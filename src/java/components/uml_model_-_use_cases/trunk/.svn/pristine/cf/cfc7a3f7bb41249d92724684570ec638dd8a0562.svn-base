/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;

/**
 * <p>
 * Unit test cases for UseCaseImpl.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseImplTests extends TestCase {
    /**
     * <p>
     * UseCaseImpl instance for testing.
     * </p>
     */
    private UseCaseImpl useCase;

    /**
     * <p>
     * Another UseCaseImpl instance that may have association with the tested use case.
     * </p>
     */
    private UseCase useCase2;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        useCase = new UseCaseImpl();
        useCase2 = new UseCaseImpl();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        useCase = null;
        useCase2 = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UseCaseImplTests.class);
    }

    /**
     * <p>
     * Tests ctor UseCaseImpl#UseCaseImpl() for accuracy.
     * </p>
     *
     * <p>
     * The newly created instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new UseCaseImpl instance.", new UseCaseImpl());
    }

    /**
     * <p>
     * Tests UseCaseImpl#addInclude(Include) for accuracy.
     * </p>
     *
     * <p>
     * Expects the include relationship is added correctly.
     * </p>
     */
    public void testAddInclude() {
        Include include = new IncludeImpl(useCase, useCase2);

        useCase.addInclude(include);

        assertTrue("The include relationship is not added.", useCase.containsInclude(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addInclude(Include) for failure.
     * It tests the case that when include is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInclude_NullInclude() {
        try {
            useCase.addInclude(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#addInclude(Include) for failure.
     * It tests the case that when include is invalid and expects IllegalArgumentException.
     * </p>
     */
    public void testAddInclude_InvalidInclude() {
        // The base use case is not the currently tested use case
        Include include = new IncludeImpl();

        try {
            useCase.addInclude(include);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeInclude(Include) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Include relationship is contained before removing.
     * </p>
     */
    public void testRemoveInclude() {
        Include include = new IncludeImpl(useCase, useCase2);
        useCase.addInclude(include);

        assertTrue("The include relationship should be removed.", useCase.removeInclude(include));
        assertFalse("The include relationship should be removed.", useCase.containsInclude(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeInclude(Include) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Include relationship is not contained before removing.
     * </p>
     */
    public void testRemoveInclude2() {
        Include include = new IncludeImpl(useCase, useCase2);

        assertFalse("No Include relationship should be removed.", useCase.removeInclude(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeInclude(Include) for failure.
     * It tests the case that when include is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveInclude_NullInclude() {
        try {
            useCase.removeInclude(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#clearIncludes() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the includes are cleared.
     * </p>
     */
    public void testClearIncludes() {
        Include include = new IncludeImpl(useCase, useCase2);
        useCase.addInclude(include);

        useCase.clearIncludes();

        assertEquals("The clear operation fails.", 0, useCase.getIncludes().size());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getIncludes() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the includes be returned.
     * </p>
     */
    public void testGetIncludes() {
        Include include = new IncludeImpl(useCase, useCase2);
        useCase.addInclude(include);

        Collection<Include> includes = useCase.getIncludes();
        assertEquals("The size should be one.", 1, includes.size());
        assertTrue("The include instance should be contained.", includes.contains(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsInclude(Include) for accuracy.
     * </p>
     *
     * <p>
     * Expects the include relationship be contained after it is added.
     * </p>
     */
    public void testContainsInclude() {
        Include include = new IncludeImpl(useCase, useCase2);

        assertFalse("The include should not be contained.", useCase.containsInclude(include));

        useCase.addInclude(include);

        assertTrue("The include should be contained.", useCase.containsInclude(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsInclude(Include) for failure.
     * It tests the case that when include is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsInclude_NullInclude() {
        try {
            Include include = null;
            useCase.containsInclude(include);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsInclude(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Two situations are tested: the use case is contained and not contained.
     * </p>
     */
    public void testContainsIncludeForUseCase() {
        assertFalse("The useCase2 should not be contained.", useCase.containsInclude(useCase2));

        Include include = new IncludeImpl(useCase, useCase2);
        useCase.addInclude(include);

        assertTrue("The useCase2 should be contained.", useCase.containsInclude(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsInclude(UseCase) for failure.
     * It tests the case that when useCase is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsInclude_NullUseCase() {
        try {
            UseCase nullUseCase = null;
            useCase.containsInclude(nullUseCase);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#countIncludes() for accuracy.
     * </p>
     *
     * <p>
     * Expects one be returned when there is only one include relationship contained.
     * </p>
     */
    public void testCountIncludes() {
        Include include = new IncludeImpl(useCase, useCase2);
        useCase.addInclude(include);

        assertEquals("The count is not correct.", 1, useCase.countIncludes());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getIncludedUseCases() for accuracy.
     * </p>
     *
     * <p>
     * Expects the use cases returned by getIncludedUseCases() are correct.
     * </p>
     */
    public void testGetIncludedUseCases() {
        Include include = new IncludeImpl(useCase, useCase2);
        useCase.addInclude(include);

        Collection<UseCase> useCases = useCase.getIncludedUseCases();
        assertEquals("The size should be one.", 1, useCases.size());
        assertTrue("The useCase2 instance should be contained.", useCases.contains(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addIncluder(Include) for accuracy.
     * </p>
     *
     * <p>
     * Expects the include relationship be added.
     * </p>
     */
    public void testAddIncluder() {
        Include include = new IncludeImpl(useCase2, useCase);

        useCase.addIncluder(include);

        assertTrue("The include relationship is not added.", useCase.containsIncluder(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addIncluder(Include) for failure.
     * It tests the case that when includer is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddIncluder_NullIncluder() {
        try {
            useCase.addIncluder(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#addIncluder(Include) for failure.
     * It tests the case that when includer is invalid and expects IllegalArgumentException.
     * </p>
     */
    public void testAddIncluder_InvalidIncluder() {
        // the addition use case is not the use case currently tested
        Include include = new IncludeImpl();

        try {
            useCase.addIncluder(include);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeIncluder(Include) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Include relationship is contained before removing.
     * </p>
     */
    public void testRemoveIncluder() {
        Include include = new IncludeImpl(useCase2, useCase);
        useCase.addIncluder(include);

        assertTrue("The include relationship should be removed.", useCase.removeIncluder(include));
        assertFalse("The include relationship should be removed.", useCase.containsIncluder(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeIncluder(Include) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Include relationship is not contained before removing.
     * </p>
     */
    public void testRemoveIncluder2() {
        Include include = new IncludeImpl(useCase2, useCase);

        assertFalse("No Include relationship should be removed.", useCase.removeIncluder(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeIncluder(Include) for failure.
     * It tests the case that when includer is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveIncluder_NullIncluder() {
        try {
            useCase.removeIncluder(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#clearIncluders() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the includer relationships are cleared.
     * </p>
     */
    public void testClearIncluders() {
        Include include = new IncludeImpl(useCase2, useCase);
        useCase.addIncluder(include);

        useCase.clearIncluders();

        assertEquals("The clear opertaion fails.", 0, useCase.getIncluders().size());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getIncluders() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the includers are returned.
     * </p>
     */
    public void testGetIncluders() {
        Include include = new IncludeImpl(useCase2, useCase);
        useCase.addIncluder(include);

        Collection<Include> includers = useCase.getIncluders();
        assertEquals("The size should be one.", 1, includers.size());
        assertTrue("The include instance should be contained.", includers.contains(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsIncluder(Include) for accuracy.
     * </p>
     *
     * <p>
     * Expects the includer be contained after it is added.
     * </p>
     */
    public void testContainsIncluder() {
        Include include = new IncludeImpl(useCase2, useCase);

        assertFalse("The include should not be contained.", useCase.containsIncluder(include));

        useCase.addIncluder(include);

        assertTrue("The include should be contained.", useCase.containsIncluder(include));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsIncluder(Include) for failure.
     * It tests the case that when includer is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsIncluder_NullIncluder() {
        try {
            Include include = null;
            useCase.containsIncluder(include);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsIncluder(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the use case be contained after it is added.
     * </p>
     */
    public void testContainsIncluderForUseCase() {
        assertFalse("The useCase2 should not be contained.", useCase.containsIncluder(useCase2));

        Include include = new IncludeImpl(useCase2, useCase);
        useCase.addIncluder(include);

        assertTrue("The useCase2 should be contained.", useCase.containsIncluder(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsIncluder(UseCase) for failure.
     * It tests the case that when useCase is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsIncluder_NullUseCase() {
        try {
            UseCase other = null;
            useCase.containsIncluder(other);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#countIncluders() for accuracy.
     * </p>
     *
     * <p>
     * Expects 1 be returned when there is only one includer relationship.
     * </p>
     */
    public void testCountIncluders() {
        Include include = new IncludeImpl(useCase2, useCase);
        useCase.addIncluder(include);

        assertEquals("The count is not correct.", 1, useCase.countIncluders());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getIncludingUseCases() for accuracy.
     * </p>
     *
     * <p>
     * Expects getIncludingUseCases() return correct use cases.
     * </p>
     */
    public void testGetIncludingUseCases() {
        Include include = new IncludeImpl(useCase2, useCase);
        useCase.addIncluder(include);

        Collection<UseCase> useCases = useCase.getIncludingUseCases();
        assertEquals("The size should be one.", 1, useCases.size());
        assertTrue("The useCase2 instance should be contained.", useCases.contains(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addExtend(Extend) for accuracy.
     * </p>
     *
     * <p>
     * Expects the extend relationship be added.
     * </p>
     */
    public void testAddExtend() {
        Extend extend = new ExtendImpl(useCase2, useCase);

        useCase.addExtend(extend);

        assertTrue("The extend relationship is not added.", useCase.containsExtend(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addExtend(Extend) for failure.
     * It tests the case that when extendRelationship is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddExtend_NullExtendRelationship() {
        try {
            useCase.addExtend(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#addExtend(Extend) for failure.
     * It tests the case that when extendRelationship is invalid and expects IllegalArgumentException.
     * </p>
     */
    public void testAddExtend_InvalidExtendRelationship() {
        // the base use case is not the use case currently tested.
        Extend extend = new ExtendImpl();

        try {
            useCase.addExtend(extend);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeExtend(Extend) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Extend relationship is contained before removing.
     * </p>
     */
    public void testRemoveExtend() {
        Extend extend = new ExtendImpl(useCase2, useCase);
        useCase.addExtend(extend);

        assertTrue("The extend relationship should be removed.", useCase.removeExtend(extend));
        assertFalse("The extend relationship should be removed.", useCase.containsExtend(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeExtend(Extend) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Extend relationship is not contained before removing.
     * </p>
     */
    public void testRemoveExtend2() {
        Extend extend = new ExtendImpl(useCase2, useCase);

        assertFalse("No extend relationship should be removed.", useCase.removeExtend(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeExtend(Extend) for failure.
     * It tests the case that when extendRelationship is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveExtend_NullExtendRelationship() {
        try {
            useCase.removeExtend(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#clearExtends() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the extend relationships are cleared.
     * </p>
     */
    public void testClearExtends() {
        Extend extend = new ExtendImpl(useCase2, useCase);
        useCase.addExtend(extend);

        useCase.clearExtends();

        assertEquals("The clear opertaion fails.", 0, useCase.getExtends().size());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getExtends() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the the extend relationships are returned.
     * </p>
     */
    public void testGetExtends() {
        Extend extend = new ExtendImpl(useCase2, useCase);
        useCase.addExtend(extend);

        Collection<Extend> exts = useCase.getExtends();
        assertEquals("The size should be one.", 1, exts.size());
        assertTrue("The extend instance should be contained.", exts.contains(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtend(Extend) for accuracy.
     * </p>
     *
     * <p>
     * Expects the extend relationship be contained after it is added.
     * </p>
     */
    public void testContainsExtend() {
        Extend extend = new ExtendImpl(useCase2, useCase);

        assertFalse("The extend should not be contained.", useCase.containsExtend(extend));

        useCase.addExtend(extend);

        assertTrue("The extend should be contained.", useCase.containsExtend(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtend(Extend) for failure.
     * It tests the case that when extendRelationship is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsExtend_NullExtendRelationship() {
        try {
            Extend extend = null;
            useCase.containsExtend(extend);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtend(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the use case in the extend relationship be contained after it is added.
     * </p>
     */
    public void testContainsExtendForUseCase() {
        assertFalse("The useCase2 should not be contained.", useCase.containsExtend(useCase2));

        Extend extend = new ExtendImpl(useCase2, useCase);
        useCase.addExtend(extend);

        assertTrue("The useCase2 should be contained.", useCase.containsExtend(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtend(UseCase) for failure.
     * It tests the case that when useCase is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsExtend_NullUseCase() {
        try {
            UseCase other = null;
            useCase.containsExtend(other);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#countExtends() for accuracy.
     * </p>
     *
     * <p>
     * Expects 1 be returned.
     * </p>
     */
    public void testCountExtends() {
        Extend extend = new ExtendImpl(useCase2, useCase);
        useCase.addExtend(extend);

        assertEquals("The count is not correct.", 1, useCase.countExtends());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getBaseUseCases() for accuracy.
     * </p>
     *
     * <p>
     * Expects getBaseUseCases() return the correct use cases.
     * </p>
     */
    public void testGetBaseUseCases() {
        Extend extend = new ExtendImpl(useCase2, useCase);
        useCase.addExtend(extend);

        Collection<UseCase> useCases = useCase.getBaseUseCases();
        assertEquals("The size should be one.", 1, useCases.size());
        assertTrue("The useCase2 instance should be contained.", useCases.contains(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addExtender(Extend) for accuracy.
     * </p>
     *
     * <p>
     * Expects the extender relationship is added.
     * </p>
     */
    public void testAddExtender() {
        Extend extend = new ExtendImpl(useCase, useCase2);

        useCase.addExtender(extend);

        assertTrue("The extend relationship is not added.", useCase.containsExtender(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#addExtender(Extend) for failure.
     * It tests the case that when extender is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddExtender_NullExtender() {
        try {
            useCase.addExtender(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#addExtender(Extend) for failure.
     * It tests the case that when extender is invalid and expects IllegalArgumentException.
     * </p>
     */
    public void testAddExtender_InvalidExtender() {
        // the extension use case is not the use case currently tested.
        Extend extend = new ExtendImpl();

        try {
            useCase.addExtender(extend);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeExtender(Extend) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Extend relationship is contained before removing.
     * </p>
     */
    public void testRemoveExtender() {
        Extend extend = new ExtendImpl(useCase, useCase2);
        useCase.addExtender(extend);

        assertTrue("The extend relationship should be removed.", useCase.removeExtender(extend));
        assertFalse("The extend relationship should be removed.", useCase.containsExtender(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeExtender(Extend) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the Extend relationship is not contained before removing.
     * </p>
     */
    public void testRemoveExtender2() {
        Extend extend = new ExtendImpl(useCase, useCase2);

        assertFalse("No extend relationship should be removed.", useCase.removeExtender(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#removeExtender(Extend) for failure.
     * It tests the case that when extender is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveExtender_NullExtender() {
        try {
            useCase.removeExtender(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#clearExtenders() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the extender relationships are cleared.
     * </p>
     */
    public void testClearExtenders() {
        Extend extend = new ExtendImpl(useCase, useCase2);
        useCase.addExtender(extend);

        useCase.clearExtenders();

        assertEquals("The clear operation fails.", 0, useCase.getExtenders().size());

    }

    /**
     * <p>
     * Tests UseCaseImpl#getExtenders() for accuracy.
     * </p>
     *
     * <p>
     * Expects all the extender relationships are returned.
     * </p>
     */
    public void testGetExtenders() {
        Extend extend = new ExtendImpl(useCase, useCase2);
        useCase.addExtender(extend);

        Collection<Extend> extenders = useCase.getExtenders();
        assertEquals("The size should be one.", 1, extenders.size());
        assertTrue("The extend instance should be contained.", extenders.contains(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtender(Extend) for accuracy.
     * </p>
     *
     * <p>
     * Expects the extender relationship be contained after it is added.
     * </p>
     */
    public void testContainsExtender() {
        Extend extend = new ExtendImpl(useCase, useCase2);

        assertFalse("The extend should not be contained.", useCase.containsExtender(extend));

        useCase.addExtender(extend);

        assertTrue("The extend should be contained.", useCase.containsExtender(extend));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtender(Extend) for failure.
     * It tests the case that when extender is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsExtender_NullExtender() {
        try {
            Extend extend = null;
            useCase.containsExtender(extend);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtender(UseCase) for accuracy.
     * </p>
     *
     * <p>
     * Expects the use case be contained after it is added.
     * </p>
     */
    public void testContainsExtenderForUseCase() {
        assertFalse("The useCase2 should not be contained.", useCase.containsExtender(useCase2));

        Extend extend = new ExtendImpl(useCase, useCase2);
        useCase.addExtender(extend);

        assertTrue("The useCase2 should be contained.", useCase.containsExtender(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#containsExtender(UseCase) for failure.
     * It tests the case that when useCase is null and expects IllegalArgumentException.
     * </p>
     */
    public void testContainsExtender_NullUseCase() {
        try {
            UseCase other = null;
            useCase.containsExtender(other);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UseCaseImpl#countExtenders() for accuracy.
     * </p>
     *
     * <p>
     * Expects 1.
     * </p>
     */
    public void testCountExtenders() {
        Extend extend = new ExtendImpl(useCase, useCase2);
        useCase.addExtender(extend);

        assertEquals("The count is not correct.", 1, useCase.countExtenders());
    }

    /**
     * <p>
     * Tests UseCaseImpl#getSubUseCases() for accuracy.
     * </p>
     *
     * <p>
     * Expects getSubUseCases return the correct use case.
     * </p>
     */
    public void testGetSubUseCases() {
        Extend extend = new ExtendImpl(useCase, useCase2);
        useCase.addExtender(extend);

        Collection<UseCase> useCases = useCase.getSubUseCases();
        assertEquals("The size should be one.", 1, useCases.size());
        assertTrue("The useCase2 instance should be contained.", useCases.contains(useCase2));
    }

    /**
     * <p>
     * Tests UseCaseImpl#getActors() for accuracy.
     * </p>
     *
     * <p>
     * Expecs all the actors are returned.
     * </p>
     */
    public void testGetActors() {
        Actor actor = new ActorImpl();
        TestHelper.setupConnection(actor, useCase);

        Collection<Actor> actors = useCase.getActors();
        assertEquals("The count of associated actor should be only one.", 1, actors.size());
        assertTrue("Failed to get the correct associated actor", actors.contains(actor));
    }

}