package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel panelPrimario;
	private JMenuBar menuBar;
	private JMenuItem clientesAlta;
	private JMenu menuClientes;
	private JMenu other;
	private JMenuItem menuSalir;
	private JMenuItem clientesBaja;
	private JMenuItem clientesConsulta;
	

	private JMenu menuProductos;
	private JMenuItem productosAlta;
	private JMenuItem productosBaja;
	private JMenuItem productosConsulta;

	private JToolBar toolBar;
	private JButton clientesAlta_1;
	private JButton clientesBaja_1;
	private JButton clientesConsulta_1;
	private JButton productosAlta_1;
	private JButton productosBaja_1;
	private JButton productosConsulta_1;

	/**
	 * Create the frame.
	 * 
	 * @param clientes
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		panelPrimario = new JPanel();
		panelPrimario.setBorder(new EmptyBorder(0, 0, 0, 0));

		creacionMenu();

		setContentPane(panelPrimario);
		panelPrimario.setLayout(new BorderLayout(0, 0));

		creacionBarra();
	}

	public void creacionBarra() {
		toolBar = new JToolBar();
		toolBar.setBorder(null);
		toolBar.setBorderPainted(false);
		panelPrimario.add(toolBar, BorderLayout.NORTH);

		clientesAlta_1 = new JButton("");

		clientesAlta_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/altaUsuario.png")));
		toolBar.add(clientesAlta_1);

		clientesBaja_1 = new JButton("");

		clientesBaja_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/bajaUsuario.png")));

		toolBar.add(clientesBaja_1);

		clientesConsulta_1 = new JButton("");

		clientesConsulta_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/modificarUsuario.png")));
		toolBar.add(clientesConsulta_1);

		toolBar.addSeparator();

		productosAlta_1 = new JButton("");
		productosAlta_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/altaProducto.png")));
		toolBar.add(productosAlta_1);

		productosBaja_1 = new JButton("");
		productosBaja_1
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-sin-existencias-60.png")));
		toolBar.add(productosBaja_1);

		productosConsulta_1 = new JButton("");
		productosConsulta_1
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-caja-llena-60.png")));
		toolBar.add(productosConsulta_1);
	}

	public void creacionMenu() {
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		setJMenuBar(menuBar);

		other = new JMenu("");
		other.setFocusPainted(false);

		other.putClientProperty(JMenu.class, new Color(0, 0, 0, 0));

		other.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-ms-word-30.png")));
		menuBar.add(other);

		menuSalir = new JMenuItem("Salir");
		menuSalir.setContentAreaFilled(false);
		other.add(menuSalir);

		menuClientes = new JMenu("Clientes");
		menuClientes.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		menuClientes.setBorder(null);
		menuBar.add(menuClientes);

		clientesAlta = new JMenuItem("Alta");

		clientesAlta.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-añadir-usuario-masculino-30.png")));
		menuClientes.add(clientesAlta);

		clientesBaja = new JMenuItem("Baja");
		clientesBaja.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-denied-30.png")));
		menuClientes.add(clientesBaja);

		clientesConsulta = new JMenuItem("Consulta");
		clientesConsulta.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-editar-usuario-masculino-30.png")));
		menuClientes.add(clientesConsulta);

		menuProductos = new JMenu("Productos");
		menuProductos.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		menuBar.add(menuProductos);

		productosAlta = new JMenuItem("Alta");
		productosAlta
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-producto-nuevo-30.png")));
		menuProductos.add(productosAlta);

		productosBaja = new JMenuItem("Baja");
		productosBaja
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-sin-existencias-30.png")));
		menuProductos.add(productosBaja);

		productosConsulta = new JMenuItem("Consulta");
		productosConsulta
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons8-caja-llena-30.png")));
		menuProductos.add(productosConsulta);
	}

	public JPanel getPanelPrimario() {
		return panelPrimario;
	}

	public JMenuItem getClientesAlta() {
		return clientesAlta;
	}

	public JMenuItem getClientesBaja() {
		return clientesBaja;
	}
	
	public JMenuItem getClientesConsulta() {
		return clientesConsulta;
	}
	
}
