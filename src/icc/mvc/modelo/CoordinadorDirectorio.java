/*
 * Demo con propósito educativo sin afán de lucro ni compromiso comercial.
 */
package icc.mvc.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * Modelo de la aplicación o coordinador para el modelo de un directorio.
 * @author blackzafiro
 */
public class CoordinadorDirectorio {
	
	private final Directorio directorio;

	private ObservableList<CoordinadorPersona> personasEnObservación;
	
	/**
	 * Constructor que con <code>archivo</code> como base.  Si ya existe y tiene
	 * datos, los carga desde ahí.  En cualquier caso, cada vez que se inserte,
	 * borre o modifique un dato, los cambios serán guardados automáticamente
	 * en ese archivo.
	 * @param archivo  Dirección del archivo base.
	 * @throws SecurityException Si la aplicación no tiene permiso para accder
	 *                           el archivo.
	 * @throws IOException Problemas al acceder el archivo para lectura/escritura.
	 */
	public CoordinadorDirectorio(String archivo) throws SecurityException, IOException {
		directorio = new Directorio(archivo);
		//personasEnObservación = FXCollections.observableArrayList(directorio.personas());
		personasEnObservación = FXCollections.observableArrayList();
		for(Persona p : directorio.personas()) {
			personasEnObservación.add(new CoordinadorPersona(p));
		}
	}

	/**
	 * Devuelve una referencia a una lista observable de personas en el directorio.
	 */
	public ObservableList<CoordinadorPersona> personasEnObservación() {
		return personasEnObservación;
	}
	
	/**
	 * Pide al modelo que inserte los datos accesibles desde <code>cp</code>
	 * y dispara el evento requerido para que la vista se actualice.
	 * @param cp Coordinador del modelo persona.
	 * @throws FileNotFoundException Al insertar los datos son guardados
	 *         automáticamente en el archivo base, si hay un error el método
	 *         lanza esta excepción.
	 */
	public void inserta(CoordinadorPersona cp) throws FileNotFoundException {
		int pos = directorio.inserta(cp.persona());
		personasEnObservación.add(cp);
	}
}
