package Controllers;

import BddTools.UserBdd;
import Moduls.User;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static javafx.fxml.FXMLLoader.load;

public class LoginCon {
    @FXML
    TextField Username;
    @FXML
    TextField Password;
    public void Login(Event e){
    UserBdd userBdd=new UserBdd();
    User user=new User(Username.getText(),Password.getText());
     ArrayList<User> list = userBdd.getAll();
     Map<String,String>map=new HashMap<String, String>();
     for (User a:list){
         map.put(a.getUserName(),a.getType());
     }
     String type=map.get(Username.getText());
     String Admin="Admin";
         try {
             if(userBdd.isExist(user)){
                 Stage primaryStage=new Stage();
                    if(type.equals("Admin")){
                    Parent  root = FXMLLoader.load(getClass().getResource("../Views/Admin.fxml"));
                    Scene scene=new Scene(root,700,500);
                        primaryStage.setTitle("لوحة التحكم ");
                    primaryStage.setScene( scene );
                    primaryStage.show();
                }else {
                    if(type.equals("Magasinier")){
                            Parent  root = FXMLLoader.load(getClass().getResource("../Views/Magasinier.fxml"));
                            Scene scene=new Scene(root,700,500);
                        primaryStage.setTitle("لوحة التحكم ");
                            primaryStage.setScene( scene );
                            primaryStage.show();
                    }else{
                        if(type.equals("Caissier")){
                            Parent  root = FXMLLoader.load(getClass().getResource("../Views/Caissier.fxml"));
                            Scene scene=new Scene(root,700,500);
                            primaryStage.setTitle("لوحة التحكم ");
                            primaryStage.setScene( scene );
                            primaryStage.show();

                        }else{
                            Parent  root = FXMLLoader.load(getClass().getResource("../Views/Cuisine.fxml"));
                            Scene scene=new Scene(root,1152,628);
                            primaryStage.setTitle("لوحة التحكم ");
                            primaryStage.setScene( scene );
                            primaryStage.show();
                        }
                    }
                }



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


}
