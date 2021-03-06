package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.FoodBdd;
import BddTools.FoodProdBdd;
import BddTools.ProduitBdd;
import Moduls.CategoryFood;
import Moduls.Food;
import Moduls.FoodProd;
import Moduls.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FoodsCon implements Initializable {
    @FXML
    FlowPane flowpane;
    @FXML
    AnchorPane foodpane;
    @FXML
    AnchorPane paneFoods;
    @FXML
    AnchorPane paneAddFood;
    @FXML
    AnchorPane addFood;
    @FXML
    AnchorPane availableFoods;
    @FXML
    AnchorPane paneMakeProduct;
    @FXML
    AnchorPane makeProducts;
    @FXML
    Hyperlink availableFoodsButton;
    @FXML
    private TextField name;
    @FXML
    private Text IDFOOD;
    @FXML
    private TextField prix;
    @FXML
    private TextField desc;
    @FXML
    private TextField qte;
    @FXML
    private ComboBox category;
    @FXML
    private Button btn;
    @FXML
    private ImageView imgfood;
    private BufferedImage image;
    @FXML
    private ListView<String> listViewproduit;
    @FXML
    private TableView<FoodProd> tableviewproduit;
    @FXML
    private TableColumn<FoodProd,String> Nameproduit;
    @FXML
    private TableColumn<FoodProd,String> unité;
    @FXML
    private TableColumn<FoodProd,Integer> qteproduit;
    @FXML
    private TableColumn<FoodProd,Button> culondelete;
    @FXML
    private TableColumn<FoodProd,Button> colonedite;
    @FXML
    private  TableView<Food> tableviewfood;
    @FXML
    private TableColumn<Food,ImageView> Imagefood;
    @FXML
    private TableColumn<Food,String> namefood;
    @FXML
    private TableColumn<Food,String> categoryfood;


    ObservableList<Produit> list1= FXCollections.observableArrayList();
    ObservableList<Food> listfood= FXCollections.observableArrayList();
    public void OpenAddFood(){
        addFood.setVisible(true);
        foodpane.setVisible(false);
        makeProducts.setVisible(false);
        availableFoods.setVisible(false);
    }

    @FXML
    public void OpenFoodPage() {
        foodpane.setVisible(true);
        addFood.setVisible(false);
        availableFoods.setVisible(false);
        makeProducts.setVisible(false);
    }

    @FXML
    public void openMakeProduct() {
        makeProducts.setVisible(true);
        foodpane.setVisible(false);
        addFood.setVisible(false);
        availableFoods.setVisible(false);

    }
    @FXML
    public void openAvailableFoods(){
        makeProducts.setVisible(false);
        foodpane.setVisible(false);
        availableFoods.setVisible(true);
        addFood.setVisible(false);
        availableFoodsButton.getStyleClass().add("active");

    }

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
        int Id=0,i=0;
        i=list.size()-1;
        Food food=list.get(i);
        Id=food.getId();

        Id++;
        return Id;
    }


    public void insertFood(){
        CategoryFoodBdd categoryFoodBdd=new CategoryFoodBdd();
        int IDcategory=idcategory(categoryFoodBdd.getAll());
        FoodBdd foodBdd=new FoodBdd();
        int ID=idfood(foodBdd.getAll());
        Food food=new Food();
        food.setId(ID);
        food.setName(name.getText());
        food.setIdCategory(IDcategory);
        food.setPrice(Float.parseFloat(prix.getText()));
        food.setDescription(desc.getText());
      //  food.setImage(name.getText()+".jpg");

        for(int i=0;i<tableviewproduit.getItems().size();i++){
            FoodProd foodProd1=new FoodProd();
            FoodProdBdd foodProdBdd=new FoodProdBdd();
            FoodProd foodProd= tableviewproduit.getItems().get(i);
            foodProd1.setProduit(foodProd.getProduit());
            foodProd1.setQte(foodProd.getQte());
            foodProd1.setIdfood(ID);
            foodProdBdd.insert(foodProd1);

        }
        try {
            ImageIO.write(image, "jpg", new File("C:\\Users\\kader\\IdeaProjects\\RestaurantProjectMascara\\src\\img/"+name.getText()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public int getslectetable(){
        int Id=tableviewproduit.getSelectionModel().getSelectedIndex();
        System.out.println(Id);
        return Id;
    }
    public void addproduit(){
        String unt = null;
        for (int i=0;i<list1.size();i++){
            if(list1.get(i).getName()==getSelectdProduit())
                unt=list1.get(i).getRecipeUnit();

        }
        FoodProd foodProd=new FoodProd();
        ImageView imageView=new ImageView("/img/edit.png");
        ImageView imageView2=new ImageView("/img/delete.png");
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        imageView2.setFitWidth(16);
        imageView2.setFitHeight(16);
        Button button1=new Button("",imageView2);

        Button button2=new Button("",imageView);
        foodProd.setProduit(getSelectdProduit());
        foodProd.setQte(Integer.parseInt(qte.getText()));
        button1.setStyle("-fx-background-color: #ee3d48; -fx-border-radius: 40;");
        button2.setStyle("-fx-background-color: #42b3c5; -fx-border-radius: 40;");
        button1.setMnemonicParsing(false);



        foodProd.setDelete(button1);
        foodProd.setEdit(button2);
        foodProd.setUnite(unt);

        tableviewproduit.getItems().add(foodProd);
    }


    public void ChooseFille(){
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All","*.png","*.jpg"));
        File file=fileChooser.showOpenDialog(btn.getScene().getWindow());
        if (file !=  null) {
            try {
                image = ImageIO.read(file);
                imgfood.setImage(SwingFXUtils.toFXImage(image, null));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FoodBdd foodBdd=new FoodBdd();
        int k=idfood(foodBdd.getAll());
        IDFOOD.setText(String.valueOf(k));
        Nameproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        unité.setCellValueFactory(new PropertyValueFactory<>("Unite"));
        qteproduit.setCellValueFactory(new PropertyValueFactory<>("Qte"));
        culondelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        colonedite.setCellValueFactory(new PropertyValueFactory<>("edit"));
        ObservableList<CategoryFood> list= FXCollections.observableArrayList();
        ObservableList<String> Category= FXCollections.observableArrayList();
        ObservableList<String> Produit= FXCollections.observableArrayList();
        CategoryFoodBdd categoryFoodBdd=new CategoryFoodBdd();
        list.addAll(categoryFoodBdd.getAll());
        ProduitBdd produitBdd=new ProduitBdd();
        list1.addAll(produitBdd.getAll());

        for(int i=0;i<list.size();i++){
            CategoryFood categoryFood=list.get(i);
            if(categoryFood.getType().matches("Food"))
                Category.add(categoryFood.getName());
        }
        for(int i=0;i<list1.size();i++){
            Produit produit=list1.get(i);
            Produit.add(produit.getName());
        }
        category.setItems(Category);
        listViewproduit.setItems(Produit);

        Imagefood.setCellValueFactory(new PropertyValueFactory<>("image"));
        namefood.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryfood.setCellValueFactory(new PropertyValueFactory<>("description"));
        Food food=new Food();
        food.setName("pizza");
        food.setDescription("pizzas");
        ImageView imageView1=new ImageView("img/pizza .jpg");
        imageView1.setFitHeight(80);
        imageView1.setFitWidth(100);
        food.setImage(imageView1);
        Food food2=new Food();
        food2.setName("soup");
        food2.setDescription("soups");
        ImageView imageView2=new ImageView("img/salade.jpg");
        imageView2.setFitHeight(80);
        imageView2.setFitWidth(100);
        food2.setImage(imageView2);
        listfood.add(food2);
        listfood.add(food);
        tableviewfood.setItems(listfood);


        for(int i=0;i<10;i++){
        Pane pane1=new Pane();
        AnchorPane anchorPane=new AnchorPane();
            anchorPane.setPrefWidth(278);
            anchorPane.setPrefHeight(177);
        pane1.getChildren().addAll(anchorPane);
        AnchorPane anchorPane1=new AnchorPane();
        anchorPane1.setPrefWidth(148);
        anchorPane1.setPrefHeight(238);
        anchorPane1.setStyle("-fx-border-style:solid;-fx-border-radius:40;-fx-border-width:20;-fx-border-color:white;");
        AnchorPane anchorPane2=new AnchorPane();
        anchorPane2.setPrefHeight(203);
        anchorPane2.setPrefWidth(131);
        anchorPane2.setStyle("-fx-background-color:white;");
        AnchorPane anchorPane3=new AnchorPane();
            anchorPane3.setPrefHeight(278);
            anchorPane3.setPrefWidth(169);
        anchorPane3.setStyle("-fx-border-style:solid solid hidden solid;-fx-border-radius:40;-fx-border-width:20;-fx-border-color:#f8f8f8;");
        ImageView imageView=new ImageView("img/food.jpg");
            imageView.setFitHeight(105);
            imageView.setFitWidth(138);
            imageView.setPickOnBounds(true);
        anchorPane.getChildren().addAll(anchorPane1,anchorPane2,imageView,anchorPane3);
        Separator separator=new Separator();
            separator.setPrefHeight(4);
            separator.setPrefHeight(138);

        Text text=new Text("tomat");
        Text text2=new Text("150da");
      //  ImageView imageView1=new ImageView("img/close-480.png");
        Button button=new Button("حذف");
            button.setStyle("-fx-background-color:white;");
       // ImageView imageView2=new ImageView("img/edit-balck.png");
        Button button1=new Button("تعديل");
            button1.setStyle("-fx-background-color:white;");
        anchorPane2.getChildren().addAll(separator,text,text2,button,button1);

        flowpane.getChildren().addAll(pane1);
        }
    }
}

