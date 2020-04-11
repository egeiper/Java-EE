package com.odev.loginpageadduser;

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



import util.Util;

@Controller
public class DashboardController {
	DB db=new DB();
@RequestMapping(value="/dashboard", method=RequestMethod.GET)

public String fncDashboard( Model model, HttpServletRequest req) {
	
	model.addAttribute("catData", catResult());
	model.addAttribute("tableData", tableResult());
	return Util.control(req,"dashboard");
}

public List<CategoryPro> catResult(){
	List<CategoryPro> ls=new ArrayList<CategoryPro>();
	try {
		String query="select * from categories";
		PreparedStatement pre=db.connect(query);
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			CategoryPro pr=new CategoryPro();
			pr.setCid(rs.getInt("cid"));
			pr.setCtitle(rs.getString("ctitle"));
			ls.add(pr);
		}
	}catch(Exception e) {
		System.err.println("Cat Result Hatasý");
	}
	return ls;
}
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
			pr.setCmail(rs.getString("cmail"));
			pr.setCtext(rs.getString("ctext"));
			ls.add(pr);
		}
	} catch (Exception e) {
		System.err.println("tableResult error : " + e);
	}
	return ls;
}
@RequestMapping(value="/cartInsert", method=RequestMethod.POST)
public String fncInsert(Carts cr,HttpServletRequest req) {
	
	try {
		String query = "INSERT INTO `cart` (`crid`, `cname`, `csurname`, `cphone`, `cid`, `cmail`, `ctext`) VALUES (NULL, ?, ?, ?, ?,?,?)";
		PreparedStatement pre = db.connect(query);
		pre.setString(1,cr.getCname());
		pre.setString(2, cr.getCsurname());
		pre.setString(3, cr.getCphone());
		pre.setInt(4, cr.getCid());
		pre.setString(5, cr.getCmail());
		pre.setString(6, cr.getCtext());
		pre.executeUpdate();
	} catch (Exception e) {
		System.err.println("insert hatasý : " + e);
	}
	req.getSession().setAttribute("user_id",10);
	return "redirect:/dashboard";
}

}

