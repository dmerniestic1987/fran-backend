package ar.com.pangolines.FRANBackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.pangolines.FRANBackend.bean.Customer;

/**
 * Permite operar y obtenre información de los clientes
 * @author diego
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	public Customer findByGoogleUserId(String googleUserId);
	
	public List<Customer> findAllByCustomerName(String customerName);
	
	public Customer findAllByEthereumPublicAddress(String ethereumPublicAddress);

}
