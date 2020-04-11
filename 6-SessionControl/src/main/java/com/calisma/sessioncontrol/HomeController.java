package com.calisma.sessioncontrol;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String mail, @RequestParam String password, HttpServletRequest req) {
		if(mail.equals("ali@ali.com") && password.equals("12345")) 
		{
			// session create
			req.getSession().setAttribute("user_id", 10);
			return "redirect:/dashboard";
		}
		return "redirect:/";
	}

	
	// exit call
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(HttpServletRequest req) {
		req.getSession().removeAttribute("user_id");
		req.getSession().invalidate(); // tüm sessionlarý sil
		return "redirect:/";
	}
	
	
	
}
