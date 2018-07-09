package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

/**
* @Description 文章的Service层接口
* @Author  Muzonghao
* @Date   2018/7/8 23:05
*/
public interface ArticleService {
    /**
    * @Description 文章的分页查询
    * @Author       Muzonghao
    * @Time         2018/7/8 23:06
    * @Param        * @param null
    * @Exception    
    */
    public Map<String,Object> queryByPage(Integer newPage,Integer pageSize);

    /**
    * @Description 根据Id查询文章
    * @Author       Muzonghao
    * @Time         2018/7/8 23:07
    * @Param        * @param null
    * @Exception    
    */
    public Article queryById(String id);
    
    /**
    * @Description 添加文章
    * @Author       Muzonghao
    * @Time         2018/7/8 23:07
    * @Param        * @param null
    * @Exception    
    */
    public int add(Article article);
    
    /**
    * @Description 删除文章
    * @Author       Muzonghao
    * @Time         2018/7/8 23:08
    * @Param        * @param null
    * @Exception    
    */
    public int cancel(String id);
    
    /**
    * @Description 修改文章
    * @Author       Muzonghao
    * @Time         2018/7/8 23:08
    * @Param        * @param null
    * @Exception
    */
    public int modify(Article article);
}
