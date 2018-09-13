package ar.com.pangolines.FRANBackend.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import ar.com.pangolines.FRANBackend.bean.Wallet;
import ar.com.pangolines.FRANBackend.dao.ethereum.EthereumDaoImpl;

@Service("pangolinesWalletServiceImpl")
public class PangolinesWalletServiceImpl implements PangolinesWalletService {
	private static final Logger logger = LogManager.getLogger(PangolinesWalletServiceImpl.class);
	
	@Autowired
	@Qualifier("ethereumDaoImpl")
	private EthereumDaoImpl dao;
	
	@Override
	public Wallet findWalletByEthereumAddress(String publicAddress) {
		Wallet wallet = new Wallet();
		try {
			EthGetBalance balance = this.dao.getBalance(publicAddress);
			wallet.setEthereumAddress(publicAddress);
			wallet.setAmountInEther( Convert.fromWei(balance.getBalance().toString(), Unit.ETHER));
			wallet.setAmountInPangolines(-1L);
		} catch (IOException e) {
			logger.error("Error al obtener el la wallet", e);
		}
		return wallet;
	}

}
