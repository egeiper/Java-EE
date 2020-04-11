package com.calisma.masterpage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	
	DB db = new DB();
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search( @RequestParam String q, Model model ) {
		//System.out.println("q : " + q);
		List<CartPro> cls = new ArrayList<CartPro>();
		try {
			String query = "select * from cart where cname like ? or csurname like ? or cphone like ? ";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, "%"+q+"%"); // '%a%'
			pre.setString(2, "%"+q+"%"); // '%a%'
			pre.setString(3, "%"+q+"%"); // '%a%'
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				int crid = rs.getInt("crid");
				String cname = rs.getString("cname");
				String csurname = rs.getString("csurname");
				String cphone = rs.getString("cphone");
				
				CartPro cr = new CartPro();
				cr.setCname(cname);
				cr.setCphone(cphone);
				cr.setCrid(crid);
				cr.setCsurname(csurname);
				cls.add(cr);
			}
		} catch (Exception e) {
			System.err.println("Sql Error : " + e);
		}
		model.addAttribute("cls", cls);
		return "search";
	}

}
