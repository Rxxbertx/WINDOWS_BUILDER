package modelo;

import java.util.ArrayList;

public class modeloCliente {

	private static ArrayList<Cliente> listaClientes = new ArrayList<>();

	
		
	public  void añadirCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}

	public  void eliminarCliente(Cliente cliente) {
		listaClientes.remove(cliente);
	}

	public  ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

}
