package com.baizhi.cmfz.controller;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:05
*/

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.utils.ImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    /**
    * @Description 勾选记住用户名，之后需要执行的操作，读取Cookie
    * @Author       Muzonghao
    * @Time         2018/7/5 9:13
    * @Param        * @param null
    * @Exception
    */
    @RequestMapping("/getCookie")
    public String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
       for (Cookie cookie : cookies) {
            if("name".equals(cookie.getName())){
                String d=URLDecoder.decode(cookie.getValue(),"UTF-8");
                request.setAttribute("name",d);

            }
        }
        return "login";
    }

    
    /**
    * @Description 获取验证码的方法
    * @Author       Muzonghao
    * @Time         2018/7/5 9:13
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        char[] chs=ImageCodeUtils.getchars(4);
        String code=String.valueOf(chs);
        session.setAttribute("code",code);

        BufferedImage image=ImageCodeUtils.getImage(chs);

        ImageIO.write(image, "png", response.getOutputStream());

    }
    
    /**
    * @Description 异步验证管理员输入的验证码是否正确
    * @Author       Muzonghao
    * @Time         2018/7/5 9:14
    * @Param        * @param encode:管理员前端输入的验证码
    * @Exception    
    */
    @RequestMapping("/checkImage")
    @ResponseBody
    public String check(String encode,HttpServletRequest request){
        HttpSession session=request.getSession();
        String code= (String) session.getAttribute("code");
        if(encode.equalsIgnoreCase(code)){
            return "OK";
        }else{
            return "NO";
        }
    }

    @Autowired
    private ManagerService ms;
    
    /**
    * @Description 管理员点击登陆之后，跳转的Controller方法，若成功则跳转到index页面，否则跳回原界面
    * @Author       Muzonghao
    * @Time         2018/7/5 9:14
    * @Param        * @param name:管理员输入的管理员姓名
     * @Param        * @param password:管理员输入的管理员密码
     * @Param        * @param remember:管理员是否勾选了”记住用户名“这个选项
    * @Exception    
    */
    @RequestMapping("/login")
    public String login(String name,String password,boolean remember,HttpServletResponse response,HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        Manager man=ms.login(name,password);
        if(man!=null){
            if(remember){
                String nam=URLEncoder.encode(name,"utf-8");
                Cookie c1 = new Cookie("name", nam);
                c1.setPath("/cmfz-admin");
                response.addCookie(c1);
            }
            session.setAttribute("man",man);
            return "redirect:/main.jsp";
        }
        return "login";
    }

}
