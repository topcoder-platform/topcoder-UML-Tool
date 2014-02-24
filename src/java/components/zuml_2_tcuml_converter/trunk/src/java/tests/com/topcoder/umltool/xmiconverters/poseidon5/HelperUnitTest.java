/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * Unit tests for <code>Helper</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HelperUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for <code>checkNull(Object, String)</code>
     * </p>
     *
     * <p>
     * Target: Verify that <code>checkNull(Object, String)</code> is correct.
     * </p>
     */
    public void testCheckNull_Accuracy() {
        Helper.checkNull("test", "name");
    }

    /**
     * <p>
     * Failure test for <code>checkNull(Object, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: the obj to be checked is null.<br>
     * Expected: <code>IllegalArgumentException</code>.
     * </p>
     */
    public void testCheckNull_Failure() {
        try {
            Helper.checkNull(null, "null");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkString(String, String)</code>
     * </p>
     *
     * <p>
     * Target: Verify that <code>checkString(String, String)</code> is correct.
     * </p>
     */
    public void testCheckString_Accuracy() {
        Helper.checkString("test", "name");
    }

    /**
     * <p>
     * Failure test for <code>checkString(String, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: the string to be checked is null.<br>
     * Expected: <code>IllegalArgumentException</code>.
     * </p>
     */
    public void testCheckString_Failure1() {
        try {
            Helper.checkString(null, "null");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkString(String, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: the string to be checked is empty.<br>
     * Expected: <code>IllegalArgumentException</code>.
     * </p>
     */
    public void testCheckString_Failure2() {
        try {
            Helper.checkString(" ", "empty");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * <p>
     * Accuact test for <code>checkArray(String[], String)</code>.
     * </p>
     */
    public void testCheckArray() {
        Helper.checkArray(new String[0], "empty");
    }

    /**
     * <p>
     * Failure test for <code>checkArray(String[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckArray_Failure1() {
        try {
            Helper.checkArray(null, "empty");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkArray(String[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array contains null string, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckArray_Failure2() {
        try {
            String[] array = new String[1];
            array[0] = null;

            Helper.checkArray(array, "empty");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkArray(String[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array contains empty string, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckArray_Failure3() {
        try {
            String[] array = new String[1];
            array[0] = "  ";

            Helper.checkArray(array, "empty");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkObjectList(Object[], String)</code>.
     * </p>
     */
    public void testCheckObjectArray() {
        List<Object> objs = new LinkedList<Object>();
        objs.add(new Object());

        Helper.checkObjectList(objs, "objs");
    }

    /**
     * <p>
     * Failure test for <code>checkObjectList(Object[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the list is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckObjectArray_Failure1() {
        try {
            Helper.checkObjectList(null, "objs");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkObjectList(Object[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the list is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckObjectArray_Failure2() {
        try {
            List<Object> objs = new LinkedList<Object>();
            Helper.checkObjectList(objs, "objs");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkObjectList(Object[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the list contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckObjectArray_Failure3() {
        try {
            List<Object> objs = new LinkedList<Object>();
            objs.add(null);

            Helper.checkObjectList(objs, "objs");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkStringMap(Map, String)</code>.
     * </p>
     */
    public void checkStringMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "value");

        Helper.checkStringMap(map, "map");
    }

    /**
     * <p>
     * Failure test for <code>checkStringMap(Map, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map is null, IllegalArgumentException is expected.
     * </p>
     */
    public void checkStringMap_Failure1() {
        try {
            Helper.checkStringMap(null, "map");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkStringMap(Map, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void checkStringMap_Failure2() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            Helper.checkStringMap(map, "map");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkStringMap(Map, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void checkStringMap_Failure3() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put(null, "value");
            Helper.checkStringMap(map, "map");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkStringMap(Map, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the map contains empty string, IllegalArgumentException is expected.
     * </p>
     */
    public void checkStringMap_Failure4() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("  ", "value");
            Helper.checkStringMap(map, "map");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkNegative(double, String)</code>.
     * </p>
     *
     */
    public void checkNegative() {
        Helper.checkNegativeAndNaN(0.0, "double");

        Helper.checkNegativeAndNaN(100, "double");
    }

    /**
     * <p>
     * Failure test for <code>checkNegative(double, String)</code>.
     * </p>
     *
     */
    public void checkNegative_Failure() {
        try {
            Helper.checkNegativeAndNaN(-1, "double");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
