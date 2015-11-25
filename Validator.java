/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gill
 */
public class Validator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           //get the user name and password
            String myUn=request.getParameter("userName");
            String myPw=request.getParameter("password");
            String myStatus=request.getParameter("status");
            
            if (myUn.trim().length() == 0 || myPw.trim().length() == 0 || myStatus==null) {
            response.sendError(401, "The password cannot be empty. Please enter username, password and status.");
        }
            
            //check the un and pw
            if(myUn.equals("srv") && myPw.equals("Sheridan") && myStatus.equals("staff") ){
                //forward it 
                RequestDispatcher rd = request.getRequestDispatcher("/staffMenu.html");
                rd.forward(request, response);
            }
            else if(myUn.equals("srv") && myPw.equals("Sheridan") && myStatus.equals("student") ){
                //forward it 
                RequestDispatcher rd = request.getRequestDispatcher("/studentMenu.html");
                rd.forward(request, response);
            }
            else{
                out.print("Invalid user name or password");
                RequestDispatcher rd1 = request.getRequestDispatcher("/myLogin.html");
                rd1.include(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
