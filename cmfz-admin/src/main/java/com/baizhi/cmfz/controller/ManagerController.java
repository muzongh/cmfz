package com.baizhi.cmfz.controller;
/**
* @Description TODO
* @Author  Muzonghao
* @Date   2018/7/5 9:05
*/

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.utils.ImageCodeUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import java.util.List;

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
   /* @RequestMapping("/getCookie")
    public String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
       for (Cookie cookie : cookies) {
            if("name".equals(cookie.getName())){
                String d=URLDecoder.decode(cookie.getValue(),"UTF-8");
                request.setAttribute("name",d);

            }
        }
        return "login";
    }*/

    
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
    * @Description 管理员点击登陆之后，跳转的Controller方法，若成功则跳转到main方法，否则跳回原界面
    * @Author       Muzonghao
    * @Time         2018/7/5 9:14
    * @Param        * @param name:管理员输入的管理员姓名
     * @Param        * @param password:管理员输入的管理员密码
     * @Param        * @param remember:管理员是否勾选了”记住用户名“这个选项
    * @Exception    
    */
    @RequestMapping("/login")
    public String login(String name,String password,boolean rememberMe,HttpServletResponse response,HttpServletRequest request) throws Exception {
        //在外部环境中安全管理器会自动进行初始化
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken(name,password,rememberMe));
            String nam=URLEncoder.encode(name,"utf-8");
            Cookie c1 = new Cookie("name", nam);
            c1.setPath("/cmfz-admin");
            response.addCookie(c1);
            request.getSession().setAttribute("man",ms.login(name));
            return "redirect:/main.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        }

        /*HttpSession session=request.getSession();
        Manager man=ms.login(name,password);
        if(man!=null){
            if(remember){
                String nam=URLEncoder.encode(name,"utf-8");
                Cookie c1 = new Cookie("name", nam);
                c1.setPath("/cmfz-admin");
                response.addCookie(c1);
            }
            session.setAttribute("man",man);
            return "main";
        }
        return "login";*/
    }

    /**
     * @Description 管理员登陆成功之后，先执行次方法，查询出来所有的一级二级目录，再由此方法跳到main页面
     * @Author       Muzonghao
     * @Time         2018/7/5 14:02
     * @Param        * @param null
     * @Exception
     */
    @Autowired
    private MenuService menus;
    @RequestMapping("/main")
    @ResponseBody
    public List<Menu> ma(HttpSession session){
        List<Menu> parents = menus.queryMenus();
        //session.setAttribute("parents",parents);
        return parents;
    }


    /**
    * @Description 异步检测旧密码是否正确和新密码是否可用
    * @Author       Muzonghao
    * @Time         2018/7/5 16:30
    * @Param        * @param null
    * @Exception    
    */
    @RequestMapping("/findPwd")
    @ResponseBody
    public String find(String pwd,HttpSession session){
        Manager man= (Manager) session.getAttribute("man");
        if(man!=null && man.getManagerPassword().equals(pwd)){
            return "OK";
        }
        return "";
    }

    @RequestMapping("/modify")
    public String modify(String pwd,HttpSession session){
        Manager manager= (Manager) session.getAttribute("man");
        manager.setManagerPassword(pwd);
        System.out.println(pwd);
        int result=ms.modifyById(manager);
        if(result>0){
            session.invalidate();
            return "redirect:/manager/getCookie.do";
        }
        return null;
    }


}
