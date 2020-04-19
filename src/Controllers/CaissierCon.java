package Controllers;

import BddTools.TableBdd;
import Moduls.Table;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.ContentDisplay.CENTER;
import static javafx.scene.paint.Color.WHITE;

public class CaissierCon implements Initializable {
    @FXML
    private FlowPane flowpane;
    public void AddTable(){
        TableBdd tableBdd=new TableBdd();
        ArrayList list=tableBdd.getAll();
        int count=list.size();
        count++;
        Table table=new Table();
        table.setNumber(count);
        table.setActive(0);
        tableBdd.insert(table);
        String tab =Integer.toString(count);
        ImageView imageView=new ImageView("img/Table0.png");
        imageView.setFitWidth(95);
        imageView.setFitHeight(50);


        Button button=new Button(tab,imageView);
        button.setPrefWidth(100);
        button.setPrefHeight(80);
        button.setContentDisplay(CENTER);
        button.setTextFill(WHITE);
        button.setId(tab);
        flowpane.setHgap(10);
        flowpane.setVgap(10);
        flowpane.getChildren().add(button);

    }
    public void Delete(){
        ArrayList list=new ArrayList();
        TableBdd tableBdd=new TableBdd();
        Table table=new Table();
        list=tableBdd.getAll();
        int count=list.size();
        table.setNumber(count);
        tableBdd.delete(table);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableBdd tableBdd=new TableBdd();
        ArrayList<Table> list=tableBdd.getAll();
        int count=list.size();
        for(int i=0;i<count;i++){
            Table table=new Table();
            table=list.get(i);
            int j=i+1;
            String tab =Integer.toString(j);
            String active;
            if(table.getActive()==0){
                active="img/Table0.png";
            }else{
                active="img/Table1.png";
            }
            ImageView imageView=new ImageView(active);
            imageView.setFitWidth(95);
            imageView.setFitHeight(50);
            Button button=new Button(tab,imageView);
            button.setPrefWidth(100);
            button.setPrefHeight(80);
            button.setContentDisplay(CENTER);
            button.setTextFill(WHITE);
            button.setId(String.valueOf(j));
            flowpane.setHgap(10);
            flowpane.setVgap(10);
            flowpane.getChildren().add(button);
        }
    }
}
