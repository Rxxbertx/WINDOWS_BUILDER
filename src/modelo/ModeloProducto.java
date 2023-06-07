package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/**
 * Clase que representa el modelo de datos para los productos.
 */
public class ModeloProducto {

	private static HashMap<Integer, Producto> almacenProductos = new HashMap<>();
	private static String[] categorias = { "Alimentacion", "Drogueria", "Juguetes", "Bebidas" };
	private static String[] cabeceraTabla = { "Id", "Nombre", "Cantidad", "Categoria", "Precio" };

	/**
	 * Constructor de la clase ModeloProducto.
	 */
	public ModeloProducto() {
		Random random = new Random();

		for (int i = 1; i <= 100; i++) {
			int id = random.nextInt(900) + 100; // Generar un ID de 3 dígitos
			String nombre = "Producto " + i;
			int cantidad = random.nextInt(100) + 1;

			int entero = random.nextInt(100); // Número entero aleatorio
			int decimal = random.nextInt(100); // Número decimal aleatorio
			float precio = Float.parseFloat(entero + "." + decimal);

			String categoria = categorias[random.nextInt(categorias.length)];

			Producto producto = new Producto(id, nombre, categoria, cantidad, precio);
			almacenProductos.put(id, producto);
		}

	}

	/**
	 * Añade un producto al almacenProductos.
	 * 
	 * @param producto El producto a añadir.
	 */
	public void añadirProducto(Producto producto) {
		almacenProductos.put(producto.getId(), producto);
	}

	/**
	 * Elimina un producto del almacenProductos.
	 * 
	 * @param producto El producto a eliminar.
	 */
	public void borrarProducto(Producto producto) {
		almacenProductos.remove(producto.getId());
	}

	/**
	 * Obtiene el almacen de productos.
	 * 
	 * @return El almacen de productos.
	 */
	public static HashMap<Integer, Producto> getAlmacenProductos() {
		return almacenProductos;
	}

	/**
	 * Obtiene las categorías de productos.
	 * 
	 * @return Las categorías de productos.
	 */
	public static String[] getCategorias() {
		return categorias;
	}

	/**
	 * Establece las categorías de productos.
	 * 
	 * @param categorias Las categorías de productos a establecer.
	 */
	public static void setCategorias(String[] categorias) {
		ModeloProducto.categorias = categorias;
	}

	/**
	 * Obtiene los nombres de los productos en el almacen.
	 * 
	 * @return Una lista de nombres de productos.
	 */
	public ArrayList<String> nombreProductos() {
		ArrayList<String> nombres = new ArrayList<>();
		for (Entry<Integer, Producto> entry : almacenProductos.entrySet()) {
			nombres.add(entry.getValue().getNombre() + " (" + entry.getKey() + ")");
		}
		return nombres;
	}

	public static String[] getCabeceraTabla() {
		return cabeceraTabla;
	}

	public static void setCabeceraTabla(String[] cabeceraTabla) {
		ModeloProducto.cabeceraTabla = cabeceraTabla;
	}
}
