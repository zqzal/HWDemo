package com.obs.services.model;

/**
 * 特殊操作符，代表要操作的子资源
 */
public enum SpecialParamEnum
{
    
    /**
     * 获取桶区域位置信息
     */
    LOCATION("location"),
    /**
     * 获取桶存量信息
     */
    STORAGEINFO("storageinfo"),
    /**
     * 获取/设置桶配额
     */
    QUOTA("quota"),
    /**
     * 获取/设置桶（对象）设置访问权限
     */
    ACL("acl"),
    /**
     * 获取/设置桶日志管理配置
     */
    LOGGING("logging"),
    /**
     * 获取/设置/删除桶策略
     */
    POLICY("policy"),
    /**
     * 获取/设置/删除桶的生命周期规则
     */
    LIFECYCLE("lifecycle"),
    /**
     * 获取/设置/删除桶的托管配置
     */
    WEBSITE("website"),
    /**
     * 获取/设置桶的多版本状态
     */
    VERSIONING("versioning"),
    /**
     * 获取/设置桶的存储策略
     */
    @Deprecated
    STORAGEPOLICY("storagePolicy"),
    /**
     * 获取/设置桶的存储类型
     */
    STORAGECLASS("storageClass"),
    /**
     * 获取/设置/删除桶的跨域资源共享配置
     */
    CORS("cors"),
    /**
     * 列举/初始化分段上传任务
     */
    UPLOADS("uploads"),
    /**
     * 列举桶内多版本对象
     */
    VERSIONS("versions"),
    /**
     * 批量删除对象
     */
    DELETE("delete"),
    
    /**
     * 取回归档存储对象
     */
    RESTORE("restore"),
    
    /**
     * 设置/获取/删除桶标签
     */
    TAGGING("tagging"),
    
    /**
     * 设置/获取桶的通知配置
     */
    NOTIFICATION("notification"),
	
	/**
     * 设置/获取/删除桶的跨Region复制配置
     */
    REPLICATION("replication"),
    
    /**
     * 追加上传对象
     */
    APPEND("append"),
    
    /**
     * 重命名文件/文件夹
     */
    RENAME("rename"),
    
    /**
     * 截断文件
     */
    TRUNCATE("truncate"),
    
    /**
     * 修改文件
     */
	MODIFY("modify"),
	
	/**
	 * 设置文件网关特性
	 */
	FILEINTERFACE("fileinterface"),
	
	/**
	 * 设置/删除对象属性
	 */
	METADATA("metadata"),
	
	/**
	 * 设置/获取/删除桶的加密配置
	 */
	ENCRYPTION("encryption");
    
    /**
     * stringCode对应数据库中和外部的Code
     */
    private String stringCode;
    
    private SpecialParamEnum(String stringCode)
    {
        if (stringCode == null)
        {
            throw new IllegalArgumentException("stringCode is null");
        }
        this.stringCode = stringCode;
    }
    
    public String getStringCode()
    {
        return this.stringCode.toLowerCase();
    }
    
    public String getOriginalStringCode()
    {
        return this.stringCode;
    }
    
    public static SpecialParamEnum getValueFromStringCode(String stringCode)
    {
        if (stringCode == null)
        {
            throw new IllegalArgumentException("string code is null");
        }
        
        for (SpecialParamEnum installMode : SpecialParamEnum.values())
        {
            if (installMode.getStringCode().equals(stringCode.toLowerCase()))
            {
                return installMode;
            }
        }
        
        throw new IllegalArgumentException("string code is illegal");
    }
}
