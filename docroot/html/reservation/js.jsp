
<script type="text/javascript">
	function <portlet:namespace/>_confirm(type, reservationId, reservationName) {
		var handleYes = function() {
			url = '<portlet:resourceURL id="delete-reservation"><portlet:param name="reservationId" value="_RESERVATION_ID_" /></portlet:resourceURL>';
			url = url.replace("_RESERVATION_ID_", reservationId);
			<portlet:namespace/>deleteReservation(url);
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
										bodyContent : "<liferay-ui:message key='reservation-confirm-body-delete' />",
										centered : true,
										destroyOnClose : true,
										draggable : false,
										height : 200,
										width : 200,
										resizable : false,
										stack : true,
										title : "<liferay-ui:message key='reservation-confirm-delete' />",
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

	function <portlet:namespace/>_updateReservation() {
		console.debug("#_updateReservation");
		var url;
		url = '<portlet:resourceURL id="update-reservation" />';
		<portlet:namespace/>updateReservation("<portlet:namespace/>",
				"updateForm", url);
	}

	function <portlet:namespace/>updateReservation(ns, formid, url) {
		var fqid = ns + formid;
		console.debug("#updateReservation");
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
													title : "<liferay-ui:message key='reservation-process-result' />",
													bodyContent : "<liferay-ui:message key='reservation-update-success'/>",
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
													title : "<liferay-ui:message key='reservation-process-result' />",
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
	function <portlet:namespace/>deleteReservation(url) {
		console.debug("#deleteReservation");
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
													title : "<liferay-ui:message key='reservation-process-result' />",
													bodyContent : "<liferay-ui:message key='reservation-delete-success' />",
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
													title : "<liferay-ui:message key='reservation-process-result' />",
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
