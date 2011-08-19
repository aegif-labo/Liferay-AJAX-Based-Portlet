package jp.aegif.liferay.experiment.mryoshio.rr;

import java.util.Enumeration;
import java.util.Iterator;

import javax.portlet.ResourceRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TemplatePortlet extends MVCPortlet {

	/**
	 * 
	 * @param req
	 */
	protected void debug(ResourceRequest req) {
		logger.debug("pId: " + PortalUtil.getPortletId(req));
		logger.debug("editJSP: " + editJSP);
		logger.debug("listJSP: " + listJSP);
		logger.debug("name: " + req.getParameter("name"));
		logger.debug("resourceId: " + req.getResourceID());
		for (Iterator<String> keys = req.getParameterMap().keySet().iterator(); keys
				.hasNext();) {
			String name = keys.next();
			logger.debug("parameter: " + name + " => " + req.getParameter(name));
		}
		for (Enumeration<String> attrNames = req.getAttributeNames(); attrNames
				.hasMoreElements();) {
			String name = attrNames.nextElement();
			logger.debug("attribute: " + name + " => " + req.getAttribute(name));
		}
		for (Enumeration<String> propNames = req.getPropertyNames(); propNames
				.hasMoreElements();) {
			String name = propNames.nextElement();
			logger.debug("property: " + name + " => " + req.getProperty(name));
		}
	}

	protected Log logger;
	protected String listJSP;
	protected String ERR_NO_TYPE_SPECIFIED = "[ERROR] Action type is not specifiled.";
}
