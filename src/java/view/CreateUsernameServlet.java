/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Username;
import java.io.IOException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.UsernameLogic;

/**
 *
 * @author baphucnguyen
 */
public class CreateUsernameServlet extends HttpServlet {

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

        if (username.getPlayerid() != null) {
            if (username.getPlayer() != null) {
                if (username.getUsername() != null) {
                    try {
                        logic.add(username);
                        request.setAttribute("successMessage", "Well done! You've done it.");
                    } catch (Exception e) {
                        request.setAttribute("error", "Select update instead of create new username for this player.");
                    }
                } else {
                    request.setAttribute("usernameError", "Please enter the valid username");
                }
            } else {
                request.setAttribute("idError", "This ID does not exist.");
            }
        } else {
            request.setAttribute("idError", "Please enter the valid Player ID");
        }
        String destination = "/Usernames";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
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
