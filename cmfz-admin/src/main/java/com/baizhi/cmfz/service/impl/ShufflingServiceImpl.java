package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ShufflingDao;
import com.baizhi.cmfz.entity.Shuffling;
import com.baizhi.cmfz.service.ShufflingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/5 20:26
 */
@Service
@Transactional
public class ShufflingServiceImpl implements ShufflingService {
    @Autowired
    private ShufflingDao sd;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryByPage(Integer newPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<Shuffling> shufflings=sd.selectByPage((newPage-1)*pageSize,pageSize);
        map.put("rows",shufflings);
        int count=sd.countAll();
        map.put("total",count);
        return map;
    }


    public int add(Shuffling shu) {
        return sd.insert(shu);
    }


    public int modify(Shuffling shu) {
        return sd.update(shu);
    }

}
