package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminCon {
    public  void Users() throws IOException {

            Stage primaryStage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../Views/User.fxml"));
            Scene scene=new Scene(root,1152,610);
            primaryStage.setTitle("لوحة التحكم المستخدمين  ");
            primaryStage.setScene( scene );
            primaryStage.show();


    }
    public  void Magasine() throws IOException{
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Mgasinier.fxml"));
        Scene scene=new Scene(root,1080,606);
        primaryStage.setTitle("لوحة التحكم امين الخزن  ");
        primaryStage.setScene( scene );
        primaryStage.show();

    }
    public  void Cuisine() throws IOException{
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Cuisine.fxml"));
        Scene scene=new Scene(root,1152,610);
        primaryStage.setTitle("لوحة التحكم الطباخ  ");
        primaryStage.setScene( scene );
        primaryStage.show();

    }
    public  void Caissier() throws IOException{
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Caissier.fxml"));
        Scene scene=new Scene(root,1152,610);
        primaryStage.setTitle("لوحة التحكم الصراف  ");
        primaryStage.setScene( scene );
        primaryStage.show();

    }
}
