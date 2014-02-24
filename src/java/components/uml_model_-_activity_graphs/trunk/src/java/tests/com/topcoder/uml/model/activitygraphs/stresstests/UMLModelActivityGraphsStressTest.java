/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @(#)UMLModelActivityGraphsStressTest.java
 */
package com.topcoder.uml.model.activitygraphs.stresstests;

import java.util.Random;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.Classifier;

import junit.framework.TestCase;

/**
 * Stress test of UML Model - Activity Graphs version 1.0. This version is rather simple, thus only one test for the <c>
 * ObjectFlowStateImpl</c> class.
 *
 * @author  smell
 * @version 1.0
 */
public class UMLModelActivityGraphsStressTest extends TestCase {

    /**
     * Repeat count of this test.
     */
    private static final int REPEAT_COUNT = 10000;

    /**
     * An array of booleans used by the setSynch method.
     */
    private static final boolean[] SYNCH_ARRAY = new boolean[] { true, false };

    /**
     * An array of Classifier used by the setType method.
     */
    private Classifier[] TYPE_ARRAY = null;

    /**
     * A random number generator for the indice to the arrays.
     */
    private Random random = null;

    /**
     * Sets up the fixtures, it initiats the random, and initializes the array.
     *
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() {
        TYPE_ARRAY = new Classifier[] { null };
        random = new Random(System.currentTimeMillis());
    }

    /**
     * Stress test against the API of <c>ObjectFlowState</c> interface. <c>ObjectFlowStateImpl</c> is the concrete
     * implementation under test.
     */
    public void testObjectFlowStateImpl() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < REPEAT_COUNT; ++i) {
            ObjectFlowState instance = new ObjectFlowStateImpl();

            instance.setSynch(SYNCH_ARRAY[random.nextInt(SYNCH_ARRAY.length)]);
            instance.isSynch();

            instance.setType(TYPE_ARRAY[random.nextInt(TYPE_ARRAY.length)]);
            instance.getType();
        }

        long end = System.currentTimeMillis();
        System.out.format("Test of ObjectFlowStateImpl class, repeated %d times, took %dms%n",
            REPEAT_COUNT, end - start);
        System.out.flush();
    }
}
