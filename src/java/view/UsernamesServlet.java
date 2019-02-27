/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.UsernameLogic;

/**
 *
 * @author phucnguyen
 */
public class UsernamesServlet extends HttpServlet {

    

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
        UsernameLogic logic = new UsernameLogic();
        List<Username> usernames;
                if (request.getAttribute("usernames")== null){
                    usernames = logic.getAll();
                }else {
                    usernames = (List<Username>) request.getAttribute("usernames");
                }
                System.out.println(usernames);
        request.setAttribute("usernames", usernames);
          String destination = "/jsp/Usernames.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }

 

 

}
