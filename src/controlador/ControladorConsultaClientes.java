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
	private modeloCliente temp = new modeloCliente();

	public ControladorConsultaClientes(VentanaPrincipal ventana) {

		if (temp.getListaClientes().size() == 0) {
			JOptionPane.showMessageDialog(ventana, "NO TIENES CLIENTES, AÑADE UNO");
		} else {

			consultaCliente = new ConsultaCliente();
			consultaCliente.getListmodel().addAll(extraerNombreClientes());
			consultaCliente.getList().addListSelectionListener(this);
			consultaCliente.getOkButton().addActionListener(this);
			consultaCliente.setModalityType(ModalityType.APPLICATION_MODAL);
			consultaCliente.setLocationRelativeTo(ventana);
			consultaCliente.setVisible(true);

		}

	}

	public List<String> extraerNombreClientes() {
		List<String> clientesNombre = new ArrayList<>();

		for (Cliente cliente : temp.getListaClientes()) {
			clientesNombre.add(cliente.getNombre());
		}
		return clientesNombre;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getSource() == consultaCliente.getList()) {
			int i = consultaCliente.getList().getSelectedIndex();
			consultaCliente.getDni().setText(temp.getListaClientes().get(i).getDni());
			consultaCliente.getNombre().setText(temp.getListaClientes().get(i).getNombre());
			consultaCliente.getTelefono().setText(temp.getListaClientes().get(i).getTelefono());
			//ez pz 
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		consultaCliente.dispose();

	}

}
