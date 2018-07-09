package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.GuruService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/9 9:41
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService as;

    @Autowired
    private GuruService gs;
    @RequestMapping("/showAllGuru")
    @ResponseBody
    public List<Guru> show(){
        List<Guru> gurus = gs.queryAll();
        return gurus;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Article article) throws Exception{
        int result=as.add(article);
        if(result>0){
            return "ok";
        }
        return "";
    }

    @RequestMapping("/addMorePic")
    @ResponseBody
    public RichTextResult addMorePic(@RequestParam("files") MultipartFile[] files,
                                     HttpServletRequest request){
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String s = realPath.substring(0, realPath.lastIndexOf("\\")) + "\\images";
            if(files !=null && files.length!=0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    file.transferTo(new File(s+"\\article\\"+fileName));
                    data.add(request.getContextPath()+"/images/article/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

}
