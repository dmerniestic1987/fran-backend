package ar.com.pangolines.FRANBackend.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.pangolines.FRANBackend.bean.Customer;
import ar.com.pangolines.FRANBackend.service.CustomerService;

/**
 * Controlador de Customers
 * @author dmernies
 *
 */
@RestController
public class CustomerController implements ICustomerController {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
    @Autowired
    @Qualifier("customerServiceMockImpl")
    private CustomerService customerService;
 
    @Override
    public List<Customer> getCustomers(){
    	logger.info("CustomerController GET /customers");
    	return customerService.getCustomerDetails();
    }
    
    @Override
    public Customer getCustomerById(@PathVariable String customerId) {
    	logger.info("CustomerController GET /customers/" + customerId);
        return customerService.getCustomerDetail(customerId);
    }
    
    @Override
    public Customer createCustomer(@RequestBody Customer customer) {
    	logger.info("CustomerController POST /customers");
    	customerService.createCustomer(customer);
    	return customer;
    }
    
    @Override
    public void updateCustomer(@RequestBody Customer customer) {
    	logger.info("CustomerController PUT /customers");
    }

	@Override
	public void deleteCustomer(String customerId) {
		logger.info("CustomerController DELTE /customers/" + customerId);		
	}
}
