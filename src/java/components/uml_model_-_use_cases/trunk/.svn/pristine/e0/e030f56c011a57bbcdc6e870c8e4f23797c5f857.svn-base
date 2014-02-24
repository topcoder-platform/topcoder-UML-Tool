/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UseCaseRelationshipAbstractImpl.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseRelationshipAbstractImplTests extends TestCase {
    /**
     * <p>
     * UseCaseRelationshipAbstractImpl instance for testing.
     * </p>
     */
    private UseCaseRelationshipAbstractImpl relationship;

    /**
     * <p>
     * The base use case in the relationship.
     * </p>
     */
    private UseCase base;

    /**
     * <p>
     * The target use case in the relationship.
     * </p>
     */
    private UseCase target;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        base = new UseCaseImpl();
        target = new UseCaseImpl();

        relationship = new MockUseCaseRelationshipImpl(base, target);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        base = null;
        target = null;
        relationship = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UseCaseRelationshipAbstractImplTests.class);
    }

    /**
     * <p>
     * Tests ctor UseCaseRelationshipAbstractImpl#UseCaseRelationshipAbstractImpl(UseCase,UseCase) for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new UseCaseRelationshipAbstractImpl instance.",
            new MockUseCaseRelationshipImpl(base, target));
    }

    /**
     * <p>
     * Tests ctor UseCaseRelationshipAbstractImpl#UseCaseRelationshipAbstractImpl(UseCase,UseCase) for accuracy.
     * It tests the case that when base is null and expects success.
     * </p>
     */
    public void testCtor1_NullBase() {
        assertNotNull("Failed to create a new UseCaseRelationshipAbstractImpl instance.",
            new MockUseCaseRelationshipImpl(null, target));
    }

    /**
     * <p>
     * Tests ctor UseCaseRelationshipAbstractImpl#UseCaseRelationshipAbstractImpl(UseCase,UseCase) for accuracy.
     * It tests the case that when target is null and expects success.
     * </p>
     */
    public void testCtor1_NullTarget() {
        assertNotNull("Failed to create a new UseCaseRelationshipAbstractImpl instance.",
            new MockUseCaseRelationshipImpl(base, null));
    }

    /**
     * <p>
     * Tests ctor UseCaseRelationshipAbstractImpl#UseCaseRelationshipAbstractImpl() for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new UseCaseRelationshipAbstractImpl instance.",
            new MockUseCaseRelationshipImpl());
    }

    /**
     * <p>
     * Tests UseCaseRelationshipAbstractImpl#getBase() for accuracy.
     * </p>
     *
     * <p>
     * Expects same base use case be returned.
     * </p>
     */
    public void testGetBase() {
        assertSame("Failed to get the correct base use case.", base, relationship.getBase());
    }

    /**
     * <p>
     * Tests UseCaseRelationshipAbstractImpl#getTarget() for accuracy.
     * </p>
     *
     * <p>
     * Expects same target use case be returned.
     * </p>
     */
    public void testGetTarget() {
        assertSame("Failed to get the correct target use case.", target, relationship.getTarget());
    }

    /**
     * <p>
     * Tests UseCaseRelationshipAbstractImpl#setBase(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the use case is set correctly.
     * </p>
     */
    public void testSetBase() {
        UseCase other = new UseCaseImpl();

        relationship.setBase(other);

        assertSame("Failed to get the correct base use case.", other, relationship.getBase());
    }

    /**
     * <p>
     * Tests UseCaseRelationshipAbstractImpl#setBase(UseCase) for accuracy.
     * It tests the case that when base is null and expects success.
     * </p>
     */
    public void testSetBase_NullBase() {
        relationship.setBase(null);

        assertNull("Expects null base use case.", relationship.getBase());
    }

    /**
     * <p>
     * Tests UseCaseRelationshipAbstractImpl#setTarget(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the use case is set correctly.
     * </p>
     */
    public void testSetTarget() {
        UseCase other = new UseCaseImpl();

        relationship.setTarget(other);

        assertSame("Failed to get the correct target use case.", other, relationship.getTarget());
    }

    /**
     * <p>
     * Tests UseCaseRelationshipAbstractImpl#setTarget(UseCase) for accuracy.
     * It tests the case that when target is null and expects success.
     * </p>
     */
    public void testSetTarget_NullTarget() {
        relationship.setTarget(null);

        assertNull("Expects null target use case.", relationship.getTarget());
    }

    /**
     * <p>
     * This is the mock implementation of abstract class UseCaseRelationshipAbstractImpl.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockUseCaseRelationshipImpl extends UseCaseRelationshipAbstractImpl {
        /**
         * <p>
         * Default constructor.
         * </p>
         */
        public MockUseCaseRelationshipImpl() {
            // empty
        }

        /**
         * <p>
         * Constructor with base and target use case specified.
         * </p>
         *
         * @param base base
         * @param target target
         */
        public MockUseCaseRelationshipImpl(UseCase base, UseCase target) {
            super(base, target);
        }
    }

}