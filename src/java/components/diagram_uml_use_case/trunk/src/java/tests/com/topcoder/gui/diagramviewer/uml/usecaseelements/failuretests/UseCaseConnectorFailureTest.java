/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * UseCaseConnectorFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import java.util.HashMap;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;

/**
 * <p>
 * This is a failure tests for <code>UseCaseConnector</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class UseCaseConnectorFailureTest extends TestCase {

    /**UseCaseNode instance that is used for testing.*/
    private UseCaseNode parent;

    /**UseCaseConnector instance that will be tested.*/
    private UseCaseConnector useCaseConnector;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        parent = new UseCaseNode(TestHelper.createGraphNodeForUseCase(), new HashMap<String, String>());
        useCaseConnector = new UseCaseConnector(parent);
    }

    /**
     * <p>
     * Tests constructor UseCaseConnector(parent) if parent is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfParentNull() {
        try {
            new UseCaseConnector(null);
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
            useCaseConnector.getConnectionPoint(null);
            fail("IllegalArgumentException is expected because wayPoint cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}