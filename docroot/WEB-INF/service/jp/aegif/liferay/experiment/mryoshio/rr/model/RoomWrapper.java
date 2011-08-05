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
 * This class is a wrapper for {@link Room}.
 * </p>
 *
 * @author    ashitaba.yoshioka@aegif.jp
 * @see       Room
 * @generated
 */
public class RoomWrapper implements Room {
	public RoomWrapper(Room room) {
		_room = room;
	}

	public int getPrimaryKey() {
		return _room.getPrimaryKey();
	}

	public void setPrimaryKey(int pk) {
		_room.setPrimaryKey(pk);
	}

	public int getRoomId() {
		return _room.getRoomId();
	}

	public void setRoomId(int roomId) {
		_room.setRoomId(roomId);
	}

	public long getCompanyId() {
		return _room.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_room.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _room.getGroupId();
	}

	public void setGroupId(long groupId) {
		_room.setGroupId(groupId);
	}

	public long getOwnerId() {
		return _room.getOwnerId();
	}

	public void setOwnerId(long ownerId) {
		_room.setOwnerId(ownerId);
	}

	public java.lang.String getName() {
		return _room.getName();
	}

	public void setName(java.lang.String name) {
		_room.setName(name);
	}

	public int getCapacity() {
		return _room.getCapacity();
	}

	public void setCapacity(int capacity) {
		_room.setCapacity(capacity);
	}

	public boolean getAvailable() {
		return _room.getAvailable();
	}

	public boolean isAvailable() {
		return _room.isAvailable();
	}

	public void setAvailable(boolean available) {
		_room.setAvailable(available);
	}

	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room toEscapedModel() {
		return _room.toEscapedModel();
	}

	public boolean isNew() {
		return _room.isNew();
	}

	public void setNew(boolean n) {
		_room.setNew(n);
	}

	public boolean isCachedModel() {
		return _room.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_room.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _room.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_room.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _room.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _room.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_room.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _room.clone();
	}

	public int compareTo(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room) {
		return _room.compareTo(room);
	}

	public int hashCode() {
		return _room.hashCode();
	}

	public java.lang.String toString() {
		return _room.toString();
	}

	public java.lang.String toXmlString() {
		return _room.toXmlString();
	}

	public Room getWrappedRoom() {
		return _room;
	}

	private Room _room;
}