package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entidade.Cliente;

public class Arquivo {
	
	FileWriter fileWriter;
	FileReader fileReader;
	BufferedReader br;
	Cliente cliente = new Cliente();
	
	public Arquivo() {}
	
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
	
	public void editarJson(Cliente cliente) {}
	
	public void deletarJson() {
		
	}
	
}
