package com.fastgood.web.incpt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.fastgood.dsl.util.AjaxResult;
import com.fastgood.dsl.util.StringUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final List<String> IGNORE_URI = new ArrayList<String>();
	private static final List<String> IGNORE_BEFORE_URI = new ArrayList<String>();
	
	/**
	 * 不需要拦截的接口声明
	 */
	static {
		IGNORE_URI.add("/");
		IGNORE_URI.add("/login");
		IGNORE_URI.add("/logout");
		IGNORE_URI.add("/register");
		IGNORE_URI.add("/user/login");
		IGNORE_BEFORE_URI.add("/public");
	}
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String uri = request.getRequestURI();
        String webRoot = request.getServletContext().getContextPath();
        if(!StringUtil.isBlank(webRoot)) uri = uri.replace(webRoot,"");
        if(IGNORE_URI.contains(uri)) {
        	//do nothing 
        	return true;
        }
    	for (String subUri : IGNORE_BEFORE_URI) {
			if(uri.startsWith(subUri)) return true;
		}
        //validate 
        boolean flag = true;
        //需要判断Session是否有用户登录信息
        HttpSession session = request.getSession(false);
        if(session !=null && session.getAttribute("name") != null)
        	flag = false;
        if(!flag) {
        	//验证不通过，返回错误信息
        	AjaxResult<Object> result = AjaxResult.newErrorResult("please login.");
        	result.setLoginStatus(0);
        	response.getWriter().write(JSONObject.toJSONString(result));
        	return false;
        }
    	//success do noting
    	return true;
    }
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}
 
}
