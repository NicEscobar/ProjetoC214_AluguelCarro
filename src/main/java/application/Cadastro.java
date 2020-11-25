package application;

import java.util.Scanner;

import DAO.Arquivo;
import model.entities.Cliente;

public class Cadastro {
	
	Cliente cliente;
	Scanner teclado = new Scanner(System.in);
	Arquivo arquivo;
	
	public Cadastro() {	
		
		cliente = new Cliente();
		arquivo = new Arquivo();
		
	}
	
	public void gerarCliente() {
		
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
		
		arquivo.gerarJson(cliente);
				
	}
	


}
