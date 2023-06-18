package org.example.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entity.Fighter;
import org.example.view.DBUtils;
import repository.DataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailsController {
    public static Fighter currentFighter = null;
    public Label divisionLabel;
    public Label rankLabel;
    public Label recordLabel;
    public Label labelAge;
    public Label nameLabel;
    public Label nickNameLabel;
    public ImageView imageFighter;

    @FXML
    private void close_app(MouseEvent event){
        System.exit(0);
    }

   /* private String getImageByFighter(){
        System.out.println("get image by fighter");
        System.out.println(currentFighter.getName());
        try{
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT PHOTO from Fighter where NAME = ?");
            preparedStatement.setString(1, currentFighter.getName());
            preparedStatement.executeQuery();
            System.out.println(preparedStatement.getResultSet().getString("PHOTO"));
            return preparedStatement.getResultSet().getString("PHOTO");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return "";
    }*/
   private String getImageByFighter() {
       System.out.println("get image by fighter");
       System.out.println(currentFighter.getName());
       try {
           Connection connection = DataBase.establishConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT PHOTO FROM Fighter WHERE NAME = ?");
           preparedStatement.setString(1, currentFighter.getName());
           ResultSet resultSet = preparedStatement.executeQuery();

           if (resultSet.next()) {
               System.out.println(resultSet.getString("PHOTO"));
               return resultSet.getString("PHOTO");
           } else {
               System.out.println("No photo found for the fighter.");
           }
       } catch (SQLException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error");

                alert.showAndWait();
         }
       return "";
   }


    public void initialize() throws FileNotFoundException {
        System.out.println(currentFighter);
        nameLabel.setText(currentFighter.getName());
        rankLabel.setText(String.valueOf(currentFighter.getRank()));
        recordLabel.setText(currentFighter.getRecord());
        divisionLabel.setText(currentFighter.getDivisionName());
        labelAge.setText(String.valueOf(currentFighter.getAge()));

        System.out.println("HIER IST DER NICKNAME");
        System.out.println(currentFighter.getNickName());

        nickNameLabel.setText(currentFighter.getNickName());
        System.out.println(getImageByFighter());
        FileInputStream fileInputStream = new FileInputStream(getImageByFighter());
        imageFighter.setImage(new Image(fileInputStream));
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

    public void btnHome(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent, "/home-view.fxml", "Home", null);
    }

    public void logoutBtn(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent, "/login-view.fxml", "Login", null);
    }

   /* public void btnOnBack(ActionEvent actionEvent) {
        DBUtils.changeScene(actionEvent, "/fighters-view.fxml", "Fighters", null);
    }*/
}
