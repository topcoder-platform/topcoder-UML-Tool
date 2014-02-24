/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core.classifiers.stresstests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;

/**
 * <p>
 * Stress test cases for <code>EnumerationImpl</code> class.
 * </p>
 *
 * @author Wendell
 * @version 1.0
 */
public class EnumerationImplStressTest extends TestCase {
    /**
     * <p>
     * The times that an operation will be run.
     * </p>
     */
    private static final int COUNT = 10000;

    /**
     * <p>
     * The EnumerationImpl instance to test against.
     * </p>
     */
    private EnumerationImpl enumImpl;

    /**
     * <p>
     * Creates the EnumerationImpl instance for testing.
     * </p>
     */
    protected void setUp() {
        enumImpl = new EnumerationImpl();
    }

    /**
     * <p>
     * Clears the test environment.
     * </p>
     */
    protected void tearDown() {
        enumImpl.clearLiterals();
        enumImpl = null;
    }

    /**
     * <p>
     * Tests the <code>addLiteral(EnumerationLiteral)</code> method.
     * </p>
     */
    public void testAddLiteral1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiteral(new EnumerationLiteralImpl());
        }
        long end = System.currentTimeMillis();
        assertEquals(COUNT, enumImpl.countLiterals());
        System.out.println("running addLiteral(EnumerationLiteral) " + COUNT
                + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>addLiteral(int, EnumerationLiteral)</code> method.
     * </p>
     */
    public void testAddLiteral2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiteral(0, new EnumerationLiteralImpl());
        }
        long end = System.currentTimeMillis();
        assertEquals(COUNT, enumImpl.countLiterals());
        System.out.println("running addLiteral(int, EnumerationLiteral) "
                + COUNT + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>addLiterals(Collection<EnumerationLiteral>)</code>
     * method.
     * </p>
     */
    public void testAddLiteral3() {
        List<List<EnumerationLiteral>> enumLiterals = new ArrayList<List<EnumerationLiteral>>();
        for (int i = 0; i < COUNT; i++) {
            List<EnumerationLiteral> enums = new ArrayList<EnumerationLiteral>();
            enums.add(new EnumerationLiteralImpl());
            enums.add(new EnumerationLiteralImpl());
            enumLiterals.add(enums);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiterals(enumLiterals.get(i));
        }
        long end = System.currentTimeMillis();
        assertEquals(COUNT * 2, enumImpl.countLiterals());
        System.out
                .println("running addLiterals(Collection<EnumerationLiteral>) "
                        + COUNT + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>addLiterals(int, Collection<EnumerationLiteral>)</code>
     * method.
     * </p>
     */
    public void testAddLiteral4() {
        List<List<EnumerationLiteral>> enumLiterals = new ArrayList<List<EnumerationLiteral>>();
        for (int i = 0; i < COUNT; i++) {
            List<EnumerationLiteral> enums = new ArrayList<EnumerationLiteral>();
            enums.add(new EnumerationLiteralImpl());
            enums.add(new EnumerationLiteralImpl());
            enumLiterals.add(enums);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiterals(i, enumLiterals.get(i));
        }
        long end = System.currentTimeMillis();
        assertEquals(COUNT * 2, enumImpl.countLiterals());
        System.out
                .println("running addLiterals(int, Collection<EnumerationLiteral>) "
                        + COUNT + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>setLiteral(int, EnumerationLiteral)</code> method.
     * </p>
     */
    public void testSetLiteral() {
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiteral(0, new EnumerationLiteralImpl());
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.setLiteral(0, new EnumerationLiteralImpl());
        }
        long end = System.currentTimeMillis();
        assertEquals(COUNT, enumImpl.countLiterals());
        System.out.println("running setLiteral(int, EnumerationLiteral) "
                + COUNT + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>removeLiteral(int)</code> method.
     * </p>
     */
    public void testRemoveLiteral1() {
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiteral(new EnumerationLiteralImpl());
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.removeLiteral(0);
        }
        long end = System.currentTimeMillis();
        assertEquals(0, enumImpl.countLiterals());
        System.out.println("running removeLiteral(int) " + COUNT
                + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>removeLiteral(EnumerationLiteral)</code> method.
     * </p>
     */
    public void testRemoveLiteral2() {
        EnumerationLiteral[] enums = new EnumerationLiteral[COUNT];
        for (int i = 0; i < COUNT; i++) {
            enums[i] = new EnumerationLiteralImpl();
            enumImpl.addLiteral(enums[i]);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            enumImpl.removeLiteral(enums[i]);
        }
        long end = System.currentTimeMillis();
        assertEquals(0, enumImpl.countLiterals());
        System.out.println("running removeLiteral(EnumerationLiteral) " + COUNT
                + " times takes " + (end - start) + "ms");
    }

    /**
     * <p>
     * Tests the <code>getLiterals()</code> method.
     * </p>
     */
    public void testGetLiterals() {
        for (int i = 0; i < COUNT; i++) {
            enumImpl.addLiteral(new EnumerationLiteralImpl());
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            assertEquals(COUNT, enumImpl.getLiterals().size());
        }
        long end = System.currentTimeMillis();
        System.out.println("running getLiterals() " + COUNT + " times takes "
                + (end - start) + "ms");
    }
}
