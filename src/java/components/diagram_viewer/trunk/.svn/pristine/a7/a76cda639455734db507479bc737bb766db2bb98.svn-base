/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.topcoder.util.cache.Cache;
import com.topcoder.util.cache.CacheException;

/**
 * A very simple implementation for the Cache interface.
 * This is a thread-safe implementation.
 *
 * @author  tianniu
 * @version  1.0
 */
public class MySimpleCache implements Cache {
    /**
     * <p>
     * Map from key to Entry objects. Each Entry object contains SoftReference to actual object.
     * Note that this is different from approach described in design, but this change is essential for
     * correct work of this class. This allows daemon thread to subtract the size of object when it finds
     * cleared SoftReference, which is impossible otherwise.
     * </p>
     */
    private Map mapCache;

    /**
     * Represent an entry memory size of the cache. Default value is 8 (key and value are both integer, for example)
     */
    private int entrySize = 8;

    /**
     * Creates an instance of the VerySimpleCache with default initialization.
     */
    public MySimpleCache() {
        this.mapCache = new HashMap();
    }

    /**
     * Creates an instance of the VerySimpleCache with default initialization.
     *
     * @param entrySize the entry size value
     */
    public MySimpleCache(int entrySize) {
        this.mapCache = new HashMap();
        this.entrySize = entrySize;
    }

    /**
     * Look up the for value with specified key in the cache.
     * @param   key     the specified key.
     * @return          value if found in cache, null otherwise.
     */
    public synchronized Object get(Object key) {
        if (key == null) {
            throw new NullPointerException("'key' can not be null.");
        }

        return this.mapCache.get(key);
    }

    /**
     * Puts value with its key into the cache. If value is null, it acts as if remove value with
     * specified key from the cache was invoked.
     *
     * @param  key the key for the value.
     * @param  value the value.
     * @throws NullPOinterException if the input key is null.
     * @throws CacheException if any internal error occurs. Any exception caught should be chained to
     *         this one.
     */
    public synchronized void put(Object key, Object value) {
        // if value is null, just call remove
        if (value == null) {
            remove(key);

            return;
        }

        if (key == null) {
            throw new NullPointerException("'key' can not be null.");
        }

        try {
            this.mapCache.put(key, value);
        } catch (Exception ex) {
            throw new CacheException("There are some errors occur when caching.", ex);
        }
    }

    /**
     * A bulk operation of entering key:value pairs into the cache. Each entry in the input map will be added
     * to the cache.
     * <p>It is allowed for the cacheEntry to be null. It this case cache instance will do nothing.
     *
     * @param  cacheEntry a Map of key:value pairs to be put into the cache.
     * @throws NullPointerException if any of the keys are null.
     * @throws CacheException if any internal error occurs. Any exception caught should be chained to
     *         this one.
     * @since  2.0
     */
    public synchronized void put(Map cacheEntry) {
        for (Iterator it = cacheEntry.entrySet().iterator(); it.hasNext();) {
            Map.Entry mapEntry;
            mapEntry = (Map.Entry) it.next();

            Object key;
            Object value;
            key = mapEntry.getKey();
            value = mapEntry.getValue();

            if (key == null) {
                throw new IllegalArgumentException("'cacheEntryMap' should not contain null keys.");
            }

            if (value != null) {
                this.put(key, value);
            }
        }
    }

    /**
     * Removes value with specified key from the cache.
     *
     * @param  key the specified key.
     * @return value if found in cache, null otherwise.
     * @throws NullPointerException if the input key is null.
     * @throws CacheException if any internal error occurs. Any exception caught should be chained to
     *         this one.
     */
    public synchronized Object remove(Object key) {
        if (key == null) {
            throw new NullPointerException("'key' can not be null.");
        }

        try {
            return this.mapCache.remove(key);
        } catch (Exception ex) {
            throw new CacheException("There are some errors occur when caching.", ex);
        }
    }

    /**
     * Clears the cache.
     */
    public synchronized void clear() {
        //        this.mapCache.clear();
    }

    /**
     * Returns an unmodifiable Set containing all keys currently in the cache.
     * Updates to the cache do not affect this Set.
     * Note that a key's value may be reclaimed at any time, so subsequent calls to
     * get() with keys in this Set may return null.
     *
     * @return unmodifiable Set containing all keys in the cache.
     */
    public synchronized Set keySet() {
        Set keySet;
        keySet = this.mapCache.keySet();

        if ((keySet == null) || keySet.isEmpty()) {
            return Collections.EMPTY_SET;
        }

        Set keySetCopy = new HashSet((int) (keySet.size() / 0.75) + 1);
        // initial capacity is just large enough to avoid rehashes
        // this line will pop-out warning: "uses unchecked or unsafe operations"
        keySetCopy.addAll(keySet);

        return Collections.unmodifiableSet(keySetCopy);
    }

    /**
     * This method returns an Iterator over all the values/entries present in the cache. The entries are
     * returned to the user in the very same manner that they were put into the cache. This means that if the
     * entry is compressed in the cache it will be uncompressed when returned from the Iterator's next() method.
     * <p>The iterator returned is not thread-safe.
     *
     * @return Iterator over collection of values in cache.
     */
    public Iterator values() {
        return this.keySet().iterator();
    }

    /**
     * Returns the number of entries currently in the cache.
     * Note that actually this value can be a bit smaller, because some of the objects might have been
     * deleted by Garbage Collector.
     *
     * @return current number of entries in the cache.
     */
    public synchronized long getSize() {
        return this.mapCache.size();
    }

    /**
     * Removes all entries in the cache that are specified by the keys Set. This is basically a bulk remove
     * operation.
     *
     * @param  keys Set of keys for entries to be removed.
     * @throws NullPointerException if keys is null or contains null value.
     */
    public synchronized void removeSet(Set keys) {
        if (keys == null) {
            throw new NullPointerException("'keys' can not be null.");
        }

        for (Iterator it = keys.iterator(); it.hasNext();) {
            Object key = it.next();

            if (key == null) {
                throw new IllegalArgumentException("'keys' can not contain null value.");
            }

            this.remove(key);
        }
    }

    /**
     * Represents total byte size of all the cache entries. Note that actually this value can be smaller,
     * because some of the objects might have been deleted by Garbage Collector.
     *
     * @return the size of the cache in bytes.
     */
    public long getByteSize() {
        return this.getSize() * this.entrySize;
    }

    /**
     * Getter of this entry size.
     *
     * @return the entry size value
     */
    public int getEntrySize() {
        return this.entrySize;
    }

    /**
     * Setter of this entry size.
     *
     * @param entrySize the new value to set
     */
    public void setEntrySize(int entrySize) {
        this.entrySize = entrySize;
    }
}
