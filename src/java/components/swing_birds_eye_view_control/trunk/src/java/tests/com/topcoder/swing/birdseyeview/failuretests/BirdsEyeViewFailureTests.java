/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.failuretests;

import com.topcoder.swing.birdseyeview.BirdsEyeView;

import junit.framework.TestCase;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;


/**
 * <p>Failure tests for <code>BirdsEyeView</code> class.</p>
 *
 * @author telly12
 * @version 1.0
 */
public class BirdsEyeViewFailureTests extends TestCase {
    /**
     * <p>
     * Failure test of constructor,
     * fail for the inputObject is null,
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void test_Ctor_failure1() {
        try {
            new BirdsEyeView(null, new Dimension(200, 200), new Point(10, 10));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test of constructor,
     * fail for the inputObjectViewDimension is null,
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void test_Ctor_failure2() {
        try {
            new BirdsEyeView(new JPanel(), null, new Point(10, 10));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
    /**
     * <p>
     * Failure test of constructor,
     * fail for the inputObjectViewPosition is null,
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void test_Ctor_failure3() {
        try {
            new BirdsEyeView(new JPanel(), new Dimension(200, 200), null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
    /**
     * <p>
     * Failure test of method setInputObject,
     * fail for the input is null,
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void test_setInputObject_failure() {
        try {
            BirdsEyeView instance = new BirdsEyeView(new JPanel(), new Dimension(200, 200), new Point(10, 10));
            instance.setInputObject(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
    /**
     * <p>
     * Failure test of method setInputObjectViewDimension,
     * fail for the input is null,
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void test_setInputObjectViewDimension_failure() {
        try {
            BirdsEyeView instance = new BirdsEyeView(new JPanel(), new Dimension(200, 200), new Point(10, 10));
            instance.setInputObjectViewDimension(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
