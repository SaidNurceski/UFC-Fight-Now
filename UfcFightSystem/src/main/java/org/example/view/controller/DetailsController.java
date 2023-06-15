package org.example.view.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import org.example.entity.Fighter;
import org.example.view.DBUtils;

public class DetailsController {
    public static Fighter currentFighter = null;
    public Label divisionLabel;
    public Label rankLabel;
    public Label recordLabel;
    public Label labelAge;
    public Label nameLabel;
    public Label nickNameLabel;

    public void initialize(){
        System.out.println(currentFighter);
        nameLabel.setText(currentFighter.getName());
        rankLabel.setText(String.valueOf(currentFighter.getRank()));
        recordLabel.setText(currentFighter.getRecord());
        divisionLabel.setText(currentFighter.getDivisionName());
        labelAge.setText(String.valueOf(currentFighter.getAge()));
        nickNameLabel.setText(currentFighter.getNickName());
        

    }

    public void btnOnBack(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent, "/fighters-view.fxml", "Fighters", null);
    }
}
