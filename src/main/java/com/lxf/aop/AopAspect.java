package com.lxf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//定义切面
public class AopAspect {

    //定义切点
    @Pointcut("execution(public * com.lxf.aop.AopController.*(..))")
    public void broker(){}

    //定义环绕通知
    @Around("broker()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("前置通知");
            pjp.proceed();
            System.out.println("最终通知");
        }catch (Throwable e){
            System.out.println("异常通知");
            throw new Throwable();
        }finally {
            System.out.println("后置通知（相当于‘最终通知’和‘异常通知’）");
        }

    }

}