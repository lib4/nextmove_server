/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;

import EntityClass.UserDb;
import SessionBeansEntityClass.UserDbFacadeLocal;
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
import com.google.gson.*;

/**
 *
 * @author anasabubacker
 */
public class doSignIn extends HttpServlet {
    @EJB
    private UserDbFacadeLocal userDbFacade;

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
        PrintWriter out = null;
        JSONObject outputObject     =   new JSONObject();
        try{
            /* TODO output your page here. You may use following sample code. */
            
            
            out = response.getWriter();
            JSONObject  signInRequestObject     =   new JSONObject( IOUtils.toString(request.getInputStream()));
            signInRequestObject                 =   signInRequestObject.getJSONObject(Constants.JSON_SIGNIN_KEY);
               
            
           System.out.println(signInRequestObject.toString());
            
            /**
             * Check For all the keys are present or not.
             */
            JSONObject mJSONObjec   =  Constants.checkForAllKeys( signInRequestObject,Constants.signInRequestParams);
            System.out.println(mJSONObjec.toString());
             
            
            
            if(mJSONObjec.getString(Constants.JSON_STATUS).compareToIgnoreCase(Constants.JSON_FAILURE)==0){
                System.out.println("IF LOOP");
                out.println(mJSONObjec);
                out.close();
                return;
            }
            
            
            String emailAddress         =   signInRequestObject.getString(Constants.JSON_EMAIL_ADDRESS);
            String password             =   signInRequestObject.getString(Constants.JSON_PASSWORD);//"123456789";
            
            
            
            UserDb mUserDb  =   userDbFacade.getThisUser(emailAddress, password);
            
            if(mUserDb==null){
                
                
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_FAILURE);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_USER_NOT_REGISTERED);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                
                out.println(outputObject.toString());
                
            }else{
                
                Gson gson = new Gson();
                //String json = gson.toJson(mUserDb);
                
                
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_PROFILE, new JSONObject(gson.toJson(mUserDb)));
                    
                    out.println(outputObject);
                    out.close();
                    return;
                    
                    
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
               
                
                
                
                
                
            }
            
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
        //processRequest(request, response);
         response.getWriter().println(Constants.getRequestNotSupported());
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
