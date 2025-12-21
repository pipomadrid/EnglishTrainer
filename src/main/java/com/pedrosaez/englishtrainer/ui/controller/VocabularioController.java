package com.pedrosaez.englishtrainer.ui.controller;

import com.pedrosaez.englishtrainer.application.model.PreguntaVocabulario;
import com.pedrosaez.englishtrainer.config.SpringFXMLLoader;
import com.pedrosaez.englishtrainer.domain.service.VocabularioService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VocabularioController {

    @Autowired
    private SpringFXMLLoader fxmlLoader;
    // Top
    @FXML
    private Label lblPalabra;

    // Center - buttons
    @FXML
    private Button btnOpcion1;
    @FXML
    private Button btnOpcion2;
    @FXML
    private Button btnOpcion3;
    @FXML
    private Button btnOpcion4;

    // Bottom
    @FXML
    private Label lblAciertos;
    @FXML
    private Label lblFallos;

    private PreguntaVocabulario preguntaActual;

    private final VocabularioService vocabularioService;

    public VocabularioController(VocabularioService vocabularioService) {
        this.vocabularioService = vocabularioService;
    }

    @FXML
    public void initialize() {
        cargarPregunta();
    }


    private void cargarPregunta() {
        Optional<PreguntaVocabulario> preguntaOpt =
                vocabularioService.generarPregunta();

        if (preguntaOpt.isEmpty()) {
     //       mostrarAlerta("No hay vocabulario suficiente");
      //      desactivarBotones();
            return;
        }

        preguntaActual = preguntaOpt.get();

        lblPalabra.setText(preguntaActual.getPalabra());

        List<Button> botones =
                List.of(btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4);

        for (int i = 0; i < botones.size(); i++) {
            botones.get(i)
                    .setText(preguntaActual.getOpciones().get(i));
            botones.get(i)
                    .setDisable(false);
        }
    }

}
