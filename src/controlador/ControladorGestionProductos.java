package controlador;

import java.awt.CardLayout;
import java.awt.Dialog.ModalityType;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.ModeloProducto;
import modelo.Producto;
import vista.VentanaGestionProductos;
import vista.VentanaPrincipal;

public class ControladorGestionProductos implements ActionListener, ItemListener, ChangeListener {

	private VentanaGestionProductos ventanaProducto;
	private ModeloProducto modeloProducto;;

	public ControladorGestionProductos(VentanaPrincipal ventana) {

		ventanaProducto = new VentanaGestionProductos();
		modeloProducto = new ModeloProducto();

		ventanaProducto.setLocationRelativeTo(ventana);
		ventanaProducto.setModalityType(ModalityType.APPLICATION_MODAL);
		//
		ventanaProducto.getBtnAlta().addActionListener(this);
		ventanaProducto.getBtnBaja().addActionListener(this);
		ventanaProducto.getBtnCancelar().addActionListener(this);
		ventanaProducto.getBtnBorrar().addActionListener(this);
		ventanaProducto.getBtnGuardar().addActionListener(this);
		ventanaProducto.getBtnModificar().addActionListener(this);
		ventanaProducto.getBtnSalir().addActionListener(this);
		ventanaProducto.getBtnSalir2().addActionListener(this);
		ventanaProducto.getBtnSalir3().addActionListener(this);
		//
		ventanaProducto.getRdbtnCategoria().addChangeListener(this);
		ventanaProducto.getRdbtnStock().addChangeListener(this);
		//
		ventanaProducto.getComboBoxCategorias().addItemListener(this);
		//
		ventanaProducto.getComboBoxProductos().addItemListener(this);
		//
		ventanaProducto.getComboBoxCategorias().setModel(new DefaultComboBoxModel<>(modeloProducto.getCategorias()));
		ventanaProducto.getComboBoxCategoria2().setModel(new DefaultComboBoxModel<>(modeloProducto.getCategorias()));

		ventanaProducto.getDatosCombo().addAll(modeloProducto.nombreProductos());

		ventanaProducto.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		accionesPanelInicio(e);
		accionesPanelAlta(e);
		accionesPanelBaja(e);
		accionesPanelConsulta(e);

	}

