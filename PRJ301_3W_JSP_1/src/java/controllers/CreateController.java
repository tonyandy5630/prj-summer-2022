/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import user.UserDAO;
import user.UserDTO;
import user.UserError;

/**
 *
 * @author thanhthu
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        boolean checkValidation = true;
        UserDAO dao = new UserDAO();
        try{
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            
            //check length
            if(userID.length()>10 || userID.length()<2){
                checkValidation = false;
                userError.setUserIDError("User ID must be between 2 and 10 characters!");
            }
            //check duplication
//            boolean checkDuplicate = dao.checkID(userID);
//            if(checkDuplicate){
//                checkValidation = false;
//                userError.setUserIDError("User ID duplicated. Please choose another!!");
//            }
            
            //check Full Name
            if(fullName.length()>100 || fullName.length()<5){
                checkValidation = false;
                userError.setFullNameError("Full Name must be between 5 and 100 characters!");
            }
            
            //check Password - Confirm
            if(!password.equals(confirm)){
                checkValidation = false;
                userError.setConfirmError("Confirm password must be the same as Password!!");
            }
            
            if(checkValidation){
//                boolean checkInsert = dao.insert(new UserDTO(userID, fullName, roleID, password, true));
                boolean checkInsert = dao.insertV2(new UserDTO(userID, fullName, roleID, password, true));
                if(checkInsert) url = SUCCESS;
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        }catch (Exception e){
            log("Error at Create Controller: "+e.toString());
            if(e.toString().contains("duplicate")){
                userError.setUserIDError("Duplicated User ID!!");
                request.setAttribute("USER_ERROR", userError);
            }
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
