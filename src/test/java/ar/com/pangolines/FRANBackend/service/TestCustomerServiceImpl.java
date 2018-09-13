package ar.com.pangolines.FRANBackend.service;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.pangolines.FRANBackend.bean.Wallet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomerServiceImpl {
	private static final Logger logger = LogManager.getLogger(TestCustomerServiceImpl.class);
	
	@Autowired
	@Qualifier("pangolinesWalletServiceImpl")
	private PangolinesWalletService walletService;
	
	@Test
	public void testBalacne() throws Exception{
		Wallet wallet = this.walletService.findWalletByEthereumAddress("0x6e89F6fa95D517eE7a0a293D8A1d3C502bfB0701");
		assertNotNull(wallet);
		
		logger.info(wallet.toString());
	}
}
