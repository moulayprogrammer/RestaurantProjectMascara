package Moduls;
import java.util.Date;

public class FactuerMagasin {
    private int Id;
    private int Number;
    private Date Date;
    private Fornisour Fornisour;
    private User Magasine;
    private Produit Produit;
    private double PrixProduit;
    private double PrixTotal;

    public FactuerMagasin() { }

    public FactuerMagasin(int id,int number, java.util.Date date, Fornisour fornisour, User magasine, Produit produit, double prixProduit, double prixTotal) {
        Id = id;
        Number=number;
        Date = date;
        Fornisour = fornisour;
        Magasine = magasine;
        Produit = produit;
        PrixProduit = prixProduit;
        PrixTotal = prixTotal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public Fornisour getFornisour() {
        return Fornisour;
    }

    public void setFornisour(Fornisour fornisour) {
        Fornisour = fornisour;
    }

    public User getMagasine() {
        return Magasine;
    }

    public void setMagasine(User magasine) {
        Magasine = magasine;
    }

    public Produit getProduit() {
        return Produit;
    }

    public void setProduit(Produit produit) {
        Produit = produit;
    }

    public double getPrixProduit() {
        return PrixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        PrixProduit = prixProduit;
    }

    public double getPrixTotal() {
        return PrixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        PrixTotal = prixTotal;
    }
}
