/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;

/**
 *
 * @author baphucnguyen
 */
public class UpdatePlayerServlet extends HttpServlet {

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
        PlayerLogic logic = new PlayerLogic();
        Player player = logic.createEntity(request.getParameterMap());
        
        if (player.getFirstName() != null) {
            if (player.getLastName() != null) {
                try {
                    logic.update(player);

                    request.setAttribute("successMessage", "You've updated it.");
                } catch (Exception e) {
                    request.setAttribute("error", e.toString());
                }

            } else {
                request.setAttribute("updateError", "Please enter the valid last name to update");
            }
        } else {
            request.setAttribute("updateError", "Please enter the valid first name to update");
        }

        
        String destination = "/Players";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }

   

}
