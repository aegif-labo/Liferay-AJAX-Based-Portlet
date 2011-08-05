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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author ashitaba.yoshioka@aegif.jp
 */
public class RoomClp extends BaseModelImpl<Room> implements Room {
	public RoomClp() {
	}

	public int getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(int pk) {
		setRoomId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_roomId);
	}

	public int getRoomId() {
		return _roomId;
	}

	public void setRoomId(int roomId) {
		_roomId = roomId;
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

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getCapacity() {
		return _capacity;
	}

	public void setCapacity(int capacity) {
		_capacity = capacity;
	}

	public boolean getAvailable() {
		return _available;
	}

	public boolean isAvailable() {
		return _available;
	}

	public void setAvailable(boolean available) {
		_available = available;
	}

	public Room toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Room)Proxy.newProxyInstance(Room.class.getClassLoader(),
				new Class[] { Room.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		RoomClp clone = new RoomClp();

		clone.setRoomId(getRoomId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setOwnerId(getOwnerId());
		clone.setName(getName());
		clone.setCapacity(getCapacity());
		clone.setAvailable(getAvailable());

		return clone;
	}

	public int compareTo(Room room) {
		int value = 0;

		value = getName().compareTo(room.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RoomClp room = null;

		try {
			room = (RoomClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = room.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{roomId=");
		sb.append(getRoomId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", capacity=");
		sb.append(getCapacity());
		sb.append(", available=");
		sb.append(getAvailable());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("jp.aegif.liferay.experiment.mryoshio.rr.model.Room");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
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
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>available</column-name><column-value><![CDATA[");
		sb.append(getAvailable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _roomId;
	private long _companyId;
	private long _groupId;
	private long _ownerId;
	private String _name;
	private int _capacity;
	private boolean _available;
}