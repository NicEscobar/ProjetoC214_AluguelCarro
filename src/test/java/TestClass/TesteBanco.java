package TestClass;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import database.Banco;

public class TesteBanco {

	Banco banco;
	
	@Before
	public void setUp() {
		banco = new Banco();
	}
	
	@Test
	public void TesteConectar() {
		banco.conectar("banco");
		
		assertNotNull(banco.conexao);
	}
	
	@Test
	public void TesteDesconectar() {
		banco.conectar("banco");
		banco.desconectar();
		
		assertNull(banco.conexao);
	}
	
}
