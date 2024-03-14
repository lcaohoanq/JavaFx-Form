package com.lcaohoanq.formhandling;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Button signupHere;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView ggImageView;
    @FXML
    private ImageView fbImageView;
    @FXML
    private ImageView xImageView;
    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image brandingImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/lcaohoanq.branding.png").toExternalForm());
        brandingImageView.setImage(brandingImage);

        Image logoImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/fpt.png").toExternalForm());
        logoImageView.setImage(logoImage);

        Image ggImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/google.png").toExternalForm());
        ggImageView.setImage(ggImage);

        Image fbImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/facebook.png").toExternalForm());
        fbImageView.setImage(fbImage);

        Image xImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/twitter.png").toExternalForm());
        xImageView.setImage(xImage);
    }
    public void loginButtonAction(ActionEvent event) {
        if((!usernameTextField.getText().isBlank()) && (!enterPasswordField.getText().isBlank())){
//            loginMessageLabel.setText("You tried to login");
            validateLogin();
        }else{
            handleEmptyFields();
        }
    }
    private void handleEmptyFields(){
        AlertHandler.IS_EMPTY_FIELD("Empty Fields", "Please fill in all fields", null);
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
                    AlertHandler.IS_LOGIN_SUCCESS("Login Success", "Welcome " + usernameTextField.getText(), null);
                }else{
                    AlertHandler.IS_LOGIN_FAILED("Login Failed", "Wrong username or password", null);
                }
            }


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    private void handleSuccess(){
        AlertHandler.IS_LOGIN_SUCCESS("Login Success", "Welcome " + usernameTextField.getText(), null);
    }
    public void signupHereAction(ActionEvent event) {
        try {
            // Load the register.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/lcaohoanq/formhandling/register.fxml"));

            // Get the current scene and set the new root
            Scene scene = signupHere.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}