package com.flipkart.paylode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlipkartOrderRequest {
	
	private String productId;
	
	private String productName;
	
	private Integer quantity;
	
	private Double price;

}
