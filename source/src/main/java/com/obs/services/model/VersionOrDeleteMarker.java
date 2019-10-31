package com.obs.services.model;

import java.util.Date;

/**
 * 多版本对象信息
 */
public class VersionOrDeleteMarker
{
	private String bucketName;
	
    private String key;
    
    private String versionId;
    
    private boolean isLatest;
    
    private Date lastModified;
    
    private Owner owner;
    
    private String etag;
    
    private long size;
    
    private StorageClassEnum storageClass;
    
    private boolean isDeleteMarker;
    
    private boolean appendable;
    
    
    /**
     * 
     * 构造方法
     * @param bucketName 桶名
     * @param key 对象名称
     * @param versionId 版本
     * @param isLatest 是否最新版本标识
     * @param lastModified 最后修改日期
     * @param owner 所有者
     * @param etag 对象的etag值
     * @param size 对象大小，单位：字节
     * @param storageClass 对象存储类型
     * @param isDeleteMarker 多版本对象是否已被删除
     * @param appendable 对象是否可被追加写
     */
    public VersionOrDeleteMarker(String bucketName, String key, String versionId, boolean isLatest, Date lastModified, Owner owner, String etag, long size,
            StorageClassEnum storageClass, boolean isDeleteMarker, boolean appendable)
    {
		this.bucketName = bucketName;
        this.key = key;
        this.versionId = versionId;
        this.isLatest = isLatest;
        this.lastModified = lastModified;
        this.owner = owner;
        this.etag = etag;
        this.size = size;
        this.storageClass = storageClass;
        this.isDeleteMarker = isDeleteMarker;
        this.appendable = appendable;
    }

    /**
     * 获取对象名
     * @return 对象名
     */
    public String getKey()
    {
        return key;
    }
    
    /**
     * 获取对象名
     * @return 对象名
     */
    public String getObjectKey()
    {
        return key;
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
     * 判断对象是否是最新的版本
     * @return 是否最新的版本标识
     */
    public boolean isLatest()
    {
        return isLatest;
    }
    
    
    /**
     * 获取对象最后修改日期
     * @return 最后修改日期
     */
    public Date getLastModified()
    {
        return lastModified;
    }
    
    
    /**
     * 获取对象的所有者
     * @return 对象的所有者
     */
    public Owner getOwner()
    {
        return owner;
    }
    
    /**
     * 获取对象存储类型
     * @return 对象存储类型
     */
    @Deprecated
    public String getStorageClass()
    {
        return this.storageClass != null ? this.storageClass.getCode() : null;
    }
    

    /**
     * 获取对象存储类型
     * @return 对象存储类型
     */
    public StorageClassEnum getObjectStorageClass()
    {
        return storageClass;
    }
    
    /**
     * 获取对象的etag值
     * 
     * @return 对象的etag值
     */
    public String getEtag()
    {
        return etag;
    }


    /**
     * 获取对象大小，单位：字节
     * @return 对象大小
     */
    public long getSize()
    {
        return size;
    }

    
    /**
     * 判断多版本对象是否已被删除
     * @return 对象是否被删除标识
     */
    public boolean isDeleteMarker()
    {
        return isDeleteMarker;
    }
    

    /**
     * 判断对象是否可被追加写
     * @return 对象是否可被追加写标识
     */
	public boolean isAppendable() {
		return appendable;
	}
    
    /**
     * 获取多版本对象所在的桶名
     * @return 多版本对象所在的桶名
     */
	public String getBucketName() {
		return bucketName;
	}

	@Override
	public String toString() {
		return "VersionOrDeleteMarker [bucketName=" + bucketName + ", key=" + key + ", versionId=" + versionId
				+ ", isLatest=" + isLatest + ", lastModified=" + lastModified + ", owner=" + owner + ", etag=" + etag
				+ ", size=" + size + ", storageClass=" + storageClass + ", isDeleteMarker=" + isDeleteMarker
				+ ", appendable=" + appendable + "]";
	}

}
