package Controllers;

import BddTools.CategoryProduitBdd;
import BddTools.FornisourBdd;
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

public class CategoryProduitCon implements Initializable {
    public ObservableList<CategoryProduit> data= FXCollections.observableArrayList();
    @FXML
    private TableView<CategoryProduit> Tablecategory;
    @FXML
    private TableColumn<CategoryProduit,Integer> ID;
    @FXML
    private TableColumn<CategoryProduit,String>nom;
    public void AddCategory() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddCategory.fxml"));
        Scene scene=new Scene(root,414,435);
        primaryStage.setTitle("إضافة صنف جديد ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    public void Update() throws IOException {
        CategoryProduit categoryProduit=new CategoryProduit();
         categoryProduit=getSelectdMeeals();
        if(categoryProduit==null)
            JOptionPane.showMessageDialog(null, "يرجى تحديد المورد المراد تعديل بياناته");
        else {
            Stage primaryStage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/UpdateCategoryProduit.fxml"));
            AnchorPane temp = loader.load();
            UpdateCategoryProduit Controller = loader.getController();
            Controller.Init(categoryProduit);
            Scene scene=new Scene(temp,414,435);
            primaryStage.setTitle("تعديل بيانات الصنف ");
            primaryStage.setScene( scene );
            primaryStage.show();
        }
    }
    public void Delete(){
        CategoryProduit categoryProduit = getSelectdMeeals();
        CategoryProduitBdd categoryProduitBdd=new CategoryProduitBdd();
        boolean delete=categoryProduitBdd.delete(categoryProduit);
        if(categoryProduit!=null){
            if(delete)
                JOptionPane.showMessageDialog(null, "لقد تم إزالة  الصنف بنجاح");
        }else
            JOptionPane.showMessageDialog(null, "يرجئ تحديد الصنف المراد إزالته");

    }
    public CategoryProduit getSelectdMeeals(){

        CategoryProduit categoryProduit = Tablecategory.getSelectionModel().getSelectedItem();
        return categoryProduit;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategoryProduitBdd categoryProduitBdd=new CategoryProduitBdd();
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));

        display(categoryProduitBdd.getAll());
    }
    private void display(ArrayList<CategoryProduit>list){
        data.addAll(list);
        Tablecategory.getItems().setAll(data);
    }
}
