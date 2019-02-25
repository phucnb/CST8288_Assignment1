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
public class SearchUsernameServlet extends HttpServlet {

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
        String keyword = request.getParameter("keyword");
        String columnToSearch = request.getParameter("columnToSearch");
        String type = request.getParameter("type");
        UsernameLogic logic = new UsernameLogic();
        List<Username> usernames;
        if (columnToSearch.equals("1")) {
            try {
                    usernames = logic.getByID(Integer.valueOf(keyword));
                    request.setAttribute("usernames", usernames);
                } catch (Exception e) {
                    request.setAttribute("searchError", "Please enter number for Player ID!");
                }   
//            if (type.equals("1")) {
//                try {
//                    usernames = logic.getByID(Integer.valueOf(keyword));
//                    request.setAttribute("usernames", usernames);
//                } catch (Exception e) {
//
//                }
//
//            } else {
//                try {
//                    System.out.println("test" + keyword);
//                    usernames = logic.getByContainKeywordInPlayerID(Integer.valueOf(keyword));
//                    System.out.println("test1" + keyword);
//                    request.setAttribute("usernames", usernames);
//                } catch (Exception e) {
//
//                }
//
//            }
        } else {
             usernames = (List<Username>) logic.getByUserName(keyword);
                request.setAttribute("usernames", usernames);
//            if (type.equals("1")) {
//                usernames = (List<Username>) logic.getByUserName(keyword);
//                request.setAttribute("usernames", usernames);
//            } else {
//                usernames = logic.getByContainKeywordInUserName("%" + keyword + "%");
//                request.setAttribute("usernames", usernames);
//            }
        }

        String destination = "/UsernamesServlet";
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
