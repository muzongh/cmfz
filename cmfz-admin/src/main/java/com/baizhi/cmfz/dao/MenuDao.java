package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description 菜单操作方法DAO接口
* @Author  Muzonghao
* @Date   2018/7/5 10:51
*/
public interface MenuDao {
    public List<Menu> selectParent();
    public List<Menu> selectChildren(@Param("menuParentId") String pid);
}
