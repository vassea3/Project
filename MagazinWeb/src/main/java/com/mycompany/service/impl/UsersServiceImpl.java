package com.mycompany.service.impl;

import com.mycompany.dao.intf.UsersIntf;
import com.mycompany.model.Users;
import com.mycompany.service.intf.UsersServiceIntf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
public class UsersServiceImpl implements UsersServiceIntf {

    @Autowired
    private UsersIntf usersIntf;

    public void setUsersIntf(UsersIntf usersIntf) {
        this.usersIntf = usersIntf;
    }

    @Override
    @Transactional
    public void save(Users user) {
        this.usersIntf.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.usersIntf.delete(id);
    }

    @Override
    @Transactional
    public Users findById(int id) {
        return this.usersIntf.findById(id);
    }

    @Override
    @Transactional
    public Users findByUsername(String username) {
        return this.usersIntf.findByUsername(username);
    }

    @Override
    @Transactional
    public List<Users> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void update(Users user) {
        this.usersIntf.update(user);
    }

    @Override
    @Transactional
    public List<String> findAllUsernames() {
        return this.usersIntf.findAllUsernames();
    }

}
