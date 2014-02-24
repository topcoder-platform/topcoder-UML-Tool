/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CutPolylineActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.diagram.CutPolylineAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.util.actionmanager.ActionExecutionException;
import junit.framework.TestCase;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This is a failure tests for <code>CutPolylineAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CutPolylineActionFailureTest extends TestCase {

    /**Polyline GraphEdge that is used for testing.*/
    private GraphEdge polylineGraphEdge;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        Helper.clearNamespace();
        Helper.initNamespace();

        polylineGraphEdge = new GraphEdge();
        polylineGraphEdge.setContainer(new GraphElement() {});
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor CutPolylineAction(polylineGraphEdge, clipboard) if polylineGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNull() {
        try {
            new CutPolylineAction(null, null);
            fail("IllegalArgumentException is expected because polylineGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CutPolylineAction(polylineGraphEdge, clipboard) if polylineGraphEdge
     * doesn't contain a Polyline object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNotContainedPolylineObject() {
        try {
            new CutPolylineAction(polylineGraphEdge, null);
            fail("IllegalArgumentException is expected because polylineGraphEdge must contain a Polyline "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method copyToClipboard(node, clipboard) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCopyToClipboardIfNodeNull() throws Exception {
        polylineGraphEdge.addContained(new Polyline());
        CutPolylineActionExt cutPolylineAction = new CutPolylineActionExt(polylineGraphEdge, null);
        try {
            cutPolylineAction.copyToClipboard(null, null);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * This class is used so that to access method copyToClipboard.
     * </p>
     */
    private class CutPolylineActionExt extends CutPolylineAction {
        /**
         * <p>
         * Constructs CutPolylineAction.
         * </p>
         *
         * @param polylineGraphEdge the polyline graph edge.
         * @param clipboard         the clipboard to copy.
         * @throws IllegalArgumentException if the polylineGraphEdge argument is null, or
         *                                  the polylineGraphEdge doesn't contain a Polyline object in its
         *                                  contained attribute.
         */
        public CutPolylineActionExt(GraphEdge polylineGraphEdge, Clipboard clipboard) {
            super(polylineGraphEdge, clipboard);
        }

        /**
         * <p>
         * Copy the poly graph edge to the clipboard.
         * </p>
         *
         * @param node      the polyline graph edge.
         * @param clipboard the clipboard to copy.
         * @throws IllegalArgumentException if the node argument is null.
         * @throws ActionExecutionException if the copy to clipboard operation fails.
         */
        protected void copyToClipboard(GraphElement node, Clipboard clipboard) throws ActionExecutionException {
            super.copyToClipboard(node, clipboard);
        }
    }
}