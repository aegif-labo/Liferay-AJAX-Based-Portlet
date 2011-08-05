
<%
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
%>


<%@include file="/html/init.jsp"%>

<%
	boolean hasAddPermission = permissionChecker.hasPermission(
			scopeGroupId,
			"jp.aegif.liferay.experiment.mryoshio.rr.model",
			scopeGroupId, "ADD_ROOM");
	boolean hasConfigurePermission = permissionChecker.hasPermission(
			scopeGroupId, Group.class.getName(), scopeGroupId,
			ActionKeys.PERMISSIONS);
%>

<aui:button-row>
	<c:choose>
		<c:when test='<%=hasAddPermission %>'>
			<aui:button name="showAddRoom" value="room-show-add"></aui:button>
		</c:when>
	</c:choose>
	<c:if test='<%= hasConfigurePermission %>'>
		<liferay-security:permissionsURL
			modelResource="jp.aegif.liferay.experiment.mryoshio.rr.model"
			modelResourceDescription="room-top-level-actions"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL" />
		<aui:button value="permissions" onClick="<%= permissionsURL %>" />
	</c:if>
</aui:button-row>

<liferay-ui:search-container
	delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>'
	emptyResultsMessage="room-empty-message">

	<liferay-ui:search-container-results
		results="<%= RoomLocalServiceUtil.getRooms(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%=RoomLocalServiceUtil.getRoomsCount() %>" />

	<liferay-ui:search-container-row
		className="jp.aegif.liferay.experiment.mryoshio.rr.model.Room"
		keyProperty="roomId" modelVar="room">

		<liferay-ui:search-container-column-text name="name" property="name"
			orderable="<%= true %>" orderableProperty="name" />

		<liferay-ui:search-container-column-text name="room-capacity"
			property="capacity" orderable="<%= true %>"
			orderableProperty="capacity" />

		<liferay-ui:search-container-column-text name="room-available"
			property="available" />


		<liferay-ui:search-container-column-jsp align="right"
			path="/html/room/actions.jsp" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<script type="text/javascript">
	AUI().ready('aui-node', function(A) {
		A.get("#<portlet:namespace />showAddRoom").on("click", function() {
			<portlet:namespace/>_showJspInPanel('add-view', 0);
		});
	});
</script>


