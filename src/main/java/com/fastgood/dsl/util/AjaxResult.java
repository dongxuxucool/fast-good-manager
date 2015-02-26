package com.fastgood.dsl.util;

import java.util.Map;

/**
 * 后端与前端交互的数据对象
 * 
 * success true/false
 * errorMsg 错误信息
 * data 成功返回的数据
 * auth 页面权限集合
 * @author zhichaoke
 *
 * @param <T>
 */
public class AjaxResult<T> {

	private boolean success;
	
	private String errorMsg;
	
	private T data;
	
	private Map<String,Integer> auth;
	
	private int loginStatus = 1;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


    /**
     * @return the auth
     */
    public Map<String, Integer> getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(Map<String, Integer> auth) {
        this.auth = auth;
    }

    /**
     * @return the loginStatus
     */
    public int getLoginStatus() {
        return loginStatus;
    }

    /**
     * @param loginStatus the loginStatus to set
     */
    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    /**
	 * 
	 * 用于参数验证时使用，直接返回一个错误的结果对象
	 * 
	 * @param errorMsg
	 * @return
	 */
	public static <T> AjaxResult<T> newErrorResult(String errorMsg) {
		AjaxResult<T> result = new AjaxResult<T>();
		result.setSuccess(false);
		result.setErrorMsg(errorMsg);
		return result;
	}

	
}
