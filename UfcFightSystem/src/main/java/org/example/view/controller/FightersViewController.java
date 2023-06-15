package org.example.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.entity.Fighter;
import org.example.view.DBUtils;
import repository.FighterRepository;

public class FightersViewController {
    public ListView fightersLv;
    public TextField nameField;
    public TextField recordField;
    public TextField divisionField;
    public TextField ageField;
    public TextField nickNameField;

    FighterRepository fighterRepository = new FighterRepository();

    private  ObservableList<Fighter> fighterObservableList = FXCollections.observableArrayList(fighterRepository.getAll());
    private FilteredList<Fighter> fighterFilteredList = null;

    public void initialize(){
        fighterFilteredList = new FilteredList<>(fighterObservableList, p -> true);

        fightersLv.setItems(fighterFilteredList);

    }
    public void btnOnDetails(ActionEvent actionEvent) {
    }

    public void btnOnHome(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "/home-view.fxml", "Home", null);
    }

    public void btnOnInsert(ActionEvent actionEvent) {
       // try {
            Fighter fighter = new Fighter(nameField.getText(),
                    Integer.parseInt( ageField.getText()),
                    divisionField.getText(),
                    recordField.getText(),
                    Integer.parseInt(recordField.getText()),nickNameField.getText());

            System.out.println(nameField.getText());
            System.out.println(ageField.getText());
            System.out.println(divisionField.getText());
            System.out.println(recordField.getText());
            System.out.println(recordField.getText());

            fighterRepository.insert(fighter);
            fighterObservableList.add(fighter);
            fightersLv.refresh();

      /*  } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Incorrect data entered!");
            alert.showAndWait();
        }*/
    }

    public void btnOnFighterDetails(ActionEvent actionEvent) {
        try{
            Fighter currentFighter = (Fighter) fightersLv.getSelectionModel().getSelectedItem();
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


}
