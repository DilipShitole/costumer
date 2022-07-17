package com.bankop.service;

import java.util.List;

import com.bankop.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomer();

	String deleteById(String id);

	Customer updateById(String id, Customer customer);

}
