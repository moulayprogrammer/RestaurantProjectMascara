package Controllers;

import BddTools.UserBdd;
import Moduls.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserCon implements Initializable {
    @FXML
    private TableView<User>TableUser;
    @FXML
    private TableColumn<User,Integer>ID;
    @FXML
    private TableColumn<User,String>Username;
    @FXML
    private TableColumn<User,String>Prenom;
    @FXML
    private TableColumn<User,String>Nom;
    @FXML
    private TableColumn<User,String>Tel;
    @FXML
    private TableColumn<User,String>Type;
    public void IsertUser(Event e) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/AddUser.fxml"));
        Scene scene=new Scene(root,534,616);
        primaryStage.setTitle("إضافة مستخدم جديد ");
        primaryStage.setScene( scene );
        primaryStage.show();



}
    public ObservableList<User>data=FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserBdd users =new UserBdd();
        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Username.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        Tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        Type.setCellValueFactory(new PropertyValueFactory<>("Type"));

        display(users.getAll());
    }

    private void display(ArrayList<User> list){
        data.addAll(list);
        TableUser.getItems().setAll(data);
    }
}
