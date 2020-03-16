package Moduls;

public class Food {

    private int id;
    private String name;
    private String description;
    private float price;
    private int idCategory;

    public Food() {
    }

    public Food(int id, String name, String description, float price, int idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Food(String name, String description, float price, int idCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Food(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
