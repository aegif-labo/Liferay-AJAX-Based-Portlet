<%--
/**
 * Copyright (c) 2011 Aegif Corporation. All rights reserved.
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
<script type="text/javascript">
	function <portlet:namespace/>_showJspInPanel(type, entityId) {
		var url;
		url = '<portlet:resourceURL id="_RESOURCE_ID_"><portlet:param name="entityId" value="_ENTITY_ID_" /></portlet:resourceURL>';
		url = url.replace("_RESOURCE_ID_", type);
		url = url.replace("_ENTITY_ID_", entityId);
		<portlet:namespace/>showJspInPanel("<portlet:namespace/>", "mainPanel",
				url);
	}

	function <portlet:namespace/>showJspInPanel(ns, panelid, url) {
		var fqid = ns + panelid;
		AUI().use('aui-node', 'aui-panel', 'aui-io', function(A) {
			var panel = A.one("#" + fqid);
			var config = {
				method : "GET",
				headers : {
					"Content-Type" : "application/json"
				},
				on : {
					success : function(obj, txnId, res) {
						panel.setContent(res.responseText);
					},
					failure : function(obj, txnId, res) {
						console.error("[ERROR] " + res.responseText);
					}
				}
			};
			A.io.request(url, config);
		});
	}
</script>
<link type="text/css" rel="stylesheet"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css">
