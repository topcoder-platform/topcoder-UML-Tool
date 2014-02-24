/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for IncludeImpl.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IncludeImplTests extends TestCase {
    /**
     * <p>
     * The IncludeImpl instance for testing.
     * </p>
     */
    private IncludeImpl include;

    /**
     * <p>
     * The base use case used by the relationship.
     * </p>
     */
    private UseCase base;

    /**
     * <p>
     * The addition use case used by the relationship.
     * </p>
     */
    private UseCase addition;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        base = new UseCaseImpl();
        addition = new UseCaseImpl();

        include = new IncludeImpl(base, addition);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        base = null;
        addition = null;

        include = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(IncludeImplTests.class);
    }

    /**
     * <p>
     * Tests ctor IncludeImpl#IncludeImpl(UseCase,UseCase) for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new IncludeImpl instance.", new IncludeImpl(base, addition));
    }

    /**
     * <p>
     * Tests ctor IncludeImpl#IncludeImpl(UseCase,UseCase) for accuracy.
     * It tests the case that when base is null and expects success.
     * </p>
     */
    public void testCtor1_NullBase() {
        assertNotNull("Failed to create a new IncludeImpl instance.", new IncludeImpl(null, addition));
    }

    /**
     * <p>
     * Tests ctor IncludeImpl#IncludeImpl(UseCase,UseCase) for accuracy.
     * It tests the case that when addition is null and expects success.
     * </p>
     */
    public void testCtor1_NullAddition() {
        assertNotNull("Failed to create a new IncludeImpl instance.", new IncludeImpl(base, null));
    }

    /**
     * <p>
     * Tests ctor IncludeImpl#IncludeImpl() for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new IncludeImpl instance.", new IncludeImpl());
    }

    /**
     * <p>
     * Tests IncludeImpl#getAddition() for accuracy.
     * </p>
     *
     * <p>
     * Expects same addition use case be returned.
     * </p>
     */
    public void testGetAddition() {
        assertSame("Failed to get the correct addition use case.", addition, include.getAddition());
    }

    /**
     * <p>
     * Tests IncludeImpl#setAddition(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the use case is added as an addition use case.
     * </p>
     */
    public void testSetAddition() {
        UseCase other = new UseCaseImpl();

        include.setAddition(other);

        assertSame("Failed to get the correct addition use case.", other, include.getAddition());
    }

    /**
     * <p>
     * Tests IncludeImpl#setAddition(UseCase) for failure.
     * It tests the case that when addition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetAddition_NullAddition() {
        include.setAddition(null);

        assertNull("The addition use case should be null.", include.getAddition());
    }

}