package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Carro;

public class CarroManager extends TableManager<Carro> {

	public CarroManager() {
		super("CREATE TABLE IF NOT EXISTS carros(" + "placa VARCHAR PRIMARY KEY, " + "marca VARCHAR NOT NULL, "
				+ "modelo VARCHAR NOT NULL, " + "aluguel REAL NOT NULL, " + "clienteCPF VARCHAR, "
				+ "FOREIGN KEY(clienteCPF) REFERENCES clientes(cpf) " + ")");
	}

	public ArrayList<Carro> buscarTodos() throws SQLException {
		ResultSet rs = Banco.conexao.prepareStatement("SELECT * FROM carros").executeQuery();

		return construirLista(rs);
	}

	public ArrayList<Carro> buscarDisponiveis() throws SQLException {
		ResultSet rs = Banco.conexao.prepareStatement("SELECT * FROM carros WHERE clienteCPF IS NULL").executeQuery();

		return construirLista(rs);
	}

	public Carro buscarPrimeiro(String placa) throws SQLException {
		ResultSet rs = Banco.conexao.prepareStatement("SELECT * FROM carros WHERE placa = '" + placa + "'")
				.executeQuery();

		if (rs.next() == false) {
			return null;
		}

		Carro carro = new Carro(rs.getString("placa"), rs.getString("modelo"), rs.getString("marca"),
				rs.getFloat("aluguel"), rs.getString("clienteCPF"));
		return carro;
	}

	public void inserir(Carro carro) throws SQLException {
		Banco.conexao.createStatement()
				.execute("INSERT INTO carros(placa, marca, modelo, aluguel) VALUES (" + "'" + carro.getPlaca() + "',"
						+ "'" + carro.getMarca() + "'," + "'" + carro.getModelo() + "'," + "'" + carro.getAluguel()
						+ "')");
	}

	private ArrayList<Carro> construirLista(ResultSet rs) throws SQLException {
		ArrayList<Carro> carros = new ArrayList<Carro>();

		while (rs.next()) {
			Carro carro = new Carro(rs.getString("placa"), rs.getString("modelo"), rs.getString("marca"),
					rs.getFloat("aluguel"), rs.getString("clienteCPF"));
			carros.add(carro);
		}

		return carros;
	}

}
