package com.flipkart.service.imp;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.flipkart.constant.ApplicationConstant;
import com.flipkart.paylode.FlipkartOrderRequest;
import com.flipkart.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private KafkaTemplate<String, FlipkartOrderRequest> kafkaTemplate;

	private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImp.class);

	@Override
	public String createOrder(FlipkartOrderRequest request) throws InterruptedException, ExecutionException {

		LOGGER.info("****** Request data in service class.." + request);
		String orderCreateResponse = UUID.randomUUID().toString();

		CompletableFuture<SendResult<String, FlipkartOrderRequest>> future = kafkaTemplate
				.send(ApplicationConstant.TOPICS_NAME, orderCreateResponse, request);

		CompletableFuture<SendResult<String, FlipkartOrderRequest>> whenComplete = future
				.whenComplete((rerult, exception) -> {

					LOGGER.info("******Getting Successfull response: " + request.getProductId());
					if (exception != null) {
						LOGGER.info("******Getting exception massege: " + exception.getMessage());
					}
				});

		SendResult<String, FlipkartOrderRequest> result = whenComplete.get();

		ProducerRecord<String, FlipkartOrderRequest> producerRecord = result.getProducerRecord();

		LOGGER.info("****** Product responce created: " + producerRecord);

		return producerRecord.key();
	}

}
