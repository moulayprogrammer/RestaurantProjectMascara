package BddTools;

import Moduls.User;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

abstract class BDD<T> {

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

    abstract public boolean insert(T o);

    abstract public boolean update(T o1,T o2);

    abstract public boolean delete(T o);

    abstract public boolean isExist(T o);

    abstract public ArrayList<T> getAll();
}
