package Controllers;

import BddTools.CategoryProduitBdd;
import Moduls.CategoryProduit;
import Moduls.Fornisour;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class UpdateCategoryProduit {
    @FXML
    private TextField nom;
    private CategoryProduit oldFornisour;
    public void Init(CategoryProduit categoryProduit) {
        oldFornisour = categoryProduit;
        Display(oldFornisour);
    }

    private void Display(CategoryProduit oldFornisour) {
        nom.setText(oldFornisour.getName());
    }
    public void Update() {
        CategoryProduit categoryProduit = new CategoryProduit();
        categoryProduit.setName(nom.getText());
        CategoryProduitBdd categoryProduitBdd = new CategoryProduitBdd();
        if (!categoryProduitBdd.isExist(categoryProduit)) {
            boolean addcat = categoryProduitBdd.update(categoryProduit,oldFornisour);
            if (addcat)
                JOptionPane.showMessageDialog(null, "لقد تم تعديل  بيانات الصنف  بنجاح");
            else
                JOptionPane.showMessageDialog(null, "لا يمكن  تعديل  بيانات الصنف  ");


       } else {
            JOptionPane.showMessageDialog(null, "الاسم  هذا موجود مسبقا ");
            nom.setText("");
        }
    }
}
