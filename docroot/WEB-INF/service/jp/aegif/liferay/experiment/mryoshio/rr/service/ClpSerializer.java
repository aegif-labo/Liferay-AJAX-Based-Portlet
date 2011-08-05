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

package jp.aegif.liferay.experiment.mryoshio.rr.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import jp.aegif.liferay.experiment.mryoshio.rr.model.ReservationClp;
import jp.aegif.liferay.experiment.mryoshio.rr.model.RoomClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "roomReservation-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(RoomClp.class.getName())) {
			RoomClp oldCplModel = (RoomClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("jp.aegif.liferay.experiment.mryoshio.rr.model.impl.RoomImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRoomId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getRoomId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCapacity",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getCapacity());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setAvailable",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getAvailable());

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ReservationClp.class.getName())) {
			ReservationClp oldCplModel = (ReservationClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setReservationId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getReservationId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getGroupId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRoomId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRoomId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setBeginTime",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getBeginTime();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getEndTime();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getUserId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setNote",
							new Class[] { String.class });

					String value7 = oldCplModel.getNote();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"jp.aegif.liferay.experiment.mryoshio.rr.model.impl.RoomImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					RoomClp newModel = new RoomClp();

					Method method0 = oldModelClass.getMethod("getRoomId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setRoomId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getCapacity");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setCapacity(value4);

					Method method5 = oldModelClass.getMethod("getAvailable");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setAvailable(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ReservationClp newModel = new ReservationClp();

					Method method0 = oldModelClass.getMethod("getReservationId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setReservationId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getGroupId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value2);

					Method method3 = oldModelClass.getMethod("getRoomId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRoomId(value3);

					Method method4 = oldModelClass.getMethod("getBeginTime");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setBeginTime(value4);

					Method method5 = oldModelClass.getMethod("getEndTime");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value5);

					Method method6 = oldModelClass.getMethod("getUserId");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setUserId(value6);

					Method method7 = oldModelClass.getMethod("getNote");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setNote(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}