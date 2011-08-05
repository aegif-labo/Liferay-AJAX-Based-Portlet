package jp.aegif.liferay.experiment.mryoshio.rr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.RoomImpl;
import jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil;

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
				ajaxResponse = PortalUtil.renderPage(pbag.getServletContext(),
						PortalUtil.getHttpServletRequest(req),
						PortalUtil.getHttpServletResponse(res), listJSP, false);
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

	private void deleteRoom(ResourceRequest req) throws PortletException {
		try {
			RoomLocalServiceUtil.deleteRoom(Integer.valueOf(req
					.getParameter("roomId")));
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

}
