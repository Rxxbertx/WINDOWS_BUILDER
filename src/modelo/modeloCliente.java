package modelo;

import java.util.ArrayList;

public class modeloCliente {

	private static ArrayList<Cliente> listaClientes = new ArrayList<>();


	public static void añadirCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}

	public static void eliminarCliente(Cliente cliente) {
		listaClientes.remove(cliente);
	}

	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

}
