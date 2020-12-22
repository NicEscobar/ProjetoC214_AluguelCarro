package TestClass;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;

import application.ClienteHolder;
import database.Banco;
import database.ClienteManager;
import entidade.Carro;
import entidade.Cliente;

@RunWith(MockitoJUnitRunner.class)
public class TestMain {

	@Mock 
	ClienteManager cManager; //Classe que vai ser mokada
	
	@InjectMocks
	ClienteHolder cHolder;//Injetando a classe de serviço
	
	Carro carro;
	Cliente cliente;
	
	@Before
	public void beforeTest() {
		carro = new Carro("5634","Hylux","Ford",0,"110");
		cliente = new Cliente("110","Jessica","je@","123","(35)9",null);
		cManager = new ClienteManager();
	}
	
	@Test
	public void testeInserirCliente() throws SQLException {	
		
	
	}
}
