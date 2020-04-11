package com.calisma.dbconnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.DB;
import util.UserPro;


@Controller
public class HomeController {
	
	DB db = new DB();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		model.addAttribute("data", dataResult());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insert() {
		
		try {
			String query = "INSERT INTO `users` "
					+ "(`uid`, `uname`, `usurname`, `umail`, `upassword`)"
					+ " VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, "Leyla");
			pre.setString(2, "Bilki");
			pre.setString(3, "leyla@mail.com");
			pre.setString(4, "123456");
			pre.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("insert error : " + e);
		}
		
		return "redirect:/";
	}
	
	
	public List<UserPro> dataResult() {
		List<UserPro> ls = new ArrayList<UserPro>();
		try {
			String query = "SELECT * FROM `users`";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) { // veritabanýndaki her bir adýmda datalarý getir.
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String usurname = rs.getString("usurname");
				String umail = rs.getString("umail");
				String upassword = rs.getString("upassword");
				
				UserPro us = new UserPro();
				us.setUid(uid);
				us.setUmail(umail);
				us.setUname(uname);
				us.setUpassword(upassword);
				us.setUsurname(usurname);
				
				ls.add(us);
				
			}
		} catch (Exception e) {
			System.err.println("select error: " + e);
		}
		return ls;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete() {
		try {
			String query = "DELETE FROM `users` WHERE `users`.`uid` = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, 2); // 2 sabit olarak uid yi iþaret eder.
			int statu = pre.executeUpdate();
			if (statu > 0) {
				System.out.println("Silme iþlemi baþarýlý");
			}else {
				System.out.println("Silme hatasý");
			}
		} catch (Exception e) {
			System.err.println("delete error : " + e);
		}
		return "redirect:/";
	}
	
	
	
}
