package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProduitCon {
    public void AddProduit() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddProduit.fxml"));
        Scene scene=new Scene(root,463,638);
        primaryStage.setTitle("قائمة المنتوجات ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
}
