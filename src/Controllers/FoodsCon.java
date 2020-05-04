package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodsCon {

    @FXML
    Button addFButton;
    @FXML
    AnchorPane foods;
    @FXML
    AnchorPane paneFoods;
    @FXML
    AnchorPane paneAddFood;
    @FXML
    AnchorPane addFood;

    @FXML
    public void OpenAddFood(){
        foods.setVisible(false);
        paneFoods.setVisible(false);
        addFood.setVisible(true);
        paneAddFood.setVisible(true);
    }

    @FXML
    public void OpenFoodPage() {
        foods.setVisible(true);
        paneFoods.setVisible(true);
        addFood.setVisible(false);
        paneAddFood.setVisible(false);
    }

}
