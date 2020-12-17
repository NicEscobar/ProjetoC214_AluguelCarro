package application;

import entidade.Cliente;

public final class ClienteHolder {

	private Cliente cliente;
	private final static ClienteHolder INSTANCE = new ClienteHolder();

	private ClienteHolder() {
	}

	public static ClienteHolder getInstance() {
	    return INSTANCE;
	  }

	public void setCliente(Cliente c) {
		this.cliente = c;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
}