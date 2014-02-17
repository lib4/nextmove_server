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
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.json.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.*;


/**
 *
 * @author anasabubacker
 */
public class doSignUp extends HttpServlet {
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
            out = response.getWriter();
            JSONObject  signUpRequestObject     =   new JSONObject( IOUtils.toString(request.getInputStream()));
            signUpRequestObject                 =   signUpRequestObject.getJSONObject(Constants.JSON_SIGNUP_KEY);
            
            System.out.println(signUpRequestObject.toString());
            
            /**
             * Check For all the keys are present or not.
             */
            JSONObject mJSONObjec   =  Constants.checkForAllKeys( signUpRequestObject,Constants.signUpRequestParams);
            System.out.println(mJSONObjec.toString());
           
            if(mJSONObjec.getString(Constants.JSON_STATUS).compareToIgnoreCase(Constants.JSON_FAILURE)==0){
                System.out.println("IF LOOP");
                out.println(mJSONObjec);
                out.close();
                return;
            }
            
           
    
                
          
            String emailAddress         =   signUpRequestObject.getString(Constants.JSON_EMAIL_ADDRESS);
            String password             =   signUpRequestObject.getString(Constants.JSON_PASSWORD);//"123456789";
            String address              =   signUpRequestObject.getString(Constants.JSON_ADDRESS);//"FlatNo: 104, SyNo:110, Celebrity Signature, Dodda Thogur,Electronic city pahse 1, Bangalore-560100,karnataka, India ";
            String phoneNumber          =   signUpRequestObject.getString(Constants.JSON_PHONE_NUMBER); //"917406667752";
            String name                 =   signUpRequestObject.getString(Constants.JSON_NAME); //"Anas Abubacker";
            
            
            if(userDbFacade.isEmailIdRegistered(emailAddress)){
                
                 outputObject.put(Constants.JSON_STATUS, Constants.JSON_FAILURE);
                 outputObject.put(Constants.JSON_MSG,Constants.JSON_EMAIL_ID_REGISERED_ALREADY);
                 out.println(outputObject);
                 out.close();
                 return;
                    
            }
            
            UserDb new_user             =   new UserDb();
           
            new_user.setUserId(UUID.randomUUID().toString());
            new_user.setEmailAddress(emailAddress);
            new_user.setAddress(address);
            new_user.setPhoneNumber(phoneNumber);
            new_user.setPassword(password);
            new_user.setName(name);
            
            new_user.setIsEmailVerified(false);
            new_user.setIsPhoneVerified(false);
            userDbFacade.create(new_user);
            
           
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_SUCCESS);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                out.print(outputObject.toString());
            
            
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
