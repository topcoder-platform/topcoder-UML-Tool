/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AbstractionUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractionUtilTest extends TestCase {

    /**
     * The AbstractionUtil instance for the test.
     */
    private AbstractionUtil abstractionUtil;

    /**
     * The Abstraction instance for the test.
     */
    private Abstraction modelElement = new AbstractionImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard;

    /**
     * The Namespace instance for the test.
     */
    private Namespace namespace;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        namespace = new ModelImpl();
    }

    /**
     * Test constructor.
     */
    public void testCtor() {
        abstractionUtil = new AbstractionUtil();
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToModelSimple() throws Exception {
        modelElement.setNamespace(namespace);

        abstractionUtil = new AbstractionUtil();

        abstractionUtil.addElementToModel(modelElement, namespace);

        assertTrue("Should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        for (ModelElement supplier : modelElement.getSuppliers()) {
            assertTrue("Should add relationship.", supplier.containsSupplierDependency(modelElement));
        }
        for (ModelElement client : modelElement.getClients()) {
            assertTrue("Should add relationship.", client.containsClientDependency(modelElement));
        }
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace. Also the
     * modelElement's namespce will be checked here.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToModel() throws Exception {
        Namespace com = new ModelImpl();
        com.setNamespace(namespace);
        Namespace tc = new ModelImpl();
        tc.setNamespace(com);

        // supplier's namespace: namespace.com
        ModelElement testSupplier = new InterfaceImpl();
        testSupplier.setNamespace(com);

        // client's namespace: namespace.com.tc
        ModelElement testClient = new InterfaceImpl();
        testClient.setNamespace(tc);

        modelElement.setNamespace(namespace);
        modelElement.addSupplier(testSupplier);
        modelElement.addClient(testClient);

        abstractionUtil = new AbstractionUtil();

        abstractionUtil.addElementToModel(modelElement, namespace);

        // modelElement's namespace should be namespace.com
        assertTrue("Should be added to the Namespace com.", com.containsOwnedElement(modelElement));

        for (ModelElement supplier : modelElement.getSuppliers()) {
            assertTrue("Should add relationship.", supplier.containsSupplierDependency(modelElement));
        }
        for (ModelElement client : modelElement.getClients()) {
            assertTrue("Should add relationship.", client.containsClientDependency(modelElement));
        }
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToModelWithNullModelElement() {
        abstractionUtil = new AbstractionUtil();

        try {
            abstractionUtil.addElementToModel(null, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with null namespace. IllegalArgumentException
     * is expected.
     */
    public void testAddElementToModelWithNullNamespace() {
        abstractionUtil = new AbstractionUtil();

        try {
            abstractionUtil.addElementToModel(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test removeElementFromModel, with correct modelElement.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRemoveElementFromModelSimple() throws Exception {
        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        abstractionUtil = new AbstractionUtil();

        abstractionUtil.removeElementFromModel(modelElement);

        for (ModelElement supplier : modelElement.getSuppliers()) {
            assertFalse("Should remove relationship.", supplier.containsSupplierDependency(modelElement));
        }
        for (ModelElement client : modelElement.getClients()) {
            assertFalse("Should remove relationship.", client.containsClientDependency(modelElement));
        }
    }

    /**
     * Test removeElementFromModel, with correct modelElement.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRemoveElementFromModel() throws Exception {
        ModelElement testSupplier = new InterfaceImpl();
        testSupplier.addSupplierDependency(modelElement);
        ModelElement testClient = new InterfaceImpl();
        testClient.addClientDependency(modelElement);

        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);
        modelElement.addSupplier(testSupplier);
        modelElement.addClient(testClient);

        abstractionUtil = new AbstractionUtil();

        abstractionUtil.removeElementFromModel(modelElement);

        for (ModelElement supplier : modelElement.getSuppliers()) {
            assertFalse("Should remove relationship.", supplier.containsSupplierDependency(modelElement));
        }
        for (ModelElement client : modelElement.getClients()) {
            assertFalse("Should remove relationship.", client.containsClientDependency(modelElement));
        }
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testRemoveElementFromModelWithNullModelElement() {
        abstractionUtil = new AbstractionUtil();

        try {
            abstractionUtil.removeElementFromModel(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToClipboard() throws Exception {
        abstractionUtil = new AbstractionUtil();

        abstractionUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.ABSTRACTION_FLAVOR) instanceof AbstractionImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.ABSTRACTION_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        abstractionUtil = new AbstractionUtil();

        try {
            abstractionUtil.addElementToClipboard(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with null classUtil. IllegalArgumentException
     * is expected.
     */
    public void testAddElementToClipboardWithNullClassUtil() {
        abstractionUtil = new AbstractionUtil();

        try {
            abstractionUtil.addElementToClipboard(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyElement, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCopyElement() throws Exception {
        abstractionUtil = new AbstractionUtil();

        Abstraction newModleElement = (Abstraction) abstractionUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertEquals("Copy failed.", modelElement.getMapping(), newModleElement.getMapping());
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        abstractionUtil = new AbstractionUtil();

        try {
            abstractionUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}