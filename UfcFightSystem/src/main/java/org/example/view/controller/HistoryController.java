package org.example.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.example.logik.Match_Fight;
import repository.MatchRepository;

public class HistoryController {

    public ListView historyLv;

    MatchRepository matchRepository = new MatchRepository();
    public ObservableList<Match_Fight> matchList = FXCollections.observableArrayList(matchRepository.getAll());

    public void initialize(){
        historyLv.setItems(matchList);
 }
}
