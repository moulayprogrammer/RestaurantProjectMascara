package BddTools;

import Moduls.CategoryProduit;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryProduitBdd extends BDD<CategoryProduit>{

    @Override
    public boolean insert(CategoryProduit o) {
        String sql="insert into CategoryProduit (Nom) values ('"+o.getName()+"')";
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
    public boolean update(CategoryProduit o1, CategoryProduit o2) {

        String sql= "UPDATE CategoryProduit SET Nom='"+o1.getName()+"' where Id='"+o2.getId()+"'";


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
    public boolean delete(CategoryProduit o) {

        String sql= "DELETE from CategoryProduit where Id='"+o.getId()+"'";


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
    public boolean isExist(CategoryProduit o) {

        String sql= " Select * from CategoryProduit where Nom= '"+o.getName()+"';";
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
    public ArrayList<CategoryProduit> getAll(){
        ArrayList<CategoryProduit> list=new ArrayList<CategoryProduit>();
        String sql="select * from CategoryProduit;";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                CategoryProduit category=new CategoryProduit();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));

                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }
}
