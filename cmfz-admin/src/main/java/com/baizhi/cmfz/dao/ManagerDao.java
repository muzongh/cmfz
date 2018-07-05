package com.baizhi.cmfz.dao;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:04
*/

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerDao {
    /**
    * @Description Manager的DAO层接口方法：根据姓名查询管理员
    * @Author       Muzonghao
    * @Time         2018/7/5 9:15
    * @Param        * @param name:客户端输入的管理员姓名
    * @Exception    null
    */
    public Manager selectByName(@Param("name")String name);
}
