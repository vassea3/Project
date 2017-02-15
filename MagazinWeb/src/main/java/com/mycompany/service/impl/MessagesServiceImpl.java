package com.mycompany.service.impl;

import com.mycompany.dao.intf.MessagesIntf;
import com.mycompany.model.Messages;
import com.mycompany.service.intf.MessagesServiceIntf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("messageService")
public class MessagesServiceImpl implements MessagesServiceIntf {

    @Autowired
    private MessagesIntf messagesIntf;

    @Override
    @Transactional
    public void save(Messages message) {
        this.messagesIntf.save(message);
    }

    @Override
    @Transactional
    public void delete(Messages message) {
        this.messagesIntf.delete(message);
    }

    @Override
    @Transactional
    public List<Messages> findAll() {
        return this.messagesIntf.findAll();
    }

    @Override
    @Transactional
    public Messages findById(int id) {
        return this.messagesIntf.findById(id);
    }
}
