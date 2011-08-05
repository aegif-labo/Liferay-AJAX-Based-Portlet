/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package jp.aegif.liferay.experiment.mryoshio.rr.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.model.RoomClp;
import jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil;
import jp.aegif.liferay.experiment.mryoshio.rr.service.base.RoomLocalServiceBaseImpl;

/**
 * The implementation of the room local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil}
 * to access the room local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ashitaba.yoshioka@aegif.jp
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.base.RoomLocalServiceBaseImpl
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil
 */
public class RoomLocalServiceImpl extends RoomLocalServiceBaseImpl {
	public void addRoom(Room room, long userId) throws SystemException,
			PortalException {
		super.addRoom(room);
//		ResourcePermissionLocalServiceUtil.addResourcePermission(room.getCompanyId(), roo, scope, primKey, roleId, actionId)
		// NG resourceLocalService.addResource(room.getCompanyId(),
		// Room.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL,String.valueOf(room.getRoomId()));
		resourceLocalService.addResources(room.getCompanyId(),
				room.getGroupId(), userId, Room.class.getName(),
				room.getPrimaryKey(), false, true, true);
		System.err.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		// resourceLocalService.addResources(room.getCompanyId(),
		// room.getGroupId(), userId, Room.class.getName(),
		// room.getRoomId(), false, true, true);
		// NG resourceLocalService.addModelResources(room.getCompanyId(),
		// room.getGroupId(), userId,
		// Room.class.getName(), room.getRoomId(),null, null);
	}

	public void deleteRoom(Room room) throws SystemException, PortalException {
		resourceLocalService.deleteResource(room.getCompanyId(),
				Room.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				room.getPrimaryKey());
		super.deleteRoom(room);
	}
}