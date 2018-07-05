package com.baizhi.cmfz.service;

/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:04
*/
import com.baizhi.cmfz.entity.Manager;

public interface ManagerService {
    /**
    * @Description Manager登陆的Service接口
    * @Author       Muzonghao
    * @Time         2018/7/5 9:15
    * @Param        * @param name:客户端输入的管理员姓名
     *              * @param password:客户端输入的管理员密码
    * @Exception
    */
    public Manager login(String name,String password);
}
