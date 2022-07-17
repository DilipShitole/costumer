package com.bankop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankop.model.Customer;
import com.bankop.service.CustomerServiceImpl;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/{account}")
	public ResponseEntity<Customer> findCustomer(@PathVariable String account) {
		Customer customer = customerServiceImpl.findCustomer(account);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	

	@GetMapping("/getcustomer")
	private ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customerlist = customerServiceImpl.getAllCustomer();
		return new ResponseEntity<List<Customer>>(customerlist, HttpStatus.OK);

	}

	@PostMapping("/save")
	private ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer customer1 = customerServiceImpl.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteById(@PathVariable String id) {
		String message = customerServiceImpl.deleteById(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	private ResponseEntity<Customer> updateById(@PathVariable String id, @RequestBody Customer customer) {
		Customer Customer2 = customerServiceImpl.updateById(id, customer);
		return new ResponseEntity<Customer>(Customer2, HttpStatus.OK);
	}

}
