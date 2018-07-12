package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/10 10:45
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService ls;
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> show(@RequestParam("page")Integer page,@RequestParam("rows")Integer rows){
        return  ls.queryByPage(page,rows);
    }
}
