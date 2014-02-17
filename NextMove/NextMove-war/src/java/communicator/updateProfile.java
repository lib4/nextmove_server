/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;

import EntityClass.UserDb;
import SessionBeansEntityClass.UserDbFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
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
public class updateProfile extends HttpServlet {
    @EJB
    private UserDbFacadeLocal userDbFacade;

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
            out = response.getWriter();
            JSONObject  updateProfileRequestObject     =   new JSONObject( IOUtils.toString(request.getInputStream()));
            updateProfileRequestObject                 =   updateProfileRequestObject.getJSONObject(Constants.JSON_UPDATEPROFILE_KEY);
            
            System.out.println(updateProfileRequestObject.toString());
            
            /**
             * Check For all the keys are present or not.
             */
            JSONObject mJSONObjec   =  Constants.checkForAllKeys( updateProfileRequestObject,Constants.updateProfileRequestParams);
            System.out.println(mJSONObjec.toString());
           
            if(mJSONObjec.getString(Constants.JSON_STATUS).compareToIgnoreCase(Constants.JSON_FAILURE)==0){
                System.out.println("IF LOOP");
                out.println(mJSONObjec);
                out.close();
                return;
            }
            
           
    
                
            
          
          
          
            String userId               =   updateProfileRequestObject.getString(Constants.JSON_USER_ID);
            String address              =   updateProfileRequestObject.getString(Constants.JSON_ADDRESS);//"FlatNo: 104, SyNo:110, Celebrity Signature, Dodda Thogur,Electronic city pahse 1, Bangalore-560100,karnataka, India ";
            String phoneNumber          =   updateProfileRequestObject.getString(Constants.JSON_PHONE_NUMBER); //"917406667752";
            String name                 =   updateProfileRequestObject.getString(Constants.JSON_NAME); //"Anas Abubacker";
            
            
 
            
            UserDb user             =   userDbFacade.getThisUserByUserId(userId);
            
           
          
          
            user.setAddress(address);
            user.setPhoneNumber(phoneNumber);
            user.setName(name);
          
            userDbFacade.edit(user);
            
           
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_PROFILE_UPDATED);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                out.println(outputObject.toString());
            
            
        }catch (JSONException ex) {
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
