/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import basicobject.Account;
import dbaccess.AccountDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

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
            //lay data tu man hinh loginpage.html
            String email=request.getParameter("txtemail");
            String password=request.getParameter("txtpassword");
            //validation
            if(!email.isEmpty() && !password.isEmpty()){
                //check email,password co trong bang Account
                Account acc=AccountDao.getAccount(email, password);
                if(acc!=null){
                    
                    //luu acc vao session memory 
                    HttpSession session=request.getSession();
                    session.setAttribute("loginedUser", acc);
                    
                    if(acc.getRole()==1)//is admin
                        response.sendRedirect("adminpage.jsp");
                    else//is customer
                        response.sendRedirect("personalpage.jsp");                        
                }
                else{
                    request.setAttribute("error", "email or password is invalid");
                    request.getRequestDispatcher("loginpage.jsp").forward(request, response);
                }
            }
            else{
                 //response.sendRedirect("loginpage.html");
                   request.setAttribute("error", "email or password is invalid");
                   request.getRequestDispatcher("loginpage.jsp").forward(request, response);
            }
        }catch(Exception e){ e.printStackTrace();}
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
