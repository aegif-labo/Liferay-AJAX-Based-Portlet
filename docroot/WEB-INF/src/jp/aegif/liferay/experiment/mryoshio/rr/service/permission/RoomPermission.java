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

package jp.aegif.liferay.experiment.mryoshio.rr.service.permission;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @see com.liferay.portlet.documentlibrary.service.permission.DLFolderPermission
 * @author ashitaba.yoshioka@aegif.jp
 */
public class RoomPermission {

	public static boolean contains(PermissionChecker permissionChecker,
			Room room, long userId, String actionId) throws PortalException,
			SystemException {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
				permissionChecker, room.getGroupId(), Room.class.getName(),
				room.getRoomId(), "room", actionId);

		if (hasPermission != null) {
			_log.debug("hasPermission is null.");
			return hasPermission.booleanValue();
		}

		if (actionId.equals(ActionKeys.VIEW)) {
			_log.debug("true because action is VIEW.");
			return true;
		} else {
			if (permissionChecker.hasOwnerPermission(room.getCompanyId(),
					Room.class.getName(), room.getRoomId(), userId, actionId)) {
				_log.debug("true because hasOwnerPermission.");
				return true;
			}

			if (permissionChecker.hasPermission(room.getGroupId(),
					Room.class.getName(), room.getRoomId(), actionId)) {
				_log.debug("true because hasPermission.");
				return true;
			}
		}
		_log.debug("false because no permission is given.");
		return false;
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, long roomId, long userId, String actionId)
			throws PortalException, SystemException {

		Room room = RoomLocalServiceUtil.getRoom((int) roomId);

		return contains(permissionChecker, room, userId, actionId);
	}

	private static Log _log = LogFactoryUtil.getLog(RoomPermission.class);
}