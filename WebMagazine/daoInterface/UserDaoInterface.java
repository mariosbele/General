
package com.cbfteam.daoInterface;

import com.cbfteam.beans.User;
import java.util.List;


public interface UserDaoInterface {

    int delete(int id);

    User getUserById(int id);

    List<String> getUsernames();

    List<String> getUsernamesByAllPublished();

    List<String> getUsernamesByPublishedCategory(String category);

    List<User> getUsers();

    int save(User pa, Boolean is_admin);

    int update(User p);

    User validateUser(String username);

    Boolean validateUsername(String username, String email);
    
}
