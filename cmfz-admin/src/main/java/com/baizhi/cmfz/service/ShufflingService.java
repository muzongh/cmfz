package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Shuffling;

import java.util.List;
import java.util.Map;

/**
* @Description 轮播图的Service层接口方法
* @Author  Muzonghao
* @Date   2018/7/5 20:21
*/
public interface ShufflingService {
    /**
    * @Description 分页查询轮播图库表。返回的map（key-value）里面存了图片的总数和此页显示的轮播图信息
    * @Author       Muzonghao
    * @Time         2018/7/5 20:23
    * @Param        * @param newPage：第几页
    * @Param        * @param pageSize:一页显示几条数据
    * @Exception
    */
    public Map<String,Object> queryByPage(Integer newPage, Integer pageSize);

    /**
    * @Description 插入轮播图片
    * @Author       Muzonghao
    * @Time         2018/7/5 20:25
    * @Param        * @param shu:图片对象
    * @Exception    
    */
    public int add(Shuffling shu);
    
    /**
    * @Description 修改轮播图片信息
    * @Author       Muzonghao
    * @Time         2018/7/6 17:26
    * @Param        * @param null
    * @Exception    
    */
    public int modify(Shuffling shu);
}
