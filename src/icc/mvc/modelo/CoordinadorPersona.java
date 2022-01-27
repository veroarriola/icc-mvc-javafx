/*
 * Demo con propósito educativo sin afán de lucro ni compromiso comercial.
 */
package icc.mvc.modelo;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

import icc.mvc.vista.DiálogoPersona;

/**
 * Modelo de la aplicación o coordinador para el modelo de una persons.
 * @author blackzafiro
 */
public class CoordinadorPersona {
	
	/**
	 * Modelo de datos.
	 */
	private Persona persona;

	/**
	 * Propiedad cuyos cambios son observables, la usaremos como envoltura
	 * para que funcione con la tabla, aunque vuelve redundate lo que hay
	 * en persona.
	 */
	private StringProperty propiedadNombre;
	
	/**
	 * Constructor que recibe una vista de java Swing y una persona con los
	 * datos del modelo.
	 * @param persona Modelo
	 */
	public CoordinadorPersona(Persona persona) {
		persona(persona);
	}

	/**
	 * Crea al coordinador con una nueva persona, cuyos datos son extraídos
	 * de la vista.
	 */
	public CoordinadorPersona(DiálogoPersona dPersona) {
		int tel = analizaEntero(dPersona.teléfono());
		int ext = analizaEntero(dPersona.extensión());
		persona(new Persona(dPersona.nombre(),
						dPersona.dirección(),
						new Teléfono(tel, ext)));
	}
	
	/**
	 * Usado para obtener los datos del teléfono.
	 */
	private int analizaEntero(String str) {
		return str == null || str.isBlank() ? -1 : Integer.parseInt(str);
	}
	
	/**
	 * Permite acceder al modelo con los datos de la persona.
	 * @return El modelo de la persona.
	 */
	Persona persona() { return persona; }

	/**
	 * Asigna los valores de p a las propiedades observables del
	 * coordinador.
	 */
	private void persona(Persona p) {
		this.persona = p;
		propiedadNombre = new SimpleStringProperty(this, "nombre");
		propiedadNombre.setValue(p.nombre());

		// TODO: Hacer lo mismo con las demás propiedades o
		// eliminar el uso del modelo Persona.
	}

	/**
	 * Nombre.
	 */
	public StringProperty nombre() {
		if (propiedadNombre.getValue() != persona.nombre()) {
			// Garantiza la sincronización entre el modelo y el 
			// envoltorio.
			propiedadNombre.setValue(persona.nombre());
		}
		return propiedadNombre;
	}
	
}
