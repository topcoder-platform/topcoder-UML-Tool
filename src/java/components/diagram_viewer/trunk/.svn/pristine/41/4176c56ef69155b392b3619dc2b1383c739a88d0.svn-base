/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.topcoder.util.cache.Cache;

/**
 * This class implements Cache interface. It is used for testing.
 *
 * @author Yeung
 * @version 1.0
 */
public class MockCache implements Cache {
    /**
     * It represents the map to store the object.
     */
    private Map map = new HashMap();

    /**
     * Clears the cache.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Look up the for value with specified key in the cache.
     *
     * @param key
     *            the specified key.
     * @return value if found in cache, null otherwise.
     */
    public Object get(Object key) {
        return map.get(key);
    }

    /**
     * Represents the current total byte size of all the cache entries.
     *
     * @return current byte size of the cache.
     */
    public long getByteSize() {
        return map.size();
    }

    /**
     * Returns the number of items currently in the cache.
     *
     * @return number of entries in the cache.
     */
    public long getSize() {
        return map.size();
    }

    /**
     * Returns an unmodifiable Set containing all keys currently in the cache.
     * Updates to the cache do not affect this Set.
     *
     * @return unmodifiable Set containing all keys in the cache.
     */
    public Set keySet() {
        return map.keySet();
    }

    /**
     * A bulk operation of entering key:value pairs into the cache. Each entry in the input map will be added to the
     * cache.
     * <p>
     * It is allowed for the cacheEntry to be null. It this case cache instance will do nothing.
     *
     * @param cacheEntry
     *            a Map of key:value pairs to be put into the cache.
     */
    public void put(Map cacheEntry) {
        map.putAll(cacheEntry);
    }

    /**
     * Puts value with its key into the cache. If value is null, it acts as if remove value with specified key from the
     * cache was invoked.
     *
     * @param key
     *            the key for the value.
     * @param value
     *            the value.
     */
    public void put(Object key, Object value) {
        map.put(key, value);
    }

    /**
     * Removes value with specified key from the cache.
     *
     * @param key
     *            the specified key.
     * @return value if found in cache, null otherwise.
     */
    public Object remove(Object key) {
        return map.remove(key);
    }

    /**
     * Removes all entries in the cache that are specified by the keys Set. This is basically a bulk remove operation.
     *
     * @param keys
     *            set representing the keys to be used in removing entries from the cache.
     */
    public void removeSet(Set keys) {
        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            map.remove(iterator.next());
        }
    }

    /**
     * Returns the iterator over all the cache values.
     *
     * @return iterator over collection of values in cache.
     */
    public Iterator values() {
        return map.values().iterator();
    }
}
