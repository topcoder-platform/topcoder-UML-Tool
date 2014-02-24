/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link IncludeUtil}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IncludeUtilTest extends TestCase {
    /** The IncludeUtil instance for testing. */
    private IncludeUtil includeUtil;

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
        includeUtil = new IncludeUtil();
        modelElement = new IncludeImpl();
        namespace = new MockNamespaceAbstractImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#IncludeUtil()}</code> with success process.
     * </p>
     */
    public void testConsturctor_Success() {
        includeUtil = new IncludeUtil();
        assertNotNull(includeUtil);
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToModel(ModelElement, Namespace)}</code> with null modelElement. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_NullModelElement() {
        try {
            modelElement = null;
            includeUtil.addElementToModel(modelElement, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToModel(ModelElement, Namespace)}</code> with null namespace. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_NullNamespace() {
        try {
            namespace = null;
            includeUtil.addElementToModel(modelElement, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success1() {
        includeUtil.addElementToModel(modelElement, namespace);
        assertTrue(includeUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     * </p>
     */
    public void testAddElementToModel_ModelElementNamespace_Success2() {
        Include include = (Include) modelElement;
        UseCase useCase = new UseCaseImpl();
        useCase.setNamespace(namespace);
        include.setBase(useCase);
        include.setAddition(useCase);
        includeUtil.addElementToModel(modelElement, namespace);
        assertTrue(includeUtil.removeElementFromModel(modelElement));
    }

    /**
     * Test <code>{@link IncludeUtil#addElementToModel(ModelElement, Namespace)}</code> with success process.
     */
    public void testAddElementToModel_ModelElementNamespace_Success3() {
        Include include = new IncludeImpl();
        include.setBase(new UseCaseImpl());
        include.getBase().setNamespace(new MockNamespaceImpl());
        include.getBase().getNamespace().setName("abc");
        include.getBase().getNamespace().setNamespace(new MockNamespaceImpl());
        include.getBase().getNamespace().getNamespace().setName("topcoder");
        include.setAddition(new UseCaseImpl());
        include.getAddition().setNamespace(new MockNamespaceImpl());
        include.getAddition().getNamespace().setName("dbf");
        include.getAddition().getNamespace().setNamespace(new MockNamespaceImpl());
        include.getAddition().getNamespace().getNamespace().setName("topcoder");

        Namespace namespace = new MockNamespaceImpl();
        includeUtil.addElementToModel(include, namespace);

        assertFalse("Calculated namespace should be used.", include.getNamespace().equals(namespace));
        assertFalse("Calculated namespace should be used.", namespace.getOwnedElements().contains(include));
        assertTrue("Calculated namespace should be 'topcoder'.", include.getNamespace().getName().equals("topcoder"));
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#removeElementFromModel(ModelElement)}</code> with null modelElement. Should throw
     * an Exception here.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            includeUtil.removeElementFromModel(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#removeElementFromModel(ModelElement)}</code> with success process.
     * </p>
     */
    public void testRemoveElementFromModel_ModelElement_Success() {
        assertFalse(includeUtil.removeElementFromModel(modelElement));
        includeUtil.addElementToModel(modelElement, namespace);
        assertTrue(includeUtil.removeElementFromModel(modelElement));
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null modelElement.
     * Should throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullModelElement() {
        try {
            modelElement = null;
            includeUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_NullClipboard() {
        try {
            clipboard = null;
            includeUtil.addElementToClipboard(modelElement, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#addElementToClipboard(ModelElement, Clipboard)}</code> with success process.
     * </p>
     */
    public void testAddElementToClipboard_ModelElementClipboard_Success() {
        includeUtil.addElementToClipboard(modelElement, clipboard);
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#copyElement(ModelElement)}</code> with null modelElement. Should throw an
     * Exception here.
     * </p>
     */
    public void testCopyElement_ModelElement_NullModelElement() {
        try {
            modelElement = null;
            includeUtil.copyElement(modelElement);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link IncludeUtil#copyElement(ModelElement)}</code> with success process.
     * </p>
     */
    public void testCopyElement_ModelElement_Success() {
        assertNotNull(includeUtil.copyElement(modelElement));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(IncludeUtilTest.class);
    }
}
