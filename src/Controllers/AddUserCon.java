package Controllers;

import Moduls.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserCon implements Initializable {
    @FXML
    private ComboBox combobox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         ObservableList<String> list= FXCollections.observableArrayList("امين مخزن","نادل","طباخ");
        combobox.setItems(list);

    }
}
