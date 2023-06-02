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
import javax.swing.event.ListDataListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

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
	private JButton btnAlta;
	private JButton btnBaja;
	private ButtonGroup radioGroup;
	private JComboBox<String> comboBoxCategorias;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnSalir;
	private JComboBox<String> comboBoxProductos;
	private JComboBox<String> comboBoxCategoria2;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnSalir2;
	private JButton btnSalir3;
	private JPanel panelCard;
	private JRadioButton rdbtnStock;
	private JRadioButton rdbtnCategoria;
	private DefaultComboBoxModel<String> datosCombo = new DefaultComboBoxModel<>();
	private JLabel lblPrecio2;
	private JLabel lblCantidad2;
	private JTextField textFieldPrecio2;
	private JTextField textFieldCantidad2;

	public VentanaGestionProductos() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 559, 396);
		getContentPane().setLayout(null);

		JPanel panelIzq = new JPanel();
		panelIzq.setBorder(new MatteBorder(0, 0, 0, 4, (Color) Color.DARK_GRAY));
		panelIzq.setBackground(new Color(30, 144, 255));
		panelIzq.setBounds(0, 0, 159, 357);
		getContentPane().add(panelIzq);
		panelIzq.setLayout(null);

		btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		btnAlta.setBounds(35, 44, 89, 28);
		panelIzq.add(btnAlta);

		btnBaja = new JButton("Baja");
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
		lblConsulta.setBounds(35, 220, 89, 16);
		panelIzq.add(lblConsulta);

		radioGroup = new ButtonGroup();

		rdbtnCategoria = new JRadioButton("Categoria");
		rdbtnCategoria.setForeground(Color.WHITE);
		rdbtnCategoria.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		rdbtnCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCategoria.setBounds(35, 255, 89, 18);
		panelIzq.add(rdbtnCategoria);

		rdbtnStock = new JRadioButton("Stock Bajo");
		rdbtnStock.setForeground(Color.WHITE);
		rdbtnStock.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		rdbtnStock.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnStock.setBounds(35, 284, 89, 18);
		panelIzq.add(rdbtnStock);

		radioGroup.add(rdbtnStock);
		radioGroup.add(rdbtnCategoria);

		panelCard = new JPanel();
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

		comboBoxCategorias = new JComboBox();
		comboBoxCategorias.setForeground(Color.BLACK);
		comboBoxCategorias.setBackground(Color.WHITE);
		comboBoxCategorias.setBounds(160, 153, 122, 21);
		panelAlta.add(comboBoxCategorias);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnGuardar.setBackground(new Color(30, 144, 255));
		btnGuardar.setBounds(28, 306, 90, 28);
		panelAlta.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnCancelar.setBackground(new Color(30, 144, 255));
		btnCancelar.setBounds(146, 306, 90, 28);
		panelAlta.add(btnCancelar);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir.setBackground(new Color(30, 144, 255));
		btnSalir.setBounds(264, 306, 90, 28);
		panelAlta.add(btnSalir);

		JPanel panelBaja = new JPanel();
		panelBaja.setBackground(Color.DARK_GRAY);
		panelCard.add(panelBaja, "panelBaja");
		panelBaja.setLayout(null);

		comboBoxProductos = new JComboBox(datosCombo);
		comboBoxProductos.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBoxProductos.setBounds(86, 26, 212, 26);
		panelBaja.add(comboBoxProductos);

		JLabel lblid2 = new JLabel("Id");
		lblid2.setForeground(Color.WHITE);
		lblid2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblid2.setBounds(86, 115, 75, 16);
		panelBaja.add(lblid2);

		JLabel lblNombre2 = new JLabel("Nombre");
		lblNombre2.setForeground(Color.WHITE);
		lblNombre2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNombre2.setBounds(86, 143, 75, 16);
		panelBaja.add(lblNombre2);

		JLabel lblCategoria2 = new JLabel("Categoria");
		lblCategoria2.setForeground(Color.WHITE);
		lblCategoria2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCategoria2.setBounds(86, 183, 75, 16);
		panelBaja.add(lblCategoria2);

		textFieldId2 = new JTextField();
		textFieldId2.setForeground(Color.WHITE);
		textFieldId2.setColumns(10);
		textFieldId2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldId2.setBackground(Color.DARK_GRAY);
		textFieldId2.setBounds(176, 115, 122, 16);
		panelBaja.add(textFieldId2);

		textFieldNombre2 = new JTextField();
		textFieldNombre2.setForeground(Color.WHITE);
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldNombre2.setBackground(Color.DARK_GRAY);
		textFieldNombre2.setBounds(176, 143, 122, 16);
		panelBaja.add(textFieldNombre2);

		comboBoxCategoria2 = new JComboBox();
		comboBoxCategoria2.setForeground(Color.BLACK);
		comboBoxCategoria2.setBackground(Color.WHITE);
		comboBoxCategoria2.setBounds(176, 181, 122, 21);
		panelBaja.add(comboBoxCategoria2);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(30, 144, 255));
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnBorrar.setBounds(28, 299, 90, 28);
		panelBaja.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(30, 144, 255));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnModificar.setBounds(139, 299, 106, 28);
		panelBaja.add(btnModificar);

		btnSalir2 = new JButton("Salir");
		btnSalir2.setBackground(new Color(30, 144, 255));
		btnSalir2.setForeground(Color.WHITE);
		btnSalir2.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir2.setBounds(264, 299, 90, 28);
		panelBaja.add(btnSalir2);
		
		lblPrecio2 = new JLabel("Precio");
		lblPrecio2.setForeground(Color.WHITE);
		lblPrecio2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblPrecio2.setBounds(86, 215, 75, 16);
		panelBaja.add(lblPrecio2);
		
		lblCantidad2 = new JLabel("Cantidad");
		lblCantidad2.setForeground(Color.WHITE);
		lblCantidad2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCantidad2.setBounds(86, 253, 75, 16);
		panelBaja.add(lblCantidad2);
		
		textFieldPrecio2 = new JTextField();
		textFieldPrecio2.setForeground(Color.WHITE);
		textFieldPrecio2.setColumns(10);
		textFieldPrecio2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldPrecio2.setBackground(Color.DARK_GRAY);
		textFieldPrecio2.setBounds(176, 215, 122, 16);
		panelBaja.add(textFieldPrecio2);
		
		textFieldCantidad2 = new JTextField();
		textFieldCantidad2.setForeground(Color.WHITE);
		textFieldCantidad2.setColumns(10);
		textFieldCantidad2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)));
		textFieldCantidad2.setBackground(Color.DARK_GRAY);
		textFieldCantidad2.setBounds(176, 253, 122, 16);
		panelBaja.add(textFieldCantidad2);

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

		btnSalir3 = new JButton("Salir");
		btnSalir3.setForeground(Color.WHITE);
		btnSalir3.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir3.setBackground(SystemColor.textHighlight);
		btnSalir3.setBounds(147, 296, 90, 28);
		panelConsulta.add(btnSalir3);

	}

	/**
	 * @return the textFieldId
	 */
	public JTextField getTextFieldId() {
		return textFieldId;
	}

	/**
	 * @return the textFieldNombre
	 */
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	/**
	 * @return the textFieldPrecio
	 */
	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}

	/**
	 * @return the textFieldCantidad
	 */
	public JTextField getTextFieldCantidad() {
		return textFieldCantidad;
	}

	/**
	 * @return the textFieldId2
	 */
	public JTextField getTextFieldId2() {
		return textFieldId2;
	}

	/**
	 * @return the textFieldNombre2
	 */
	public JTextField getTextFieldNombre2() {
		return textFieldNombre2;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @return the btnAlta
	 */
	public JButton getBtnAlta() {
		return btnAlta;
	}

	/**
	 * @return the btnBaja
	 */
	public JButton getBtnBaja() {
		return btnBaja;
	}

	/**
	 * @return the radioGroup
	 */
	public ButtonGroup getRadioGroup() {
		return radioGroup;
	}

	/**
	 * @return the comboBoxCategorias
	 */
	public JComboBox getComboBoxCategorias() {
		return comboBoxCategorias;
	}

	/**
	 * @return the btnGuardar
	 */
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	/**
	 * @return the btnCancelar
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * @return the btnSalir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * @return the comboBoxProductos
	 */
	public JComboBox getComboBoxProductos() {
		return comboBoxProductos;
	}

	/**
	 * @return the comboBoxCategoria2
	 */
	public JComboBox getComboBoxCategoria2() {
		return comboBoxCategoria2;
	}

	/**
	 * @return the btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	/**
	 * @return the btnModificar
	 */
	public JButton getBtnModificar() {
		return btnModificar;
	}

	/**
	 * @return the btnSalir2
	 */
	public JButton getBtnSalir2() {
		return btnSalir2;
	}

	/**
	 * @return the btnSalir3
	 */
	public JButton getBtnSalir3() {
		return btnSalir3;
	}

	/**
	 * @return the panelCard
	 */
	public JPanel getPanelCard() {
		return panelCard;
	}

	/**
	 * @return the rdbtnStock
	 */
	public JRadioButton getRdbtnStock() {
		return rdbtnStock;
	}

	/**
	 * @param rdbtnStock the rdbtnStock to set
	 */
	public void setRdbtnStock(JRadioButton rdbtnStock) {
		this.rdbtnStock = rdbtnStock;
	}

	/**
	 * @return the rdbtnCategoria
	 */
	public JRadioButton getRdbtnCategoria() {
		return rdbtnCategoria;
	}

	/**
	 * @param rdbtnCategoria the rdbtnCategoria to set
	 */
	public void setRdbtnCategoria(JRadioButton rdbtnCategoria) {
		this.rdbtnCategoria = rdbtnCategoria;
	}

	public void setComboBoxCategorias(JComboBox<String> e) {

		this.comboBoxCategorias = e;

	}

	/**
	 * @return the datosCombo
	 */
	public DefaultComboBoxModel<String> getDatosCombo() {
		return datosCombo;
	}

	/**
	 * @param datosCombo the datosCombo to set
	 */
	public void setDatosCombo(DefaultComboBoxModel<String> datosCombo) {
		this.datosCombo = datosCombo;
	}

	/**
	 * @return the textFieldPrecio2
	 */
	public JTextField getTextFieldPrecio2() {
		return textFieldPrecio2;
	}

	/**
	 * @return the textFieldCantidad2
	 */
	public JTextField getTextFieldCantidad2() {
		return textFieldCantidad2;
	}
}
