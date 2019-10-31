package com.obs.services.model;

/**
 * 列举桶内多版本对象的请求参数
 */
public class ListVersionsRequest
{
    private String bucketName;
    
    private String prefix;
    
    private String keyMarker;
    
    private String versionIdMarker;
    
    private int maxKeys;
    
    private String delimiter;
    
    private int listTimeout;
    
    public ListVersionsRequest()
    {
    }
    
    /**
     * 构造函数
     * 
     *  @param bucketName 桶名
     */
    public ListVersionsRequest(String bucketName)
    {
        this.bucketName = bucketName;
    }
    
    
    /**
     * 构造函数
     * @param bucketName 桶名
     * @param maxKeys 列举多版本对象的最大条目数
     */
    public ListVersionsRequest(String bucketName, int maxKeys)
    {
        this.bucketName = bucketName;
        this.maxKeys = maxKeys;
    }

    /**     
     *  构造函数 
     *  @param bucketName 桶名
     *  @param prefix 列举多版本对象对象时的对象名前缀
     *  @param keyMarker 列举多版本对象时的起始位置
     *  @param delimiter 用于对多版本对象名进行分组的字符
     *  @param maxKeys 列举多版本对象的最大条目数
     */
    public ListVersionsRequest(String bucketName, String prefix, String keyMarker, String delimiter, int maxKeys)
    {
        this.bucketName = bucketName;
        this.prefix = prefix;
        this.keyMarker = keyMarker;
        this.delimiter = delimiter;
        this.maxKeys = maxKeys;
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
     */
    public void setBucketName(String bucketName)
    {
        this.bucketName = bucketName;
    }
    
    /**
     * 获取列举多版本对象时的对象名前缀
     * 
     * @return 对象名前缀
     */
    public String getPrefix()
    {
        return prefix;
    }
    
    /**
     * 设置列举多版本对象时的对象名前缀
     * 
     * @param prefix 对象名前缀
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
    
    /**
     * 获取列举多版本对象的最大条目数
     * 
     * @return 列举多版本对象的最大条目数
     */
    public int getMaxKeys()
    {
        return maxKeys;
    }
    
    /**
     * 设置列举多版本对象的最大条目数
     * 
     * @param maxKeys 列举多版本对象的最大条目数
     */
    public void setMaxKeys(int maxKeys)
    {
        this.maxKeys = maxKeys;
    }
    
    /**
     * 获取用于对多版本对象名进行分组的字符
     * 
     * @return 分组字符
     */
    public String getDelimiter()
    {
        return delimiter;
    }
    
    /**
     * 设置用于对多版本对象名进行分组的字符
     * 
     * @param delimiter 分组字符
     */
    public void setDelimiter(String delimiter)
    {
        this.delimiter = delimiter;
    }
    
	/**
	 * 获取列举多版本对象的起始位置（versionId标识）
	 * @return 列举多版本对象的起始位置
	 */
	public String getVersionIdMarker() {
		return versionIdMarker;
	}

	/**
	 * 设置列举多版本对象的起始位置（versionId标识）
	 * @param versionIdMarker 列举多版本对象的起始位置
	 */
	public void setVersionIdMarker(String versionIdMarker) {
		this.versionIdMarker = versionIdMarker;
	}

	/**
	 * 获取列举多版本对象的起始位置
	 * @return 列举多版本对象的起始位置
	 */
	public String getKeyMarker() {
		return keyMarker;
	}

	/**
	 * 设置列举多版本对象的起始位置
	 * @param keyMarker 列举多版本对象的起始位置
	 */
	public void setKeyMarker(String keyMarker) {
		this.keyMarker = keyMarker;
	}
	
    public int getListTimeout() {
		return listTimeout;
	}

	public void setListTimeout(int listTimeout) {
		this.listTimeout = listTimeout;
	}

	@Override
	public String toString() {
		return "ListVersionsRequest [bucketName=" + bucketName + ", prefix=" + prefix + ", keyMarker=" + keyMarker
				+ ", versionIdMarker=" + versionIdMarker + ", maxKeys=" + maxKeys + ", delimiter=" + delimiter
				+ ", listTimeout=" + listTimeout + "]";
	}

	
}
