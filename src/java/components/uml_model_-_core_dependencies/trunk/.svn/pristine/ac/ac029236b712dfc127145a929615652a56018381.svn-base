/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Bloom Filter Version 1.1
 *
 * @ CoreDependenciesHelperTest.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>Tests for CoreDependenciesHelper class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public final class CoreDependenciesHelperTest extends TestCase {

    /**
     * <p> Tests the <code>checkNotNull</code> method with null object. </p>
     * <p> <code>IllegalArgumentException</code> should be thrown. </p>
     */
    public static void testCheckNotNull_Null() {
        try {
            CoreDependenciesHelper.checkNotNull(null, "");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p> Tests accuracy of the <code>checkNotNull</code> method. </p>
     * <p> Correct value should be returned. </p>
     */
    public static void testCheckNotNull_NotNull() {
        try {
            CoreDependenciesHelper.checkNotNull(new Object(), "");
            // ok
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException expected");
        }
    }

    /**
     * <p> Tests the <code>checkCollection</code> with null object. </p>
     * <p> <code>IllegalArgumentException</code> should be thrown. </p>
     */
    public static void testCheckCollection_Null() {
        try {
            CoreDependenciesHelper.checkCollection(null, "");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p> Tests the <code>checkCollection</code> with null object. </p>
     * <p> <code>IllegalArgumentException</code> should be thrown. </p>
     */
    public static void testCheckCollection_ContaisNull() {
        try {
            Collection<String> collection = new ArrayList<String>();
            collection.add(null);
            CoreDependenciesHelper.checkCollection(collection, "");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p> Tests the accuracy of <code>checkCollection</code> method. </p>
     * <p> Correct value should be returned. </p>
     */
    public static void testCheckCollection_Accuracy() {
        try {
            Collection<String> collection = new ArrayList<String>();
            collection.add("");
            CoreDependenciesHelper.checkCollection(collection, "");
            // ok
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException expected");
        }
    }

    /**
     * <p> Tests the <code>checkIndexRange</code> with negative index. </p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown. </p>
     */
    public static void testCheckIndexRange_Negative() {
        try {
            CoreDependenciesHelper.checkIndexRange(-1, 3, "");
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * <p> Tests the <code>checkIndexRange</code> with big index. </p>
     * <p> <code>IndexOutOfBoundsException</code> should be thrown. </p>
     */
    public static void testCheckIndexRange_MoreThan() {
        try {
            CoreDependenciesHelper.checkIndexRange(4, 3, "");
            fail("IndexOutOfBoundsException expected");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * <p> Tests the accuracy of <code>checkIndexRange</code> method. </p>
     * <p> Correct value should be returned. </p>
     */
    public static void testCheckIndexRange_Accuracu() {
        try {
            CoreDependenciesHelper.checkIndexRange(2, 3, "");
            // Ok
        } catch (IndexOutOfBoundsException e) {
            fail("IndexOutOfBoundsException expected");
        }
    }

}
