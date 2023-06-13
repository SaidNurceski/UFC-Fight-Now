package org.example.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entity.Fighter;
import org.example.view.App;
import repository.FighterRepository;

import java.io.IOException;
import java.util.LinkedList;

public class FightScreenController<T> {
    public ListView fightersToChoose;

    private static ObservableList<Fighter> fighters = FXCollections.observableArrayList(new LinkedList<>());
    FighterRepository fighterRepository = new FighterRepository();




    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    private FilteredList<Fighter> fighterFilteredList = null;

    private void getNewStage(String name, String title) throws IOException {
        Stage stage = App.getCurrentStage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/" + name + ".fxml"));

        Image icon = new Image("file:../../../images/logo.jpg");
        stage.getIcons().add(icon);

        Scene scene = new Scene(fxmlLoader.load(), 795, 538);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
       /* fighters.addAll(fighterRepository.getAll());
        fightersToChoose.setItems(fighters);*/

    }


  /*  public void addBtnHelper(ListView<Fighter> listView) {
        System.out.println(listView.getId().toString());

        if (Objects.equals(listView.getId().toString(), "fightersLvP1")) {
            System.out.println("team1Lv");
            Fighter selectedFighter = listView.getSelectionModel().getSelectedItem();
            teamOfFighters1.add(selectedFighter);
            System.out.println("Fighter added to team1: " + selectedFighter.getName());
            team1Lv.refresh();
        }

        if (Objects.equals(listView.getId().toString(), "fightersLvP2")) {

            System.out.println("team2Lv");
            Fighter selectedFighter = listView.getSelectionModel().getSelectedItem();
            teamsOfFighters2.add(selectedFighter);
            team2Lv.refresh();
            System.out.println("Fighter added to team2: " + selectedFighter.getName());
            team2Lv.refresh();


        }
    }*/



    public void onRemoveBtn(ActionEvent actionEvent) {
    }

    public void onDetailsBtn(ActionEvent actionEvent) {
    }

    public void onChoosePlayer2(ActionEvent actionEvent) {

    }

    public void onChoosePlayer1(ActionEvent actionEvent) {
    }
}
