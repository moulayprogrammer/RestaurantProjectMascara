package Controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CuisineCon {
    public void category() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/CategoryFood.fxml "));
        Scene scene=new Scene(root,646,424);
        primaryStage.setTitle("إدرة الاصناف ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    public void food() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Food.fxml "));
        Scene scene=new Scene(root,1053,628);
        primaryStage.setTitle("إدرة الوجبات ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
}
