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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateUserCon implements Initializable {
    @FXML
    private ComboBox type;
    @FXML
    public TextField username;
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

    public void Update(){
    User user =new User();
    UserCon userCon=new UserCon();
       System.out.println(userCon.getSelectdMeeals());

        UserBdd userBdd=new UserBdd();
        if(!userBdd.isExistuser(user)){
           if(password.equals(confirmpassword.getText())) {
               boolean adduser = userBdd.insert(user);
               if (adduser)
                   JOptionPane.showMessageDialog(null, "لقد تم إضافة المستخدم بنجاح");
           }else {
               JOptionPane.showMessageDialog(null,"كلمة المرور غير متطابقة ");
               username.setText("");
               password.setText("");
               confirmpassword.setText("");
               nom.setText("");
               prenom.setText("");
               tel.setText("");
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
