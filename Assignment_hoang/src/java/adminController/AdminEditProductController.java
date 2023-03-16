/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package adminController;

import dal.ProductDAO;
import daoAdmin.CategoryAdminDAO;
import daoAdmin.CollectionAdminDAO;
import daoAdmin.ProductAdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelAdmin.Category;
import modelAdmin.Collection;
import modelAdmin.Product;
import modelAdmin.ProductImage;
import modelAdmin.ProductSize;

/**
 *
 * @author phanh
 */
@WebServlet(name="AdminEditProductController", urlPatterns={"/adminEditProduct"})
public class AdminEditProductController extends HttpServlet {
   
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
            out.println("<title>Servlet AdminEditProductController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditProductController at " + request.getContextPath () + "</h1>");
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
        String code = request.getParameter("code");
        ProductDAO pd = new ProductDAO();
        request.setAttribute("product", pd.getProductByProductCode(code));
        request.getRequestDispatcher("jspAdmin/editProduct.jsp").forward(request, response);
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
        String productCode = request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String categoryID_raw = request.getParameter("categoryID");
        String price_raw = request.getParameter("price");
        price_raw = price_raw.replace(".", "");
        String decription = request.getParameter("description");
        String status = request.getParameter("status");
        String gender_raw = request.getParameter("gender");
        String collectionID_raw = request.getParameter("collectionID");
        String detail = request.getParameter("detail");
        String quantity_raw = request.getParameter("quantity");
        
        int categoryID, gender, quantity, collectionID;
        double price;
        try {
            categoryID = Integer.parseInt(categoryID_raw);
            gender = Integer.parseInt(gender_raw);
            quantity = Integer.parseInt(quantity_raw);
            collectionID = Integer.parseInt(collectionID_raw);
            price = Double.parseDouble(price_raw);
            
            ProductAdminDAO pd = new ProductAdminDAO();
            CollectionAdminDAO cld = new CollectionAdminDAO();
            CategoryAdminDAO cd = new CategoryAdminDAO();
            Category c = cd.select(categoryID);
            Collection cl = cld.select(collectionID);
            ProductImage pim = new ProductImage(productCode, "", "", "");
            ProductSize ps = new ProductSize(productCode, "", "", "", "", "", "", "", "", "", "", "", "");
            
            Product p = new Product(productCode, productName, price, decription, status, gender, quantity, "", detail, pim, ps, cl, c);
            
            pd.update(p);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        String url = request.getRequestURL() + "?" + request.getQueryString();
        response.sendRedirect(url);
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
