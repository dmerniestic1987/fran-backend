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
		/*
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
        */
		MapeoRubros mapeo = new MapeoRubros();
		Rubro rubro = new Rubro();
		rubro.setName("ENTRETENIMIENTO");
		rubro.setRubroBigData("ENTRETENIMIENTO");
		rubro.setRubroFrancesGo("3413");
		mapeo.add(rubro);
		
		
		rubro = new Rubro();
		rubro.setName("MODA Y ACCESORIOS");
		rubro.setRubroBigData("MODA Y ACCESORIOS");
		rubro.setRubroFrancesGo("3517");
		mapeo.add(rubro);
		
		
		rubro = new Rubro();
		rubro.setName("AUTOMOTORES");
		rubro.setRubroBigData("AUTOMOTORES");
		rubro.setRubroFrancesGo("3579");
		mapeo.add(rubro);
		
		
		rubro = new Rubro();
		rubro.setName("BELLEZA Y CUIDADO PERSONAL");
		rubro.setRubroBigData("BELLEZA Y CUIDADO PERSONAL");
		rubro.setRubroFrancesGo("3417");
		mapeo.add(rubro);
		
		
		rubro = new Rubro();
		rubro.setName("DEPORTES");
		rubro.setRubroBigData("DEPORTES");
		rubro.setRubroFrancesGo("13527");
		mapeo.add(rubro);
		
		
		rubro = new Rubro();
		rubro.setName("ELECTRO Y TECNOLOGIA");
		rubro.setRubroBigData("ELECTRO Y TECNOLOGIA");
		rubro.setRubroFrancesGo("16458");
		mapeo.add(rubro);
		
		
		rubro = new Rubro();
		rubro.setName("GASTRONOMIA");
		rubro.setRubroBigData("GASTRONOMIA");
		rubro.setRubroFrancesGo("3412");
		mapeo.add(rubro);
		
		rubro = new Rubro();
		rubro.setName("GASTRONOMIA");
		rubro.setRubroBigData("GASTRONOMIA");
		rubro.setRubroFrancesGo("3412");
		mapeo.add(rubro);
		
		rubro = new Rubro();
		rubro.setName("HOGAR Y DECO");
		rubro.setRubroBigData("HOGAR Y DECO");
		rubro.setRubroFrancesGo("3578");
		mapeo.add(rubro);
		
		rubro = new Rubro();
		rubro.setName("REGALOS");
		rubro.setRubroBigData("REGALOS");
		rubro.setRubroFrancesGo("16466");
		mapeo.add(rubro);
		
		rubro = new Rubro();
		rubro.setName("OTROS COMERCIOS Y SERVICIOS");
		rubro.setRubroBigData("OTROS COMERCIOS Y SERVICIOS");
		rubro.setRubroFrancesGo("3435");
		
		rubro = new Rubro();
		rubro.setName("VIAJES Y TURISMO");
		rubro.setRubroBigData("VIAJES Y TURISMO");
		rubro.setRubroFrancesGo("3422");
		mapeo.add(rubro);
		
		return mapeo;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	
}
