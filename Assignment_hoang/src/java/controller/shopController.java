/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import daoAdmin.CategoryAdminDAO;
import daoAdmin.CollectionAdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import modelAdmin.Collection;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
@WebServlet(name = "shopController", urlPatterns = {"/shop"})
public class shopController extends HttpServlet {

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
        ProductDAO pd = new ProductDAO();
        List<Product> listp = pd.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";

        if (arr != null) {
            for (Cookie i : arr) {
                if (i.getName().equals("cart")) {
                    txt += i.getValue();
                }
            }
        }

        Cart cart = new Cart(txt, listp);
        List<Item> listItem = cart.getItems();
        int n;
        if (listItem != null) {
            n = listItem.size();
        } else {
            n = 0;
        }
        request.setAttribute("cartSize", n);
        
        
        CategoryAdminDAO cd = new CategoryAdminDAO();
        CollectionAdminDAO cld = new CollectionAdminDAO();

        String cid_raw = request.getParameter("cid");

        int cid;
        try {
            cid = Integer.parseInt(cid_raw);
            request.setAttribute("cid", cid);
        } catch (NumberFormatException e) {
            System.out.println(e);
            cid = 0;
        }


        List<Product> listP = pd.getProductByCategoryID(cid);
        String numberPerPage_raw = request.getParameter("numPerPage");

        String[] collection_raw = request.getParameterValues("clid");
        if (collection_raw != null) {
            int[] clid = null;

            if (collection_raw != null) {
                clid = new int[collection_raw.length];
                for (int i = 0; i < clid.length; i++) {
                    clid[i] = Integer.parseInt(collection_raw[i]);
                }
            }

            List<Collection> listCL = cld.getAll();
            boolean[] collectionCheck = new boolean[listCL.size()];
            for (int i = 0; i < collectionCheck.length; i++) {
                if (isCollection(listCL.get(i).getId(), clid)) {
                    collectionCheck[i] = true;
                } else {
                    collectionCheck[i] = false;
                }
            }
            request.setAttribute("collectionCheck", collectionCheck);
            
            listP = pd.getProductByCollectID(clid);
            
            String collectionS = "";
            for (int i = 0; i < clid.length; i++) {
                if(i == clid.length - 1){
                    collectionS += clid[i];
                }else {
                    collectionS += clid[i] + "&clid=";
                }
            }
            request.setAttribute("collectionS", collectionS);
        }
        String search = request.getParameter("search");
        if(search != null){
            listP = pd.getProductBySearch(search);
        }

        int page, numberPerPage = 8;

        if (numberPerPage_raw != null) {
            numberPerPage = Integer.parseInt(numberPerPage_raw);
        }
        String xpage = request.getParameter("page");

        int size = listP.size();    // số lượng sản phẩm % số lượng sản phẩm trên 1 trang nếu nó chia hết thì => lấy nó còn nếu không thì cộng thêm 1 
        int numberOfPage = ((size % numberPerPage == 0) ? (size / numberPerPage) : (size / numberPerPage + 1));
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start, end;
        start = (page - 1) * numberPerPage;
        end = Math.min(page * numberPerPage, size);
        List<Product> listByPage = pd.getListByPage(listP, start, end);

        request.setAttribute("page", page);
        request.setAttribute("numberPage", numberOfPage);
        request.setAttribute("numPerPage", numberPerPage);
        request.setAttribute("listByPage", listByPage);

        
        request.setAttribute("collection", cld.getAll());
        request.setAttribute("category", cd.getAll());
        request.getRequestDispatcher("/product.jsp").forward(request, response);

    }

    private boolean isCollection(int collectionID, int[] list) {

        for (int i = 0; i < list.length; i++) {
            if (list[i] == collectionID) {
                return true;
            }
        }
        return false;
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
