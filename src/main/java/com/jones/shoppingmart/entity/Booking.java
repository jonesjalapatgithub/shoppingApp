package com.jones.shoppingmart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Entity // This tells Hibernate to make a table out of this class
@Data
@Builder
public class Booking {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
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
