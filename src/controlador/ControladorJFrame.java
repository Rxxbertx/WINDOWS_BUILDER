package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.modeloCliente;

import vista.VentanaPrincipal;

public class ControladorJFrame implements ActionListener {

	private VentanaPrincipal ventana;
//	private AñadirCliente dialogoAltaCliente;

	public ControladorJFrame() {

		ventana = new VentanaPrincipal();
		ventana.setVisible(true);

		// sumar listener
		ventana.getClientesAlta().addActionListener(this);
		ventana.getClientesBaja().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// si se a pulsado la opcion cliente ALTA
		if (e.getSource() == ventana.getClientesAlta()) {
			// dialogoAltaCliente = new AñadirCliente();
			// dialogoAltaCliente.setVisible(true);
			// dialogoAltaCliente.setLocationRelativeTo(ventana);
			try {
				 new ControladorJDialog(ventana);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
			System.out.println(modeloCliente.getListaClientes().toString());
		}
		if (e.getSource()==ventana.getClientesBaja()) {
			System.out.println("ahdofklasdfj");
		}

	}

}
