package ar.com.pangolines.FRANBackend.dao.dataAnalytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import com.opencsv.CSVReader;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import ar.com.pangolines.FRANBackend.bean.Rubro;

@Repository("mapeosRubrosDaoImpl")
public class MapeosRubrosDaoImpl {
	private static final Logger logger = LogManager.getLogger(MapeosRubrosDaoImpl.class);
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	public MapeoRubros getMapeoRubros() throws IOException {
		logger.info("getMapeoRubros");
		File file = resourceLoader
				.getResource("classpath:rubros-frances-go.csv")
				.getFile();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		CSVReader csvReader = new CSVReader(reader, '|');
        String[] nextRecord;
        
        MapeoRubros mapeo = new MapeoRubros();
        while ((nextRecord = csvReader.readNext()) != null) {
        	Rubro rubro = new Rubro();
        	rubro.setName(nextRecord[0]);
        	rubro.setRubroBigData(nextRecord[0]);
        	rubro.setRubroFrancesGo(nextRecord[1]);
        	
        	mapeo.add(rubro);
        }
        
		return mapeo;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	
}
