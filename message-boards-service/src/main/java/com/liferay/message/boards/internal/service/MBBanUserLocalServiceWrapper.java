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

package com.liferay.message.boards.internal.service;

import com.liferay.message.boards.service.MBBanLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class MBBanUserLocalServiceWrapper extends UserLocalServiceWrapper {

	public MBBanUserLocalServiceWrapper() {
		super(null);
	}

	public MBBanUserLocalServiceWrapper(UserLocalService userLocalService) {
		super(userLocalService);
	}

	@Override
	public User deleteUser(User user) throws PortalException {
		_mbBanLocalService.deleteBansByBanUserId(user.getUserId());

		return super.deleteUser(user);
	}

	@Reference
	private MBBanLocalService _mbBanLocalService;

}