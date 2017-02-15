package com.mycompany.service.intf;

import com.mycompany.model.Messages;
import java.util.List;

public interface MessagesServiceIntf {

    public void save(Messages message);

    public void delete(Messages message);

    public Messages findById(int id);

    public List<Messages> findAll();
}
