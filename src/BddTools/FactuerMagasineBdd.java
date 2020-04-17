package BddTools;

import Moduls.FactuerMagasin;
import Moduls.Produit;
import Moduls.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FactuerMagasineBdd extends BDD {
    @Override
    public boolean insert(Object o) {
        FactuerMagasin factuerMagasin =  (FactuerMagasin)o;
        String sql="";
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
    public boolean update(Object o1, Object o2) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public boolean isExist(Object o) {
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
