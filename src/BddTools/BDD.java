package BddTools;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract class BDD {

    Connection conn;

    BDD() {
        connect();
    }

    public Connection connect(){
        // db parameters
        String url = "jdbc:sqlite:testRes.db";

        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connection");
            alert.setContentText("Connection is field !!");
            alert.show();
        }
        return conn;
    }

    void close(){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract public boolean insert(Object o);

    abstract public boolean update(Object o1,Object o2);

    abstract public boolean delete(Object o);

    abstract public  boolean isExist(Object o);

    abstract public<T> ArrayList<T> getAll();

     void insert(String nom, String prenom) {

    }


}
