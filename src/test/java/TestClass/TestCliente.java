package TestClass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entidade.Carro;
import entidade.Cliente;

public class TestCliente {

	Cliente cliente;
	Carro carro;
	
	@Before
	public void beforeTest() {
		cliente = new Cliente();
		carro = new Carro();
		
	}
	
	@Test
	public void AddCliente() {
		
		cliente.setNome("Nicole");
		cliente.setCpf("110.345");
		cliente.setEmail("nicole@");
		cliente.setId(0);
		cliente.setSenha("123");
		cliente.setTell(3594);
		
		assertEquals("Nicole",cliente.getNome());
		assertEquals("123",cliente.getSenha());
		
	}
	@Test
	public void AddCarro() {
		
		carro.setMarca("Ford");
		carro.setModelo("Hylux");
		carro.setPlaca("AB-28");
		carro.setInfo("Ar-condicionado");
		
		cliente.setCarro(carro);
		
		assertEquals("Hylux",cliente.getCarro().getModelo());
		
	}
	
	
}
