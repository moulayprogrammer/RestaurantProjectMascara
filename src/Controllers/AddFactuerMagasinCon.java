package Controllers;

import BddTools.FornisourBdd;
import BddTools.ProduitBdd;
import Moduls.CategoryProduit;
import Moduls.FactuerMagasin;
import Moduls.Fornisour;
import Moduls.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFactuerMagasinCon implements Initializable {
    @FXML
    private ComboBox prduit1;
    @FXML
    private ComboBox produit2;
    @FXML
    private ComboBox prduit3;
    @FXML
    private ComboBox prduit4;
    @FXML
    private ComboBox prduit5;
    @FXML
    private ComboBox prduit6;
    @FXML
    private ComboBox prduit7;
    @FXML
    private ComboBox prduit8;
    @FXML
    private ComboBox prduit9;
    @FXML
    private ComboBox prduit10;
    @FXML
    private ComboBox fornisuor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Produit> data= FXCollections.observableArrayList();
        ObservableList<Fornisour> data1= FXCollections.observableArrayList();
        ObservableList<String> produits= FXCollections.observableArrayList();
        ObservableList<String> fornisours= FXCollections.observableArrayList();
        ProduitBdd produitBdd=new ProduitBdd();
        data.addAll(produitBdd.getAll());
        for(int i=0;i<data.size();i++){
            Produit Produit=data.get(i);
            produits.add(Produit.getName());
        }
        FornisourBdd fornisourBdd=new FornisourBdd();
        data1.addAll(fornisourBdd.getAll());
        for(int i=0;i<data1.size();i++){
            Fornisour fornisour=data1.get(i);
            fornisours.add(fornisour.getNom());
        }
        prduit1.setItems(produits);
        produit2.setItems(produits);
        prduit3.setItems(produits);
        prduit4.setItems(produits);
        prduit5.setItems(produits);
        prduit6.setItems(produits);
        prduit7.setItems(produits);
        prduit8.setItems(produits);
        prduit9.setItems(produits);
        prduit10.setItems(produits);
        fornisuor.setItems(fornisours);

    }
}
