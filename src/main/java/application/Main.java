package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import database.Banco;
import database.CarroManager;
import database.ClienteManager;
import model.entities.Carro;
import model.entities.Cliente;

public class Main {

	private static CarroManager carroManager;
	private static ClienteManager clienteManager;

	private static void startDatabase() {
		Banco.conectar("banco");
		clienteManager = new ClienteManager();
		carroManager = new CarroManager();
	}

	private static void registerCars() {
		try {
			carroManager.inserir(new Carro("ABC1D23", "Gol G5", "Volkswagen", 120.00));
			carroManager.inserir(new Carro("GUG2A24", "Punto 2014", "Fiat", 130.10));
			carroManager.inserir(new Carro("BOL4C47", "Tempra", "Fiat", 30.49));
			carroManager.inserir(new Carro("TRI5T40", "Chevet", "Chervrolet", 68.49));
			carroManager.inserir(new Carro("XEQ3T17", "HB20", "Hyundai", 139.49));
		} catch (SQLException e) {
			System.out.println("Failed to register cars:" + e);
		}
	}
	
	private static void registerClients() {
		try {
			clienteManager.inserir(new Cliente("00000000000", "Gustavo Pessa", "guga@teste.com", "123456", "3599999999"));
		} catch (SQLException e) {
			System.out.println("Failed to register users:" + e);
		}
	}
	
	private static void rentCar() {
		try {
			Cliente logedIn = clienteManager.login("guga@teste.com", "123456");
			Carro carro = carroManager.buscarDisponiveis().get(0);
			
			clienteManager.alugarCarro(logedIn, carro);
			
			System.out.println("Carro Alugado:");
			System.out.println(clienteManager.buscarPrimeiro(logedIn.getCPF()));
			System.out.println(carroManager.buscarPrimeiro(carro.getPlaca()));
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Failed to rent:" + e);
		}
	}
	
	private static void printCars() {
		System.out.println("--- Carros ---");
		try {
			ArrayList<Carro> carros = carroManager.buscarTodos();
			
			for (Carro carro : carros) {
				System.out.println(carro);
				System.out.println("---");
			}
		} catch (SQLException e) {
			System.out.println("Failed to load cars:" + e);
		}
		System.out.println();
	}
	
	private static void printClients() {
		System.out.println("--- Clientes ---");
		try {
			
			ArrayList<Cliente> clientes = clienteManager.buscarTodos();
			
			for (Cliente cliente: clientes) {
				System.out.println(cliente);
				System.out.println("---");
			}
		} catch (SQLException e) {
			System.out.println("Failed to load clients:" + e);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		startDatabase();
		
		// --- Extra ---
		registerCars();
		registerClients();
		
		rentCar();
		
		printClients();
		printCars();
		// -------------
		
		Banco.desconectar();
	}

}
