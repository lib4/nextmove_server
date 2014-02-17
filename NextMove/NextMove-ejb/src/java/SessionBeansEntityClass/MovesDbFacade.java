/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.MovesDb;
import EntityClass.UserDb;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author anasabubacker
 */
@Stateless
public class MovesDbFacade extends AbstractFacade<MovesDb> implements MovesDbFacadeLocal {
    @PersistenceContext(unitName = "NextMove-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovesDbFacade() {
        super(MovesDb.class);
    }
    
    
    @Override
    public List getMyMoves(String userId,String moveStatus){
      Query query;
      try{
      if(moveStatus!=null){
          query   =     em.createNativeQuery("SELECT * FROM moves_db  WHERE moveStatus= '"+moveStatus+"' AND userId = '"+userId+"' order by moveSeqNum DESC",MovesDb.class);

      }else{
          System.out.println("ELSE ");
          query   =     em.createNativeQuery("SELECT * FROM moves_db  WHERE userId = '"+userId+"' order by moveSeqNum DESC ",MovesDb.class);
         
      } 
      
      
      
      return   query.getResultList();
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
        
    }
    
    
    @Override
    public List getMovesByFilter(String moveStatus,String sourceAddress,String destinationAddress){
      Query query;
      String searchStr = "";
      if(sourceAddress!=null&&sourceAddress.length()>0&&(destinationAddress==null||destinationAddress.length()==0)){
          
           searchStr  =   "  ( sourceAddress like '%"+sourceAddress+"%' )";
          
      }else if(destinationAddress!=null&&destinationAddress.length()>0&&(sourceAddress==null||sourceAddress.length()==0)){
           searchStr  =   "  ( destinationAddress like '%"+destinationAddress+"%' )";
      }else if(destinationAddress!=null&&destinationAddress.length()>0&&sourceAddress!=null&&sourceAddress.length()>0){
          searchStr  =   "  ( destinationAddress like '%"+destinationAddress+"%' OR sourceAddress like '%"+sourceAddress+"%' )";
      }
      
      if(searchStr.length()>0&&moveStatus!=null){
          searchStr+=" AND "+searchStr;
      }
      else   if(searchStr.length()==0&&moveStatus==null){
            
          
      }else if(searchStr.length()==0&&moveStatus!=null){
          
      }
          
      
      try{
      if(moveStatus!=null){
          query   =     em.createNativeQuery("SELECT * FROM moves_db  WHERE moveStatus= '"+moveStatus+"'"+searchStr+" order by moveSeqNum DESC ",MovesDb.class);

      }else {
          System.out.println("ELSE ");
          query   =     em.createNativeQuery("SELECT * FROM moves_db "+searchStr+" order by moveSeqNum DESC ",MovesDb.class);
         
      } 
      
      
      
      return   query.getResultList();
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
        
    }
    
    
    
    @Override
    public MovesDb getMove(String moveId){
      Query query;
      try{
     
          query   =     em.createNativeQuery("SELECT * FROM moves_db  WHERE moveId ='"+moveId+"' ",MovesDb.class);
          return  (MovesDb) query.getSingleResult();
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
        
    }
}
