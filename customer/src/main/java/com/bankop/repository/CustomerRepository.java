package com.bankop.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankop.model.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	    @Query("{account :?0}")                                             
	    Optional<Customer> getAccountById(String id);
	}

