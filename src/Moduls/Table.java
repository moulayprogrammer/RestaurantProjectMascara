package Moduls;

public class Table {

    private int id;
    private int number;
    private int Active;

    public Table() {
    }

    public Table(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public Table(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }
}
