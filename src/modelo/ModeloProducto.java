package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ModeloProducto {

	private static HashMap<Integer, Producto> almacenProductos = new HashMap<>();
	private static String[] categorias = { "Alimentacion", "Drogueria", "Juguetes", "Bebidas" };

	public ModeloProducto() {
		// TODO Auto-generated constructor stub
	}

	public void añadirProducto(Producto producto) {

		almacenProductos.put(producto.getId(), producto);

	}

	public void modificarProducto(Producto producto, Producto productoViejo) {

		if (producto.getId() == productoViejo.getId()) {

			almacenProductos.replace(producto.getId(), producto);
		} else {
			almacenProductos.remove(productoViejo.getId());
			almacenProductos.put(producto.getId(), producto);
		}

	}

	public void borrarProducto(Producto producto) {
		almacenProductos.remove(producto.getId());
	}

	/**
	 * @return the almacenProductos
	 */
	public static HashMap<Integer, Producto> getAlmacenProductos() {
		return almacenProductos;
	}

	/**
	 * @return the categorias
	 */
	public static String[] getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public static void setCategorias(String[] categorias) {
		ModeloProducto.categorias = categorias;
	}

	public ArrayList<String> nombreProductos() {

		ArrayList<String> nombres = new ArrayList<>();

		for (Entry<Integer, Producto> entry : almacenProductos.entrySet()) {

			nombres.add(entry.getValue().getNombre() + " (" + entry.getKey() + ")");

		}

		return nombres;

	}

}
