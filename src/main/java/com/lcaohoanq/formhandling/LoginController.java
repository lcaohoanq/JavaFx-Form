package com.lcaohoanq.formhandling;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image brandingImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/lcaohoanq.branding.jpg").toExternalForm());
        brandingImageView.setImage(brandingImage);

        Image lockImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/lcaohoanq.lock.png").toExternalForm());
        lockImageView.setImage(lockImage);
    }
    public void loginButtonAction(ActionEvent event) {
        if((usernameTextField .getText().isBlank() == false )&& (enterPasswordField.getText().isBlank() == false)){
//            loginMessageLabel.setText("You tried to login");
            validateLogin();
        }else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText() + "' and password = '" + enterPasswordField.getText() + "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Congrats!");
                }else{
                    loginMessageLabel.setText("Invalid login. Please try again.");
                }
            }


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}