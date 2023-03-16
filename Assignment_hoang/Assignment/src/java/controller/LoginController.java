/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import daoAdmin.UserAdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author GearVn
 */
public class LoginController extends HttpServlet {

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            HttpSession session = request.getSession(true);
            UserAdminDAO dao = new UserAdminDAO();
            UserDAO uDAO = new UserDAO();
            session.setAttribute("error", "");
            if (username != null && password != null) {
                ArrayList<User> list = dao.getAll();
                if (username.equals("admin") && password.equals("*TienViet3353")) {
                    User user =  dao.select(new User(username, password));
                    session.setAttribute("account", user);
                    request.getRequestDispatcher("/productAdmin").forward(request, response);
                    return;
                } else {
                    for (User x : list) {
                        if (username.equals(x.getUsername()) && password.equals(x.getPassword())) {
                            session.setAttribute("account", x);
//                            request.getRequestDispatcher("./index.html").forward(request, response);
                            response.sendRedirect("index");
                            return;

                        } else if (username.equals(x.getUsername()) && !password.equals(x.getPassword())) {
                            session.setAttribute("error", "Username or password is incorrect");
                            response.sendRedirect("./login.jsp");
                        }else {
                            continue;
                        }
                    }
                    session.setAttribute("error", "Username or password is incorrect");
                    response.sendRedirect("./login.jsp");
                }
            }
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
