package modelo;

public class Producto {

	private int id;
	private String nombre;
	private String categoria;
	private int cantidad;
	private float precio;
	
	
	
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param categoria
	 * @param cantidad
	 * @param precio
	 */
	public Producto(int id, String nombre, String categoria, int cantidad, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
	}





	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}





	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}





	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}





	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}





	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}





	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}





	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}





	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
}
