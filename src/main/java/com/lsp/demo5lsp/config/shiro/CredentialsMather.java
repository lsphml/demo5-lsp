package com.lsp.demo5lsp.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/23 14:59
 **/
public class CredentialsMather extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

//        UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
//        Object tokenCredentials = EncryptKit.md5Admin(String.valueOf(authcToken.getPassword()));
//        Object accountCredentials = getCredentials(info);
//        if(!accountCredentials.equals(tokenCredentials)){
//            log.error("密码不正确！用户：{},密码：{}",authcToken.getUsername(),authcToken.getPassword());
//            throw new UserException(ErrorCodeEnum.USER_LOGIN_PASSWORD_ERROR);
//        }
        return true;
    }
}
