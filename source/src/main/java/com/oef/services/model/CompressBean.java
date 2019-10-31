package com.oef.services.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件压缩策略内容
 *
 */
public class CompressBean {
	@JsonProperty(value = "status")
	private String status;
	
	@JsonProperty(value = "agency")
	private String agency;
	
    public CompressBean() {
    	
    }
	
    /**
	 * 构造函数
	 * @param status 策略状态
	 * @param agency IAM 委托名
	 */
	public CompressBean(String status, String agency) {
		this.status = status;
		this.agency = agency;
	}
	
	/**
	 * 获取策略状态
	 * @return 策略状态
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置策略状态
	 * @param status 策略状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 获取IAM 委托名
	 * @return IAM 委托名
	 */
	public String getAgency() {
		return agency;
	}
	
	/**
	 * 设置IAM 委托名
	 * @param agency IAM 委托名
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	@Override
    public String toString()
    {
        return "CompressBean [status=" + status + ", agency=" + agency + "]";
    }
}
