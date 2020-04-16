package Controllers;

import BddTools.CategoryProduitBdd;
import BddTools.FornisourBdd;
import Moduls.CategoryProduit;
import Moduls.Fornisour;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class AddCategoryProduit {
    @FXML
    private TextField nom;

    public void insert() {
        CategoryProduit categoryProduit = new CategoryProduit();
        categoryProduit.setName(nom.getText());
        CategoryProduitBdd categoryProduitBdd = new CategoryProduitBdd();
        if (!categoryProduitBdd.isExist(categoryProduit)) {
            boolean addcat = categoryProduitBdd.insert(categoryProduit);
            if (addcat)
                JOptionPane.showMessageDialog(null, "لقد تم إضافة بيانات الصنف  بنجاح");
            else
                JOptionPane.showMessageDialog(null, "لا يمكن  إضافة بيانات الصنف  ");


       } else {
            JOptionPane.showMessageDialog(null, "الاسم  هذا موجود مسبقا ");
            nom.setText("");
        }
    }
}
