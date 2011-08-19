
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
<%@include file="/html/common.jsp"%>
<%@ include file="/html/reservation/js.jsp"%>

<%
	boolean hasAddPermission = permissionChecker.hasPermission(
			scopeGroupId,
			"jp.aegif.liferay.experiment.mryoshio.rr.model",
			scopeGroupId, "ADD_RESERVATION");
	boolean hasConfigurePermission = permissionChecker.hasPermission(
			scopeGroupId, Group.class.getName(), scopeGroupId,
			ActionKeys.PERMISSIONS);
%>

<script type="text/javascript">
	AUI().ready('aui-panel', function(A) {
		var panel = new A.Panel({
			visible : false
		}).render("#<portlet:namespace/>mainPanel");
		<portlet:namespace/>_showListView();
	});
</script>


<portlet:defineObjects />

<aui:button-row>
	<c:choose>
		<c:when test='<%=hasAddPermission %>'>
			<aui:button name="showAddReservation" value="reservation-show-add"></aui:button>
		</c:when>
	</c:choose>
	<c:if test='<%= hasConfigurePermission %>'>
		<liferay-security:permissionsURL
			modelResource="jp.aegif.liferay.experiment.mryoshio.rr.model"
			modelResourceDescription="reservation-top-level-actions"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL" />
		<aui:button value="permissions" onClick="<%= permissionsURL %>" />
	</c:if>
</aui:button-row>
<div id="<portlet:namespace/>mainPanel"></div>


<script type="text/javascript">
	AUI().ready(
			'aui-node',
			function(A) {
				var button = A.get("#<portlet:namespace />showAddReservation");
				if (button == null) {
				} else {
					A.get("#<portlet:namespace />showAddReservation").on(
							"click",
							function() {
								<portlet:namespace/>_showJspInPanel('add-view',
										0);
							});
				}
			});
</script>
