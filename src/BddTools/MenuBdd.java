package BddTools;

import Moduls.Menu;
import Moduls.User;

import java.util.ArrayList;

public class MenuBdd extends BDD<Menu> {

    @Override
    public boolean insert(Menu o) {
        return false;
    }

    @Override
    public boolean update(Menu o1, Menu o2) {
        return false;
    }

    @Override
    public boolean delete(Menu o) {
        return false;
    }

    @Override
    public boolean isExist(Menu o) {
        return false;
    }

    @Override
    public ArrayList<Menu> getAll() {
        return null;
    }
}
