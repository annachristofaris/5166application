import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author annachristofaris
 */
public class CatalogController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String url = "/categories.jsp";
        String value = request.getParameter("value");
        // Initialize the database and get all items
        ItemDB database = ItemDB.getDatabase();
        
        if (action == null || action.equals("")) {
            ArrayList<Item> popularItems = database.getItemsByCategory("popular");
            request.setAttribute("popularItems", popularItems);
            
            ArrayList<Item> tipItems = database.getItemsByCategory("tips");
            request.setAttribute("tipItems", tipItems);
            
            getServletContext().getRequestDispatcher(url).forward(request, response);

        }
        else if (action.equals("details")) {
            url = "/item.jsp";
            // New java bean
            Item detailItem = database.getItem(value);
            request.setAttribute("detailItem", detailItem);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equals("rating")) {
            url = "/item.jsp";
            String rating = request.getParameter("newRating");
            Item detailItem = database.getItem(value);
            detailItem.setRating(rating);
            request.setAttribute("detailItem", detailItem);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
                
    
        
        // Name that will be used in categories jsp to access the above data is "item"
//        request.setAttribute("item", item1);
        
//        ItemDB database = ItemDB.getDatabase();
//        ArrayList<Item> allItems = database.getItems();
//       request.setAttribute("model", allItems);
       
        
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
