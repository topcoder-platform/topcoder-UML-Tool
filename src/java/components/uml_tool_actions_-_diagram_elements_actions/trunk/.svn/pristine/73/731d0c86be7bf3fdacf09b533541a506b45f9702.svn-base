/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.lang.reflect.Field;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.Image;

import junit.framework.TestCase;

/**
 * <P>
 * Super class for unit tests of this component. This class extends TestCase and
 * provide test data and helper method for the unit tests.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 *
 */
public class DiagramElementsActionsTestCase extends TestCase {

    /**
     * <P>
     * The instance of Ellipse used in the unit tests.
     * </P>
     */
    protected static final Ellipse SIMPLE_ELLIPSE = new Ellipse();

    /**
     * <P>
     * The instance of Image used in the unit tests.
     * </P>
     */
    protected static final Image SIMPLE_IMAGE = new Image();

    /**
     * <P>
     * The DataFlavor of Ellipse.
     * </P>
     */
    protected static final DataFlavor SIMPLE_ELLIPSE_FLAVOR = new DataFlavor(
            Ellipse.class, Ellipse.class.getName());

    /**
     * <P>
     * The DataFlavor of Image.
     * </P>
     */
    protected static final DataFlavor SIMPLE_IMAGE_FLAVOR = new DataFlavor(
            Image.class, Image.class.getName());

    /**
     * <P>
     * The CopiedElement wrapped SIMPLE_ELLIPSE and SIMPLE_ELLIPSE_FLAVOR.
     * </P>
     */
    protected static final CopiedElement SIMPLE_ELLIPSE_ELEMENT = new CopiedElement(
            SIMPLE_ELLIPSE, new DataFlavor[] {SIMPLE_ELLIPSE_FLAVOR });

    /**
     * <P>
     * An empty Diagram.
     * </P>
     */
    protected static final Diagram EMPTY_DIAGRAM = new Diagram();

    /**
     * <P>
     * The error message for an argument is null.
     * </P>
     */
    protected static final String NULL_ARGUMENT_MESSAGE = " is null. IllegalArgumentException is expected";

    /**
     * <P>
     * The system clipboard.
     * </P>
     */
    protected static final Clipboard SYSTEM_CLIPBOARD = Toolkit
            .getDefaultToolkit().getSystemClipboard();

    /**
     * <P>
     * Assert an array equals another one. The two array must be at the same
     * length. The item in A array should equals the one in B with the same
     * index.
     *
     * @param errorMessage
     *            show this message, if the array are not equal
     * @param arrayA
     *            the array A
     * @param arrayB
     *            the array B
     */
    protected static void assertArrayEquals(String errorMessage,
            Object[] arrayA, Object[] arrayB) {
        assertEquals(errorMessage, arrayA.length, arrayB.length);

        for (int i = 0; i < arrayA.length; i++) {
            assertEquals(errorMessage, arrayA[i], arrayB[i]);
        }
    }

    /**
     * <P>
     * Gets the value of a specified field of the given object. The field should
     * be a object.
     * </P>
     *
     * @param name
     *            the name of the field
     * @param object
     *            the object to get the field from
     * @return the value of the object
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    protected static Object reflectObjectField(String name, Object object)
        throws NoSuchFieldException,
            IllegalAccessException {
        Field field = reflectField(name, object);
        return field.get(object);
    }

    /**
     * <P>
     * Gets the value of a specified field of the given object. The field should
     * be a boolean field.
     * </P>
     *
     * @param name
     *            the name of the field
     * @param object
     *            the object to get the field from
     * @return the value of the object
     *
     * @throws NoSuchFieldException
     *             if any field not found
     * @throws IllegalAccessException
     *             if the class or its nullary constructor is not accessible
     */
    protected static boolean reflectBooleanField(String name, Object object)
        throws NoSuchFieldException,
            IllegalAccessException {
        Field field = reflectField(name, object);
        return field.getBoolean(object);
    }

    /**
     * <P>
     * Gets the Field instance from the object's class and set the field to
     * accessable.
     * </P>
     *
     * @param name
     *            the name of the field
     * @param object
     *            get the field from this object's class
     * @return the field instance
     *
     * @throws NoSuchFieldException
     *             if any field not found
     */
    private static Field reflectField(String name, Object object)
        throws NoSuchFieldException {
        Class objectClass = object.getClass();
        Field field = objectClass.getDeclaredField(name);
        field.setAccessible(true);
        return field;
    }
}
