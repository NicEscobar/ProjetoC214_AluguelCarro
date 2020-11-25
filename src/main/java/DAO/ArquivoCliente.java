package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entidade.Cliente;

public class ArquivoCliente {
	
	FileWriter fileWriter;
	FileReader fileReader;
	BufferedReader br;
	Cliente cliente = new Cliente();
	
	public ArquivoCliente() {}
	
	//Procura o email do  cliente no arquivo
	public Cliente procurarJson(String email) {
		
		try {
				
			br = new BufferedReader(new FileReader("cliente.json"));
			
			while(br.ready()) {
				String linha = br.readLine();
				
				if(linha.contains(email)) {
					System.out.println(email);
				}
			}
			br.close();
			return cliente;
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	//Gera o arquivo json e adiciona o cliente no arquivo
	public void gerarJson(Cliente cliente) 
	{
		if(cliente != null) {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(cliente);
				
			try {
				
				fileWriter = new FileWriter("cliente.json", true);
				fileWriter.write(json);
				fileWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	
	//Edita o cliente salvo no arquivo
	public void editarJson(Cliente cliente) {}
	
	//Deleta o cliente do arquivo
	public void deletarJson() {
		
	}
	
}
