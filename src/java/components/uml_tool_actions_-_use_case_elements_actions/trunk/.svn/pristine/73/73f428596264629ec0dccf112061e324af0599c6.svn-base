/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link ActorUtil}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActorUtilTest extends TestCase {
    /** The ActorUtil instance for testing. */
    private ActorUtil actorUtil;

    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        actorUtil = new ActorUtil();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        modelElement = new ActorImpl();
        namespace = new MockNamespaceAbstractImpl();
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#ActorUtil()}</code> with success process.
     * </p>
     */
    public void testConstructor_Success() {
        actorUtil = new ActorUtil();
        assertNotNull(actorUtil);
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null ModelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullModelElement() {
        try {
            modelElement = null;
            actorUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullClipboard() {
        try {
            clipboard = null;
            actorUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with success process.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_Success() {
        actorUtil.addElementToClipboard(modelElement, clipboard);
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#copyElement(ModelElement)}</code> with null ModelElement. Should throw an Exception
     * here.
     * </p>
     */
    public void testCopyElement_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            actorUtil.copyElement(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#copyElement(ModelElement)}</code> with success process.
     * </p>
     */
    public void testCopyElement_ModelElement_Success() {
        assertNotNull(actorUtil.copyElement(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success() {
        testRemoveElementFromModel_ModelElement_Success();
    }

    /**
     * <p>
     * Test <code>{@link ActorUtil#removeElementFromModel(ModelElement)}</code> with success process.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Success() {
        actorUtil.addElementToModel(modelElement, namespace);
        assertTrue(actorUtil.removeElementFromModel(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(ActorUtilTest.class);
    }
}
