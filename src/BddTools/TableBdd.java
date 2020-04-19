package BddTools;

import Moduls.FactuerMagasin;
import Moduls.Fornisour;
import Moduls.Table;
import Moduls.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableBdd extends BDD<Table> {

    @Override
    public boolean insert(Table table) {
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
    public boolean update(Table table, Table table1) {
        return false;
    }

    @Override
    public boolean delete(Table table) {
        return false;
    }

    @Override
    public boolean isExist(Table table) {
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
