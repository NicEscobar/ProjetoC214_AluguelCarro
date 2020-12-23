package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import holder.BancoHolder;

public abstract class TableManager<T> {

	protected Connection conexao;
	public abstract ArrayList<T> buscarTodos() throws SQLException;
	public abstract T buscarPrimeiro(String valor) throws SQLException;
	public abstract void inserir(T data) throws SQLException;
	
	TableManager (Connection conexao, String query) {
		this.conexao = conexao;
		criarTabela(query);
	}
	
	private void criarTabela(String query) {
		try {			
			conexao.createStatement().execute(query);
		} catch (SQLException e) {
			System.out.print("Failed to create table: " + e);
		}
	}
}
