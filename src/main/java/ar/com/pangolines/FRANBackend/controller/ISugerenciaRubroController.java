package ar.com.pangolines.FRANBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "wallets", description = "API para sugerencia y predicción de rubros")
public interface ISugerenciaRubroController {
	
	@ApiOperation(value = "Obtiene el mapeo entre rubros de nuestro análisis de BitData y los de Fracnés Go", nickname = "getAllRubros", response = MapeoRubros.class)
	@GetMapping("/rubros")
	public MapeoRubros getAllRubros();

	
}
