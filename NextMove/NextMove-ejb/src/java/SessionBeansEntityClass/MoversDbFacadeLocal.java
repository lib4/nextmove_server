/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeansEntityClass;

import EntityClass.MoversDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aabuback
 */
@Local
public interface MoversDbFacadeLocal {

    void create(MoversDb moversDb);

    void edit(MoversDb moversDb);

    void remove(MoversDb moversDb);

    MoversDb find(Object id);

    List<MoversDb> findAll();

    List<MoversDb> findRange(int[] range);

    int count();
    
}
