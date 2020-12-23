package database;

import java.sql.*;

public class Banco {

	public Connection conexao;

	public void conectar(String nome) {
		try {
			conexao = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			System.out.println("Conex�o realizada !!!!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void desconectar() {
		if (conexao == null) return;
		try {
			conexao.close();
			conexao = null;
			System.out.println("Conex�o finalizada !!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
