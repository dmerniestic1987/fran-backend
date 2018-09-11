package ar.com.pangolines.FRANBackend.service;

import java.util.List;

import ar.com.pangolines.FRANBackend.bean.Customer;

/**
 * Defines the busines logic of Customer	
 * @author dmernies
 *
 */
public interface CustomerService {	
	
	/**
	 * Get the detail of a costumer
	 * @param customerId
	 * @return customer if is found, null otherwise
	 */
	public Customer getCustomerDetail(String customerId);	
	
	/**
	 * Get the list the customers
	 * @return listCustomer
	 */
	public List<Customer> getCustomerDetails();
}
