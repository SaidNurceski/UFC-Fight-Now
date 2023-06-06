package org.example.view.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entity.Fighter;
import org.example.view.App;

import java.io.IOException;

public class FightScreenController {
    @FXML
    private void close_app(MouseEvent event){
        System.exit(0);
    }


    @FXML
    private ObservableList<Fighter> fighterObservableList  = null;
    private void getNewStage(String name,String title) throws IOException {
        Stage stage = App.getCurrentStage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/" + name + ".fxml"));

        Image icon = new Image("file:../../../images/logo.jpg");
        stage.getIcons().add(icon);

        Scene scene = new Scene(fxmlLoader.load(), 795, 538);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){


    }
    public void onAddBtn(ActionEvent actionEvent) {
    }

    public void onRemoveBtn(ActionEvent actionEvent) {
    }
    public void onDetailsBtn(ActionEvent actionEvent) {
    }
}
