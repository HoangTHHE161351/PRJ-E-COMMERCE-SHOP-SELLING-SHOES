/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import dal.ProductReviewDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.ProductReview;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
@WebServlet(name = "productDetailController", urlPatterns = {"/product-details"})
public class productDetailController extends HttpServlet {

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
        try {
            String productCode = request.getParameter("productCode");
            ProductDAO dao = new ProductDAO();
            Product p = new Product();
            p.setProductCode(productCode);
            Product p1 = dao.getProductByProductCode(productCode);
            request.setAttribute("product", p1);
            request.getRequestDispatcher("product-detail.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
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
        String productCode = request.getParameter("code");
        request.setAttribute("product", new ProductDAO().getProductByProductCode(productCode));
        ProductReviewDAO prd = new ProductReviewDAO();
        List<ProductReview> listReview = prd.getReviewListByProductCode(productCode);
        request.setAttribute("listReview", listReview);
        request.getRequestDispatcher("product-detail.jsp").forward(request, response);

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
        String code = request.getParameter("productCode");
        String quantity_raw = request.getParameter("quantity");
        int quantity;
        if (quantity_raw == null) {
            quantity = 1;
        } else {
            quantity = Integer.parseInt(quantity_raw);
        }
        ProductDAO pd = new ProductDAO();

        String size_raw = request.getParameter("size");

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

        if (cookies.isEmpty()) {
            cookies = code + "_" + quantity + "/" + size_raw;
        } else if (cartC.getItemByCode(pc.getProductCode()) == null) {
            if (cookies.isEmpty()) {
                cookies = code + "_" + quantity + "/" + size_raw;
            } else {
                cookies += "-" + code + "_" + quantity + "/" + size_raw;
            }
        } else if (cartC.getItemByCode(pc.getProductCode()).getQuantity() >= pc.getQuantity()) {

        } else {
            cookies += "-" + code + "_" + quantity + "/" + size_raw;
        }

        Cart cart = new Cart(cookies, listP);

        Cookie c = new Cookie("cart", cookies);
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);
        request.setAttribute("cart", cart);
        request.setAttribute("size", cart.getItems().size());
        String url = request.getRequestURL() + "?" + request.getQueryString();
        response.sendRedirect(url);
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
