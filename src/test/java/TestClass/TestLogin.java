package TestClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import DAO.ArquivoCliente;
import application.Login;


@RunWith(MockitoJUnitRunner.class)
public class TestLogin {

	@Mock 
	ArquivoCliente arquivo; //Classe que vai ser mokada
	
	@InjectMocks
	Login login; //Injetando a classe de serviço
	
	@Test
	public void testeInsert() {
		
		//String email = "nicole@";
		//String senha = "1234";
		
		//Mockito.when(arquivo.procurarJson(email)).thenReturn(ClienteConstante.Cliente);
		
		//verify(arquivo,times(1)).gerarJson(cliente);;
		
	}
}
