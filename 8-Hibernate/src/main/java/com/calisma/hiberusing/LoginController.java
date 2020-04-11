package com.calisma.hiberusing;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Users;
import util.Password;

@Controller
public class LoginController {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		
		// çerez kontrol saðlanýyor
		if (req.getCookies() != null) {
			Cookie[] cookies = req.getCookies();
			for (Cookie item : cookies) {
				if(item.getName().equals("user_remember")) {
					String uid =  Password.sifreCoz(item.getValue(), 4) ;
					System.out.println("Cookie Uid : " + uid);
					// session içersine bu id yi atýp kiþiyi yönlendir.
					return "redirect:/";
				}
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost( Users us, @RequestParam(defaultValue = "off") String remember_me, HttpServletResponse res) {
		
		System.out.println("remember_me : " + remember_me);
		
		Session sesi = sf.openSession();
		try {
			Users lus = (Users) sesi.createQuery("from Users where umail = ? and upassword = ? ")
					.setParameter(0, us.getUmail())
					.setParameter(1, us.getUpassword())
					.list()
					.get(0);
			System.out.println("Name : " + lus.getUname());
			// kullnýcý var ve giriþ baþarýlý
			if(remember_me.equals("on")) {
				Cookie cookie = new Cookie("user_remember", Password.sifrele(""+lus.getUid(), 4) );
				cookie.setMaxAge(60 * 60 * 24);
				res.addCookie(cookie);
			}
			
		} catch (Exception e) {
			System.err.println("Böyle bir kullanýcý yok !");
		}
		return "redirect:/";
	}
	
	
	
	// exit
	// cookie delete
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit( HttpServletResponse res ) {
		
		Cookie cookie = new Cookie("user_remember", "");
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		
		
		return "redirect:/login";
	}
	
	

}
