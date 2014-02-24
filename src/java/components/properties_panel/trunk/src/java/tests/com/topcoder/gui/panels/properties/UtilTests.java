/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JComponent;
import javax.swing.JPanel;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilTests extends TestCase {
    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull(" ", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for accuracy.
     * </p>
     */
    public void testCheckString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullArg() {
        try {
            Util.checkString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyArg() {
        try {
            Util.checkString(" ", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkCollection(Collection,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies Util#checkCollection(Collection,String) is correct.
     * </p>
     */
    public void testCheckCollection() {
        Collection<String> collection = new ArrayList<String>();
        collection.add("test");
        Util.checkCollection(collection, "test");
    }

    /**
     * <p>
     * Tests Util#checkCollection(Collection,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckCollection_NullArg() {
        try {
            Util.checkCollection(null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkCollection(Collection,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when collection contains null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckCollection_NullInCollection() {
        Collection<String> collection = new ArrayList<String>();
        collection.add(null);
        try {
            Util.checkCollection(collection, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkCollection(Collection,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when collection is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckCollection_EmptyCollection() {
        Collection<String> collection = new ArrayList<String>();
        try {
            Util.checkCollection(collection, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#setFixedSize(JComponent Collection,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when collection is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFixedSize_Accuracy() {
        JComponent component = new JPanel();
        Util.setFixedSize(component, 10, 20);
        assertEquals("The max size is wrong.", new Dimension(10, 20), component.getMaximumSize());
        assertEquals("The max size is wrong.", new Dimension(10, 20), component.getMinimumSize());
        assertEquals("The preferred size is wrong.", new Dimension(10, 20), component.getPreferredSize());
    }

}