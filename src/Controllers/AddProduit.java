package Controllers;

import BddTools.CategoryProduitBdd;
import BddTools.FornisourBdd;
import BddTools.ProduitBdd;
import Moduls.CategoryProduit;
import Moduls.Fornisour;
import Moduls.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProduit implements Initializable {
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
    public  void insert(){
        Produit produit=new Produit();
        produit.setName(nom.getText());
        produit.setCategory(category.getSelectionModel().getSelectedItem().toString());
        produit.setPurchaseUnit(PurchaseUnit.getSelectionModel().getSelectedItem().toString());
        produit.setRecipeUnit(RecipeUnit.getSelectionModel().getSelectedItem().toString());
        produit.setCoefficient(Double.parseDouble(Coefficient.getText()));


        ProduitBdd produitBdd=new ProduitBdd();
        boolean addproduit = produitBdd.insert(produit);
        if (addproduit)
            JOptionPane.showMessageDialog(null, "لقد تم إضافة بيانات المنتوج  بنجاح");
        else
            JOptionPane.showMessageDialog(null, "لا يمكن إضافة بيانات المنتوج  ");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<CategoryProduit> list= FXCollections.observableArrayList();
        ObservableList<String> Category= FXCollections.observableArrayList();
        ObservableList<String> purchaseUnit= FXCollections.observableArrayList("QN","KG","G","L","ML","Unit");
        ObservableList<String> recipeUnit= FXCollections.observableArrayList("QN","KG","G","L","ML","Unit");
        CategoryProduitBdd categoryProduitBdd=new CategoryProduitBdd();
        list.addAll(categoryProduitBdd.getAll());


        for(int i=0;i<list.size();i++){
            CategoryProduit categoryProduit=list.get(i);
            Category.add(categoryProduit.getName());
            System.out.println(categoryProduit.getName());
          }
        category.setItems(Category);
        RecipeUnit.setItems(recipeUnit);
        PurchaseUnit.setItems(purchaseUnit);


    }
}
