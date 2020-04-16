package Controllers;

import BddTools.FornisourBdd;
import BddTools.ProduitBdd;
import Moduls.Fornisour;
import Moduls.Produit;
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

public class ProduitCon implements Initializable {
    public ObservableList<Produit> data= FXCollections.observableArrayList();
    @FXML
    private TableView<Produit> TableProduit;
    @FXML
    private TableColumn<Produit,Integer> ID;
    @FXML
    private TableColumn<Produit,String>nom;
    @FXML
    private TableColumn<Produit,String>category;
    public void AddProduit() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddProduit.fxml"));
        Scene scene=new Scene(root,463,638);
        primaryStage.setTitle("قائمة المنتوجات ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    public void Update() throws IOException {
        Produit produit = getSelectdMeeals();
        if(produit==null)
            JOptionPane.showMessageDialog(null, "يرجى تحديد المورد المراد تعديل بياناته");
        else {
            Stage primaryStage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/UpdateProduit.fxml"));
            AnchorPane temp = loader.load();
            UpdateProduitCon Controller = loader.getController();
            Controller.Init(produit);
            Scene scene=new Scene(temp,534,616);
            primaryStage.setTitle("تعديل بيانات المورد ");
            primaryStage.setScene( scene );
            primaryStage.show();
        }
    }
    public void Delete(){
        Produit produit = getSelectdMeeals();
        ProduitBdd produitBdd=new ProduitBdd();
        boolean delete=produitBdd.delete(produit);
        if(delete)
            JOptionPane.showMessageDialog(null, "لقد تم إزالة  المنتوج  بنجاح");
    }
    public Produit getSelectdMeeals(){

        Produit produit = TableProduit.getSelectionModel().getSelectedItem();
        return produit;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProduitBdd produitBdd=new ProduitBdd();
        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Name"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        display(produitBdd.getAll());


    }
    private void display(ArrayList<Produit> list){
        data.addAll(list);
        TableProduit.getItems().setAll(data);
    }
}
