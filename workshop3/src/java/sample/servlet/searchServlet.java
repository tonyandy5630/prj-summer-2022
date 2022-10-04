/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sample.dao.PlantDao;
import sample.dto.Plant;

/**
 *
 * @author ACER
 */
public class searchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            String keyword = request.getParameter("txtsearch");
            String searchBy = request.getParameter("searchby");

            ArrayList<Plant> plantList = PlantDao.getPlants(keyword, searchBy);
            if (plantList != null && !plantList.isEmpty()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet searchServlet</title>");
                out.println("<link rel='stylesheet' href='mycss.css' type='text/css'/>");
                out.println("</head>");
                out.println("<body>");
                ServletContext context = getServletContext();
                String country = context.getInitParameter("Country");
                ServletConfig context2 = getServletConfig();
                String lang = context2.getInitParameter("lang");
                out.println(" <p> Server is deploying at :" + country + "</p>");
                out.println(" <p> Server is using language:" + lang + "</p>");
                out.println("<p>" + searchBy + "</p>");
                out.println("<section>");
                out.println("<table class='producttable'>");
                out.println("<tr><td> product id </td><td> name </td><td> price </td><td> images </td><td> detail </td><td> action </td></tr>");
                for (Plant plant : plantList) {
                    out.println("<tr>");
                    out.println("<td>" + plant.getId() + "</td>");
                    out.println("<td>" + plant.getName() + "</td>");
                    out.println("<td>" + plant.getPrice() + "</td>");
                    out.println("<td> <img src='" + plant.getImgPath() + "' class='product'></td>");
                    out.println("<td> <a href='#'> view detail </a></td>");
                    out.println("<td> <a href='#'> add to your cart</a></td>");
                    out.println("</tr>");
                }
                out.println("</table></section>");
                out.println("</body>");
                out.println("</html>");
            }
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
        processRequest(request, response);
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
