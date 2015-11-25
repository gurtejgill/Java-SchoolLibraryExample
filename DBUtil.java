/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Gill
 */
public class DBUtil {
    
    public static void closeStatement(Statement s) throws SQLException{
        if(s!=null)s.close();
    }
    
    public static void closePreparedStatement(PreparedStatement ps) throws SQLException{
        if(ps!=null)ps.close();
    }
    
    public static void closeResultSet(ResultSet r) throws SQLException{
        if(r!=null)r.close();
    }
                
    }
   


