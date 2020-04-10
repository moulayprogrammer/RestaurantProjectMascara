package Controllers;

import BddTools.UseBdd;
import Moduls.User;
import com.sun.javafx.collections.MappingChange;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static javafx.fxml.FXMLLoader.load;

public class UserController implements Initializable{
    @FXML
    TextField Username;
    @FXML
    TextField Password;
 public void Login(Event e){
    UseBdd useBdd=new UseBdd();
    User user=new User(Username.getText(),Password.getText());
     ArrayList<User> liste = useBdd.getAll();
     Map<String,String>map=new HashMap<String, String>();

         try {
             if(useBdd.isExist(user)){
                 Stage primaryStage=new Stage();
                 Parent root;
                 root = load(getClass().getResource("../Views/Category.fxml"));
                 Scene scene=new Scene(root,700,500);
                 primaryStage.setScene( scene );
                 primaryStage.show();
             }else {
                 JOptionPane.showMessageDialog(null,"يرجى التحقق من الاسم المستخدم و كلمة المرور");
             }
         } catch (IOException ex) {
             ex.printStackTrace();
         }


 }
 public void exit(){
     Platform.exit();
 }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
