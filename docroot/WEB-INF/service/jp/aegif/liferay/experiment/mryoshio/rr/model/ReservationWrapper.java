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

package jp.aegif.liferay.experiment.mryoshio.rr.model;

/**
 * <p>
 * This class is a wrapper for {@link Reservation}.
 * </p>
 *
 * @author    ashitaba.yoshioka@aegif.jp
 * @see       Reservation
 * @generated
 */
public class ReservationWrapper implements Reservation {
	public ReservationWrapper(Reservation reservation) {
		_reservation = reservation;
	}

	public int getPrimaryKey() {
		return _reservation.getPrimaryKey();
	}

	public void setPrimaryKey(int pk) {
		_reservation.setPrimaryKey(pk);
	}

	public int getReservationId() {
		return _reservation.getReservationId();
	}

	public void setReservationId(int reservationId) {
		_reservation.setReservationId(reservationId);
	}

	public long getCompanyId() {
		return _reservation.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_reservation.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _reservation.getGroupId();
	}

	public void setGroupId(long groupId) {
		_reservation.setGroupId(groupId);
	}

	public int getRoomId() {
		return _reservation.getRoomId();
	}

	public void setRoomId(int roomId) {
		_reservation.setRoomId(roomId);
	}

	public long getOwnerId() {
		return _reservation.getOwnerId();
	}

	public void setOwnerId(long ownerId) {
		_reservation.setOwnerId(ownerId);
	}

	public java.util.Date getBeginTime() {
		return _reservation.getBeginTime();
	}

	public void setBeginTime(java.util.Date beginTime) {
		_reservation.setBeginTime(beginTime);
	}

	public java.util.Date getEndTime() {
		return _reservation.getEndTime();
	}

	public void setEndTime(java.util.Date endTime) {
		_reservation.setEndTime(endTime);
	}

	public long getUserId() {
		return _reservation.getUserId();
	}

	public void setUserId(long userId) {
		_reservation.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservation.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_reservation.setUserUuid(userUuid);
	}

	public java.lang.String getNote() {
		return _reservation.getNote();
	}

	public void setNote(java.lang.String note) {
		_reservation.setNote(note);
	}

	public jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation toEscapedModel() {
		return _reservation.toEscapedModel();
	}

	public boolean isNew() {
		return _reservation.isNew();
	}

	public void setNew(boolean n) {
		_reservation.setNew(n);
	}

	public boolean isCachedModel() {
		return _reservation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_reservation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _reservation.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_reservation.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _reservation.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reservation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reservation.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _reservation.clone();
	}

	public int compareTo(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation) {
		return _reservation.compareTo(reservation);
	}

	public int hashCode() {
		return _reservation.hashCode();
	}

	public java.lang.String toString() {
		return _reservation.toString();
	}

	public java.lang.String toXmlString() {
		return _reservation.toXmlString();
	}

	public Reservation getWrappedReservation() {
		return _reservation;
	}

	private Reservation _reservation;
}