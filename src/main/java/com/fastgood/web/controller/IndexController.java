package com.fastgood.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fastgood.dsl.service.UserService;
import com.fastgood.dsl.util.AjaxResult;
import com.fastgood.dsl.util.StringUtil;

@Controller
public class IndexController {

	private static Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserService userService;
	
    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("index");  
        modelAndView.addObject("message", "欢迎使用xxx" );  
        return modelAndView;  
	}
    
    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult<Long> login(@RequestParam("name") String name, 
    		@RequestParam("password") String password,
            HttpServletRequest request){
        AjaxResult<Long> results = new AjaxResult<Long>();
		try {
			//password MD5加密
//			String pw = StringUtil.md5(password);		
			long userId = userService.login(name, password);
			if( userId== 0L) return AjaxResult.newErrorResult("用户名不存在");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("user_id", userId);
			results.setSuccess(true);
			results.setData(userId);
		} catch (Exception e) {
			log.error("异常错误：",e);
			results.setSuccess(false);
			results.setErrorMsg("异常错误：" + e.getMessage());
		}
        return results;
    }
    
    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value="/logout", method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult<String> logout(HttpSession session){
        AjaxResult<String> results = new AjaxResult<String>();
        session.invalidate();       
        results.setSuccess(true);
        results.setData(null);
        return results;
    }
    
    
    /**
     * 返回已登录用户信息,目前只返回email，后续需要在丰富信息，
     * 这个接口不被拦截，任何时候可以使用。
     * @param session
     * @return
     */
    @RequestMapping(value="/user/login", method=RequestMethod.GET)
    @ResponseBody
    public AjaxResult<String> loginedUser(HttpSession session){
        AjaxResult<String> results = new AjaxResult<String>();
        String email = (String)session.getAttribute("email");
        if(StringUtil.isBlank(email)) {
            results.setSuccess(false);
        } else {
            results.setSuccess(true);
            results.setData(email);
        }
        return results;
    }
    
    
    /**
     * 注册
     * @param email
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult<String> register(@RequestParam("name") String name,
    		@RequestParam("password") String password,
    		@RequestParam("company_name")String companyName,
    		@RequestParam("type")Integer type){
        //password MD5加密
//        String pw = StringUtil.md5(password);  
        if(userService.exists(name)) {
        	return AjaxResult.newErrorResult("用户名已被占用！");
        }
        userService.save(name, password, companyName, type);
        
        AjaxResult<String> results = new AjaxResult<String>();              
        results.setSuccess(true);
        results.setData(name);
        return results;
    }
}
