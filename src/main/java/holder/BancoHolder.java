package holder;

import database.Banco;
import database.CarroManager;
import database.ClienteManager;

public final class BancoHolder {

	private Banco banco;
	private final static BancoHolder INSTANCE = new BancoHolder();
	
	private CarroManager carroManager;
	private ClienteManager clienteManager;
	
	public CarroManager getCarroManager() {
		return carroManager;
	}

	public ClienteManager getClienteManager() {
		return clienteManager;
	}

	private BancoHolder() {
	}

	public static BancoHolder getInstance() {
	    return INSTANCE;
	  }

	public void criarBanco(String b) {
		this.banco = new Banco();
		this.banco.conectar(b);
		
		this.clienteManager = new ClienteManager();
		this.carroManager = new CarroManager();
	}

	public Banco getBanco() {
		return this.banco;
	}
}
