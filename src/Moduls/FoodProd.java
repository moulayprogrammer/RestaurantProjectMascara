package Moduls;

public class FoodProd {
    private int Qte;
    private int Idfood;
    private String produit;
    private String Unite;

    public FoodProd() {
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = qte;
    }

    public int getIdfood() {
        return Idfood;
    }

    public void setIdfood(int idfood) {
        Idfood = idfood;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getUnite() {
        return Unite;
    }

    public void setUnite(String unite) {
        Unite = unite;
    }
}
