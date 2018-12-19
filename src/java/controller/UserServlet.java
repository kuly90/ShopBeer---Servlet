package controller;


import business.User;

import data.UserDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";

        } else if (action.equals("deactive")) {
            doDeActive(request, response);
        } else if (action.equals("active")) {
            doActive(request, response);
        } else if (action.equals("add")) {
            doAdd(request, response);
        }else if (action.equals("delete")) {
            doDelete(request, response);
        }
        String url = "/Admin/userList.jsp";
        List<User> users = UserDB.getUsers();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Admin/userList.jsp";
        String userName = request.getParameter("userName");
        String roleName = request.getParameter("roleName");
        String password = request.getParameter("password");
        
        User user = new User(userName, roleName, password,1);
        if (UserDB.add(user)) {
            List<User> users = UserDB.getUsers();
            request.setAttribute("users", users);
        } else {
            url = "/errorPage.jsp";
            String errorMessage = "Can't delete email";
            request.setAttribute("errorMessage", errorMessage);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

    protected void doActive(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        String url = "/Admin/userList.jsp";

        if (UserDB.updateUser2(userName)) {
            List<User> users = UserDB.getUsers();
            request.setAttribute("users", users);

        } else {
            url = "/errorPage.jsp";
            String errorMessage = "can't Update user";
            request.setAttribute("errorMessage", errorMessage);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doDeActive(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        String url = "/Admin/userList.jsp";

        if (UserDB.updateUser(userName)) {
            List<User> users = UserDB.getUsers();
            request.setAttribute("users", users);

        } else {
            url = "/errorPage.jsp";
            String errorMessage = "can't Update user";
            request.setAttribute("errorMessage", errorMessage);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String url = "/Admin/userList.jsp";

        if (UserDB.deleteUser(userName)) {
            List<User> users = UserDB.getUsers();
            request.setAttribute("users", users);
        } else {
            url = "/errorPage.jsp";
            String errorMessage = "can't delete user";
            request.setAttribute("errorMessage", errorMessage);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
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