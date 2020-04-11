package com.calisma.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"userRest", "com.calisma.restapi" }) // bu paket altındaki sınıfları Spring olarak çalıştır.
public class Application {

	public static void main(String[] args) {
		//System.out.println("merhaba");
		SpringApplication.run(Application.class, args);
	}

}
