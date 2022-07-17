package com.bankop.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankop.model.AccontModel;
import com.bankop.model.Customer;
import com.bankop.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Value("${account_save}")
	private String account_summary;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer cus = customerRepository.save(customer);
		AccontModel accontModel = new AccontModel();
		accontModel.setAccount_no(customer.getAccount());
		accontModel.setAccount_type("saving");
		accontModel.setBalance((double) 50000);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:MM:ss");
		String requiredDate = df.format(new Date(System.currentTimeMillis()));
		accontModel.setLast_updated_date(requiredDate);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<AccontModel> entity = new HttpEntity<AccontModel>(accontModel, headers);
		restTemplate.exchange(account_summary, HttpMethod.POST, entity, AccontModel.class);

		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerlist = customerRepository.findAll();
		return customerlist;
	}

	@Override
	public String deleteById(String id) {
		customerRepository.deleteById(id);
		return "Customer Deleted Successfully";
	}

	@Override
	public Customer updateById(String id, Customer customer) {
		Optional<Customer> customer1 = customerRepository.findById(id);
		Customer Custome2 = customer1.get();
		Custome2.setId(customer.getId());
		Custome2.setFirstname(customer.getFirstname());
		Custome2.setLastname(customer.getLastname());
		Custome2.setMobile(customer.getMobile());
		Custome2.setEmail(customer.getEmail());
		customerRepository.save(Custome2);

		return Custome2;
	}
	
	public Customer findCustomer(String account) {
		   Optional<Customer> cus=customerRepository.getAccountById(account);
			return cus.get();
		}

}
