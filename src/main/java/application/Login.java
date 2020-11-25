package application;

import DAO.Arquivo;
import entidade.Cliente;

public class Login {
	
	Cliente cliente = new Cliente();
	Arquivo arquivo = new Arquivo();
	
	
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
