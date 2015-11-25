/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gill
 */
public class ConnControl {
    public Connection connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        //define all connection data
        String driverName="com.mysql.jdbc.Driver";
        String dbUrl="jdbc:mysql://localhost:3306/library";
        String userName="root";
        String pw="mysql";
        //open the connection
        Class.forName(driverName).newInstance();
        try {
            Connection con=DriverManager.getConnection(dbUrl,userName,pw);
            return con;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }//end of the connect
    public void FreeConnection(Connection c)throws SQLException{
        if(c!=null)c.close();
    }
}


