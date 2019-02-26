/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import entity.Score;
import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;
import logic.ScoreLogic;
import logic.UsernameLogic;

/**
 *
 * @author baphucnguyen
 */
public class DeletePlayerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeletePlayerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeletePlayerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PlayerLogic logic = new PlayerLogic();
        Player player = new Player();
        player.setId(Integer.valueOf(request.getParameter("id")));

        UsernameLogic usernameLogic = new UsernameLogic();
        List<Username> usernames = usernameLogic.getByID(Integer.valueOf(request.getParameter("id")));

        ScoreLogic scoreLogic = new ScoreLogic();
        List<Score> scores = scoreLogic.getScoresForPlayerID(Integer.valueOf(request.getParameter("id")));
        System.out.println(usernames.size());
        System.out.println(scores.size());
        if (usernames.size() != 0) {
            Username username = new Username();
            username.setPlayerid(Integer.valueOf(request.getParameter("id")));

            try {
                usernameLogic.delete(username);

            } catch (Exception e) {
                System.out.println("step 1");
                request.setAttribute("deleteError", e.toString());
            }

        }

        if (scores.size() != 0) {
            int size = scores.size();
            for (int i = 0; i < size; i++){
                scoreLogic.delete(scores.get(i));
                System.out.println("size is: "+scores.size());
            }
        }

        try {
            logic.delete(player);
            request.setAttribute("deleteSuccess", "You successfully deleted this player!");
        } catch (Exception e) {
            System.out.println("step 3");
            request.setAttribute("deleteError", e.toString());
        }
        String destination = "/Players";
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
