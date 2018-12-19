package controller;

import business.Promotion;
import data.PromotionDB;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PromotionServlet", urlPatterns = {"/promotionServlet"})
public class PromotionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "/Manager/promotionList.jsp";

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
        List<Promotion> promotions = PromotionDB.getPromotions();
        request.setAttribute("promotions", promotions);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerID = request.getParameter("beerID");
        String promotionID = request.getParameter("promotionID");

        String discountString = request.getParameter("discount");
        double discount = Double.parseDouble(discountString);

        String dateStartString = request.getParameter("dateStart");
        LocalDate dateStart = LocalDate.parse(dateStartString);

        String dateEndString = request.getParameter("dateEnd");
        LocalDate dateEnd = LocalDate.parse(dateEndString);

        Promotion p = new Promotion(beerID, promotionID, discount, dateStart, dateEnd);
        String url = "/Manager/promotionList.jsp";

        if (PromotionDB.insertPromotion(p)) {
            List<Promotion> promotions = PromotionDB.getPromotions();
            request.setAttribute("promotions", promotions);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    protected void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerID = request.getParameter("beerID");
        String url = "/Manager/editPromotion.jsp";
        Promotion p = PromotionDB.getPromotion(beerID);

        if (p != null) {
            request.setAttribute("promotion", p);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerID = request.getParameter("beerID");
        String discountString = request.getParameter("discount");
        double dicount = Double.parseDouble(discountString);
        String dateStartString = request.getParameter("dateStart");
        LocalDate dateStart = LocalDate.parse(dateStartString);
        String dateEndString = request.getParameter("dateEnd");
        LocalDate dateEnd = LocalDate.parse(dateEndString);
        Promotion p = new Promotion(beerID, dicount, dateStart, dateEnd);
        String url = "/Manager/promotionList.jsp";
        if (PromotionDB.updatePromotion(p)) {
            List<Promotion> promotions = PromotionDB.getPromotions();
            request.setAttribute("promotions", promotions);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String beerID = request.getParameter("beerID");
        String url = "/Manager/promotionList.jsp";

        if (PromotionDB.deletePromotion(beerID)) {
            List<Promotion> promotions = PromotionDB.getPromotions();
            request.setAttribute("promotions", promotions);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Manager/promotionList.jsp";
        String textSearch = request.getParameter("textsearch");
        List<Promotion> promotions = PromotionDB.search(textSearch);
        request.setAttribute("promotions", promotions);
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
