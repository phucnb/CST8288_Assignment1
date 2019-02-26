/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
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
public class SearchPlayerServlet extends HttpServlet {

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

        String keyword = request.getParameter("keyword");
        String columnToSearch = request.getParameter("columnToSearch");
        String dateType = request.getParameter("dateType");

        PlayerLogic logic = new PlayerLogic();

        List<Player> players;

        if (columnToSearch.equals("1")) {
            try {
                Player player = logic.getPlayerWithId(Integer.valueOf(keyword));
                System.out.println(player);
                request.setAttribute("players", player);
            } catch (Exception e) {
                System.out.println(e.toString());
                request.setAttribute("searchError", "Please enter number for Player ID!");
            }
        } else if (columnToSearch.equals("2")) {
            try {
                players = logic.getPlayersWithFirstName(keyword);
                request.setAttribute("players", players);
            } catch (Exception e) {
                request.setAttribute("searchError", "Please enter a valid first name to search");
            }
        } else if (columnToSearch.equals("3")) {
            try {
                players = logic.getPlayersWithLastName(keyword);
                request.setAttribute("players", players);
            } catch (Exception e) {
                request.setAttribute("searchError", "Please enter a valid Last name to search");
            }
        } else if (columnToSearch.equals("4")) {
            try {
                players = (List<Player>) logic.getPlayerWithEmail(keyword);
                request.setAttribute("players", players);
            } catch (Exception e) {
                request.setAttribute("searchError", "Please enter a valid email to search");
            }
        } else {
            if (dateType.equals("3")) {
                try {
                    players = logic.getPlayersJoinedOn(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
                    request.setAttribute("players", players);
                } catch (ParseException ex) {
                }
            } else if (dateType.equals("1")) {
                try {
                    players = logic.getPlayerOnDateBefore(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
                    request.setAttribute("players", players);
                } catch (ParseException ex) {
                }
            } else if (dateType.equals("2")) {
                try {
                    players = logic.getPlayerOnDateAfter(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
                    request.setAttribute("players", players);
                } catch (ParseException ex) {
                }
            }

        }
        String destination = "/Players";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }
}
