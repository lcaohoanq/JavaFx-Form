package com.lcaohoanq.formhandling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("Hello!");
        stage.initStyle(StageStyle.UNDECORATED); // Hide the window's title bar (close, minimize, maximize buttons)
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}