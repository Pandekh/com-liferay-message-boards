/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.message.boards.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.message.boards.model.MBStatsUser;
import com.liferay.message.boards.model.MBStatsUserModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MBStatsUser service. Represents a row in the &quot;MBStatsUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link MBStatsUserModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MBStatsUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBStatsUserImpl
 * @see MBStatsUser
 * @see MBStatsUserModel
 * @generated
 */
@ProviderType
public class MBStatsUserModelImpl extends BaseModelImpl<MBStatsUser>
	implements MBStatsUserModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message boards stats user model instance should use the {@link MBStatsUser} interface instead.
	 */
	public static final String TABLE_NAME = "MBStatsUser";
	public static final Object[][] TABLE_COLUMNS = {
			{ "statsUserId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "messageCount", Types.INTEGER },
			{ "lastPostDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("statsUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("messageCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPostDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table MBStatsUser (statsUserId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,messageCount INTEGER,lastPostDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table MBStatsUser";
	public static final String ORDER_BY_JPQL = " ORDER BY mbStatsUser.messageCount DESC";
	public static final String ORDER_BY_SQL = " ORDER BY MBStatsUser.messageCount DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.message.boards.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.message.boards.model.MBStatsUser"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.message.boards.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.message.boards.model.MBStatsUser"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.message.boards.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.message.boards.model.MBStatsUser"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long MESSAGECOUNT_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.message.boards.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.message.boards.model.MBStatsUser"));

	public MBStatsUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _statsUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatsUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statsUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MBStatsUser.class;
	}

	@Override
	public String getModelClassName() {
		return MBStatsUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("statsUserId", getStatsUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("messageCount", getMessageCount());
		attributes.put("lastPostDate", getLastPostDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long statsUserId = (Long)attributes.get("statsUserId");

		if (statsUserId != null) {
			setStatsUserId(statsUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer messageCount = (Integer)attributes.get("messageCount");

		if (messageCount != null) {
			setMessageCount(messageCount);
		}

		Date lastPostDate = (Date)attributes.get("lastPostDate");

		if (lastPostDate != null) {
			setLastPostDate(lastPostDate);
		}
	}

	@Override
	public long getStatsUserId() {
		return _statsUserId;
	}

	@Override
	public void setStatsUserId(long statsUserId) {
		_statsUserId = statsUserId;
	}

	@Override
	public String getStatsUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatsUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setStatsUserUuid(String statsUserUuid) {
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public int getMessageCount() {
		return _messageCount;
	}

	@Override
	public void setMessageCount(int messageCount) {
		_columnBitmask = -1L;

		if (!_setOriginalMessageCount) {
			_setOriginalMessageCount = true;

			_originalMessageCount = _messageCount;
		}

		_messageCount = messageCount;
	}

	public int getOriginalMessageCount() {
		return _originalMessageCount;
	}

	@Override
	public Date getLastPostDate() {
		return _lastPostDate;
	}

	@Override
	public void setLastPostDate(Date lastPostDate) {
		_lastPostDate = lastPostDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MBStatsUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MBStatsUser toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MBStatsUser)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MBStatsUserImpl mbStatsUserImpl = new MBStatsUserImpl();

		mbStatsUserImpl.setStatsUserId(getStatsUserId());
		mbStatsUserImpl.setGroupId(getGroupId());
		mbStatsUserImpl.setCompanyId(getCompanyId());
		mbStatsUserImpl.setUserId(getUserId());
		mbStatsUserImpl.setMessageCount(getMessageCount());
		mbStatsUserImpl.setLastPostDate(getLastPostDate());

		mbStatsUserImpl.resetOriginalValues();

		return mbStatsUserImpl;
	}

	@Override
	public int compareTo(MBStatsUser mbStatsUser) {
		int value = 0;

		if (getMessageCount() < mbStatsUser.getMessageCount()) {
			value = -1;
		}
		else if (getMessageCount() > mbStatsUser.getMessageCount()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MBStatsUser)) {
			return false;
		}

		MBStatsUser mbStatsUser = (MBStatsUser)obj;

		long primaryKey = mbStatsUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		MBStatsUserModelImpl mbStatsUserModelImpl = this;

		mbStatsUserModelImpl._originalGroupId = mbStatsUserModelImpl._groupId;

		mbStatsUserModelImpl._setOriginalGroupId = false;

		mbStatsUserModelImpl._originalUserId = mbStatsUserModelImpl._userId;

		mbStatsUserModelImpl._setOriginalUserId = false;

		mbStatsUserModelImpl._originalMessageCount = mbStatsUserModelImpl._messageCount;

		mbStatsUserModelImpl._setOriginalMessageCount = false;

		mbStatsUserModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MBStatsUser> toCacheModel() {
		MBStatsUserCacheModel mbStatsUserCacheModel = new MBStatsUserCacheModel();

		mbStatsUserCacheModel.statsUserId = getStatsUserId();

		mbStatsUserCacheModel.groupId = getGroupId();

		mbStatsUserCacheModel.companyId = getCompanyId();

		mbStatsUserCacheModel.userId = getUserId();

		mbStatsUserCacheModel.messageCount = getMessageCount();

		Date lastPostDate = getLastPostDate();

		if (lastPostDate != null) {
			mbStatsUserCacheModel.lastPostDate = lastPostDate.getTime();
		}
		else {
			mbStatsUserCacheModel.lastPostDate = Long.MIN_VALUE;
		}

		return mbStatsUserCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{statsUserId=");
		sb.append(getStatsUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", messageCount=");
		sb.append(getMessageCount());
		sb.append(", lastPostDate=");
		sb.append(getLastPostDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.message.boards.model.MBStatsUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statsUserId</column-name><column-value><![CDATA[");
		sb.append(getStatsUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageCount</column-name><column-value><![CDATA[");
		sb.append(getMessageCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPostDate</column-name><column-value><![CDATA[");
		sb.append(getLastPostDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = MBStatsUser.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			MBStatsUser.class
		};
	private long _statsUserId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private int _messageCount;
	private int _originalMessageCount;
	private boolean _setOriginalMessageCount;
	private Date _lastPostDate;
	private long _columnBitmask;
	private MBStatsUser _escapedModel;
}