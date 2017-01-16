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

package com.liferay.message.boards.web.internal.format;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Alejandro Tardín
 */
@Component(service = MBMessageFormatHandlerFactory.class)
public class MBMessageFormatHandlerFactory {

	@Activate
	public void activate(BundleContext bundleContext) {
		_formatHandlerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, MBMessageFormatHandler.class,
			MBMessageFormatHandler.FORMAT_KEY);
	}

	@Deactivate
	public void deactivate() {
		_formatHandlerMap.close();
	}

	public MBMessageFormatHandler provide(String format) {
		return _formatHandlerMap.getService(format);
	}

	private ServiceTrackerMap<String, MBMessageFormatHandler> _formatHandlerMap;

}