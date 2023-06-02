package controlador;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClienteMain {

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(new NimbusLookAndFeel());

			new ControladorJFrame();
			// new ControladorJDialog();
		} catch (Exception e) {

		}

	}

}
