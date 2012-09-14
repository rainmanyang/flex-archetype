package com.oasis.tmsv5.facade.util;

import javax.servlet.http.HttpServletRequest;

import flex.messaging.FlexContext;

public class SecurityUtil {
	/**
     * 获取访问用户的ip
     * @return
     */
    public static String getUserIp() {
        String result;
        HttpServletRequest request = null;
        try{
            request = FlexContext.getHttpRequest();
        }catch(Exception e){
            
        }
        if(request == null){
            return "unknown host";
        }
        result = request.getRemoteAddr();
        
        return result;
    }
    /**
     * 获取访问url
     * @return
     */
    public static String getRequestUrl() {
        String result;
        HttpServletRequest request = null;
        try{
            request = FlexContext.getHttpRequest();
        }catch(Exception e){
            
        }
        if(request == null){
            return "unknown host";
        }               
        String uri = request.getRequestURI();      
        String url =  request.getRequestURL().toString();  
        result=url.substring(0, url.indexOf(uri))+request.getContextPath();
        
        return result;
    }
    /**
     * 获取访问ContextPath
     * @return
     */
    public static String getContextPath() {
        String result;
        HttpServletRequest request = null;
        try{
            request = FlexContext.getHttpRequest();
        }catch(Exception e){
            
        }
        if(request == null){
            return "unknown host";
        }        
        result =  request.getSession().getServletContext().getRealPath("/");        
        return result;
    }
    
    /**
     * 获取访问host
     * @return
     */
    public static String getRequestHost() {
        String result;
        HttpServletRequest request = null;
        try{
            request = FlexContext.getHttpRequest();
        }catch(Exception e){
            
        }
        if(request == null){
            return "unknown host";
        }               
        String uri = request.getRequestURI();      
        String url =  request.getRequestURL().toString();  
        result=url.substring(0, url.indexOf(uri));
        
        return result;
    }
}
