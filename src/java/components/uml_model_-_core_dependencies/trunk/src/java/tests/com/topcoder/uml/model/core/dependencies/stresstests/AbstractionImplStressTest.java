/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies.stresstests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.datatypes.expressions.MappingExpression;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionImpl;;
/**
 * <p>
 * Stress test for the AbstractionImpl class.
 * </p>
 *
 * @author coolzhao
 * @version 1.0
 */
public class AbstractionImplStressTest extends TestCase {
    /**
     * <p>
     * MappingExpression for test.
     * </p>
     */
    private static final int OPERATIONS = 1000000;

    /**
     * <p>
     * MappingExpression for test.
     * </p>
     */
    private MappingExpression mapping;

    /**
     * <p>
     * AbstractionImpl for test.
     * </p>
     */
    private AbstractionImpl abstractionImpl;

    /**
     * <p>
     * Prepares the environment for each test.
     * </p>
     */
    protected void setUp() {
        mapping = new MappingExpressionImpl();
        abstractionImpl = new AbstractionImpl();
    }

    /**
     * <p>
     * Test getMapping() and setMapping().
     * </p>
     */
    public void testGetAndSetMappingForManyTimes() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            abstractionImpl.setMapping(mapping);
            assertEquals("testGetSetMapping failed.", mapping, abstractionImpl.getMapping());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testGetAndSetMappingForManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }
}
