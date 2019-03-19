/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author annachristofaris
 */
public class ProfileController extends HttpServlet {

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
        String action = request.getParameter("action");
        String url = "/myItems.jsp";
        HttpSession session = request.getSession(false);

        //load user and item database
        UserDB userDatabase = UserDB.getUserDatabase();
        ItemDB itemDatabase = ItemDB.getDatabase();

        User currentUser = (User) session.getAttribute("theUser");
        UserProfile currentProfile = (UserProfile) session.getAttribute("userCP");

        if (currentUser == null) {
            //for new users, assign them to the default/first user in database
            currentUser = userDatabase.users.get(0);
            //create profile from this User
            currentProfile = new UserProfile(currentUser);
            session = request.getSession(true);
            //assign session attributes
            session.setAttribute("theUser", currentUser);
            session.setAttribute("userCP", currentProfile);
        }

        if (action.equals("signout")) {
            session.removeAttribute("theUser");
            session.removeAttribute("userCP");
            request.getSession(false).invalidate();
            response.sendRedirect("./index.jsp");
        }

        if (currentProfile != null && !action.equals("signout")) {
            if (action.equals("save")) {
                url = "/myItems.jsp";
                String savedItemCode = request.getParameter("itemCode");
                Item newSavedItem = itemDatabase.getItem(savedItemCode);
                currentProfile.addItem(newSavedItem, "0", Boolean.FALSE);
            }
            if (action.equals("feedback")) {
                url = "/feedback.jsp";
                // New java bean
                String savedItemCode = request.getParameter("itemCode");
                Item detailItem = itemDatabase.getItem(savedItemCode);
                request.setAttribute("detailItem", detailItem);
                String rating = request.getParameter("newRating");
                detailItem.setRating(rating);
                //if item is in user's list, update their profile's rating
                if (currentProfile.isInList(detailItem)) {
                    currentProfile.updateItem(detailItem, rating, true);
                }
            }
            if (action.equals("delete")) {
                url = "/myItems.jsp";
                String removeItem = request.getParameter("itemCode");
                Item deletedItem = itemDatabase.getItem(removeItem);
                currentProfile.removeItem(deletedItem);
            }

            getServletContext().getRequestDispatcher(url).forward(request, response);
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

//** test code
//                User currentUser1 = new User();
//                currentUser1 = userDatabase.users.get(0);
//                System.out.println("Username =" + currentUser1.getFirstName());
//              try (PrintWriter out = response.getWriter()) {
//                  out.print("Username =" + currentUser1.getFirstName());
//                  out.println(session.getId());
//              }
//          //test code**
        //check session for current user using "theUser" attribute 
//processRequest(request, response);
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
