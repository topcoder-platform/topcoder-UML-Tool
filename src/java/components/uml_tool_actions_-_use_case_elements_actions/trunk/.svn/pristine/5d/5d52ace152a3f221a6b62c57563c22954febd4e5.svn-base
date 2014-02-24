/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link SubsystemUtil}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SubsystemUtilTest extends TestCase {
    /** The SubsystemUtil instance for testing. */
    private SubsystemUtil subsystemUtil;

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
        subsystemUtil = new SubsystemUtil();
        modelElement = new SubsystemImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        namespace = new MockNamespaceAbstractImpl();
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#SubsystemUtil()}</code> with success process.
     * </p>
     */
    public void testConsturctor_Success() {
        subsystemUtil = new SubsystemUtil();
        assertNotNull(subsystemUtil);
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null modelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullModelElement() {
        try {
            modelElement = null;
            subsystemUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null clipboard.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullClipboard() {
        try {
            clipboard = null;
            subsystemUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with success process.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_Success() {
        subsystemUtil.addElementToClipboard(modelElement, clipboard);
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#copyElement(ModelElement)}</code> with null modelElement. Should throw an
     * Exception here.
     * </p>
     */
    public void testCopyElement_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            subsystemUtil.copyElement(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#copyElement(ModelElement)}</code> with success process.
     * </p>
     */
    public void testCopyElement_ModelElement_Success() {
        ModelElement newModelElement = null;
        newModelElement = subsystemUtil.copyElement(modelElement);
        assertNotNull(newModelElement);
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success() {
        testRemoveElementFromModel_ModelElement_Success();
    }

    /**
     * <p>
     * Test <code>{@link SubsystemUtil#removeElementFromModel(ModelElement)}</code> with success process.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Success() {
        subsystemUtil.addElementToModel(modelElement, namespace);
        assertTrue(subsystemUtil.removeElementFromModel(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(SubsystemUtilTest.class);
    }
}
