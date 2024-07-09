package com.flipkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlipkartOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartOrderApplication.class, args);
		
		System.out.println("kafka Application is started...");
	}

}
