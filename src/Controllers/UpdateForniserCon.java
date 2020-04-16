package Controllers;

import BddTools.FornisourBdd;
import BddTools.UserBdd;
import Moduls.Fornisour;
import Moduls.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class UpdateForniserCon {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private TextField email;
    private Fornisour oldFornisour;
    public void Init(Fornisour fornisour) {
        oldFornisour = fornisour;
        Display(oldFornisour);
    }

    private void Display(Fornisour oldFornisour) {
        nom.setText(oldFornisour.getNom());
        prenom.setText(oldFornisour.getPrenom());
        tel.setText(oldFornisour.getTel());
        email.setText(oldFornisour.getEmail());
    }
    public void Update(){
        FornisourBdd fornisourBdd=new FornisourBdd();
        Fornisour fornisour=new Fornisour();
        fornisour.setNom(nom.getText());
        fornisour.setPrenom(prenom.getText());
        fornisour.setTel(tel.getText());
        fornisour.setEmail(email.getText());

            boolean fouenisour = fornisourBdd.update(fornisour,oldFornisour);
            if (fouenisour)
                JOptionPane.showMessageDialog(null, "لقد تم تعديل بيانات المورد بنجاح");
    }
}
