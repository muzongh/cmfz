package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description 文章的Service层接口实现
 * @Author Muzonghao
 * @Date 2018/7/8 23:10
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao ad;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryByPage(Integer newPage, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        List<Article> articles = ad.selectByPage((newPage - 1) * pageSize, newPage * pageSize);
        map.put("rows",articles);
        int count=ad.count();
        map.put("total",count);
        return map;
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Article queryById(String id) {
        return ad.selectById(id);
    }

    @Override
    public int add(Article article) {
        if(article.getArticleStatus()==null){
            article.setArticleStatus("下架");
        }
        article.setArticleDate(new Date());
        article.setArticleId(UUID.randomUUID().toString().replace("-",""));
        return ad.insert(article);
    }

    @Override
    public int cancel(String id) {
        return ad.delete(id);
    }

    @Override
    public int modify(Article article) {
        return ad.update(article);
    }
}
