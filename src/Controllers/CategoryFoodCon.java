package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.CategoryProduitBdd;
import Moduls.CategoryFood;
import Moduls.CategoryProduit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CategoryFoodCon implements Initializable {
    public ObservableList<CategoryFood> data= FXCollections.observableArrayList();
    @FXML
    private TableView<CategoryFood> Tablecategory;
    @FXML
    private TableColumn<CategoryFood,Integer> ID;
    @FXML
    private TableColumn<CategoryFood,String>nom;
    @FXML
    private TableColumn<CategoryFood,String>type;
    public void AddCategory() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddCategoryFood.fxml"));
        Scene scene=new Scene(root,414,424);
        primaryStage.setTitle("إضافة صنف جديد ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    public void Update() throws IOException {
        CategoryFood categoryFood=new CategoryFood();
        categoryFood=getSelectdMeeals();
        if(categoryFood==null)
            JOptionPane.showMessageDialog(null, "يرجى تحديد المورد المراد تعديل بياناته");
        else {
            Stage primaryStage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/UpdateCategoryProduit.fxml"));
            AnchorPane temp = loader.load();
            UpdateCategoryFood Controller = loader.getController();
            Controller.Init(categoryFood);
            Scene scene=new Scene(temp,414,435);
            primaryStage.setTitle("تعديل بيانات الصنف ");
            primaryStage.setScene( scene );
            primaryStage.show();
        }
    }
    public void Delete(){
        CategoryFood categoryFood = getSelectdMeeals();
        CategoryFoodBdd categoryFoodBdd=new CategoryFoodBdd();
        boolean delete=categoryFoodBdd.delete(categoryFood);
        if(categoryFood!=null){
            if(delete)
                JOptionPane.showMessageDialog(null, "لقد تم إزالة  الصنف بنجاح");
        }else
            JOptionPane.showMessageDialog(null, "يرجئ تحديد الصنف المراد إزالته");

    }
    public CategoryFood getSelectdMeeals(){

        CategoryFood categoryFood = Tablecategory.getSelectionModel().getSelectedItem();
        return categoryFood;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategoryFoodBdd categoryFoodBdd=new CategoryFoodBdd();
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        display(categoryFoodBdd.getAll());
    }
    private void display(ArrayList<CategoryFood>list){
        data.addAll(list);
        Tablecategory.getItems().setAll(data);
    }
}
