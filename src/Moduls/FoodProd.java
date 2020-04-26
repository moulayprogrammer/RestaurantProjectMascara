package Moduls;

public class FoodProd {
    private int Qte;
    private int Idfood;
    private int Idprod;

    public FoodProd() {
    }

    public FoodProd(int qte, int idfood, int idprod) {
        Qte = qte;
        Idfood = idfood;
        Idprod = idprod;
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

    public int getIdprod() {
        return Idprod;
    }

    public void setIdprod(int idprod) {
        Idprod = idprod;
    }
}
