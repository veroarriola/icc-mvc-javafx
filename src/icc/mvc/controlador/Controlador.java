/*
 * Demo con propósito educativo sin afán de lucro ni compromiso comercial.
 */
package icc.mvc.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import icc.mvc.modelo.CoordinadorDirectorio;
import icc.mvc.modelo.CoordinadorPersona;
import icc.mvc.vista.DiálogoPersona;
import icc.mvc.modelo.Persona;

/**
 * Controlador, contiene la lógica de la aplicación y establece la comunicación
 * entre modelo y vistas.
 * @author blackzafiro
 */
public class Controlador {

	/**
	 * Tabla donde se despliega el contenido del directorio.
	 */
	@FXML
	private TableView<CoordinadorPersona> vistaTablaDirectorio;

	/**
	 * Vista en forma de columna para el atributo nombre.
	 */
	@FXML
	private TableColumn<CoordinadorPersona, String> colNombre;

	// TODO: Agregar y configurar las demás columnas.

	/**
	 * Sólo se usa un diálogo, que se muestra cada vez que se quieran
	 * pedir los datos de la persona:
	 */
	private static DiálogoPersona dPersona;

	/**
	 * Modelo, maneja los datos del directorio.
	 */
	private CoordinadorDirectorio coordModeloDirectorio;
	
	/**
	 * Nombre del archivo por defecto donde se estará guardando la agenda.
	 */
	private static final String ARCHIVO_POR_DEFECTO = "Agenda.ag";
	
	/**
	 * Este método es mandado llamar al incio de la aplicación.
	 * Crea los objetos necesarios para trabajar.
	 */
	public void initialize() throws IOException {
		// Crea un objeto directorio con los datos del archivo por defecto.
		try {
			coordModeloDirectorio = new CoordinadorDirectorio(ARCHIVO_POR_DEFECTO);
			colNombre.setCellValueFactory(cellData -> cellData.getValue().nombre());
			vistaTablaDirectorio.setItems(coordModeloDirectorio.personasEnObservación());

			dPersona = new DiálogoPersona();
		} catch (javafx.fxml.LoadException ex) {
			throw ex;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, "{0}: {1}", new Object[]{ex, ex.getMessage()});
			Alert alert = new Alert(AlertType.ERROR, "Archivo no encontrado");
			alert.showAndWait();
			System.exit(1);
		} catch (SecurityException ex) {
			Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, "{0}: {1}", new Object[]{ex, ex.getMessage()});
			Alert alert = new Alert(AlertType.ERROR, "Error de seguridad");
			alert.showAndWait();
		} catch (IOException ex) {
			Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, "{0}: {1}", new Object[]{ex, ex.getMessage()});
			Alert alert = new Alert(AlertType.ERROR, "Error al acceder al archivo");
			alert.showAndWait();
		}
	}

	/**
	 * Muestra la vista y recaba los datos hasta agregar a una persona nueva
	 * al directorio.
	 */
	public void agregaPersona() {

		dPersona.showAndWait()
       .filter(response -> response == ButtonType.OK)
       .ifPresent(response -> {
       		System.out.println("El diálogo funciona");
       		try {
				// Agregar persona a directorio/tabla
				CoordinadorPersona coord = new CoordinadorPersona(dPersona);
				coordModeloDirectorio.inserta(coord);
				dPersona.reiníciate();
			} catch (FileNotFoundException ex) {
				Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
				alert.showAndWait();
			}
       	});
	}
}
