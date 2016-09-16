package com.victommasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victommasi.model.Customer;
import com.victommasi.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	//creates and updates
	public void saveCustomer(Customer customer){
		customerRepository.save(customer);
	}

	public void deleteCustomer(Integer id) {
		customerRepository.delete(id);
	}

	public Customer getCustomerById(Integer id) {
		Customer customer = customerRepository.findOne(id);
		return customer;
	}
}
