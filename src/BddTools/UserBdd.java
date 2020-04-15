package BddTools;


import Moduls.User;

import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.List;

public class UserBdd extends BDD {
    @Override
    public boolean insert(Object o) {
        User user =  (User)o;
      String sql="insert into Users(UserName,Password,Nom,Prenom,Tel,Type)values('"+user.getUserName()+"','"+user.getPassWord()+"','"+user.getNom()+"','"+user.getPrenom()+"','"+user.getTel()+"','"+user.getType()+"');";
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
        User user =  (User)o1;
        User user2 =  (User)o2;

        String sql= "UPDATE Users SET  Password = '"+user.getPassWord()+"',Type='"+user.getType()+"',Nom='"+user.getNom()+"',Prenom='"+user.getPrenom()+"',Tel='"+user.getTel()+"' WHERE Id='"+user2.getId()+"';";


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
    public boolean delete(Object o)
    {
        User user =  (User)o;
        String sql= " DELETE from Users where Id='"+user.getId()+"';";


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
    public boolean isExistuser(Object o) {
        User user =  (User)o;

        String sql= " select * from Users where UserName = '"+user.getUserName()+"' ;";


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
                users.setNom(rs.getString(5));
                users.setPrenom(rs.getString(6));
                users.setTel(rs.getString(7));
                list.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public User getUser(Object o){
        User user1 =  (User)o;
        User users=new User();


        String sql= "select * from Users where Id='"+user1.getId()+"';";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {

                users.setId(rs.getInt(1));
                users.setUserName(rs.getString(2));
                users.setPassWord(rs.getString(3));
                users.setType(rs.getString(4));
                users.setNom(rs.getString(5));
                users.setPrenom(rs.getString(6));
                users.setTel(rs.getString(7));
              //  return users;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }
}
