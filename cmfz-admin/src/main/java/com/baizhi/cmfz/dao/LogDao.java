package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/9 21:36
 */
public interface LogDao {
    public List<Log> selectByPage(@Param("begin")Integer begin,@Param("end")Integer end);
    public int count();

    public int insert(Log log);

}
