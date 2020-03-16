package BddTools;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

abstract class BDD {

    Connection conn;

    BDD() {
        connect();
    }

    private void connect(){
        // db parameters
        String url = "jdbc:sqlite:/home/moulay/IdeaProjects/BD/testRes.db";

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

    abstract public boolean isExist(Object o);

    abstract public ArrayList<Object> getAll();


    void insert(String nom, String prenom) {

    }

    public void selectAll(){
        String sql = "SELECT * FROM Category";

        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("nom et prenom") + "\t" +
                        rs.getString("spec"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
