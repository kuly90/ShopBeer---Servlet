package controller;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MailUtilGmail;
@WebServlet(name = "EmailServlet", urlPatterns = {"/emailServlet"})
public class EmailServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       String emailTo = request.getParameter("emailTo");
       String subject = request.getParameter("subject");
       String emailFrom = "ductest12@gmail.com";
       String body= request.getParameter("body");
       
       String message = "";
       String url = "/thanks.jsp";
       
       try{
           MailUtilGmail.sendMail(emailTo, emailFrom, subject, body, true);
           message = "We have received an email from you. Thank you for feedback ";
       } catch(MessagingException e){
           System.out.println(e);
           message = "Send email fail";
       }
       
       request.setAttribute("message", message);
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
