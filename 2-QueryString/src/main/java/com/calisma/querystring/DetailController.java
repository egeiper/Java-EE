package com.calisma.querystring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailController {
	
	@RequestMapping(value = "/detail/{param}", method = RequestMethod.GET)
	public String fncDetail( @PathVariable String param, Model model ) {
		System.out.println("Param " + param);
		model.addAttribute("title", param);
		return "detail";
	}

}
