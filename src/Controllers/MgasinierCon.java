package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MgasinierCon {
    public void Fournisour() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Fornisour.fxml"));
        Scene scene=new Scene(root,1000,607);
        primaryStage.setTitle("لوحة التحكم ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
}
