package com.lcaohoanq.loginsignupjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextArea password;

    @FXML
    private Button signUpHere;

    @FXML
    private Button submit;

    @FXML
    private TextArea username;

    @FXML
    void onCLickSignUpHere(ActionEvent event) {
        System.out.println("Sign up here clicked");
    }

    @FXML
    void onClickSubmit(ActionEvent event) {
        String user = username.getText();
        String pass = password.getText();
        if(user.equals("admin") && pass.equals("admin")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

}
