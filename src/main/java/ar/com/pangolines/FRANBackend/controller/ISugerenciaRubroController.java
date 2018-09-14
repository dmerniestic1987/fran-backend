package ar.com.pangolines.FRANBackend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.pangolines.FRANBackend.bean.MapeoRubros;
import ar.com.pangolines.FRANBackend.bean.Recomendacion;
import ar.com.pangolines.FRANBackend.bean.RecomendacionRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "wallets", description = "API para sugerencia y predicción de rubros")
public interface ISugerenciaRubroController {
	
	@ApiOperation(value = "Obtiene el mapeo entre rubros de nuestro análisis de BitData y los de Fracnés Go", nickname = "getAllRubros", response = MapeoRubros.class)
	@GetMapping("/rubros")
	public MapeoRubros getAllRubros();
	
	@ApiOperation(value = "Obtiene la recomendación en ase al número de cuenta"
			  	, nickname = "getAllRubros"
			  	, response = Recomendacion.class)
	@PostMapping("/recomendaciones")
	public Recomendacion getRecomendacionByGoogleUserId(@ApiParam(value = "Google ID" ,required=true) @RequestBody RecomendacionRequest googleUserId, HttpServletResponse response);

	
}
