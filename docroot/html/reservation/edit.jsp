<%--
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
--%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@include file="/html/init.jsp"%>

<%
	Reservation reservation = null;
	int reservationId = Integer.valueOf(ParamUtil.getString(request,
			"entityId"));
	Calendar beginCalendar = Calendar.getInstance();
	Calendar endCalendar = Calendar.getInstance();
	if (reservationId > 0) {
		reservation = ReservationLocalServiceUtil
				.getReservation(reservationId);
		beginCalendar.setTime(reservation.getBeginTime());
		beginCalendar.setTime(reservation.getEndTime());
	}

	List<Room> rooms = RoomLocalServiceUtil.getRooms(0,
			RoomLocalServiceUtil.getRoomsCount());
%>

<liferay-ui:header title="reservation-add-update" />
<aui:model-context bean="<%=reservation %>"
	model="<%=Reservation.class %>" />


<aui:form name="updateForm" useNamespace="true"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="reservationId"
			value='<%= reservation == null? "0":reservation.getReservationId() %>' />

		<aui:select name="roomId" showEmptyOption="<%= false %>"
			label="reservation-room">

			<%
				for (Room room : rooms) {
			%>
			<aui:option value="<%= room.getRoomId() %>"
				selected="<%= reservation != null && reservation.getRoomId() == room.getRoomId() %>"><%=room.getName()%></aui:option>
			<%
				}
			%>

		</aui:select>

		<aui:input name="beginTime" value="<%= beginCalendar %>"
			label="reservation-beginTime" />

		<aui:input name="endTime" value="<%= endCalendar %>"
			label="reservation-endTime" />

		<aui:input type="textarea" name="note"
			value="<%=reservation==null? "": String.valueOf(reservation.getNote()) %>"
			size="10" label="reservation-note" last="true" />

		<aui:input type="hidden" name="userId"
			value="<%=themeDisplay.getUserId()%>"></aui:input>

	</aui:fieldset>
	<aui:button-row>
		<aui:button name="doAddUpdateReservation"
			value="reservation-add-update-execute" />
		<aui:button type="cancel" name="cancel" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
	AUI().ready(
			'aui-node',
			function(A) {
				A.get("#<portlet:namespace />doAddUpdateReservation").on(
						"click", function() {
							<portlet:namespace/>_updateReservation();
						});
				A.get("#<portlet:namespace />cancel").on("click", function() {
					<portlet:namespace/>_showJspInPanel('list-view');
				});
			});
</script>