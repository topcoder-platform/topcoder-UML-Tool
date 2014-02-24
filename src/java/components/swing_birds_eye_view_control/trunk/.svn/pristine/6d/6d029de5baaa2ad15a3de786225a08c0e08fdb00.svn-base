/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.lang.reflect.Field;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ReflectTestHelper {
    /**
     * <p>
     * Private constructor to prevent initialization.
     * </p>
     */
    private ReflectTestHelper() {
    }

    /**
     * <p>
     * Used to get the declared field of the specified object.
     * </p>
     *
     * @param instance the instance from where to get the field value.
     * @param fieldName the name of the field.
     * @throws Exception If any exception is thrown from the inner code.
     * @return the value of the field.
     */
    public static Object getField(Object instance, String fieldName)
        throws Exception {
        Field field = null;
        Class<?> clazz = instance.getClass();
        while (true) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                if (clazz.getSuperclass() == null) {
                    throw e;
                }
                clazz = clazz.getSuperclass();
            }
        }

        boolean accessFlag = field.isAccessible();

        try {
            field.setAccessible(true);

            Object res = field.get(instance);

            return res;
        } finally {
            field.setAccessible(accessFlag);
        }
    }
}
