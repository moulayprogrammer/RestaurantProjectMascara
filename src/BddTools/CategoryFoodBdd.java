package BddTools;

import Moduls.CategoryFood;
import Moduls.CategoryProduit;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryFoodBdd extends BDD<CategoryFood> {
    @Override
    public boolean insert(CategoryFood categoryFood) {
        String sql="insert into CategoryFood (name, type) VALUES ('"+categoryFood.getName()+"','"+categoryFood.getType()+"')";
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
    public boolean update(CategoryFood categoryFood, CategoryFood categoryFood2) {
        return false;
    }

    @Override
    public boolean delete(CategoryFood categoryFood) {
        String sql= "DELETE from CategoryFood where id='"+categoryFood.getId()+"'";


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
    public boolean isExist(CategoryFood categoryFood) {
        String sql= "Select * from CategoryFood where name= '"+categoryFood.getName()+"';";
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
    }}

    @Override
    public  ArrayList<CategoryFood> getAll() {
        ArrayList<CategoryFood> list=new ArrayList<CategoryFood>();
        String sql="select * from CategoryFood";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                CategoryFood categoryFood=new CategoryFood();
                categoryFood.setId(rs.getInt(1));
                categoryFood.setName(rs.getString(2));
                categoryFood.setType(rs.getString(3));

                list.add(categoryFood);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

}
