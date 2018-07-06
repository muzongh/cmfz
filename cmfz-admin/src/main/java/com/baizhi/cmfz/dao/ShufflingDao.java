package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Shuffling;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description 轮播图的DAO层接口方法
* @Author  Muzonghao
* @Date   2018/7/5 20:01
*/
public interface ShufflingDao {
    /**
    * @Description 分页查询轮播图的所有图片
    * @Description count：查询所有轮播图的个数
    * @Author       Muzonghao
    * @Time         2018/7/5 20:02
    * @Param        * @param begin:本页显示的数据的开始
    * @Param        * @param end:本页显示的数据的结束
    * @Exception
    */
    public List<Shuffling> selectByPage(@Param("begin") Integer begin, @Param("end") Integer end);
    public int countAll();

    /**
    * @Description 添加轮播图信息
    * @Author       Muzonghao
    * @Time         2018/7/5 20:05
    * @Param        * @param shu:轮播图对象
    * @Exception    
    */
    public int insert(Shuffling shu);
    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/5 23:56
    * @Param        * @param null
    * @Exception    
    */
    public int update(Shuffling shu);

}
