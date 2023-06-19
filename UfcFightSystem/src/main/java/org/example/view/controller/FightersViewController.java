package org.example.view.controller;

import java.util.regex.*;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.entity.Fighter;
import org.example.view.DBUtils;
import repository.FighterRepository;

public class FightersViewController {
    public ListView fightersLv;
    public TextField nameField;
    public TextField recordField;
    public TextField ageField;
    public TextField nickNameField;
    public TextField rankField;
    @FXML
    private ComboBox divisionField;
    @FXML
    private Label label;

    @FXML
    void Select(ActionEvent event) {
        String s = divisionField.getSelectionModel().getSelectedItem().toString();
        label.setText(s);
    }

    FighterRepository fighterRepository = new FighterRepository();

    private  ObservableList<Fighter> fighterObservableList = FXCollections.observableArrayList(fighterRepository.getAll());
    private FilteredList<Fighter> fighterFilteredList = null;
    public void initialize(){
        fighterFilteredList = new FilteredList<>(fighterObservableList, p -> true);

        fightersLv.setItems(fighterFilteredList);
        ObservableList<String> list = FXCollections.observableArrayList("LIGHTWEIGHT", "MIDDLEWEIGHT", "FEATHERWEIGHT", "HEAVYWEIGHT");
        divisionField.setItems(list);
    }
    public void btnOnDetails(ActionEvent actionEvent) {
    }

    public void btnOnHome(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "/home-view.fxml", "Home", null);
    }

    public void btnOnInsert(ActionEvent actionEvent) {
    //   try {
           String s = "C:\\Saidprpr\\3.Klasse\\PR JAVA 3.Klasse\\UFC_Projekt\\UFC-Fight-Now\\UfcFightSystem\\src\\main\\resources\\img\\unbekannt.png";

        if (!Pattern.matches("[a-zA-Z]+", nameField.getText()) || nameField.getText().trim().isEmpty()) {
            showAlert("Fehler", "Invalid Name! Name should only contain alphabetic characters");
        } else if (!Pattern.matches("\\d+", ageField.getText()) || ageField.getText().trim().isEmpty()) {
            showAlert("Fehler", "Invalid Age! Age should only contain numeric digits");
        } else if (!Pattern.matches("\\d+-\\d+-\\d+", recordField.getText()) || recordField.getText().trim().isEmpty()) {
            showAlert("Fehler", "Invalid Record! Record should be in the format 10-0-0");
        } else if (!Pattern.matches("^[A-Za-z0-9 ]+$", nickNameField.getText()) || nickNameField.getText().trim().isEmpty()) {
            showAlert("Fehler", "Invalid Nickname! Nickname should only contain alphabetic characters");
        } else if (!Pattern.matches("\\d+", rankField.getText()) || rankField.getText().trim().isEmpty()) {
            showAlert("Fehler", "Invalid Rank! Rank should only contain numeric digits");
        } else {
            Fighter fighter = new Fighter(label.getText(),
                    nameField.getText(),
                    Integer.parseInt(ageField.getText()),
                    s,
                    recordField.getText(),
                    nickNameField.getText(),
                    Integer.parseInt(rankField.getText()));

            System.out.println(nameField.getText());
            System.out.println(ageField.getText());
            System.out.println(s);
            System.out.println(recordField.getText());
            System.out.println(recordField.getText());

            fighterRepository.insert(fighter);
            fighterObservableList.add(fighter);
            fightersLv.refresh();
        }

    /*  } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Incorrect data entered!");
            alert.showAndWait();
        }*/
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void btnOnFighterDetails(ActionEvent actionEvent) {
        try{
            Fighter currentFighter = (Fighter) fightersLv.getSelectionModel().getSelectedItem();
            System.out.println(currentFighter.getNickName());
            DetailsController.currentFighter = currentFighter;
            System.out.println(currentFighter);
            DBUtils.changeScene(actionEvent, "/details-view.fxml", "Details", null);

        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Not selected Fighter!");
            alert.showAndWait();
        }

    }

    @FXML
    private void close_app(MouseEvent event){
        System.exit(0);
    }

    public void onBtnHistory(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent,"/history-view.fxml","History",null);
    }

    public void btn_fighters(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent,"/fighters-view.fxml","Fighters",null);
    }

    public void btnFighters(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent,"/fight-choose-view.fxml","Choose",null);
    }

    public void logoutBtn(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent, "/login-view.fxml", "Login", null);
    }
}
