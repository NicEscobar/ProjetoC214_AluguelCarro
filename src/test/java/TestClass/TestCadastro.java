package TestClass;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import DAO.ArquivoCliente;
import application.Cadastro;
import entidade.Cliente;

@RunWith(MockitoJUnitRunner.class)
public class TestCadastro {

	@Mock 
	ArquivoCliente arquivo; //Classe que vai ser mokada
	
	@InjectMocks
	Cadastro cadastro; //Injetando a classe de serviço
	
	@Test
	public void testeInserirCliente() {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(0);
		cliente.setNome("Nicole");
		cliente.setEmail("nicole@");
		cliente.setCpf("110.123");
		cliente.setTell(3512);
		cliente.setSenha("123");
		cliente.setCarro(null);
		
		cadastro.gerarCliente(cliente);
		
		verify(arquivo,times(1)).gerarJson(cliente);
		
	}
	@Test
	public void testeInserirCarro() {
		/*
		Cliente cliente = new Cliente();
		Carro carro = new Carro();
		
		carro.setMarca("Ford");
		carro.setModelo("Hylux");
		
		cliente.setCarro(carro);
		
		verify(arquivo,times(1)).editarJson(cliente);
	*/}
}
