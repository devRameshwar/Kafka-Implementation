package com.flipkart.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.paylode.FlipkartOrderRequest;
import com.flipkart.service.OrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	private final Logger LOGGER =LoggerFactory.getLogger(OrderController.class);

	@GetMapping()
	public String getwish() {
		LOGGER.info("****** getWish method called...");
		return "Happy path...";
	}
	
	@PostMapping()
	public ResponseEntity<Object> createOrder(@RequestBody FlipkartOrderRequest request) throws InterruptedException, ExecutionException{
		LOGGER.info("****** Request Data in Controller class: "+request);
		return ResponseEntity.ok(service.createOrder(request));
	}

}
