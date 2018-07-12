package com.baizhi.cmfz.service;

/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:04
*/
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface ManagerService {
    /**
    * @Description Manager登陆的Service接口
    * @Author       Muzonghao
    * @Time         2018/7/5 9:15
    * @Param        * @param name:客户端输入的管理员姓名
     *              * @param password:客户端输入的管理员密码
    * @Exception
    */
    public Manager login(String name);
    
    /**
    * @Description 查找Manager所拥有的角色信息
    * @Author       Muzonghao
    * @Time         2018/7/12 17:34
    * @Param        * @param null
    * @Exception    
    */
    public List<Role> queryRolesByName(String name);
    
    /**
    * @Description 查询Manager所拥有的权限信息
    * @Author       Muzonghao
    * @Time         2018/7/12 17:43
    * @Param        * @param null
    * @Exception    
    */
    public List<Permission> queryPermissionsByName(String name);

    /**
    * @Description 修改Manager信息的Service的Service接口
    * @Author       Muzonghao
    * @Time         2018/7/5 13:56
    * @Param        * @param manager:管理员信息
    * @Exception    
    */
    public int modifyById(Manager manager);
}
