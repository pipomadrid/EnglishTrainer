package com.pedrosaez.englishtrainer.controller;


import com.pedrosaez.englishtrainer.config.SpringFXMLLoader;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SplashScreenController {

    @Autowired
    private SpringFXMLLoader fxmlLoader;

    @FXML
    public void initialize(){
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e-> showLogin());
        delay.play();

    }

    private void showLogin() {
        try {
            Stage stage = (Stage) Stage.getWindows().stream()
                    .filter(Window::isShowing)
                    .findFirst()
                    .orElse(null);

            if (stage != null) {
                Parent loginRoot = fxmlLoader.load(getClass().getResource("/fxml/main-view.fxml"));
                stage.setScene(new Scene(loginRoot));
                stage.setMinWidth(400);
                stage.setMinHeight(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

