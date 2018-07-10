package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/9 21:44
 */
public interface LogService {
    public Map<String,Object> queryByPage(Integer newPage,Integer pageSize);

    public int insert(Log log);
}
