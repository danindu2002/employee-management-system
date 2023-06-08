package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {

    //------------------------ main window --------------------------
    public static String Username;
    public static String Password;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField password;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField username;

    @FXML
    private Label loginTxt;

    @FXML
    private Button quitBtn;

    //----------------------- signup window -------------------------

    @FXML
    private Button backBtn;

    @FXML
    private TextField department;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField passwordSignup;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField usernameSignup;



    //------------------------ main window --------------------------

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {

        if (username.getText().isBlank() == false || password.getText().isBlank() == false){
            loginValidation();
        }
        else{
            loginTxt.setText("Missing required credentials");
        }
    }

    public void loginValidation() throws SQLException, IOException {
        DatabaseConnection con = new DatabaseConnection();
        Connection db = con.getdbconnection();

        String usernameLogin = "select count(1) from `ems`.`employee_details` where Username ='"+username.getText()+"' and Password ='"+password.getText()+"'";

        Username = username.getText();
        Password = password.getText();

        Statement statement = db.createStatement();
        ResultSet resultSet = statement.executeQuery(usernameLogin);

        while(resultSet.next()){
            if (resultSet.getInt(1) == 1) {
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
                primaryStage.setTitle("Welcome");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();

            }
            else {
                loginTxt.setText("Incorrect credentials");
            }
        }
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        Stage stage = (Stage) signupBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signup-view.fxml"));
        primaryStage.setTitle("Sign Up");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void txtPassword(ActionEvent event) {
    }

    @FXML
    void txtUsername(ActionEvent event) {
    }

    @FXML
    void quit(ActionEvent event) {
        System.exit(0);

    }

    //----------------------- signup window -------------------------

    @FXML
    void backHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Employee Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    @FXML
    void register(ActionEvent event) throws SQLException, IOException {
        DatabaseConnection con = new DatabaseConnection();
        Connection db = con.getdbconnection();

        String signup = "INSERT INTO `ems`.`employee_details` (`First_Name`,`Last_Name`,`Department`,`Username`,`Password`) VALUES (?,?,?,?,?)";

        PreparedStatement pStatement = db.prepareStatement(signup);
        pStatement.setString(1,firstName.getText());
        pStatement.setString(2,lastName.getText());
        pStatement.setString(3,department.getText());
        pStatement.setString(4,usernameSignup.getText());
        pStatement.setString(5,passwordSignup.getText());
        pStatement.execute();

        if (firstName.getText().isBlank() || lastName.getText().isBlank() || department.getText().isBlank() ||
                usernameSignup.getText().isBlank() || passwordSignup.getText().isBlank()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please enter details for all necessary fields");
            alert.showAndWait();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registered");
            alert.setHeaderText("Details were added successfully");
            alert.setContentText("Please login using the new details");
            alert.showAndWait();

            Stage stage = (Stage) registerBtn.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            primaryStage.setTitle("Employee Management System");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }
    }
}
