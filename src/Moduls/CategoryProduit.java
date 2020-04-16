package Moduls;

public class CategoryProduit {

    private int id;
    private String name;

    public CategoryProduit() {
    }

    public CategoryProduit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryProduit(String name) {
        this.name = name;
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
}
