package model.entities;

public class Cliente {

	private String nome, email, senha, CPF, telefone, carroPlaca;

	public Cliente(String CPF, String nome, String email, String senha, String telefone, String carroPlaca) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.telefone = telefone;
		this.carroPlaca = carroPlaca;
	}

	public Cliente(String CPF, String nome, String email, String senha, String telefone) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCPF() {
		return CPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCarroPlaca() {
		return carroPlaca;
	}

	@Override
	public String toString() {
		return "Cliente: " + "Nome: " + nome + "\n" + "CPF: " + CPF + "\n" + "Email: " + email + "\n" + "Telefone: "
				+ telefone + "\n" + "Carro: " + carroPlaca;
	}

}
