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

import com.liferay.portal.service.persistence.BasePersistence;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;

/**
 * The persistence interface for the room service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link RoomUtil} to access the room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see RoomPersistenceImpl
 * @see RoomUtil
 * @generated
 */
public interface RoomPersistence extends BasePersistence<Room> {
	/**
	* Caches the room in the entity cache if it is enabled.
	*
	* @param room the room to cache
	*/
	public void cacheResult(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room);

	/**
	* Caches the rooms in the entity cache if it is enabled.
	*
	* @param rooms the rooms to cache
	*/
	public void cacheResult(
		java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> rooms);

	/**
	* Creates a new room with the primary key. Does not add the room to the database.
	*
	* @param roomId the primary key for the new room
	* @return the new room
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room create(int roomId);

	/**
	* Removes the room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room to remove
	* @return the room that was removed
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room remove(int roomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room updateImpl(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the room with the primary key or throws a {@link jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException} if it could not be found.
	*
	* @param roomId the primary key of the room to find
	* @return the room
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByPrimaryKey(
		int roomId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

	/**
	* Finds the room with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roomId the primary key of the room to find
	* @return the room, or <code>null</code> if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room fetchByPrimaryKey(
		int roomId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the rooms where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room[] findByGroupId_PrevAndNext(
		int roomId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

	/**
	* Finds all the rooms where name = &#63;.
	*
	* @param name the name to search with
	* @return the matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room[] findByName_PrevAndNext(
		int roomId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

	/**
	* Finds all the rooms where available = &#63;.
	*
	* @param available the available to search with
	* @return the matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByAvailable(
		boolean available)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByAvailable(
		boolean available, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findByAvailable(
		boolean available, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByAvailable_First(
		boolean available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room findByAvailable_Last(
		boolean available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

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
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room[] findByAvailable_PrevAndNext(
		int roomId, boolean available,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;

	/**
	* Finds all the rooms.
	*
	* @return the rooms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rooms where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rooms where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rooms where available = &#63; from the database.
	*
	* @param available the available to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAvailable(boolean available)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rooms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the rooms where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the rooms where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the rooms where available = &#63;.
	*
	* @param available the available to search with
	* @return the number of matching rooms
	* @throws SystemException if a system exception occurred
	*/
	public int countByAvailable(boolean available)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the rooms.
	*
	* @return the number of rooms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}