/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;
import logic.UsernameLogic;

/**
 *
 * @author baphucnguyen
 */
@WebServlet(name = "CreatePlayerServlet", urlPatterns = {"/CreatePlayerServlet"})
public class CreatePlayerServlet extends HttpServlet {

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
        System.out.println(player.getId());
        if (player.getId() != null) {
            if (player.getFirstName() != null) {
                if (player.getLastName() != null) {
                    if (player.getEmail() != null) {
                        
                    }else {
                         request.setAttribute("emailError", "error");
                    request.setAttribute("error", "Oop!");
                    }

                } else {
                    request.setAttribute("lnError", "error");
                    request.setAttribute("error", "Oop!");
                }
            } else {
                request.setAttribute("fnError", "error");
                request.setAttribute("error", "Oop!");
            }
            try {
                logic.add(player);
                request.setAttribute("successMessage", "Well done! You've done it.");

            } catch (Exception e) {
                request.setAttribute("error", e.toString());
            }
        } else {
            request.setAttribute("idError", "error");
            request.setAttribute("error", "Oop!");
        }

        String destination = "/Players";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
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
