package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FacturMagasinierCon {
    public void AddFactuer() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddFactuerMagasine.fxml"));
        Scene scene=new Scene(root,1196,690);
        primaryStage.setTitle("قائمة المنتوجات ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
}
