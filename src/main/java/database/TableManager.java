package database;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class TableManager<T> {

	public abstract ArrayList<T> buscarTodos() throws SQLException;
	public abstract T buscarPrimeiro(String valor) throws SQLException;
	public abstract void inserir(T data) throws SQLException;
	
	TableManager (String query) {
		criarTabela(query);
	}
	
	private void criarTabela(String query) {
		try {			
			Banco.conexao.createStatement().execute(query);
		} catch (SQLException e) {
			System.out.print("Failed to create table: " + e);
		}
	}
}
