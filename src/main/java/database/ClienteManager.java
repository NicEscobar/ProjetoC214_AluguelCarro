package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entidade.Carro;
import entidade.Cliente;

public class ClienteManager extends TableManager<Cliente> {

	public ClienteManager() {
		super("CREATE TABLE IF NOT EXISTS clientes(" + "CPF VARCHAR PRIMARY KEY, " + "nome VARCHAR NOT NULL, "
				+ "email VARCHAR NOT NULL, " + "senha VARCHAR NOT NULL, " + "telefone VARCHAR, "
				+ "carroPlaca VARCHAR");
	}

	public ArrayList<Cliente> buscarTodos() throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rs = Banco.conexao.prepareStatement("SELECT * FROM clientes").executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente(rs.getString("CPF"), rs.getString("nome"), rs.getString("email"),
					rs.getString("senha"), rs.getString("telefone"), rs.getString("carroPlaca"));
			clientes.add(cliente);
		}

		return clientes;
	}

	public Cliente buscarPrimeiro(String CPF) throws SQLException {
		ResultSet rs = Banco.conexao.prepareStatement("SELECT * FROM clientes WHERE CPF = '" + CPF + "'")
				.executeQuery();

		return criarCliente(rs);
	}

	public Cliente login(String email, String senha) throws SQLException {
		ResultSet rs = Banco.conexao
				.prepareStatement(
						"SELECT * FROM clientes WHERE email = '" + email + "' AND " + " senha = '" + senha + "'")
				.executeQuery();

		return criarCliente(rs);
	}

	public void inserir(Cliente cliente) throws SQLException {
		Banco.conexao.createStatement()
				.execute("INSERT INTO clientes(CPF, nome, email, senha, telefone) VALUES (" + "'" + cliente.getCPF()
						+ "'," + "'" + cliente.getNome() + "'," + "'" + cliente.getEmail() + "'," + "'"
						+ cliente.getSenha() + "'," + "'" + cliente.getTelefone() + "'" + ")");
	}

	public void devolverCarro(Cliente cliente) throws SQLException {
		Banco.conexao.createStatement()
				.execute("UPDATE carros SET clienteCPF = NULL WHERE placa = '" + cliente.getCarroPlaca() + "'");
	}

	public void alugarCarro(Cliente cliente, Carro carro) throws SQLException {
		devolverCarro(cliente);

		Banco.conexao.createStatement().execute(
				"UPDATE clientes SET carroPlaca = '" + carro.getPlaca() + "' WHERE CPF = '" + cliente.getCPF() + "'");
		Banco.conexao.createStatement().execute(
				"UPDATE carros SET clienteCPF = '" + cliente.getCPF() + "' WHERE placa = '" + carro.getPlaca() + "'");
	}

	public void atualizarCliente(String CPF, String coluna, String novoValor) throws SQLException {
		Banco.conexao.createStatement()
				.execute("UPDATE clientes SET " + coluna + " = '" + novoValor + "' WHERE CPF = '" + CPF + "'");
	}

	private Cliente criarCliente(ResultSet rs) throws SQLException {
		if (rs.next() == false) {
			return null;
		}

		Cliente cliente = new Cliente(rs.getString("CPF"), rs.getString("nome"), rs.getString("email"),
				rs.getString("senha"), rs.getString("telefone"), rs.getString("carroPlaca"));
		return cliente;
	}

}
