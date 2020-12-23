package TestClass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidade.Cliente;
import entidade.ClienteFactory;

public class TesteCliente {

	@Test
	public void TesteClienteFactorySemTelefone() {
		Cliente cliente = ClienteFactory.criaNovoCliente("0101", "Cliente", "cliente@teste.com", "123");

		assertEquals("Cliente", cliente.getNome());
		assertEquals("123", cliente.getSenha());
		assertEquals("0101", cliente.getCPF());
		assertEquals("cliente@teste.com", cliente.getEmail());
		assertEquals("", cliente.getTelefone());
	}

	@Test
	public void TesteClienteFactoryComTelefone() {
		Cliente cliente = ClienteFactory.criaNovoCliente("0101", "Cliente", "cliente@teste.com", "123", "99");

		assertEquals("Cliente", cliente.getNome());
		assertEquals("123", cliente.getSenha());
		assertEquals("0101", cliente.getCPF());
		assertEquals("cliente@teste.com", cliente.getEmail());
		assertEquals("99", cliente.getTelefone());
	}

}
