package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description 文章的DAO的接口方法
* @Author  Muzonghao
* @Date   2018/7/8 22:29
*/
public interface ArticleDao {
    /**
     * @Description 分页查询所有文章
     * @Author Muzonghao
     * @Time 2018/7/8 22:30
     * @Param * @param null
     * @Exception
     */
    public List<Article> selectByPage(@Param("begin") Integer begin, @Param("end") Integer end);
    public int count();

    /**
     * @Description 查询单个文章
     * @Author Muzonghao
     * @Time 2018/7/8 22:39
     * @Param * @param null
     * @Exception
     */
    public Article selectById(@Param("id") String aid);

    /**
     * @Description 增加文章
     * @Author Muzonghao
     * @Time 2018/7/8 22:41
     * @Param * @param null
     * @Exception
     */
    public int insert(Article article);

    /**
    * @Description 删除文章
    * @Author       Muzonghao
    * @Time         2018/7/8 22:42
    * @Param        * @param null
    * @Exception    
    */
    public int delete(@Param("id")String aid);

    /**
    * @Description 修改文章信息
    * @Author       Muzonghao
    * @Time         2018/7/8 22:44
    * @Param        * @param null
    * @Exception    
    */
    public int update(Article article);
}
