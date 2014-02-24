/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies.stresstests;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * <p>
 * Stress test for the DependencyImpl class.
 * </p>
 *
 * @author coolzhao
 * @version 1.0
 */
public class DependencyImplStressTest extends TestCase {
    /**
     * <p>
     * MappingExpression for test.
     * </p>
     */
    private static final int OPERATIONS = 1000;

    /**
     * <p>
     * Supplier for test.
     * </p>
     */
    private ArrayList<ModelElement> suppliersList = new ArrayList<ModelElement>();

    /**
     * <p>
     * Client for test.
     * </p>
     */
    private ArrayList<ModelElement> clientsList = new ArrayList<ModelElement>();

    /**
     * <p>
     * DependencyImpl for test.
     * </p>
     */
    private DependencyImpl dependencyImpl;

    /**
     * <p>
     * Prepares the environment for each test.
     * </p>
     */
    protected void setUp() {
        for (int i = 0; i < OPERATIONS; ++i) {
            suppliersList.add(new ModelElementAbstractImpl() { });
            clientsList.add(new ModelElementAbstractImpl() { });
        }
        dependencyImpl = new DependencyImpl();
    }

    /**
     * <p>
     * Test addClient() and removeClient().
     * </p>
     */
    public void testAddAndRemoveClientManyTimes() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.addClient(clientsList.get(i));
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.removeClient(clientsList.get(i));
            assertEquals("testAddAndRemoveClientManyTimes failed.",
                    OPERATIONS - i - 1, dependencyImpl.countClients());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testAddAndRemoveClientManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test addSupplier() and removeSupplier().
     * </p>
     */
    public void testAddAndRemoveSupplierManyTimes() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.addSupplier(suppliersList.get(i));
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.removeSupplier(suppliersList.get(i));
            assertEquals("testAddAndRemoveSupplierManyTimes failed.",
                    OPERATIONS - i - 1, dependencyImpl.countSuppliers());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testAddAndRemoveSupplierManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test addClients() and removeClients().
     * </p>
     */
    public void testAddAndRemoveClientsManyTimes() {
        ArrayList<ModelElement> arrayList = new ArrayList<ModelElement>();
        arrayList.add(clientsList.get(0));
        arrayList.add(clientsList.get(1));

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.addClients(arrayList);
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.removeClients(arrayList);
            assertEquals("testAddAndRemoveClientsManyTimes failed.",
                    (OPERATIONS - i - 1) * 2, dependencyImpl.countClients());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testAddAndRemoveClientsManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test addSuppliers() and removeSuppliers().
     * </p>
     */
    public void testAddAndRemoveSuppliersManyTimes() {
        ArrayList<ModelElement> arrayList = new ArrayList<ModelElement>();
        arrayList.add(suppliersList.get(0));
        arrayList.add(suppliersList.get(1));

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.addSuppliers(arrayList);
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            dependencyImpl.removeSuppliers(arrayList);
            assertEquals("testAddAndRemoveSuppliersManyTimes failed.",
                    (OPERATIONS - i - 1) * 2, dependencyImpl.countSuppliers());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testAddAndRemoveSuppliersManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test operate clients.
     * </p>
     */
    public void testOperateClients() {
        long startTime = System.currentTimeMillis();

        dependencyImpl.addClients(clientsList);
        for (int i = 0; i < OPERATIONS; ++i) {
            assertTrue("testOperateClients failed.",
                    dependencyImpl.containsClient(clientsList.get(i)));
            assertTrue("testOperateClients failed.",
                    dependencyImpl.getClients().contains(clientsList.get(i)));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testOperateClients");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test operate suppliers.
     * </p>
     */
    public void testOperateSuppliers() {
        long startTime = System.currentTimeMillis();

        dependencyImpl.addSuppliers(suppliersList);
        for (int i = 0; i < OPERATIONS; ++i) {
            assertTrue("testOperateSuppliers failed.",
                    dependencyImpl.containsSupplier(suppliersList.get(i)));
            assertTrue("testOperateSuppliers failed.",
                    dependencyImpl.getSuppliers().contains(suppliersList.get(i)));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testOperateSuppliers");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }
}
