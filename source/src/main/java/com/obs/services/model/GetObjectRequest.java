package com.obs.services.model;

import java.util.Date;
import java.util.Map;

import com.obs.services.internal.ObsConstraint;

/**
 * 下载对象的请求参数
 */
public class GetObjectRequest
{
    private String bucketName;
    
    private String objectKey;
    
    private Long rangeStart;
    
    private Long rangeEnd;
    
    private String versionId;
    
    private ObjectRepleaceMetadata replaceMetadata;
    
    private SseCHeader sseCHeader;
    
    private Date ifModifiedSince;
    
    private Date ifUnmodifiedSince;
    
    private String ifMatchTag;
    
    private String ifNoneMatchTag;
    
    private String imageProcess;
    
    private ProgressListener progressListener;
    
    private long progressInterval = ObsConstraint.DEFAULT_PROGRESS_INTERVAL;
    
    private Map<String, String> requestParameters;
    
    public GetObjectRequest(){
        
    }
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param objectKey 对象名
     */
    public GetObjectRequest(String bucketName, String objectKey)
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
    public GetObjectRequest(String bucketName, String objectKey, String versionId)
    {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.versionId = versionId;
    }

    /**
     * 获取下载对象时需要重写的响应头信息
     * @return 重写的响应头信息
     */
    public ObjectRepleaceMetadata getReplaceMetadata()
    {
        return replaceMetadata;
    }
    
