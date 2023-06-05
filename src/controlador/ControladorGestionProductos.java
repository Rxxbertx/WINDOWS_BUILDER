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

	/**
	 * Controlador para la gestión de productos en la interfaz gráfica.
	 * Se encarga de controlar las interacciones entre la ventana principal y la ventana de gestión de productos.
	 */
	public ControladorGestionProductos(VentanaPrincipal ventana) {

	    // Se crea una nueva instancia de la ventana de gestión de productos y el modelo de producto
	    ventanaProducto = new VentanaGestionProductos();
	    modeloProducto = new ModeloProducto();

	    // Configuración de la ventana de gestión de productos
	    ventanaProducto.setLocationRelativeTo(ventana);
	    ventanaProducto.setModalityType(ModalityType.APPLICATION_MODAL);

	    // Se añaden listeners a los botones de la ventana de gestión de productos
	    ventanaProducto.getBtnAlta().addActionListener(this);
	    ventanaProducto.getBtnBaja().addActionListener(this);
	    ventanaProducto.getBtnCancelar().addActionListener(this);
	    ventanaProducto.getBtnBorrar().addActionListener(this);
	    ventanaProducto.getBtnGuardar().addActionListener(this);
	    ventanaProducto.getBtnModificar().addActionListener(this);
	    ventanaProducto.getBtnSalir().addActionListener(this);
	    ventanaProducto.getBtnSalir2().addActionListener(this);
	    ventanaProducto.getBtnSalir3().addActionListener(this);

	    // Se añaden ChangeListeners a los radio buttons de categoría y stock
	    ventanaProducto.getRdbtnCategoria().addChangeListener(this);
	    ventanaProducto.getRdbtnStock().addChangeListener(this);

	    // Se añade un ItemListener al combo box de categorías
	    ventanaProducto.getComboBoxCategorias().addItemListener(this);

	    // Se añade un ItemListener al combo box de productos
	    ventanaProducto.getComboBoxProductos().addItemListener(this);

	    // Se establece el modelo de datos para los combo boxes de categorías
	    ventanaProducto.getComboBoxCategorias().setModel(new DefaultComboBoxModel<>(modeloProducto.getCategorias()));
	    ventanaProducto.getComboBoxCategoria2().setModel(new DefaultComboBoxModel<>(modeloProducto.getCategorias()));

	    // Se cargan los datos de los productos en la lista de nombres de productos
	    ventanaProducto.getDatosCombo().addAll(modeloProducto.nombreProductos());

	    // Se hace visible la ventana de gestión de productos
	    ventanaProducto.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	    // Se ejecutan las acciones relacionadas con el panel de inicio
	    accionesPanelInicio(e);

	    // Se ejecutan las acciones relacionadas con el panel de alta de productos
	    accionesPanelAlta(e);

	    // Se ejecutan las acciones relacionadas con el panel de baja de productos
	    accionesPanelBaja(e);

	    // Se ejecutan las acciones relacionadas con el panel de consulta de productos
	    accionesPanelConsulta(e);
	}


	private void accionesPanelBaja(ActionEvent e) {

	    // Acción realizada al presionar el botón "Borrar"
	    if (ventanaProducto.getBtnBorrar().equals(e.getSource())) {

	        // Se verifica si hay un producto seleccionado en el combo box
	        if (ventanaProducto.getComboBoxProductos().getSelectedIndex() != -1) {

	            // Se obtiene el producto seleccionado
	            Producto temp = getProductoPorNombreId(
	                    (String) ventanaProducto.getComboBoxProductos().getSelectedItem());

	            // Se muestra un cuadro de diálogo para confirmar el borrado del producto
	            int i = JOptionPane.showConfirmDialog(ventanaProducto, "Quieres borrar el producto?", "",
	                    JOptionPane.YES_NO_OPTION);

	            // Si se confirma el borrado del producto
	            if (i == JOptionPane.YES_OPTION) {
	                modeloProducto.borrarProducto(temp);
	                ventanaProducto.getDatosCombo()
	                        .removeElement(ventanaProducto.getComboBoxProductos().getSelectedItem());
	            }

	        }

	    }

	    // Acción realizada al presionar el botón "Modificar"
	    if (ventanaProducto.getBtnModificar().equals(e.getSource())) {

	        // Se verifica si hay un producto seleccionado en el combo box
	        if (ventanaProducto.getComboBoxProductos().getSelectedIndex() != -1) {

	            // Se obtiene el producto seleccionado
	            Producto temp = getProductoPorNombreId(
	                    (String) ventanaProducto.getComboBoxProductos().getSelectedItem());

	            try {
	                // Se actualizan los datos del producto con los valores ingresados en la interfaz
	                temp.setNombre(ventanaProducto.getTextFieldNombre2().getText());
	                temp.setCategoria(ventanaProducto.getComboBoxCategoria2().getSelectedItem().toString());
	                temp.setPrecio(Float.parseFloat(ventanaProducto.getTextFieldPrecio2().getText()));
	                temp.setCantidad(Integer.parseInt(ventanaProducto.getTextFieldCantidad2().getText()));

	                
	             // Se actualiza la lista de nombres de productos con los cambios realizados
	                String dato = ventanaProducto.getTextFieldNombre2().getText() + " ("
	                        + ventanaProducto.getTextFieldId2().getText() + ")";
	                
	                ventanaProducto.getDatosCombo()
	                        .removeElement(ventanaProducto.getComboBoxProductos().getSelectedItem());

	                

	                ventanaProducto.getDatosCombo().addElement(dato);

	                // Se selecciona el producto modificado en el combo box
	                ventanaProducto.getComboBoxProductos()
	                        .setSelectedIndex(ventanaProducto.getDatosCombo().getIndexOf(dato));

	            } catch (Exception e2) {
	                // TODO: handle exception
	            }

	        }

	    }

	    // Acción realizada al presionar el botón "Salir"
	    if (ventanaProducto.getBtnSalir2().equals(e.getSource())) {
	        cambiarPanel("panelInicio");
	    }
	}


	private void accionesPanelConsulta(ActionEvent e) {

	    // Acción realizada al presionar el botón "Salir"
	    if (ventanaProducto.getBtnSalir3().equals(e.getSource())) {
	        cambiarPanel("panelInicio");
	    }
	}


	/**
	 * Realiza las acciones correspondientes al panel de alta de productos.
	 * @param e El evento de acción que ha ocurrido.
	 */
	private void accionesPanelAlta(ActionEvent e) {

	    // Acción realizada al presionar el botón "Cancelar"
	    if (ventanaProducto.getBtnCancelar().equals(e.getSource())) {

	        // Se limpian los campos del panel de alta de productos
	        limpiarCampos("panelAlta");

	    }

	    // Acción realizada al presionar el botón "Salir"
	    if (ventanaProducto.getBtnSalir().equals(e.getSource())) {

	        // Se limpian los campos del panel de alta de productos
	        limpiarCampos("panelAlta");

	        // Se cambia al panel de inicio
	        cambiarPanel("panelInicio");

	    }

	    // Acción realizada al presionar el botón "Guardar"
	    if (ventanaProducto.getBtnGuardar().equals(e.getSource())) {

	        try {
	            // Se crea un nuevo producto con los datos ingresados en la interfaz
	            modeloProducto.añadirProducto(new Producto(
	                    Integer.parseInt(ventanaProducto.getTextFieldId().getText()),
	                    ventanaProducto.getTextFieldNombre().getText(),
	                    ventanaProducto.getComboBoxCategorias().getSelectedItem().toString(),
	                    Integer.parseInt(ventanaProducto.getTextFieldCantidad().getText()),
	                    Float.parseFloat(ventanaProducto.getTextFieldPrecio().getText())
	            ));

	            // Se agrega el nombre del producto a la lista de nombres de productos en la interfaz
	            ventanaProducto.getDatosCombo().addElement(
	                    ventanaProducto.getTextFieldNombre().getText() + " (" +
	                    ventanaProducto.getTextFieldId().getText() + ")"
	            );

	            // Se limpian los campos del panel de alta de productos
	            limpiarCampos("panelAlta");

	            // Se muestra un mensaje de confirmación
	            JOptionPane.showMessageDialog(ventanaProducto, "Se ha introducido el producto");

	        } catch (Exception e2) {
	            // Si ocurre una excepción, se imprime un mensaje de error
	            System.err.println("Algo se ha introducido mal");
	        }

	    }
	}


	/**
	 * Realiza las acciones correspondientes al panel de inicio.
	 * @param e El evento de acción que ha ocurrido.
	 */
	private void accionesPanelInicio(ActionEvent e) {

	    // Acción realizada al presionar el botón "Alta"
	    if (ventanaProducto.getBtnAlta().equals(e.getSource())) {

	        // Se cambia al panel de alta de productos
	        cambiarPanel("panelAlta");

	    }

	    // Acción realizada al presionar el botón "Baja"
	    if (ventanaProducto.getBtnBaja().equals(e.getSource())) {

	        // Se cambia al panel de baja de productos
	        cambiarPanel("panelBaja");

	    }
	}


	/**
	 * Cambia el panel visible en la ventana principal según la opción especificada.
	 * @param string La opción de panel a mostrar.
	 */
	private void cambiarPanel(String string) {

	    if (string.equals("panelInicio")) {
	        // Habilita los botones de alta y baja
	        ventanaProducto.getBtnBaja().setEnabled(true);
	        ventanaProducto.getBtnAlta().setEnabled(true);
	        // Limpia la selección de los radio buttons
	        ventanaProducto.getRadioGroup().clearSelection();
	    }

	    if (string.equals("panelConsulta")) {
	        // Deshabilita los botones de alta y baja
	        ventanaProducto.getBtnBaja().setEnabled(false);
	        ventanaProducto.getBtnAlta().setEnabled(false);
	    }
	    if (string.equals("panelBaja")) {
	        // Habilita el botón de baja y deshabilita el de alta
	        ventanaProducto.getBtnBaja().setEnabled(true);
	        ventanaProducto.getBtnAlta().setEnabled(false);
	        // Limpia la selección de los radio buttons
	        ventanaProducto.getRadioGroup().clearSelection();
	    }
	    if (string.equals("panelAlta")) {
	        // Deshabilita el botón de baja y habilita el de alta
	        ventanaProducto.getBtnBaja().setEnabled(false);
	        ventanaProducto.getBtnAlta().setEnabled(true);
	        // Limpia la selección de los radio buttons
	        ventanaProducto.getRadioGroup().clearSelection();
	    }

	    // Muestra el panel correspondiente en la ventana principal
	    ((CardLayout) ventanaProducto.getPanelCard().getLayout()).show(this.ventanaProducto.getPanelCard(), string);
	}


	/**
	 * Limpia los campos de texto y selecciones de la interfaz, según la opción especificada.
	 * @param string La opción de panel para limpiar los campos.
	 */
	private void limpiarCampos(String string) {

	    switch (string) {
	        case "panelAlta":

	            // Se limpian los campos de texto en el panel de alta
	            ventanaProducto.getTextFieldPrecio().setText("");
	            ventanaProducto.getTextFieldId().setText("");
	            ventanaProducto.getTextFieldCantidad().setText("");
	            ventanaProducto.getTextFieldNombre().setText("");

	            break;
	        case "panelBaja":

	            // Se limpian los campos de texto y selecciones en el panel de baja
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

	            // Obtener el producto seleccionado
	            Producto temp = getProductoPorNombreId((String) ventanaProducto.getComboBoxProductos().getSelectedItem());

	            // Actualizar los campos de texto y selecciones en el panel de baja con los datos del producto
	            ventanaProducto.getTextFieldId2().setText(String.valueOf(temp.getId()));
	            ventanaProducto.getComboBoxCategoria2().setSelectedIndex(Arrays.asList(modeloProducto.getCategorias()).indexOf(temp.getCategoria()));
	            ventanaProducto.getTextFieldNombre2().setText(temp.getNombre());
	            ventanaProducto.getTextFieldPrecio2().setText(String.valueOf(temp.getPrecio()));
	            ventanaProducto.getTextFieldCantidad2().setText(String.valueOf(temp.getCantidad()));

	        } else {

	            // Limpiar los campos de texto y selecciones en el panel de baja
	            limpiarCampos("panelBaja");
	        }
	    }
	}

	

	/**
	 * Método que se ejecuta cuando se produce un cambio de estado en los componentes que implementan la interfaz ChangeListener.
	 * @param e El evento que disparó el cambio de estado.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
	    if (e.getSource().equals(ventanaProducto.getRdbtnCategoria())) {
	        if (ventanaProducto.getRdbtnCategoria().isSelected()) {
	            // Acciones a realizar cuando se selecciona la opción de categoría
	        	 cambiarPanel("panelConsulta");
	        }
	    }
	   
	}


	/**
	 * Busca y devuelve un objeto Producto en base al nombre y el ID proporcionados.
	 * @param nombre El nombre del producto junto con su ID.
	 * @return El objeto Producto correspondiente, o null si no se encuentra.
	 */
	private Producto getProductoPorNombreId(String nombre) {
	    for (Map.Entry<Integer, Producto> entry : modeloProducto.getAlmacenProductos().entrySet()) {
	        if ((entry.getValue().getNombre() + " (" + entry.getValue().getId() + ")").equals(nombre)) {
	            return entry.getValue();
	        }
	    }
	    return null;
	}


}
