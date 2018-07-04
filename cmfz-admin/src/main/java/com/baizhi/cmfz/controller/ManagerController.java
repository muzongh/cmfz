package com.baizhi.cmfz.controller;

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


    @RequestMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        char[] chs=ImageCodeUtils.getchars(4);
        String code=String.valueOf(chs);
        session.setAttribute("code",code);

        BufferedImage image=ImageCodeUtils.getImage(chs);

        ImageIO.write(image, "png", response.getOutputStream());

    }

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

    @RequestMapping("/login")
    public String login(String name,String password,boolean remember,HttpServletResponse response,HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        Manager man=ms.login(name,password);
        System.out.println(remember);
        System.out.println(name);
        if(man!=null){
            if(remember){
                String nam=URLEncoder.encode(name,"utf-8");
                Cookie c1 = new Cookie("name", nam);
                System.out.println(nam);
                c1.setPath("/cmfz-admin");
                response.addCookie(c1);
            }
            session.setAttribute("man",man);
            return "redirect:/main.jsp";
        }
        return "login";
    }

}
