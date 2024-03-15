package com.lcaohoanq.formhandling;

import javafx.scene.control.Alert;

public class AlertHandler {
    private static Alert alert;
    private static void setTypeAlert(Alert.AlertType type){
        alert = new Alert(type);
    }
    public static void IS_EMPTY_FIELD(String title, String content, String moreContent){
        setTypeAlert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.setContentText(moreContent);

        // Display the dialog
        alert.showAndWait();
    }
    public static void IS_NOT_SUPPORT(){
        setTypeAlert(Alert.AlertType.ERROR);
        alert.setTitle("Unsupported feature");
        alert.setHeaderText("This feature is not supported now");

        // Display the dialog
        alert.showAndWait();
    }
    public static void IS_NOT_MATCHING(String title, String content, String moreContent){
        setTypeAlert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.setContentText(moreContent);

        // Display the dialog
        alert.showAndWait();
    }
    public static void IS_LOGIN_FAILED(String title, String content, String moreContent){
        setTypeAlert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.setContentText(moreContent);

        // Display the dialog
        alert.showAndWait();
    }
    public static void IS_LOGIN_SUCCESS(String title, String content, String moreContent){
        setTypeAlert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.setContentText(moreContent);

        // Display the dialog
        alert.showAndWait();
    }
}
