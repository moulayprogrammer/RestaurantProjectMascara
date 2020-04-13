package Controllers;

import BddTools.UserBdd;
import Moduls.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddUserCon implements Initializable {
    @FXML
    private ComboBox type;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmpassword;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    public void AddUser(){
    User user =new User();
        user.setUserName(username.getText());
        user.setPassWord(password.getText());
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        user.setTel(tel.getText());
       // user.setType();
        UserBdd userBdd=new UserBdd();
        boolean adduser=userBdd.insert(user);
        if(adduser)
            JOptionPane.showMessageDialog(null,"لقد تم إضافة المستخدم بنجاح");

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         ObservableList<String> list= FXCollections.observableArrayList("اAdmin","Magasinier","Caissier","Cuisine");
        type.setItems(list);

    }
}
