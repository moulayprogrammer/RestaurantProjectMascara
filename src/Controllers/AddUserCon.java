package Controllers;

import BddTools.UserBdd;
import Moduls.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        user.setType(type.getSelectionModel().getSelectedItem().toString());
        UserBdd userBdd=new UserBdd();


        if(!userBdd.isExistuser(user)){
            String ps = password.getText();
            String psC = confirmpassword.getText();
            if(ps.matches(psC)) {
                boolean adduser = userBdd.insert(user);
                if (adduser)
                    JOptionPane.showMessageDialog(null, "لقد تم إضافة المستخدم بنجاح");
            }else{
                System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            }
        }else {
            JOptionPane.showMessageDialog(null,"الاسم المستخدم هذا موجود مسبقا ");
            username.setText("");
            password.setText("");
            confirmpassword.setText("");
            nom.setText("");
            prenom.setText("");
            tel.setText("");
        }


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         ObservableList<String> list= FXCollections.observableArrayList("Admin","Magasinier","Caissier","Cuisine");
        type.setItems(list);

    }
}
