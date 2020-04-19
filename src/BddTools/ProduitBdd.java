package BddTools;

import Moduls.Produit;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProduitBdd extends BDD<Produit> {

    @Override
    public boolean insert(Produit produit) {
        String sql="insert into Produit (Name, Category, PurchaseUnit, RecipeUnit, Coefficient) values ('"+produit.getName()+"','"+produit.getCategory()+"','"+produit.getPurchaseUnit()+"','"+produit.getRecipeUnit()+"','"+produit.getCoefficient()+"')";
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
    public boolean update(Produit produit, Produit produit1) {
        String sql= "UPDATE Produit SET Name='"+produit.getName()+"',Category='"+produit.getCategory()+"',PurchaseUnit='"+produit.getPurchaseUnit()+"',RecipeUnit='"+produit.getRecipeUnit()+"',Coefficient='"+produit.getCoefficient()+"' where Id='"+produit1.getId()+"'";


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
    public boolean delete(Produit produit) {
        String sql= " DELETE from Produit where Id='"+produit.getId()+"'";


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
    public boolean isExist(Produit produit) {
        String sql= " select * from Produit where Name = '"+produit.getName()+"';";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Produit> getAll() {
        ArrayList<Produit> list=new ArrayList<Produit>();
        String sql="select * from Produit";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                Produit produit=new Produit();
                produit.setId(rs.getInt(1));
                produit.setName(rs.getString(2));
                produit.setCategory(rs.getString(3));
                produit.setPurchaseUnit(rs.getString(4));
                produit.setRecipeUnit(rs.getString(5));
                produit.setCoefficient(rs.getDouble(6));
                list.add(produit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
