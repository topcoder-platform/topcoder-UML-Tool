/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ExtendImpl.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExtendImplTests extends TestCase {
    /**
     * <p>
     * ExtendImpl instance for testing.
     * </p>
     */
    private ExtendImpl extend;

    /**
     * <p>
     * The base use case used by the relationship.
     * </p>
     */
    private UseCase base;

    /**
     * <p>
     * The extension use case used by the relationship.
     * </p>
     */
    private UseCase extension;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        base = new UseCaseImpl();
        extension = new UseCaseImpl();

        extend = new ExtendImpl(base, extension);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        base = null;
        extension = null;
        extend = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ExtendImplTests.class);
    }

    /**
     * <p>
     * Tests ctor ExtendImpl#ExtendImpl(UseCase,UseCase) for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new ExtendImpl instance.", new ExtendImpl(base, extension));
    }

    /**
     * <p>
     * Tests ctor ExtendImpl#ExtendImpl(UseCase,UseCase) for accuracy.
     * It tests the case that when base is null and expects success.
     * </p>
     */
    public void testCtor1_NullBase() {
        assertNotNull("Failed to create a new ExtendImpl instance.", new ExtendImpl(null, extension));
    }

    /**
     * <p>
     * Tests ctor ExtendImpl#ExtendImpl(UseCase,UseCase) for accuracy.
     * It tests the case that when extension is null and expects success.
     * </p>
     */
    public void testCtor1_NullExtension() {
        assertNotNull("Failed to create a new ExtendImpl instance.", new ExtendImpl(base, null));
    }

    /**
     * <p>
     * Tests ctor ExtendImpl#ExtendImpl() for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new ExtendImpl instance.", new ExtendImpl());
    }

    /**
     * <p>
     * Tests ExtendImpl#setExtension(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the set extension operation work correctly.
     * </p>
     */
    public void testSetExtension() {
        UseCase other = new UseCaseImpl();

        extend.setExtension(other);

        assertSame("Failed to get the correct extension use case.", other, extend.getExtension());
    }

    /**
     * <p>
     * Tests ExtendImpl#setExtension(UseCase) for failure.
     * It tests the case that when extension is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetExtension_NullExtension() {
        extend.setExtension(null);

        assertNull("Expects null extension use case.", extend.getExtension());
    }

    /**
     * <p>
     * Tests ExtendImpl#getExtension() for accuracy.
     * </p>
     *
     * <p>
     * Expects the same extension use case be returned.
     * </p>
     */
    public void testGetExtension() {
        assertSame("Failed to get correct extension use case.", extension, extend.getExtension());
    }

    /**
     * <p>
     * Tests ExtendImpl#setCondition(BooleanExpression) for accuracy.
     * </p>
     *
     * <p>
     * Expects same condition be returned.
     * </p>
     */
    public void testSetCondition() {
        BooleanExpression expression = new MockBooleanExpression();

        extend.setCondition(expression);

        assertSame("Failed to get the correct condition.", expression, extend.getCondition());
    }

    /**
     * <p>
     * Tests ExtendImpl#setCondition(BooleanExpression) for failure.
     * It tests the case that when condition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetCondition_NullCondition() {
        extend.setCondition(null);

        assertNull("Expects null condition.", extend.getCondition());
    }

    /**
     * <p>
     * Tests ExtendImpl#getCondition() for accuracy.
     * </p>
     *
     * <p>
     * Expects the default null condition be null.
     * </p>
     */
    public void testGetCondition() {
        assertNull("The default condition should be null.", extend.getCondition());
    }

    /**
     * <p>
     * Mock implementation of interface BooleanExpression.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockBooleanExpression implements BooleanExpression {

        /**
         * <p>
         * Not implemented.
         * </p>
         *
         * @return null.
         */
        public String getLanguage() {
            return null;
        }

        /**
         * <p>
         * Not implemented.
         * </p>
         *
         * @param language language
         */
        public void setLanguage(String language) {
            // empty
        }

        /**
         * <p>
         * Not implemented.
         * </p>
         *
         * @return null.
         */
        public String getBody() {
            return null;
        }

        /**
         * <p>
         * Not implemented.
         * </p>
         *
         * @param body body
         */
        public void setBody(String body) {
        }

        /**
         *
         * <p>
         * Not implemented.
         * </p>
         *
         * @return null.
         */
        public Procedure getProcedure() {
            return null;
        }

        /**
         * <p>
         * Not implemented.
         * </p>
         *
         * @param procedure procedure
         */
        public void setProcedure(Procedure procedure) {
            // empty
        }
    }
}