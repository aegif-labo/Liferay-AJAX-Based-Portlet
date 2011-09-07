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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation;
import jp.aegif.liferay.experiment.mryoshio.rr.service.base.ReservationLocalServiceBaseImpl;

/**
 * The implementation of the reservation local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link jp.aegif.liferay.experiment.mryoshio.rr.service.ReservationLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link jp.aegif.liferay.experiment.mryoshio.rr.service.ReservationLocalServiceUtil}
 * to access the reservation local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author ashitaba.yoshioka@aegif.jp
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.base.ReservationLocalServiceBaseImpl
 * @see jp.aegif.liferay.experiment.mryoshio.rr.service.ReservationLocalServiceUtil
 */
public class ReservationLocalServiceImpl extends
		ReservationLocalServiceBaseImpl {
	public void addReservation(Reservation rsv, long userId)
			throws SystemException, PortalException {
		super.addReservation(rsv);
		resourceLocalService.addResources(rsv.getCompanyId(), rsv.getGroupId(),
				userId, Reservation.class.getName(), rsv.getReservationId(),
				false, true, true);
	}

	public void deleteReservation(Reservation rsv) throws SystemException,
			PortalException {
		resourceLocalService.deleteResource(rsv.getCompanyId(),
				Reservation.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, rsv.getPrimaryKey());
		super.deleteReservation(rsv);
	}

	public int countByRoomId(int roomId) throws SystemException {
		return reservationPersistence.findByRoomId(roomId).size();
	}
}