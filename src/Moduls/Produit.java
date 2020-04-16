package Moduls;

import javafx.scene.control.ComboBox;

public class Produit {
    private int Id;
    private String Name;
    private String category;
    private String PurchaseUnit;
    private String RecipeUnit;
    private double Coefficient;

    public Produit(int id, String name, String category, String purchaseUnit, String recipeUnit, double coefficient) {
        Id = id;
        Name = name;
        this.category = category;
        PurchaseUnit = purchaseUnit;
        RecipeUnit = recipeUnit;
        Coefficient = coefficient;
    }

    public Produit() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPurchaseUnit() {
        return PurchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        PurchaseUnit = purchaseUnit;
    }

    public String getRecipeUnit() {
        return RecipeUnit;
    }

    public void setRecipeUnit(String recipeUnit) {
        RecipeUnit = recipeUnit;
    }

    public double getCoefficient() {
        return Coefficient;
    }

    public void setCoefficient(double coefficient) {
        Coefficient = coefficient;
    }
}
