package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import model.entities.Cliente;

public class Arquivo {
	
	FileWriter fileWriter;
	FileReader fileReader;
	BufferedReader br;
	
	public Arquivo() {}
	
	public void procurar(String email) {
		
		try {
			
		
			br = new BufferedReader(new FileReader("cliente.json"));
			
			while(br.ready()) {
				String linha = br.readLine();
				
				if(linha.contains(email)) {
					System.out.println(email);
				}
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
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
	
	public void deletar() {
		
	}
	
}
