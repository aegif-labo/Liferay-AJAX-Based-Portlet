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
 * The utility for the reservation local service. This utility wraps {@link jp.aegif.liferay.experiment.mryoshio.rr.service.impl.ReservationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link jp.aegif.liferay.experiment.mryoshio.rr.service.impl.ReservationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see ReservationLocalService
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.base.ReservationLocalServiceBaseImpl
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.impl.ReservationLocalServiceImpl
 * @generated
 */
public class ReservationLocalServiceUtil {
	/**
	* Adds the reservation to the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to add
	* @return the reservation that was added
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation addReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addReservation(reservation);
	}

	/**
	* Creates a new reservation with the primary key. Does not add the reservation to the database.
	*
	* @param reservationId the primary key for the new reservation
	* @return the new reservation
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation createReservation(
		int reservationId) {
		return getService().createReservation(reservationId);
	}

	/**
	* Deletes the reservation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the reservation to delete
	* @throws PortalException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteReservation(int reservationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteReservation(reservationId);
	}

	/**
	* Deletes the reservation from the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteReservation(reservation);
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
	* Gets the reservation with the primary key.
	*
	* @param reservationId the primary key of the reservation to get
	* @return the reservation
	* @throws PortalException if a reservation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation getReservation(
		int reservationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getReservation(reservationId);
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
	public static java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation> getReservations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getReservations(start, end);
	}

	/**
	* Gets the number of reservations.
	*
	* @return the number of reservations
	* @throws SystemException if a system exception occurred
	*/
	public static int getReservationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getReservationsCount();
	}

	/**
	* Updates the reservation in the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to update
	* @return the reservation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation updateReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateReservation(reservation);
	}

	/**
	* Updates the reservation in the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the reservation to update
	* @param merge whether to merge the reservation with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the reservation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation updateReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateReservation(reservation, merge);
	}

	public static void addReservation(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation rsv,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addReservation(rsv, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ReservationLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ReservationLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ReservationLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ReservationLocalService service) {
		_service = service;
	}

	private static ReservationLocalService _service;
}