package controller;

import business.Beer;
import business.Cart;
import business.LineItem;
import business.Order;
import data.BeerDB;
import data.OrderDB;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CartServlet", urlPatterns = {"/cartServlet"})
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }
        if (action.equals("cart") || action.equals("update")) {
            doAddToCart(request, response);
        } else if (action.equals("shop")) {
            doShop(request, response);
        } else if (action.equals("confirm")) {
            doConfirm(request, response);
        }
    }

    private void doAddToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        String beerName = request.getParameter("beerName");
        String quantityString = request.getParameter("quantity");

        Beer b = BeerDB.getBeer(beerName);
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            quantity = 1;
        }

        LineItem item = new LineItem(b, quantity);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }
        if (quantity == 0) {
            cart.removeItem(item);
        } else if (action == null) {
            cart.addQuantity(item);
        } else {
            cart.addItem(item);
        }

        session.setAttribute("cart", cart);
        String url = "/Cart.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doConfirm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/thanks.jsp";
        LocalDate dateOrder = LocalDate.now();
        String custName = request.getParameter("name");
        String custAddress = request.getParameter("address");
        String custPhone = request.getParameter("phone");
        String custMail = request.getParameter("email");
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Order order = new Order(dateOrder, custName, custMail, custPhone, custAddress, cart);
        String message = "";
        if(OrderDB.confirmOrder(order)){
            message = "Thank you for order. Your order is processing";
        } else {
            message = "Order fail";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doShop(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        List<Beer> beers = BeerDB.getBeerHeineken();

        request.setAttribute("beers", beers);
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
