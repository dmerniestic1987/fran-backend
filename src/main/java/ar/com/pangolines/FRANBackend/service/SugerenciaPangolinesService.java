package ar.com.pangolines.FRANBackend.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import ar.com.pangolines.FRANBackend.bean.Recomendacion;
import ar.com.pangolines.FRANBackend.bean.Rubro;
import ar.com.pangolines.FRANBackend.dao.dataAnalytics.MapeosRubrosDaoImpl;

@Service("sugerenciaPangolinesService")
public class SugerenciaPangolinesService {
	private static final Logger logger = LogManager.getLogger(SugerenciaPangolinesService.class);
	
	@Autowired
	@Qualifier("mapeosRubrosDaoImpl")
	private MapeosRubrosDaoImpl dao;
	
	/**
	 * Obtiene una referencia en base l número de cuenta
	 * @param accountNumber
	 * @return
	 */
	public Recomendacion findByAccountNumber(String accountNumber) {
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setAccountNumber(accountNumber);
		recomendacion.setRubro1FrancesGo("3435");
		recomendacion.setRubro2FrancesGO("3517");
		return recomendacion;
	}
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
	
	/**
	 * Botiene tiendos lso rubros
	 * @return
	 */
	public MapeoRubros getMapeoAllRubros() {
		MapeoRubros mapeo = null;
		try {
			mapeo = this.dao.getMapeoRubros();
		} catch (IOException e) {
			logger.error("Error al leer archivo de datos", e.getMessage());
			mapeo = new MapeoRubros();
		}
		
		return mapeo;
	}
}
