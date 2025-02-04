/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HomeUserDTO;
import dto.UserDTO;
import entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;


/**
 *
 * @author Ahmed
 */
public class UserDAO {

    static public String getPassword(String userName) throws SQLException{
        Database db = new Database();
        Connection con = db.getConnection();
        PreparedStatement stmt  = con.prepareStatement("select password from users where username = ?");
       stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        String password= null;
        if (rs.next()) {
            password = rs.getString("password");
        }
        db.close();
        stmt.close();
        return password;
    }


    static public int addUser(User user) throws SQLException {return 0;}
    static public HomeUserDTO getHomeUser(String userName) throws SQLException {
        Database db = new Database();
        Connection con = db.getConnection();
        PreparedStatement stmt  = con.prepareStatement("select username, fullName, balance from users where username = ?");
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        HomeUserDTO user = null;
        if (rs.next()) {
            user = new HomeUserDTO( rs.getString("username"),  rs.getString("fullName"), rs.getDouble("balance"));
        }
        db.close();
        stmt.close();
        return user;
    }
    static public int updateBalance(String userName) throws SQLException {return 0;}



}
