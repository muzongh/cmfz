package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Description 额外功能类：日志记录
 * @Author Muzonghao
 * @Date 2018/7/9 23:42
 */
@Aspect
public class aspectjUtils {
    @Autowired
    private LogService ls;
    @Autowired
    private HttpSession session;
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.add*(..)) " +
            "|| execution(* com.baizhi.cmfz.service.impl.*.cancel*(..)) " +
            "|| execution(* com.baizhi.cmfz.service.impl.*.modify*(..))")
    public void log(){}

    @Around("log()")
    public Object after(ProceedingJoinPoint pjp){
        Log log=new Log();
        Object obj = null;
        try {
            obj = pjp.proceed();
            log.setLogResult("success");
        } catch (Throwable throwable) {
            log.setLogResult("error");
            throwable.printStackTrace();
        }
        Object[] args=pjp.getArgs();
        String message="";
        for (Object str:args ) {
            message=message+str.toString();
        }
        MethodSignature methodSignature= (MethodSignature) pjp.getSignature();

        Method method=methodSignature.getMethod();

        String methodName=method.getName();

        String className=methodSignature.getDeclaringType().getSimpleName();

        String resource=className.replace("Service","");

        String name="";
        Manager manager =(Manager)session.getAttribute("man");
        String userName=manager.getManagerName();
        if(methodName.startsWith("add")){
            name="新增";
        }else if(methodName.startsWith("cancel")){
            name="删除";
        }else if(methodName.startsWith("modify")){
            name="修改";
        }
        log.setLogMessage(message);
        log.setLogAction(name);
        log.setLogResource(resource);
        log.setLogUser(userName);
        ls.insert(log);
        return obj;

    }

}
