package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description 上师表的DAO层接口方法
* @Author  Muzonghao
* @Date   2018/7/6 17:33
*/
public interface GuruDao {

    /**
    * @Description TODO
    * @Author       Muzonghao
    * @Time         2018/7/6 17:54
    * @Param        * @param null
    * @Exception    
    */
    public Guru selectById(@Param("id")String gid);

    /**
    * @Description 分页查询上师具体信息
    * @Author       Muzonghao
    * @Time         2018/7/6 17:34
     * @Param        * @param begin:本页显示的数据的开始
     * @Param        * @param end:本页显示的数据的结束
    * @Exception    
    */
    public List<Guru> selectByPage(@Param("begin") Integer begin, @Param("end") Integer end);
    public int countAll();

    /**
    * @Description 添加上师
    * @Author       Muzonghao
    * @Time         2018/7/6 17:36
    * @Param        * @param null
    * @Exception    
    */
    public int insert(Guru guru);
    
    /**
    * @Description 修改上师信息
    * @Author       Muzonghao
    * @Time         2018/7/6 17:36
    * @Param        * @param null
    * @Exception    
    */
    public int update(Guru guru);
    
    /**
    * @Description 删除上师信息
    * @Author       Muzonghao
    * @Time         2018/7/6 22:38
    * @Param        * @param null
    * @Exception    
    */
    public int delete(@Param("id") String gid);

    /**
    * @Description 模糊查询上师信息
    * @Author       Muzonghao
    * @Time         2018/7/7 17:04
    * @Param        * @param null
    * @Exception    
    */
    public List<Guru> selectByContains(@Param("name")String gname,@Param("begin") Integer begin, @Param("end") Integer end);
    public int countContains(@Param("name")String gname);
    
    /**
    * @Description 批量插入上师信息
    * @Author       Muzonghao
    * @Time         2018/7/8 18:23
    * @Param        * @param null
    * @Exception    
    */
    public int insertBatch(@Param("list") List<Guru> gurus);
    
    /**
    * @Description 批量导出，查询所有
    * @Author       Muzonghao
    * @Time         2018/7/8 19:27
    * @Param        * @param null
    * @Exception    
    */
    public List<Guru> selectAll();
}
