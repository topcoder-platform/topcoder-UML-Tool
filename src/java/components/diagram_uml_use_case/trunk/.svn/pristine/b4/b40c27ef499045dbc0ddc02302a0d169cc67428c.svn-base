/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * SubsystemNodeContainerFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.CoreSemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.uml.model.usecases.ActorImpl;
import junit.framework.TestCase;

import javax.swing.TransferHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This is a failure tests for <code>SubsystemNodeContainer</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class SubsystemNodeContainerFailureTest extends TestCase {

    /**GraphNode instance that is used for testing.*/
    private GraphNode graphNode;

    /**Properties map.*/
    private Map<String, String> properties;

    /**TransferHandler instance that is used for testing.*/
    private TransferHandler handler;

    /**SubsystemNodeContainer instance that will be tested.*/
    private SubsystemNodeContainer subsystemNodeContainer;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        graphNode = TestHelper.createGraphNodeForSubsystem();
        properties = new HashMap<String, String>();
        handler = new TransferHandler("property_name");
        subsystemNodeContainer = new SubsystemNodeContainer(graphNode, properties, handler);
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if graphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphNodeNull() throws Exception {
        try {
            new SubsystemNodeContainer(null, properties, handler);
            fail("IllegalArgumentException is expected because graphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if properties map is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapNull() throws Exception {
        try {
            new SubsystemNodeContainer(graphNode, null, handler);
            fail("IllegalArgumentException is expected because properties map cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if properties map contains
     * null key.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainNullKey() throws Exception {
        properties.put(null, "value");
        try {
            new SubsystemNodeContainer(graphNode, properties, handler);
            fail("IllegalArgumentException is expected because properties map cannot contain null key.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if properties map contains
     * empty key.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainEmptyKey() throws Exception {
        properties.put("  ", "value");
        try {
            new SubsystemNodeContainer(graphNode, properties, handler);
            fail("IllegalArgumentException is expected because properties map cannot contain empty key.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if properties map contains
     * null value.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainNullValue() throws Exception {
        properties.put("key", null);
        try {
            new SubsystemNodeContainer(graphNode, properties, handler);
            fail("IllegalArgumentException is expected because properties map cannot contain null value.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if properties map contains
     * empty value.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainEmptyValue() throws Exception {
        properties.put("key", "  ");
        try {
            new SubsystemNodeContainer(graphNode, properties, handler);
            fail("IllegalArgumentException is expected because properties map cannot contain empty value.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if handler is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfHandlerNull() throws Exception {
        try {
            new SubsystemNodeContainer(graphNode, properties, null);
            fail("IllegalArgumentException is expected because handler cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if graphNode does not
     * contain 2 compartments.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfInvalid1() throws Exception {
        graphNode.removeContained(0);
        try {
            new SubsystemNodeContainer(graphNode, properties, handler);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor SubsystemNodeContainer(graphNode, properties, handler) if first compartment does not
     * contain 3 compartments.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfInvalid2() throws Exception {
        GraphNode compartment = (GraphNode) graphNode.getContaineds().get(0);
        compartment.removeContained(0);
        try {
            new SubsystemNodeContainer(graphNode, properties, handler);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method setTransferHandler(handler) if handler is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testSetTransferHandlerIfHandlerNull() {
        try {
            subsystemNodeContainer.setTransferHandler(null);
            fail("IllegalArgumentException is expected because handler cannot be null.");
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
        subsystemNodeContainer.getNameCompartment().getGraphNode().setVisible(false);
        subsystemNodeContainer.getStereotypeCompartment().getGraphNode().setVisible(false);
        subsystemNodeContainer.getNamespaceCompartment().getGraphNode().setVisible(false);
        graphNode.setSemanticModel(null);
        try {
            subsystemNodeContainer.notifyGraphNodeChange(null);
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
        subsystemNodeContainer.getNameCompartment().getGraphNode().setVisible(false);
        subsystemNodeContainer.getStereotypeCompartment().getGraphNode().setVisible(false);
        subsystemNodeContainer.getNamespaceCompartment().getGraphNode().setVisible(false);
        graphNode.setSemanticModel(new CoreSemanticModelBridge());
        try {
            subsystemNodeContainer = new SubsystemNodeContainer(graphNode, properties, handler);
            subsystemNodeContainer.notifyGraphNodeChange(null);
            fail("IllegalGraphElementException is expected because semantic model cannot be null.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyGraphNodeChange() if semantic model's element is non-Actor.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyGraphNodeChangeIfSemanticModelElementNonActor() throws Exception {
        subsystemNodeContainer.getNameCompartment().getGraphNode().setVisible(false);
        subsystemNodeContainer.getStereotypeCompartment().getGraphNode().setVisible(false);
        subsystemNodeContainer.getNamespaceCompartment().getGraphNode().setVisible(false);
        Uml1SemanticModelBridge modelBridge = new Uml1SemanticModelBridge();
        modelBridge.setElement(new ActorImpl());
        graphNode.setSemanticModel(modelBridge);
        try {
            subsystemNodeContainer = new SubsystemNodeContainer(graphNode, properties, handler);
            subsystemNodeContainer.notifyGraphNodeChange(null);
            fail("IllegalGraphElementException is expected because semantic model cannot be null.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }
}