/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * ActorConnectorFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.diagraminterchange.GraphNode;

import java.util.HashMap;

/**
 * <p>
 * This is a failure tests for <code>ActorConnector</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class ActorConnectorFailureTest extends TestCase {

    /**ActorNode instance that is used for testing.*/
    private ActorNode parent;

    /**ActorConnector instance that will be tested.*/
    private ActorConnector actorConnector;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        GraphNode graphNode = TestHelper.createGraphNodeForActor();
        parent = new ActorNode(graphNode, new HashMap<String, String>());
        actorConnector = new ActorConnector(parent);
    }

    /**
     * <p>
     * Tests constructor ActorConnector(parent) if parent is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfParentNull() {
        try {
            new ActorConnector(null);
            fail("IllegalArgumentException is expected because parent cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method getConnectionPoint(wayPoint) if wayPoint is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testGetConnectionPointIfWayPointNull() {
        try {
            actorConnector.getConnectionPoint(null);
            fail("IllegalArgumentException is expected because wayPoint cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}