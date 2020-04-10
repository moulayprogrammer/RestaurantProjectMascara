package BddTools;


import Moduls.User;

import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.List;

public class UserBdd extends BDD {
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
        User user =  (User)o;

        String sql= " select * from Users where UserName = '"+user.getUserName()+"' and Password = '"+user.getPassWord()+"';";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> list=new ArrayList<User>();
        String sql="select * from Users";


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                User users=new User();
                users.setId(rs.getInt(1));
                users.setUserName(rs.getString(2));
                users.setPassWord(rs.getString(3));
                users.setType(rs.getString(4));
                list.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return list;
    }
}
