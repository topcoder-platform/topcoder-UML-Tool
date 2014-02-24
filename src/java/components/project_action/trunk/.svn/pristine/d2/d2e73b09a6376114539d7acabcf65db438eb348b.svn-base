/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.lang.reflect.Field;

/**
 * <p>
 * Helper class used for testing purpose.
 * </p>
 * 
 * @author FireIce
 * @version 1.0
 */
final class AccuracyTestHelper {

    /**
     * <p>
     * private constructor that preventing instantiation.
     * </p>
     */
    private AccuracyTestHelper() {
    }

    /**
     * <p>
     * Get the field value of an object.
     * </p>
     * 
     * @param obj
     *            the object where to get the field value.
     * @param fieldName
     *            the name of the field.
     * @return the field value
     * @throws Exception
     *             any exception occurs.
     */
    static Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
