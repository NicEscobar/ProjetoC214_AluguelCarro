package application;

import java.sql.SQLException;
import java.util.ArrayList;

import database.Banco;
import database.CarroManager;
import database.ClienteManager;
import entidade.Carro;
import entidade.CarroFactory;
import entidade.Cliente;
import entidade.ClienteFactory;
import holder.BancoHolder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static void registerCars() {
		try {
			BancoHolder.getInstance().getCarroManager()
					.inserir(CarroFactory.criaNovoCarro("ABC1D23", "Gol G5", "Volkswagen", 120.00));
			BancoHolder.getInstance().getCarroManager()
					.inserir(CarroFactory.criaNovoCarro("GUG2A24", "Punto 2014", "Fiat", 130.10));
			BancoHolder.getInstance().getCarroManager()
					.inserir(CarroFactory.criaNovoCarro("BOL4C47", "Tempra", "Fiat", 30.49));
			BancoHolder.getInstance().getCarroManager()
					.inserir(CarroFactory.criaNovoCarro("TRI5T40", "Chevet", "Chervrolet", 68.49));
			BancoHolder.getInstance().getCarroManager()
					.inserir(CarroFactory.criaNovoCarro("XEQ3T17", "HB20", "Hyundai", 139.49));
		} catch (SQLException e) {
			System.out.println("Failed to register cars:" + e);
		}
	}

	private static void registerClients() {
		try {
			BancoHolder.getInstance().getClienteManager().inserir(
					ClienteFactory.criaNovoCliente("00000000000", "Gustavo Pessa", "guga@teste.com", "123456"));
		} catch (SQLException e) {
			System.out.println("Failed to register users:" + e);
		}
	}

	private static void rentCar() {
		try {
			Cliente logedIn = BancoHolder.getInstance().getClienteManager().login("guga@teste.com", "123456");
			Carro carro = BancoHolder.getInstance().getCarroManager().buscarDisponiveis().get(0);

			BancoHolder.getInstance().getClienteManager().alugarCarro(logedIn, carro);

			System.out.println("Carro Alugado:");
			System.out.println(BancoHolder.getInstance().getClienteManager().buscarPrimeiro(logedIn.getCPF()));
			System.out.println(BancoHolder.getInstance().getClienteManager().buscarPrimeiro(carro.getPlaca()));
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Failed to rent:" + e);
		}
	}

	private static void printCars() {
		System.out.println("--- Carros ---");
		try {
			ArrayList<Carro> carros = BancoHolder.getInstance().getCarroManager().buscarTodos();

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

			ArrayList<Cliente> clientes = BancoHolder.getInstance().getClienteManager().buscarTodos();

			for (Cliente cliente : clientes) {
				System.out.println(cliente);
				System.out.println("---");
			}
		} catch (SQLException e) {
			System.out.println("Failed to load clients:" + e);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		BancoHolder.getInstance().criarBanco("banco");

		// --- Extra ---
		registerCars();
		registerClients();

		// rentCar();

		// printClients();
		// printCars();
		// -------------

		launch(args);

		BancoHolder.getInstance().getBanco().desconectar();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("/view/FXMLTelaLogin.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();

	}

}
