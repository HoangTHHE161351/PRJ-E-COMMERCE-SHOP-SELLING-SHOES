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
import java.util.List;
import model.Cart;
import model.Item;
import modelAdmin.Product;

/**
 *
 * @author phanh
 */
@WebServlet(name="CartChangeSizeController", urlPatterns={"/changeSize"})
public class CartChangeSizeController extends HttpServlet {
   
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
            out.println("<title>Servlet CartChangeSizeController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartChangeSizeController at " + request.getContextPath () + "</h1>");
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
        ProductDAO pd = new ProductDAO();
        List<Product> list = pd.getAll();
        Cookie arr[] = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie item : arr) {
                if (item.getName().equals("cart")) {
                    txt += item.getValue();
                    item.setMaxAge(0);
                    response.addCookie(item);
                }
            }
        }
        Cart cart = new Cart(txt, list);
        
        String productCode = request.getParameter("code");
        String size = request.getParameter("size");
        try {
            Product p = pd.getProductByProductCode(productCode);
            if(p.getCategory().getId() == 1){
                int size_par = Integer.parseInt(size);
                if(size_par != cart.getItemByCode(productCode).getSizeFormat()){
                    cart.getItemByCode(productCode).setSize(size_par+"");
                }
            }else {
                if(!size.equals(cart.getItemByCode(productCode).getSize())){
                    cart.getItemByCode(productCode).setSize(size);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        List<Item> items = cart.getItems();
        txt = "";
        
        if(items.size() > 0){
            txt = items.get(0).getProduct().getProductCode()+ "_" + items.get(0).getQuantity() + "/" + items.get(0).getSize();
            
            for (int i = 1; i < items.size(); i++) {
                txt += "-" + items.get(i).getProduct().getProductCode() + "_" + items.get(i).getQuantity()+ "/" + items.get(i).getSize();
            }
        }
        
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(7 * 24 * 60 *60);
        response.addCookie(c);
        response.sendRedirect("cart");
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
