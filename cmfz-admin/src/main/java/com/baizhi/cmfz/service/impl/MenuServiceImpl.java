package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description Menu Service的实现类
 * @Author Muzonghao
 * @Date 2018/7/5 11:32
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao md;

    /**
    * @Description 调用MenuDao中的方法实现查询一级和二级目录
    * @Author       Muzonghao
    * @Time         2018/7/5 11:33
    * @Param        * @param null
    * @Exception    
    */
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Menu> queryMenus() {
        return md.selectParent();
    }
}
