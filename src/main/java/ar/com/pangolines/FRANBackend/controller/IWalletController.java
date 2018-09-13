package ar.com.pangolines.FRANBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ar.com.pangolines.FRANBackend.bean.Wallet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "wallets", description = "API para obtener información de los wallet de la blockhein Ethereum")
public interface IWalletController {
	
	@ApiOperation(value = "Busca una wallet dada una clave publica.", nickname = "getWalletByPublicAddressEthereum", response = Wallet.class)
	@GetMapping("/wallet/{publicAddress}")
	public Wallet getWalletByPublicAddressEthereum(@ApiParam(value = "Dirección pulica de la wallet ethereum" ,required=true) 	@PathVariable String publicAddress);
}
