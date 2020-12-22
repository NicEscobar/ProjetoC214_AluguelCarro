package TestClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entidade.Cliente;

public class TestCliente {

	Cliente cliente;
	
	@Before
	public void beforeTest() {
		cliente = new Cliente("110","Jessica","je@","123","(35)9",null);
		
	}
	
	@Test
	public void GetCliente() {
		
		assertEquals("Jessica",cliente.getNome());
		assertEquals("123",cliente.getSenha());
		assertEquals("110",cliente.getCPF());
		assertEquals("je@",cliente.getEmail());
		assertEquals("(35)9",cliente.getTelefone());
		
	}
	@Test
	public void AddCarro() {
		
		String c;
		c = "Jessica, 123, 110, je@,";
		String s;
		s = cliente.toString();
		
		assertTrue(s.contains(c));
		
		
	}
	
	
}
