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

    private User oldUser;
    private User user1;

    public void Init(User user){
        oldUser = user;
        UserBdd userBdd=new UserBdd();
        user1=userBdd.getUser(oldUser);
        Display(user1);

    }

    private void Display(User  user){
        username.setText(user.getUserName());
        password.setText(user.getPassWord());
        confirmpassword.setText(user.getPassWord());
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        tel.setText(user.getTel());
        type.setValue(user.getType());
    }

    public void Update(){
        UserCon userCon=new UserCon();
        UserBdd userBdd=new UserBdd();
        User user =new User();
       // User user2=new User(userCon.getSelectdMeeals());

        user.setUserName(username.getText());
        user.setPrenom(password.getText());
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        user.setTel(tel.getText());
        user.setType(type.getSelectionModel().getSelectedItem().toString());

        String ps = password.getText();
        String psC = confirmpassword.getText();
        if(ps.matches(psC)) {


               boolean adduser = userBdd.update(user,oldUser);
               if (adduser)
                   JOptionPane.showMessageDialog(null, "لقد تم تعديل بيانات المستخدم المستخدم بنجاح");

        }else {
            JOptionPane.showMessageDialog(null,"كلمة المرور غير متطابقتان");
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
