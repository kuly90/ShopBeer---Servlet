package controller;

import business.Beer;
import data.ManagerDB;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ManagerServlet", urlPatterns = {"/managerServlet"})
public class ManagerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";

        } else if (action.equals("edit")) {
            doEdit(request, response);
        } else if (action.equals("update")) {
            doUpdate(request, response);
        } else if (action.equals("delete")) {
            doDelete(request, response);
        } else if (action.equals("add")) {
            doAdd(request, response);
        } else if (action.equals("search")) {
            doSearch(request, response);
        }

        String url = "/Manager/beerList.jsp";
        List<Beer> beers = ManagerDB.getBeers();

        request.setAttribute("beers", beers);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerID = request.getParameter("beerID");
        String beerName = request.getParameter("beerName");
        String detail = request.getParameter("detail");

        String quantityInStoreString = request.getParameter("quantityInStore");
        int quantityInStore = Integer.parseInt(quantityInStoreString);

        String priceString = request.getParameter("price");
        double price = Double.parseDouble(priceString);

        String brandID = request.getParameter("brandID");
        String image = request.getParameter("image");

        String dateJoinString = request.getParameter("dateJoin");
        LocalDate dateJoin = LocalDate.parse(dateJoinString);

        String information = request.getParameter("information");

        Beer b = new Beer(beerID, beerName, price, image, quantityInStore, brandID, dateJoin, detail, information);
        String url = "/Manager/beerList.jsp";

        if (ManagerDB.insertBeer(b)) {
            List<Beer> beers = ManagerDB.getBeers();
            request.setAttribute("beers", beers);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    protected void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerName = request.getParameter("beerName");
        String url = "/Manager/editBeer.jsp";
        Beer b = ManagerDB.getBeer(beerName);

        if (b != null) {
            request.setAttribute("beer", b);

        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerID = request.getParameter("beerID");
        String beerName = request.getParameter("beerName");
        String detail = request.getParameter("detail");

        String quantityInStoreString = request.getParameter("quantityInStore");
        int quantityInStore = Integer.parseInt(quantityInStoreString);

        String priceString = request.getParameter("price");
        double price = Double.parseDouble(priceString);

        String brandID = request.getParameter("brandID");
        String image = request.getParameter("image");

        String dateJoinString = request.getParameter("dateJoin");
        LocalDate dateJoin = LocalDate.parse(dateJoinString);

        Beer b = new Beer(beerID, beerName, price, image, quantityInStore, brandID, dateJoin, detail);
        String url = "/Manager/beerList.jsp";

        if (ManagerDB.updateBeer(b)) {
            List<Beer> beers = ManagerDB.getBeers();
            request.setAttribute("beers", beers);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerName = request.getParameter("beerName");
        String url = "/Manager/beerList.jsp";

        if (ManagerDB.deleteBeer(beerName)) {
            List<Beer> beers = ManagerDB.getBeers();
            request.setAttribute("beers", beers);
        } else {
            url = "/errorPage.jsp";
            String errorMessage = "can't delete user";
            request.setAttribute("errorMessage", errorMessage);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Manager/beerList.jsp";
        String textSearch = request.getParameter("textsearch");
        List<Beer> beers = ManagerDB.search(textSearch);
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
