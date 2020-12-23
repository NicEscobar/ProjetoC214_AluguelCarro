package TestClass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entidade.Carro;
import entidade.CarroFactory;

public class TesteCarro {

	Carro carro;

	@Before
	public void beforeTest() {
		carro = CarroFactory.criaNovoCarro("5634", "Hylux", "Ford", 0);
	}

	@Test
	public void TesteCarroFactory() {
		assertEquals("Hylux", carro.getModelo());
		assertEquals("Ford", carro.getMarca());
		assertEquals("5634", carro.getPlaca());
		assertEquals(0, carro.getAluguel(), 0.1);
	}

}
