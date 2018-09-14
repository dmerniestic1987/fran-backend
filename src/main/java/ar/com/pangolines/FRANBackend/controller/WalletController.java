package ar.com.pangolines.FRANBackend.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import ar.com.pangolines.FRANBackend.bean.Wallet;
import ar.com.pangolines.FRANBackend.service.PangolinesWalletService;

@RestController
public class WalletController implements IWalletController {
	private static final Logger logger = LogManager.getLogger(WalletController.class);
	
	@Autowired
	@Qualifier("pangolinesWalletServiceImpl")
	private PangolinesWalletService walletService;
	
	@Override
	public Wallet getWalletByPublicAddressEthereum(String publicAddress) {
		logger.info("getWalletByPublicAddressEthereum=(" + publicAddress + ")");
		return this.walletService.findWalletByEthereumAddress(publicAddress);
	}
}
