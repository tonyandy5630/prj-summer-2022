/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.AccountDao;
import sample.dto.Account;
import sample.dto.MD5;


/**
 *
 * @author ACER
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String save = request.getParameter("savelogin");
            Account acc = null;
            try {
                if (email.isEmpty() || email.equals("") || password == null || password.isEmpty()) {
                    Cookie[] c= request.getCookies();
                    String token = "";
                    if( c != null)
                    {
                        for(Cookie aCookie : c)
                        {
                            if(aCookie.getName().equals("selector"))
                                token = aCookie.getValue();
                        }
                    }
                    if(!token.equals(""))
                        response.sendRedirect("personalPage.jsp");
                    else
                        response.sendRedirect("errorPage.jsp?message=Something+is+wrong");
//                        response.sendRedirect("errorPage.jsp?message="+email+"_"+password);
                }
                else
                {
                    acc = AccountDao.getAccont(email, password);
                    if(acc == null)
                    {
                        response.sendRedirect("errorPage.jsp?message="+email+""+password);
                    }
                    if (acc != null) 
                    {
                        if (acc.getRole() == 1) 
                        {
                            // admin homepage
                        }
                        else 
                        {
                            HttpSession session = request.getSession(true);
                            if(session != null )
                            {
                                session.setAttribute("accID", acc.getAccid());
                                session.setAttribute("email", email);
                                session.setAttribute("name", acc.getFullname());
                                if(save != null)
                                {
                                    String key = acc.getAccid() + email;
                                    String token = MD5.getMd5(key);
                                    AccountDao.updateToken(token, acc.getAccid());
                                    Cookie cookie = new Cookie("selector",token);
                                    cookie.setMaxAge(60 * 60);
                                    response.addCookie(cookie);
                                }
                                response.sendRedirect("personalPage.jsp");
                            }
                        }
                    } 
                    else 
                    {
//                        response.sendRedirect("loginError.html");
                        response.sendRedirect("errorPage.jsp?message="+email+""+password);
                    }
                }
            } catch (Exception e) {
            }

        } catch (Exception e) {
            e.printStackTrace();
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
