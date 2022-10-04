/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import sample.dao.AccountDao;
import sample.dto.Account;

/**
 *
 * @author ACER
 */
public class registerServlet extends HttpServlet {

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String phone = request.getParameter("phone");
            String Numberpattern = "([^a-zA-Z]+)\\d+";
            if(!phone.matches(Numberpattern))
            {
                request.setAttribute("email",email);
                request.setAttribute("password",password);
                request.setAttribute("fullname",fullname);
                request.setAttribute("phone", phone);
                request.setAttribute("ERROR", "the phone is invalid");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else
            {
                boolean result = AccountDao.insertAccount(email, password, fullname, phone, 1, 0);
                Account checkAcc = AccountDao.getAccont(email, password);
                if (checkAcc != null) {
                    request.setAttribute("email_newAcc", email);
                    RequestDispatcher rd = request.getRequestDispatcher("errorPage.jsp?message="+phone);
                    rd.forward(request,response);
                }
                else
                {
                    response.sendRedirect("errorPage.jsp?message=Failed");
                }
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
