/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link UseCaseUtil}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseUtilTest extends TestCase {
    /** The UseCaseUtil instance for testing. */
    private UseCaseUtil useCaseUtil;

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
        modelElement = new UseCaseImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        useCaseUtil = new UseCaseUtil();
        namespace = new MockNamespaceAbstractImpl();
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#UseCaseUtil()}</code> with success process.
     * </p>
     */
    public void testConstructor_Success() {
        useCaseUtil = new UseCaseUtil();
        assertNotNull(useCaseUtil);
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null ModelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullModelElement() {
        try {
            modelElement = null;
            useCaseUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullClipboard() {
        try {
            clipboard = null;
            useCaseUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with success process.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_Success() {
        useCaseUtil.addElementToClipboard(modelElement, clipboard);
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#copyElement(ModelElement)}</code> with null ModelElement. Should throw an
     * Exception here.
     * </p>
     */
    public void testCopyElement_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            useCaseUtil.copyElement(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#copyElement(ModelElement)}</code> with success process.
     * </p>
     */
    public void testCopyElement_ModelElement_Success() {
        ModelElement newModelElement = null;
        newModelElement = useCaseUtil.copyElement(modelElement);
        assertNotNull(newModelElement);
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success() {
        testRemoveElementFromModel_ModelElement_Success();
    }

    /**
     * <p>
     * Test <code>{@link UseCaseUtil#removeElementFromModel(ModelElement)}</code> with success process.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Success() {
        useCaseUtil.addElementToModel(modelElement, namespace);
        assertTrue(useCaseUtil.removeElementFromModel(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(UseCaseUtilTest.class);
    }
}
