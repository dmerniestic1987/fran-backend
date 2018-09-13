package ar.com.pangolines.FRANBackend.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wallet implements Serializable{
	private static final long serialVersionUID = -1779497736481428519L;
	private String ethereumAddress;
	private BigDecimal amountInEther;
	private Long amountInPangolines;
	
	public Wallet() {
		super();
		ethereumAddress = ""; 
		amountInEther = new BigDecimal(-1);
		amountInPangolines = -1L;
	}
	
	@JsonProperty("ethereumAddress")
	public String getEthereumAddress() {
		return ethereumAddress;
	}
	public void setEthereumAddress(String ethereumAddress) {
		this.ethereumAddress = ethereumAddress;
	}
	
	@JsonProperty("amountInEther")
	public BigDecimal getAmountInEther() {
		return amountInEther;
	}
	public void setAmountInEther(BigDecimal amountInEther) {
		this.amountInEther = amountInEther;
	}
	
	@JsonProperty("amountInPangolines")
	public Long getAmountInPangolines() {
		return amountInPangolines;
	}
	public void setAmountInPangolines(Long amountInPangolines) {
		this.amountInPangolines = amountInPangolines;
	}
	@Override
	public String toString() {
		return "Wallet [ethereumAddress=" + ethereumAddress + ", amountInEther=" + amountInEther
				+ ", amountInPangolines=" + amountInPangolines + "]";
	}

}
