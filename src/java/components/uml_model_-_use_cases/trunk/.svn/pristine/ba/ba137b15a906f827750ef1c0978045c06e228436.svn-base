/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases.failuretests;

import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A failure test for {@link UseCaseImpl} class. Tests the proper handling of invalid input data by the methods.
 * Passes the invalid arguments to the methods and expects the appropriate exception to be thrown.</p>
 *
 * @author isv
 * @version 1.0
 */
public class UseCaseImplFailureTest extends TestCase {

    /**
     * <p>The instances of {@link UseCaseImpl} which are tested. These instances are initialized in {@link #setUp()}
     * method and released in {@link #tearDown()} method. Each instance is initialized using a separate constructor
     * provided by the tested class.<p>
     */
    private UseCaseImpl[] testedInstances = null;

    /**
     * <p>Gets the test suite for {@link UseCaseImpl} class.</p>
     *
     * @return a <code>TestSuite</code> providing the tests for {@link UseCaseImpl} class.
     */
    public static Test suite() {
        return new TestSuite(UseCaseImplFailureTest.class);
    }

    /**
     * <p>Sets up the fixture. This method is called before a test is executed.</p>
     *
     * @throws Exception if any error occurs.
     */
    protected void setUp() throws Exception {
        super.setUp();
        List instances = new ArrayList();
        instances.add(TestDataFactory.USE_CASE_1);
        this.testedInstances = (UseCaseImpl[]) instances.toArray(new UseCaseImpl[instances.size()]);
    }

    /**
     * <p>Tears down the fixture. This method is called after a test is executed.</p>
     *
     * @throws Exception if any error occurs.
     */
    protected void tearDown() throws Exception {
        this.testedInstances = null;
        super.tearDown();
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addInclude(Include)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link null} as <code>include</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testAddInclude_Include_include_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addInclude(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addInclude(Include)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#INCLUDE_21} as <code>include</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddInclude_Include_include_INCLUDE_21() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addInclude(TestDataFactory.INCLUDE_21);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addInclude(Include)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#INCLUDE_23} as <code>include</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddInclude_Include_include_INCLUDE_23() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addInclude(TestDataFactory.INCLUDE_23);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#removeInclude(Include)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>include</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testRemoveInclude_Include_include_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].removeInclude(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsInclude(Include)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>include</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsInclude_Include_include_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsInclude((Include) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsInclude(UseCase)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>include</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsInclude_UseCase_include_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsInclude((UseCase) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addIncluder(Include)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link null} as <code>includer</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testAddIncluder_Include_includer_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addIncluder(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addIncluder(Include)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#INCLUDE_12} as <code>includer</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddIncluder_Include_includer_INCLUDE_12() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addIncluder(TestDataFactory.INCLUDE_12);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addIncluder(Include)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#INCLUDE_23} as <code>includer</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddIncluder_Include_includer_INCLUDE_23() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addIncluder(TestDataFactory.INCLUDE_23);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#removeIncluder(Include)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>includer</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testRemoveIncluder_Include_includer_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].removeIncluder(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsIncluder(Include)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>includer</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsIncluder_Include_includer_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsIncluder((Include) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsIncluder(UseCase)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>includer</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsIncluder_UseCase_includer_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsIncluder((UseCase) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addExtend(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link null} as <code>extendRelationship</code> and expects the <code>IllegalArgumentException</code>
     * to be thrown.</p>
     */
    public void testAddExtend_Extend_extendRelationship_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addExtend(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addExtend(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#EXTEND_12} as <code>extendRelationship</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddExtend_Extend_extendRelationship_EXTEND_12() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addExtend(TestDataFactory.EXTEND_12);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addExtend(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#EXTEND_23} as <code>extendRelationship</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddExtend_Extend_extendRelationship_EXTEND_23() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addExtend(TestDataFactory.EXTEND_23);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#removeExtend(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link null} as <code>extendRelationship</code> and expects the <code>IllegalArgumentException</code>
     * to be thrown.</p>
     */
    public void testRemoveExtend_Extend_extendRelationship_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].removeExtend(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsExtend(Extend)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>extendRelationship</code> and expects the <code>IllegalArgumentException</code>
     * to be thrown.</p>
     */
    public void testContainsExtend_Extend_extendRelationship_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsExtend((Extend) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsExtend(UseCase)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>extendsUseCase</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsExtend_UseCase_extendsUseCase_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsExtend((UseCase) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addExtender(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link null} as <code>extender</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testAddExtender_Extend_extender_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addExtender(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addExtender(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#EXTEND_21} as <code>extender</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddExtender_Extend_extender_EXTEND_21() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addExtender(TestDataFactory.EXTEND_21);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#addExtender(Extend)} method for proper handling the invalid input
     * arguments.</p>
     *
     * <p>Passes {@link TestDataFactory#EXTEND_32} as <code>extender</code> and expects the
     * <code>IllegalArgumentException</code> to be thrown.</p>
     */
    public void testAddExtender_Extend_extender_EXTEND_32() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].addExtender(TestDataFactory.EXTEND_32);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#removeExtender(Extend)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>extender</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testRemoveExtender_Extend_extender_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].removeExtender(null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsExtender(Extend)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>extender</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsExtender_Extend_extender_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsExtender((Extend) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }

    /**
     * <p>Failure test. Tests the {@link UseCaseImpl#containsExtender(UseCase)} method for proper handling the invalid
     * input arguments.</p>
     *
     * <p>Passes {@link null} as <code>extender</code> and expects the <code>IllegalArgumentException</code> to be
     * thrown.</p>
     */
    public void testContainsExtender_UseCase_extender_null() {
        for (int i = 0; i < this.testedInstances.length; i++) {
            try {
                this.testedInstances[i].containsExtender((UseCase) null);
                Assert.fail("IllegalArgumentException should have been thrown");
            } catch (IllegalArgumentException e) {
                // expected behavior
            } catch (Exception e) {
                Assert.fail("IllegalArgumentException was expected but the original exception is : " + e);
            }
        }
    }
}
