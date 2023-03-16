/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CartDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.Item;
import model.User;
import modelAdmin.Product;

/**
 *
 * @author phanh
 */
@WebServlet(name="CartProcessController", urlPatterns={"/process"})
public class CartProcessController extends HttpServlet {
   
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
            out.println("<title>Servlet CartProcessController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartProcessController at " + request.getContextPath () + "</h1>");
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
        
        String productCode = request.getParameter("productCode");
        String quantity_raw = request.getParameter("quantity");
        String size = request.getParameter("size");
        int quantity;
        try {
            quantity = Integer.parseInt(quantity_raw);
            Product p = pd.getProductByProductCode(productCode);
            if( (quantity  == -1) && (cart.getQuantityByCode(productCode) <= 1) ){
                cart.removeItem(productCode);
            }else {
                if( (quantity == 1) && (cart.getQuantityByCode(productCode) >= p.getQuantity()) ){
                    quantity = 0;
                }
                Item item = new Item(p, p.getPrice(), quantity, size);
                cart.addItem(item);
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
        
        request.setAttribute("cart", cart);
        response.sendRedirect("cart");
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
        List<Product> prods = pd.getAll();
        Cookie arr[] = request.getCookies();
        String txt = "";

        if (arr != null) {
            for (Cookie item : arr) {
                if (item.getName().equals("cart")) {
                    txt += item.getValue();

                }
            }
        }

        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("account");

        Cart cart = new Cart(txt, prods);

        if (a == null) {
            response.sendRedirect("login");
        } else {
            
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            if (firstName != null && !firstName.equalsIgnoreCase(a.getFirstName())) {
                a.setFirstName(firstName);
            }

            if (lastName != null && !lastName.equalsIgnoreCase(a.getLastName())) {
                a.setLastName(lastName);
            }

            if (phone != null && !phone.equalsIgnoreCase(a.getPhoneNumber())) {
                a.setPhoneNumber(phone);
            }

            if (address != null && !address.equalsIgnoreCase(a.getAddress())) {
                a.setAddress(address);
            }

            CartDAO cartd = new CartDAO();
            cartd.checkout(a, cart);

            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(0);
            response.addCookie(c);
            response.sendRedirect("cart");
        }
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
