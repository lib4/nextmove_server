/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeansEntityClass;

import EntityClass.MoversDb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aabuback
 */
@Stateless
public class MoversDbFacade extends AbstractFacade<MoversDb> implements MoversDbFacadeLocal {
    @PersistenceContext(unitName = "NextMove-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MoversDbFacade() {
        super(MoversDb.class);
    }
    
}
