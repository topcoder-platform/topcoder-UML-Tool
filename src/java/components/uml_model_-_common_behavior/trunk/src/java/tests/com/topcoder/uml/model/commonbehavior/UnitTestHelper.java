/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Helper class for unit test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTestHelper extends TestCase {
    /**
     * Private constructor.
     */
    private UnitTestHelper() {
        // do nothing
    }

    /**
    * Creates an object using relection.
    *
    * @param type the type of the class
    * @param parameterTypes the types of parameter
    * @param parameters the parameters
    * @return the object created
    * @throws Exception to invoker
    */
    public static Object createInstance(Class type, Class[] parameterTypes, Object[] parameters)
        throws Exception {
        Constructor ctor = type.getConstructor(parameterTypes);

        if (!ctor.isAccessible()) {
            // check isAccessible before new
            try {
                ctor.setAccessible(true);

                return ctor.newInstance(parameters);
            } finally {
                // check isAccessible back
                ctor.setAccessible(false);
            }
        } else {
            return ctor.newInstance(parameters);
        }
    }

    /**
     * Invokes a method using reflection, pass out exception from invoked method.
     *
     * @param obj the object to invoke on
     * @param type the type of obj
     * @param name the name of the method
     * @param parameterTypes the parameter types of the method
     * @param parameters the parameters
     * @return the return value, or null if the method is a void-return one
     * @throws Exception if any error happens, or it is thrown from invoked method.
     */
    public static Object invokeMethod(Object obj, Class type, String name, Class[] parameterTypes, Object[] parameters)
        throws Exception {
        Method method = type.getMethod(name, parameterTypes);

        try {
            // check isAccessible
            if (method.isAccessible()) {
                return method.invoke(obj, parameters);
            } else {
                try {
                    method.setAccessible(true);

                    return method.invoke(obj, parameters);
                } finally {
                    // set isAccessible back
                    method.setAccessible(false);
                }
            }
        } catch (InvocationTargetException ite) {
            // pass out exception from invoked method.
            throw (Exception) ite.getCause();
        }
    }
}
