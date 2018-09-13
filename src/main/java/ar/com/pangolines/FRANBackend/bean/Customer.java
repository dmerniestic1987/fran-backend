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
    private String customerName;
    private String companyName;
    
    @Indexed(unique = true)
    private String ethereumPublicAddress;
    
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
		return ethereumPublicAddress;
	}
	public void setEthereumPublicAdress(String ethereumPublicAdress) {
		this.ethereumPublicAddress = ethereumPublicAdress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", companyName=" + companyName
				+ ", ethereumPublicAdress=" + ethereumPublicAddress + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((ethereumPublicAddress == null) ? 0 : ethereumPublicAddress.hashCode());
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
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (ethereumPublicAddress == null) {
			if (other.ethereumPublicAddress != null)
				return false;
		} else if (!ethereumPublicAddress.equals(other.ethereumPublicAddress))
			return false;
		return true;
	}
	
}
