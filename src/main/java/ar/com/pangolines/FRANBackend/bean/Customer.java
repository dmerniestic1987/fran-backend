package ar.com.pangolines.FRANBackend.bean;

import java.io.Serializable;

/**
 * Bean that represents a customer
 * @author Diego Pangolines
 *
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
    private String customerId;
    private String customerName;
    private String companyName;
    private String ethereumPublicAdress;
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEthereumPublicAdress() {
		return ethereumPublicAdress;
	}
	public void setEthereumPublicAdress(String ethereumPublicAdress) {
		this.ethereumPublicAdress = ethereumPublicAdress;
	}
	
}
