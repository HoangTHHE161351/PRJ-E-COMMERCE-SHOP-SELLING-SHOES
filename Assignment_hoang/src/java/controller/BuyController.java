/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Cart;
import modelAdmin.Product;

/**
 *
 * @author phanh
 */
@WebServlet(name="BuyController", urlPatterns={"/buy"})
public class BuyController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuyController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // cart
        String code = request.getParameter("code");
        String quantity_raw = request.getParameter("quantity");
        int quantity;
        if(quantity_raw == null){
            quantity = 1;
        }else {
            quantity = Integer.parseInt(quantity_raw);
        }
        
        String color_raw = request.getParameter("color");
        int color;
        if(color_raw == null){
            color = 1;
        }else{
            color = Integer.parseInt(color_raw);
        }

        ProductDAO pd = new ProductDAO();
        ArrayList<Product> listP = pd.getAll();
        Cookie[] arr = request.getCookies();
        String cookies = "";

        if (arr != null) {
            for (Cookie i : arr) {
                if (i.getName().equals("cart")) {
                    cookies += i.getValue();
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
            }
        }
        
        Product pc = pd.getProductByProductCode(code);
        Cart cartC = new Cart(cookies, listP);
        
        if(cookies.isEmpty()){
            cookies = code + "_" + 0 + "/" + color;
        }else {
            cookies += "-" + code + "_" + 0 + "/" + color;
        }
        if(cartC.getItemByCode(pc.getProductCode()) == null){
            if(cookies.isEmpty()){
                cookies = code + "_" + quantity + "/" + color;
            }else {
                cookies += "-" + code + "_" + quantity + "/" + color;
            }
        }else if(cartC.getItemByCode(pc.getProductCode()).getQuantity() >= pc.getQuantity()){
            
        }else {
            if(cookies.isEmpty()){
                cookies = code + "_" + quantity + "/" + color;
            }else {
                cookies += "-" + code + "_" + quantity + "/" + color;
            }
        }

        Cart cart = new Cart(cookies, listP);
        
        Cookie c = new Cookie("cart", cookies);
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);
        request.setAttribute("cart", cart);
        request.setAttribute("size", cart.getItems().size());
        
        response.sendRedirect("home");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
