package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaveReqController {

    //-------------------------Leave Request window------------------------

    @FXML
    private Button backBtnLeave;

    @FXML
    private RadioButton duration1;

    @FXML
    private RadioButton duration2;

    @FXML
    private RadioButton duration3;

    @FXML
    private DatePicker endDateTxt;

    @FXML
    private Label errorLabel;

    @FXML
    private ToggleGroup group1;

    @FXML
    private ToggleGroup group2;

    @FXML
    private ToggleGroup group3;

    @FXML
    private RadioButton reason1;

    @FXML
    private RadioButton reason2;

    @FXML
    private RadioButton reason3;

    @FXML
    private RadioButton reason4;

    @FXML
    private RadioButton reason5;

    @FXML
    private RadioButton reason6;

    @FXML
    private DatePicker startDateTxt;

    @FXML
    private Button submitBtnLeave;

    @FXML
    private TextArea textArea;

    @FXML
    private RadioButton type1;

    @FXML
    private RadioButton type2;

    @FXML
    private RadioButton type3;

    @FXML
    void backToWelcomeLeave(ActionEvent event) throws IOException {

        Stage stage = (Stage) backBtnLeave.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void submitLeave(ActionEvent event) {

        String startDate = String.valueOf(startDateTxt.getValue());
        String endDate = String.valueOf(endDateTxt.getValue());

        if((!type1.isSelected() && !type2.isSelected() && !type3.isSelected())
                || (!duration1.isSelected() && !duration2.isSelected() && !duration3.isSelected())
                ||(!reason1.isSelected() && !reason2.isSelected() && !reason3.isSelected()
                && !reason4.isSelected() && !reason5.isSelected() && !reason6.isSelected())
                || startDate == "null" || endDate == "null") {

            errorLabel.setText("Fields marked with ' * ' are mandatory");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Missing Details");
            alert.setContentText("Please add details to the mandatory fields to proceed");
            alert.showAndWait();

        }
        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done");
            alert.setHeaderText("Your request submitted successfully");
            alert.setContentText("HR will contact you soon after confirmation");
            alert.showAndWait();


        }

    }

    @FXML
    void d1Click(ActionEvent event) {

    }

    @FXML
    void d2Click(ActionEvent event) {

    }

    @FXML
    void d3Click(ActionEvent event) {

    }

    @FXML
    void r1Click(ActionEvent event) {

    }

    @FXML
    void r2Click(ActionEvent event) {

    }

    @FXML
    void r3Click(ActionEvent event) {

    }

    @FXML
    void r4Click(ActionEvent event) {

    }

    @FXML
    void r5Click(ActionEvent event) {

    }

    @FXML
    void r6Click(ActionEvent event) {

    }

    @FXML
    void t1Click(ActionEvent event) {

    }

    @FXML
    void t2Click(ActionEvent event) {

    }

    @FXML
    void t3Click(ActionEvent event) {

    }

}
