package ar.com.pangolines.FRANBackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.pangolines.FRANBackend.bean.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "customers", description = "API para gestión de Clientes Pangolines")
public interface ICustomerController {
	
    
    @ApiOperation(value = "Obtiene una lista de los clientes.", nickname = "getCustomers")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Operación exitosa"),
    						@ApiResponse(code = 401, message = "No autorizado"),
    						@ApiResponse(code = 404, message = "Recurso no encontrado"),
            				@ApiResponse(code = 500, message = "Error interno del servidor") })
    @GetMapping("/customers")
    public List<Customer> getCustomers();
    
    
    @ApiOperation(value = "Obtiene un cliente particular dado su id.", nickname = "getCustomerById", response = Customer.class)
    @GetMapping("/customers/{customerId}")
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Operación exitosa"),
			@ApiResponse(code = 401, message = "No autorizado"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })    
    public Customer getCustomerById( @ApiParam(value = "El id del cliente. Es un string que se genera al darlo de alta",required=true)
    								 @PathVariable String customerId);
    
    
    @ApiOperation(value = "Crea un nuevo cliente.", nickname = "createCustomer", response = Customer.class)
    @PostMapping("/customers")
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Operación exitosa"),
			@ApiResponse(code = 401, message = "No autorizado"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })        
    public Customer createCustomer(@ApiParam(value = "Customer que se quiere dar sin alta, sin customerId" ,required=true) 
    							   @RequestBody Customer customer);
    
    @ApiOperation(value = "Actualiza un cliente dado un id específico.", nickname = "updateCustomer")
    @PutMapping("/customers/{customerId}")
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Operación exitosa"),
			@ApiResponse(code = 401, message = "No autorizado"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })         
    public void updateCustomer(@ApiParam(value = "Customer que se quiere dar sin alta, con customerId" ,required=true)
    						   @RequestBody Customer customer);
 
    @ApiOperation(value = "Elimina un cliente dado un id específico.", nickname = "deleteCustomer")
    @DeleteMapping("/customers/{customerId}")
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Operación exitosa"),
			@ApiResponse(code = 401, message = "No autorizado"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })         
    public void deleteCustomer(@ApiParam(value = "El id del cliente. Es un string que se genera al darlo de alta",required=true)
	 						   @PathVariable String customerId);
}
