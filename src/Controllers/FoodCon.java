package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodCon {

    public void AddFood() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddFood.fxml "));
        Scene scene=new Scene(root,1292,706);
        primaryStage.setTitle("إضافة وجبة جديدة  ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }

}
