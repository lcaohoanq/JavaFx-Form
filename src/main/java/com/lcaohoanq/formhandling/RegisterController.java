package com.lcaohoanq.formhandling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView brandingImageView;

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField enterConfirmPasswordField;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private Button signupButton;

    @FXML
    private Button loginHere;

    @FXML
    private TextField usernameTextField;

    @FXML
    void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void signupButtonAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = enterPasswordField.getText();
        String confirmPassword = enterConfirmPasswordField.getText();

        if(isEmpty(username, password, confirmPassword)){
            handleEmptyFields();
        }else if(!isMatching(password, confirmPassword)){
            AlertHandler.IS_NOT_MATCHING("Password Mismatch", "Password and Confirm Password do not match", null);
        }else{
            //insert to database
            validateRegister(username, username, username, password);
        }

    }


    private boolean isEmpty(String username, String password, String confirmPassword){
        return username.isBlank() || password.isBlank() || confirmPassword.isBlank();
    }
    private boolean isMatching(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
    private void handleEmptyFields(){
        AlertHandler.IS_EMPTY_FIELD("Empty Fields", "Please fill in all fields", null);
    }
    public void validateRegister(String firstname, String lastname, String username, String password){
        DatabaseConnection connectNow = null;
        Connection connectDB = null;
        PreparedStatement statement = null;
        String insertUser = "INSERT INTO `user_account`" + "(`firstname`,`lastname`,`username`,`password`) " + "VALUES (?,?,?,?)";

        try{
            connectNow = new DatabaseConnection();
            connectDB = connectNow.getConnection();
            statement = connectDB.prepareStatement(insertUser);
            statement.setString(1,firstname);
            statement.setString(2,lastname);
            statement.setString(3,username);
            statement.setString(4,password);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                AlertHandler.IS_LOGIN_SUCCESS("Register Success", "Welcome " + usernameTextField.getText(), null);
            } else {
                throw new SQLException("Insert failed for " + usernameTextField.getText());
            }
        }catch(SQLException e){
            //MySQL Error for duplicate entry
            if(e.getErrorCode() == 1062){
                System.out.println("Username already exists");
            }else{
                System.out.println(e.getMessage());
            }

        }finally {
            // Closing resources
            try {
                if (statement != null)
                    statement.close();
                if (connectDB != null)
                    connectDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image brandingImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/lcaohoanq.branding.png").toExternalForm());
        brandingImageView.setImage(brandingImage);
    }
    @FXML
    void loginHereAction(ActionEvent event) {
        try {
            // Load the register.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/lcaohoanq/formhandling/login.fxml"));

            // Get the current scene and set the new root
            Scene scene = loginHere.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
