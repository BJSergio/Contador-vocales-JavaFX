package org.iesalandalus.programacion.javafx.contarvocales;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controladores;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Dialogos;

public class Main extends Application {

	private Controlador ventanaPrincipal;

	@Override
	public void start(Stage escenarioPrincipal) {
		ventanaPrincipal = Controladores.get("/vistas/contarVocales.fxml", "Contador de vocales", null);
		ventanaPrincipal.getEscenario().setOnCloseRequest(this::salir);
		ventanaPrincipal.getEscenario().show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void salir(WindowEvent e) {
		if(Dialogos.mostrarDialogoConfirmacion("Salir","¿Quieres salir de la aplicación?",ventanaPrincipal.getEscenario())) {
			ventanaPrincipal.getEscenario().close();
		} else {
			e.consume();
		}
	}


}
