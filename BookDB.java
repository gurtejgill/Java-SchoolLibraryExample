/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Gill
 */
public class BookDB {
    
    ArrayList<String> listt = new ArrayList<String>();
    ArrayList<String> lista = new ArrayList<String>();
    ArrayList<String> listb = new ArrayList<String>();
    String ans;

    
        public static int insert(Book c) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        //define the local object that will be used in the insert process
        PreparedStatement ps=null;
        Connection myCon=null;
        ConnControl conManager;
        String ptsm="INSERT INTO books(bookID,title,author)VALUES(?,?,?)";
        try{
            //create a connection to mysql
            conManager=new ConnControl();
            myCon=conManager.connect();
            //create a preparedStatement object that models the sql insert command
            ps=myCon.prepareStatement(ptsm);
            //set the parameters of the ps
            ps.setInt(1,c.getBookID());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getAuthor());
            //execute the ps
            return ps.executeUpdate();
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }//end of the insert method
    
        
          public static ResultSet search(String title, String author) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Statement s;
        Connection myCon;
        ConnControl conManager;
        ResultSet r;
        //prepare the sql statement(we will use the prepared statement for security)
        String stm = "SELECT * FROM books WHERE title=? OR author=? ";
        try{
        //create prepared statement object
        conManager=new ConnControl();
        myCon=conManager.connect();
        //create statement object
        s=myCon.createStatement();
        PreparedStatement pstm = myCon.prepareStatement(stm);
            pstm.setString(1,""+title);
            pstm.setString(2,""+author);
        //execute the statement
        r=pstm.executeQuery();
        return r;
        
        } catch (SQLException e) {
            return null;
        }
    }
        
    public static ResultSet showAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        //define local objects that will be used in the process
        Statement s;
        Connection myCon;
        ConnControl conManager;
        ResultSet r;
        String stm="SELECT * FROM books;";
        try{
        //create connection 
        conManager=new ConnControl();
        myCon=conManager.connect();
        //create statement object
        s=myCon.createStatement();
        //execute the statement
        r=s.executeQuery(stm);
        return r;
        
       
        } catch (SQLException e) {
            return null;
        }
    
    }   
}
