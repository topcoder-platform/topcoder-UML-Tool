/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Bloom Filter Version 1.1
 *
 * @ CollaborationsHelpTest.java
 */
package com.topcoder.uml.model.collaborations.collaborationinstances;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>Tests for CollaborationsHelp class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public final class CollaborationsHelperTest extends TestCase {

    /**
     * <p> Tests the <code>checkNotNull</code> method with null object. </p>
     * <p> <code>IllegalArgumentException</code> should be thrown. </p>
     */
    public static void testCheckNotNull_Null() {
        try {
            CollaborationsHelper.checkNotNull(null, "");
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
            CollaborationsHelper.checkNotNull(new Object(), "");
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
            CollaborationsHelper.checkCollection(null, "");
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
            CollaborationsHelper.checkCollection(collection, "");
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
            CollaborationsHelper.checkCollection(collection, "");
            // ok
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException expected");
        }
    }

}
