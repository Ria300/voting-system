/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */

public class signup1 extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("username");
        String email=request.getParameter("email");
        String passW=request.getParameter("psw");
        //out.println("hello");
        LoginDAO l = new LoginDAO();
        try {
           String result = l.addData(userName, email, passW);
           out.println(result);

        } 
      catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(signup1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
