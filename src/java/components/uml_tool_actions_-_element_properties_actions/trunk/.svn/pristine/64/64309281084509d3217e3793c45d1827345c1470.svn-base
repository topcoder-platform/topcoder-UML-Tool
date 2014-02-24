/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions;

import java.lang.reflect.Field;

/**
 * Helper class of Unit Test.
 *
 * @author rainday
 * @version 1.0
 */
public class UnitTestsHelper {

    /**
     * Private constructor.
     */
    private UnitTestsHelper() {
        // do nothing.
    }

    /**
     * Returns the value of the given field in the given Object using Reflection.
     *
     * @param obj the given Object instance to get the field value.
     * @param fieldName the name of the filed to get value from the obj.
     * @return the field value in the obj.
     */
    public static Object getObjectFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            return field.get(obj);
        } catch (SecurityException e) {
            // ignore
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalArgumentException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        }

        return null;
    }
}
