package BddTools;

import Moduls.FactuerMagasin;
import Moduls.Fornisour;
import Moduls.Table;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableBdd extends BDD {

    @Override
    public boolean insert(Object o) {
        Table table =  (Table)o;
        String sql="insert into \"table\" ( Number) VALUES ('"+table.getNumber()+"')";
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
    public ArrayList<Table> getAll() {

        ArrayList<Table> list1=new ArrayList<Table>();
        String sql="select * from  \"table\"";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                Table table=new Table();
                table.setId(rs.getInt(1));
                table.setNumber(rs.getInt(2));


                list1.add(table);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list1;
    }
}
