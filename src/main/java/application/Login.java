package application;

import java.util.Scanner;

import DAO.Arquivo;
import model.entities.Cliente;

public class Login {
	
	Scanner teclado = new Scanner(System.in);
	Cliente cliente = new Cliente();
	Arquivo arquivo = new Arquivo();
	
	
	public void verificar() {
		
		arquivo.procurar(cliente.getEmail());
		
	}
	
	public void inserir() {	
		
		System.out.println("E-mail;");
		cliente.setEmail(teclado.nextLine());
		System.out.println("Senha;");
		cliente.setSenha(teclado.nextLine());	
		
		verificar();
	}
	
	
}
