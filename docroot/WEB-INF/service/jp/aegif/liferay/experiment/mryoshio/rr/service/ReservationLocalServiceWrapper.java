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

/**
 * <p>
 * This class is a wrapper for {@link ReservationLocalService}.
 * </p>
 *
 * @author    ashitaba.yoshioka@aegif.jp
 * @see       ReservationLocalService
 * @generated
 */
public class ReservationLocalServiceWrapper implements ReservationLocalService {
	public ReservationLocalServiceWrapper(
		ReservationLocalService reservationLocalService) {
		_reservationLocalService = reservationLocalService;
	}

	/**
	* Adds the reservation to the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to add
	* @return the reservation that was added
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation addReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.addReservation(reservation);
	}

	/**
	* Creates a new reservation with the primary key. Does not add the reservation to the database.
	*
	* @param reservationId the primary key for the new reservation
	* @return the new reservation
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation createReservation(
		int reservationId) {
		return _reservationLocalService.createReservation(reservationId);
	}

	/**
	* Deletes the reservation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the reservation to delete
	* @throws PortalException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteReservation(int reservationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_reservationLocalService.deleteReservation(reservationId);
	}

	/**
	* Deletes the reservation from the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_reservationLocalService.deleteReservation(reservation);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the reservation with the primary key.
	*
	* @param reservationId the primary key of the reservation to get
	* @return the reservation
	* @throws PortalException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation getReservation(
		int reservationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.getReservation(reservationId);
	}

	/**
	* Gets a range of all the reservations.
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
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> getReservations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.getReservations(start, end);
	}

	/**
	* Gets the number of reservations.
	*
	* @return the number of reservations
	* @throws SystemException if a system exception occurred
	*/
	public int getReservationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.getReservationsCount();
	}

	/**
	* Updates the reservation in the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to update
	* @return the reservation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation updateReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.updateReservation(reservation);
	}

	/**
	* Updates the reservation in the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to update
	* @param merge whether to merge the reservation with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the reservation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation updateReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservationLocalService.updateReservation(reservation, merge);
	}

	public void addReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation rsv,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_reservationLocalService.addReservation(rsv, userId);
	}

	public ReservationLocalService getWrappedReservationLocalService() {
		return _reservationLocalService;
	}

	private ReservationLocalService _reservationLocalService;
}