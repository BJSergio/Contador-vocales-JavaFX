package org.iesalandalus.programacion.javafx.contarvocales.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controladores;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Controles;
import org.iesalandalus.programacion.javafx.contarvocales.utilidades.Dialogos;

public class ContarVocales extends Controlador {

    @FXML
    private TextArea areaTexto;
    @FXML
    private TextField etiquetaA;
    @FXML
    private TextField etiquetaE;
    @FXML
    private TextField etiquetaI;
    @FXML
    private TextField etiquetaO;
    @FXML
    private TextField etiquetaU;
    @FXML
    private Button btLimpiar;

    // Contadores
    private int contadorA;
    private int contadorE;
    private int contadorI;
    private int contadorO;
    private int contadorU;

    private void contarVocales(String nuevoTexto) {
        inicializar(); // Pongo los atributos a cero
        String textoMinus = nuevoTexto.toLowerCase();
        for (int i = 0; i < textoMinus.length(); i++) {
            char inicial = textoMinus.charAt(i);
            if (inicial == 'a' || inicial == 'á') {
                contadorA++;
            } else if (inicial == 'e' || inicial == 'é') {
                contadorE++;
            } else if (inicial == 'i' || inicial == 'í') {
                contadorI++;
            } else if (inicial == 'o' || inicial == 'ó') {
                contadorO++;
            } else if (inicial == 'u' || inicial == 'ú') {
                contadorU++;
            }
        }
        etiquetaA.setText(String.valueOf(contadorA));
        etiquetaE.setText(String.valueOf(contadorE));
        etiquetaI.setText(String.valueOf(contadorI));
        etiquetaO.setText(String.valueOf(contadorO));
        etiquetaU.setText(String.valueOf(contadorU));

    }

    private void inicializar() {
        contadorA = 0;
        contadorE = 0;
        contadorI = 0;
        contadorO = 0;
        contadorU = 0;
    }
    @FXML
    void mostrarInformacion() {
        AcercaDe vistaAcercaDe = (AcercaDe) Controladores.get("/vistas/ventanaAcercaDe.fxml", "Acerca de", getEscenario());
        vistaAcercaDe.getEscenario().showAndWait();
    }

    @FXML
    void cerrarVentana() {
        if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?", getEscenario())) {
            getEscenario().close();
        }
    }

    @FXML
    void limpiar() {
        areaTexto.clear();
        Controles.limpiarCamposTexto(etiquetaA, etiquetaE, etiquetaI, etiquetaO, etiquetaU);
    }

    @FXML
    void initialize() {
        areaTexto.textProperty().addListener((ob, oldValue, newValue) -> {
            btLimpiar.setDisable(newValue.isEmpty());
            contarVocales(newValue);
        });
    }
}

