package ar.com.pangolines.FRANBackend.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rubro implements Serializable {
	private static final long serialVersionUID = 6807601978654495507L;
	private String rubroFrancesGo;
	private String name;
	private String rubroBigData;
	
	@JsonProperty("rubroFrancesGo")
	public String getRubroFrancesGo() {
		return rubroFrancesGo;
	}
	public void setRubroFrancesGo(String rubroFrancesGo) {
		this.rubroFrancesGo = rubroFrancesGo;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("rubroBigData")
	public String getRubroBigData() {
		return rubroBigData;
	}
	public void setRubroBigData(String rubroBigData) {
		this.rubroBigData = rubroBigData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rubroBigData == null) ? 0 : rubroBigData.hashCode());
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
		Rubro other = (Rubro) obj;
		if (rubroBigData == null) {
			if (other.rubroBigData != null)
				return false;
		} else if (!rubroBigData.equals(other.rubroBigData))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Rubro [rubroFrancesGo=" + rubroFrancesGo + ", name=" + name + ", rubroBigData=" + rubroBigData + "]";
	}

}