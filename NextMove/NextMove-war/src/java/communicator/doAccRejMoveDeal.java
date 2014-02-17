/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;

import EntityClass.MovesDb;
import SessionBeansEntityClass.MovesDbFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aabuback
 */
public class doAccRejMoveDeal extends HttpServlet {
    @EJB
    private MovesDbFacadeLocal movesDbFacade;

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
        JSONObject outputObject     =   new JSONObject();
        try{
            /* TODO output your page here. You may use following sample code. */
            
            
            out = response.getWriter();
            JSONObject  doAcknowledgeRequestObject     =   new JSONObject( IOUtils.toString(request.getInputStream()));
            doAcknowledgeRequestObject                 =   doAcknowledgeRequestObject.getJSONObject(Constants.JSON_ACCREJMOVEDEAL_KEY);
               
            
           System.out.println(doAcknowledgeRequestObject.toString());
            
            /**
             * Check For all the keys are present or not.
             */
            JSONObject mJSONObjec   =  Constants.checkForAllKeys( doAcknowledgeRequestObject,Constants.accRejMoveDealRequestParams);
            System.out.println(mJSONObjec.toString());
             
            
            
            if(mJSONObjec.getString(Constants.JSON_STATUS).compareToIgnoreCase(Constants.JSON_FAILURE)==0){
                System.out.println("IF LOOP");
                out.println(mJSONObjec);
                out.close();
                return;
            }
            
            
            String moveId         =   doAcknowledgeRequestObject.getString(Constants.JSON_MOVE_ID);
            String rejestReason   =   doAcknowledgeRequestObject.getString(Constants.JSON_REASON);
            String status         =   doAcknowledgeRequestObject.getString(Constants.JSON_MOVE_STATUS);
            
            
           MovesDb movesDb        =   movesDbFacade.getMove(moveId);
     
           if(movesDb!=null){
            movesDb.setMoveStatus(status);
            movesDb.setRejectReason(rejestReason);
            movesDbFacade.edit(movesDb);
           }
            
           outputObject     =   new JSONObject();
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
                    if(status.compareToIgnoreCase(Constants.MOVE_STATUS_ACCEPTED)==0){
                         outputObject.put(Constants.JSON_MSG,Constants.JSON_ACCEPTED);
                    }else{
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_REJECTED);
                }
                    
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                out.println(outputObject.toString());
          
            
            
        }catch(JSONException ex){
            
            outputObject     =   new JSONObject();
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_FAILURE);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_EXCEPTION);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                out.println(outputObject.toString());
                Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
