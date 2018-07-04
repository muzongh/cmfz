package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerDao {
    public Manager selectByName(@Param("name")String name);
}
