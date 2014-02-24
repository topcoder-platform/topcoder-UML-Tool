/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

import junit.framework.TestCase;

/**
 * Failure test for DependencyImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class DependencyImplFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private DependencyImpl dependencyImpl = new DependencyImpl();

    /**
     * This instance is used in the test.
     */
    private ModelElement modelElement = new ModelElementAbstractImpl() {
    };

    /**
     * This instance is used in the test.
     */
    private Collection<ModelElement> modelElements = new ArrayList<ModelElement>();

    /**
     * Sets up the environment for the TestCase.
     *
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        modelElements.add(modelElement);
        modelElements.add(modelElement);
    }

    /**
     * Failure test of <code>addSupplier(ModelElement supplier)</code>.
     * <p>
     * supplier is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddSupplierFailureNullSupplier() throws Exception {
        try {
            dependencyImpl.addSupplier(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addSuppliers(Collection<ModelElement> suppliers)</code>.
     * <p>
     * suppliers is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddSuppliersFailureNullSuppliers() throws Exception {
        try {
            dependencyImpl.addSuppliers(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addSuppliers(Collection<ModelElement> suppliers)</code>.
     * <p>
     * suppliers contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddSuppliersFailureSuppliersContainsNull() throws Exception {
        modelElements.add(null);
        try {
            dependencyImpl.addSuppliers(modelElements);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeSupplier(ModelElement supplier)</code>.
     * <p>
     * supplier is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveSupplierFailureNullSupplier() throws Exception {
        try {
            dependencyImpl.removeSupplier(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>removeSuppliers(Collection<ModelElement> suppliers)</code>.
     * <p>
     * suppliers is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveSuppliersFailureNullSuppliers() throws Exception {
        try {
            dependencyImpl.removeSuppliers(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>removeSuppliers(Collection<ModelElement> suppliers)</code>.
     * <p>
     * suppliers contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveSuppliersFailureSuppliersContainsNull() throws Exception {
        modelElements.add(null);
        try {
            dependencyImpl.removeSuppliers(modelElements);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsSupplier(ModelElement supplier)</code>.
     * <p>
     * supplier is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testContainsSupplierFailureNullSupplier() throws Exception {
        try {
            dependencyImpl.containsSupplier(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addClient(ModelElement client)</code>.
     * <p>
     * client is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddClientFailureNullClient() throws Exception {
        try {
            dependencyImpl.addClient(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addClients(Collection<ModelElement> clients)</code>.
     * <p>
     * clients is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddClientsFailureNullClients() throws Exception {
        try {
            dependencyImpl.addClients(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addClients(Collection<ModelElement> clients)</code>.
     * <p>
     * clients contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddClientsFailureClientsContainsNull() throws Exception {
        modelElements.add(null);
        try {
            dependencyImpl.addClients(modelElements);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeClient(ModelElement client)</code>.
     * <p>
     * client is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveClientFailureNullClient() throws Exception {
        try {
            dependencyImpl.removeClient(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>removeClients(Collection<ModelElement> clients)</code>.
     * <p>
     * clients is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveClientsFailureNullClients() throws Exception {
        try {
            dependencyImpl.removeClients(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>removeClients(Collection<ModelElement> clients)</code>.
     * <p>
     * clients contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveClientsFailureClientsContainsNull() throws Exception {
        modelElements.add(null);
        try {
            dependencyImpl.removeClients(modelElements);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsClient(ModelElement client)</code>.
     * <p>
     * client is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testContainsClientFailureNullClient() throws Exception {
        try {
            dependencyImpl.containsClient(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
