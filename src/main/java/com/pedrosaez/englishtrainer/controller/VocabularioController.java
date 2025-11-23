package com.pedrosaez.englishtrainer.controller;

import com.pedrosaez.englishtrainer.config.SpringFXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @FXML
    public void initialize() {
        // Aquí puedes inicializar los botones, labels, etc.
        // Por ejemplo, poner texto inicial o agregar listeners
    }

}
