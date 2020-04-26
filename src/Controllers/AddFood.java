package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.FoodBdd;
import BddTools.ProduitBdd;
import Moduls.CategoryFood;
import Moduls.CategoryProduit;
import Moduls.Food;
import Moduls.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddFood implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField prix;
    @FXML
    private TextArea desc;
    @FXML
    private ComboBox category;
    @FXML
    private TextField qte1;
    @FXML
    private TextField qte2;
    @FXML
    private TextField qte3;
    @FXML
    private TextField qte4;
    @FXML
    private ComboBox produit1;
    @FXML
    private ComboBox produit2;
    @FXML
    private ComboBox produit3;
    @FXML
    private ComboBox produit4;

    public int idcategory(ArrayList<CategoryFood> list){
        int Id=-1;
        String cat=category.getSelectionModel().getSelectedItem().toString();
        for(int i=0;i<list.size();i++){
            CategoryFood categoryFood=list.get(i);
            if(categoryFood.getName().matches(cat))
                Id=categoryFood.getId();
        }
        return Id;
    }
    public int idfood(ArrayList<Food> list){
        int i=list.size();
       Food food=list.get(11);
        int Id=food.getId();
        return Id;
    }


    public void insert(){
        CategoryFoodBdd categoryFoodBdd=new CategoryFoodBdd();
        int IDcategory=idcategory(categoryFoodBdd.getAll());
        Food food=new Food();
        food.setName(name.getText());
        food.setIdCategory(IDcategory);
        food.setPrice(Float.parseFloat(prix.getText()));
        food.setDescription(desc.getText());
        FoodBdd foodBdd=new FoodBdd();
        int k=idfood(foodBdd.getAll());
        k++;
        System.out.println(k);
        boolean addfood = foodBdd.insert(food);
        if (addfood)
            JOptionPane.showMessageDialog(null, "لقد تم إضافة بيانات الوصفة  بنجاح");
        else
            JOptionPane.showMessageDialog(null, "لا يمكن إضافة بيانات المنتوج  ");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<CategoryFood> list= FXCollections.observableArrayList();
        ObservableList<String> Category= FXCollections.observableArrayList();
        ObservableList<Produit> list1= FXCollections.observableArrayList();
        ObservableList<String> Produit= FXCollections.observableArrayList();
        CategoryFoodBdd categoryFoodBdd=new CategoryFoodBdd();
        list.addAll(categoryFoodBdd.getAll());
        ProduitBdd produitBdd=new ProduitBdd();
        list1.addAll(produitBdd.getAll());

        for(int i=0;i<list.size();i++){
            CategoryFood categoryFood=list.get(i);
            Category.add(categoryFood.getName());
        }
        for(int i=0;i<list1.size();i++){
            Produit produit=list1.get(i);
            Produit.add(produit.getName());
        }
        category.setItems(Category);
        produit1.setItems(Produit);
        produit2.setItems(Produit);
        produit3.setItems(Produit);
        produit4.setItems(Produit);

    }
}
