package ar.com.pangolines.FRANBackend.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapeoRubros implements Serializable {
	private static final long serialVersionUID = 6807601978654495507L;
	
	private List<Rubro> values;

	public MapeoRubros() {
		super();
		values = new ArrayList<Rubro>();
	}
	
	public List<Rubro> getValues() {
		return values;
	}

	public void setValues(List<Rubro> values) {
		this.values = values;
	}

	public void add(Rubro rubro) {
		this.values.add(rubro);
	}
	
	@Override
	public String toString() {
		return "MapeoRubros [values=" + values + "]";
	}
}
