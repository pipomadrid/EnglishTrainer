package com.pedrosaez.englishtrainer.ui.controller;


import com.pedrosaez.englishtrainer.config.SpringFXMLLoader;
import com.pedrosaez.englishtrainer.ui.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private SpringFXMLLoader fxmlLoader;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button logoutButton;

    @FXML
    private Button btnVocabulario;

    @FXML
    public void initialize() {
        if (sessionManager.isLoggedIn()) {
            welcomeLabel.setText("Bienvenido, " + sessionManager.getCurrentUser().getUsername());
        }
    }

    @FXML
    private void onLogoutClicked() {
        // Limpiar sesión
        sessionManager.logout();

        try {
            var root = fxmlLoader.load(getClass().getResource("/fxml/login-view.fxml"));
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("English Trainer - Login");

            stage.setMinWidth(400);
            stage.setMinHeight(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onVocabularioClicked(){
        try {
            var root = fxmlLoader.load(getClass().getResource("/fxml/vocabulario-view.fxml"));
            Stage stage = (Stage) btnVocabulario.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMinWidth(400);
            stage.setMinHeight(300);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
