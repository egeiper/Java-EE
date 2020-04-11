package com.propertyusing.calisma;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import properties.Cars;


@Controller
public class HomeController {
	int count=0;
	List<Cars> cars=new ArrayList<Cars>();
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String fncHome(Model model) {
		model.addAttribute("data", "cars");
		return "home";
	}
	
	@RequestMapping(value="/carInsert", method=RequestMethod.POST)
	public String fncInsert(Cars crs) {
		count++;
		crs.setId(count);
		cars.add(crs);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String fncDelete(@PathVariable int id) {
		cars.remove(IndexSearch(id));
		return "redirect:/";
	}
	public int IndexSearch(int id) {
		int s=0;
		
		for(Cars item: cars) {
			if(item.getId()==id)
				break;
			s++;
			
		}
		return s;
	}
}
