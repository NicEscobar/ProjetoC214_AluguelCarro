package application;

import DAO.Arquivo;
import entidade.Carro;
import entidade.Cliente;

public class Cadastro {
	
	Arquivo arquivo;
	
	public Cadastro() {	
		
		arquivo = new Arquivo();
		
	}
	
	public void gerarCliente(Cliente cliente) {
		
		arquivo.gerarJson(cliente);
				
	}
	public void addCarro(Cliente cliente, Carro carro) {
				
		if (cliente != null && cliente.getCarro() == null) {
			cliente.setCarro(carro);	
		}
		
		arquivo.editarJson(cliente);
	}
	public void editarCadastro(Cliente cliente) {
		
		Cliente clienteJson = arquivo.procurarJson(cliente.getEmail());
		
		if(clienteJson != null) {
			arquivo.editarJson(cliente);
		}
	}

}
