package database;

import java.sql.*;

public class Banco {

	static Connection conexao;

	public static void conectar(String nome) {
		try {
			conexao = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			System.out.println("Conex�o realizada !!!!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void desconectar() {
		try {
			conexao.close();
			System.out.println("Conex�o finalizada !!!!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
