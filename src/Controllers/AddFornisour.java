package Controllers;

import BddTools.FornisourBdd;
import BddTools.UserBdd;
import Moduls.Fornisour;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class AddFornisour {
     @FXML
     private TextField nom;
     @FXML
     private TextField prenom;
     @FXML
     private TextField tel;
    @FXML
    private TextField email;
    public  void insert(){
        Fornisour fornisour=new Fornisour();
        fornisour.setNom(nom.getText());
        fornisour.setPrenom(prenom.getText());
        fornisour.setTel(tel.getText());
        fornisour.setEmail(email.getText());
        FornisourBdd fornisourBdd=new FornisourBdd();
        boolean adduser = fornisourBdd.insert(fornisour);
        if (adduser)
            JOptionPane.showMessageDialog(null, "لقد تم إضافة بيانات المورد  بنجاح");
    else
        JOptionPane.showMessageDialog(null, "لا يمكن  إضافة بيانات المورد  ");


    }
}
