/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import java.util.Collection;

import com.topcoder.uml.model.core.Classifier;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UseCaseUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseUtilTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UseCaseUtilTests.class);
    }

    /**
     * <p>
     * Tests UseCaseUtil#findAssociatedEnd(Classifier,Class) for accuracy.
     * </p>
     *
     * <p>
     * Expects the associated classfiers are returned correctly.
     * </p>
     */
    public void testFindAssociatedEnd() {
        Actor actor = new ActorImpl();
        UseCase useCase = new UseCaseImpl();
        TestHelper.setupConnection(actor, useCase);

        Collection<Classifier> classifiers = UseCaseUtil.findAssociatedEnd(actor, UseCase.class);
        assertEquals("The count of associated classifiers should be only one.", 1, classifiers.size());
        assertTrue("Failed to get the correct associated classfiers", classifiers.contains(useCase));
    }

    /**
     * <p>
     * Tests UseCaseUtil#findAssociatedEnd(Classifier,Class) for failure.
     * It tests the case that when source is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFindAssociatedEnd_NullSource() {
        try {
            UseCaseUtil.findAssociatedEnd(null, Actor.class);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseUtil#findAssociatedEnd(Classifier,Class) for failure.
     * It tests the case that when endType is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFindAssociatedEnd_NullEndType() {
        try {
            UseCaseUtil.findAssociatedEnd(new ActorImpl(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseUtil#findAssociatedEnd(Classifier,Class) for failure.
     * It tests the case that when endType is not a sub-interface of Classifier and expects IllegalArgumentException.
     * </p>
     */
    public void testFindAssociatedEnd_InvalidEndType() {
        try {
            UseCaseUtil.findAssociatedEnd(new ActorImpl(), String.class);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}