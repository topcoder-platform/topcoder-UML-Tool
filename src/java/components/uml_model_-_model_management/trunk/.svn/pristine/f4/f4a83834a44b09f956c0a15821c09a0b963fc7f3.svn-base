/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement.stresstests;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * This is the stress test for <code>PackageImpl</code>.
 * @author fuyun
 * @version 1.0
 */
public class PackageImplStressTest extends TestCase {

    /**
     * The number of loop.
     */
    private static final int NUM = 1000;

    /**
     * Represetns the <code>PackageImpl</code> instance used for test.
     */
    private PackageImpl impl = null;

    /**
     * Sets up the test environment.
     */
    public void setUp() {
        impl = new PackageImpl();
    }

    /**
     * Cleans up the test environment.
     */
    public void tearDown() {
        impl = null;
    }

    /**
     * Stress test for method <code>addElementImport</code> and
     * <code>removeElementImport</code>.
     */
    public void testAddRemoveElementImportStress() {
        long begin = System.currentTimeMillis();
        ElementImport[] elementImports = new ElementImport[NUM];
        for (int i = 0; i < NUM; i++) {
            elementImports[i] = new ElementImportImpl();
        }
        for (int i = 0; i < NUM; i++) {
            impl.addElementImport(elementImports[i]);

        }

        for (int i = 0; i < NUM; i++) {
            impl.removeElementImport(elementImports[i]);

        }

        long end = System.currentTimeMillis();
        System.out.println("testAddRemoveElementImportStress takes " + (end - begin) + " ms");
    }

    /**
     * Stress test for method <code>addElementImports</code> and
     * <code>removeElementImports</code>.
     */
    public void testAddRemoveElementImportsStress() {

        Collection<ElementImport> elementImports = new ArrayList<ElementImport>();
        for (int i = 0; i < NUM; i++) {
            elementImports.add(new ElementImportImpl());
        }

        long begin = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            impl.addElementImports(elementImports);
            assertTrue("Fails to remove ElementImport collection.", impl
                        .removeElementImports(elementImports));
        }
        long end = System.currentTimeMillis();
        System.out.println("testAddRemoveElementImportsStress takes " + (end - begin) + " ms");
    }

    /**
     * Stress test for method <code>addElementImports</code> and
     * <code>clearElementImports</code>.
     */
    public void testAddClearElementImportsStress() {

        Collection<ElementImport> elementImports = new ArrayList<ElementImport>();
        for (int i = 0; i < NUM; i++) {
            elementImports.add(new ElementImportImpl());
        }

        long begin = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            impl.addElementImports(elementImports);
            impl.clearElementImports();
        }
        long end = System.currentTimeMillis();
        System.out.println("testAddClearElementImportsStress takes " + (end - begin) + " ms");
    }

    /**
     * Stress test for method <code>addElementImports</code> and
     * <code>getElementImports</code>.
     */
    public void testAddGetElementImportsStress() {

        Collection<ElementImport> elementImports = new ArrayList<ElementImport>();
        for (int i = 0; i < NUM; i++) {
            elementImports.add(new ElementImportImpl());
        }

        long begin = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            impl.addElementImports(elementImports);
            assertEquals("Fails to get ElementImports.", 1000 * (i + 1), impl.getElementImports()
                        .size());
        }
        long end = System.currentTimeMillis();
        System.out.println("testAddGetElementImportsStress takes " + (end - begin) + " ms");
    }

}
