package com.lsp.demo5lsp.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/23 12:19
 **/
@Configuration
@Slf4j
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shrioFilter(SecurityManager securityManager){
        log.info("ShiroConfiguration.shirFilter()........");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 过滤链从上向下顺序执行，一般将/**放在最为下边; authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        // swagger2的所有相关请求全部放行
        filterChainDefinitionMap.put("/doc.html","anon");
        filterChainDefinitionMap.put("/swagger/**","anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**","anon");
        filterChainDefinitionMap.put("/v2/**","anon");
        // druid监控页面的相关请求放行
        filterChainDefinitionMap.put("/druid/**","anon");
        // 登录相关的请求拦截设置
        filterChainDefinitionMap.put("/login.html","anon");
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
//        filterChainDefinitionMap.put("/**", "authc");
        // 暂时撤去所有的访问请求限制，需要权限过滤时将<"/**", "anon">变成<"/**", "authc"> 即可
        filterChainDefinitionMap.put("/**", "anon");
        //如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
//        shiroFilterFactoryBean.setLoginUrl("/login.html");
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized.html");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 自定义session管理
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }


    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(new CredentialsMather());
        return myShiroRealm;
    }

    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new MySessionManager();
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionIdCookie(simpleCookie());
        sessionManager.setSessionIdCookieEnabled(true);
        // 删除无效Session
        sessionManager.setDeleteInvalidSessions(true);
        // 设置30分钟删除会话 // 60 * 60 * 1000
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
        sessionManager.setSessionValidationInterval(30 * 60 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //sessionManager.setSessionDAO(sessionDAO());
        return  sessionManager;
    }

    @Bean
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie =new SimpleCookie("shiro.sesssion");
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
