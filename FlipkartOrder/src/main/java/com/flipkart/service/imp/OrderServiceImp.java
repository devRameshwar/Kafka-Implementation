package com.flipkart.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.flipkart.paylode.FlipkartOrderRequest;
import com.flipkart.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private KafkaTemplate<String, FlipkartOrderRequest> kafkaTemplate;

	private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImp.class);

	@Override
	public String createOrder(FlipkartOrderRequest request) {

		LOGGER.info("****** Request data in service class.." + request);

		return null;
	}

}
