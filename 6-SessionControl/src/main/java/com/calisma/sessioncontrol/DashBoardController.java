package com.calisma.sessioncontrol;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.Util;

@Controller
public class DashBoardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, HttpServletRequest req) {
		
		return Util.control(req, "dashboard");
	}

	
	
}
