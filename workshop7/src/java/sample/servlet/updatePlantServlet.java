/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.PlantDao;
import sample.dto.Plant;

/**
 *
 * @author ACER
 */
public class updatePlantServlet extends HttpServlet {

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
           int id = Integer.parseInt(request.getParameter("pid"));
           String name;
           int price;
           String desc;
           int status;
           int cateid;
           
           Plant p = PlantDao.getPlant(id);
           if( request.getParameter("pName").isEmpty())
           {
               name = p.getName();
           }
           else
           {
               name = request.getParameter("pName");
           }
           
           if(request.getParameter("price").isEmpty())
           {
               price = p.getPrice();
           }
           else{
               price = Integer.parseInt(request.getParameter("price"));
           }
           
           if(request.getParameter("pDesc").isEmpty() )
           {
               desc = p.getDescription();
           }
           else{
               desc = request.getParameter("pDesc");
           }
           
           if(request.getParameter("pCategory").isEmpty())
           {
               cateid = p.getCateId();
           }
           else{
               cateid = Integer.parseInt(request.getParameter("pCategory"));
           }
           
           if(request.getParameter("status").isEmpty())
           {
               status = p.getId();
           }
           else
           {
               status = Integer.parseInt(request.getParameter("status"));
           }
           
           boolean success = PlantDao.updatePlant(id, name, price, desc, status, cateid);
           
           if(success)
           {
               Plant newP = PlantDao.getPlant(id);
               request.setAttribute("WARNING", "Update successfully");
               request.setAttribute("plant", newP);
               request.getRequestDispatcher("updatePlant.jsp").forward(request, response);
           }
           else
           {
               request.setAttribute("WARNING", "Update failed");
               request.getRequestDispatcher("updatePlant.jsp").forward(request, response);
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
