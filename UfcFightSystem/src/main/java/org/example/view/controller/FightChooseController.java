package org.example.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.entity.Fighter;
import org.example.logik.Match_Fight;
import org.example.view.DBUtils;
import repository.FighterRepository;
import repository.MatchRepository;

import java.util.LinkedList;
import java.util.List;


public class FightChooseController {
    MatchRepository matchRepository = new MatchRepository();

    public Label fighter1Label;
    public Label fighter2Label;
    private List<Fighter> choosedFighter = new LinkedList<>();
    public ListView fighterLv;
    FighterRepository fighterRepository = new FighterRepository();


    public Button btnHome;
    private ObservableList<Fighter> fighterObservableList = FXCollections.observableArrayList(fighterRepository.getAll());
    private FilteredList<Fighter> fighterFilteredList = null;

    public void initialize() {
        btnHome.setOnAction(actionEvent -> {
            DBUtils.changeScene(actionEvent, "/home-view.fxml", "Home", null);
        });

        fighterFilteredList = new FilteredList<>(fighterObservableList, p -> true);

        fighterLv.setItems(fighterFilteredList);

    }

    public void onChooseBtn(ActionEvent actionEvent) {
        Fighter fighter = (Fighter) fighterLv.getSelectionModel().getSelectedItem();
        choosedFighter.add(fighter);
        if (choosedFighter.size() == 1) {
            fighter1Label.setText(fighter.getName());

        } else if (choosedFighter.size() == 2) {
            fighter2Label.setText(fighter.getName());
        }
    }

    public void onFightBtn(ActionEvent actionEvent) {
        System.out.println(choosedFighter.size());
        System.out.println(choosedFighter.get(0).getName());
        System.out.println(choosedFighter.get(0).getId());
        System.out.println(choosedFighter.get(1).getName());
        System.out.println(choosedFighter.get(1).getId());

        if (choosedFighter.size() == 2) {
            Fighter fighter1 = choosedFighter.get(0);
            Fighter fighter2 = choosedFighter.get(1);
            Match_Fight match = new Match_Fight(fighter1, fighter2);
            matchRepository.insert(match);
        }

            /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("You need to choose 2 fighters");
            alert.showAndWait();*/

    }
        /*Fighter fighter1 = choosedFighter.get(1);
        Fighter fighter2 = choosedFighter.get(2);
        System.out.println(fighter1.getName());
        System.out.println(fighter2.getName());

        Match_Fight match = new Match_Fight(fighter1, fighter2);
        matchRepository.save(match);*/


}
