package com.lsp.demo5lsp.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import java.io.Serializable;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/23 15:07
 **/
@Slf4j
public class MySessionManager extends DefaultWebSessionManager {
    /**
     * @Description  重写进行异常处理
      * @param sessionKey
     * @Return org.apache.shiro.session.Session
     * @Author lsp
     * @Date 2020/3/23 15:48
     */
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        try {
            Serializable sessionId = getSessionId(sessionKey);
            if (sessionId == null) {
                log.debug("Unable to resolve session ID from SessionKey [{}].  Returning null to indicate a " +
                        "session could not be found.", sessionKey);
                return null;
            }
            Session s = retrieveSessionFromDataSource(sessionId);
            if (s == null) {
                //session ID was provided, meaning one is expected to be found, but we couldn't find one:
                String msg = "Could not find session with ID [" + sessionId + "]";
                throw new UnknownSessionException(msg);
            }
            return s;
        }catch (UnknownSessionException e){
            log.warn("找不到Session：[{}]",e.getMessage());
            return null;
        }catch (Exception e){
            log.error("Session异常：[{}]",e.getMessage(),e);
            return null;
        }
    }
}
