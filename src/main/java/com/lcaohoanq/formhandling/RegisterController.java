package com.lcaohoanq.formhandling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
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
    private Label loginMessageLabel;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    void cancelButtonAction(ActionEvent event) {
        Stage state = (Stage) cancelButton.getScene().getWindow();
        state.close();
    }

    @FXML
    void signupButtonAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = enterPasswordField.getText();
        String confirmPassword = enterConfirmPasswordField.getText();

        if(isEmpty(username, password, confirmPassword)){
            handleEmptyFields();
        }

    }

    private boolean isEmpty(String username, String password, String confirmPassword){
        return username.isBlank() || password.isBlank() || confirmPassword.isBlank();
    }
    private void handleEmptyFields(){
        AlertHandler.IS_EMPTY_FIELD("Empty Fields", "Please fill in all fields", null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image brandingImage = new Image(getClass().getResource("/com/lcaohoanq/formhandling/lcaohoanq.branding.png").toExternalForm());
        brandingImageView.setImage(brandingImage);
    }

}
