package TestClass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.entities.Carro;

public class TestCarro {

	Carro carro;
	
	@Before
	public void beforeTest() {
		carro = new Carro();
		
	}
	
	@Test
	public void AddCarro() {
		carro.setMarca("Ford");
		carro.setModelo("Hylux");
		carro.setPlaca("FLO-1241");
		
		assertEquals("Ford",carro.getMarca());
		assertEquals("Hylux",carro.getModelo());
		assertEquals("FLO-1241",carro.getPlaca());
		
	}
}
