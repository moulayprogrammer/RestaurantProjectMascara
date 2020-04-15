package BddTools;

import Moduls.User;

import java.util.ArrayList;

public class FoodBdd extends BDD {

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
    public ArrayList<User> getAll() {
        return null;
    }
}
