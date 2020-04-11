package com.odev.loginpageadduser;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class DeleteController {
	DB db=new DB();
	@RequestMapping(value = "/delete{cartid}", method = RequestMethod.POST)
	public String delete(@PathVariable int cartid, HttpServletRequest req) {
		try {
			String query = "DELETE FROM `cart` WHERE `cart`.`cartid` = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1,param);
			int statu = pre.executeUpdate();
			if (statu > 0) {
				System.out.println("Silme iþlemi baþarýlý");
			}else {
				System.out.println("Silme hatasý");
			}
		} catch (Exception e) {
			System.err.println("delete error : " + e);
		}
		return "redirect:/order";
	}
}
