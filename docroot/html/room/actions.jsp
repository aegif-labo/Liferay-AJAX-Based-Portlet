<%@include file="/html/init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Room room = (Room) row.getObject();

	long groupId = room.getGroupId();
	long roomId = room.getRoomId();
	String name = Room.class.getName();

	String ns = PortalUtil.getPortletNamespace(themeDisplay
			.getPortletDisplay().getId());

	StringBuffer confirmUrl = new StringBuffer("javascript:");
	confirmUrl.append(ns);
	confirmUrl.append("_confirm('delete-view', '");
	confirmUrl.append(String.valueOf(roomId));
	confirmUrl.append("', '");
	confirmUrl.append(room.getName());
	confirmUrl.append("')");

	StringBuffer updateUrl = new StringBuffer("javascript:");
	updateUrl.append(ns);
	updateUrl.append("_showJspInPanel('update-view', '");
	updateUrl.append(String.valueOf(roomId));
	updateUrl.append("')");

	boolean deletable = false;
	boolean updatable = false;
	if (permissionChecker.isCompanyAdmin(room.getCompanyId())
			|| permissionChecker.isCommunityAdmin(room.getGroupId())
			|| permissionChecker.isCommunityOwner(room.getGroupId())) {
		updatable = deletable = true;
	} else {
		updatable = permissionChecker.hasOwnerPermission(
				room.getCompanyId(), Room.class.getName(), roomId,
				room.getOwnerId(), ActionKeys.UPDATE);
		deletable = permissionChecker.hasOwnerPermission(
				room.getCompanyId(), Room.class.getName(), roomId,
				room.getOwnerId(), ActionKeys.DELETE);
	}
%>

<liferay-ui:icon-menu>

	<c:if test="<%= updatable %>">
		<liferay-ui:icon image="edit" message="room-show-update"
			url="<%= updateUrl.toString() %>" />
	</c:if>

	<c:if test="<%= deletable %>">
		<liferay-ui:icon image="delete" message="room-show-delete"
			url="<%= confirmUrl.toString() %>" />
	</c:if>

</liferay-ui:icon-menu>

