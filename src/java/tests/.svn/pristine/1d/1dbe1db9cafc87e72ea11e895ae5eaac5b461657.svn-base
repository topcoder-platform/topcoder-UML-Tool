/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveObjectNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveSequenceEdgeActionTest extends TestCase {
    /** Reference to main frame for testing */
    MainFrame mainFrame;

    /** Reference to diagram view for testing */
    DiagramView diagramView;

    /** An instance of <code>RemoveSequenceEdgeAction</code> for testing. */
    private RemoveSequenceEdgeAction action;

    /** Sequence edge to remove */
    SequenceEdge sequenceEdge;

    /** Start object node connected to sequence edge */
    ObjectNode startNode;

    /** End object node connected to sequence edge */
    ObjectNode endNode;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        mainFrame = TestHelper.getMainFrame();
        diagramView = TestHelper.getDiagramView(DiagramType.SEQUENCE);
        Diagram diagram = diagramView.getDiagram();

        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
        Collaboration collaboration = (Collaboration) bridge.getElement();

        Link link = new LinkImpl();
        link.setName("anonymous");
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(collaboration);
        Procedure procedure = new ProcedureImpl();
        procedure.setAction(null);
        stimulus.setDispatchAction(procedure);
        stimulus.setCommunicationLink(link);
        link.addStimulus(stimulus);
        collaboration.addOwnedElement(stimulus);

        GraphEdge graphEdge = new GraphEdge();
        DeployHelper.addContained(graphEdge, new GraphNode());
        DeployHelper.addContained(graphEdge, new GraphNode());
        graphEdge.addWaypoint(0, DeployHelper.createPoint(100.0, 100.0));
        graphEdge.addWaypoint(1, DeployHelper.createPoint(200.0, 200.0));
        graphEdge.setPosition(DeployHelper.createPoint(100.0, 60.0));
        DeployHelper.setElement(graphEdge, link);

        EnumMap<SequenceEdgePropertyType, String> edgeProperties = new EnumMap<SequenceEdgePropertyType, String>(
                SequenceEdgePropertyType.class);
        edgeProperties.put(SequenceEdgePropertyType.STROKE_COLOR, "STROKE_COLOR");
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingProperties = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                ConfiguredEdgeEndingPropertyType.class);
        endingProperties.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "STROKE_COLOR");
        sequenceEdge = new ReturnMessageEdge(link, graphEdge, endingProperties, edgeProperties);

        diagramView.add(sequenceEdge);
        startNode = TestHelper.createObjectNode();
        endNode = TestHelper.createObjectNode();
        startNode.setPosition(new java.awt.Point(100, 150));
        endNode.setPosition(new java.awt.Point(200, 150));
        diagramView.add(startNode);
        diagramView.add(endNode);
        DeployHelper.connectEdgeWithNodes(graphEdge, startNode.getGraphNode(), endNode.getGraphNode());

        // sequenceEdge..setNamespace(collaboration);
        // collaboration.addOwnedElement(objectNode.getObject());

        action = new RemoveSequenceEdgeAction(mainFrame, sequenceEdge);
    }

    /**
     * Test method for 'RemoveSequenceEdgeAction.RemoveSequenceEdgeAction(MainFrame, SequenceEdge)'. Instance of action
     * should not be null.
     */
    public void testRemoveSequenceEdgeAction_Accuracy() {
        assertNotNull(
                "Test method for 'RemoveSequenceEdgeAction.RemoveSequenceEdgeAction(MainFrame, SequenceEdge)' failed.",
                action);
    }

    /**
     * Test method for RemoveSequenceEdgeAction.RemoveSequenceEdgeAction(MainFrame, SequenceEdge)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRemoveSequenceEdgeAction_Null_1() {
        try {
            new RemoveSequenceEdgeAction(null, sequenceEdge);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for RemoveSequenceEdgeAction.RemoveSequenceEdgeAction(MainFrame, SequenceEdge)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRemoveSequenceEdgeAction_Null_2() {
        try {
            new RemoveSequenceEdgeAction(mainFrame, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveSequenceEdgeAction.executeAction()'. Sequence edge should be removed from diagram view.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertFalse("Sequence edge should be removed from diagram view", TestHelper.isContainedInDiagramView(
                diagramView, sequenceEdge));
        action.undoAction();
    }

    /**
     * Test method for 'RemoveSequenceEdgeAction.undoAction()'. Sequence edge should be added back to diagram view.
     */
    public void testUndoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        assertTrue("Sequence edge should be added back to diagram view", TestHelper.isContainedInDiagramView(
                diagramView, sequenceEdge));

    }

    /**
     * Test method for 'RemoveSequenceEdgeAction.redoAction()'. Sequence edge should be removed from diagram view
     */
    public void testRedoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        action.redoAction();
        assertFalse("Sequence edge should be removed from diagram view", TestHelper.isContainedInDiagramView(
                diagramView, sequenceEdge));
        action.undoAction();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        mainFrame = null;
        diagramView = null;
        startNode = null;
        endNode = null;
        sequenceEdge = null;
        action = null;
    }

}
