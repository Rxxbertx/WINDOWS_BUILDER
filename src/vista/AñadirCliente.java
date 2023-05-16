package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class AñadirCliente extends JDialog {

	private JPanel contentPanel = new JPanel();

	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoTelefono;
	private JButton btAceptar;
	private JButton btCancelar;

	private JPanel buttonPane;

	/**
	 * Create the dialog.
	 */
	public AñadirCliente() {


		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(46, 40, 128, 22);
		contentPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(46, 102, 128, 22);
		contentPanel.add(lblNombre);

		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefono.setBounds(46, 164, 128, 22);
		contentPanel.add(lblTelefono);

		campoDni = new JTextField();
		campoDni.setBounds(153, 40, 128, 22);
		contentPanel.add(campoDni);
		campoDni.setColumns(10);

		campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(153, 102, 128, 22);
		contentPanel.add(campoNombre);

		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(153, 164, 128, 22);
		contentPanel.add(campoTelefono);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btAceptar = new JButton("Aceptar");
		btAceptar.setActionCommand("OK");
		buttonPane.add(btAceptar);

		btCancelar = new JButton("Cancelar");

		buttonPane.add(btCancelar);

	}

	// method para agregar listener a los botones

	public JButton getBtAceptar() {
		return btAceptar;
	}

	public JButton getBtCancelar() {
		return btCancelar;
	}

	public JTextField getCampoDni() {
		return campoDni;
	}

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public JTextField getCampoTelefono() {
		return campoTelefono;
	}
}
