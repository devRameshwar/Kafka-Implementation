package com.flipkart.service;

import java.util.concurrent.ExecutionException;

import com.flipkart.paylode.FlipkartOrderRequest;

public interface OrderService {

	String createOrder(FlipkartOrderRequest request) throws InterruptedException, ExecutionException;

}
