package com.odev.loginpageadduser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.Locale;
/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	DB db=new DB();
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fncHome(Model model) {
		
		
		return "home";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String umail, @RequestParam String upassword, HttpServletRequest req) {
	
		Users us = new Users();
		
		try {
			
		String query= "Select * from  `users`";
		PreparedStatement pr = db.connect(query);
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			us.setUid(rs.getInt("uid"));
			us.setUmail(rs.getString("umail"));
			us.setUpassword(rs.getString("upassword"));
			
		}
			
			System.out.println("Giris basarili !!");
		} catch (Exception e) {
			System.err.println("Giris Hatas� : " + e);
		}
		
		
		if(umail.equals(us.getUmail()) && upassword.equals(us.getUpassword())) 
		{
			
			
			req.getSession().setAttribute("user_id", 10);
			return "redirect:/dashboard";
			
			
			
		}
			
		return "redirect:/";
	}
	
	@RequestMapping(value="/exit", method=RequestMethod.GET)
		public String fncExit(HttpServletRequest req) {
			req.getSession().removeAttribute("user_id");
			return "redirect:/";
		}
	}


