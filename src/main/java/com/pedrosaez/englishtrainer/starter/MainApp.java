package com.pedrosaez.englishtrainer.starter;

import com.pedrosaez.englishtrainer.EnglishTrainerApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.builder.SpringApplicationBuilder;
import com.pedrosaez.englishtrainer.config.SpringFXMLLoader;

public class MainApp  extends Application {

    private ConfigurableApplicationContext context;
    private SpringFXMLLoader fxmlLoader;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(EnglishTrainerApplication.class).run();
        fxmlLoader = context.getBean(SpringFXMLLoader.class);
    }
    @Override
    public void start(Stage stage) throws Exception {
        var root = fxmlLoader.load(getClass().getResource("/fxml/splash-view.fxml"));
        Scene scene = new Scene(root,800,600);
        stage.setTitle("English Trainer");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch();
    }
}
