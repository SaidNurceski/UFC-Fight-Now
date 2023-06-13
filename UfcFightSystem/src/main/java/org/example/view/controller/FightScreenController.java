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
import org.example.entity.Division;
import org.example.entity.Fighter;
import org.example.view.App;

import java.io.IOException;
import java.util.Objects;

public class FightScreenController<T> {
    public ListView fightersLvP2;
    public ListView fightersLvP1;
    public ObservableList<Fighter> fighterObservableList = FXCollections.observableArrayList();
    public ObservableList<Fighter> teamOfFighters1 = FXCollections.observableArrayList();
    public ObservableList<Fighter> teamsOfFighters2 = FXCollections.observableArrayList();

    public ListView team1Lv;
    public ListView team2Lv;

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    private FilteredList<Fighter> fighterFilteredList = null;

    public void initialize() {
        fighterObservableList.add(new Fighter("Conor McGregor", 2, Division.Lightweight, 2, "23-7"));
        fighterObservableList.add(new Fighter("Khabib Nurmagomedov", 1, Division.Lightweight, 1, "29-0"));
        fighterFilteredList = new FilteredList<Fighter>(fighterObservableList);
        fightersLvP1.setItems(fighterFilteredList);
        fightersLvP2.setItems(fighterFilteredList);

        team1Lv.setItems(teamOfFighters1);
        team2Lv.setItems(teamsOfFighters2);
    }


    public void addBtnHelper(ListView<Fighter> listView) {
        System.out.println(listView.getId().toString());

        if (Objects.equals(listView.getId().toString(), "fightersLvP1")) {
            System.out.println("team1Lv");
            Fighter selectedFighter = listView.getSelectionModel().getSelectedItem();
            teamOfFighters1.add(selectedFighter);
            System.out.println("Fighter added to team: " + selectedFighter.getName());
            team1Lv.refresh();
        }

        if (Objects.equals(listView.getId().toString(), "fightersLvP2")) {

            System.out.println("team2Lv");
            Fighter selectedFighter = listView.getSelectionModel().getSelectedItem();
            teamsOfFighters2.add(selectedFighter);
            team2Lv.refresh();
            System.out.println("Fighter added to team: " + selectedFighter.getName());
            team2Lv.refresh();


        }
    }


    public void onAddBtn(ActionEvent actionEvent) {
        addBtnHelper(fightersLvP1);
        addBtnHelper(fightersLvP2);

    }

    public void onRemoveBtn(ActionEvent actionEvent) {
    }

    public void onDetailsBtn(ActionEvent actionEvent) {
    }
}
