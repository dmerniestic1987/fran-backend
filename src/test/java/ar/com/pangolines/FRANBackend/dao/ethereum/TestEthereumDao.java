package ar.com.pangolines.FRANBackend.dao.ethereum;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

/**
 * Test Unitario de EthreumDao
 * @author diego
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEthereumDao{
	private static final Logger logger = LogManager.getLogger(TestEthereumDao.class);
	
	@Autowired
	@Qualifier("ethereumDaoImpl")
	private EthereumDaoImpl dao;
	
	@Test
	public void testGetClientVersion() throws Exception{
		logger.info("testGetClientVersion");	
		String clientVersion = dao.getWeb3ClientVersionSync();
		assertNotNull(clientVersion);
		
		logger.info(clientVersion);
	}
	
	@Test
	public void testLoadCredencial() throws Exception{
		logger.info("testLoadCredencial");
		Credentials cred = this.dao.getCredentials();
		assertNotNull(cred);
		logger.info("Dirección Púbica: " + cred.getAddress());
		
	}
	
	@Test
	public void testGetBalance() throws Exception{
		logger.info("testGetBalance");
		EthGetBalance ob = dao.getBalance("0x6e89F6fa95D517eE7a0a293D8A1d3C502bfB0701");
		assertNotNull(ob);
		
		logger.info("Result: " + ob.getResult());
		logger.info("Error: " + ob.getError());
		logger.info("id: " + ob.getId());
		
		
		logger.info("balance: " + ob.getBalance() + " WEI");
		logger.info("balance: " + Convert.fromWei(ob.getBalance().toString(), Unit.ETHER) + " ETH");
		logger.info("jsonRpc: " + ob.getJsonrpc());
		logger.info("RawResponse: " + ob.getRawResponse());
		
	}
}