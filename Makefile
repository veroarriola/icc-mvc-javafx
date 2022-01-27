PATH_TO_FX=/home/blackzafiro/Descargas/Aplicaciones/Java/openjfx-11.0.1_linux-x64_bin-sdk/javafx-sdk-11.0.1/lib/

compile:
	javac -Xlint:unchecked --module-path $(PATH_TO_FX) --add-modules=javafx.controls,javafx.fxml -d ./build --source-path ./src src/icc/mvc/*.java
	javac -Xlint:unchecked --module-path $(PATH_TO_FX) --add-modules=javafx.controls,javafx.fxml -d ./build --source-path ./src src/icc/mvc/**/*.java
	mkdir -p build/icc/mvc/vista/
	cp ./src/icc/mvc/vista/*.fxml ./build/icc/mvc/vista/

run:
	java --module-path $(PATH_TO_FX) --add-modules=javafx.controls,javafx.fxml -classpath build icc.mvc.Aplicación

.PHONY: clean
clean:
	rm -rf build
