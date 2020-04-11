package com.calisma.dbupdate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	DB db = new DB();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		model.addAttribute("catData", catResult());
		model.addAttribute("tableData", tableResult());
		return "home";
	}
	
	
	public List<CategoryPro> catResult() {
		List<CategoryPro> ls = new ArrayList<CategoryPro>();
			try {
				String query = "select * from categories";
				PreparedStatement pre = db.connect(query);
				ResultSet rs = pre.executeQuery();
				while(rs.next()) {
					int cid = rs.getInt("cid");
					String ctitle = rs.getString("ctitle");
					
					CategoryPro ct = new CategoryPro();
					ct.setCid(cid);
					ct.setCtitle(ctitle);
					
					ls.add(ct);
					
				}
			} catch (Exception e) {
				System.err.println("sql error : " + e);
			}
		return ls;
	}
	
	
	@RequestMapping(value = "/cartInsert", method = RequestMethod.POST)
	public String cartInsert(Carts cr) {
		try {
			String query = "INSERT INTO `cart` (`crid`, `cname`, `csurname`, `cphone`, `cid`) VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement pre = db.connect(query);
			pre.setString(1,cr.getCname());
			pre.setString(2, cr.getCsurname());
			pre.setString(3, cr.getCphone());
			pre.setInt(4, cr.getCid());
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("insert hatasý : " + e);
		}
		return "redirect:/";
	}
	
	
	// table result
	public List<TablePro> tableResult() {
		List<TablePro> ls = new ArrayList<TablePro>();
		try {
			String query = "SELECT * FROM cart c INNER JOIN categories as ct ON c.cid = ct.cid ORDER by c.crid ASC";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				TablePro pr = new TablePro();
				pr.setCname(rs.getString("cname"));
				pr.setCphone(rs.getString("cphone"));
				pr.setCrid(rs.getInt("crid"));
				pr.setCsurname(rs.getString("csurname"));
				pr.setCtitle(rs.getString("ctitle"));
				ls.add(pr);
			}
		} catch (Exception e) {
			System.err.println("tableResult error : " + e);
		}
		return ls;
	}
	
	
	
}
