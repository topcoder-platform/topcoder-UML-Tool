/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AuxiliaryElementClipboardUtilityFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import junit.framework.TestCase;

import java.awt.*;
import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This is a failure tests for <code>AuxiliaryElementClipboardUtility</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AuxiliaryElementClipboardUtilityFailureTest extends TestCase {

    /**System clipboard.*/
    private static final Clipboard CLIPBOARD = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * <p>
     * Tests method copyComment(comment, clipboard) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyCommentIfCommentNull() throws Exception{
        try {
            AuxiliaryElementClipboardUtility.copyComment(null, CLIPBOARD);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyNoteRelationship(comment, clipboard) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyNoteRelationshipIfCommentNull() throws Exception {
        try {
            AuxiliaryElementClipboardUtility.copyNoteRelationship(null, CLIPBOARD);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyCommentGraphNode(node, clipboard) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyCommentGraphNodeIfNodeNull() throws Exception {
        try {
            AuxiliaryElementClipboardUtility.copyCommentGraphNode(null, CLIPBOARD);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyFreeTextGraphNode(node, clipboard) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void test—opyFreeTextGraphNodeIfNodeNull() throws Exception {
        try {
            AuxiliaryElementClipboardUtility.copyFreeTextGraphNode(null, CLIPBOARD);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyCommentRelationshipGraphEdge(edge, clipboard) if edge is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyCommentRelationshipGraphEdgeIfNodeNull() throws Exception {
        try {
            AuxiliaryElementClipboardUtility.copyCommentRelationshipGraphEdge(null, CLIPBOARD);
            fail("IllegalArgumentException is expected because edge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyPolylineGraphEdge(edge, clipboard) if edge is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyPolylineGraphEdgeIfNodeNull() throws Exception {
        try {
            AuxiliaryElementClipboardUtility.copyPolylineGraphEdge(null, CLIPBOARD);
            fail("IllegalArgumentException is expected because edge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}