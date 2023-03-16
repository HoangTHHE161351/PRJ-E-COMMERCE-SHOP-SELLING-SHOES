/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import daoAdmin.CollectionAdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelAdmin.Collection;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class productController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {

            ProductDAO dao = new ProductDAO();
            ArrayList<Product> list;
            HttpSession session = request.getSession();
            if(session.getAttribute("list")== null){
                list = dao.getAll();
            }else {
                list = (ArrayList<Product>) session.getAttribute("list");
//                session.removeAttribute("list");
            }
            int start = 0, end = 6;
            int numProduct = 6;
            CollectionAdminDAO cad = new CollectionAdminDAO();
            ArrayList<Collection> collectionList = cad.getAll();
            if (request.getParameter("numProduct") != null) {
                numProduct = Integer.parseInt(request.getParameter("numProduct"));
                if(numProduct < end){
                    end = start + numProduct;
                }
            }
            if (list.size() < end) {
                end = list.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }

            ArrayList<Product> listByPage = dao.getListByPage(list, start, end);
            int numPage = list.size() / numProduct;
            if (numPage * numProduct < list.size()) {
                numPage++;
            }
            int currPage = start/numProduct;
            if(currPage*numProduct < end){
                currPage++;
            }
            request.setAttribute("numPage", numPage);
            request.setAttribute("size", list.size());
            request.setAttribute("currPage", currPage);
            request.setAttribute("numProduct", numProduct);
            request.setAttribute("productList", listByPage);
            request.setAttribute("collectionList", collectionList);
            request.getRequestDispatcher("/product.jsp").forward(request, response);
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
