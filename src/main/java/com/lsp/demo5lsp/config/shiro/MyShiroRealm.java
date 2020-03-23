package com.lsp.demo5lsp.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/23 12:20
 **/
@Slf4j
public class MyShiroRealm   extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo() .......权限认证");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 做一些权限认证，应该从数据库的角色表中获取角色及url
//        info.addRole(role.getRoleName());
//        info.addStringPermission(url.getFilePath());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("doGetAuthenticationInfo() ........身份认证");
        // 做一些身份认证
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        // 应该从数据库获取密码进行比对
        String password = null;
//        StaffInfoVo user = loginService.findUserByLoginName(userName,true);
//        if(ObjectKit.isNull(user) || user.getStaff()==null){
//            log.debug("用户名不存在");
//            throw new UserException(ErrorCodeEnum.USER_LOGIN_USERNAME_ERROR);
//        }
        return new SimpleAuthenticationInfo(userName, password,getName());
    }
}
