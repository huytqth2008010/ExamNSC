package com.example.examnsc.dao;
//by : Huy
import com.example.examnsc.model.User;
import com.example.examnsc.utils.ConnectionUtils;

import java.sql.*;

public class UserDao {
    Connection connection = ConnectionUtils.getConnection();

    public User getUser(String pName, String password) {
        User user = null;
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = String.format("select * from users where username = '"+pName +"' and password = " +password);
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()){
                String name = rs.getString("username");
                String pass = rs.getString("password");
                user = new User(name, pass);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

}
