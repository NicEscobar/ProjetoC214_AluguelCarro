package entidade;

public class Carro {

	private String modelo,marca,info,placa;
	private int id;
	private boolean alugado;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getInfo() {
		return info;
	}
	public String getPlaca() {
		return placa;
	}
	public int getId() {
		return id;
	}
	public boolean isAlugado() {
		return alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	
	
}
