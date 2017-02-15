package com.mycompany.dao.intf;

import com.mycompany.model.Users;
import java.util.List;

public interface UsersIntf {

    public void save(Users user);

    public void update(Users user);

    public void delete(int id);

    public Users findById(int id);

    public Users findByUsername(String username);

    public List<Users> findAll();

    public List<String> findAllUsernames();
}
