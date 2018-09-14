package ar.com.pangolines.FRANBackend.dao.ethereum;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import ar.com.pangolines.FRANBackend.contract.PangolinesToken;

@Repository("ethereumDaoImpl")
public class EthereumDaoImpl {
	private static final Logger logger = LogManager.getLogger(EthereumDaoImpl.class);
	
	@Value("${ETHEREUM_NODE_ENDPOINT}")
	private String ETHEREUM_NODE_ENDPOINT;
	
	@Value("${ETHEREUM_NODE_ENDPOINT}")
	private String INFURA_API_KEY; 
	
	@Value("${ETHEREUM_NODE_ENDPOINT}")
	private String INFURA_APISECRET; 
	
	@Value("${ETHEREUM_NODE_ENDPOINT}")
	private String INFURA_ENDPOINT; 
	
	@Value("${PANGOLINES_TOKEN_SMART_CONTRACT}")
	private String PANGOLINES_TOKEN_SMART_CONTRACT;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	public EthereumDaoImpl() {
		super();
	}
	
	/**
	 * Obtiene la versión del cliente Web3JS
	 * @return
	 * @throws IOException
	 */
	public String getWeb3ClientVersionSync() throws IOException{
		logger.info("EthereumDao.getWeb3ClientVersion()");
		//Creamos el cliente
		Web3j web3 = Web3j.build(new HttpService(ETHEREUM_NODE_ENDPOINT));
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		return clientVersion;
	}
	
	
	/**
	 * Obtiene el balance de una clave publica
	 * @param publicAddress EthGetBalance
	 * @return ethGetBalance
	 * @throws Exception
	 */
	public EthGetBalance getBalance(String publicAddress) throws IOException{
		logger.info("EthereumDao.getBalance("+ publicAddress + "");
		Web3j web3 = Web3j.build(new HttpService(ETHEREUM_NODE_ENDPOINT));
		
		EthGetBalance ethGetBalance = web3
				  .ethGetBalance(publicAddress, DefaultBlockParameterName.LATEST)
				  .send();
		return ethGetBalance;
	}
	
	/**
	 * Carga las credenciales desde el archivo *.json
	 * @return cred
	 * @throws IOException
	 * @throws CipherException
	 */
	public Credentials getCredentials() throws IOException, CipherException {
		File file = resourceLoader
					.getResource("classpath:UTC--2018-08-24T01-32-50.967000000Z--0b2b8f8365bc45b88057fcab1629fef25c932d73.json")
					.getFile();
		Credentials cred = WalletUtils.loadCredentials("pangolines2018", file);
		return cred;
	}
	
	/**
	 * obtiene el balance en Pangolines
	 * @param publicAddress
	 * @throws Exception
	 */
    public BigInteger balanceInPangolines(String publicAddress) throws Exception {
    	logger.info("EthereumDao.balanceInPangolines()");
    	Web3j web3j = Web3j.build(new HttpService(ETHEREUM_NODE_ENDPOINT));
        Credentials credentials = getCredentials();
        PangolinesToken contract = PangolinesToken.load(PANGOLINES_TOKEN_SMART_CONTRACT, web3j, credentials,  ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
        return contract.balanceOf(publicAddress).send();
    }	
}
