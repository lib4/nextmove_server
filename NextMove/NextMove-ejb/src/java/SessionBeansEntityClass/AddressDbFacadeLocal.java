/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.AddressDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anasabubacker
 */
@Local
public interface AddressDbFacadeLocal {

    void create(AddressDb addressDb);

    void edit(AddressDb addressDb);

    void remove(AddressDb addressDb);

    AddressDb find(Object id);

    List<AddressDb> findAll();

    List<AddressDb> findRange(int[] range);

    int count();
    
}
