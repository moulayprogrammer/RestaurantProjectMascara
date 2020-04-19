package BddTools;

import Moduls.FactuerMagasin;
import Moduls.Produit;
import Moduls.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FactuerMagasineBdd extends BDD<FactuerMagasin> {

    @Override
    public boolean insert(FactuerMagasin o) {
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
    public boolean update(FactuerMagasin o1, FactuerMagasin o2) {
        return false;
    }

    @Override
    public boolean delete(FactuerMagasin o) {
        return false;
    }

    @Override
    public boolean isExist(FactuerMagasin o) {
        return false;
    }

    @Override
    public ArrayList<FactuerMagasin> getAll() {
        return null;
    }
}
