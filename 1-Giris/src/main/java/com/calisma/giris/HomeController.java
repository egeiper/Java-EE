package com.calisma.giris;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model, Random rnd ) {
		String dt = LocalDate.now().toString();
		model.addAttribute("serverTime", "gönderilen data" );
		model.addAttribute("takim", "Fenerbahçe");
		model.addAttribute("dt", dt + rnd.nextFloat());
		return "home";
	}
	
	
}






