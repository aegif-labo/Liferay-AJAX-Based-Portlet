
<script type="text/javascript">
	function <portlet:namespace/>_confirm(type, roomId, roomName) {
		var handleYes = function() {
			url = '<portlet:resourceURL id="delete-room"><portlet:param name="roomId" value="_ROOM_ID_" /></portlet:resourceURL>';
			url = url.replace("_ROOM_ID_", roomId);
			<portlet:namespace/>deleteRoom(url);
			this.close();
		};
		AUI()
				.use(
						'aui-dialog',
						'aui-overlay-manager',
						'dd-constrain',
						function(A) {
							var d = new A.Dialog(
									{
										bodyContent : "<liferay-ui:message key='room-confirm-body-delete' />"
												+ " " + roomName,
										centered : true,
										destroyOnClose : true,
										draggable : false,
										height : 200,
										width : 200,
										resizable : false,
										stack : true,
										title : "<liferay-ui:message key='room-confirm-delete' />",
										buttons : [
												{
													text : "<liferay-ui:message key='yes' />",
													handler : handleYes
												},
												{
													text : "<liferay-ui:message key='no' />",
													handler : function() {
														this.close();
													},
													isDefault : true
												} ]
									}).render();
						});
	}

	function <portlet:namespace/>_updateRoom() {
		console.debug("#_updateRoom");
		var url;
		url = '<portlet:resourceURL id="update-room" />';
		<portlet:namespace/>updateRoom("<portlet:namespace/>", "updateForm", url);
	}

	function <portlet:namespace/>updateRoom(ns, formid, url) {
		var fqid = ns + formid;
		console.debug("#updateRoom");
		console.debug("fqid: " + fqid);
		console.debug("url: " + url);
		AUI()
				.use(
						'aui-node',
						'aui-io',
						'aui-form',
						'aui-dialog',
						function(A) {
							var form = A.one("#" + fqid);
							var config = {
								method : "POST",
								form : {
									id : fqid
								},
								on : {
									success : function(obj, txnId, res) {
										console.debug("[SUCCESS] txnId: "
												+ txnId);
										console.debug("[SUCCESS] response: "
												+ res.responseText);
										<portlet:namespace/>_showJspInPanel('list-view');
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='room-update-success'/>",
													centered : true,
													destroyOnClose : true
												}).render();

									},
									failure : function(obj, txnId, res) {
										console.debug("[FAILURE] txnId: "
												+ txnId);
										console.debug("[FAILURE] response: "
												+ res.responseText);
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='error' />"
															+ ": "
															+ res.responseText,
													destroyOnClose : true
												}).render();
									}
								}
							};
							A.io.request(url, config);
						});
	}

	/**
	 */
	function <portlet:namespace/>deleteRoom(url) {
		console.debug("#deleteRoom");
		console.debug("url: " + url);
		AUI()
				.use(
						'aui-io',
						'aui-dialog',
						function(A) {
							var config = {
								method : "POST",
								on : {
									success : function(obj, txnId, res) {
										console.debug("[SUCCESS] txnId: "
												+ txnId);
										console.debug("[SUCCESS] response: "
												+ res.responseText);
										<portlet:namespace/>_showJspInPanel('list-view');
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='room-delete-success' />",
													centered : true,
													destroyOnClose : true
												}).render();
									},
									failure : function(obj, txnId, res) {
										console.debug("[FAILURE] txnId: "
												+ txnId);
										console.debug("[FAILURE] response: "
												+ res.responseText);
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='error' />"
															+ ": "
															+ res.responseText,
													destroyOnClose : true
												}).render();
									}
								}
							};
							A.io.request(url, config);
						});
	}
</script>
