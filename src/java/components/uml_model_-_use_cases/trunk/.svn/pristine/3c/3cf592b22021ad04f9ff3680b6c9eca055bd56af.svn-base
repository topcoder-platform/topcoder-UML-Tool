/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import java.util.Collection;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActorImpl.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActorImplTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActorImplTests.class);
    }

    /**
     * <p>
     * Tests ctor ActorImpl#ActorImpl() for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ActorImpl instance.", new ActorImpl());
    }

    /**
     * <p>
     * Tests ActorImpl#getUseCases() for accuracy.
     * </p>
     *
     * <p>
     * Expects correct associated use cases are returned.
     * </p>
     */
    public void testGetUseCases() {
        Actor actor = new ActorImpl();
        UseCase useCase = new UseCaseImpl();
        TestHelper.setupConnection(actor, useCase);

        Collection<UseCase> useCases = actor.getUseCases();
        assertEquals("The count of associated use case should be only one.", 1, useCases.size());
        assertTrue("Failed to get the correct associated use case", useCases.contains(useCase));
    }

}