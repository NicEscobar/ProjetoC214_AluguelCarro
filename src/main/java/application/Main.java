package application;

import java.util.Scanner;

public class Main {
	
	public static void  main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int op;
		
		do{
			System.out.println("[1] - Login");
			System.out.println("[2] - Cadastrar");
			System.out.println("[0] - SAIR");
			
			System.out.println("Entre com a opção desejada:");
			
			op = teclado.nextInt();
			
			switch(op) {
				case 0:
					op = 0;
					break;
				case 1:
					Login login = new Login();
					login.inserir();
					break;
				case 2:
					Cadastro cadastro = new Cadastro();
					cadastro.gerarCliente();
					break;
				default:
					break;
				
			}
			
		}while(op != 0);
		
		teclado.close();
	}
}
