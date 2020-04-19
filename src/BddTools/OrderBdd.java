package BddTools;

import Moduls.Order;
import Moduls.User;

import java.util.ArrayList;

public class OrderBdd extends BDD<Order> {

    @Override
    public boolean insert(Order o) {
        return false;
    }

    @Override
    public boolean update(Order o1, Order o2) {
        return false;
    }

    @Override
    public boolean delete(Order o) {
        return false;
    }

    @Override
    public boolean isExist(Order o) {
        return false;
    }

    @Override
    public ArrayList<Order> getAll() {
        return null;
    }
}
