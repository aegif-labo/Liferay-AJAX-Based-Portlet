
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
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
			scopeGroupId, "ADD_RESERVATION");
	boolean hasConfigurePermission = permissionChecker.hasPermission(
			scopeGroupId, Group.class.getName(), scopeGroupId,
			ActionKeys.PERMISSIONS);
%>

<aui:button-row>
	<c:choose>
		<c:when test='<%=hasAddPermission %>'>
			<aui:button name="showAddReservation" value="reservation-show-add" />
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
	emptyResultsMessage="reservation-empty-message">

	<liferay-ui:search-container-results
		results="<%= ReservationLocalServiceUtil.getReservations(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ReservationLocalServiceUtil.getReservationsCount() %>" />

	<liferay-ui:search-container-row
		className="jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation"
		keyProperty="reservationId" modelVar="reservation">

		<liferay-ui:search-container-column-text name="reservation-room"
			value="<%= RoomLocalServiceUtil.getRoom(reservation.getRoomId()).getName() %>" />

		<liferay-ui:search-container-column-text name="reservation-beginTime"
			property="beginTime" />

		<liferay-ui:search-container-column-text name="reservation-endTime"
			property="endTime" />

		<liferay-ui:search-container-column-text name="reservation-user"
			value="<%= UserLocalServiceUtil.getUser(reservation.getUserId()).getScreenName() %>" />


		<liferay-ui:search-container-column-jsp align="right"
			path="/html/reservation/actions.jsp" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<script type="text/javascript">
	AUI().ready(
			'aui-node',
			function(A) {
				var button = A.get("#<portlet:namespace />showAddReservation");
				if(button == null) {
				} else {
				    A.get("#<portlet:namespace />showAddReservation").on("click",
						function() { <portlet:namespace/>_showJspInPanel('add-view', 0); }
				    );
				}
			});
</script>
