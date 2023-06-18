package org.example.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import org.example.entity.User;
import org.example.logik.Match_Fight;
import org.example.view.DBUtils;
import repository.MatchRepository;

public class HistoryController {
    public static User currentUser;
    public ListView historyLv;

    MatchRepository matchRepository = new MatchRepository();
    public ObservableList<Match_Fight> matchList = FXCollections.observableArrayList(matchRepository.getHistoryById());

    public void btnOnHome(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent, "/home-view.fxml", "Home", null);
    }

    public void initialize(){
        historyLv.setItems(matchList);
 }

    public void onClearBtn(ActionEvent actionEvent) {
    matchRepository.clearHistory();
    historyLv.refresh();

    }
}
