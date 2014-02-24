/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class DependencyUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DependencyUtilTest extends TestCase {

    /**
     * The DependencyUtil instance for the test.
     */
    private DependencyUtil dependencyUtil;

    /**
     * The Dependency instance for the test.
     */
    private Dependency modelElement = new DependencyImpl();

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
        dependencyUtil = new DependencyUtil();
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToModelSimple() throws Exception {
        modelElement.setNamespace(namespace);

        dependencyUtil = new DependencyUtil();

        dependencyUtil.addElementToModel(modelElement, namespace);

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
        Namespace org = new ModelImpl();
        org.setNamespace(namespace);
        Namespace tc = new ModelImpl();
        tc.setNamespace(com);

        // supplier's namespace: namespace.com.tc
        ModelElement testSupplier = new InterfaceImpl();
        testSupplier.setNamespace(tc);

        // client's namespace: namespace.org
        ModelElement testClient = new InterfaceImpl();
        testClient.setNamespace(org);

        modelElement.setNamespace(namespace);
        modelElement.addSupplier(testSupplier);
        modelElement.addClient(testClient);

        dependencyUtil = new DependencyUtil();

        dependencyUtil.addElementToModel(modelElement, namespace);

        // modelElement's namespace should be namespace
        assertTrue("Should be added to the Namespace namespace.", namespace.containsOwnedElement(modelElement));

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
        dependencyUtil = new DependencyUtil();

        try {
            dependencyUtil.addElementToModel(null, namespace);
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
        dependencyUtil = new DependencyUtil();

        try {
            dependencyUtil.addElementToModel(modelElement, null);
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
    public void testRemoveElementFromModel() throws Exception {
        ModelElement testSupplier = new InterfaceImpl();
        testSupplier.addSupplierDependency(modelElement);
        ModelElement testClient = new InterfaceImpl();
        testClient.addClientDependency(modelElement);

        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);
        modelElement.addSupplier(testSupplier);
        modelElement.addClient(testClient);

        dependencyUtil = new DependencyUtil();

        dependencyUtil.removeElementFromModel(modelElement);

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
    public void testRemoveElementFromModelSimple() throws Exception {
        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        dependencyUtil = new DependencyUtil();

        dependencyUtil.removeElementFromModel(modelElement);

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
        dependencyUtil = new DependencyUtil();

        try {
            dependencyUtil.removeElementFromModel(null);
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
        dependencyUtil = new DependencyUtil();

        dependencyUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.DEPENDENCY_FLAVOR) instanceof DependencyImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.DEPENDENCY_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        dependencyUtil = new DependencyUtil();

        try {
            dependencyUtil.addElementToClipboard(null, clipboard);
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
        dependencyUtil = new DependencyUtil();

        try {
            dependencyUtil.addElementToClipboard(modelElement, null);
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
        dependencyUtil = new DependencyUtil();

        Dependency newModleElement = (Dependency) dependencyUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertTrue("Copy failed.", newModleElement instanceof DependencyImpl);
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        dependencyUtil = new DependencyUtil();

        try {
            dependencyUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}