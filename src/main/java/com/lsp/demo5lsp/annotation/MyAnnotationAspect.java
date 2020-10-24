package com.lsp.demo5lsp.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lsp
 * @description TODO
 * @date 2020/4/13 19:31
 **/
@Component
public class MyAnnotationAspect implements MethodInterceptor {

    @Pointcut("@annotation(com.lsp.demo5lsp.annotation.MyAnnotaion)")
    public void methodPointCut(){}

//    @Around("methodPointCut()")
//    public void annotationAround(ProceedingJoinPoint proceedingJoinPoint){
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        MyAnnotaion myAnnotaion = proceedingJoinPoint.getSignature().getDeclaringTypeName().getClass().getAnnotation(MyAnnotaion.class);
//        System.out.println("methodName:"+methodName+"============ myAnnotation:"+myAnnotaion);
//        try {
//            proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("myAnnotationAspect execute success!");
//    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        MyAnnotaion myAnnotaion = methodInvocation.getMethod().getAnnotation(MyAnnotaion.class);
        System.out.println("myAnnotation:"+myAnnotaion);
        return methodInvocation.proceed();
    }
}
