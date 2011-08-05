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

package jp.aegif.liferay.experiment.mryoshio.rr.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;

import java.util.List;

/**
 * The persistence utility for the room service. This utility wraps {@link RoomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see RoomPersistence
 * @see RoomPersistenceImpl
 * @generated
 */
public class RoomUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Room room) {
		getPersistence().clearCache(room);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Room> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Room> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Room> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Room remove(Room room) throws SystemException {
		return getPersistence().remove(room);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Room update(Room room, boolean merge)
		throws SystemException {
		return getPersistence().update(room, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Room update(Room room, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(room, merge, serviceContext);
	}

	/**
	* Caches the room in the entity cache if it is enabled.
	*
	* @param room the room to cache
	*/
	public static void cacheResult(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room) {
		getPersistence().cacheResult(room);
	}

	/**
	* Caches the rooms in the entity cache if it is enabled.
	*
	* @param rooms the rooms to cache
	*/
	public static void cacheResult(
		java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> rooms) {
		getPersistence().cacheResult(rooms);
	}

	/**
	* Creates a new room with the primary key. Does not add the room to the database.
	*
	* @param roomId the primary key for the new room
	* @return the new room
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room create(
		int roomId) {
		return getPersistence().create(roomId);
	}

	/**
	* Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room to remove
	* @return the room that was removed
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room remove(
		int roomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence().remove(roomId);
	}

	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room updateImpl(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(room, merge);
	}

	/**
	* Finds the room with the primary key or throws a {@link jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException} if it could not be found.
	*
	* @param roomId the primary key of the room to find
	* @return the room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByPrimaryKey(
		int roomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence().findByPrimaryKey(roomId);
	}

	/**
	* Finds the room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roomId the primary key of the room to find
	* @return the room, or <code>null</code> if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room fetchByPrimaryKey(
		int roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(roomId);
	}

	/**
	* Finds all the rooms where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the rooms where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @return the range of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the rooms where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first room in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a matching room could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last room in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a matching room could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the rooms before and after the current room in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the primary key of the current room
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room[] findByGroupId_PrevAndNext(
		int roomId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(roomId, groupId, orderByComparator);
	}

	/**
	* Finds all the rooms where name = &#63;.
	*
	* @param name the name to search with
	* @return the matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Finds a range of all the rooms where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @return the range of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Finds an ordered range of all the rooms where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Finds the first room in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a matching room could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Finds the last room in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a matching room could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Finds the rooms before and after the current room in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the primary key of the current room
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room[] findByName_PrevAndNext(
		int roomId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence()
				   .findByName_PrevAndNext(roomId, name, orderByComparator);
	}

	/**
	* Finds all the rooms where available = &#63;.
	*
	* @param available the available to search with
	* @return the matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByAvailable(
		boolean available)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvailable(available);
	}

	/**
	* Finds a range of all the rooms where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param available the available to search with
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @return the range of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByAvailable(
		boolean available, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAvailable(available, start, end);
	}

	/**
	* Finds an ordered range of all the rooms where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param available the available to search with
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByAvailable(
		boolean available, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAvailable(available, start, end, orderByComparator);
	}

	/**
	* Finds the first room in the ordered set where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param available the available to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a matching room could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByAvailable_First(
		boolean available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence()
				   .findByAvailable_First(available, orderByComparator);
	}

	/**
	* Finds the last room in the ordered set where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param available the available to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a matching room could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByAvailable_Last(
		boolean available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence()
				   .findByAvailable_Last(available, orderByComparator);
	}

	/**
	* Finds the rooms before and after the current room in the ordered set where available = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the primary key of the current room
	* @param available the available to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Room[] findByAvailable_PrevAndNext(
		int roomId, boolean available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException {
		return getPersistence()
				   .findByAvailable_PrevAndNext(roomId, available,
			orderByComparator);
	}

	/**
	* Finds all the rooms.
	*
	* @return the rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the rooms.
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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rooms where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the rooms where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes all the rooms where available = &#63; from the database.
	*
	* @param available the available to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAvailable(boolean available)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAvailable(available);
	}

	/**
	* Removes all the rooms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the rooms where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the rooms where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Counts all the rooms where available = &#63;.
	*
	* @param available the available to search with
	* @return the number of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAvailable(boolean available)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAvailable(available);
	}

	/**
	* Counts all the rooms.
	*
	* @return the number of rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RoomPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RoomPersistence)PortletBeanLocatorUtil.locate(jp.aegif.liferay.experiment.mryoshio.rr.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					RoomPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(RoomPersistence persistence) {
		_persistence = persistence;
	}

	private static RoomPersistence _persistence;
}