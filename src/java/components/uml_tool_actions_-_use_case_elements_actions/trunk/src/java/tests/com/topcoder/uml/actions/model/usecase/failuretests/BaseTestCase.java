/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

/**
 * <p>
 * Base test case that provides some common assertion functionality for testing.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class BaseTestCase extends TestCase {

    /**
     * <p>
     * assert the constructor to throw exception.
     * </p>
     * @param clazz
     *            the class
     * @param parameterTypes
     *            the parameter types
     * @param initargs
     *            the initialization arguments
     * @param expectedException
     *            the expected exception type
     * @param message
     *            the error message
     */
    public static void assertConstructorException(Class clazz, Class[] parameterTypes, Object[] initargs,
        Class expectedException, String message) {
        try {
            clazz.getDeclaredConstructor(parameterTypes).newInstance(initargs);
            fail(message);
        } catch (InvocationTargetException e) {
                if (expectedException.equals(e.getCause().getClass())) {
                    return;
                }
                fail(e.getCause().getMessage());
        } catch (Exception e) {
            fail("should not throw this exception.");
        }
    }

    /**
     * <p>
     * assert the method to throw exception.
     * </p>
     * @param clazz
     *            the class
     * @param methodName
     *            the method name
     * @param parameterTypes
     *            the parameter types
     * @param obj
     *            the instance obj
     * @param args
     *            the arguments
     * @param expectedException
     *            the expected exception type
     * @param message
     *            the error message
     */
    public static void assertMethodException(Class clazz, String methodName, Class[] parameterTypes, Object obj,
        Object[] args, Class expectedException, String message) {
        try {
            clazz.getDeclaredMethod(methodName, parameterTypes).invoke(obj, args);
            fail(message);
        } catch (Exception e) {
            if (!expectedException.getClass().isAssignableFrom(e.getClass())) {
                fail(message);
            }
        }

    }
}
