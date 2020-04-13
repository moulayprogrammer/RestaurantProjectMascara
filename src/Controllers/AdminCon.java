package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminCon {
    public  void Users() throws IOException {

            Stage primaryStage=new Stage();
        Parent root = null;

            root = FXMLLoader.load(getClass().getResource("../Views/User.fxml"));

        Scene scene=new Scene(root,1152,610);
            primaryStage.setTitle("لوحة التحكم ");
            primaryStage.setScene( scene );
            primaryStage.show();


    }
}
