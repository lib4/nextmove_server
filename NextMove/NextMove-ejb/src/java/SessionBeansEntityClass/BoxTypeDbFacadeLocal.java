/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.BoxTypeDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anasabubacker
 */
@Local
public interface BoxTypeDbFacadeLocal {

    void create(BoxTypeDb boxTypeDb);

    void edit(BoxTypeDb boxTypeDb);

    void remove(BoxTypeDb boxTypeDb);

    BoxTypeDb find(Object id);

    List<BoxTypeDb> findAll();

    List<BoxTypeDb> findRange(int[] range);

    int count();
    
}
