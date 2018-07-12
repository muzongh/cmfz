package com.baizhi.cmfz.service.impl;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:04
*/

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao md;
    
    /**
    * @Description Manager登陆的Service实现登陆功能的方法
    * @Author       Muzonghao
    * @Time         2018/7/5 9:14
    * @Param         * @param name:客户端输入的管理员姓名
     *               * @param password:客户端输入的管理员密码
    * @Exception    
    */
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Manager login(String name) {
        return md.selectByName(name);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Role> queryRolesByName(String name) {
        return md.selectRolesByManName(name);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Permission> queryPermissionsByName(String name) {
        System.out.println(md.selectPermissionsByName(name));
        return md.selectPermissionsByName(name);
    }

    /**
    * @Description Manager修改信息的Service实现方法
    * @Author       Muzonghao
    * @Time         2018/7/5 14:00
    * @Param        * @param manager:管理员对象信息
    * @Exception    
    */
    public int modifyById(Manager manager) {
        return md.updateById(manager);
    }
}
