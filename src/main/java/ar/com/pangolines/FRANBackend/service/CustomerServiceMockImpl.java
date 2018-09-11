package ar.com.pangolines.FRANBackend.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.pangolines.FRANBackend.bean.Customer;

@Service("customerServiceMockImpl")
public class CustomerServiceMockImpl implements CustomerService{

	@Override
	public Customer getCustomerDetail(String customerId) {
		Customer customer = new Customer();
		customer.setCustomerId("1");
		customer.setCompanyName("BBVA Francés");
		customer.setCustomerName("Ludwing Von Bertalanfy");
		return customer;
	}
	
	@Override
	public List<Customer> getCustomerDetails(){
		List<Customer> listCustomers = new LinkedList<Customer>();
		
		Customer customer = new Customer();
		customer.setCustomerId("1");
		customer.setCompanyName("BBVA Francés");
		customer.setCustomerName("Ludwing Von Bertalanfy");
		listCustomers.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("2");
		customer.setCompanyName("Santander Rio");
		customer.setCustomerName("Rogelio Aguas");
		listCustomers.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("4");
		customer.setCompanyName("ACME Corporation");
		customer.setCustomerName("El Coyote");
		listCustomers.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("5");
		customer.setCompanyName("BBVA Francés");
		customer.setCustomerName("Son Gokú");
		listCustomers.add(customer);
		return listCustomers;
	}

}
