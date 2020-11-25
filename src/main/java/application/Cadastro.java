package application;

import DAO.ArquivoCliente;
import entidade.Carro;
import entidade.Cliente;

public class Cadastro {
	
	ArquivoCliente arquivo;
	
	public Cadastro() {	
		
		arquivo = new ArquivoCliente();
		
	}
	
	//Envia as informações do cliente adquiridas para o arquivo
	public void gerarCliente(Cliente cliente) {
		
		arquivo.gerarJson(cliente);
				
	}
	//Adiciona o carro escolhido pelo cliente no cadastro
	public void addCarro(Cliente cliente, Carro carro) {
				
		if (cliente != null && cliente.getCarro() == null) {
			cliente.setCarro(carro);	
		}
		
		arquivo.editarJson(cliente);
	}
	//Edita o cadastro do cliente
	public void editarCadastro(Cliente cliente) {
		
		Cliente clienteJson = arquivo.procurarJson(cliente.getEmail());
		
		if(clienteJson != null) {
			arquivo.editarJson(cliente);
		}
	}

}
