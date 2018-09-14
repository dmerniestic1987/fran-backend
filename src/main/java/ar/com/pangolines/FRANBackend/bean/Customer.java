package ar.com.pangolines.FRANBackend.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Bean that represents a customer
 * @author Diego Pangolines
 *
 */
@Document(collection="customers")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    private String customerId;
	
	@Indexed(unique = true)
	private String googleUserId;
	
    private String customerName;
    
    @Indexed(unique = true)
    private String accountNumber;
    
    @Indexed(unique = true)
    private String ethereumPublicAddress;
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGoogleUserId() {
		return googleUserId;
	}
	public void setGoogleUserId(String googleUserId) {
		this.googleUserId = googleUserId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEthereumPublicAddress() {
		return ethereumPublicAddress;
	}
	public void setEthereumPublicAddress(String ethereumPublicAddress) {
		this.ethereumPublicAddress = ethereumPublicAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName 	+ ", ethereumPublicAdress=" + ethereumPublicAddress + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
}
