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

package jp.aegif.liferay.experiment.mryoshio.rr.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException;
import jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationImpl;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the reservation service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ReservationUtil} to access the reservation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ashitaba.yoshioka@aegif.jp
 * @see ReservationPersistence
 * @see ReservationUtil
 * @generated
 */
public class ReservationPersistenceImpl extends BasePersistenceImpl<Reservation>
	implements ReservationPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ReservationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROOMID = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByRoomId",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMID = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByRoomId", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_BEGINTIME = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByBeginTime",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_BEGINTIME = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByBeginTime", new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ENDTIME = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByEndTime",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ENDTIME = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByEndTime", new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_R_U = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_R_U",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_R_U = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_R_U",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_G_R_B = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_R_B",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_R_B = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_R_B",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_G_R_E = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_R_E",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_R_E = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_R_E",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_G_B_E = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByG_B_E",
			new String[] {
				Long.class.getName(), Date.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_B_E = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByG_B_E",
			new String[] {
				Long.class.getName(), Date.class.getName(), Date.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the reservation in the entity cache if it is enabled.
	 *
	 * @param reservation the reservation to cache
	 */
	public void cacheResult(Reservation reservation) {
		EntityCacheUtil.putResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey(), reservation);
	}

	/**
	 * Caches the reservations in the entity cache if it is enabled.
	 *
	 * @param reservations the reservations to cache
	 */
	public void cacheResult(List<Reservation> reservations) {
		for (Reservation reservation : reservations) {
			if (EntityCacheUtil.getResult(
						ReservationModelImpl.ENTITY_CACHE_ENABLED,
						ReservationImpl.class, reservation.getPrimaryKey(), this) == null) {
				cacheResult(reservation);
			}
		}
	}

	/**
	 * Clears the cache for all reservations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ReservationImpl.class.getName());
		EntityCacheUtil.clearCache(ReservationImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the reservation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Reservation reservation) {
		EntityCacheUtil.removeResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey());
	}

	/**
	 * Creates a new reservation with the primary key. Does not add the reservation to the database.
	 *
	 * @param reservationId the primary key for the new reservation
	 * @return the new reservation
	 */
	public Reservation create(int reservationId) {
		Reservation reservation = new ReservationImpl();

		reservation.setNew(true);
		reservation.setPrimaryKey(reservationId);

		return reservation;
	}

	/**
	 * Removes the reservation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reservation to remove
	 * @return the reservation that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Integer)primaryKey).intValue());
	}

	/**
	 * Removes the reservation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reservationId the primary key of the reservation to remove
	 * @return the reservation that was removed
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation remove(int reservationId)
		throws NoSuchReservationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Reservation reservation = (Reservation)session.get(ReservationImpl.class,
					new Integer(reservationId));

			if (reservation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + reservationId);
				}

				throw new NoSuchReservationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					reservationId);
			}

			return remove(reservation);
		}
		catch (NoSuchReservationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation removeImpl(Reservation reservation)
		throws SystemException {
		reservation = toUnwrappedModel(reservation);

		Session session = null;

		try {
			session = openSession();

			if (reservation.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ReservationImpl.class,
						reservation.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(reservation);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey());

		return reservation;
	}

	public Reservation updateImpl(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation reservation,
		boolean merge) throws SystemException {
		reservation = toUnwrappedModel(reservation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, reservation, merge);

			reservation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey(), reservation);

		return reservation;
	}

	protected Reservation toUnwrappedModel(Reservation reservation) {
		if (reservation instanceof ReservationImpl) {
			return reservation;
		}

		ReservationImpl reservationImpl = new ReservationImpl();

		reservationImpl.setNew(reservation.isNew());
		reservationImpl.setPrimaryKey(reservation.getPrimaryKey());

		reservationImpl.setReservationId(reservation.getReservationId());
		reservationImpl.setCompanyId(reservation.getCompanyId());
		reservationImpl.setGroupId(reservation.getGroupId());
		reservationImpl.setRoomId(reservation.getRoomId());
		reservationImpl.setBeginTime(reservation.getBeginTime());
		reservationImpl.setEndTime(reservation.getEndTime());
		reservationImpl.setUserId(reservation.getUserId());
		reservationImpl.setNote(reservation.getNote());

		return reservationImpl;
	}

	/**
	 * Finds the reservation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the reservation to find
	 * @return the reservation
	 * @throws com.liferay.portal.NoSuchModelException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Finds the reservation with the primary key or throws a {@link jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException} if it could not be found.
	 *
	 * @param reservationId the primary key of the reservation to find
	 * @return the reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByPrimaryKey(int reservationId)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = fetchByPrimaryKey(reservationId);

		if (reservation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + reservationId);
			}

			throw new NoSuchReservationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				reservationId);
		}

		return reservation;
	}

	/**
	 * Finds the reservation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reservation to find
	 * @return the reservation, or <code>null</code> if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Finds the reservation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reservationId the primary key of the reservation to find
	 * @return the reservation, or <code>null</code> if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation fetchByPrimaryKey(int reservationId)
		throws SystemException {
		Reservation reservation = (Reservation)EntityCacheUtil.getResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
				ReservationImpl.class, reservationId, this);

		if (reservation == null) {
			Session session = null;

			try {
				session = openSession();

				reservation = (Reservation)session.get(ReservationImpl.class,
						new Integer(reservationId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (reservation != null) {
					cacheResult(reservation);
				}

				closeSession(session);
			}
		}

		return reservation;
	}

	/**
	 * Finds all the reservations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByGroupId(groupId);

		List<Reservation> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByGroupId_PrevAndNext(int reservationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, reservation, groupId,
					orderByComparator, true);

			array[1] = reservation;

			array[2] = getByGroupId_PrevAndNext(session, reservation, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByGroupId_PrevAndNext(Session session,
		Reservation reservation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the reservations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the reservations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_FILTER_SQL_SELECT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity(_FILTER_ENTITY_ALIAS, ReservationImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Reservation>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the reservations where roomId = &#63;.
	 *
	 * @param roomId the room id to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByRoomId(int roomId) throws SystemException {
		return findByRoomId(roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByRoomId(int roomId, int start, int end)
		throws SystemException {
		return findByRoomId(roomId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByRoomId(int roomId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				roomId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOMID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOMID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByRoomId_First(int roomId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByRoomId(roomId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("roomId=");
			msg.append(roomId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roomId the room id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByRoomId_Last(int roomId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByRoomId(roomId);

		List<Reservation> list = findByRoomId(roomId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("roomId=");
			msg.append(roomId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param roomId the room id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByRoomId_PrevAndNext(int reservationId,
		int roomId, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByRoomId_PrevAndNext(session, reservation, roomId,
					orderByComparator, true);

			array[1] = reservation;

			array[2] = getByRoomId_PrevAndNext(session, reservation, roomId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByRoomId_PrevAndNext(Session session,
		Reservation reservation, int roomId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roomId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the reservations where beginTime = &#63;.
	 *
	 * @param beginTime the begin time to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByBeginTime(Date beginTime)
		throws SystemException {
		return findByBeginTime(beginTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the reservations where beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param beginTime the begin time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByBeginTime(Date beginTime, int start, int end)
		throws SystemException {
		return findByBeginTime(beginTime, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param beginTime the begin time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByBeginTime(Date beginTime, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				beginTime,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BEGINTIME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				if (beginTime == null) {
					query.append(_FINDER_COLUMN_BEGINTIME_BEGINTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_BEGINTIME_BEGINTIME_2);
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (beginTime != null) {
					qPos.add(CalendarUtil.getTimestamp(beginTime));
				}

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BEGINTIME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param beginTime the begin time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByBeginTime_First(Date beginTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByBeginTime(beginTime, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("beginTime=");
			msg.append(beginTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param beginTime the begin time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByBeginTime_Last(Date beginTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByBeginTime(beginTime);

		List<Reservation> list = findByBeginTime(beginTime, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("beginTime=");
			msg.append(beginTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param beginTime the begin time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByBeginTime_PrevAndNext(int reservationId,
		Date beginTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByBeginTime_PrevAndNext(session, reservation,
					beginTime, orderByComparator, true);

			array[1] = reservation;

			array[2] = getByBeginTime_PrevAndNext(session, reservation,
					beginTime, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByBeginTime_PrevAndNext(Session session,
		Reservation reservation, Date beginTime,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		if (beginTime == null) {
			query.append(_FINDER_COLUMN_BEGINTIME_BEGINTIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_BEGINTIME_BEGINTIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (beginTime != null) {
			qPos.add(CalendarUtil.getTimestamp(beginTime));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the reservations where endTime = &#63;.
	 *
	 * @param endTime the end time to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByEndTime(Date endTime)
		throws SystemException {
		return findByEndTime(endTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByEndTime(Date endTime, int start, int end)
		throws SystemException {
		return findByEndTime(endTime, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByEndTime(Date endTime, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				endTime,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ENDTIME,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				if (endTime == null) {
					query.append(_FINDER_COLUMN_ENDTIME_ENDTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_ENDTIME_ENDTIME_2);
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (endTime != null) {
					qPos.add(CalendarUtil.getTimestamp(endTime));
				}

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ENDTIME,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByEndTime_First(Date endTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByEndTime(endTime, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("endTime=");
			msg.append(endTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByEndTime_Last(Date endTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByEndTime(endTime);

		List<Reservation> list = findByEndTime(endTime, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("endTime=");
			msg.append(endTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByEndTime_PrevAndNext(int reservationId,
		Date endTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByEndTime_PrevAndNext(session, reservation, endTime,
					orderByComparator, true);

			array[1] = reservation;

			array[2] = getByEndTime_PrevAndNext(session, reservation, endTime,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByEndTime_PrevAndNext(Session session,
		Reservation reservation, Date endTime,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		if (endTime == null) {
			query.append(_FINDER_COLUMN_ENDTIME_ENDTIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_ENDTIME_ENDTIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (endTime != null) {
			qPos.add(CalendarUtil.getTimestamp(endTime));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_U(long groupId, int roomId, long userId)
		throws SystemException {
		return findByG_R_U(groupId, roomId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_U(long groupId, int roomId, long userId,
		int start, int end) throws SystemException {
		return findByG_R_U(groupId, roomId, userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_U(long groupId, int roomId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, roomId, userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_R_U,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(5 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(5);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_R_U_GROUPID_2);

				query.append(_FINDER_COLUMN_G_R_U_ROOMID_2);

				query.append(_FINDER_COLUMN_G_R_U_USERID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roomId);

				qPos.add(userId);

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_R_U,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_R_U_First(long groupId, int roomId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByG_R_U(groupId, roomId, userId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roomId=");
			msg.append(roomId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_R_U_Last(long groupId, int roomId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByG_R_U(groupId, roomId, userId);

		List<Reservation> list = findByG_R_U(groupId, roomId, userId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roomId=");
			msg.append(roomId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByG_R_U_PrevAndNext(int reservationId,
		long groupId, int roomId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByG_R_U_PrevAndNext(session, reservation, groupId,
					roomId, userId, orderByComparator, true);

			array[1] = reservation;

			array[2] = getByG_R_U_PrevAndNext(session, reservation, groupId,
					roomId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByG_R_U_PrevAndNext(Session session,
		Reservation reservation, long groupId, int roomId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		query.append(_FINDER_COLUMN_G_R_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_U_ROOMID_2);

		query.append(_FINDER_COLUMN_G_R_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roomId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @return the matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_U(long groupId, int roomId,
		long userId) throws SystemException {
		return filterFindByG_R_U(groupId, roomId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_U(long groupId, int roomId,
		long userId, int start, int end) throws SystemException {
		return filterFindByG_R_U(groupId, roomId, userId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_U(long groupId, int roomId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_R_U(groupId, roomId, userId, start, end,
				orderByComparator);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_FILTER_SQL_SELECT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_R_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_U_ROOMID_2);

			query.append(_FINDER_COLUMN_G_R_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity(_FILTER_ENTITY_ALIAS, ReservationImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(roomId);

			qPos.add(userId);

			return (List<Reservation>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_B(long groupId, int roomId,
		Date beginTime) throws SystemException {
		return findByG_R_B(groupId, roomId, beginTime, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_B(long groupId, int roomId,
		Date beginTime, int start, int end) throws SystemException {
		return findByG_R_B(groupId, roomId, beginTime, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_B(long groupId, int roomId,
		Date beginTime, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, roomId, beginTime,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_R_B,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(5 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(5);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_R_B_GROUPID_2);

				query.append(_FINDER_COLUMN_G_R_B_ROOMID_2);

				if (beginTime == null) {
					query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_2);
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roomId);

				if (beginTime != null) {
					qPos.add(CalendarUtil.getTimestamp(beginTime));
				}

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_R_B,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_R_B_First(long groupId, int roomId,
		Date beginTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByG_R_B(groupId, roomId, beginTime, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roomId=");
			msg.append(roomId);

			msg.append(", beginTime=");
			msg.append(beginTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_R_B_Last(long groupId, int roomId,
		Date beginTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByG_R_B(groupId, roomId, beginTime);

		List<Reservation> list = findByG_R_B(groupId, roomId, beginTime,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roomId=");
			msg.append(roomId);

			msg.append(", beginTime=");
			msg.append(beginTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByG_R_B_PrevAndNext(int reservationId,
		long groupId, int roomId, Date beginTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByG_R_B_PrevAndNext(session, reservation, groupId,
					roomId, beginTime, orderByComparator, true);

			array[1] = reservation;

			array[2] = getByG_R_B_PrevAndNext(session, reservation, groupId,
					roomId, beginTime, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByG_R_B_PrevAndNext(Session session,
		Reservation reservation, long groupId, int roomId, Date beginTime,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		query.append(_FINDER_COLUMN_G_R_B_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_B_ROOMID_2);

		if (beginTime == null) {
			query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roomId);

		if (beginTime != null) {
			qPos.add(CalendarUtil.getTimestamp(beginTime));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @return the matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_B(long groupId, int roomId,
		Date beginTime) throws SystemException {
		return filterFindByG_R_B(groupId, roomId, beginTime, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_B(long groupId, int roomId,
		Date beginTime, int start, int end) throws SystemException {
		return filterFindByG_R_B(groupId, roomId, beginTime, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_B(long groupId, int roomId,
		Date beginTime, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_R_B(groupId, roomId, beginTime, start, end,
				orderByComparator);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_FILTER_SQL_SELECT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_R_B_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_B_ROOMID_2);

			if (beginTime == null) {
				query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity(_FILTER_ENTITY_ALIAS, ReservationImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(roomId);

			if (beginTime != null) {
				qPos.add(CalendarUtil.getTimestamp(beginTime));
			}

			return (List<Reservation>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_E(long groupId, int roomId, Date endTime)
		throws SystemException {
		return findByG_R_E(groupId, roomId, endTime, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_E(long groupId, int roomId,
		Date endTime, int start, int end) throws SystemException {
		return findByG_R_E(groupId, roomId, endTime, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_R_E(long groupId, int roomId,
		Date endTime, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, roomId, endTime,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_R_E,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(5 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(5);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_R_E_GROUPID_2);

				query.append(_FINDER_COLUMN_G_R_E_ROOMID_2);

				if (endTime == null) {
					query.append(_FINDER_COLUMN_G_R_E_ENDTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_R_E_ENDTIME_2);
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roomId);

				if (endTime != null) {
					qPos.add(CalendarUtil.getTimestamp(endTime));
				}

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_R_E,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_R_E_First(long groupId, int roomId,
		Date endTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByG_R_E(groupId, roomId, endTime, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roomId=");
			msg.append(roomId);

			msg.append(", endTime=");
			msg.append(endTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_R_E_Last(long groupId, int roomId, Date endTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByG_R_E(groupId, roomId, endTime);

		List<Reservation> list = findByG_R_E(groupId, roomId, endTime,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roomId=");
			msg.append(roomId);

			msg.append(", endTime=");
			msg.append(endTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByG_R_E_PrevAndNext(int reservationId,
		long groupId, int roomId, Date endTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByG_R_E_PrevAndNext(session, reservation, groupId,
					roomId, endTime, orderByComparator, true);

			array[1] = reservation;

			array[2] = getByG_R_E_PrevAndNext(session, reservation, groupId,
					roomId, endTime, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByG_R_E_PrevAndNext(Session session,
		Reservation reservation, long groupId, int roomId, Date endTime,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		query.append(_FINDER_COLUMN_G_R_E_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_E_ROOMID_2);

		if (endTime == null) {
			query.append(_FINDER_COLUMN_G_R_E_ENDTIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_R_E_ENDTIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roomId);

		if (endTime != null) {
			qPos.add(CalendarUtil.getTimestamp(endTime));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @return the matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_E(long groupId, int roomId,
		Date endTime) throws SystemException {
		return filterFindByG_R_E(groupId, roomId, endTime, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_E(long groupId, int roomId,
		Date endTime, int start, int end) throws SystemException {
		return filterFindByG_R_E(groupId, roomId, endTime, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_R_E(long groupId, int roomId,
		Date endTime, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_R_E(groupId, roomId, endTime, start, end,
				orderByComparator);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_FILTER_SQL_SELECT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_R_E_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_E_ROOMID_2);

			if (endTime == null) {
				query.append(_FINDER_COLUMN_G_R_E_ENDTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_R_E_ENDTIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity(_FILTER_ENTITY_ALIAS, ReservationImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(roomId);

			if (endTime != null) {
				qPos.add(CalendarUtil.getTimestamp(endTime));
			}

			return (List<Reservation>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @return the matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_B_E(long groupId, Date beginTime,
		Date endTime) throws SystemException {
		return findByG_B_E(groupId, beginTime, endTime, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_B_E(long groupId, Date beginTime,
		Date endTime, int start, int end) throws SystemException {
		return findByG_B_E(groupId, beginTime, endTime, start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByG_B_E(long groupId, Date beginTime,
		Date endTime, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, beginTime, endTime,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_B_E,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(5 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(5);
				}

				query.append(_SQL_SELECT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_B_E_GROUPID_2);

				if (beginTime == null) {
					query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_2);
				}

				if (endTime == null) {
					query.append(_FINDER_COLUMN_G_B_E_ENDTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_B_E_ENDTIME_2);
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ReservationModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (beginTime != null) {
					qPos.add(CalendarUtil.getTimestamp(beginTime));
				}

				if (endTime != null) {
					qPos.add(CalendarUtil.getTimestamp(endTime));
				}

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_B_E,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first reservation in the ordered set where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_B_E_First(long groupId, Date beginTime,
		Date endTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByG_B_E(groupId, beginTime, endTime, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", beginTime=");
			msg.append(beginTime);

			msg.append(", endTime=");
			msg.append(endTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last reservation in the ordered set where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a matching reservation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByG_B_E_Last(long groupId, Date beginTime,
		Date endTime, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByG_B_E(groupId, beginTime, endTime);

		List<Reservation> list = findByG_B_E(groupId, beginTime, endTime,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", beginTime=");
			msg.append(beginTime);

			msg.append(", endTime=");
			msg.append(endTime);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the reservations before and after the current reservation in the ordered set where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current reservation
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next reservation
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchReservationException if a reservation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByG_B_E_PrevAndNext(int reservationId,
		long groupId, Date beginTime, Date endTime,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByG_B_E_PrevAndNext(session, reservation, groupId,
					beginTime, endTime, orderByComparator, true);

			array[1] = reservation;

			array[2] = getByG_B_E_PrevAndNext(session, reservation, groupId,
					beginTime, endTime, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByG_B_E_PrevAndNext(Session session,
		Reservation reservation, long groupId, Date beginTime, Date endTime,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		query.append(_FINDER_COLUMN_G_B_E_GROUPID_2);

		if (beginTime == null) {
			query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_2);
		}

		if (endTime == null) {
			query.append(_FINDER_COLUMN_G_B_E_ENDTIME_1);
		}
		else {
			query.append(_FINDER_COLUMN_G_B_E_ENDTIME_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (beginTime != null) {
			qPos.add(CalendarUtil.getTimestamp(beginTime));
		}

		if (endTime != null) {
			qPos.add(CalendarUtil.getTimestamp(endTime));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @return the matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_B_E(long groupId, Date beginTime,
		Date endTime) throws SystemException {
		return filterFindByG_B_E(groupId, beginTime, endTime,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_B_E(long groupId, Date beginTime,
		Date endTime, int start, int end) throws SystemException {
		return filterFindByG_B_E(groupId, beginTime, endTime, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> filterFindByG_B_E(long groupId, Date beginTime,
		Date endTime, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_B_E(groupId, beginTime, endTime, start, end,
				orderByComparator);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_FILTER_SQL_SELECT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_B_E_GROUPID_2);

			if (beginTime == null) {
				query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_2);
			}

			if (endTime == null) {
				query.append(_FINDER_COLUMN_G_B_E_ENDTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_B_E_ENDTIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity(_FILTER_ENTITY_ALIAS, ReservationImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (beginTime != null) {
				qPos.add(CalendarUtil.getTimestamp(beginTime));
			}

			if (endTime != null) {
				qPos.add(CalendarUtil.getTimestamp(endTime));
			}

			return (List<Reservation>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the reservations.
	 *
	 * @return the reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the reservations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @return the range of reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the reservations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of reservations to return
	 * @param end the upper bound of the range of reservations to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of reservations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_RESERVATION);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_RESERVATION.concat(ReservationModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Reservation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Reservation>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Reservation>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the reservations where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Reservation reservation : findByGroupId(groupId)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where roomId = &#63; from the database.
	 *
	 * @param roomId the room id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRoomId(int roomId) throws SystemException {
		for (Reservation reservation : findByRoomId(roomId)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where beginTime = &#63; from the database.
	 *
	 * @param beginTime the begin time to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBeginTime(Date beginTime) throws SystemException {
		for (Reservation reservation : findByBeginTime(beginTime)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where endTime = &#63; from the database.
	 *
	 * @param endTime the end time to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEndTime(Date endTime) throws SystemException {
		for (Reservation reservation : findByEndTime(endTime)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_R_U(long groupId, int roomId, long userId)
		throws SystemException {
		for (Reservation reservation : findByG_R_U(groupId, roomId, userId)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_R_B(long groupId, int roomId, Date beginTime)
		throws SystemException {
		for (Reservation reservation : findByG_R_B(groupId, roomId, beginTime)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_R_E(long groupId, int roomId, Date endTime)
		throws SystemException {
		for (Reservation reservation : findByG_R_E(groupId, roomId, endTime)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_B_E(long groupId, Date beginTime, Date endTime)
		throws SystemException {
		for (Reservation reservation : findByG_B_E(groupId, beginTime, endTime)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the reservations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Reservation reservation : findAll()) {
			remove(reservation);
		}
	}

	/**
	 * Counts all the reservations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the reservations where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = new StringBundler(2);

			query.append(_FILTER_SQL_COUNT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the reservations where roomId = &#63;.
	 *
	 * @param roomId the room id to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoomId(int roomId) throws SystemException {
		Object[] finderArgs = new Object[] { roomId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the reservations where beginTime = &#63;.
	 *
	 * @param beginTime the begin time to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBeginTime(Date beginTime) throws SystemException {
		Object[] finderArgs = new Object[] { beginTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BEGINTIME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				if (beginTime == null) {
					query.append(_FINDER_COLUMN_BEGINTIME_BEGINTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_BEGINTIME_BEGINTIME_2);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (beginTime != null) {
					qPos.add(CalendarUtil.getTimestamp(beginTime));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BEGINTIME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the reservations where endTime = &#63;.
	 *
	 * @param endTime the end time to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEndTime(Date endTime) throws SystemException {
		Object[] finderArgs = new Object[] { endTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ENDTIME,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				if (endTime == null) {
					query.append(_FINDER_COLUMN_ENDTIME_ENDTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_ENDTIME_ENDTIME_2);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (endTime != null) {
					qPos.add(CalendarUtil.getTimestamp(endTime));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENDTIME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_R_U(long groupId, int roomId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, roomId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_R_U,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_R_U_GROUPID_2);

				query.append(_FINDER_COLUMN_G_R_U_ROOMID_2);

				query.append(_FINDER_COLUMN_G_R_U_USERID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roomId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_R_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param userId the user id to search with
	 * @return the number of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_R_U(long groupId, int roomId, long userId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_R_U(groupId, roomId, userId);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = new StringBundler(4);

			query.append(_FILTER_SQL_COUNT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_R_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_U_ROOMID_2);

			query.append(_FINDER_COLUMN_G_R_U_USERID_2);

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(roomId);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_R_B(long groupId, int roomId, Date beginTime)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, roomId, beginTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_R_B,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_R_B_GROUPID_2);

				query.append(_FINDER_COLUMN_G_R_B_ROOMID_2);

				if (beginTime == null) {
					query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_2);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roomId);

				if (beginTime != null) {
					qPos.add(CalendarUtil.getTimestamp(beginTime));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_R_B,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and beginTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param beginTime the begin time to search with
	 * @return the number of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_R_B(long groupId, int roomId, Date beginTime)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_R_B(groupId, roomId, beginTime);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = new StringBundler(4);

			query.append(_FILTER_SQL_COUNT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_R_B_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_B_ROOMID_2);

			if (beginTime == null) {
				query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_R_B_BEGINTIME_2);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(roomId);

			if (beginTime != null) {
				qPos.add(CalendarUtil.getTimestamp(beginTime));
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_R_E(long groupId, int roomId, Date endTime)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, roomId, endTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_R_E,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_R_E_GROUPID_2);

				query.append(_FINDER_COLUMN_G_R_E_ROOMID_2);

				if (endTime == null) {
					query.append(_FINDER_COLUMN_G_R_E_ENDTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_R_E_ENDTIME_2);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roomId);

				if (endTime != null) {
					qPos.add(CalendarUtil.getTimestamp(endTime));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_R_E,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the reservations where groupId = &#63; and roomId = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param roomId the room id to search with
	 * @param endTime the end time to search with
	 * @return the number of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_R_E(long groupId, int roomId, Date endTime)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_R_E(groupId, roomId, endTime);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = new StringBundler(4);

			query.append(_FILTER_SQL_COUNT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_R_E_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_E_ROOMID_2);

			if (endTime == null) {
				query.append(_FINDER_COLUMN_G_R_E_ENDTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_R_E_ENDTIME_2);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(roomId);

			if (endTime != null) {
				qPos.add(CalendarUtil.getTimestamp(endTime));
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @return the number of matching reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_B_E(long groupId, Date beginTime, Date endTime)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, beginTime, endTime };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_B_E,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_RESERVATION_WHERE);

				query.append(_FINDER_COLUMN_G_B_E_GROUPID_2);

				if (beginTime == null) {
					query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_2);
				}

				if (endTime == null) {
					query.append(_FINDER_COLUMN_G_B_E_ENDTIME_1);
				}
				else {
					query.append(_FINDER_COLUMN_G_B_E_ENDTIME_2);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (beginTime != null) {
					qPos.add(CalendarUtil.getTimestamp(beginTime));
				}

				if (endTime != null) {
					qPos.add(CalendarUtil.getTimestamp(endTime));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_B_E,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the reservations where groupId = &#63; and beginTime = &#63; and endTime = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param beginTime the begin time to search with
	 * @param endTime the end time to search with
	 * @return the number of matching reservations that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_B_E(long groupId, Date beginTime, Date endTime)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_B_E(groupId, beginTime, endTime);
		}

		Session session = null;

		try {
			session = openSession();

			StringBundler query = new StringBundler(4);

			query.append(_FILTER_SQL_COUNT_RESERVATION_WHERE);

			query.append(_FINDER_COLUMN_G_B_E_GROUPID_2);

			if (beginTime == null) {
				query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_B_E_BEGINTIME_2);
			}

			if (endTime == null) {
				query.append(_FINDER_COLUMN_G_B_E_ENDTIME_1);
			}
			else {
				query.append(_FINDER_COLUMN_G_B_E_ENDTIME_2);
			}

			String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
					Reservation.class.getName(), _FILTER_COLUMN_PK,
					_FILTER_COLUMN_USERID, groupId);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (beginTime != null) {
				qPos.add(CalendarUtil.getTimestamp(beginTime));
			}

			if (endTime != null) {
				qPos.add(CalendarUtil.getTimestamp(endTime));
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the reservations.
	 *
	 * @return the number of reservations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESERVATION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the reservation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Reservation>> listenersList = new ArrayList<ModelListener<Reservation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Reservation>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = RoomPersistence.class)
	protected RoomPersistence roomPersistence;
	@BeanReference(type = ReservationPersistence.class)
	protected ReservationPersistence reservationPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RESERVATION = "SELECT reservation FROM Reservation reservation";
	private static final String _SQL_SELECT_RESERVATION_WHERE = "SELECT reservation FROM Reservation reservation WHERE ";
	private static final String _SQL_COUNT_RESERVATION = "SELECT COUNT(reservation) FROM Reservation reservation";
	private static final String _SQL_COUNT_RESERVATION_WHERE = "SELECT COUNT(reservation) FROM Reservation reservation WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "reservation.groupId = ?";
	private static final String _FINDER_COLUMN_ROOMID_ROOMID_2 = "reservation.roomId = ?";
	private static final String _FINDER_COLUMN_BEGINTIME_BEGINTIME_1 = "reservation.beginTime IS NULL";
	private static final String _FINDER_COLUMN_BEGINTIME_BEGINTIME_2 = "reservation.beginTime = ?";
	private static final String _FINDER_COLUMN_ENDTIME_ENDTIME_1 = "reservation.endTime IS NULL";
	private static final String _FINDER_COLUMN_ENDTIME_ENDTIME_2 = "reservation.endTime = ?";
	private static final String _FINDER_COLUMN_G_R_U_GROUPID_2 = "reservation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_U_ROOMID_2 = "reservation.roomId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_U_USERID_2 = "reservation.userId = ?";
	private static final String _FINDER_COLUMN_G_R_B_GROUPID_2 = "reservation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_B_ROOMID_2 = "reservation.roomId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_B_BEGINTIME_1 = "reservation.beginTime IS NULL";
	private static final String _FINDER_COLUMN_G_R_B_BEGINTIME_2 = "reservation.beginTime = ?";
	private static final String _FINDER_COLUMN_G_R_E_GROUPID_2 = "reservation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_E_ROOMID_2 = "reservation.roomId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_E_ENDTIME_1 = "reservation.endTime IS NULL";
	private static final String _FINDER_COLUMN_G_R_E_ENDTIME_2 = "reservation.endTime = ?";
	private static final String _FINDER_COLUMN_G_B_E_GROUPID_2 = "reservation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_B_E_BEGINTIME_1 = "reservation.beginTime IS NULL AND ";
	private static final String _FINDER_COLUMN_G_B_E_BEGINTIME_2 = "reservation.beginTime = ? AND ";
	private static final String _FINDER_COLUMN_G_B_E_ENDTIME_1 = "reservation.endTime IS NULL";
	private static final String _FINDER_COLUMN_G_B_E_ENDTIME_2 = "reservation.endTime = ?";
	private static final String _FILTER_SQL_SELECT_RESERVATION_WHERE = "SELECT DISTINCT {reservation.*} FROM rr_Reservation reservation WHERE ";
	private static final String _FILTER_SQL_COUNT_RESERVATION_WHERE = "SELECT COUNT(DISTINCT reservation.reservationId) AS COUNT_VALUE FROM rr_Reservation reservation WHERE ";
	private static final String _FILTER_COLUMN_PK = "reservation.reservationId";
	private static final String _FILTER_COLUMN_USERID = "reservation.userId";
	private static final String _FILTER_ENTITY_ALIAS = "reservation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reservation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Reservation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Reservation exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ReservationPersistenceImpl.class);
}