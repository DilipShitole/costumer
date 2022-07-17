package com.bankop.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {
	@MongoId
	private String id;
	private String firstname;
	private String lastname;
	private String mobile;
	private String email;
	private String account;
	

}
