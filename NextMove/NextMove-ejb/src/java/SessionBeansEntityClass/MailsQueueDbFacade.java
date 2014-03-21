/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeansEntityClass;

import EntityClass.MailsQueueDb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aabuback
 */
@Stateless
public class MailsQueueDbFacade extends AbstractFacade<MailsQueueDb> implements MailsQueueDbFacadeLocal {
    @PersistenceContext(unitName = "NextMove-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MailsQueueDbFacade() {
        super(MailsQueueDb.class);
    }
    
}
