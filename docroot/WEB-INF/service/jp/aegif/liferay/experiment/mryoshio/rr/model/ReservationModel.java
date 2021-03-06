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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Reservation service. Represents a row in the &quot;rr_Reservation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a reservation model instance should use the {@link Reservation} interface instead.
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see Reservation
 * @see jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationImpl
 * @see jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationModelImpl
 * @generated
 */
public interface ReservationModel extends BaseModel<Reservation> {
	/**
	 * Gets the primary key of this reservation.
	 *
	 * @return the primary key of this reservation
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this reservation
	 *
	 * @param pk the primary key of this reservation
	 */
	public void setPrimaryKey(int pk);

	/**
	 * Gets the reservation id of this reservation.
	 *
	 * @return the reservation id of this reservation
	 */
	public int getReservationId();

	/**
	 * Sets the reservation id of this reservation.
	 *
	 * @param reservationId the reservation id of this reservation
	 */
	public void setReservationId(int reservationId);

	/**
	 * Gets the company id of this reservation.
	 *
	 * @return the company id of this reservation
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this reservation.
	 *
	 * @param companyId the company id of this reservation
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this reservation.
	 *
	 * @return the group id of this reservation
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this reservation.
	 *
	 * @param groupId the group id of this reservation
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the room id of this reservation.
	 *
	 * @return the room id of this reservation
	 */
	public int getRoomId();

	/**
	 * Sets the room id of this reservation.
	 *
	 * @param roomId the room id of this reservation
	 */
	public void setRoomId(int roomId);

	/**
	 * Gets the owner id of this reservation.
	 *
	 * @return the owner id of this reservation
	 */
	public long getOwnerId();

	/**
	 * Sets the owner id of this reservation.
	 *
	 * @param ownerId the owner id of this reservation
	 */
	public void setOwnerId(long ownerId);

	/**
	 * Gets the begin time of this reservation.
	 *
	 * @return the begin time of this reservation
	 */
	public Date getBeginTime();

	/**
	 * Sets the begin time of this reservation.
	 *
	 * @param beginTime the begin time of this reservation
	 */
	public void setBeginTime(Date beginTime);

	/**
	 * Gets the end time of this reservation.
	 *
	 * @return the end time of this reservation
	 */
	public Date getEndTime();

	/**
	 * Sets the end time of this reservation.
	 *
	 * @param endTime the end time of this reservation
	 */
	public void setEndTime(Date endTime);

	/**
	 * Gets the user id of this reservation.
	 *
	 * @return the user id of this reservation
	 */
	public long getUserId();

	/**
	 * Sets the user id of this reservation.
	 *
	 * @param userId the user id of this reservation
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this reservation.
	 *
	 * @return the user uuid of this reservation
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this reservation.
	 *
	 * @param userUuid the user uuid of this reservation
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the note of this reservation.
	 *
	 * @return the note of this reservation
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this reservation.
	 *
	 * @param note the note of this reservation
	 */
	public void setNote(String note);

	/**
	 * Gets a copy of this reservation as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Reservation toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Reservation reservation);

	public int hashCode();

	public String toString();

	public String toXmlString();
}