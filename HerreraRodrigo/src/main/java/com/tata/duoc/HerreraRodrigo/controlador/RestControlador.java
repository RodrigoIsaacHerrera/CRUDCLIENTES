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
	IClientesDAO clientsDAO;
	
	@GetMapping("/clients")
	public List<ClientesVO> getAllClients(){
		return this.clientsDAO.findAll();
	}
	@GetMapping("/clients/{rut}")
	public ClientesVO getClientById(@PathVariable String rut){
		return this.clientsDAO.findById(rut).get();
	}

	@GetMapping("/clients/search/{nombre}")
	public ClientesVO getClientByName(@PathVariable String nombre){
	return this.clientsDAO.findByNombres(nombre).orElse(new ClientesVO());
	}
	@PostMapping("/clients")
	public boolean addClient(@RequestBody ClientesVO body) {
		
		String rut = body.getRut();
		if(!this.clientsDAO.existsById(rut) && this.clientsDAO != null) {
			this.clientsDAO.save(body);
			return true;
		}
		return false;	
	}
	@PutMapping("/clients")
	public boolean modifyClient(@RequestBody ClientesVO body){
		String rut = body.getRut();
		if(this.clientsDAO.existsById(rut) && this.clientsDAO != null){
			this.clientsDAO.save(body);
			return true;
		}
		return false;
	}
	@DeleteMapping("/clients/{rut}")
	public boolean deleteClient(@PathVariable String rut) {
		
		if(this.clientsDAO.existsById(rut) && !(rut.equalsIgnoreCase("99999999-9"))) {
			this.clientsDAO.deleteById(rut);
			return true;
		}else if(rut.equalsIgnoreCase("99999999-9")&& (this.clientsDAO.count()!=0)) {
			this.clientsDAO.deleteAll();
			return true;
		}else if (rut.equalsIgnoreCase("99999999-9")&&(this.clientsDAO.count()==0)) {
			return false;
		}else {
			return false;
		}
		
	}
	
}

