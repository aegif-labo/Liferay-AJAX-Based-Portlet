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

import jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation;

import java.util.List;

/**
 * The persistence utility for the reservation service. This utility wraps {@link ReservationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see ReservationPersistence
 * @see ReservationPersistenceImpl
 * @generated
 */
public class ReservationUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Reservation reservation) {
		getPersistence().clearCache(reservation);
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
	public static List<Reservation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Reservation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Reservation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Reservation remove(Reservation reservation)
		throws SystemException {
		return getPersistence().remove(reservation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Reservation update(Reservation reservation, boolean merge)
		throws SystemException {
		return getPersistence().update(reservation, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Reservation update(Reservation reservation, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(reservation, merge, serviceContext);
	}

	/**
	* Caches the reservation in the entity cache if it is enabled.
	*
	* @param reservation the reservation to cache
	*/
	public static void cacheResult(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation) {
		getPersistence().cacheResult(reservation);
	}

	/**
	* Caches the reservations in the entity cache if it is enabled.
	*
	* @param reservations the reservations to cache
	*/
	public static void cacheResult(
		java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> reservations) {
		getPersistence().cacheResult(reservations);
	}

	/**
	* Creates a new reservation with the primary key. Does not add the reservation to the database.
	*
	* @param reservationId the primary key for the new reservation
	* @return the new reservation
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation create(
		int reservationId) {
		return getPersistence().create(reservationId);
	}

	/**
	* Removes the reservation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the reservation to remove
	* @return the reservation that was removed
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation remove(
		int reservationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().remove(reservationId);
	}

	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation updateImpl(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(reservation, merge);
	}

	/**
	* Finds the reservation with the primary key or throws a {@link jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException} if it could not be found.
	*
	* @param reservationId the primary key of the reservation to find
	* @return the reservation
	* @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByPrimaryKey(
		int reservationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByPrimaryKey(reservationId);
	}

	/**
	* Finds the reservation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reservationId the primary key of the reservation to find
	* @return the reservation, or <code>null</code> if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation fetchByPrimaryKey(
		int reservationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reservationId);
	}

	/**
	* Finds all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByGroupId_PrevAndNext(
		int reservationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(reservationId, groupId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds all the reservations where roomId = &#63;.
	*
	* @param roomId the room id to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByRoomId(
		int roomId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomId(roomId);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByRoomId(
		int roomId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoomId(roomId, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByRoomId(
		int roomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoomId(roomId, start, end, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByRoomId_First(
		int roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByRoomId_First(roomId, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByRoomId_Last(
		int roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByRoomId_Last(roomId, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByRoomId_PrevAndNext(
		int reservationId, int roomId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByRoomId_PrevAndNext(reservationId, roomId,
			orderByComparator);
	}

	/**
	* Finds all the reservations where beginTime = &#63;.
	*
	* @param beginTime the begin time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByBeginTime(
		java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBeginTime(beginTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByBeginTime(
		java.util.Date beginTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBeginTime(beginTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByBeginTime(
		java.util.Date beginTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBeginTime(beginTime, start, end, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByBeginTime_First(
		java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByBeginTime_First(beginTime, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByBeginTime_Last(
		java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByBeginTime_Last(beginTime, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByBeginTime_PrevAndNext(
		int reservationId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByBeginTime_PrevAndNext(reservationId, beginTime,
			orderByComparator);
	}

	/**
	* Finds all the reservations where endTime = &#63;.
	*
	* @param endTime the end time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByEndTime(
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEndTime(endTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByEndTime(
		java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEndTime(endTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByEndTime(
		java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEndTime(endTime, start, end, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByEndTime_First(
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByEndTime_First(endTime, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByEndTime_Last(
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence().findByEndTime_Last(endTime, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByEndTime_PrevAndNext(
		int reservationId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByEndTime_PrevAndNext(reservationId, endTime,
			orderByComparator);
	}

	/**
	* Finds all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_U(
		long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R_U(groupId, roomId, userId);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_U(
		long groupId, int roomId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R_U(groupId, roomId, userId, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_U(
		long groupId, int roomId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_U(groupId, roomId, userId, start, end,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_U_First(
		long groupId, int roomId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_U_First(groupId, roomId, userId, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_U_Last(
		long groupId, int roomId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_U_Last(groupId, roomId, userId, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_R_U_PrevAndNext(
		int reservationId, long groupId, int roomId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_U_PrevAndNext(reservationId, groupId, roomId,
			userId, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_U(
		long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_R_U(groupId, roomId, userId);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_U(
		long groupId, int roomId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_U(groupId, roomId, userId, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_U(
		long groupId, int roomId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_U(groupId, roomId, userId, start, end,
			orderByComparator);
	}

	/**
	* Finds all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_B(
		long groupId, int roomId, java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R_B(groupId, roomId, beginTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_B(groupId, roomId, beginTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_B(groupId, roomId, beginTime, start, end,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_B_First(
		long groupId, int roomId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_B_First(groupId, roomId, beginTime,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_B_Last(
		long groupId, int roomId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_B_Last(groupId, roomId, beginTime,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_R_B_PrevAndNext(
		int reservationId, long groupId, int roomId, java.util.Date beginTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_B_PrevAndNext(reservationId, groupId, roomId,
			beginTime, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_B(
		long groupId, int roomId, java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_R_B(groupId, roomId, beginTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_B(groupId, roomId, beginTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_B(
		long groupId, int roomId, java.util.Date beginTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_B(groupId, roomId, beginTime, start, end,
			orderByComparator);
	}

	/**
	* Finds all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_E(
		long groupId, int roomId, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R_E(groupId, roomId, endTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R_E(groupId, roomId, endTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R_E(groupId, roomId, endTime, start, end,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_E_First(
		long groupId, int roomId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_E_First(groupId, roomId, endTime,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_R_E_Last(
		long groupId, int roomId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_E_Last(groupId, roomId, endTime, orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_R_E_PrevAndNext(
		int reservationId, long groupId, int roomId, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_R_E_PrevAndNext(reservationId, groupId, roomId,
			endTime, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_E(
		long groupId, int roomId, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_R_E(groupId, roomId, endTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_E(groupId, roomId, endTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_R_E(
		long groupId, int roomId, java.util.Date endTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_R_E(groupId, roomId, endTime, start, end,
			orderByComparator);
	}

	/**
	* Finds all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_B_E(groupId, beginTime, endTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_E(groupId, beginTime, endTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_E(groupId, beginTime, endTime, start, end,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_B_E_First(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_B_E_First(groupId, beginTime, endTime,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation findByG_B_E_Last(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_B_E_Last(groupId, beginTime, endTime,
			orderByComparator);
	}

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
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation[] findByG_B_E_PrevAndNext(
		int reservationId, long groupId, java.util.Date beginTime,
		java.util.Date endTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException {
		return getPersistence()
				   .findByG_B_E_PrevAndNext(reservationId, groupId, beginTime,
			endTime, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_B_E(groupId, beginTime, endTime);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_B_E(groupId, beginTime, endTime, start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> filterFindByG_B_E(
		long groupId, java.util.Date beginTime, java.util.Date endTime,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_B_E(groupId, beginTime, endTime, start, end,
			orderByComparator);
	}

	/**
	* Finds all the reservations.
	*
	* @return the reservations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the reservations where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the reservations where roomId = &#63; from the database.
	*
	* @param roomId the room id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoomId(int roomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoomId(roomId);
	}

	/**
	* Removes all the reservations where beginTime = &#63; from the database.
	*
	* @param beginTime the begin time to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBeginTime(java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBeginTime(beginTime);
	}

	/**
	* Removes all the reservations where endTime = &#63; from the database.
	*
	* @param endTime the end time to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEndTime(java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEndTime(endTime);
	}

	/**
	* Removes all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_R_U(long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_R_U(groupId, roomId, userId);
	}

	/**
	* Removes all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_R_B(long groupId, int roomId,
		java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_R_B(groupId, roomId, beginTime);
	}

	/**
	* Removes all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_R_E(long groupId, int roomId,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_R_E(groupId, roomId, endTime);
	}

	/**
	* Removes all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_B_E(long groupId, java.util.Date beginTime,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_B_E(groupId, beginTime, endTime);
	}

	/**
	* Removes all the reservations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Counts all the reservations where roomId = &#63;.
	*
	* @param roomId the room id to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoomId(int roomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoomId(roomId);
	}

	/**
	* Counts all the reservations where beginTime = &#63;.
	*
	* @param beginTime the begin time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBeginTime(java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBeginTime(beginTime);
	}

	/**
	* Counts all the reservations where endTime = &#63;.
	*
	* @param endTime the end time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEndTime(java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEndTime(endTime);
	}

	/**
	* Counts all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_R_U(long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_R_U(groupId, roomId, userId);
	}

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param userId the user id to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_R_U(long groupId, int roomId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_R_U(groupId, roomId, userId);
	}

	/**
	* Counts all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_R_B(long groupId, int roomId,
		java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_R_B(groupId, roomId, beginTime);
	}

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param beginTime the begin time to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_R_B(long groupId, int roomId,
		java.util.Date beginTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_R_B(groupId, roomId, beginTime);
	}

	/**
	* Counts all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_R_E(long groupId, int roomId,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_R_E(groupId, roomId, endTime);
	}

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param roomId the room id to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_R_E(long groupId, int roomId,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_R_E(groupId, roomId, endTime);
	}

	/**
	* Counts all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_B_E(long groupId, java.util.Date beginTime,
		java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_B_E(groupId, beginTime, endTime);
	}

	/**
	* Filters by the user's permissions and counts all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	*
	* @param groupId the group id to search with
	* @param beginTime the begin time to search with
	* @param endTime the end time to search with
	* @return the number of matching reservations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_B_E(long groupId,
		java.util.Date beginTime, java.util.Date endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_B_E(groupId, beginTime, endTime);
	}

	/**
	* Counts all the reservations.
	*
	* @return the number of reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReservationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReservationPersistence)PortletBeanLocatorUtil.locate(jp.aegif.liferay.experiment.mryoshio.rr.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ReservationPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ReservationPersistence persistence) {
		_persistence = persistence;
	}

	private static ReservationPersistence _persistence;
}