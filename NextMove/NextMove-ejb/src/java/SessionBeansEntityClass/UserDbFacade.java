/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.UserDb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author anasabubacker
 */
@Stateless
public class UserDbFacade extends AbstractFacade<UserDb> implements UserDbFacadeLocal {
    @PersistenceContext(unitName = "NextMove-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDbFacade() {
        super(UserDb.class);
    }
    
    @Override
    public boolean isEmailIdRegistered(String emailAddress){
      
      try{  
      Query query   =     em.createNativeQuery("SELECT * FROM user_db  WHERE emailAddress='"+emailAddress+"'",UserDb.class);
      UserDb mUserDb = (UserDb) query.getSingleResult();
      if(mUserDb==null){
          return false;
      }else
          return true;
      }catch(Exception e){
          return false;
      }
        
    }
    
    
    
    @Override
    public UserDb getThisUser(String emailAddress,String password){
       
     try{
      Query query   =     em.createNativeQuery("SELECT * FROM user_db  WHERE emailAddress='"+emailAddress+"' AND password = '"+password+"'",UserDb.class);
      UserDb mUserDb = (UserDb) query.getSingleResult();
      return  mUserDb;
      }catch(Exception e){
            return null;
     }
        
    }
    
    
    @Override
    public UserDb getThisUserByUserId(String userId){
        
     try{
       Query query   =     em.createNativeQuery("SELECT * FROM user_db  WHERE userId='"+userId+"'",UserDb.class);
      UserDb mUserDb = (UserDb) query.getSingleResult();
      return  mUserDb;
     }catch(Exception e){
         return null;
     }
        
    }
}
