package com.pedrosaez.englishtrainer.controller;

import com.pedrosaez.englishtrainer.config.SpringFXMLLoader;
import com.pedrosaez.englishtrainer.model.User;
import com.pedrosaez.englishtrainer.service.UserService;
import com.pedrosaez.englishtrainer.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class LoginController {

    @Autowired
    private SpringFXMLLoader fxmlLoader;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private UserService userService;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private void onLoginClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean isRegistered = userService.login(username, password);

        if (isRegistered) {
            sessionManager.login(new User(username,password));
            openMainView();
        } else {
            errorLabel.setText("❌ Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    private void onRegisterClicked(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean isRegistered = userService.register(username, password);
        if (!isRegistered) {
            errorLabel.setText("Usuario registrado");
        } else {
            errorLabel.setText("Usuario ya registrado");
        }
    }

    private void openMainView() {
        try {
            var root = fxmlLoader.load(getClass().getResource("/fxml/main-view.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("English Trainer");

            stage.setMinWidth(400);
            stage.setMinHeight(300);
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Error al abrir la pantalla principal.");
        }
    }
}
