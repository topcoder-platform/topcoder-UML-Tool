/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for NamespaceItem.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NamespaceItemTests extends TestCase {
    /**
     * <p>
     * The NamespaceItem instance for testing.
     * </p>
     */
    private NamespaceItem item;

    /**
     * <p>
     * The Namespace instance for testing.
     * </p>
     */
    private Namespace namespace;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        namespace = new DataTypeImpl();
        namespace.setName("namespace");
        item = new NamespaceItem(namespace);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        item = null;
        namespace = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(NamespaceItemTests.class);
    }

    /**
     * <p>
     * Tests NamespaceItem#NamespaceItem(Namespace) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NamespaceItem instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new NamespaceItem instance.", item);
    }

    /**
     * <p>
     * Tests ctor NamespaceItem#NamespaceItem(Namespace) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new NamespaceItem(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests NamespaceItem#toString() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NamespaceItem#toString() is correct.
     * </p>
     */
    public void testToString() {
        assertEquals("Failed to get the value correctly.", "namespace", item.toString());
    }

    /**
     * <p>
     * Tests NamespaceItem#getNamespace() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NamespaceItem#getNamespace() is correct.
     * </p>
     */
    public void testGetNamespace() {
        assertSame("Failed to get the namespace correctly.", this.namespace, item.getNamespace());
    }

}