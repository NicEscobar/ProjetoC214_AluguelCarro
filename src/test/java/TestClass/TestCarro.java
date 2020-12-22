package TestClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entidade.Carro;


public class TestCarro {

Carro carro;
	
	@Before
	public void beforeTest() {
		carro = new Carro("5634","Hylux","Ford",0,"110");
		
	}
	
	@Test
	public void GetCarro() {
		
		assertEquals("Hylux",carro.getModelo());
		assertEquals("Ford",carro.getMarca());
		assertEquals("5634",carro.getPlaca());
		assertEquals("110",carro.getClienteCPF());
		assertEquals(0,carro.getAluguel(),0.1);
		
	}
	@Test
	public void AddCarro() {
		
		String c;
		c = "Hylux";
		String s;
		s = carro.toString();
		
		assertTrue(s.contains(c));
		
		
	}
	
}
