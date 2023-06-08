package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML
    private Button attendenceBtn;

    @FXML
    private Label empIdLabel;

    @FXML
    private Button leaveReqBtn;

    @FXML
    private Label ppDepartment;

    @FXML
    private Label ppName;

    @FXML
    private Button signoutBtn;

    @FXML
    void attendence(ActionEvent event) throws IOException {

        Stage stage = (Stage) attendenceBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AttendanceMark-view.fxml"));
        primaryStage.setTitle("Employee Attendance");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void leaveReq(ActionEvent event) throws IOException {

        Stage stage = (Stage) leaveReqBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LeaveReq-view.fxml"));
        primaryStage.setTitle("Employee Leave");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void signout(ActionEvent event) throws IOException {

        Stage stage = (Stage) signoutBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            profile Label = new profile();
            String abc[] = Label.ppLabels();

            ppName.setText(abc[0] + " " + abc[1]);
            ppDepartment.setText(abc[2] + " Department");
            empIdLabel.setText("Employee ID - " + abc[3]);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
