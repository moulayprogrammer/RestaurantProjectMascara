package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodsCon {

    @FXML
    Button addFButton;
    Stage stage = null;
    @FXML
    public void OpenAddFood(){
        Stage primaryStage=new Stage();
        Parent root = null;
        try {
            stage = (Stage) addFButton.getScene().getWindow();
            stage.close();
            root = FXMLLoader.load(getClass().getResource("../Views/AddFood.fxml "));
            Scene scene=new Scene(root,1292,706);
            primaryStage.setTitle("إضافة وجبة جديدة  ");
            primaryStage.setScene( scene );
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
