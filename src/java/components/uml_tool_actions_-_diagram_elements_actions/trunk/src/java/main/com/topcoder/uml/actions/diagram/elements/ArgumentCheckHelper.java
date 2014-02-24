/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.util.Arrays;

/**
 * <P>
 * ArgumentCheckHelper is a helper class which helps to check argument for
 * methods. No instance of this class will be create, it just provides static
 * methods.
 * </P>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 */
class ArgumentCheckHelper {

    /**
     * <P>
     * Just a private empty constructor. So no instance of this class can be
     * create.
     * </P>
     *
     */
    private ArgumentCheckHelper() {
    }

    /**
     * <P>
     * Checks if the argument is <code>null</code>. If it's <code>null</code>,
     * throw an <code>IllegalArgumentException</code> else return it back.
     * </P>
     *
     * @param name
     *            the name of the argument, it would be used to generate error
     *            message.
     * @param argument
     *            the argument to check.
     *
     * @throws IllegalArgumentException
     *             if the argument is <code>null</code>.
     *
     * @return the argument if it isn't <code>null</code>.
     */
    static Object checkNotNull(String name, Object argument) {
        if (argument == null) {
            if (name == null) {
                name = "argument";
            }

            throw new IllegalArgumentException(name + " can't be null");
        }
        return argument;
    }

    /**
     * <P>
     * Checks an array argument isn't an empty array. If it is <code>null</code>
     * or empty throw an <code>IllegalArgumentException</code> else just
     * return it back.
     * </P>
     *
     * @param name
     *            the name of the array. It would be used to generate error
     *            message.
     * @param arrayArgument
     *            the argument to check.
     * @throws IllegalArgumentException
     *             if the argument is <code>null</code> or empty.
     * @return the array back if it isn't <code>null</code> or empty.
     */
    static Object[] checkArrayValidity(String name,
            Object[] arrayArgument) {
        if (name == null) {
            name = "argument";
        }
        // the array isn't null
        checkNotNull(name, arrayArgument);
        // the array is not empty
        if (arrayArgument.length == 0) {
            throw new IllegalArgumentException(name
                    + " can't be an empty array");
        }
        // no null item in the array
        if (Arrays.asList(arrayArgument).contains(null)) {
            throw new IllegalArgumentException(name + " can't contain null");
        }
        return arrayArgument;
    }
}
