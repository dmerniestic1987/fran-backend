package ar.com.pangolines.FRANBackend.service;

import ar.com.pangolines.FRANBackend.bean.Wallet;

/**
 * Servicio de la wallet
 * @author diego
 *
 */
public interface PangolinesWalletService {
	
	/**
	 * Obtiene una wallet ethereum.
	 * @param publicAddress ejemplo: 0x6e89F6fa95D517eE7a0a293D8A1d3C502bfB0701
	 * @return wallet si la encuetra, false de lo contrario
	 */
	public Wallet findWalletByEthereumAddress(String publicAddress);
}
