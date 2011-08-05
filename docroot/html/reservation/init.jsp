<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page
	import="com.liferay.portal.service.PortletPreferencesLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="javax.portlet.PortletPreferences"%>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>

<%@ page import="java.util.Calendar" %>

<%@page import="jp.aegif.liferay.experiment.mryoshio.rr.model.Room"%>
<%@page import="jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation"%>
<%@page import="jp.aegif.liferay.experiment.mryoshio.rr.service.ReservationLocalServiceUtil"%>

<%@page import="jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil"%>

	

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletPreferences prefs = null;
	long ownerId = themeDisplay.getUserId();
	int ownerType = PortletKeys.PREFS_OWNER_TYPE_USER;
	
	prefs = portletPreferences;
	/* if (renderRequest == null) {
		prefs = PortletPreferencesLocalServiceUtil
				.getPortletPreferences(ownerId,ownerType,plid,portletDisplay.getp);
	} else {
		prefs = renderRequest.getPreferences();
	} */
%>
