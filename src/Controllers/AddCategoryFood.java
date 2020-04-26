package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.CategoryProduitBdd;
import Moduls.CategoryFood;
import Moduls.CategoryProduit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCategoryFood implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private ComboBox type;

    public void insert() {
        CategoryFood categoryFood = new CategoryFood();
        categoryFood.setName(nom.getText());
        categoryFood.setType(type.getSelectionModel().getSelectedItem().toString());
        CategoryFoodBdd categoryFoodBdd = new CategoryFoodBdd();
        if (!categoryFoodBdd.isExist(categoryFood)){
            boolean addcat = categoryFoodBdd.insert(categoryFood);
            if (addcat)
                JOptionPane.showMessageDialog(null, "لقد تم إضافة بيانات الصنف  بنجاح");
            else
                JOptionPane.showMessageDialog(null, "لا يمكن  إضافة بيانات الصنف  ");
       } else {
            JOptionPane.showMessageDialog(null, "الاسم  هذا موجود مسبقا ");
            nom.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> food= FXCollections.observableArrayList("Food","boisson");
        type.setItems(food);
    }
}
