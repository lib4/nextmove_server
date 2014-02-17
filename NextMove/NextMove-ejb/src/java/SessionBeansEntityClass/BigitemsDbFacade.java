/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.BigitemsDb;
import EntityClass.MovesDb;
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
public class BigitemsDbFacade extends AbstractFacade<BigitemsDb> implements BigitemsDbFacadeLocal {
    @PersistenceContext(unitName = "NextMove-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BigitemsDbFacade() {
        super(BigitemsDb.class);
    }
    
    @Override
    public List getBigItems(String moveId){
      Query query;
      try{
      
          query   =     em.createNativeQuery("SELECT * FROM bigitems_db  WHERE moveId='"+moveId+"' ",BigitemsDb.class);

        
      return   query.getResultList();
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
        
    }
    
}
