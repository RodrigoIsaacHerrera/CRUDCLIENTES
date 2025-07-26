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
public class GetClientByIdTest {
	
	@Autowired
	private TestEntityManager manager;
	@Autowired
	IClientesDAO clienteDao;
		
	@Before
	public void setUp() throws Exception {
		ClientesVO  cliente1 = new ClientesVO("12369857-1","Carmelo Miguel","Marin Ambio","marintoypato@losdeudores.com","78526495");
		ClientesVO  cliente2 = new ClientesVO("15456321-0","Catalina Andrea","Lagos Brito","lavidaesdura@emu.cl","72254569");
		ClientesVO  cliente3 = new ClientesVO("14658951-7","Seaca Botodo","Metroa Plastame","losreprobados@duoc.com","96325814");
		
		ArrayList<ClientesVO> listaClientes = new ArrayList<ClientesVO>();
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);
		
		this.manager.persist(cliente1);
		this.manager.persist(cliente2);
		this.manager.persist(cliente3);
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("prueba terminada resultado");
	}

	@Test
	public void whenGetClientByIdcliente1EntoncesNotNull(){
		
		String celu = this.clienteDao.findById("12369857-1").get().getCelular();
		assertTrue("Es "+ celu +" y deberia ser ", celu.equals("78526495"));
	}

}
