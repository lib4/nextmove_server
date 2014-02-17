/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/**
 *
 * @author anasabubacker
 */
public class Constants {
    
    
    
    public static final String MOVE_IMAGE_FOLDER     =   "/Applications/NetBeans/glassfish-4.0/glassfish/domains/domain1/docroot/move_image";
    public static final String IMAGE_URL             =    "http://localhost:8080/move_image/";
    
            
    
    
    
    
    
    public static final String JSON_SIGNIN_KEY  =   "signInRequest";
    
    
    
    public static final String JSON_SIGNUP_KEY      =   "signUpRequest";
    public static final String JSON_EMAIL_ADDRESS   =   "emailAddress";
    public static final String JSON_PASSWORD        =   "password";
    public static final String JSON_ADDRESS         =   "address";
    public static final String JSON_PHONE_NUMBER    =   "phoneNumber";
    public static final String JSON_NAME            =   "name";
    
    
   public static final String JSON_STATUS           =   "status";
   public static final String JSON_SUCCESS          =   "success";
   public static final String JSON_FAILURE          =   "failure";
   public static final String JSON_MSG              =   "message";
   
   
   
  public static final String JSON_EXCEPTION         =   "Json request is not well formed. Please check the api document for details.";
  public static final String JSON_KEY_MISSING       =   " key is required. which is missing!";
  public static final String JSON_GET_NOT_SUPPORTED       =  " HTTP GET request is not supported.";
  public static final String JSON_EMAIL_ID_REGISERED_ALREADY       =  "Email address is already taken. Please choose another one! ";
  public static final String JSON_PROFILE       =  "Profile";
  public static final String JSON_REQUEST       =  "request";
  public static final String JSON_USER_NOT_REGISTERED       =  "Email password combination does not match. Please try again.";
  
  
  
  public static final String JSON_MOVE_KEY      =   "moveRequest";
  public static final String JSON_SMALL_BOX_COUNT   =   "smallBoxCount";
  public static final String JSON_MEDIUM_BOX_COUNT   =   "mediumBoxCount";
  public static final String JSON_LARGE_BOX_COUNT   =   "largeBoxCount";
  public static final String JSON_SOURCE_ADDRESS   =   "sourceAddress";
  public static final String JSON_DESTINATION_ADDRESS   =   "destinationAddress";
  public static final String JSON_DISPATCH_DATE     =   "dispatchDate";
  public static final String JSON_EXPECTED_RECEIVED_DATE     =   "expectedReceivedDate";
 
  
  
  public static final String JSON_BIG_ITEM      =   "bigItems";
  public static final String JSON_REQUIRES_DISAASSEMBLY     =   "disassembly";
  public static final String JSON_DOES_FIT_IN_ELEVATOR     =   "fitInElevator";
  public static final String JSON_ITEM_NAME     =   "itemName";
  public static final String JSON_ITEM_DESCRIPTION   =   "itemDescription";
  public static final String JSON_IMAGE            =   "image";
  
  
  
 
 public static final String JSON_USER_ID            =   "userId";
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
  public static final HashMap<String,String> signUpRequestParams    =   new HashMap<String, String>(){{
      //put(Constants.JSON_SIGNUP_KEY,"");
      put(Constants.JSON_EMAIL_ADDRESS,"");
      put(Constants.JSON_PASSWORD,"");
      put(Constants.JSON_ADDRESS,"");
      put(Constants.JSON_PHONE_NUMBER,"");
      put(Constants.JSON_NAME,"");
  }};
  
  
  
  public static final HashMap<String,String> signInRequestParams    =   new HashMap<String, String>(){{
   
      put(Constants.JSON_EMAIL_ADDRESS,"");
      put(Constants.JSON_PASSWORD,"");
      
  }};
  
   
 public static final HashMap<String,String> moveRequestParams    =   new HashMap<String, String>(){{
   
      put(Constants.JSON_USER_ID,"");
      put(Constants.JSON_SMALL_BOX_COUNT,"");
      put(Constants.JSON_MEDIUM_BOX_COUNT,"");
      put(Constants.JSON_LARGE_BOX_COUNT,"");
      put(Constants.JSON_SOURCE_ADDRESS,"");
      put(Constants.JSON_DESTINATION_ADDRESS,"");
      put(Constants.JSON_DISPATCH_DATE,"");
      put(Constants.JSON_EXPECTED_RECEIVED_DATE,"");
      put(Constants.JSON_BIG_ITEM,"");
  }};

 
 
  public static final HashMap<String,String> bigItemRequestParams    =   new HashMap<String, String>(){{
   
      put(Constants.JSON_REQUIRES_DISAASSEMBLY,"");
      put(Constants.JSON_DOES_FIT_IN_ELEVATOR,"");
      put(Constants.JSON_ITEM_NAME,"");
      put(Constants.JSON_ITEM_DESCRIPTION,"");
      put(Constants.JSON_IMAGE,"");
     
  }};

 
 
 
  
  
  
  public static JSONObject checkForAllKeys(JSONObject mJSONObject,HashMap<String,String> map){
      
      JSONObject mResponseObject    =   new JSONObject();
      Iterator mIterator =  map.keySet().iterator();//signUpRequestParams.keySet().iterator();
      String key = null;
      boolean keyMissing    =   false;
      while(mIterator.hasNext()){
          key    =   (String) mIterator.next();
        
             if(!mJSONObject.has(key)){
                 keyMissing =   true;
                 
                 
                  
             }else{
                 
             }
              
          
      }
    
      try{
      if(keyMissing){
          mResponseObject.put(Constants.JSON_STATUS, Constants.JSON_FAILURE);
          mResponseObject.put(Constants.JSON_MSG, key + JSON_KEY_MISSING);
          
      }else{
           mResponseObject.put(Constants.JSON_STATUS, Constants.JSON_SUCCESS);
         
      }
      }catch(Exception e){
          e.printStackTrace();
      }
      
    return mResponseObject;
  }
  
  
  public static JSONObject getRequestNotSupported(){
      
      JSONObject mJSONObjec = new JSONObject();
      
      try{
      mJSONObjec.put(Constants.JSON_STATUS, Constants.JSON_FAILURE);
      mJSONObjec.put(Constants.JSON_MSG, Constants.JSON_GET_NOT_SUPPORTED);
      
      }catch(Exception e){
          
      }
    
     return mJSONObjec;
  }
         
}
