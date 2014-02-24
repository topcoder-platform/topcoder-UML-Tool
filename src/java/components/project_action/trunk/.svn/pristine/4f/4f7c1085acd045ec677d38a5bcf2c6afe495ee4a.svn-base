/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

/**
 * <p>
 * Base test case that provides common assertion function.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class BaseTestCase extends TestCase {

    /**
     * <p>
     * assertion equation of two list.
     * </p>
     * @param list
     *            the list to compare with the orignal list.
     * @param original
     *            the original list
     */
    public void assertListEquals(List list, List original) {
        assertTrue("the size is incorrect.", list.size() == original.size());

        for (Iterator iter = list.iterator(); iter.hasNext();) {
            assertTrue("new element not exist in original list.", original.contains(iter.next()));
        }

        for (Iterator iter = original.iterator(); iter.hasNext();) {
            assertTrue("element not found in the list.", list.contains(iter.next()));
        }
    }
}
