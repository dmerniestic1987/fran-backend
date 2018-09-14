package ar.com.pangolines.FRANBackend.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import ar.com.pangolines.FRANBackend.bean.Customer;
import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import ar.com.pangolines.FRANBackend.bean.Recomendacion;
import ar.com.pangolines.FRANBackend.bean.RecomendacionRequest;
import ar.com.pangolines.FRANBackend.service.CustomerService;
import ar.com.pangolines.FRANBackend.service.SugerenciaPangolinesService;

@RestController
public class SugerenciaRubroController implements ISugerenciaRubroController{
	private static final Logger logger = LogManager.getLogger(SugerenciaRubroController.class);
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;
    
	@Autowired()
	@Qualifier("sugerenciaPangolinesService")
	private SugerenciaPangolinesService sugerenciaPangolinesService;
	
	
	@Override
	public MapeoRubros getAllRubros() {
		return this.sugerenciaPangolinesService.getMapeoAllRubros();
	}


	@Override
	public Recomendacion getRecomendacionByGoogleUserId(RecomendacionRequest googleUserId, HttpServletResponse response) {
		Recomendacion recomendacion = null;
		Customer cus = this.customerService.getCustomerByGoogleId(googleUserId.getGoogleUserId());
		if (cus == null) {
			response.setStatus(404);
		}
		
		
		try {
			recomendacion = this.sugerenciaPangolinesService.findByAccountNumber(cus.getAccountNumber());
			if (recomendacion == null) {
				response.setStatus(404);
				return recomendacion;
			}
			recomendacion.setGogoleUserId(googleUserId.getGoogleUserId());
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.setStatus(500);
		}
		
		return recomendacion;
	
	}
}
