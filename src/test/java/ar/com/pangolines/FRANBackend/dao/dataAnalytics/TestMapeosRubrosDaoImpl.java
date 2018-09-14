package ar.com.pangolines.FRANBackend.dao.dataAnalytics;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapeosRubrosDaoImpl {
	private static final Logger logger = LogManager.getLogger(TestMapeosRubrosDaoImpl.class);

	@Autowired
	@Qualifier("mapeosRubrosDaoImpl")
	private MapeosRubrosDaoImpl dao;
	
	@Test
	public void testLoadFile() throws Exception{
		logger.info("testLoadFile");
		
		MapeoRubros rubros = dao.getMapeoRubros();
		assertNotNull(rubros);
		
		logger.info(rubros.toString());
	}
	
}
