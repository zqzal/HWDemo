package com.obs.services.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OEF异常信息
 *
 */
public class OefExceptionMessage {
	@JsonProperty(value = "message")
	private String message;
	
	@JsonProperty(value = "code")
	private String code;
	
	@JsonProperty(value = "request_id")
	private String request_id;
	
	public OefExceptionMessage() {
		
	}
	
	/**
	 * 构造函数
	 * @param message 错误信息
	 * @param code 错误码
	 * @param request_id 请求ID
	 */
	public OefExceptionMessage(String message, String code, String request_id) {
		this.message = message;
		this.code = code;
		this.request_id = request_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	
	@Override
    public String toString()
    {
        return "OefExceptionMessage [message=" + message + ", code=" + code + ", request_id" + request_id + "]";
    }
}
