/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * UseCaseNodeFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * This is a failure tests for <code>UseCaseNode</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class UseCaseNodeFailureTest extends TestCase {


    /**GraphNode that is used for testing.*/
    private GraphNode graphNode;

    /**Properties map.*/
    private Map<String, String> properties;

    /**UseCaseNode instance that will be tested.*/
    private UseCaseNode useCaseNode;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        graphNode = TestHelper.createGraphNodeForUseCase();
        properties = new HashMap<String, String>();
        useCaseNode = new UseCaseNode(graphNode, properties);
    }

    /**
     * <p>
     * Tests constructor UseCaseNode(graphNode, properties, ) if graphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGrapchNodeNull() throws Exception {
        try {
            new UseCaseNode(null, properties);
            fail("IllegalArgumentException is expected because graphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor UseCaseNode(graphNode, properties) if properties map is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapNull() throws Exception {
        try {
            new UseCaseNode(graphNode, null);
            fail("IllegalArgumentException is expected because properties map cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyGraphNodeChange() if semantic model is null.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyGraphNodeChangeIfSemanticModelNull() throws Exception {
        useCaseNode.getNameCompartment().getGraphNode().setVisible(false);
        useCaseNode.getStereotypeCompartment().getGraphNode().setVisible(false);
        useCaseNode.getNamespaceCompartment().getGraphNode().setVisible(false);
        graphNode.setSemanticModel(null);
        try {
            useCaseNode.notifyGraphNodeChange(null);
            fail("IllegalGraphElementException is expected because semantic model cannot be null.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyGraphNodeChange() if semantic model is non-Uml1SemanticModelBridge.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyGraphNodeChangeIfSemanticModelInvalidClass() throws Exception {
        useCaseNode.getNameCompartment().getGraphNode().setVisible(false);
        useCaseNode.getStereotypeCompartment().getGraphNode().setVisible(false);
        useCaseNode.getNamespaceCompartment().getGraphNode().setVisible(false);
        graphNode.setSemanticModel(new CoreSemanticModelBridge());
        try {
            useCaseNode = new UseCaseNode(graphNode, properties);
            useCaseNode.notifyGraphNodeChange(null);
            fail("IllegalGraphElementException is expected because semantic model cannot be null.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }
}