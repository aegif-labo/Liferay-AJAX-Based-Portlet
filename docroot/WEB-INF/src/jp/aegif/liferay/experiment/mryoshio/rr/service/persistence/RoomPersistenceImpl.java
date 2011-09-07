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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException;
import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.RoomImpl;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.RoomModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the room service.
 * 
 * <p>
 * Never modify or reference this class directly. Always use {@link RoomUtil} to
 * access the room persistence. Modify <code>service.xml</code> and rerun
 * ServiceBuilder to regenerate this class.
 * </p>
 * 
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 * 
 * @author ashitaba.yoshioka@aegif.jp
 * @see RoomPersistence
 * @see RoomUtil
 * @generated
 */
public class RoomPersistenceImpl extends BasePersistenceImpl<Room> implements
		RoomPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = RoomImpl.class
			.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY
			+ ".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId", new String[] { Long.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByName", new String[] { String.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_AVAILABLE = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByAvailable", new String[] { Boolean.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_COUNT_BY_AVAILABLE = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAvailable", new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(
			RoomModelImpl.ENTITY_CACHE_ENABLED,
			RoomModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the room in the entity cache if it is enabled.
	 * 
	 * @param room
	 *            the room to cache
	 */
	public void cacheResult(Room room) {
		EntityCacheUtil.putResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
				RoomImpl.class, room.getPrimaryKey(), room);
	}

	/**
	 * Caches the rooms in the entity cache if it is enabled.
	 * 
	 * @param rooms
	 *            the rooms to cache
	 */
	public void cacheResult(List<Room> rooms) {
		for (Room room : rooms) {
			if (EntityCacheUtil.getResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
					RoomImpl.class, room.getPrimaryKey(), this) == null) {
				cacheResult(room);
			}
		}
	}

	/**
	 * Clears the cache for all rooms.
	 * 
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and
	 * {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by
	 * this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(RoomImpl.class.getName());
		EntityCacheUtil.clearCache(RoomImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the room.
	 * 
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and
	 * {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by
	 * this method.
	 * </p>
	 */
	public void clearCache(Room room) {
		EntityCacheUtil.removeResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
				RoomImpl.class, room.getPrimaryKey());
	}

	/**
	 * Creates a new room with the primary key. Does not add the room to the
	 * database.
	 * 
	 * @param roomId
	 *            the primary key for the new room
	 * @return the new room
	 */
	public Room create(int roomId) {
		Room room = new RoomImpl();

		room.setNew(true);
		room.setPrimaryKey(roomId);

		return room;
	}

	/**
	 * Removes the room with the primary key from the database. Also notifies
	 * the appropriate model listeners.
	 * 
	 * @param primaryKey
	 *            the primary key of the room to remove
	 * @return the room that was removed
	 * @throws com.liferay.portal.NoSuchModelException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room remove(Serializable primaryKey) throws NoSuchModelException,
			SystemException {
		return remove(((Integer) primaryKey).intValue());
	}

	/**
	 * Removes the room with the primary key from the database. Also notifies
	 * the appropriate model listeners.
	 * 
	 * @param roomId
	 *            the primary key of the room to remove
	 * @return the room that was removed
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room remove(int roomId) throws NoSuchRoomException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Room room = (Room) session.get(RoomImpl.class, new Integer(roomId));

			if (room == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + roomId);
				}

				throw new NoSuchRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY
						+ roomId);
			}

			return remove(room);
		} catch (NoSuchRoomException nsee) {
			throw nsee;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected Room removeImpl(Room room) throws SystemException {
		room = toUnwrappedModel(room);

		Session session = null;

		try {
			session = openSession();

			if (room.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(RoomImpl.class,
						room.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(room);

			session.flush();
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
				RoomImpl.class, room.getPrimaryKey());

		return room;
	}

	public Room updateImpl(
			jp.aegif.liferay.experiment.mryoshio.rr.model.Room room,
			boolean merge) throws SystemException {
		room = toUnwrappedModel(room);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, room, merge);

			room.setNew(false);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(RoomModelImpl.ENTITY_CACHE_ENABLED,
				RoomImpl.class, room.getPrimaryKey(), room);

		return room;
	}

	protected Room toUnwrappedModel(Room room) {
		if (room instanceof RoomImpl) {
			return room;
		}

		RoomImpl roomImpl = new RoomImpl();

		roomImpl.setNew(room.isNew());
		roomImpl.setPrimaryKey(room.getPrimaryKey());

		roomImpl.setRoomId(room.getRoomId());
		roomImpl.setCompanyId(room.getCompanyId());
		roomImpl.setGroupId(room.getGroupId());
		roomImpl.setOwnerId(room.getOwnerId());
		roomImpl.setName(room.getName());
		roomImpl.setCapacity(room.getCapacity());
		roomImpl.setAvailable(room.isAvailable());

		return roomImpl;
	}

	/**
	 * Finds the room with the primary key or throws a
	 * {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 * 
	 * @param primaryKey
	 *            the primary key of the room to find
	 * @return the room
	 * @throws com.liferay.portal.NoSuchModelException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByPrimaryKey(Serializable primaryKey)
			throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer) primaryKey).intValue());
	}

	/**
	 * Finds the room with the primary key or throws a
	 * {@link jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException} if it
	 * could not be found.
	 * 
	 * @param roomId
	 *            the primary key of the room to find
	 * @return the room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByPrimaryKey(int roomId) throws NoSuchRoomException,
			SystemException {
		Room room = fetchByPrimaryKey(roomId);

		if (room == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + roomId);
			}

			throw new NoSuchRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY
					+ roomId);
		}

		return room;
	}

	/**
	 * Finds the room with the primary key or returns <code>null</code> if it
	 * could not be found.
	 * 
	 * @param primaryKey
	 *            the primary key of the room to find
	 * @return the room, or <code>null</code> if a room with the primary key
	 *         could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room fetchByPrimaryKey(Serializable primaryKey)
			throws SystemException {
		return fetchByPrimaryKey(((Integer) primaryKey).intValue());
	}

	/**
	 * Finds the room with the primary key or returns <code>null</code> if it
	 * could not be found.
	 * 
	 * @param roomId
	 *            the primary key of the room to find
	 * @return the room, or <code>null</code> if a room with the primary key
	 *         could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room fetchByPrimaryKey(int roomId) throws SystemException {
		Room room = (Room) EntityCacheUtil.getResult(
				RoomModelImpl.ENTITY_CACHE_ENABLED, RoomImpl.class, roomId,
				this);

		if (room == null) {
			Session session = null;

			try {
				session = openSession();

				room = (Room) session.get(RoomImpl.class, new Integer(roomId));
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (room != null) {
					cacheResult(room);
				}

				closeSession(session);
			}
		}

		return room;
	}

	/**
	 * Finds all the rooms where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @return the matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}

	/**
	 * Finds a range of all the rooms where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @return the range of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByGroupId(long groupId, int start, int end)
			throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rooms where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by
	 * @return the ordered range of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByGroupId(long groupId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { groupId,

		String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator) };

		List<Room> list = (List<Room>) FinderCacheUtil.getResult(
				FINDER_PATH_FIND_BY_GROUPID, finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(
							3 + (orderByComparator.getOrderByFields().length * 3));
				} else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_ROOM_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
							orderByComparator);
				}

				else {
					query.append(RoomModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Room>) QueryUtil.list(q, getDialect(), start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					list = new ArrayList<Room>();
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
	 * Finds the first room in the ordered set where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the first matching room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a matching room could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByGroupId_First(long groupId,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		List<Room> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRoomException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last room in the ordered set where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the last matching room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a matching room could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByGroupId_Last(long groupId,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		int count = countByGroupId(groupId);

		List<Room> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRoomException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rooms before and after the current room in the ordered set
	 * where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param roomId
	 *            the primary key of the current room
	 * @param groupId
	 *            the group id to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the previous, current, and next room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room[] findByGroupId_PrevAndNext(int roomId, long groupId,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, room, groupId,
					orderByComparator, true);

			array[1] = room;

			array[2] = getByGroupId_PrevAndNext(session, room, groupId,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected Room getByGroupId_PrevAndNext(Session session, Room room,
			long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOM_WHERE);

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
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(room);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Room> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Finds all the rooms where name = &#63;.
	 * 
	 * @param name
	 *            the name to search with
	 * @return the matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rooms where name = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param name
	 *            the name to search with
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @return the range of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByName(String name, int start, int end)
			throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rooms where name = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param name
	 *            the name to search with
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by
	 * @return the ordered range of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByName(String name, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { name,

		String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator) };

		List<Room> list = (List<Room>) FinderCacheUtil.getResult(
				FINDER_PATH_FIND_BY_NAME, finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(
							3 + (orderByComparator.getOrderByFields().length * 3));
				} else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_ROOM_WHERE);

				if (name == null) {
					query.append(_FINDER_COLUMN_NAME_NAME_1);
				} else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAME_NAME_3);
					} else {
						query.append(_FINDER_COLUMN_NAME_NAME_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
							orderByComparator);
				}

				else {
					query.append(RoomModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Room>) QueryUtil.list(q, getDialect(), start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					list = new ArrayList<Room>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME, finderArgs,
						list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first room in the ordered set where name = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param name
	 *            the name to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the first matching room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a matching room could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByName_First(String name,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		List<Room> list = findByName(name, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRoomException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last room in the ordered set where name = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param name
	 *            the name to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the last matching room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a matching room could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByName_Last(String name, OrderByComparator orderByComparator)
			throws NoSuchRoomException, SystemException {
		int count = countByName(name);

		List<Room> list = findByName(name, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRoomException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rooms before and after the current room in the ordered set
	 * where name = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param roomId
	 *            the primary key of the current room
	 * @param name
	 *            the name to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the previous, current, and next room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room[] findByName_PrevAndNext(int roomId, String name,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByName_PrevAndNext(session, room, name,
					orderByComparator, true);

			array[1] = room;

			array[2] = getByName_PrevAndNext(session, room, name,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected Room getByName_PrevAndNext(Session session, Room room,
			String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOM_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		} else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			} else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}
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
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(room);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Room> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Finds all the rooms where available = &#63;.
	 * 
	 * @param available
	 *            the available to search with
	 * @return the matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByAvailable(boolean available) throws SystemException {
		return findByAvailable(available, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}

	/**
	 * Finds a range of all the rooms where available = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param available
	 *            the available to search with
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @return the range of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByAvailable(boolean available, int start, int end)
			throws SystemException {
		return findByAvailable(available, start, end, null);
	}

	/**
	 * Finds an ordered range of all the rooms where available = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param available
	 *            the available to search with
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by
	 * @return the ordered range of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findByAvailable(boolean available, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { available,

		String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator) };

		List<Room> list = (List<Room>) FinderCacheUtil.getResult(
				FINDER_PATH_FIND_BY_AVAILABLE, finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(
							3 + (orderByComparator.getOrderByFields().length * 3));
				} else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_ROOM_WHERE);

				query.append(_FINDER_COLUMN_AVAILABLE_AVAILABLE_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
							orderByComparator);
				}

				else {
					query.append(RoomModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(available);

				list = (List<Room>) QueryUtil.list(q, getDialect(), start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					list = new ArrayList<Room>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AVAILABLE,
						finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first room in the ordered set where available = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param available
	 *            the available to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the first matching room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a matching room could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByAvailable_First(boolean available,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		List<Room> list = findByAvailable(available, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("available=");
			msg.append(available);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRoomException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last room in the ordered set where available = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param available
	 *            the available to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the last matching room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a matching room could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room findByAvailable_Last(boolean available,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		int count = countByAvailable(available);

		List<Room> list = findByAvailable(available, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("available=");
			msg.append(available);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRoomException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Finds the rooms before and after the current room in the ordered set
	 * where available = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param roomId
	 *            the primary key of the current room
	 * @param available
	 *            the available to search with
	 * @param orderByComparator
	 *            the comparator to order the set by
	 * @return the previous, current, and next room
	 * @throws jp.aegif.liferay.experiment.mryoshio.rr.NoSuchRoomException
	 *             if a room with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Room[] findByAvailable_PrevAndNext(int roomId, boolean available,
			OrderByComparator orderByComparator) throws NoSuchRoomException,
			SystemException {
		Room room = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			Room[] array = new RoomImpl[3];

			array[0] = getByAvailable_PrevAndNext(session, room, available,
					orderByComparator, true);

			array[1] = room;

			array[2] = getByAvailable_PrevAndNext(session, room, available,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected Room getByAvailable_PrevAndNext(Session session, Room room,
			boolean available, OrderByComparator orderByComparator,
			boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROOM_WHERE);

		query.append(_FINDER_COLUMN_AVAILABLE_AVAILABLE_2);

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
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(RoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(available);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(room);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Room> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Finds all the rooms.
	 * 
	 * @return the rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the rooms.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @return the range of rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the rooms.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param start
	 *            the lower bound of the range of rooms to return
	 * @param end
	 *            the upper bound of the range of rooms to return (not
	 *            inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by
	 * @return the ordered range of rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Room> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { String.valueOf(start),
				String.valueOf(end), String.valueOf(orderByComparator) };

		List<Room> list = (List<Room>) FinderCacheUtil.getResult(
				FINDER_PATH_FIND_ALL, finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(
							2 + (orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_ROOM);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
							orderByComparator);

					sql = query.toString();
				} else {
					sql = _SQL_SELECT_ROOM.concat(RoomModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Room>) QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				} else {
					list = (List<Room>) QueryUtil.list(q, getDialect(), start,
							end);
				}
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					list = new ArrayList<Room>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the rooms where groupId = &#63; from the database.
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Room room : findByGroupId(groupId)) {
			remove(room);
		}
	}

	/**
	 * Removes all the rooms where name = &#63; from the database.
	 * 
	 * @param name
	 *            the name to search with
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByName(String name) throws SystemException {
		for (Room room : findByName(name)) {
			remove(room);
		}
	}

	/**
	 * Removes all the rooms where available = &#63; from the database.
	 * 
	 * @param available
	 *            the available to search with
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByAvailable(boolean available) throws SystemException {
		for (Room room : findByAvailable(available)) {
			remove(room);
		}
	}

	/**
	 * Removes all the rooms from the database.
	 * 
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Room room : findAll()) {
			remove(room);
		}
	}

	/**
	 * Counts all the rooms where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group id to search with
	 * @return the number of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_GROUPID, finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_ROOM_WHERE);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
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
	 * Counts all the rooms where name = &#63;.
	 * 
	 * @param name
	 *            the name to search with
	 * @return the number of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_NAME, finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_ROOM_WHERE);

				if (name == null) {
					query.append(_FINDER_COLUMN_NAME_NAME_1);
				} else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAME_NAME_3);
					} else {
						query.append(_FINDER_COLUMN_NAME_NAME_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the rooms where available = &#63;.
	 * 
	 * @param available
	 *            the available to search with
	 * @return the number of matching rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByAvailable(boolean available) throws SystemException {
		Object[] finderArgs = new Object[] { available };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_AVAILABLE, finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_ROOM_WHERE);

				query.append(_FINDER_COLUMN_AVAILABLE_AVAILABLE_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(available);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AVAILABLE,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the rooms.
	 * 
	 * @return the number of rooms
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROOM);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
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
	 * Initializes the room persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil
				.split(GetterUtil.getString(com.liferay.util.service.ServiceProps
						.get("value.object.listener.jp.aegif.liferay.experiment.mryoshio.rr.model.Room")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Room>> listenersList = new ArrayList<ModelListener<Room>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Room>) InstanceFactory
							.newInstance(listenerClassName));
				}

				listeners = listenersList
						.toArray(new ModelListener[listenersList.size()]);
			} catch (Exception e) {
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
	private static final String _SQL_SELECT_ROOM = "SELECT room FROM Room room";
	private static final String _SQL_SELECT_ROOM_WHERE = "SELECT room FROM Room room WHERE ";
	private static final String _SQL_COUNT_ROOM = "SELECT COUNT(room) FROM Room room";
	private static final String _SQL_COUNT_ROOM_WHERE = "SELECT COUNT(room) FROM Room room WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "room.groupId = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "room.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "room.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(room.name IS NULL OR room.name = ?)";
	private static final String _FINDER_COLUMN_AVAILABLE_AVAILABLE_2 = "room.available = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "room.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Room exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Room exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(RoomPersistenceImpl.class);
}