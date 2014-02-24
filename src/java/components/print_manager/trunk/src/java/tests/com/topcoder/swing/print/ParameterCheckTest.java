/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


/**
 * Test case for helper class ParameterCheck.
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class ParameterCheckTest extends TestCase {
    /**
     * Test ParameterCheck.checkEmptyList() given with a valid list.
     */
    public void testCheckEmptyList() {
        List list = new ArrayList();
        list.add("element");
        ParameterCheck.checkEmptyList("name", list);

        // success
    }

    /**
     * Test ParameterCheck.checkEmptyList() given with an empty list, IAE is expected.
     */
    public void testCheckEmptyListEmptyList() {
        List list = new ArrayList();

        try {
            ParameterCheck.checkEmptyList("name", null);
            fail("parameter is empty list and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ParameterCheck.checkEmptyList() given with a list containing null element, IAE is expected.
     */
    public void testCheckEmptyListListContainsNull() {
        List list = new ArrayList();
        list.add(null);
        list.add("element");

        try {
            ParameterCheck.checkEmptyList("name", null);
            fail("parameter contains null element  and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ParameterCheck.checkEmptyList() given with null as parameter, IAE is expected.
     */
    public void testCheckEmptyListNull() {
        try {
            ParameterCheck.checkEmptyList("name", null);
            fail("parameter is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ParameterCheck.checkNull() with not null Object.
     */
    public void testCheckNull() {
        ParameterCheck.checkNull("name", "not null");

        // success
    }

    /**
     * Test ParameterCheck.checkNullEmpty() with valid string.
     */
    public void testCheckNullEmpty() {
        ParameterCheck.checkNullEmpty("name", "not empty");

        // success
    }

    /**
     * Test ParameterCheck.checkNullEmpty() with empty string, IAE is expected.
     */
    public void testCheckNullEmptyEmpty() {
        try {
            ParameterCheck.checkNullEmpty("name", " ");
            fail("parameter is empty string and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ParameterCheck.checkNullEmpty() with null, IAE is expected.
     */
    public void testCheckNullEmptyNull() {
        try {
            ParameterCheck.checkNullEmpty("name", null);
            fail("parameter is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ParameterCheck.checkNull() with null, IAE is expected.
     */
    public void testCheckNullNull() {
        try {
            ParameterCheck.checkNull("name", null);
            fail("parameter is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
