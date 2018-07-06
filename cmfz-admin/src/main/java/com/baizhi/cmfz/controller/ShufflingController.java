package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Shuffling;
import com.baizhi.cmfz.service.ShufflingService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/5 20:45
 */
@Controller
@RequestMapping("/shuffling")
public class ShufflingController {
    @Autowired
    private ShufflingService ss;
    /**
    * @Description 分页查询所有的轮播图片信息
    * @Author       Muzonghao
    * @Time         2018/7/5 20:47
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> show(@RequestParam("page")Integer newPage, @RequestParam("rows")Integer pageSize){
        return ss.queryByPage(newPage,pageSize);
    }

    /**
    * @Description 添加轮播图详细
    * @Author       Muzonghao
    * @Time         2018/7/6 9:07
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request,
                      @RequestParam("description") String description,
                      @RequestParam("file") MultipartFile file,
                      @RequestParam("status")String status) throws Exception{
        System.out.println(description+file+status);
        if(!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            System.out.println(filename);
            String realPath = request.getSession().getServletContext().getRealPath("/images/").replace(request.getContextPath().replace("/","\\"),"");
            System.out.println(realPath);
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,
                    file.getOriginalFilename()));
            Shuffling shu=new Shuffling();
            shu.setShufflingDate(new Date());
            shu.setShufflingDescription(description);
            shu.setShufflingPath(filename);
            shu.setShufflingStatus(status);
            shu.setShufflingId(UUID.randomUUID().toString().replace("-",""));
            System.out.println(shu);
            int result=ss.add(shu);
            if(result>0){
                return "success";
            }else{
                return "";
            }
        } else {
            return "";
        }
    }
}
