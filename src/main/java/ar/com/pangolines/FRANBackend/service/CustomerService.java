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
	public Customer getCustomerByCustomerId(String customerId);	
	
	/**
	 * Get the list the customers
	 * @return listCustomer
	 */
	public List<Customer> getCustomers();

	/**
	 * Creates a new customer
	 * @param customer
	 */
	public Customer createCustomer(Customer customer);
	
	/**
	 * Deletes a cusomter
	 * @param customerId
	 */
	public void deleteCustomer(String customerId);
	
	/**
	 * Obtriene un cliente dado un gogole id
	 * @param googleId
	 * @return customer
	 */
	public Customer getCustomerByGoogleId(String googleId);
	
}
