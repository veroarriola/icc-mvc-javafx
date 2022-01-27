# icc-mvc-javafx

Demo de un diseño de aplicación con JavaFX siguiendo el patrón Modelo-Vista-Controlador (MVC).
La aplicación ilustra un directorio telefónico con los elementos básicos de programación para leer datos desde un archivo de texto por defecto e insertar personas, aunque sólo inserta el nombre.  Queda como un ejercicio para el alumno completar el resto de la funcionalidad.

Para ejecutarlo es necesario descargar la versión de JavaFX correspondiente la JDK en la computadora donde se usará el programa.  Se requiere mínimo la versión 11 de Java.

Se inlcuye un Makefile para compilar y ejecutar el demo.  Se debe editar para sustituir el PATH_TO_FX por la dirección donde fue instalado.

Usa los comandos:
```
make compile
make run
```
Los archivos generados se pueden borrar con:
```
make clean
```
