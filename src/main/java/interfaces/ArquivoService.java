package interfaces;

import entidade.Cliente;

public interface ArquivoService {
	
	public void gerarJson(Cliente cliente);
	
	public void editarJson(Cliente cliente);
	
	public void deletarJson();
	
	public String procurar(String email);
	
}
