package controlador;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import modelo.Cliente;
import modelo.modeloCliente;
import vista.AñadirCliente;
import vista.VentanaPrincipal;

public class ControladorJDialog implements ActionListener {

	private AñadirCliente dialogoAltaCliente;

	public ControladorJDialog(JFrame ventana) {

		dialogoAltaCliente = new AñadirCliente();
		dialogoAltaCliente.setLocationRelativeTo(ventana);
		dialogoAltaCliente.setModalityType(ModalityType.APPLICATION_MODAL);
		dialogoAltaCliente.getBtAceptar().addActionListener(this);
		dialogoAltaCliente.getBtCancelar().addActionListener(this);
		dialogoAltaCliente.setVisible(true);

	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == dialogoAltaCliente.getBtCancelar()) {
			dialogoAltaCliente.setVisible(false);
		}

		if (e.getSource() == dialogoAltaCliente.getBtAceptar()) {

			if (dialogoAltaCliente.getCampoDni().getText().isEmpty()
					| dialogoAltaCliente.getCampoTelefono().getText().isEmpty()
					| dialogoAltaCliente.getCampoNombre().getText().isEmpty()) {

			} else {
				Cliente cliente = new Cliente(dialogoAltaCliente.getCampoNombre().getText(),
						dialogoAltaCliente.getCampoDni().getText(), dialogoAltaCliente.getCampoTelefono().getText());

				modeloCliente temp = new modeloCliente();
				temp.añadirCliente(cliente);
				dialogoAltaCliente.dispose();

			}

		}

	}

}
