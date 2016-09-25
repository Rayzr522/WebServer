package com.rayzr522.webserver.fx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

	primaryStage.setTitle("Hello world!");

	Parent root = loadRoot("/Main");

	Scene scene = new Scene(root, 800, 600);

	primaryStage.setScene(scene);
	primaryStage.setMinHeight(scene.getHeight());
	primaryStage.setMinWidth(scene.getWidth());

	primaryStage.show();

	System.out.println("Init complete");

    }

    public static void main(String[] args) {
	launch(args);
    }

    private static Parent loadRoot(String path) throws IOException {
	return FXMLLoader.<Parent> load(Main.class.getResource(path + ".fxml"));
    }

}
