package com.obs.services.internal;

import java.util.List;

import com.obs.services.model.AccessControlList;
import com.obs.services.model.BucketCors;
import com.obs.services.model.BucketEncryption;
import com.obs.services.model.BucketLoggingConfiguration;
import com.obs.services.model.BucketNotificationConfiguration;
import com.obs.services.model.BucketQuota;
import com.obs.services.model.BucketStoragePolicyConfiguration;
import com.obs.services.model.BucketTagInfo;
import com.obs.services.model.EventTypeEnum;
import com.obs.services.model.GroupGranteeEnum;
import com.obs.services.model.KeyAndVersion;
import com.obs.services.model.LifecycleConfiguration;
import com.obs.services.model.PartEtag;
import com.obs.services.model.ReplicationConfiguration;
import com.obs.services.model.RestoreObjectRequest;
import com.obs.services.model.StorageClassEnum;
import com.obs.services.model.WebsiteConfiguration;
import com.obs.services.model.fs.FSStatusEnum;

public interface IConvertor {

	String transCompleteMultipartUpload(List<PartEtag> parts) throws ServiceException;

	String transBucketLoction(String location) throws ServiceException;

	String transVersioningConfiguration(String bucketName, String status) throws ServiceException;

	String transLifecycleConfiguration(LifecycleConfiguration config) throws ServiceException;

	String transWebsiteConfiguration(WebsiteConfiguration config) throws ServiceException;

	String transRestoreObjectRequest(RestoreObjectRequest req) throws ServiceException;

	String transBucketQuota(BucketQuota quota) throws ServiceException;
	
	String transBucketEcryption(BucketEncryption encryption) throws ServiceException;

	String transStoragePolicy(BucketStoragePolicyConfiguration status) throws ServiceException;

	String transBucketLoggingConfiguration(BucketLoggingConfiguration c) throws ServiceException;

	String transBucketCors(BucketCors cors) throws ServiceException;

	String transAccessControlList(AccessControlList acl, boolean isBucket) throws ServiceException;
	
	String transKeyAndVersion(KeyAndVersion[] objectNameAndVersions, boolean isQuiet) throws ServiceException;

	String transBucketTagInfo(BucketTagInfo bucketTagInfo) throws ServiceException;

	String transBucketNotificationConfiguration(BucketNotificationConfiguration bucketNotificationConfiguration)
			throws ServiceException;

	String transReplicationConfiguration(ReplicationConfiguration replicationConfiguration) throws ServiceException;
	
	String transBucketFileInterface(FSStatusEnum status) throws ServiceException;
	
	String transStorageClass(StorageClassEnum storageClass);
	
	String transEventType(EventTypeEnum eventType);
	
	String transGroupGrantee(GroupGranteeEnum groupGrantee);
	
	AccessControlList transCannedAcl(String cannedAcl);
	
	
}