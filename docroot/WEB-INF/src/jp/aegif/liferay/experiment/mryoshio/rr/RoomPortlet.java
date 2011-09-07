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
package jp.aegif.liferay.experiment.mryoshio.rr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.RoomImpl;
import jp.aegif.liferay.experiment.mryoshio.rr.service.ReservationLocalServiceUtil;
import jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class Room
 */
public class RoomPortlet extends TemplatePortlet {

	public void init() throws PortletException {
		logger = LogFactoryUtil.getLog(RoomPortlet.class);
		super.init();
	}

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res)
			throws IOException, PortletException {

		if (logger.isDebugEnabled())
			debug(req);

		try {
			String rid = req.getResourceID();
			PortletBag pbag = PortletBagPool.get(PortalUtil.getPortletId(req));
			String ajaxResponse = null;

			if ("add-view".equals(rid) || "update-view".equals(rid)) {
				ajaxResponse = PortalUtil.renderPage(pbag.getServletContext(),
						PortalUtil.getHttpServletRequest(req),
						PortalUtil.getHttpServletResponse(res), editJSP, false);
			} else if ("list-view".equals(rid)) {
				ajaxResponse = getListDataAsJson(
						Integer.parseInt(req.getParameter("itemPerPage")),
						Integer.parseInt(req.getParameter("targetPage")));
			} else if ("update-room".equals(rid)) {
				updateRoom(req);
			} else if ("delete-room".equals(rid)) {
				deleteRoom(req);
			} else {
				ajaxResponse = ERR_NO_TYPE_SPECIFIED;
			}
			PrintWriter writer = res.getWriter();
			writer.write(ajaxResponse);
			writer.flush();
			writer.close();
		} catch (ServletException e) {
			throw new PortletException(e);
		}
	}

	private String getListDataAsJson(int itemPerPage, int targetPage)
			throws PortletException {
		JSONObject ret = new JSONObject();
		try {
			/*
			 * TODO imporove to use itemPerPage, targetPage parameters.
			 */
			// int start = itemPerPage * (targetPage - 1); List<Room> rooms =
			// RoomLocalServiceUtil.getRooms(start, start + itemPerPage);
			//
			List<Room> rooms = RoomLocalServiceUtil.getRooms(0,
					RoomLocalServiceUtil.getRoomsCount());
			JSONArray jr = new JSONArray();
			for (Iterator<Room> i = rooms.iterator(); i.hasNext();) {
				JSONObject j = new JSONObject();
				Room r = i.next();
				j.put("id", r.getRoomId());
				j.put("name", r.getName());
				j.put("available", r.getAvailable());
				j.put("capacity", r.getCapacity());
				jr.put(j);
			}
			ret.put("data", jr);
		} catch (Exception e) {
			throw new PortletException(ERR_SEARCH_ROOM + ": " + e);
		}
		logger.debug("return json: " + ret);
		return ret.toString();
	}

	private void deleteRoom(ResourceRequest req) throws PortletException {
		try {
			int roomId = Integer.valueOf(req.getParameter("roomId"));

			if (ReservationLocalServiceUtil.countByRoomId(roomId) > 0) {
				throw new PortletException(ERR_DELETE_ROOM);
			} else {
				RoomLocalServiceUtil.deleteRoom(roomId);
			}
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void updateRoom(ResourceRequest req) throws PortletException {
		Room room = roomFromRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			if (room.getRoomId() > 0) {
				logger.debug("Update room: " + room);
				RoomLocalServiceUtil.updateRoom(room);
			} else if (room.getRoomId() == 0) {
				logger.debug("Create room: " + room);
				RoomLocalServiceUtil.addRoom(room, userId);
			} else {
				throw new PortletException(ERR_ILLEGAL_ROOM_SPECIFIED);
			}
		} catch (SystemException e) {
			throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}

	private Room roomFromRequest(ResourceRequest req) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		RoomImpl room = new RoomImpl();
		room.setRoomId(ParamUtil.getInteger(req, "roomId"));
		room.setCompanyId(PortalUtil.getCompanyId(req));
		room.setGroupId(themeDisplay.getScopeGroupId());
		room.setName(ParamUtil.getString(req, "name"));
		room.setCapacity(ParamUtil.getInteger(req, "capacity"));
		room.setAvailable(ParamUtil.getBoolean(req, "available"));
		room.setOwnerId(themeDisplay.getUserId());

		return room;
	}

	private static final String ERR_ILLEGAL_ROOM_SPECIFIED = "[ERROR] Room id is illegal.";
	private static final String ERR_SEARCH_ROOM = "[ERROR] Room couldn't be searched.";
	private static final String ERR_DELETE_ROOM = "[ERROR] Room couldn't be deleted.";

}
