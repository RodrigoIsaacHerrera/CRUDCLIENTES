package com.tata.duoc.HerreraRodrigo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tata.duoc.HerreraRodrigo.modelo.ClientesVO;
import com.tata.duoc.HerreraRodrigo.modelo.IClientesDAO;

@RestController
public class RestControlador{

	@Autowired
	IClientesDAO clientesDAO;
	
	@GetMapping("/clientes")
	public List<ClientesVO> getAllClients(){
		return this.clientesDAO.findAll();
	}
	@GetMapping("/clientes/{rut}")
	public ClientesVO getClienteById(@PathVariable String rut){
		return this.clientesDAO.findById(rut).get();
	}

	@GetMapping("/clientes/buscar/{nombre}")
	public ClientesVO getClienteByName(@PathVariable String nombre){
	return this.clientesDAO.findByNombres(nombre).orElse(new ClientesVO());
	}
	@PostMapping("/clientes")
	public boolean addClient(@RequestBody ClientesVO body) {
		
		String rut = body.getRut();
		if(!this.clientesDAO.existsById(rut) && this.clientesDAO != null && rut!=null) {
			this.clientesDAO.save(body);
			return true;
		}
		return false;	
	}
	@PutMapping("/clientes")
	public boolean modifyClient(@RequestBody ClientesVO body){
		String rut = body.getRut();
		if(this.clientesDAO.existsById(rut) && this.clientesDAO != null){
			this.clientesDAO.save(body);
			return true;
		}
		return false;
	}
	@DeleteMapping("/clientes/{rut}")
	public boolean deleteCliente(@PathVariable String rut) {
		
		if(this.clientesDAO.existsById(rut) && !(rut.equalsIgnoreCase("99999999-9"))) {
			this.clientesDAO.deleteById(rut);
			return true;
		}else if(rut.equalsIgnoreCase("99999999-9")&& (this.clientesDAO.count()!=0)) {
			this.clientesDAO.deleteAll();
			return true;
		}else if (rut.equalsIgnoreCase("99999999-9")&&(this.clientesDAO.count()==0)) {
			return false;
		}else {
			return false;
		}
		
	}
	
}

