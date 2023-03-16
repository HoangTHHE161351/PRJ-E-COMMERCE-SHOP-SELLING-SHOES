/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import model.User;

/**
 *
 * @author GearVn
 */
@WebServlet(name="ContactController", urlPatterns={"/changeInfo"})

public class ChangeInfoController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("account");
            request.setAttribute("user", u);
            request.getRequestDispatcher("account.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            response.getWriter().println(e);
        }

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
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("oldPassword");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String adress = request.getParameter("address");
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("account");
            if (password.equals(u.getPassword())) {
                UserDAO dao = new UserDAO();
                if (request.getParameter("newPassword") != null && request.getParameter("reNewPassword") != null) {
                    String newPassword = request.getParameter("newPassword");
                    String reNewPassword = request.getParameter("reNewPassword");
                    if (newPassword.equals(reNewPassword)) {
                        User uUpdate = new User(username, newPassword, phone, adress, email, firstName, lastName, "customer", -1, getCurrentDate());
                        dao.update(uUpdate);
                        session.setAttribute("account", uUpdate);
                        request.getRequestDispatcher("home").forward(request, response);
                    } else {
                        request.setAttribute("error", "Please check re-password again");
                        request.getRequestDispatcher("changeInfo").forward(request, response);
                    }
                } else if (request.getParameter("newPassword") == null && request.getParameter("reNewPassword") == null) {
                    User uUpdate = new User(username, password, phone, adress, email, firstName, lastName, "customer", -1, getCurrentDate());
                    dao.update(uUpdate);
                    session.setAttribute("account", uUpdate);
                    request.getRequestDispatcher("home").forward(request, response);
                } else {
                    request.setAttribute("error", "Please check re-password again");
                    request.getRequestDispatcher("changeInfo").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Please check re-password again");
                request.getRequestDispatcher("changeInfo").forward(request, response);
            }
            
        } catch (ServletException | IOException e) {
            response.getWriter().println(e);
        }
    }
    
    public static Date getCurrentDate() {
        LocalDate curDate = java.time.LocalDate.now();
        return Date.valueOf(curDate.toString());
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
