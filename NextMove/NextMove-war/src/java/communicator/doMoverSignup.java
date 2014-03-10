/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;

import EntityClass.MoversDb;
import SessionBeansEntityClass.MoversDbFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aabuback
 */
public class doMoverSignup extends HttpServlet {
    @EJB
    private MoversDbFacadeLocal moversDbFacade;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            
            
            MoversDb moversDb   =   new MoversDb();
            moversDb.setMoverId(UUID.randomUUID().toString());
            moversDb.setMoversName("PackMove Corporation");
            moversDb.setMoverEmail("anaschaky@gmail.com");
            moversDb.setMoversLocality("India");
            moversDb.setMoversDescription("Leading movers with ISO certification");
            
            moversDbFacade.create(moversDb);
            
            moversDb   =   new MoversDb();
            moversDb.setMoverId(UUID.randomUUID().toString());
            moversDb.setMoversName("BrillianctMove LLC");
            moversDb.setMoverEmail("anaschaky@gmail.com");
            moversDb.setMoversLocality("USA");
            moversDb.setMoversDescription("Leading movers with ISO certification");
            
            moversDbFacade.create(moversDb);
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doMoverSignup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doMoverSignup at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
