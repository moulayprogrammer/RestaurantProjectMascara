package Moduls;

public class FoodMenu {

    private int id;
    private int idFood;
    private int idMenu;

    public FoodMenu(int id, int idFood, int idMenu) {
        this.id = id;
        this.idFood = idFood;
        this.idMenu = idMenu;
    }

    public FoodMenu(int idFood, int idMenu) {
        this.idFood = idFood;
        this.idMenu = idMenu;
    }

    public FoodMenu() {
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

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }
}
