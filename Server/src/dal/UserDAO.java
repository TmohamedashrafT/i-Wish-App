/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.UserDTO;
import entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;


/**
 *
 * @author Ahmed
 */
public class UserDAO {
    
    private final static String CONNECTION_PATH = "jdbc:oracle:thin:@localhost:1521:XE";
    private final static String USERNAME = "hr";
    private final static String PASSWORD = "hr";
    static public String getPassword(String userName) throws SQLException{
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection(CONNECTION_PATH, USERNAME, PASSWORD);
        PreparedStatement stmt  = con.prepareStatement("select password from logintest where username = ?");
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        String password= null;
        while(rs.next()){
            password = rs.getString("password"); 
        }
        con.close();
        stmt.close();
        return password; 
    }

    
    static public int addUser(User user) throws SQLException {return 0;}
    static public UserDTO getUser(String userName ) throws SQLException {return new UserDTO();}
    static public int updateBalance(String userName) throws SQLException {return 0;}


    
}
