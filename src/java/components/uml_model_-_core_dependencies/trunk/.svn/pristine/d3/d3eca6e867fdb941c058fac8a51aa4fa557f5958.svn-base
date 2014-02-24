/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.dependencies.BindingImpl;

import junit.framework.TestCase;

/**
 * Failure test for BindingImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class BindingImplFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private BindingImpl bindingImpl = new BindingImpl();

    /**
     * This instance is used in the test.
     */
    private TemplateArgument argument = new TemplateArgumentImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<TemplateArgument> arguments = new ArrayList<TemplateArgument>();

    /**
     * Sets up the environment for the TestCase.
     *
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        arguments.add(argument);
        arguments.add(argument);
    }

    /**
     * Failure test of <code>addArgument(TemplateArgument argument)</code>.
     * <p>
     * argument is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArgument1FailureNullArgument() throws Exception {
        try {
            bindingImpl.addArgument(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArgument(int index, TemplateArgument argument)</code>.
     * <p>
     * argument is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArgument2FailureNullArgument() throws Exception {
        try {
            bindingImpl.addArgument(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArgument(int index, TemplateArgument argument)</code>.
     * <p>
     * index is negative.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArgument2FailureNegativeIndex() throws Exception {
        try {
            bindingImpl.addArgument(-1, argument);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArgument(int index, TemplateArgument argument)</code>.
     * <p>
     * index is greater than size.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArgument2FailureIndexGreaterThanSize() throws Exception {
        try {
            bindingImpl.addArgument(1, argument);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArguments(Collection<TemplateArgument> arguments)</code>.
     * <p>
     * arguments is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArguments1FailureNullArguments() throws Exception {
        try {
            bindingImpl.addArguments(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArguments(Collection<TemplateArgument> arguments)</code>.
     * <p>
     * arguments contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArguments1FailureArgumentsContainsNull() throws Exception {
        arguments.add(null);
        try {
            bindingImpl.addArguments(arguments);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArguments(int index, Collection<TemplateArgument> arguments)</code>.
     * <p>
     * arguments is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArguments2FailureNullArguments() throws Exception {
        try {
            bindingImpl.addArguments(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArguments(int index, Collection<TemplateArgument> arguments)</code>.
     * <p>
     * arguments contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArguments2FailureArgumentsContainsNull() throws Exception {
        arguments.add(null);
        try {
            bindingImpl.addArguments(0, arguments);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArguments(int index, Collection<TemplateArgument> arguments)</code>.
     * <p>
     * index is negative.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArguments2FailureNegativeIndex() throws Exception {
        try {
            bindingImpl.addArguments(-1, arguments);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>addArguments(int index, Collection<TemplateArgument> arguments)</code>.
     * <p>
     * index is greater than size.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testAddArguments2FailureIndexGreaterThanSize() throws Exception {
        try {
            bindingImpl.addArguments(1, arguments);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>setArgument(int index, TemplateArgument argument)</code>.
     * <p>
     * argument is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testSetArgumentFailureNullArgument() throws Exception {
        bindingImpl.addArgument(argument);
        try {
            bindingImpl.setArgument(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>setArgument(int index, TemplateArgument argument)</code>.
     * <p>
     * index is negative.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testSetArgumentFailureNegativeIndex() throws Exception {
        try {
            bindingImpl.setArgument(-1, argument);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>setArgument(int index, TemplateArgument argument)</code>.
     * <p>
     * index is equal to size.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testSetArgumentFailureIndexEqualToSize() throws Exception {
        try {
            bindingImpl.setArgument(0, argument);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeArgument(int index)</code>.
     * <p>
     * index is negative.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveArgument1FailureNegativeIndex() throws Exception {
        try {
            bindingImpl.removeArgument(-1);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeArgument(int index)</code>.
     * <p>
     * index is equal to size.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveArgument1FailureIndexEqualToSize() throws Exception {
        try {
            bindingImpl.removeArgument(0);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeArgument(TemplateArgument argument)</code>.
     * <p>
     * argument is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveArgument2FailureNullArgument() throws Exception {
        try {
            bindingImpl.removeArgument(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>removeArguments(Collection<TemplateArgument> arguments)</code>.
     * <p>
     * arguments is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveArgumentsFailureNullArguments() throws Exception {
        try {
            bindingImpl.removeArguments(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of
     * <code>removeArguments(Collection<TemplateArgument> arguments)</code>.
     * <p>
     * arguments contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testRemoveArgumentsFailureArgumentsContainsNull() throws Exception {
        arguments.add(null);
        try {
            bindingImpl.removeArguments(arguments);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsArgument(TemplateArgument argument)</code>.
     * <p>
     * argument is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testContainsArgumentFailureNullArgument() throws Exception {
        try {
            bindingImpl.containsArgument(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>indexOfArgument(TemplateArgument argument)</code>.
     * <p>
     * argument is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             to junit
     */
    public void testIndexOfArgumentFailureNullArgument() throws Exception {
        try {
            bindingImpl.indexOfArgument(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
