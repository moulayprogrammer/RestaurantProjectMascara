package Controllers;

import BddTools.TableBdd;
import Moduls.Table;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

import static javafx.scene.control.ContentDisplay.CENTER;
import static javafx.scene.paint.Color.WHITE;

public class CaissierCon {
    @FXML
    private FlowPane flowpane;
    public void AddTable(){
        TableBdd tableBdd=new TableBdd();
        ArrayList list=tableBdd.getAll();
        int count=list.size();
        count++;
        Table table=new Table();
        table.setNumber(count);
        tableBdd.insert(table);
        String tab =Integer.toString(count);
        ImageView imageView=new ImageView("img/tab.png");
        imageView.setFitWidth(95);
        imageView.setFitHeight(50);


        Button button=new Button(tab,imageView);
        button.setPrefWidth(100);
        button.setPrefHeight(80);
        button.setContentDisplay(CENTER);
        button.setTextFill(WHITE);
        flowpane.setHgap(10);
        flowpane.setVgap(10);
        flowpane.getChildren().add(button);

    }
}
