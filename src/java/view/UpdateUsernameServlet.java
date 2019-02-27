/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.UsernameLogic;

/**
 *
 * @author baphucnguyen
 */
@WebServlet(name = "UpdateUsernameServlet", urlPatterns = {"/UpdateUsernameServlet"})
public class UpdateUsernameServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        Username username = logic.createEntity(request.getParameterMap());
        if (username.getUsername() != null) {
            try {
                logic.update(username);
                request.setAttribute("updateSuccess", "Well done! You've updated it.");
            } catch (Exception e) {
                request.setAttribute("updateError", e.toString());
            }
        } else {
            request.setAttribute("updateError", "Please enter the valid username to update");
        }

        String destination = "/Usernames";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }

   

}
