/*
 * Código utilizado para el curso de Introducción a las Ciencias de la Computación.
 */

module mvcjavafx {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.logging;
	
	opens icc.mvc to javafx.fxml;

	exports icc.mvc;
}
