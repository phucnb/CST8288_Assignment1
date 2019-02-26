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
public class DeleteScoreServlet extends HttpServlet {

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
        //create logic and entity
        ScoreLogic logic = new ScoreLogic();
//        Score score = logic.createEntity(request.getParameterMap());
        Score score = new Score();
        score.setId(Integer.valueOf(request.getParameter("id")));
        try {
            logic.delete(score);
            request.setAttribute("deleteSuccess", "You successfully deleted this score for player!");
        } catch (Exception e) {
            request.setAttribute("deleteError", e.toString());
        }
        
        String destination = "/Scores";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }
    
}
