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
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author lenovo
 */
public class login1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("username");
        String passW=request.getParameter("psw");
        
       
        LoginDAO l = new LoginDAO();
        try {
           String result = l.checkInfo(userName, passW);
           if(result.equals("you are logged in"))
               response.sendRedirect("student.html");
           else
               response.sendRedirect("login.html");
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
      catch (SQLException ex) {
       Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}