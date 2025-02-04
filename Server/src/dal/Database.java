/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;


public class Database {
    private final static String CONNECTION_PATH = "jdbc:oracle:thin:@localhost:1521:XE";
    private final static String USERNAME = "hr";
    private final static String PASSWORD = "hr";
    private Connection con;
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        con = DriverManager.getConnection(CONNECTION_PATH, USERNAME, PASSWORD);
        return con;
    }
    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
