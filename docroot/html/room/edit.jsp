
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
	Room room = null;
	int roomId = Integer.valueOf(ParamUtil.getString(request,
			"entityId"));
	if (roomId > 0)
		room = RoomLocalServiceUtil.getRoom(roomId);
%>

<liferay-ui:header title="room-add-update" />
<aui:model-context bean="<%=room %>" model="<%=Room.class %>" />


<aui:form name="updateForm" useNamespace="true"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input type="hidden" name="roomId"
			value='<%= room == null? "0":room.getRoomId() %>' />

		<aui:input type="text" name="name"
			value="<%=room==null?"":room.getName() %>" size="10" first="true" />

		<aui:input type="text" name="capacity"
			value="<%=room==null?"0": String.valueOf(room.getCapacity()) %>"
			size="5" label="room-capacity" />

		<aui:input type="checkbox" name="available"
			value="<%=room==null?true:room.getAvailable() %>" last="true"
			label="room-available" />

	</aui:fieldset>
	<aui:button-row>
		<aui:button name="doAddUpdateRoom" value="room-add-update-execute" />
		<aui:button type="cancel" name="cancel" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
    AUI().ready('aui-node', function(A) {
        A.get("#<portlet:namespace />doAddUpdateRoom").on("click", function() {
        	<portlet:namespace/>_updateRoom();
        });
        A.get("#<portlet:namespace />cancel").on("click", function() {
        	<portlet:namespace/>_showJspInPanel('list-view');
        });
    });
</script>

