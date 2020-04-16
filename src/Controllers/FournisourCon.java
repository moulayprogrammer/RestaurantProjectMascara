package Controllers;

import BddTools.FornisourBdd;
import Moduls.Fornisour;
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

public class FournisourCon implements Initializable {
    public ObservableList<Fornisour> data= FXCollections.observableArrayList();
    @FXML
    private TableView<Fornisour> TableFornisour;
    @FXML
    private TableColumn<Fornisour,Integer> ID;
    @FXML
    private TableColumn<Fornisour,String>nom;
    @FXML
    private TableColumn<Fornisour,String>prenom;
    @FXML
    private TableColumn<Fornisour,String>tel;
    @FXML
    private TableColumn<Fornisour,String>email;
    public void IsertFornisour() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/AddFornisour.fxml"));
        Scene scene=new Scene(root,463,623);
        primaryStage.setTitle("اضافة مورد جديد ");
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    public void Update() throws IOException {
        Fornisour fornisour = getSelectdMeeals();
        if(fornisour==null)
            JOptionPane.showMessageDialog(null, "يرجى تحديد المورد المراد تعديل بياناته");
        else {
            Stage primaryStage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/UpdateFornisour.fxml"));
            AnchorPane temp = loader.load();
            UpdateForniserCon Controller = loader.getController();
            Controller.Init(fornisour);
            Scene scene=new Scene(temp,534,616);
            primaryStage.setTitle("تعديل بيانات المورد ");
            primaryStage.setScene( scene );
            primaryStage.show();
        }
    }
    public void Delete(){
        Fornisour fornisour = getSelectdMeeals();
        FornisourBdd fornisourBdd=new FornisourBdd();
        boolean delete=fornisourBdd.delete(fornisour);
        if(delete)
            JOptionPane.showMessageDialog(null, "لقد تم إزالة  المورد بنجاح");
    }
    public Fornisour getSelectdMeeals(){

        Fornisour fornisour = TableFornisour.getSelectionModel().getSelectedItem();
        return fornisour;
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FornisourBdd fornisourBdd=new FornisourBdd();
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        display(fornisourBdd.getAll());
    }
    private void display(ArrayList<Fornisour> list){
        data.addAll(list);
        TableFornisour.getItems().setAll(data);
    }
}
