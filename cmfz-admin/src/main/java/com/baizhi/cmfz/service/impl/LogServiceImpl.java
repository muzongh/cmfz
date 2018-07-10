package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/9 21:46
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao ld;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryByPage(Integer newPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<Log> logs = ld.selectByPage((newPage - 1) * pageSize, newPage * pageSize);
        map.put("rows",logs);
        int count=ld.count();
        map.put("total",count);
        return map;
    }


    public int insert(Log log) {
        log.setLogId(UUID.randomUUID().toString().replace("-",""));
        log.setLogTime(new Date());
        return ld.insert(log);
    }
}
