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
	
	boolean deletable = false;
    boolean updatable = false;
    if (permissionChecker.isCompanyAdmin(reservation.getCompanyId())
            || permissionChecker.isCommunityAdmin(reservation.getGroupId())
            || permissionChecker.isCommunityOwner(reservation.getGroupId())) {
        updatable = deletable = true;
    } else {
        updatable = permissionChecker.hasOwnerPermission(
                reservation.getCompanyId(), Reservation.class.getName(), reservationId,
                reservation.getOwnerId(), ActionKeys.UPDATE);
        deletable = permissionChecker.hasOwnerPermission(
                reservation.getCompanyId(), Reservation.class.getName(), reservationId,
                reservation.getOwnerId(), ActionKeys.DELETE);
    }
%>



<liferay-ui:icon-menu>

	<c:if test="<%= updatable %>">
		<liferay-ui:icon image="edit" message="reservation-show-update"
			url="<%= updateUrl.toString() %>" />
	</c:if>

	<c:if test="<%= deletable %>">
		<liferay-ui:icon image="delete" message="reservation-show-delete"
			url="<%= confirmUrl.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>
