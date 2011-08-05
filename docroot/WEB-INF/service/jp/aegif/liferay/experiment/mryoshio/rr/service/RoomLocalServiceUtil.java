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

package jp.aegif.liferay.experiment.mryoshio.rr.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the room local service. This utility wraps {@link jp.aegif.liferay.experiment.mryoshio.rr.service.impl.RoomLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link jp.aegif.liferay.experiment.mryoshio.rr.service.impl.RoomLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see RoomLocalService
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.base.RoomLocalServiceBaseImpl
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.impl.RoomLocalServiceImpl
 * @generated
 */
public class RoomLocalServiceUtil {
	/**
	* Adds the room to the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to add
	* @return the room that was added
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room addRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRoom(room);
	}

	/**
	* Creates a new room with the primary key. Does not add the room to the database.
	*
	* @param roomId the primary key for the new room
	* @return the new room
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room createRoom(
		int roomId) {
		return getService().createRoom(roomId);
	}

	/**
	* Deletes the room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room to delete
	* @throws PortalException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteRoom(int roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRoom(roomId);
	}

	/**
	* Deletes the room from the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRoom(room);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the room with the primary key.
	*
	* @param roomId the primary key of the room to get
	* @return the room
	* @throws PortalException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room getRoom(
		int roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRoom(roomId);
	}

	/**
	* Gets a range of all the rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @return the range of rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> getRooms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRooms(start, end);
	}

	/**
	* Gets the number of rooms.
	*
	* @return the number of rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int getRoomsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRoomsCount();
	}

	/**
	* Updates the room in the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to update
	* @return the room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room updateRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRoom(room);
	}

	/**
	* Updates the room in the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to update
	* @param merge whether to merge the room with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room updateRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRoom(room, merge);
	}

	public static void addRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addRoom(room, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static RoomLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					RoomLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new RoomLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(RoomLocalService service) {
		_service = service;
	}

	private static RoomLocalService _service;
}