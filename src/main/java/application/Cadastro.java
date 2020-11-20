package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.entities.Cliente;

public class Cadastro {
	
	Cliente cliente;
	FileWriter fileWriter;
	Scanner teclado = new Scanner(System.in);
	
	public Cadastro() {	
		cliente = new Cliente();
		
	}

	public void GerarJson() {
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
	
	public void GerarCliente() {
		
		System.out.println("Nome;");
		cliente.setNome(teclado.nextLine());
		System.out.println("E-mail;");
		cliente.setEmail(teclado.nextLine());
		System.out.println("Senha;");
		cliente.setSenha(teclado.nextLine());
		System.out.println("CPF:");
		cliente.setCpf(teclado.nextInt());
		System.out.println("Telefone;");
		cliente.setTell(teclado.nextInt());
		
			
		GerarJson();
	}
	


}
