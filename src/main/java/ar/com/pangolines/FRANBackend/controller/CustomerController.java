package ar.com.pangolines.FRANBackend.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.pangolines.FRANBackend.bean.Customer;
import ar.com.pangolines.FRANBackend.service.CustomerService;

/**
 * Controlador de Customers
 * @author dmernies
 *
 */
@RestController
@RequestMapping(value = "/")
public class CustomerController {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
    @Autowired
    @Qualifier("customerServiceMockImpl")
    private CustomerService customerService;
 
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
    	logger.info("CustomerController GET /customers");
    	return customerService.getCustomerDetails();
    }
    
    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
    	logger.info("CustomerController GET /customers/" + customerId);
        return customerService.getCustomerDetail(customerId);
    }
    
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
    	logger.info("CustomerController POST /customers");
    	customerService.createCustomer(customer);
    	return customer;
    }
    
    @PutMapping("/customers/{customerId}")
    public void updateCustomer(@RequestBody Customer customer) {
    	logger.info("CustomerController PUT /customers");
    }
}
