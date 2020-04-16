package Controllers;

import BddTools.FornisourBdd;
import BddTools.ProduitBdd;
import Moduls.Fornisour;
import Moduls.Produit;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;

public class UpdateProduitCon {
    @FXML
    private TextField nom;
    @FXML
    private ComboBox category;
    @FXML
    private ComboBox PurchaseUnit;
    @FXML
    private ComboBox RecipeUnit;
    @FXML
    private TextField Coefficient;
    private Produit oldProduite;

    public void Init(Produit produit) {
        oldProduite = produit;
        Display(oldProduite);
    }

    private void Display(Produit oldProduite) {
        nom.setText(oldProduite.getName());
        category.setValue(oldProduite.getCategory());
        PurchaseUnit.setValue(oldProduite.getPurchaseUnit());
        RecipeUnit.setValue(oldProduite.getRecipeUnit());
        Coefficient.setText(String.valueOf(oldProduite.getCoefficient()));
    }
    public void Update(){
        ProduitBdd produitBdd=new ProduitBdd();
        Produit produit=new Produit();
        produit.setName(nom.getText());
        produit.setCategory(category.getSelectionModel().getSelectedItem().toString());
        produit.setPurchaseUnit(PurchaseUnit.getSelectionModel().getSelectedItem().toString());
        produit.setRecipeUnit(RecipeUnit.getSelectionModel().getSelectedItem().toString());
        produit.setCoefficient(Double.parseDouble(Coefficient.getText()));


        boolean produite = produitBdd.update(produit,oldProduite);
        if (produite)
            JOptionPane.showMessageDialog(null, "لقد تم تعديل بيانات المورد بنجاح");
    }
}
