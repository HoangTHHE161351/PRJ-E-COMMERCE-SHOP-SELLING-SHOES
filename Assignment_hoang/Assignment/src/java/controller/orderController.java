/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daoAdmin.OrderAdminDAO;
import daoAdmin.OrderDetailAdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.User;
import modelAdmin.Order;
import modelAdmin.OrderDetail;

/**
 *
 * @author GearVn
 */
public class orderController extends HttpServlet {

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
            HttpSession session = request.getSession();
            Cart c = (Cart) session.getAttribute("cart");
            String username ="";
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phoneNumber");
            String adress = request.getParameter("address");
            if(session.getAttribute("account") != null){
                User u = (User) session.getAttribute("account");
                username = u.getUsername();
            } 
            OrderAdminDAO dao = new OrderAdminDAO();
            Order o = new Order(username, firstName, lastName, c.totalMoney(), "Pending", adress, phone);
            dao.insert(o);
            ArrayList<Order> orderList = dao.getAll();
            int maxID = 0;
            for (Order x : orderList) {
                if(x.getId() > maxID){
                    maxID = x.getId();
                }
            }
            OrderDetailAdminDAO ddao = new OrderDetailAdminDAO();
            int index = 0;
            for(Item i : c.getCart()){
                String[] listSize = request.getParameterValues("size");
                ddao.insert(new OrderDetail(maxID, i.getProduct().getProductCode(), i.getQuantity(),listSize[index]));
                index++;
            }
            session.removeAttribute("cart");
            response.sendRedirect("index");
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
