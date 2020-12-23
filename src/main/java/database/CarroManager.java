package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Carro;
import entidade.CarroFactory;

public class CarroManager extends TableManager<Carro> {

	public CarroManager(Connection conexao) {
		super(conexao, "CREATE TABLE IF NOT EXISTS carros(" + "placa VARCHAR PRIMARY KEY, " + "marca VARCHAR NOT NULL, "
				+ "modelo VARCHAR NOT NULL, " + "aluguel REAL NOT NULL, " + "clienteCPF VARCHAR, "
				+ "FOREIGN KEY(clienteCPF) REFERENCES clientes(CPF) " + ")");
	}

	public ArrayList<Carro> buscarTodos() throws SQLException {
		ResultSet rs = this.conexao.prepareStatement("SELECT * FROM carros")
				.executeQuery();

		return construirLista(rs);
	}

	public ArrayList<Carro> buscarDisponiveis() throws SQLException {
		ResultSet rs = this.conexao
				.prepareStatement("SELECT * FROM carros WHERE clienteCPF IS NULL").executeQuery();

		return construirLista(rs);
	}

	public Carro buscarPrimeiro(String placa) throws SQLException {
		ResultSet rs = this.conexao
				.prepareStatement("SELECT * FROM carros WHERE placa = '" + placa + "'").executeQuery();

		if (rs.next() == false) {
			return null;
		}

		Carro carro = CarroFactory.criaCarro(rs.getString("placa"), rs.getString("modelo"), rs.getString("marca"),
				rs.getFloat("aluguel"), rs.getString("clienteCPF"));
		return carro;
	}

	public void inserir(Carro carro) throws SQLException {
		this.conexao.createStatement()
				.execute("INSERT INTO carros(placa, marca, modelo, aluguel) VALUES (" + "'" + carro.getPlaca() + "',"
						+ "'" + carro.getMarca() + "'," + "'" + carro.getModelo() + "'," + "'" + carro.getAluguel()
						+ "')");
	}

	private ArrayList<Carro> construirLista(ResultSet rs) throws SQLException {
		ArrayList<Carro> carros = new ArrayList<Carro>();

		while (rs.next()) {
			Carro carro = CarroFactory.criaCarro(rs.getString("placa"), rs.getString("modelo"), rs.getString("marca"),
					rs.getFloat("aluguel"), rs.getString("clienteCPF"));
			carros.add(carro);
		}

		return carros;
	}

}
