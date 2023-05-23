package controlador;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Cliente;
import modelo.modeloCliente;
import vista.ConsultaCliente;
import vista.VentanaPrincipal;

public class ControladorConsultaClientes implements ListSelectionListener, ActionListener {

	private ConsultaCliente consultaCliente;
	private modeloCliente modCliente = new modeloCliente();

	public ControladorConsultaClientes(VentanaPrincipal ventana) {

		if (modCliente.getListaClientes().size() == 0) {
			JOptionPane.showMessageDialog(ventana, "NO TIENES CLIENTES, AÑADE UNO");
		} else {

			consultaCliente = new ConsultaCliente();
			consultaCliente.getListmodel().addAll(modCliente.extraerNombreClientes());
			consultaCliente.getList().addListSelectionListener(this);
			consultaCliente.getOkButton().addActionListener(this);
			consultaCliente.setModalityType(ModalityType.APPLICATION_MODAL);
			consultaCliente.setLocationRelativeTo(ventana);
			consultaCliente.setVisible(true);

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getSource() == consultaCliente.getList()) {
			int i = consultaCliente.getList().getSelectedIndex();
			consultaCliente.getDni().setText(modCliente.getListaClientes().get(i).getDni());
			consultaCliente.getNombre().setText(modCliente.getListaClientes().get(i).getNombre());
			consultaCliente.getTelefono().setText(modCliente.getListaClientes().get(i).getTelefono());
			// ez pz
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		consultaCliente.dispose();

	}

}
