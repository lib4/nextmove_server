/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;

import EntityClass.BigitemsDb;
import EntityClass.MovesDb;
import SessionBeansEntityClass.BigitemsDbFacadeLocal;
import SessionBeansEntityClass.MovesDbFacadeLocal;
import com.google.common.collect.HashBiMap;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.Folder;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author anasabubacker
 */
public class doMove extends HttpServlet {
    @EJB
    private BigitemsDbFacadeLocal bigitemsDbFacade;
    @EJB
    private MovesDbFacadeLocal movesDbFacade;

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
        try  {
 
            HashMap<String,String> bigItemIds   =   new HashMap<>();
            Iterator mIterator  =   bigItemIds.keySet().iterator();
            out = response.getWriter();
            // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
             // Parse the request
             List<FileItem> items = upload.parseRequest(request);
                
             final String moveId               =   UUID.randomUUID().toString();
             final MovesDb movesDb             =   new MovesDb();
             // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (item.isFormField()) {
                    
                    System.out.println("Form field" +item.getString());
                    
                   bigItemIds   =   processFormField(new JSONObject( item.getString()), out,moveId,movesDb);
                   mIterator  =   bigItemIds.keySet().iterator();
                   System.out.println("ITEM ID SIZE "+bigItemIds.size());
                 
                } else {
                    //processUploadedFile(item);
                    System.out.print("Photo Field");
                    String key  =   (String) mIterator.next();
                    File mFile  =   new File(bigItemIds.get(key));
                    item.write(mFile);
                    
                  
                    
                    
                }
            }
                new Thread(){
                    
                    public void run(){
                        pushMovetoMailQueue moveToMailQueue=    new pushMovetoMailQueue();
                        moveToMailQueue.pushMoveToMailQueue(movesDb);
                    }
                }.start();
                outputObject     =   new JSONObject();
                try {
                    outputObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
                    outputObject.put(Constants.JSON_MSG,Constants.JSON_GET_QUOTE);
                } catch (JSONException ex1) {
                    Logger.getLogger(doSignUp.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
                out.println(outputObject.toString());
               
            
            
            
        }catch(Exception ex){
            
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
        
    
    
    private HashMap<String,String> processFormField(JSONObject  moveRequestObject, PrintWriter out,String moveId,MovesDb movesDb){
            
       HashMap<String,String> bigItemIds =   new HashMap<>();
        try{
             moveRequestObject                 =   moveRequestObject.getJSONObject(Constants.JSON_MOVE_KEY);
               
            
           System.out.println(moveRequestObject.toString());
            
            /**
             * Check For all the keys are present or not.
             */
            JSONObject mJSONObjec   =  Constants.checkForAllKeys( moveRequestObject,Constants.moveRequestParams);
            System.out.println(mJSONObjec.toString());
             
            
            
            if(mJSONObjec.getString(Constants.JSON_STATUS).compareToIgnoreCase(Constants.JSON_FAILURE)==0){
                System.out.println("IF LOOP");
                out.println(mJSONObjec);
                out.close();
                return null;
            }
            
            
            
     
            String userId                =   moveRequestObject.getString(Constants.JSON_USER_ID);
            int smallBoxCount            =   moveRequestObject.getInt(Constants.JSON_SMALL_BOX_COUNT);
            int mediumBoxCount           =   moveRequestObject.getInt(Constants.JSON_MEDIUM_BOX_COUNT);
            int largeBoxCount            =   moveRequestObject.getInt(Constants.JSON_LARGE_BOX_COUNT);
            String sourceAddress         =   moveRequestObject.getString(Constants.JSON_SOURCE_ADDRESS);
            String destinationAddress    =   moveRequestObject.getString(Constants.JSON_DESTINATION_ADDRESS);
            String dispatchDate          =   moveRequestObject.getString(Constants.JSON_DISPATCH_DATE);
            String expectedReceivedDate  =   moveRequestObject.getString(Constants.JSON_EXPECTED_RECEIVED_DATE);
            JSONArray bigItems           =   moveRequestObject.getJSONArray(Constants.JSON_BIG_ITEM);
            int bigItemCount             =  bigItems.length();
            
           
            
        
            movesDb.setSourceAddress(sourceAddress);
            movesDb.setDestinationAddress(destinationAddress);
            movesDb.setDispatchDate(dispatchDate);
            movesDb.setExpectedReceiveDate(expectedReceivedDate);
            movesDb.setLargeBoxCount(largeBoxCount);
            movesDb.setSmallBoxCount(smallBoxCount);
            movesDb.setMediumBoxCount(mediumBoxCount);
            movesDb.setMoveId(moveId);
            movesDb.setUserId(userId);
            movesDb.setMoveStatus(Constants.MOVE_STATUS_PENDING_QUOTE);
             if(bigItemCount>0){
                   movesDb.setIsBigItemsPresent(true);
             }else{
                   movesDb.setIsBigItemsPresent(false);
             }
            
             int itemsWontFitInABox =   0;
             int itemsWontFitInElevator =   0;
             int itemsNeedDisassembly =   0;
            
            if(bigItemCount>0){
                
                File mFile  =   new File(Constants.MOVE_IMAGE_FOLDER+moveId);
                mFile.mkdir();
            }
            int i =0;
            while(i<bigItemCount){
                itemsWontFitInABox++;
                
                JSONObject mJSONObject  =   bigItems.getJSONObject(i);
                boolean requiresDisassembly     =   mJSONObject.getBoolean(Constants.JSON_REQUIRES_DISAASSEMBLY);
                if(requiresDisassembly)
                    itemsNeedDisassembly++;
                
                boolean fitInElevator     =   mJSONObject.getBoolean(Constants.JSON_DOES_FIT_IN_ELEVATOR);
                if(fitInElevator)
                    itemsWontFitInElevator++;
                
                String itemName     =   mJSONObject.getString(Constants.JSON_ITEM_NAME);
                String itemDescription  =   mJSONObject.getString(Constants.JSON_ITEM_DESCRIPTION);
              //  String baseg4           =   mJSONObject.getString(Constants.JSON_IMAGE);
                
                
              
                String bigItemId    =   UUID.randomUUID().toString();
                //IOUtils.write(Base64.decode(baseg4), new FileOutputStream(new File(Constants.MOVE_IMAGE_FOLDER+moveId+"\\"+bigItemId+".jpg")));
                
                bigItemIds.put(bigItemId, Constants.MOVE_IMAGE_FOLDER+moveId+"\\"+bigItemId+".jpg");
                
                
                
                BigitemsDb mBigitemsDb  =   new BigitemsDb();
                mBigitemsDb.setBigItemId(bigItemId);
                mBigitemsDb.setDoesFitInElevator(fitInElevator);
                mBigitemsDb.setRequiresDisassembly(requiresDisassembly);
                mBigitemsDb.setItemDescription(itemDescription);
                mBigitemsDb.setItemName(itemName);
                mBigitemsDb.setItemUrl(Constants.IMAGE_URL+"/"+moveId+"/"+bigItemId+".jpg");
                mBigitemsDb.setMoveId(moveId);
                
                
                bigitemsDbFacade.create(mBigitemsDb);
                i++;
                
            }
             movesDb.setItemsWontFitInBox(itemsWontFitInABox);
             movesDb.setItemsWontFitInElevator(itemsWontFitInElevator);
             movesDb.setItemsNeedDisassembly(itemsNeedDisassembly);
             movesDbFacade.create(movesDb);
        }catch(Exception e){
            e.printStackTrace();
        }
            return bigItemIds;    
                
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
