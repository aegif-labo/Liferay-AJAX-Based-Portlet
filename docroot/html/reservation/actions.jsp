<%@include file="/html/init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Reservation reservation = (Reservation) row.getObject();

	long groupId = reservation.getGroupId();
	long reservationId = reservation.getReservationId();
	String name = Reservation.class.getName();

	String ns = PortalUtil.getPortletNamespace(themeDisplay
			.getPortletDisplay().getId());

	StringBuffer confirmUrl = new StringBuffer("javascript:");
	confirmUrl.append(ns);
	confirmUrl.append("_confirm('delete-view', '");
	confirmUrl.append(String.valueOf(reservationId));
	confirmUrl.append("')");

	StringBuffer updateUrl = new StringBuffer("javascript:");
	updateUrl.append(ns);
	updateUrl.append("_showJspInPanel('update-view', '");
	updateUrl.append(String.valueOf(reservationId));
	updateUrl.append("')");
%>



<liferay-ui:icon-menu>

	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, reservationId, ActionKeys.UPDATE) %>">
		<liferay-ui:icon image="edit" message="reservation-show-update"
			url="<%= updateUrl.toString() %>" />
	</c:if>

	<c:if
		test="<%= permissionChecker.hasPermission(groupId, name, reservationId, ActionKeys.DELETE) %>">
		<liferay-ui:icon image="delete" message="reservation-show-delete"
			url="<%= confirmUrl.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>
