package ar.com.pangolines.FRANBackend.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.pangolines.FRANBackend.bean.Customer;

@Service("customerServiceMockImpl")
public class CustomerServiceMockImpl implements CustomerService{

	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		Customer customer = new Customer();
		customer.setCustomerId("1");
		customer.setCustomerName("Ludwing Von Bertalanfy");
		return customer;
	}
	
	@Override
	public List<Customer> getCustomers(){
		List<Customer> listCustomers = new LinkedList<Customer>();
		
		Customer customer = new Customer();
		customer.setCustomerId("1");
		customer.setCustomerName("Ludwing Von Bertalanfy");
		listCustomers.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("2");
		customer.setCustomerName("Rogelio Aguas");
		listCustomers.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("4");
		customer.setCustomerName("El Coyote");
		listCustomers.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("5");
		customer.setCustomerName("Son Gokú");
		listCustomers.add(customer);
		return listCustomers;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customer;	
	}

	@Override
	public void deleteCustomer(String customerId) {
	}

}
