package BddTools;

import Moduls.Daten;
import Moduls.User;

import java.util.ArrayList;

public class DateBdd extends BDD<Daten> {

    @Override
    public boolean insert(Daten o) {
        return false;
    }

    @Override
    public boolean update(Daten o1, Daten o2) {
        return false;
    }

    @Override
    public boolean delete(Daten o) {
        return false;
    }

    @Override
    public boolean isExist(Daten o) {
        return false;
    }

    @Override
    public ArrayList<Daten> getAll() {
        return null;
    }
}
