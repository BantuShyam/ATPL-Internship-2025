package com.aaslin.DispatcherServlet.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class FlowLoggingInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(" PreHandle: Incoming Request URL  " + request.getRequestURL());
        return true; // continue request flow
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            System.out.println(" PostHandle: ModelAndView  ViewName: " 
                               + modelAndView.getViewName() + ", Model: " + modelAndView.getModel());
        } else {
            System.out.println(" PostHandle: No ModelAndView (maybe REST response)");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println(" AfterCompletion: Response Status - " + response.getStatus());
    }
}
