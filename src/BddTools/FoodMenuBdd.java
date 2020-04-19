package BddTools;

import Moduls.FoodMenu;
import Moduls.User;

import java.util.ArrayList;

public class FoodMenuBdd extends BDD<FoodMenu> {

    @Override
    public boolean insert(FoodMenu o) {
        return false;
    }

    @Override
    public boolean update(FoodMenu o1, FoodMenu o2) {
        return false;
    }

    @Override
    public boolean delete(FoodMenu o) {
        return false;
    }

    @Override
    public boolean isExist(FoodMenu o) {
        return false;
    }

    @Override
    public ArrayList<FoodMenu> getAll() {
        return null;
    }
}
