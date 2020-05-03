package Controllers;

import BddTools.CategoryFoodBdd;
import BddTools.FoodBdd;
import BddTools.FoodProdBdd;
import BddTools.ProduitBdd;
import Moduls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddFood implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private Text IDFOOD;
    @FXML
    private TextField prix;
    @FXML
    private TextArea desc;
    @FXML
    private TextField qte;
    @FXML
    private ChoiceBox category;
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

    ObservableList<Produit> list1= FXCollections.observableArrayList();

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
        food.setImage(name.getText()+".jpg");

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
    public void addproduit(){
        String unt = null;
        for (int i=0;i<list1.size();i++){
            if(list1.get(i).getName()==getSelectdProduit())
                unt=list1.get(i).getRecipeUnit();

        }
         FoodProd foodProd=new FoodProd();
        foodProd.setProduit(getSelectdProduit());
        foodProd.setQte(Integer.parseInt(qte.getText()));
        foodProd.setUnite(unt);
        tableviewproduit.getItems().add(foodProd);
    }
    public BufferedImage ChooseFille(){

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
            return image;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FoodBdd foodBdd=new FoodBdd();
        int k=idfood(foodBdd.getAll());
        IDFOOD.setText(String.valueOf(k));
        Nameproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        unité.setCellValueFactory(new PropertyValueFactory<>("Unite"));
        qteproduit.setCellValueFactory(new PropertyValueFactory<>("Qte"));
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


    }
}
