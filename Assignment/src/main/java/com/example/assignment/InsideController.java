package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class InsideController implements Initializable {


    //-------------------------Attendance window------------------------

    @FXML
    private Button backBtnAttendence;

    @FXML
    private DatePicker dateTxt;

    @FXML
    private TextField empIdTxt;

    @FXML
    private TextField empNameTxt;

    @FXML
    private Button submitBtn;

    @FXML
    private ComboBox<String> hourInBox;

    @FXML
    private ComboBox<String> hourOutBox;

    @FXML
    private ComboBox<String> minInBox;

    @FXML
    private ComboBox<String> minOutBox;

    @FXML
    private RadioButton amIn;

    @FXML
    private RadioButton amOut;

    @FXML
    private RadioButton pmIn;

    @FXML
    private RadioButton pmOut;

    @FXML
    private ToggleGroup inRadioGroup;

    @FXML
    private ToggleGroup outRadioGroup;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hourInBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
        hourOutBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
        minInBox.getItems().addAll("00","05","10","15","20","25","30","35","40","45","50","55");
        minOutBox.getItems().addAll("00","05","10","15","20","25","30","35","40","45","50","55");
    }


    @FXML
    void backToWelcome(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtnAttendence.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    @FXML
    void submitAttendence(ActionEvent event) {
        String date = String.valueOf(dateTxt.getValue());
        String hourIn = String.valueOf(hourInBox.getValue());

        if (empIdTxt.getText().isBlank() || empNameTxt.getText().isBlank() || hourInBox.getValue() == null || hourOutBox.getValue() == null
                || minInBox.getValue() == null || minOutBox.getValue() == null || (!amIn.isSelected() && !pmIn.isSelected())
            || (!amOut.isSelected() && !pmOut.isSelected()) || date == "null"){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Missing Details");
            alert.setContentText("Please add details to the necessary fields");
            alert.showAndWait();

        }
        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done");
            alert.setHeaderText("Nice job, " + empNameTxt.getText() + " !");
            alert.setContentText("Details added successfully for the date " + date);
            alert.showAndWait();

        }
    }



    @FXML
    void hourInSelect(ActionEvent event) {

    }

    @FXML
    void hourOutSelect(ActionEvent event) {

    }

    @FXML
    void minInSelect(ActionEvent event) {

    }

    @FXML
    void minOutSelect(ActionEvent event) {

    }

    @FXML
    void amInRadio(ActionEvent event) {

    }

    @FXML
    void amOutRadio(ActionEvent event) {

    }

    @FXML
    void pmInRadio(ActionEvent event) {

    }

    @FXML
    void pmOutRadio(ActionEvent event) {

    }

}
