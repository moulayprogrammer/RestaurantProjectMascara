package BddTools;

import Moduls.FoodOrder;
import Moduls.User;

import java.util.ArrayList;

public class FoodOrderBdd extends BDD<FoodOrder> {

    @Override
    public boolean insert(FoodOrder o) {
        return false;
    }

    @Override
    public boolean update(FoodOrder o1, FoodOrder o2) {
        return false;
    }

    @Override
    public boolean delete(FoodOrder o) {
        return false;
    }

    @Override
    public boolean isExist(FoodOrder o) {
        return false;
    }

    @Override
    public ArrayList<FoodOrder> getAll() {
        return null;
    }
}
