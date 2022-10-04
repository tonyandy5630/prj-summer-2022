/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DBContext;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
@WebServlet(name = "userController", urlPatterns = {"/user"})
public class userController extends HttpServlet {

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
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "login":
                request.getRequestDispatcher("/WEB-INF/Layers/show.jsp").forward(request, response);
                break;
            case "checkLogin":
                CheckLogin(request, response);
                break;
            case "logout":
                Logout(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "checkRegister":
                checkRegister(request, response);
                break;
        }
    }

    public static void CheckLogin(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        boolean checkUser = DBContext.checkLogin(account, password);

        if (checkUser == false) {
            try {
                request.setAttribute("account", account);
                request.setAttribute("password", password);
                request.getRequestDispatcher("user/login.do").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("user", account);
                request.getRequestDispatcher("/home/homePage.do").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void Logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("/home/homePage.do").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void register(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/Layers/show.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void checkRegister(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String passWord = request.getParameter("password");
        String checkPass = request.getParameter("checkPassword");
        System.out.println(passWord);
        if (!checkPass.equals(passWord)) {
            try {
                request.setAttribute("message", "Check Password again!");
                request.setAttribute("account", account);
                request.setAttribute("password", passWord);
                request.setAttribute("checkPassword", checkPass);
                request.getRequestDispatcher("user/register.do").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                DBContext.register(account, passWord);
                request.getRequestDispatcher("/home/homePage.do").forward(request, response);
            } catch (SQLException | ServletException | IOException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
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
