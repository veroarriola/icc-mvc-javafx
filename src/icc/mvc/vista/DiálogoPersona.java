/*
 * Demo con propósito educativo sin afán de lucro ni compromiso comercial.
 */
package icc.mvc.vista;

import javafx.scene.control.Dialog;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DialogPane;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ButtonType;

/**
 * Vista para solicitar/modificar los datos de una persona.
 * @author blackzafiro
 */
public class DiálogoPersona extends Dialog<ButtonType> {

	private TextField cajaNombre;

	private TextField cajaDirección;

	private TextField cajaTeléfono;

	private TextField cajaExtensión;

	private TextArea áreaMensajes;

	/**
	 * Crea un diálogo para solicitar/mostrar los datos de una persona.
	 */
	public DiálogoPersona() throws IOException  {
		setResizable(true);
		setTitle("Persona");
		DialogPane root = new FXMLLoader(
				getClass().getResource("DiálogoPersona.fxml")
			).load();
		cajaNombre = (TextField)root.lookup("#cajaNombre");
		cajaDirección = (TextField)root.lookup("#cajaDirección");
		cajaTeléfono = (TextField)root.lookup("#cajaTeléfono");
		cajaExtensión = (TextField)root.lookup("#cajaExtensión");
		áreaMensajes = (TextArea)root.lookup("#áreaMensajes");
		setDialogPane(root);
	}

	/**
	 * Devuelve el contenido del campo nombre.
	 * @return el nombre.
	 */
	public String nombre() {
		return cajaNombre.getText();
	}

	public String dirección() {
		return cajaDirección.getText();
	}

	public String teléfono() {
		return cajaTeléfono.getText();
	}

	public String extensión() {
		return cajaExtensión.getText();
	}

	public void agregaMensaje(String msj) {
		áreaMensajes.setText(áreaMensajes.getText() + '\n' + msj);
	}

	/**
	 * Vacía las cajas de texto y la opción seleccionada queda, por defecto,
	 * en CANCELAR.
	 */
	public void reiníciate() {
		áreaMensajes.setText("");
		cajaNombre.setText("");
		cajaDirección.setText("");
		cajaTeléfono.setText("");
		cajaExtensión.setText("");
	}

}