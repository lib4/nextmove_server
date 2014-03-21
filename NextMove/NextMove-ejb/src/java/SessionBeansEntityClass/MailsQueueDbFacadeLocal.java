/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeansEntityClass;

import EntityClass.MailsQueueDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabuback
 */
@Local
public interface MailsQueueDbFacadeLocal {

    void create(MailsQueueDb mailsQueueDb);

    void edit(MailsQueueDb mailsQueueDb);

    void remove(MailsQueueDb mailsQueueDb);

    MailsQueueDb find(Object id);

    List<MailsQueueDb> findAll();

    List<MailsQueueDb> findRange(int[] range);

    int count();
    
}
