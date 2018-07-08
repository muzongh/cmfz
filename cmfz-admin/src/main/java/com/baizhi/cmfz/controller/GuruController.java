package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/6 20:13
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService gs;
    
    /**
    * @Description 分页查询所有上师
    * @Author       Muzonghao
    * @Time         2018/7/6 21:23
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> show(@RequestParam("page")Integer newPage, @RequestParam("rows")Integer pageSize){
        return gs.queryByPage(newPage,pageSize);
    }

    /**
    * @Description 分页模糊查询所有上师
    * @Author       Muzonghao
    * @Time         2018/7/6 21:23
    * @Param        * @param null
    * @Exception
    */
    @RequestMapping("/containsByName")
    @ResponseBody
    public Map<String,Object> containsByName(@RequestParam("name")String name,@RequestParam("page")Integer newPage, @RequestParam("rows")Integer pageSize){
        return gs.queryByContains(name,newPage,pageSize);
    }

    /**
    * @Description 添加上师
    * @Author       Muzonghao
    * @Time         2018/7/6 21:24
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request,
                      @RequestParam("name") String name,
                      @RequestParam("file") MultipartFile file,
                      @RequestParam("summary")String summary) throws IOException {
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String realPath = request.getSession().getServletContext().getRealPath("/photos/").replace(request.getContextPath().replace("/","\\"),"");
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,
                    file.getOriginalFilename()));
            Guru guru=new Guru();
            guru.setGuruId(UUID.randomUUID().toString().replace("-",""));
            guru.setGuruName(name);
            guru.setGuruPhoto(filename);
            guru.setGuruSummary(summary);
            int result = gs.add(guru);
            if(result>0){
                return "success";
            }else{
                return "";
            }
        }
        return "";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request,
                         @RequestParam("guruId")String id,
                         @RequestParam("guruName") String name,
                         @RequestParam("file") MultipartFile file,
                         @RequestParam("guruSummary")String summary) throws IOException {
        Guru guru=gs.queryById(id);
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String realPath = request.getSession().getServletContext().getRealPath("/photos/").replace(request.getContextPath().replace("/","\\"),"");
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,
                    file.getOriginalFilename()));
            guru.setGuruPhoto(filename);
        }else{
            guru.setGuruName(name);
            guru.setGuruSummary(summary);
        }
        int result = gs.modify(guru);
        if(result>0){
            return "success";
        }
        return "";
    }

    /**
    * @Description 删除上师信息
    * @Author       Muzonghao
    * @Time         2018/7/8 18:10
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping("/cancel")
    @ResponseBody
    public String cancel(@RequestParam("id")String id){
        System.out.println(id);
        int result=gs.cancel(id);
        if(result>0){
            return "success";
        }
        return "";
    }

    /**
    * @Description 批量插入上师信息
    * @Author       Muzonghao
    * @Time         2018/7/8 18:10
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping("/addBatch")
    @ResponseBody
    public String addBatch(@RequestParam("addfile")MultipartFile file) throws Exception {
        //file.getOriginalFilename().substring();
        ImportParams params = new ImportParams();
        List<Guru> list = ExcelImportUtil.importExcel(file.getInputStream(), Guru.class, params);
        int result=gs.addBatch(list);
        if(result>0){
            return "OK";
        }
        return "";
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<Guru> list=gs.queryAll();
        Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams("上师信息表", "sheet1"), Guru.class, list);

        String fileName=new String("上师信息.xls".getBytes(),"iso-8859-1");

        ServletOutputStream stream = response.getOutputStream();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition","attachment;fileName="+fileName);

        sheets.write(stream);

        stream.close();

    }
}
