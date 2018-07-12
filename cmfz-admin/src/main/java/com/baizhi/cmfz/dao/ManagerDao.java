package com.baizhi.cmfz.dao;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:04
*/

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao {
    /**
    * @Description Manager的DAO层接口方法：根据姓名查询管理员
    * @Author       Muzonghao
    * @Time         2018/7/5 9:15
    * @Param        * @param name:客户端输入的管理员姓名
    * @Exception    null
    */
    public Manager selectByName(@Param("name")String name);
    
    /**
    * @Description 查找Manager的角色信息
    * @Author       Muzonghao
    * @Time         2018/7/12 17:27
    * @Param        * @param null
    * @Exception    
    */
    public List<Role> selectRolesByManName(@Param("name")String name);

    /**
    * @Description 查找Manager的权限信息
    * @Author       Muzonghao
    * @Time         2018/7/12 17:40
    * @Param        * @param null
    * @Exception    
    */
    public List<Permission> selectPermissionsByName(@Param("name")String name);

    /**
    * @Description 修改管理员信息DAO层接口
    * @Author       Muzonghao
    * @Time         2018/7/5 13:39
    * @Param        * @param Manager:需要修改的管理员的新信息
    * @Exception    
    */
    public int updateById(Manager manager);
}
