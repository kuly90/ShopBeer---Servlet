package controller;

import business.Order;
import data.OrderDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrderManagementServlet", urlPatterns = {"/orderManagementServlet"})
public class OrderManagementServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "/Manager/OrderManagement.jsp";
        if (action == null) {
            action = "list";
        }else if (action.equals("active")) {
            doShip(request, response);
        } else if (action.equals("delete")){
            doDelete(request, response);
        } else if (action.equals("search")){
            doSearch(request, response);
        }
        List<Order> orders = OrderDB.orderManagement();
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    protected void doShip(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String orderIDString = request.getParameter("orderID");
        int orderID = Integer.parseInt(orderIDString);

        String url = "/Manager/OrderManagement.jsp";

        if (OrderDB.updateStatus(orderID)) {
            List<Order> orders = OrderDB.orderManagement();
            request.setAttribute("orders", orders);

        } else {
            url = "/../thanks.jsp";
            String message = "can't active";
            request.setAttribute("message", message);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    public void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Manager/OrderManagement.jsp";
        String textSearch = request.getParameter("textsearch");
        List<Order> orders = OrderDB.search(textSearch);
        request.setAttribute("orders", orders);
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
