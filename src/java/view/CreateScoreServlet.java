/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Score;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ScoreLogic;

/**
 *
 * @author baphucnguyen
 */
public class CreateScoreServlet extends HttpServlet {

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
        ScoreLogic logic = new ScoreLogic();
        Score score = logic.createEntity(request.getParameterMap());

        if (score.getPlayerid() != null) {
            if (score.getScore() != 0) {
                try{
                    logic.add(score);
                    request.setAttribute("successMessage", "Well done! You've done it.");
                }catch (Exception e){
                    request.setAttribute("scoreError", e.toString());
                }
            } else {
                System.out.println(score.getPlayerid());
                request.setAttribute("scoreError", "Please enter a valid score");
            }
        } else {
            System.out.println(score.getPlayerid());
            request.setAttribute("idError", "Please enter a valid ID");
        }

        String destination = "/Scores";
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
