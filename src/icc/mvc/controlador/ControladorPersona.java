/*
 * Demo con propósito educativo sin afán de lucro ni compromiso comercial.
 */
package icc.mvc.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;

import icc.mvc.modelo.Persona;
import icc.mvc.modelo.Teléfono;
import icc.mvc.vista.DiálogoPersona;

/**
 * Controlador para validar los datos de una persona.
 * @author blackzafiro
 */
public class ControladorPersona {

	@FXML
	private DialogPane panelDiálogoPersona;

	@FXML
	private TextField cajaNombre;

	@FXML
	private TextField cajaDirección;

	@FXML
	private TextField cajaTeléfono;

	@FXML
	private TextField cajaExtensión;

	@FXML
	private TextArea áreaMensajes;

	/**
	 * Este método es mandado llamar al incio de la aplicación.
	 * Crea los objetos necesarios para trabajar.
	 */
	public void initialize() {
		final Button btOk = (Button) panelDiálogoPersona.lookupButton(ButtonType.OK);
		btOk.addEventFilter(ActionEvent.ACTION, event -> {
			System.out.println("Válidos: " + datosVálidos());
			if (!datosVálidos()) {
				event.consume();
			}
		});
	}

	/**
	 * Valida los datos ingresados en la caja de texto.
	 */
	private boolean datosVálidos() {
		boolean válidos = true;
		áreaMensajes.setText("");
		String nombre = cajaNombre.getText();
		if (nombre == null || nombre.isBlank()) {
			//vista.agregaMensaje("No se ha asignado un nombre");
			áreaMensajes.setText(áreaMensajes.getText() + '\n' + "No se ha asignado un nombre");
			válidos = false;
		}

		// TODO: Valida que teléfono y extensión sean números.
		return válidos;
	}
}