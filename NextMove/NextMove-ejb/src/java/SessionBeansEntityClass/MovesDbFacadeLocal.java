/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.MovesDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anasabubacker
 */
@Local
public interface MovesDbFacadeLocal {

    void create(MovesDb movesDb);

    void edit(MovesDb movesDb);

    void remove(MovesDb movesDb);

    MovesDb find(Object id);

    List<MovesDb> findAll();

    List<MovesDb> findRange(int[] range);

    int count();
    
}
