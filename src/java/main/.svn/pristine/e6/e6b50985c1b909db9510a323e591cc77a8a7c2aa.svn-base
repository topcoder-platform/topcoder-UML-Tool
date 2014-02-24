/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.util.cache.MemoryUtilizationException;
import com.topcoder.util.cache.MemoryUtilizationHandler;

/**
 * This is a null implementation of the MemoryUtilizationHandler interface. This implementation delegates the memory
 * utilization processing to the TopCoder Memory Usage component.
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NullMemoryUtilizationHandler implements MemoryUtilizationHandler {

    /**
     * Zero memory usage for the input object in bytes of memory.
     * @param object
     *            object that we would like to know the size of.
     * @return zero.
     * @throws NullPointerException
     *             if the argument object is null.
     * @throws MemoryUtilizationException
     *             if there are issues with processing the request. Any exception caught from
     *             MemoryUsage.getDeepMemoryUsage will be wrapped into this exception.
     */
    public long getObjectSize(Object object) {
        return 0;
    }

}
