package org.example.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.css.Match;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.entity.Fighter;
import org.example.logik.FightGame;
import org.example.view.DBUtils;
import repository.FighterRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;


public class FightChooseController {

    public Label fighter1Label;
    public Label fighter2Label;
    private List<Fighter> choosedFighter = new LinkedList<>();
    public ListView fighterLv;
    FighterRepository fighterRepository = new FighterRepository();


    public Button btnHome;
    private ObservableList<Fighter> fighterObservableList = FXCollections.observableArrayList(fighterRepository.getAll());
    private FilteredList<Fighter> fighterFilteredList = null;

    public void initialize(){
        btnHome.setOnAction(actionEvent -> {
            DBUtils.changeScene(actionEvent, "/home-view.fxml", "Home", null);
        });

        fighterFilteredList = new FilteredList<>(fighterObservableList, p -> true);

        fighterLv.setItems(fighterFilteredList);

    }

    public void onChooseBtn(ActionEvent actionEvent) {
        Fighter fighter = (Fighter) fighterLv.getSelectionModel().getSelectedItem();
        choosedFighter.add(fighter);
        if(choosedFighter.size() == 1){
            fighter1Label.setText(fighter.getName());

        }else if(choosedFighter.size() == 2){
            fighter2Label.setText(fighter.getName());
        }
    }

    public void onFightBtn(ActionEvent actionEvent) {
        Fighter fighter1 = choosedFighter.get(1);
        Fighter fighter2 = choosedFighter.get(2);

        FightGame match = new FightGame(fighter1, fighter2);

    }
}
