package ar.com.pangolines.FRANBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import ar.com.pangolines.FRANBackend.service.SugerenciaPangolinesService;

@RestController
public class SugerenciaRubroController implements ISugerenciaRubroController{
	@Autowired()
	@Qualifier("sugerenciaPangolinesService")
	private SugerenciaPangolinesService sugerenciaPangolinesService;
	
	
	@Override
	public MapeoRubros getAllRubros() {
		return this.sugerenciaPangolinesService.getMapeoAllRubros();
	}
	
}
