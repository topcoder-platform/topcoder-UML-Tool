/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
/**
 * <p>
 * Failure test for ObjectUtil.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ObjectUtilFailureTest extends TestCase {

    /**
     * <p>
     * ObjectUtil instance created for testing.
     * <p>
     */
    private ObjectUtil util;

    /**
     * <p>
     * Object instance created for testing.
     * <p>
     */
    private Object object;

    /**
     * <p>
     * Clipboard instance created for testing.
     * <p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        util = new ObjectUtil();
        clipboard = new Clipboard("clip");
        object = new ObjectImpl();
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        // empty
    }

    /**
     * <p>
     * Failure test for <code>addObjectToCollaboration(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testAddObjectToCollaboration() {
        try {
            util.addObjectToCollaboration(null);
            fail("object is null, IllegalArgumentException is expect.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>removeObjectFromCollaboration(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testRemoveObjectFromCollaboration() {
        try {
            util.removeObjectFromCollaboration(null);
            fail("object is null, IllegalArgumentException is expect.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>addObjectToClipboard(Object object, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testAddObjectToClipboardNull() {
        try {
            util.addObjectToClipboard(null, clipboard);
            fail("object is null, IllegalArgumentException is expect.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>addObjectToClipboard(Object object, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testAddObjectToClipboard() {
        try {
            util.addObjectToClipboard(object, null);
            fail("object is null, IllegalArgumentException is expect.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>checkObjectNamespace(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testCheckObjectNamespace() {
        try {
            util.checkObjectNamespace(null);
            fail("object is null, IllegalArgumentException is expect.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>copyObject(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expect.
     * </p>
     */
    public void testCopyObject() {
        try {
            util.copyObject(null);
            fail("object is null, IllegalArgumentException is expect.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

}
