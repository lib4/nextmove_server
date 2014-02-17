/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.BigitemsDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anasabubacker
 */
@Local
public interface BigitemsDbFacadeLocal {

    void create(BigitemsDb bigitemsDb);

    void edit(BigitemsDb bigitemsDb);

    void remove(BigitemsDb bigitemsDb);

    BigitemsDb find(Object id);

    List<BigitemsDb> findAll();

    List<BigitemsDb> findRange(int[] range);

    int count();

    public List getBigItems(String moveId);
    
}
