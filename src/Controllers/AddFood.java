package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.FoodBdd;
import BddTools.ProduitBdd;
import Moduls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField desc;
    @FXML
    private TextField qte;
    @FXML
    private ChoiceBox category;
    @FXML
    private ListView<String> listViewproduit;
    @FXML
    private TableView<FoodProd> tableviewproduit;
    @FXML
    private TableColumn<FoodProd,Integer> Nameproduit;
    @FXML
    private TableColumn<FoodProd,Integer> unité;
    @FXML
    private TableColumn<FoodProd,Integer> qteproduit;
    ObservableList<Produit> list1= FXCollections.observableArrayList();

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
    public String getSelectdProduit(){

        String produit = listViewproduit.getSelectionModel().getSelectedItem();
        return produit;
    }
    public void addproduit(){
        String unt = null;
        for (int i=0;i<list1.size();i++){
            if(list1.get(i).getName()==getSelectdProduit())
                unt=list1.get(i).getRecipeUnit();
            
        }
         FoodProd foodProd=new FoodProd();
        foodProd.setProduit(getSelectdProduit());
        foodProd.setQte(Integer.parseInt(qte.getText()));
        foodProd.setUnite(unt);
        tableviewproduit.getItems().add(foodProd);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Nameproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        unité.setCellValueFactory(new PropertyValueFactory<>("Unite"));
        qteproduit.setCellValueFactory(new PropertyValueFactory<>("Qte"));
        ObservableList<CategoryFood> list= FXCollections.observableArrayList();
        ObservableList<String> Category= FXCollections.observableArrayList();
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
        listViewproduit.setItems(Produit);


    }
}
