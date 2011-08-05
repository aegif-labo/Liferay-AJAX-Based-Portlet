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

import jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation;

/**
 * The persistence interface for the reservation service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ReservationUtil} to access the reservation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see ReservationPersistenceImpl
 * @see ReservationUtil
 * @generated
 */
public interface ReservationPersistence extends BasePersistence<Reservation> {
	/**
	* Caches the reservation in the entity cache if it is enabled.
	*
	* @param reservation the reservation to cache
	*/
	public void cacheResult(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation);

	/**
	* Caches the reservations in the entity cache if it is enabled.
	*
	* @param reservations the reservations to cache
	*/
	public void cacheResult(
		java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> reservations);

	/**
	* Creates a new reservation with the primary key. Does not add the reservation to the database.
	*
	* @param reservationId the primary key for the new reservation
	* @return the new reservation
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation create(
		int reservationId);

	/**
	* Removes the reservation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the reservation to remove
	* @return the reservation that was removed
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation remove(
		int reservationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation updateImpl(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the reservation with the primary key or throws a {@link jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException} if it could not be found.
	*
	* @param reservationId the primary key of the reservation to find
	* @return the reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByPrimaryKey(
		int reservationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reservationId the primary key of the reservation to find
	* @return the reservation, or <code>null</code> if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation fetchByPrimaryKey(
		int reservationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByGroupId_PrevAndNext(
		int reservationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the reservations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the reservations where roomId = &#63;.
	*
	* @param roomId the room id to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByRoomId(
		int roomId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByRoomId(
		int roomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByRoomId(
		int roomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByRoomId_First(
		int roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roomId the room id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByRoomId_Last(
		int roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where roomId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param roomId the room id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByRoomId_PrevAndNext(
		int reservationId, int roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds all the reservations where beginTime = &#63;.
	*
	* @param beginTime the begin time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByBeginTime(
		java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param beginTime the begin time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByBeginTime(
		java.util.Date beginTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param beginTime the begin time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByBeginTime(
		java.util.Date beginTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param beginTime the begin time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByBeginTime_First(
		java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param beginTime the begin time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByBeginTime_Last(
		java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param beginTime the begin time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByBeginTime_PrevAndNext(
		int reservationId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds all the reservations where endTime = &#63;.
	*
	* @param endTime the end time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByEndTime(
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByEndTime(
		java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByEndTime(
		java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByEndTime_First(
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByEndTime_Last(
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByEndTime_PrevAndNext(
		int reservationId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_U(
		long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_U(
		long groupId, int roomId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_U(
		long groupId, int roomId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_U_First(
		long groupId, int roomId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_U_Last(
		long groupId, int roomId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_R_U_PrevAndNext(
		int reservationId, long groupId, int roomId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_U(
		long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_U(
		long groupId, int roomId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_U(
		long groupId, int roomId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_B(
		long groupId, int roomId, java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_B_First(
		long groupId, int roomId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_B_Last(
		long groupId, int roomId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_R_B_PrevAndNext(
		int reservationId, long groupId, int roomId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_B(
		long groupId, int roomId, java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_E(
		long groupId, int roomId, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_E_First(
		long groupId, int roomId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_E_Last(
		long groupId, int roomId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_R_E_PrevAndNext(
		int reservationId, long groupId, int roomId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_E(
		long groupId, int roomId, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first reservation in the ordered set where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_B_E_First(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the last reservation in the ordered set where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_B_E_Last(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param reservationId the primary key of the current reservation
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_B_E_PrevAndNext(
		int reservationId, long groupId, java.util.Date beginTime,
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the reservations.
	*
	* @return the reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the reservations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @return the range of reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the reservations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of reservations to return
	* @param end the upper bound of the range of reservations to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of reservations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where roomId = &#63; from the database.
	*
	* @param roomId the room id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRoomId(int roomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where beginTime = &#63; from the database.
	*
	* @param beginTime the begin time to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBeginTime(java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where endTime = &#63; from the database.
	*
	* @param endTime the end time to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEndTime(java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_R_U(long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_R_B(long groupId, int roomId, java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_R_E(long groupId, int roomId, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_B_E(long groupId, java.util.Date beginTime,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reservations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where roomId = &#63;.
	*
	* @param roomId the room id to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByRoomId(int roomId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where beginTime = &#63;.
	*
	* @param beginTime the begin time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByBeginTime(java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where endTime = &#63;.
	*
	* @param endTime the end time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByEndTime(java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_R_U(long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_R_U(long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_R_B(long groupId, int roomId, java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_R_B(long groupId, int roomId,
		java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_R_E(long groupId, int roomId, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_R_E(long groupId, int roomId,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_B_E(long groupId, java.util.Date beginTime,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_B_E(long groupId, java.util.Date beginTime,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the reservations.
	*
	* @return the number of reservations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}