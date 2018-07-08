package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/6 17:52
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao gd;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Guru queryById(String gid) {
        return gd.selectById(gid);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryByPage(Integer newPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<Guru> gurus=gd.selectByPage((newPage-1)*pageSize,newPage*pageSize);
        map.put("rows",gurus);
        int count=gd.countAll();
        map.put("total",count);
        return map;
    }

    @Override
    public Map<String, Object> queryByContains(String name, Integer newPage, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        List<Guru> gurus = gd.selectByContains(name, (newPage - 1) * pageSize, newPage * pageSize);
        map.put("rows",gurus);
        int count=gd.countContains(name);
        map.put("total",count);
        return map;
    }


    public int add(Guru guru) {
        return gd.insert(guru);
    }

    @Override
    public int addBatch(List<Guru> gurus) {
        return gd.insertBatch(gurus);
    }


    public int modify(Guru guru) {
        return gd.update(guru);
    }


    public int cancel(String gid) {
        return gd.delete(gid);
    }

    @Override
    public List<Guru> queryAll() {
        return gd.selectAll();
    }
}
