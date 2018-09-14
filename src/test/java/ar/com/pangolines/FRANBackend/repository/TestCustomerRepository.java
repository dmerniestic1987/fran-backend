package ar.com.pangolines.FRANBackend.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.pangolines.FRANBackend.bean.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomerRepository {
	private static final Logger logger = LogManager.getLogger(TestCustomerRepository.class);
	
	@Autowired
	private CustomerRepository repo;
	
	@Test
	public void saveCustomer() throws Exception{
		logger.info("save customer");
		Customer cu = new Customer();
		cu.setCustomerId("00001000000001010101");
		cu.setCustomerName("Gokú");
		cu.setEthereumPublicAddress("0x6e89F6fa95D517eE7a0a293D8A1d55555bfB0701");
		
		cu = this.repo.save(cu);
		assertNotNull(cu);
		
		logger.info(cu.toString());
	}
	
	@Test
	public void getAllCustomers() throws Exception{
		logger.info("save getAllCustomers");
		List<Customer> li = this.repo.findAll();
		
		assertNotNull(li);
		assertFalse(li.size() < 0);
		
		logger.info(li.toString());
	}
	
	@Test
	public void findByCustomerId() throws Exception{
		logger.info("save getAllCustomers");
		Optional<Customer> optCustomer = this.repo.findById("00001000000001010101");
		assertNotNull(optCustomer);
		Customer cu = optCustomer.get();;
		assertNotNull(cu);
		logger.info(cu.toString());
	}
}
