package entidade;

public class Carro {

	private String modelo, marca, placa, clienteCPF;
	private double aluguel;

	public Carro(String placa, String modelo, String marca, double aluguel, String clienteCPF) {
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.clienteCPF = clienteCPF;
		this.aluguel = aluguel;
	}

	public Carro(String placa, String modelo, String marca, double aluguel) {
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.aluguel = aluguel;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getPlaca() {
		return placa;
	}

	public String getClienteCPF() {
		return clienteCPF;
	}

	public double getAluguel() {
		return aluguel;
	}

	@Override
	public String toString() {
		return "Carro: \n" + "Modelo: " + modelo + "\n" + "Marca: " + marca + "\n" + "Placa: " + placa + "\n"
				+ "Modelo: " + modelo + "\n" + "Alguel: " + aluguel + "\n" + "Cliente: " + clienteCPF;
	}

}
