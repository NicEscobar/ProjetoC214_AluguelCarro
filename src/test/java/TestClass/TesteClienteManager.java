package TestClass;

import static org.junit.Assert.assertSame;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import database.ClienteManager;
import entidade.Cliente;

@RunWith(MockitoJUnitRunner.class)
public class TesteClienteManager {

	@Mock
	Cliente clienteMock;

	@Mock
	ClienteManager clienteManager;

	@Mock
	ArrayList<Cliente> listaDeClientes;

	@Test
	public void TesteLogin() throws SQLException {
		Mockito.when(clienteManager.login("email", "senha")).thenReturn(clienteMock);

		assertSame(clienteManager.login("email", "senha"), clienteMock);
	}

	@Test
	public void TesteBuscarTodos() throws SQLException {
		Mockito.when(clienteManager.buscarTodos()).thenReturn(listaDeClientes);

		assertSame(clienteManager.buscarTodos(), listaDeClientes);
	}

}
