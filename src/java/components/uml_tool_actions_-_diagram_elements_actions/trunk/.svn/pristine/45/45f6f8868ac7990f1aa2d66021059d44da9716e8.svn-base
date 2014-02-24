/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

/**
 * <P>
 * Tests for ArgumentCheckHelper.
 * </P>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestArgumentCheckHelper extends DiagramElementsActionsTestCase {

    /**
     * <P>
     * Tests checkNotNull method with null as argument. IllegalArgumentException
     * is expected.
     * </P>
     */
    public void testCheckNotNullWithNull() {
        try {
            ArgumentCheckHelper.checkNotNull("null argument", null);
            fail("argument is null. IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // sucess
        }
    }

    /**
     * <P>
     * Tests checkNotNull method with a not null argument.
     * </P>
     *
     */
    public void testCheckNotNull() {
        Integer argument = new Integer(Integer.MAX_VALUE);
        assertTrue("the argument should be returned back",
                argument == ArgumentCheckHelper.checkNotNull("argument",
                        argument));
    }

    /**
     * <P>
     * Tests checkArrayValidity method with null as array.
     * </P>
     *
     */
    public void testCheckArrayValidityWithNullArray() {
        try {
            ArgumentCheckHelper.checkArrayValidity("array", null);
            fail("array" + NULL_ARGUMENT_MESSAGE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests checkArrayValidity method with an empty array.
     * IllegalArgumentException is expected.
     * </P>
     *
     */
    public void testCheckArrayValidityWithEmptyArray() {
        try {
            ArgumentCheckHelper.checkArrayValidity("array", new Object[] {});
            fail("array can't be empty. IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests checkArrayValidity method with an array contains null.
     * </P>
     *
     */
    public void testCheckArrayValidityWithNullInArray() {
        try {
            ArgumentCheckHelper.checkArrayValidity("array",
                    new Object[] {null });
            fail("array can't contain null");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <P>
     * Tests checkArrayValidity method. The array should be returned back after
     * it pass the check.
     * </P>
     *
     */
    public void testCheckArrayValiditySuccessCondition() {
        Integer[] intArray = new Integer[] {new Integer(Integer.MIN_VALUE),
            new Integer(Integer.MAX_VALUE)};
        assertEquals("the array should be returned back", intArray,
                ArgumentCheckHelper.checkArrayValidity("array", intArray));
    }
}
