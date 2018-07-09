package com.baizhi.cmfz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/9 20:48
 */
@Controller
@RequestMapping("/chart")
public class ChartController {
    @RequestMapping("/getManData")
    @ResponseBody
    public ArrayList getManData(){
        ArrayList list = new ArrayList();
        HashMap map1 = new HashMap();
        map1.put("name","北京");
        map1.put("value","100");
        HashMap map2 = new HashMap();
        map2.put("name","河南");
        map2.put("value","150");
        HashMap map3 = new HashMap();
        map3.put("name","山东");
        map3.put("value","90");
        HashMap map4 = new HashMap();
        map4.put("name","河北");
        map4.put("value","80");
        HashMap map5 = new HashMap();
        map5.put("name","四川");
        map5.put("value","500");
        HashMap map6 = new HashMap();
        map6.put("name","新疆");
        map6.put("value","800");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        return list;
    }

    @RequestMapping("/getLadyData")
    @ResponseBody
    public ArrayList getLadyData(){
        ArrayList list = new ArrayList();
        HashMap map1 = new HashMap();
        map1.put("name","北京");
        map1.put("value","1200");
        HashMap map2 = new HashMap();
        map2.put("name","河南");
        map2.put("value","100000");
        HashMap map3 = new HashMap();
        map3.put("name","山东");
        map3.put("value","50000");
        HashMap map4 = new HashMap();
        map4.put("name","河北");
        map4.put("value","10");
        HashMap map5 = new HashMap();
        map5.put("name","四川");
        map5.put("value","500");
        HashMap map6 = new HashMap();
        map6.put("name","新疆");
        map6.put("value","800");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        return list;
    }
}
