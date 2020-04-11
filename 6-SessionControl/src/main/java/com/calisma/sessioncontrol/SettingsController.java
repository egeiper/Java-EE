package com.calisma.sessioncontrol;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.Util;

@Controller
public class SettingsController {

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings(Locale locale, Model model, HttpServletRequest req) {
		return Util.control(req, "settings");
	}
	
}
