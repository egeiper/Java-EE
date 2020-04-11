package com.calisma.masterpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinkController {

	@RequestMapping(value = "/link", method = RequestMethod.GET)
	public String link() {
		IncluderController.page = "link";
		return "link";
	}
	
}
