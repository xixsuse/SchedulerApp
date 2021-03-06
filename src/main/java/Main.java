package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    public static Connection con;
    public static Stage window;
    public static User user;

    public static void main(String[] args) {
        con = ConnectionManager.getConnection();
        launch(args);
    }

    public static void closeProgram() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Couldn't close connection");
        }
        window.close();
    }

    public static void update(Parent root) {
        window.getScene().setRoot(root);
        window.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        window.setTitle("J&K Scheduler");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/view/SignUp.fxml"));
        Scene scene = new Scene(root, 1280, 720);

        window.setScene(scene);
        window.show();
    }
}
