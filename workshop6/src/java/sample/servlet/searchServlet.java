/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.OrderDAO;
import sample.dto.Order;

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

            String from = (String) request.getParameter("from");

            String to = (String) request.getParameter("to");
            
            if(!from.isEmpty())
            {
                if(to.compareTo(from) < 0 )
                {
                    request.setAttribute("WARNING", "from date must larger than to date");
                    request.getRequestDispatcher("personalPage.jsp").forward(request, response);
                }
                else
                {
                    int id = Integer.parseInt(request.getParameter("accid"));
                    ArrayList<Order> orders = OrderDAO.filterDate(from, to, id);

                    request.setAttribute("orders", orders);
                    request.setAttribute("from", from);
                    request.setAttribute("to", to);
                    request.getRequestDispatcher("personalPage.jsp").forward(request, response);
                }
            }
            else if( from.isEmpty() && to.isEmpty())
            {
                response.sendRedirect("personalPage.jsp");
            }
            
            
            
            // con loi chua chinh duoc chi set from ma khong can set to
//            response.sendRedirect("errorPage.jsp?message="+id);
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
