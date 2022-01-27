/*
 * Demo con propósito educativo sin afán de lucro ni compromiso comercial.
 */
package icc.mvc;
 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * JavaFX App directorio.
 * @author blackzafiro
 */
public class Aplicación extends Application {
	
	/**
	 * Auxiliar para imprimir en caso de que algo salga mal.
	 */
	private static void printException(Exception e) {
		System.err.println(e.toString());
		e.printStackTrace(System.err);
	}
	
	/**
	 * Método donde se inicia el escenario y la primer escena.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			Parent root = new FXMLLoader(
				getClass().getResource("vista/Ventana.fxml")
			).load();
			primaryStage.setTitle("Mi directorio");
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException ioe) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("IOException");
			alert.setTitle("Error");
			alert.setContentText("No se pudo cargar el archivo Ventana.fxml");
			printException(ioe);
			alert.showAndWait();
			throw ioe;
		}
	}
	
	/**
	 * Entrada a la aplicación.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
