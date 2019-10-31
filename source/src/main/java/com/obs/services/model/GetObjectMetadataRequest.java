package com.obs.services.model;

/**
 * 获取对象属性的请求参数
 */
public class GetObjectMetadataRequest
{
    private String bucketName;
    
    private String objectKey;
    
    private String versionId;
    
    private SseCHeader sseCHeader;
    
    public GetObjectMetadataRequest(){
        
    }
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     */
    public GetObjectMetadataRequest(String bucketName, String objectKey)
    {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
    }

    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     * @param versionId 对象的版本号
     */
    public GetObjectMetadataRequest(String bucketName, String objectKey, String versionId)
    {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.versionId = versionId;
    }



    /**
     * 获取SSE-C解密头域信息
     * 
     * @return SSE-C解密头域信息
     */
    public SseCHeader getSseCHeader()
    {
        return sseCHeader;
    }
    
    /**
     * 设置SSE-C解密头域信息
     * 
     * @param sseCHeader SSE-C解密头域信息
     */
    public void setSseCHeader(SseCHeader sseCHeader)
    {
        this.sseCHeader = sseCHeader;
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
     * @return 对象名
     */
    public String getObjectKey()
    {
        return objectKey;
    }
    
    /**
     * 设置对象名
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

    @Override
    public String toString()
    {
        return "GetObjectMetadataRequest [bucketName=" + bucketName + ", objectKey=" + objectKey + ", versionId=" + versionId
            + ", sseCHeader=" + sseCHeader + "]";
    }
    
}
