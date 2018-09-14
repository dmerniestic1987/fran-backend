package ar.com.pangolines.FRANBackend.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.pangolines.FRANBackend.bean.Customer;
import ar.com.pangolines.FRANBackend.repository.CustomerRepository;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);	
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		logger.info("getCustomerByCustomerId(" + customerId + ")");
		Optional<Customer> optCustomer = this.customerRepo.findById(customerId);
		if (optCustomer != null)
			return optCustomer.get();
		
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		logger.info("getCustomers");
		return this.customerRepo.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		logger.info("createCustomer");
		return this.customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(String customerId) {
		logger.info("deleteCustomer");
		this.customerRepo.deleteById(customerId);
	}

}
