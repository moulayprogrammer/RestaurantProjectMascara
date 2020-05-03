package BddTools;

import Moduls.CategoryFood;
import Moduls.Food;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodBdd extends BDD<Food> {

    @Override
    public boolean insert(Food o) {
        String sql="insert into Food(name, description, price, id_category,image) values ('"+o.getName()+"','"+o.getDescription()+"','"+o.getPrice()+"','"+o.getIdCategory()+"','"+o.getImage()+"')";
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
    public boolean update(Food o1, Food o2) {
        return false;
    }

    @Override
    public boolean delete(Food o) {
        return false;
    }

    @Override
    public boolean isExist(Food o) {
        return false;
    }

    @Override
    public ArrayList<Food> getAll() {
        ArrayList<Food> list=new ArrayList<Food>();
        String sql="select * from Food order by id";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                Food food=new Food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setDescription(rs.getString(3));
                food.setPrice(rs.getFloat(4));
                food.setIdCategory(rs.getInt(5));


                list.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }
}
