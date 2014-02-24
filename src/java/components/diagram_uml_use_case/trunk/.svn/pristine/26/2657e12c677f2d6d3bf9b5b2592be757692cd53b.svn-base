/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * ActorNodeFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * This is a failure tests for <code>ActorNode</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class ActorNodeFailureTest extends TestCase {

    /**GraphNode instance that is used for testing.*/
    private GraphNode graphNode;

    /**Properties map.*/
    private Map<String, String> properties;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        properties = new HashMap<String, String>();
        graphNode = Helper.createGrapchNodeForActorNode();
    }

    /**
     * <p>
     * Tests constructor ActorNode(graphNode, properties) if graphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphNodeNull() throws Exception {
        try {
            new ActorNode(null, properties);
            fail("IllegalArgumentException is expected because graphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor ActorNode(graphNode, properties) if properties is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapNull() throws Exception {
        try {
            new ActorNode(graphNode, null);
            fail("IllegalArgumentException is expected because properties map cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}