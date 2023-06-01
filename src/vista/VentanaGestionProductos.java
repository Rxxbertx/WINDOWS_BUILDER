package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaGestionProductos extends JDialog {
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldCantidad;
	private JTextField textFieldId2;
	private JTextField textFieldNombre2;
	private JTable table;

	

	public VentanaGestionProductos() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 559, 396);
		getContentPane().setLayout(null);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBorder(new MatteBorder(0, 0, 0, 4, (Color) Color.DARK_GRAY));
		panelIzq.setBackground(SystemColor.textHighlight);
		panelIzq.setBounds(0, 0, 159, 357);
		getContentPane().add(panelIzq);
		panelIzq.setLayout(null);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		btnAlta.setBounds(35, 44, 89, 28);
		panelIzq.add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		btnBaja.setBounds(35, 109, 89, 28);
		panelIzq.add(btnBaja);
		
		JSeparator separator = new JSeparator();
		separator.setEnabled(false);
		separator.setSize(new Dimension(3, 2));
		separator.setBounds(0, 187, 159, 2);
		panelIzq.add(separator);
		separator.setOpaque(true);
		separator.setBorder(new EmptyBorder(0, 0, 0, 0));
		separator.setRequestFocusEnabled(false);
		separator.setForeground(Color.RED);
		separator.setBackground(Color.DARK_GRAY);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Calibri", Font.BOLD, 16));
		lblConsulta.setForeground(Color.WHITE);
		lblConsulta.setBounds(46, 220, 66, 16);
		panelIzq.add(lblConsulta);
		
		JRadioButton rdbtnCategoria = new JRadioButton("Categoria");
		rdbtnCategoria.setForeground(Color.WHITE);
		rdbtnCategoria.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		rdbtnCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCategoria.setBounds(35, 255, 89, 18);
		panelIzq.add(rdbtnCategoria);
		
		JRadioButton rdbtnStock = new JRadioButton("Stock Bajo");
		rdbtnStock.setForeground(Color.WHITE);
		rdbtnStock.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		rdbtnStock.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnStock.setBounds(35, 284, 89, 18);
		panelIzq.add(rdbtnStock);
		
		JPanel panelCard = new JPanel();
		panelCard.setBackground(Color.DARK_GRAY);
		panelCard.setBounds(159, 0, 384, 357);
		getContentPane().add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));
		
		JPanel panelinicio = new JPanel();
		panelinicio.setBackground(Color.DARK_GRAY);
		panelCard.add(panelinicio, "panelInicio");
		panelinicio.setLayout(null);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(VentanaGestionProductos.class.getResource("/images/icons8-caja-llena-60.png")));
		icono.setBounds(162, 149, 60, 105);
		panelinicio.add(icono);
		
		JLabel lblTuEmpresa = new JLabel("Tu empresa");
		lblTuEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTuEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuEmpresa.setForeground(Color.WHITE);
		lblTuEmpresa.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblTuEmpresa.setAlignmentY(0.5f);
		lblTuEmpresa.setAlignmentX(0.5f);
		lblTuEmpresa.setBounds(77, 122, 229, 36);
		panelinicio.add(lblTuEmpresa);
		
		JPanel panelAlta = new JPanel();
		panelAlta.setBackground(Color.DARK_GRAY);
		panelCard.add(panelAlta, "panelAlta");
		panelAlta.setLayout(null);
		
		JLabel lblid = new JLabel("Id");
		lblid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblid.setForeground(Color.WHITE);
		lblid.setBounds(73, 64, 75, 16);
		panelAlta.add(lblid);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(73, 113, 75, 16);
		panelAlta.add(lblNombre);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setBounds(73, 155, 75, 16);
		panelAlta.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(73, 201, 75, 16);
		panelAlta.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(73, 249, 75, 16);
		panelAlta.add(lblCantidad);
		
		textFieldId = new JTextField();
		textFieldId.setForeground(Color.WHITE);
		textFieldId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldId.setBackground(Color.DARK_GRAY);
		textFieldId.setBounds(160, 64, 122, 16);
		panelAlta.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.WHITE);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldNombre.setBackground(Color.DARK_GRAY);
		textFieldNombre.setBounds(160, 113, 122, 16);
		panelAlta.add(textFieldNombre);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setForeground(Color.WHITE);
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldPrecio.setBackground(Color.DARK_GRAY);
		textFieldPrecio.setBounds(160, 201, 122, 16);
		panelAlta.add(textFieldPrecio);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setForeground(Color.WHITE);
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldCantidad.setBackground(Color.DARK_GRAY);
		textFieldCantidad.setBounds(160, 249, 122, 16);
		panelAlta.add(textFieldCantidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(160, 153, 122, 21);
		panelAlta.add(comboBox);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnGuardar.setBackground(SystemColor.textHighlight);
		btnGuardar.setBounds(28, 306, 90, 28);
		panelAlta.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnCancelar.setBackground(SystemColor.textHighlight);
		btnCancelar.setBounds(146, 306, 90, 28);
		panelAlta.add(btnCancelar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir.setBackground(SystemColor.textHighlight);
		btnSalir.setBounds(264, 306, 90, 28);
		panelAlta.add(btnSalir);
		
		JPanel panelBaja = new JPanel();
		panelBaja.setBackground(Color.DARK_GRAY);
		panelCard.add(panelBaja, "panelBaja");
		panelBaja.setLayout(null);
		
		JComboBox comboBoxProductos = new JComboBox();
		comboBoxProductos.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBoxProductos.setBounds(86, 26, 212, 26);
		panelBaja.add(comboBoxProductos);
		
		JLabel lblid2 = new JLabel("Id");
		lblid2.setForeground(Color.WHITE);
		lblid2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblid2.setBounds(86, 170, 75, 16);
		panelBaja.add(lblid2);
		
		JLabel lblNombre2 = new JLabel("Nombre");
		lblNombre2.setForeground(Color.WHITE);
		lblNombre2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNombre2.setBounds(86, 198, 75, 16);
		panelBaja.add(lblNombre2);
		
		JLabel lblCategoria2 = new JLabel("Categoria");
		lblCategoria2.setForeground(Color.WHITE);
		lblCategoria2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCategoria2.setBounds(86, 238, 75, 16);
		panelBaja.add(lblCategoria2);
		
		textFieldId2 = new JTextField();
		textFieldId2.setForeground(Color.WHITE);
		textFieldId2.setColumns(10);
		textFieldId2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldId2.setBackground(Color.DARK_GRAY);
		textFieldId2.setBounds(176, 170, 122, 16);
		panelBaja.add(textFieldId2);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setForeground(Color.WHITE);
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldNombre2.setBackground(Color.DARK_GRAY);
		textFieldNombre2.setBounds(176, 198, 122, 16);
		panelBaja.add(textFieldNombre2);
		
		JComboBox comboBoxCategoria2 = new JComboBox();
		comboBoxCategoria2.setForeground(Color.BLACK);
		comboBoxCategoria2.setBackground(Color.WHITE);
		comboBoxCategoria2.setBounds(176, 236, 122, 21);
		panelBaja.add(comboBoxCategoria2);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(SystemColor.textHighlight);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnBorrar.setBounds(28, 299, 90, 28);
		panelBaja.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(SystemColor.textHighlight);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnModificar.setBounds(146, 299, 90, 28);
		panelBaja.add(btnModificar);
		
		JButton btnSalir2 = new JButton("Salir");
		btnSalir2.setBackground(SystemColor.textHighlight);
		btnSalir2.setForeground(Color.WHITE);
		btnSalir2.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir2.setBounds(264, 299, 90, 28);
		panelBaja.add(btnSalir2);
		
		JPanel panelConsulta = new JPanel();
		panelConsulta.setBackground(Color.DARK_GRAY);
		panelCard.add(panelConsulta, "panelConsulta");
		panelConsulta.setLayout(null);
		
		JLabel lblCategoria3 = new JLabel("CATEGORIA");
		lblCategoria3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCategoria3.setForeground(Color.WHITE);
		lblCategoria3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCategoria3.setBounds(151, 32, 82, 16);
		panelConsulta.add(lblCategoria3);
		
		JComboBox comboBoxCategoriaConsulta = new JComboBox();
		comboBoxCategoriaConsulta.setBounds(95, 52, 193, 26);
		panelConsulta.add(comboBoxCategoriaConsulta);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 91, 331, 179);
		panelConsulta.add(scrollPane);
		
		JButton btnSalir3 = new JButton("Salir");
		btnSalir3.setForeground(Color.WHITE);
		btnSalir3.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir3.setBackground(SystemColor.textHighlight);
		btnSalir3.setBounds(147, 296, 90, 28);
		panelConsulta.add(btnSalir3);
		
		
		
		
		
		
		
		
	}
}
