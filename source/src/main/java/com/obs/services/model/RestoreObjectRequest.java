package com.obs.services.model;

/**
*
* 取回归档存储对象的请求参数
*
*/
public class RestoreObjectRequest
{
    /**
     * 快速取回，取回耗时1~5分钟
     */
	@Deprecated
    public static final String EXPEDITED = "Expedited";
    
    /**
     * 标准取回，取回耗时3~5小时
     */
	@Deprecated
    public static final String STANDARD = "Standard";
    
    /**
     * 批量取回，取回耗时5~12小时
     */
	@Deprecated
    public static final String BULK = "Bulk";
    
    /**
     * 
     * 归档存储对象状态
     *
     */
    public static class RestoreObjectStatus extends HeaderResponse
    {   
        
        private int code;
        /**
         * 对象已取回，可以下载
         */
        public static final RestoreObjectStatus AVALIABLE = new RestoreObjectStatus(200);
        /**
         * 对象正在取回，不能下载
         */
        public static final RestoreObjectStatus INPROGRESS = new RestoreObjectStatus(202);
        
        private RestoreObjectStatus(int code)
        {
            this.code = code;
        }
        
        /**
         * 获取对象状态码
         * @return 对象状态码
         */
        public int getCode()
        {
            return this.code;
        }
        
        public static RestoreObjectStatus valueOf(int retCode)
        {
            return retCode == 200 ? AVALIABLE : retCode == 202 ? INPROGRESS : new RestoreObjectStatus(retCode);
        }
    }
    
    private String bucketName;
    
    private String objectKey;
    
    private String versionId;
    
    private int days;
    
    private RestoreTierEnum tier;
    
    public RestoreObjectRequest()
    {
        
    }
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     * @param days 对象取回后保存时间
     */
    public RestoreObjectRequest(String bucketName, String objectKey, int days)
    {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.days = days;
    }
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     * @param versionId 对象版本号
     * @param days 对象取回后保存时间
     */
    public RestoreObjectRequest(String bucketName, String objectKey, String versionId, int days)
    {
        this(bucketName, objectKey, days);
        this.versionId = versionId;
    }
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     * @param versionId 对象版本号
     * @param days 对象取回后保存时间
     * @param tier 取回选项
     */
    @Deprecated
    public RestoreObjectRequest(String bucketName, String objectKey, String versionId, int days, String tier)
    {
        this(bucketName, objectKey, versionId, days);
        this.tier = RestoreTierEnum.getValueFromCode(tier);
    }
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     * @param versionId 对象版本号
     * @param days 对象取回后保存时间
     * @param tier 取回选项
     */
    public RestoreObjectRequest(String bucketName, String objectKey, String versionId, int days, RestoreTierEnum tier)
    {
        this(bucketName, objectKey, versionId, days);
        this.tier = tier;
    }
    
    /**
     * 获取桶名
     * @return 桶名
     */
    public String getBucketName()
    {
        return bucketName;
    }
    
    /**
     * 设置桶名
     * @param bucketName 桶名
     */
    public void setBucketName(String bucketName)
    {
        this.bucketName = bucketName;
    }
    
    /**
     * 获取对象名
     * 
     * @return 对象名
     */
    public String getObjectKey()
    {
        return objectKey;
    }
    
    /**
     * 设置对象名
     * 
     * @param objectKey 对象名
     */
    public void setObjectKey(String objectKey)
    {
        this.objectKey = objectKey;
    }
    
    /**
     * 获取对象版本号
     * @return 对象版本号
     */
    public String getVersionId()
    {
        return versionId;
    }
    
    /**
     * 设置对象版本号
     * @param versionId 对象版本号
     */
    public void setVersionId(String versionId)
    {
        this.versionId = versionId;
    }
    
    /**
     * 获取对象取回后保存时间，单位：天，最小值为1，最大值为30
     * @return 对象取回后保存时间
     */
    public int getDays()
    {
        return days;
    }
    
    /**
     * 设置对象取回后保存时间，单位：天，最小值为1，最大值为30
     * @param days 对象取回后保存时间
     */
    public void setDays(int days)
    {
        this.days = days;
    }
    
    /**
     * 获取取回选项.
     * @see #getRestoreTier()
     * @return 取回选项
     */
    @Deprecated
    public String getTier()
    {
        return this.tier != null ? this.tier.getCode() : null;
    }
    
    /**
     * 设置取回选项.
     * @see #setRestoreTier(RestoreTierEnum tier)
     * @param tier 取回选项
     */
    @Deprecated
    public void setTier(String tier)
    {
        this.tier = RestoreTierEnum.getValueFromCode(tier);
    }
    
    /**
     * 获取取回选项.
     * @return 取回选项
     */
    public RestoreTierEnum getRestoreTier()
    {
        return tier;
    }
    
    /**
     * 设置取回选项.
     * @param tier 取回选项
     */
    public void setRestoreTier(RestoreTierEnum tier)
    {
        this.tier = tier;
    }

    @Override
    public String toString()
    {
        return "RestoreObjectRequest [bucketName=" + bucketName + ", objectKey=" + objectKey + ", versionId=" + versionId + ", days=" + days
            + ", tier=" + tier + "]";
    }
}
