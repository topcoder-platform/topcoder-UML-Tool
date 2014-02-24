/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link ExtendUtil}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExtendUtilTest extends TestCase {
    /** The ExtendUtil instance for testing. */
    private ExtendUtil extendUtil;

    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        extendUtil = new ExtendUtil();
        modelElement = new ExtendImpl();
        namespace = new MockNamespaceAbstractImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#ExtendUtil()}</code> with success process.
     * </p>
     */
    public void testConsturctor_Success() {
        extendUtil = new ExtendUtil();
        assertNotNull(extendUtil);
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToModel(ModelElement, Namespace)}</code> with null modelElement. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_NullModelElement() {
        try {
            modelElement = null;
            extendUtil.addElementToModel(modelElement, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToModel(ModelElement, Namespace)}</code> with null namespace. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_NullNamespace() {
        try {
            namespace = null;
            extendUtil.addElementToModel(modelElement, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success1() {
        extendUtil.addElementToModel(modelElement, namespace);
        assertTrue(extendUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success2() {
        Extend extend = (Extend) modelElement;
        UseCase useCase = new UseCaseImpl();
        useCase.setNamespace(namespace);
        extend.setBase(useCase);
        extend.setExtension(useCase);
        extendUtil.addElementToModel(modelElement, namespace);
        assertTrue(extendUtil.removeElementFromModel(modelElement));
    }

    /**
     * Test the method <code>{@link ExtendUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     */
    public void testAddElementToModel_ModelElementNamespace_Success3() {
        Extend extend = new ExtendImpl();
        extend.setBase(new UseCaseImpl());
        extend.getBase().setNamespace(new MockNamespaceImpl());
        extend.getBase().getNamespace().setName("abc");
        extend.getBase().getNamespace().setNamespace(new MockNamespaceImpl());
        extend.getBase().getNamespace().getNamespace().setName("topcoder");
        extend.setExtension(new UseCaseImpl());
        extend.getExtension().setNamespace(new MockNamespaceImpl());
        extend.getExtension().getNamespace().setName("dbf");
        extend.getExtension().getNamespace().setNamespace(new MockNamespaceImpl());
        extend.getExtension().getNamespace().getNamespace().setName("topcoder");

        Namespace namespace = new MockNamespaceImpl();
        extendUtil.addElementToModel(extend, namespace);

        assertFalse("Calculated namespace should be used.", extend.getNamespace().equals(namespace));
        assertFalse("Calculated namespace should be used.", namespace.getOwnedElements().contains(extend));
        assertTrue("Calculated namespace should be 'topcoder'.", extend.getNamespace().getName().equals("topcoder"));
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#removeElementFromModel(ModelElement)}</code> with null modelElement. Should throw
     * an Exception here.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            extendUtil.removeElementFromModel(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#removeElementFromModel(ModelElement)}</code> with success process.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Success() {
        assertFalse(extendUtil.removeElementFromModel(modelElement));
        extendUtil.addElementToModel(modelElement, namespace);
        assertTrue(extendUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null modelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullModelElement() {
        try {
            modelElement = null;
            extendUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullClipboard() {
        try {
            clipboard = null;
            extendUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with success process.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_Success() {
        extendUtil.addElementToClipboard(modelElement, clipboard);
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#copyElement(ModelElement)}</code> with null modelElement. Should throw an Exception
     * here.
     * </p>
     */
    public void testCopyElement_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            extendUtil.copyElement(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ExtendUtil#copyElement(ModelElement)}</code> with success process.
     * </p>
     */
    public void testCopyElement_ModelElement_Success() {
        assertNotNull(extendUtil.copyElement(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(ExtendUtilTest.class);
    }
}
