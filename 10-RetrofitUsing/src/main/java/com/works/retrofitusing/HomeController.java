package com.works.retrofitusing;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import restUsing.API;
import restUsing.Bilgiler;
import restUsing.JsonPro;
import restUsing.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( final Model model) throws IOException {
		
		Service servis = API.getClient().create(Service.class);
		Call<JsonPro> dt = servis.allUser();
		List<Bilgiler> ls = dt.execute().body().getProducts().get(0).getBilgiler();
		model.addAttribute("ls", ls);
		
		/*
		dt.enqueue(new Callback<JsonPro>() {

			@Override
			public void onResponse(Call<JsonPro> call, Response<JsonPro> response) {
				JsonPro pr = response.body();
				// String name = pr.getProducts().get(0).getBilgiler().get(0).getProductName();
				// System.out.println("Name : " + name);
				List<Bilgiler> ls = pr.getProducts().get(0).getBilgiler();
				model.addAttribute("ls", ls);
				//for (Bilgiler item : ls) {
					//System.out.println(item.getProductName());
				//}
			}

			@Override
			public void onFailure(Call<JsonPro> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		
		return "home";
	}
	
}
