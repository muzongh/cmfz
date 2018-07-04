package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao md;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Manager login(String name, String password) {
        Manager man=md.selectByName(name);
        if(man!=null){
            String pwd= DigestUtils.md5Hex(password+man.getManagerSalt());
            String pwd1=DigestUtils.md5Hex(man.getManagerPassword()+man.getManagerSalt());
            if(pwd.equals(pwd1)){
                return man;
            }
        }
        return null;
    }
}
