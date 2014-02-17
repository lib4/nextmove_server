/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeansEntityClass;

import EntityClass.UserDb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anasabubacker
 */
@Local
public interface UserDbFacadeLocal {

    void create(UserDb userDb);

    void edit(UserDb userDb);

    void remove(UserDb userDb);

    UserDb find(Object id);

    List<UserDb> findAll();

    List<UserDb> findRange(int[] range);

    int count();

    public boolean isEmailIdRegistered(String emailAddress);

    public UserDb getThisUser(String emailAddress, String password);
    
}
