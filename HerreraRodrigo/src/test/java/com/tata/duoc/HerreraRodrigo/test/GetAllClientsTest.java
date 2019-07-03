package com.tata.duoc.HerreraRodrigo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.tata.duoc.HerreraRodrigo.modelo.ClientesVO;
import com.tata.duoc.HerreraRodrigo.modelo.IClientesDAO;
@RunWith(SpringRunner.class)
@DataJpaTest
public class GetAllClientsTest {
	@Autowired
	private TestEntityManager manager;
	@Autowired
	IClientesDAO clientDAO;

	@Before
	public void setUp() throws Exception {
		
		ClientesVO cliente1 = new ClientesVO("17164844-0","Rodrigo Isaac","Herrera Beiza", "rodrigoherrera_fil@hotmail.com", "54893739"); 	
		ClientesVO cliente2= new ClientesVO("19254257-0","Diego Alberto","Herrera Beiza", "diego_chicloso@hotmail.com", "58745698");
		ClientesVO cliente3= new ClientesVO("16245654-0","Francisco Javier","Herrera Beiza", "franciscoHerrera_30@gmail.com", "53645688");
		ArrayList<ClientesVO> listaClients= new ArrayList<ClientesVO>();
		listaClients.add(cliente1);
		listaClients.add(cliente2);
		listaClients.add(cliente3);
		this.manager.persist(cliente1);
		this.manager.persist(cliente2);
		this.manager.persist(cliente3);
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("prueba terminada");
	}
	
	@Test
	public void cuandoGetAllClientsWithDataEntoncesSize3() {
		
		int porte = this.clientDAO.findAll().size();
		assertTrue("Es "+porte+" y deberia ser 3", porte==3);
		
	}
	@Test
	public void cuandoGetAllClientesWithOutDataEntoncesReturnFalse() {
		
		this.clientDAO.deleteAll();
		String validador = (this.clientDAO.findAll().size()==0)? "false":"true";
		assertTrue("Es "+validador+" y deberia ser false", validador == "false");
	}

}