	private void accionesPanelBaja(ActionEvent e) {

		if (ventanaProducto.getBtnBorrar().equals(e.getSource())) {

			if (ventanaProducto.getComboBoxProductos().getSelectedIndex() != -1) {

				Producto temp = getProductoPorNombreId(
						(String) ventanaProducto.getComboBoxProductos().getSelectedItem());

				int i = JOptionPane.showConfirmDialog(ventanaProducto, "Quieres borrar el producto?", "",
						JOptionPane.YES_NO_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					modeloProducto.borrarProducto(temp);
					ventanaProducto.getDatosCombo()
							.removeElement(ventanaProducto.getComboBoxProductos().getSelectedItem());
				}

			}

		}

		if (ventanaProducto.getBtnModificar().equals(e.getSource())) {

			if (ventanaProducto.getComboBoxProductos().getSelectedIndex() != -1) {

				Producto temp = getProductoPorNombreId(
						(String) ventanaProducto.getComboBoxProductos().getSelectedItem());

				try {
					modeloProducto.modificarProducto(
							new Producto(Integer.parseInt(ventanaProducto.getTextFieldId2().getText()),
									ventanaProducto.getTextFieldNombre2().getText(),
									ventanaProducto.getComboBoxCategoria2().getSelectedItem().toString(),
									Integer.parseInt(ventanaProducto.getTextFieldPrecio2().getText()),
									Float.parseFloat(ventanaProducto.getTextFieldCantidad2().getText())),
							temp);

					ventanaProducto.getDatosCombo()
							.removeElement(ventanaProducto.getComboBoxProductos().getSelectedItem());

					String datos = ventanaProducto.getTextFieldNombre2().getText() + " ("
							+ ventanaProducto.getTextFieldId2().getText() + ")";

					ventanaProducto.getDatosCombo().addElement(datos);

					ventanaProducto.getComboBoxProductos()
							.setSelectedIndex(ventanaProducto.getDatosCombo().getIndexOf(datos));

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

		}
		if (ventanaProducto.getBtnSalir2().equals(e.getSource())) {
			cambiarPanel("panelInicio");
		}
	}

	private void accionesPanelConsulta(ActionEvent e) {

		if (ventanaProducto.getBtnSalir3().equals(e.getSource())) {
			cambiarPanel("panelInicio");
		}
	}

	private void accionesPanelAlta(ActionEvent e) {

		if (ventanaProducto.getBtnCancelar().equals(e.getSource())) {

			limpiarCampos("panelAlta");

		}

		if (ventanaProducto.getBtnSalir().equals(e.getSource())) {

			limpiarCampos("panelAlta");
			cambiarPanel("panelInicio");

		}

		if (ventanaProducto.getBtnGuardar().equals(e.getSource())) {

			try {

				modeloProducto.añadirProducto(new Producto(Integer.parseInt(ventanaProducto.getTextFieldId().getText()),
						ventanaProducto.getTextFieldNombre().getText(),
						ventanaProducto.getComboBoxCategorias().getSelectedItem().toString(),
						Integer.parseInt(ventanaProducto.getTextFieldCantidad().getText()),
						Float.parseFloat(ventanaProducto.getTextFieldPrecio().getText())));

				ventanaProducto.getDatosCombo().addElement(ventanaProducto.getTextFieldNombre().getText() + " ("
						+ ventanaProducto.getTextFieldId().getText() + ")");

				limpiarCampos("panelAlta");

				JOptionPane.showMessageDialog(ventanaProducto, "Se ha introducido el producto");

			} catch (Exception e2) {
				System.err.println("Algo se ha introducido mal");
			}

		}
	}

	private void accionesPanelInicio(ActionEvent e) {

		if (ventanaProducto.getBtnAlta().equals(e.getSource())) {

			cambiarPanel("panelAlta");

		}
		if (ventanaProducto.getBtnBaja().equals(e.getSource())) {

			cambiarPanel("panelBaja");

		}

	}

	private void cambiarPanel(String string) {

		if (string.equals("panelInicio")) {
			ventanaProducto.getBtnBaja().setEnabled(true);
			ventanaProducto.getBtnAlta().setEnabled(true);
			ventanaProducto.getRadioGroup().clearSelection();
		}

		if (string.equals("panelConsulta")) {
			ventanaProducto.getBtnBaja().setEnabled(false);
			ventanaProducto.getBtnAlta().setEnabled(false);
		}
		if (string.equals("panelBaja")) {
			ventanaProducto.getBtnBaja().setEnabled(true);
			ventanaProducto.getBtnAlta().setEnabled(false);
			ventanaProducto.getRadioGroup().clearSelection();
		}
		if (string.equals("panelAlta")) {
			ventanaProducto.getBtnBaja().setEnabled(false);
			ventanaProducto.getBtnAlta().setEnabled(true);
			ventanaProducto.getRadioGroup().clearSelection();
		}

		((CardLayout) ventanaProducto.getPanelCard().getLayout()).show(this.ventanaProducto.getPanelCard(), string);
	}

	private void limpiarCampos(String string) {

		switch (string) {
		case "panelAlta":

			ventanaProducto.getTextFieldPrecio().setText("");
			ventanaProducto.getTextFieldId().setText("");
			ventanaProducto.getTextFieldCantidad().setText("");
			ventanaProducto.getTextFieldNombre().setText("");

			break;
		case "panelBaja":

			ventanaProducto.getTextFieldId2().setText("");
			ventanaProducto.getTextFieldNombre2().setText("");
			ventanaProducto.getComboBoxCategoria2().setSelectedIndex(-1);
			ventanaProducto.getComboBoxProductos().setSelectedItem(-1);
			ventanaProducto.getTextFieldPrecio2().setText("");
			ventanaProducto.getTextFieldCantidad2().setText("");
			break;
		default:
			break;
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(ventanaProducto.getComboBoxProductos())) {

			if (ventanaProducto.getComboBoxProductos().getSelectedIndex() != -1) {

				Producto temp = getProductoPorNombreId(
						(String) ventanaProducto.getComboBoxProductos().getSelectedItem());

				ventanaProducto.getTextFieldId2().setText(String.valueOf(temp.getId()));
				ventanaProducto.getComboBoxCategoria2()
						.setSelectedIndex(Arrays.asList(modeloProducto.getCategorias()).indexOf(temp.getCategoria()));
				ventanaProducto.getTextFieldNombre2().setText(temp.getNombre());
				ventanaProducto.getTextFieldPrecio2().setText(String.valueOf(temp.getPrecio()));
				ventanaProducto.getTextFieldCantidad2().setText(String.valueOf(temp.getCantidad()));

			} else {

				limpiarCampos("panelBaja");
			}

		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {

		cambiarPanel("panelConsulta");

	}

	private Producto getProductoPorNombreId(String nombre) {
		for (Map.Entry<Integer, Producto> entry : modeloProducto.getAlmacenProductos().entrySet()) {
			if ((entry.getValue().getNombre() + " (" + entry.getValue().getId() + ")").equals(nombre)) {
				return entry.getValue();
			}
		}
		return null;

	}

}
