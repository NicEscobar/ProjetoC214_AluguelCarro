package application;

import DAO.ArquivoCliente;
import entidade.Cliente;

public class Login {
	
	Cliente cliente = new Cliente();
	ArquivoCliente arquivo = new ArquivoCliente();
	
	//Verifica se o cliente foi cadastrado e existe no arquivo 
	public Cliente verificarLogin(String email, String senha) {
		
		cliente = arquivo.procurarJson(email);
		
		if(cliente != null) {
			if (cliente.getSenha() == senha) {
				return cliente;
			}
		}
		
		return null;
	}
	
	
}
