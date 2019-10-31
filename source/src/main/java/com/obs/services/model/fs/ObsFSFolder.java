package com.obs.services.model.fs;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.internal.utils.ServiceUtils;
import com.obs.services.model.PutObjectResult;
import com.obs.services.model.StorageClassEnum;
import com.obs.services.model.TaskProgressStatus;

/**
 * 支持文件接口的桶中的文件夹
 *
 */
public class ObsFSFolder extends PutObjectResult{
	
	protected ObsClient innerClient;
	
	public ObsFSFolder(String bucketName, String objectKey, String etag, String versionId, StorageClassEnum storageClass,
			String objectUrl) {
		super(bucketName, objectKey, etag, versionId, storageClass, objectUrl);
	}

	/**
	 * 获取文件夹的属性
	 * @return 文件夹的属性
	 * @throws ObsException OBS SDK自定义异常，当调用接口失败、访问OBS失败时抛出该异常
	 */
	public ObsFSAttribute attribute() throws ObsException{
		this.checkInternalClient();
		return (ObsFSAttribute)this.innerClient.getObjectMetadata(this.getBucketName(), this.getObjectKey());
	}
	
	/**
	 * 重命名文件夹
	 * @param newName 新的文件夹名
	 * @return 重命名文件夹响应结果
	 * @throws ObsException OBS SDK自定义异常，当调用接口失败、访问OBS失败时抛出该异常
	 */
	public RenameResult rename(String newName) throws ObsException{
		this.checkInternalClient();
		RenameRequest request = new RenameRequest(this.getBucketName(), this.getObjectKey(), newName);
		return this.innerClient.renameFolder(request);
	}
	
	/**
	 * 删除文件夹
	 * @throws ObsException OBS SDK自定义异常，当调用接口失败、访问OBS失败时抛出该异常
	 */
	public TaskProgressStatus dropFolder() throws ObsException {
	    this.checkInternalClient();
	    DropFolderRequest request = new DropFolderRequest(this.getBucketName(), this.getObjectKey());
	    return this.innerClient.dropFolder(request);
	}
	
	protected void checkInternalClient() {
		ServiceUtils.asserParameterNotNull(this.innerClient, "ObsClient is null");
	}

	@Override
	protected void finalize() throws Throwable {
		this.innerClient = null;
		super.finalize();
	}
	
}
