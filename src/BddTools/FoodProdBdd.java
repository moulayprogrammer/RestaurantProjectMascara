package BddTools;

import Moduls.FoodProd;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodProdBdd extends BDD<FoodProd> {
    @Override
    public boolean insert(FoodProd o) {
        String sql="insert into Food_Prod(qte, idprod, idfood) VALUES ('"+o.getQte()+"','"+o.getProduit()+"','"+o.getIdfood()+"')";
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
    public boolean update(FoodProd o1, FoodProd o2) {
        return false;
    }

    @Override
    public boolean delete(FoodProd o) {
        return false;
    }

    @Override
    public boolean isExist(FoodProd o) {
        return false;
    }

    @Override
    public ArrayList<FoodProd> getAll() {
        return null;
    }
}