    /**
     * 设置下载对象时需要重写的响应头信息
     * @param replaceMetadata 重写的响应头信息
     */
    public void setReplaceMetadata(ObjectRepleaceMetadata replaceMetadata)
    {
        this.replaceMetadata = replaceMetadata;
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
     * 获取下载对象的起始位置
     * 
     * @return 下载对象的起始位置
     */
    public Long getRangeStart()
    {
        return rangeStart;
    }
    
    /**
     * 设置下载对象的起始位置
     * 
     * @param rangeStart 下载对象的起始位置
     */
    public void setRangeStart(Long rangeStart)
    {
        this.rangeStart = rangeStart;
    }
    
    /**
     * 获取下载对象的结束位置
     * 
     * @return 下载对象的结束位置
     */
    public Long getRangeEnd()
    {
        return rangeEnd;
    }
    
    /**
     * 设置下载对象的结束位置
     * 
     * @param rangeEnd 下载对象的结束位置
     * 
     */
    public void setRangeEnd(Long rangeEnd)
    {
        this.rangeEnd = rangeEnd;
    }
    
    /**
     * 获取桶名
     * 
     * @return 桶名
     */
    public String getBucketName()
    {
        return bucketName;
    }
    
    /**
     * 设置桶名
     * 
     * @param bucketName 桶名
     * 
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
     * 
     */
    public void setObjectKey(String objectKey)
    {
        this.objectKey = objectKey;
    }
    
    /**
     * 获取对象的版本号
     * 
     * @return 对象的版本号
     */
    public String getVersionId()
    {
        return versionId;
    }
    
    /**
     * 设置对象的版本号
     * 
     * @param versionId 对象的版本号
     * 
     */
    public void setVersionId(String versionId)
    {
        this.versionId = versionId;
    }

    /**
     * 获取下载对象的时间条件（修改则下载），如果对象在此参数指定的时间之后有修改则进行下载，否则返回304（Not Modified）
     * 
     * @return 下载对象的时间条件
     */
    public Date getIfModifiedSince()
    {
        return ifModifiedSince;
    }
    
    /**
     * 设置下载对象的时间条件（修改则下载），如果对象在此参数指定的时间之后有修改则进行下载，否则返回304（Not Modified）
     * 
     * @param ifModifiedSince 下载对象的时间条件
     */
    public void setIfModifiedSince(Date ifModifiedSince)
    {
        this.ifModifiedSince = ifModifiedSince;
    }
    
    /**
     * 获取下载对象的时间条件（未修改则下载），如果对象在此参数指定的时间之后没有修改则进行下载，否则返回412（ 前置条件不满足）
     * 
     * @return 下载对象的时间条件
     */
    public Date getIfUnmodifiedSince()
    {
        return ifUnmodifiedSince;
    }
    
    /**
     * 设置下载对象的时间条件（未修改则下载），如果对象在此参数指定的时间之后没有修改则进行下载，否则返回412（ 前置条件不满足）
     * 
     * @param ifUnmodifiedSince 下载对象的时间条件
     */
    public void setIfUnmodifiedSince(Date ifUnmodifiedSince)
    {
        this.ifUnmodifiedSince = ifUnmodifiedSince;
    }
    
    /**
     * 获取下载对象的校验值条件（相等则下载），如果对象的etag校验值与此参数指定的值相等则进行下载。否则返回412（前置条件不满足）
     * 
     * @return 下载对象的校验值条件
     */
    public String getIfMatchTag()
    {
        return ifMatchTag;
    }
    
    /**
     * 设置下载对象的校验值条件（相等则下载），如果对象的etag校验值与此参数指定的值相等则进行下载。否则返回412（前置条件不满足）
     * 
     * @param ifMatchTag 下载对象的校验值条件
     */
    public void setIfMatchTag(String ifMatchTag)
    {
        this.ifMatchTag = ifMatchTag;
    }
    
    /**
     * 获取下载对象的校验值条件（不相等则下载），如果对象的etag校验值与此参数指定的值不相等则进行下载。否则返回304（Not Modified）
     * 
     * @return 下载对象的校验值条件
     */
    public String getIfNoneMatchTag()
    {
        return ifNoneMatchTag;
    }
    
    /**
     * 设置下载对象的校验值条件（不相等则下载），如果对象的etag校验值与此参数指定的值不相等则进行下载。否则返回304（Not Modified）
     * 
     * @param ifNoneMatchTag 下载对象的校验值条件
     * 
     */
    public void setIfNoneMatchTag(String ifNoneMatchTag)
    {
        this.ifNoneMatchTag = ifNoneMatchTag;
    }

    /**
     * 获取图片处理参数
     * @return 图片处理参数
     */
    public String getImageProcess()
    {
        return imageProcess;
    }

    /**
     * 设置图片处理参数
     * @param imageProcess 图片处理参数
     */
    public void setImageProcess(String imageProcess)
    {
        this.imageProcess = imageProcess;
    }
    
    /**
	 * 获取数据传输监听器
	 * @return 数据传输监听器
	 */
	public ProgressListener getProgressListener() {
		return progressListener;
	}

	/**
	 * 设置数据传输监听器
	 * @param progressListener 数据传输监听器
	 */
	public void setProgressListener(ProgressListener progressListener) {
		this.progressListener = progressListener;
	}
	
	/**
	 * 获取数据传输监听器回调的阈值，默认为100KB
	 * @return 数据传输监听器回调的阈值
	 */
	public long getProgressInterval() {
		return progressInterval;
	}
	
	/**
	 * 设置数据传输监听器回调的阈值，默认为100KB
	 * @param progressInterval 数据传输监听器回调的阈值
	 */
	public void setProgressInterval(long progressInterval) {
		this.progressInterval = progressInterval;
	}
	
	public Map<String, String> getRequestParameters() {
	    return this.requestParameters;
	}
	  
	public void setRequestParameters(Map<String, String> requestParameters) {
	    this.requestParameters = requestParameters;
	}

    @Override
    public String toString()
    {
        return "GetObjectRequest [bucketName=" + bucketName + ", objectKey=" + objectKey + ", rangeStart=" + rangeStart + ", rangeEnd="
            + rangeEnd + ", versionId=" + versionId + ", replaceMetadata=" + replaceMetadata + ", sseCHeader=" + sseCHeader
            + ", ifModifiedSince=" + ifModifiedSince + ", ifUnmodifiedSince=" + ifUnmodifiedSince + ", ifMatchTag=" + ifMatchTag
            + ", ifNoneMatchTag=" + ifNoneMatchTag + ", imageProcess=" + imageProcess + "]";
    }
    
}
