package com.victommasi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victommasi.model.Customer;
import com.victommasi.model.Status;
import com.victommasi.repository.CustomerRepository;
import com.victommasi.service.CustomerService;

@RestController
//@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer",method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	//@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer, BindingResult result) {
		if(result.hasErrors()){
			//return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		customerService.saveCustomer(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCustomer(@PathVariable ("id") Integer id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") Integer id){
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable ("id") Integer id, @RequestBody Customer customer){
		customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
    @RequestMapping("/statusJson")
	public Status[] getStatusJson(Customer customer) {
		return Status.values();
	}
}
	