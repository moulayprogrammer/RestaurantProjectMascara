package BddTools;

import Moduls.Fornisour;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornisourBdd extends BDD<Fornisour> {

    @Override
    public boolean insert(Fornisour fornisour) {
        String sql="insert into Fornisour(nome, prenom, \"n-tel\",Email) VALUES ('"+fornisour.getNom()+"','"+fornisour.getPrenom()+"','"+fornisour.getTel()+"','"+fornisour.getEmail()+"');";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Fornisour fornisour, Fornisour fornisour1) {
        String sql= "UPDATE Fornisour set Nome='"+fornisour.getNom()+"',Prenom='"+fornisour.getPrenom()+"',\"N-tel\"='"+fornisour.getTel()+"',Email='"+fornisour.getEmail()+"' where Id='"+fornisour1.getID()+"'";


        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Fornisour fornisour) {
        String sql= " DELETE from fornisour where Id='"+fornisour.getID()+"';";


        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isExist(Fornisour fornisour) {
        return false;
    }

    @Override
    public ArrayList<Fornisour> getAll(){
        ArrayList<Fornisour> list1=new ArrayList<Fornisour>();
        String sql="select * from fornisour";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                Fornisour fornisour=new Fornisour();
                fornisour.setID(rs.getInt(1));
                fornisour.setNom(rs.getString(2));
                fornisour.setPrenom(rs.getString(3));
                fornisour.setTel(rs.getString(4));
                fornisour.setEmail(rs.getString(5));

                list1.add(fornisour);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list1;
    }
    
}
