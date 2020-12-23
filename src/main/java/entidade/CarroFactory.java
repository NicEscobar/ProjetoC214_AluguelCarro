package entidade;

public class CarroFactory {
	
	public static Carro criaCarro(String placa, String modelo, String marca, double aluguel, String clienteCPF){		
		return new Carro(placa, modelo, marca, aluguel, clienteCPF);
	}
	
	public static Carro criaNovoCarro(String placa, String modelo, String marca, double aluguel){		
		return new Carro(placa, modelo, marca, aluguel);
	}	
}
