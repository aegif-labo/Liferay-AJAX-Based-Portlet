/**
 * Copyright (c) 2011 Aegif Corporation. All rights reserved.
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

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.service.base.RoomLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

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
		resourceLocalService.addResources(room.getCompanyId(),
				room.getGroupId(), userId, Room.class.getName(),
				room.getRoomId(), false, true, true);
	}

	public void deleteRoom(Room room) throws SystemException, PortalException {
		resourceLocalService.deleteResource(room.getCompanyId(),
				Room.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				room.getPrimaryKey());
		super.deleteRoom(room);
	}
}