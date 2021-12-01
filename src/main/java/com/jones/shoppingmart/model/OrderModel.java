package com.jones.shoppingmart.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderModel {
	
	  private Integer orderId;
	  private String productName;
	  private String productId;
	  private Integer tuid;
	  private Integer tpid;
	  private String country;
	  private String pinCode;
	  private String address;
	  private Integer points;

}
