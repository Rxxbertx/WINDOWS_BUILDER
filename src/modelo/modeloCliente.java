package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloCliente {

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
	
	public List<String> extraerNombreClientes() {
		List<String> clientesNombre = new ArrayList<>();

		for (Cliente cliente : getListaClientes()) {
			clientesNombre.add(cliente.getNombre());
		}
		return clientesNombre;
	}
	

}
