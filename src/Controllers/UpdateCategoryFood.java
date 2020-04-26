package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.CategoryProduitBdd;
import Moduls.CategoryFood;
import Moduls.CategoryProduit;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class UpdateCategoryFood {
    @FXML
    private TextField nom;
    private CategoryFood oldFornisour;
    public void Init(CategoryFood categoryFood) {
        oldFornisour = categoryFood;
        Display(oldFornisour);
    }

    private void Display(CategoryFood oldFornisour) {
        nom.setText(oldFornisour.getName());
    }
    public void Update() {
        CategoryFood categoryFood = new CategoryFood();
        categoryFood.setName(nom.getText());
        CategoryFoodBdd categoryProduitBdd = new CategoryFoodBdd();
        if (!categoryProduitBdd.isExist(categoryFood)) {
            boolean addcat = categoryProduitBdd.update(categoryFood,oldFornisour);
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
