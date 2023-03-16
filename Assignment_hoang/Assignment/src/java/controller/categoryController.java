/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class categoryController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            ProductDAO dao = new ProductDAO();
            ArrayList<Product> list = dao.getAll();
            HttpSession sesion = request.getSession();
            if (request.getParameter("collectionId") != null) {
                ArrayList<Product> listCategory = new ArrayList<>();
                int id = Integer.valueOf(request.getParameter("collectionId"));
                for (Product p : list) {
                    if (p.getCollectionID() == id) {
                        listCategory.add(p);
                    }
                }
                sesion.setAttribute("list", listCategory);
                response.sendRedirect("product");
            }
            if(request.getParameter("categoryId")!= null){
                ArrayList<Product> listCategory = new ArrayList<>();
                int id = Integer.valueOf(request.getParameter("categoryId"));
                for (Product p : list) {
                    if (p.getCategoryID() == id) {
                        listCategory.add(p);
                    }
                }
                sesion.setAttribute("list", listCategory);
                response.sendRedirect("product");
            }
            
            
        } catch (Exception e) {
            response.getWriter().println(e);
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
