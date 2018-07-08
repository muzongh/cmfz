package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
* @Description 上师Service层接口
* @Author  Muzonghao
* @Date   2018/7/6 17:49
*/
public interface GuruService {
    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/6 17:56
    * @Param        * @param null
    * @Exception    
    */
    public Guru queryById(String gid);

    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/6 17:49
    * @Param        * @param null
    * @Exception    
    */
    public Map<String,Object> queryByPage(Integer newPage,Integer pageSize);

    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/7 17:24
    * @Param        * @param null
    * @Exception    
    */
    public Map<String,Object> queryByContains(String name,Integer newPage,Integer pageSize);

    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/6 17:50
    * @Param        * @param null
    * @Exception    
    */
    public int add(Guru guru);

    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/8 18:26
    * @Param        * @param null
    * @Exception    
    */
    public int addBatch(List<Guru> gurus);

    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/6 17:50
    * @Param        * @param null
    * @Exception    
    */
    public int modify(Guru guru);
    
    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/6 22:39
    * @Param        * @param null
    * @Exception    
    */
    public int cancel(String gid);
    
    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/8 19:28
    * @Param        * @param null
    * @Exception    
    */
    public List<Guru> queryAll();
}
