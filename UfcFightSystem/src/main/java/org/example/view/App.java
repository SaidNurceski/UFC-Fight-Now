package org.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    private static Stage currentStage = null;

    @Override
    public void start(Stage stage) throws IOException {
        currentStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/login-view.fxml"));
        Scene scene = new Scene(root);
       stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login");
        stage.setScene(scene);

        currentStage.getIcons().add(new javafx.scene.image.Image("file:images/logo.jpg"));

        currentStage.setScene(scene);
        stage.show();
    }
    public static Stage getCurrentStage(){
        return currentStage;
    }
    public static void main(String[] args) {
        launch();
    }
}
