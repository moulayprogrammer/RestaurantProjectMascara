package Moduls;

public class Order {

    private int id;
    private int idDate;
    private String hour;
    private int idTable;
    private float payer;

    public Order() {
    }

    public Order(int id, int idDate, String hour, int idTable, float payer) {
        this.id = id;
        this.idDate = idDate;
        this.hour = hour;
        this.idTable = idTable;
        this.payer = payer;
    }

    public Order(int idDate, String hour, int idTable, float payer) {
        this.idDate = idDate;
        this.hour = hour;
        this.idTable = idTable;
        this.payer = payer;
    }

    public Order(int idDate, String hour, int idTable) {
        this.idDate = idDate;
        this.hour = hour;
        this.idTable = idTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDate() {
        return idDate;
    }

    public void setIdDate(int idDate) {
        this.idDate = idDate;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public float getPayer() {
        return payer;
    }

    public void setPayer(float payer) {
        this.payer = payer;
    }
}
