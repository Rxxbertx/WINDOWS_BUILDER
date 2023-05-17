package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;

import java.awt.Color;
import modelo.Cliente;

public class ConsultaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel dni;
	private JLabel nombre;
	private JLabel telefono;
	private JButton okButton;
	private DefaultListModel<String> listmodel;
	private JList list;

	/**
	 * Create the dialog.
	 */
	public ConsultaCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		listmodel = new DefaultListModel<>();

		list = new JList(listmodel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(list);

		contentPanel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel labelDni = new JLabel("DNI:  ");
		labelDni.setHorizontalTextPosition(SwingConstants.CENTER);
		labelDni.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelDni);

		dni = new JLabel("");
		dni.setHorizontalTextPosition(SwingConstants.CENTER);
		dni.setForeground(Color.RED);
		dni.setOpaque(true);
		dni.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(dni);

		JLabel labelNombre = new JLabel("NOMBRE:  ");
		labelNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelNombre);

		nombre = new JLabel("");
		nombre.setForeground(Color.RED);
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(nombre);

		JLabel labelTelefono = new JLabel("TELEFONO:  ");
		labelTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelTelefono);

		telefono = new JLabel("");
		telefono.setForeground(Color.RED);
		telefono.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(telefono);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}

	public JLabel getDni() {
		return dni;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public JLabel getTelefono() {
		return telefono;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public DefaultListModel<String> getListmodel() {
		return listmodel;
	}

	public JList getList() {
		return list;
	}

	public void setDni(JLabel dni) {
		this.dni = dni;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(JLabel telefono) {
		this.telefono = telefono;
	}

}
