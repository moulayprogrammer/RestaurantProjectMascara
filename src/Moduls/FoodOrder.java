package Moduls;

public class FoodOrder {

    private int id;
    private int idFood;
    private int idOrder;
    private int qte;

    public FoodOrder(int id, int idFood, int idOrder, int qte) {
        this.id = id;
        this.idFood = idFood;
        this.idOrder = idOrder;
        this.qte = qte;
    }

    public FoodOrder(int idFood, int idOrder, int qte) {
        this.idFood = idFood;
        this.idOrder = idOrder;
        this.qte = qte;
    }

    public FoodOrder(int qte) {
        this.qte = qte;
    }

    public FoodOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
