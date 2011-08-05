<script type="text/javascript">
	function <portlet:namespace/>_showJspInPanel(type, entityId) {
		console.debug("#_showJspInPanel");
		console.debug("type: " + type);
		var url;
		url = '<portlet:resourceURL id="_RESOURCE_ID_"><portlet:param name="entityId" value="_ENTITY_ID_" /></portlet:resourceURL>';
		url = url.replace("_RESOURCE_ID_", type);
		url = url.replace("_ENTITY_ID_", entityId);
		<portlet:namespace/>showJspInPanel("<portlet:namespace/>", "mainPanel", url);
	}

	function <portlet:namespace/>showJspInPanel(ns, panelid, url) {
		var fqid = ns + panelid;
		console.debug("#showJspInPanel");
		console.debug("fqid: " + fqid);
		console.debug("url: " + url);
		AUI().use(
				'aui-node',
				'aui-panel',
				'aui-io',
				function(A) {

					var panel = A.one("#" + fqid);
					var config = {
						method : "GET",
						headers : {
							"Content-Type" : "application/json"
						},
						on : {
							success : function(obj, txnId, res) {
								console.debug("[SUCCESS] txnId: " + txnId);
								//console.debug("[SUCCESS] response: "
								//		+ res.responseText);
								panel.setContent(res.responseText);
							},
							failure : function(obj, txnId, res) {
								console.debug("[FAILURE] txnId: " + txnId);
								console.debug("[FAILURE] response: "
										+ res.responseText);
							}
						}
					};
					A.io.request(url, config);
				});
	}
</script>