package com.calisma.dbupdate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdatePageController {
	
	DB db = new DB();

	@RequestMapping(value = "/updatePage/{crid}", method = RequestMethod.GET)
	public String updatePage( @PathVariable int crid, Model model, HttpServletRequest req ) {
		req.getSession().setAttribute("crid", crid);
		model.addAttribute("tablePro", tableResult(crid));
		model.addAttribute("catData", new HomeController().catResult());
		System.out.println("crid : " + crid);
		return "update";
	}
	
	
	public TablePro tableResult(int crid) {
		
		try {
			String query = "SELECT * FROM cart c INNER JOIN categories as ct ON c.cid = ct.cid where c.crid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, crid);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				TablePro pr = new TablePro();
				pr.setCname(rs.getString("cname"));
				pr.setCphone(rs.getString("cphone"));
				pr.setCrid(rs.getInt("crid"));
				pr.setCsurname(rs.getString("csurname"));
				pr.setCtitle(rs.getString("ctitle"));
				pr.setCid(rs.getInt("cid"));
				return pr;
			}
		} catch (Exception e) {
			System.err.println("tableResult error : " + e);
		}
		return null;
	}
	
	@RequestMapping(value = "/cartUpdate", method = RequestMethod.POST)
	public String cartUpdate( TablePro tbl, HttpServletRequest req ) {
		int crid = Integer.valueOf(""+req.getSession().getAttribute("crid"));
		
		try {
			String query = "update cart set cname = ?, csurname = ?, cphone = ?, cid = ? where crid = ? ";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, tbl.getCname());
			pre.setString(2, tbl.getCsurname());
			pre.setString(3, tbl.getCphone());
			pre.setInt(4, tbl.getCid());
			pre.setInt(5, crid);
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("update error : " + e);
		}
		
		return "redirect:/";
	}
	
	
	
}
