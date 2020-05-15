package com.hqu.community.controller.interceptor;

import com.hqu.community.annotation.LoginRequired;
import com.hqu.community.entity.LoginTicket;
import com.hqu.community.util.HostHolder;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws IOException {
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            if(loginRequired != null) {
                if(hostHolder.getUser() == null) {
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
                }
            }
        }
        return true;
    }
}
