package BddTools;

import Moduls.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryBdd extends BDD{



    @Override
    public boolean insert(Object o) {


        return false;
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
    public ArrayList<Object> getAll(){
        return null;
    }
}
