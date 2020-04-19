package BddTools;

import Moduls.Food;
import Moduls.User;

import java.util.ArrayList;

public class FoodBdd extends BDD<Food> {

    @Override
    public boolean insert(Food o) {
        return false;
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
        return null;
    }
}
