package pl.hansonq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 460, 360));
        primaryStage.show();
     //  System.out.println(Utils.makeHttpRequest("http://facebook.com"));
       // System.out.println(Utils.makeHttpsRequest("https://facebook.com"));

    }


    public static void main(String[] args) {
        launch(args);

    }
}
