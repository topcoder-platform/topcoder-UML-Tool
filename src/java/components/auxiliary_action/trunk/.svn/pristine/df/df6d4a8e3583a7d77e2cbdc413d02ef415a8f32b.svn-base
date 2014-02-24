/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * PastePolylineActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.diagram.PastePolylineAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;

/**
 * <p>
 * This is a failure tests for <code>PastePolylineAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PastePolylineActionFailureTest extends TestCase {

    /**Diagram GraphNode that is used for testing.*/
    private GraphNode diagram;


    /**Content GraphEdge that is used for testing.*/
    private GraphEdge content;

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

        content = new GraphEdge();
        diagram = new GraphNode();
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
     * Tests constructor PastePolylineAction(content, diagram) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNull() {
        try {
            new PastePolylineAction(null, diagram);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PastePolylineAction(content, diagram) if content is not instance of GraphEdge.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNotGraphEdge() {
        try {
            new PastePolylineAction(new Object(), diagram);
            fail("IllegalArgumentException is expected because content must be instance of GraphEdge.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PastePolylineAction(content, diagram) if diagram is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfDiagramNull() {
        try {
            content.addContained(new Polyline());
            new PastePolylineAction(content, null);
            fail("IllegalArgumentException is expected because diagram cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PastePolylineAction(content, diagram) if content doesn't contain a
     * Polyline object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfContentNotContainedPolylineObject() {
        try {
            new PastePolylineAction(content, diagram);
            fail("IllegalArgumentException is expected because content must contain a Polyline "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}