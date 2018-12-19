
package controller;

import business.Beer;
import business.Compare;
import business.LineItem;
import data.BeerDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "compareServlet", urlPatterns = {"/compareServlet"})
public class CompareServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "compare";
        }
        if (action.equals("compare") || action.equals("update")) {
            doAddCompare(request, response);
        } else if (action.equals("shop")) {
            doShop(request, response);
        }
    }

    private void doAddCompare(HttpServletRequest request, HttpServletResponse response)
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
        Compare compare = (Compare) session.getAttribute("compare");

        if (compare == null) {
            compare = new Compare();
        }
         if (action == null) {
            compare.addQuantity(item);
        } else {
            compare.addItem(item);
        }

        session.setAttribute("compare", compare);
        String url = "/compare.jsp";
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
