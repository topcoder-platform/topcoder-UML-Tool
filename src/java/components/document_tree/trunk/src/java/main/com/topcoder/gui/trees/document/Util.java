/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * Helper class for this component.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safe.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public final class Util {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Util() {
        // empty
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg
     *            the argument to check
     * @param name
     *            the name of the argument to check
     *
     * @throws IllegalArgumentException
     *             if the given Object is null
     */
    public static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given String is null or empty.
     * </p>
     *
     * @param arg
     *            the String to check
     * @param name
     *            the name of the String argument to check
     *
     * @throws IllegalArgumentException
     *             if the given string is null or empty
     */
    public static void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Checks whether the given array is null or contains null element.
     * </p>
     *
     * @param arg
     *            the array to check
     * @param name
     *            the name of the argument to check
     *
     * @throws IllegalArgumentException
     *             if the given array is null or contains null element
     */
    public static void checkArray(Object[] arg, String name) {
        checkNull(arg, name);

        for (Object element : arg) {
            Util.checkNull(element, "element in " + name);
        }
    }

    /**
     * <p>
     * This method used to create new DocumentTreeView instance, basing on implementation-class name and parameters
     * for constructor.
     * </p>
     *
     * @param className
     *            The fully qualified class name - implementation of DocumentTreeView interface.
     * @param parent
     *            The parent tabbed pane, used as first parameter in className constructor.
     * @param namespace
     *            The string used as second parameter in className constructor.
     * @return newly created DocumentTreeView instance
     * @throws IllegalArgumentException
     *             If any argument is null or any String is empty.
     * @since 1.1
     */
    public static DocumentTreeView createTreeView(String className, DocumentTreePanel parent, String namespace) {
        checkString(className, "className");
        checkNull(parent, "parent");
        checkString(namespace, "namespace");

        try {
            // create object from class name and constructor parameters
            Class implementation = Class.forName(className);
            Constructor constructor =
                implementation.getConstructor(new Class[] {DocumentTreePanel.class, String.class});
            Object object = constructor.newInstance(new Object[] {parent, namespace});

            // check what object can be used as DocumentTreeView
            if (!(object instanceof DocumentTreeView)) {
                throw new DocumentTreeConfigurationException("Class " + className
                    + " can't be cast to DocumentTreeView.");
            }

            return (DocumentTreeView) object;
        } catch (ClassNotFoundException e) {
            throw new DocumentTreeConfigurationException("Unable to locate the class " + className
                + ", caused by " + e.getMessage(), e);
        } catch (NoSuchMethodException e) {
            throw new DocumentTreeConfigurationException("Unable to locate the constructor, caused by "
                + e.getMessage(), e);
        } catch (InstantiationException e) {
            throw new DocumentTreeConfigurationException("Fails to create the instance, caused by "
                + e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new DocumentTreeConfigurationException("Fails to create the instance, caused by "
                + e.getMessage(), e);
        } catch (InvocationTargetException e) {
            throw new DocumentTreeConfigurationException("Fails to create the instance, caused by "
                + e.getMessage(), e);
        }
    }
}
