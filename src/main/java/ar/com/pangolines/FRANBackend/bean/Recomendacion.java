package ar.com.pangolines.FRANBackend.bean;

import java.io.Serializable;

public class Recomendacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private String gogoleUserId;
	private String accountNumber;
	private String rubro1FrancesGo;
	private String rubro2FrancesGO;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRubro1FrancesGo() {
		return rubro1FrancesGo;
	}
	public void setRubro1FrancesGo(String rubro1FrancesGo) {
		this.rubro1FrancesGo = rubro1FrancesGo;
	}
	public String getRubro2FrancesGO() {
		return rubro2FrancesGO;
	}
	public void setRubro2FrancesGO(String rubro2FrancesGO) {
		this.rubro2FrancesGO = rubro2FrancesGO;
	}
	public String getGogoleUserId() {
		return gogoleUserId;
	}
	public void setGogoleUserId(String gogoleUserId) {
		this.gogoleUserId = gogoleUserId;
	}
	
	
}
