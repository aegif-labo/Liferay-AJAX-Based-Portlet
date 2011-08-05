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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author ashitaba.yoshioka@aegif.jp
 */
public class ReservationClp extends BaseModelImpl<Reservation>
	implements Reservation {
	public ReservationClp() {
	}

	public int getPrimaryKey() {
		return _reservationId;
	}

	public void setPrimaryKey(int pk) {
		setReservationId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_reservationId);
	}

	public int getReservationId() {
		return _reservationId;
	}

	public void setReservationId(int reservationId) {
		_reservationId = reservationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getRoomId() {
		return _roomId;
	}

	public void setRoomId(int roomId) {
		_roomId = roomId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public Date getBeginTime() {
		return _beginTime;
	}

	public void setBeginTime(Date beginTime) {
		_beginTime = beginTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public Reservation toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Reservation)Proxy.newProxyInstance(Reservation.class.getClassLoader(),
				new Class[] { Reservation.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ReservationClp clone = new ReservationClp();

		clone.setReservationId(getReservationId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setRoomId(getRoomId());
		clone.setOwnerId(getOwnerId());
		clone.setBeginTime(getBeginTime());
		clone.setEndTime(getEndTime());
		clone.setUserId(getUserId());
		clone.setNote(getNote());

		return clone;
	}

	public int compareTo(Reservation reservation) {
		int value = 0;

		if (getRoomId() < reservation.getRoomId()) {
			value = -1;
		}
		else if (getRoomId() > reservation.getRoomId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getBeginTime(), reservation.getBeginTime());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getEndTime(), reservation.getEndTime());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ReservationClp reservation = null;

		try {
			reservation = (ReservationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = reservation.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{reservationId=");
		sb.append(getReservationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", roomId=");
		sb.append(getRoomId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", beginTime=");
		sb.append(getBeginTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reservationId</column-name><column-value><![CDATA[");
		sb.append(getReservationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginTime</column-name><column-value><![CDATA[");
		sb.append(getBeginTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _reservationId;
	private long _companyId;
	private long _groupId;
	private int _roomId;
	private long _ownerId;
	private Date _beginTime;
	private Date _endTime;
	private long _userId;
	private String _userUuid;
	private String _note;
}