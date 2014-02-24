/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * BaseEdgeFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;

/**
 * <p/>
 * This is a failure tests for <code>BaseEdge</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class BaseEdgeFailureTest extends TestCase {

    /**keywordMetaclass.*/
    private static final String KEYWORD_METACLASS = "keywordMetaclass";

    /**GraphEdge instance that is used for testing.*/
    private GraphEdge graphEdge;

    /**BaseEdge instance that will be tested.*/
    private BaseEdge baseEdge;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        graphEdge = Helper.createGraphEdge();
        baseEdge = new BaseEdgeImpl(graphEdge, KEYWORD_METACLASS);
    }

    /**
     * <p>
     * Tests constructor BaseEdge(graphEdge, keywordMetaclass) if graphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphEdgeNull() throws Exception {
        try {
            new BaseEdgeImpl(null, KEYWORD_METACLASS);
            fail("IllegalArgumentException is expected because graphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseEdge(graphEdge, keywordMetaclass) if keywordMetaclass is empty.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfKeywordMetaclassEmpty() throws Exception {
        try {
            new BaseEdgeImpl(graphEdge, "  ");
            fail("IllegalArgumentException is expected because keywordMetaclass cannot be empty.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseEdge(graphEdge, keywordMetaclass) if graphEdge does not contain two compartments.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphEdgeInvalid1() throws Exception {
        graphEdge.removeContained(1);
        try {
            new BaseEdgeImpl(graphEdge, KEYWORD_METACLASS);
            fail("IllegalGraphElementException is expected because GraphEdge is invalid.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseEdge(graphEdge, keywordMetaclass) if graphEdge contains less than 2 waypoints.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphEdgeInvalid2() throws Exception {
        graphEdge.removeWaypoint(0);
        try {
            new BaseEdgeImpl(graphEdge, KEYWORD_METACLASS);
            fail("IllegalGraphElementException is expected because GraphEdge is invalid.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyGraphEdgeChange() if semantic model is null.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyGraphEdgeChangeIfSemanticModelNull() throws Exception {
        graphEdge.setSemanticModel(null);
        try {
            baseEdge = new BaseEdgeImpl(graphEdge, KEYWORD_METACLASS);
            baseEdge.notifyGraphEdgeChange();
            fail("IllegalGraphElementException is expected becasue semantic model is null.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyGraphEdgeChange() if semantic model is non-Uml1SemanticModelBridge.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyGraphEdgeChangeIfInvalidSemanticModelClass() throws Exception {
        graphEdge.setSemanticModel(new CoreSemanticModelBridge());
        try {
            baseEdge = new BaseEdgeImpl(graphEdge, KEYWORD_METACLASS);
            baseEdge.notifyGraphEdgeChange();
            fail("IllegalGraphElementException is expected becasue semantic model is non-Uml1SemanticModelBridge.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Simple implementation of BaseEdge class.
     * Used for testing.
     * </p>
     */
    private class BaseEdgeImpl extends BaseEdge {

        /**
         * Constructor.
         * <pre>
         * 1) Call super constructor with appropriate args.
         * The left eding should be null.
         * The right ending should be SimpleArrow instance.
         * Configure the line style of this edge
         * 2) keywordMetaclass can be null but not empty.
         * 3) Register PopupMenuTrigger to this edge to allow popup menu.
         * 4) Create compartments, and add them with super.addTextField...
         * 5) Register a EditBoxTrigger to name compartment to allow it editable.
         * </pre>
         *
         * @param graphEdge        the graphEdge representing this Edge.
         * @param keywordMetaclass the keyword metaclass of this edge
         * @throws IllegalArgumentException     if graphEdge is null, or keywordMetaclass is empty
         * @throws IllegalGraphElementException if graphEdge has bad structure.
         */
        public BaseEdgeImpl(GraphEdge graphEdge, String keywordMetaclass) throws IllegalGraphElementException {
            super(graphEdge, keywordMetaclass);
        }
    }
}