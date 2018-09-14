package ar.com.pangolines.FRANBackend.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import ar.com.pangolines.FRANBackend.bean.Rubro;
import ar.com.pangolines.FRANBackend.dao.dataAnalytics.MapeosRubrosDaoImpl;

@Service("sugerenciaPangolines")
public class SugerenciaPangolines {
	private static final Logger logger = LogManager.getLogger(SugerenciaPangolines.class);
	
	@Autowired
	@Qualifier("mapeosRubrosDaoImpl")
	private MapeosRubrosDaoImpl dao;
	
	/**
	 * Obtiene el rubro dado uno de bigData
	 * @param rubroBigData
	 * @return rubro
	 */
	public Rubro findByRubroBigData(String rubroBigData) {
		Rubro rubro = null;
		try {
			MapeoRubros mapeo = this.dao.getMapeoRubros();
			for (Rubro rubo : mapeo.getValues()) {
				if (rubo.getRubroBigData().equals(rubroBigData)) {
					rubro = rubo;
					break;
				}
			}
		} catch (IOException e) {
			logger.error("Error al leer archivo de datos", e.getMessage());
			rubro = null;
		}
		
		if (rubro == null) {
			rubro = new Rubro();
			rubro.setName("Otros Comercios y Servicios");
			rubro.setRubroFrancesGo("3435");
			rubro.setRubroBigData("RUBRO 001");			
		}
		return rubro;
	}
}
