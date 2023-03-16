/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertController;

import daoAdmin.ProductAdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class ServletInsertProduct extends HttpServlet {

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
        try {
            String productCode = request.getParameter("productCode");
            String productName = request.getParameter("productName");
            int categoryID = Integer.valueOf(request.getParameter("categoryID"));
            double price = Double.valueOf(request.getParameter("price"));
            String description = request.getParameter("description");
            String status = request.getParameter("status");
            String size = request.getParameter("size");
            String images = request.getParameter("images");
            String gender = request.getParameter("gender");
            int colletionID = Integer.valueOf(request.getParameter("collectionID"));
            int materialID = Integer.parseInt(request.getParameter("materialID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String style = request.getParameter("style");
            int colorID = Integer.parseInt(request.getParameter("colorID"));
            String detailProduct = request.getParameter("detailProduct");
            int productLineID = Integer.parseInt(request.getParameter("productLineID"));

            Product p = new Product(productCode, productName, categoryID, price,
                    description, status, size, images, gender, colletionID, 
                    materialID, quantity, style, colorID, detailProduct, 
                    productLineID);
            ProductAdminDAO pad = new ProductAdminDAO();
            pad.insert(p);
            response.sendRedirect("productAdmin");
        } catch (Exception e) {
            response.getWriter().print(e);
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
