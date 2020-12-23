package entidade;

public class ClienteFactory {

	public static Cliente criaCliente(String CPF, String nome, String email, String senha, String telefone, String carroPlaca){		
		return new Cliente(CPF, nome, email, senha, telefone, carroPlaca);
	}
	
	public static Cliente criaNovoCliente(String CPF, String nome, String email, String senha, String telefone){		
		return new Cliente(CPF, nome, email, senha, telefone);
	}
	
	public static Cliente criaNovoCliente(String CPF, String nome, String email, String senha){		
		return new Cliente(CPF, nome, email, senha, "");
	}
	
	
}
