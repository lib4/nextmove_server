/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;

import EntityClass.BigitemsDb;
import EntityClass.MovesDb;
import SessionBeansEntityClass.BigitemsDbFacadeLocal;
import SessionBeansEntityClass.MovesDbFacadeLocal;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author aabuback
 */
public class getMyMoves extends HttpServlet {
    @EJB
    private BigitemsDbFacadeLocal bigitemsDbFacade;
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
        PrintWriter out = null;
        JSONObject outputObject     =   new JSONObject();
        try{
            /* TODO output your page here. You may use following sample code. */
            
            
            out = response.getWriter();
            JSONObject  getMyMoveRequestObject     =   new JSONObject( IOUtils.toString(request.getInputStream()));
            getMyMoveRequestObject                 =   getMyMoveRequestObject.getJSONObject(Constants.JSON_GETMYMOVE_KEY);
               
            
           System.out.println(getMyMoveRequestObject.toString());
            
            /**
             * Check For all the keys are present or not.
             */
            JSONObject mJSONObjec   =  Constants.checkForAllKeys( getMyMoveRequestObject,Constants.getMyMoveRequestParams);
            System.out.println(mJSONObjec.toString());
             
            
            
            if(mJSONObjec.getString(Constants.JSON_STATUS).compareToIgnoreCase(Constants.JSON_FAILURE)==0){
                System.out.println("IF LOOP");
                out.println(mJSONObjec);
                out.close();
                return;
            }
            
            
            
            String userId                 =   getMyMoveRequestObject.getString(Constants.JSON_USER_ID);
            String moveStatus             =   getMyMoveRequestObject.getString(Constants.JSON_MOVE_STATUS);//"123456789";
           
            if(moveStatus.compareToIgnoreCase("ALL")==0){
                moveStatus=null;
            }
            List<MovesDb> movesDbs  =   movesDbFacade.getMyMoves(userId, moveStatus);
            if(movesDbs==null||movesDbs.size()==0){
                
                
                outputObject     =   new JSONObject();
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_FAILURE);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_NO_MOVES);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                     System.out.println("no Moves RESPONSE "+outputObject);
                out.println(outputObject.toString());
                return;
                
            }
            
            
            
            Iterator mIterator  =   movesDbs.iterator();
            
            JSONArray moves  =   new JSONArray();
            Gson gson = new Gson();
            while(mIterator.hasNext()){
                MovesDb movesDb =   (MovesDb) mIterator.next();
                 JSONObject mJSONObject =   new JSONObject(gson.toJson(movesDb).toString());
                
                if(movesDb.getIsBigItemsPresent()){
                    
                    List<BigitemsDb> mBigitemsDbs   =   bigitemsDbFacade.getBigItems(movesDb.getMoveId());
                    
                    mJSONObject.put("bigItems",mBigitemsDbs);
                    
                }
                
                
                moves.put(mJSONObject);
                
                
            }
            
            
            outputObject     =   new JSONObject();
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_RESPONSE,moves);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                System.out.println("Moves RESPONSE "+outputObject);
                out.println(outputObject);
            
            
            
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
