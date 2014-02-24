/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.MergeNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.SendSignalAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Tests for adding, removing, and persistence for sequence diagram.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ActivityDiagramTest extends DiagramTest {

    /**
     * <p>
     * Creates a sequence diagram for testing.
     * </p>
     */
    public void createDiagram() {
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        Node initialNode = TestHelper.addNode(view, InitialNode.class, new Point(320, 40));
        Node actionState1 = TestHelper.addNode(view, ActionState.class, new Point(320, 100));
        TestHelper.addEdge(view, Transition.class, initialNode, actionState1);
        Node sendSignalAction = TestHelper.addNode(view, SendSignalAction.class, new Point(320, 160));
        TestHelper.addEdge(view, Transition.class, actionState1, sendSignalAction);
        Node acceptEventAction = TestHelper.addNode(view, AcceptEventAction.class, new Point(320, 220));
        TestHelper.addEdge(view, Transition.class, sendSignalAction, acceptEventAction);
        Node objectFlowNode = TestHelper.addNode(view, ObjectFlowNode.class, new Point(320, 280));
        TestHelper.addEdge(view, Transition.class, acceptEventAction, objectFlowNode);
        Node commentNode = TestHelper.addNode(view, CommentNode.class, new Point(100, 100));
        TestHelper.addEdge(view, CommentLinkEdge.class, objectFlowNode, commentNode);
        Node flowFinalNode = TestHelper.addNode(view, FlowFinalNode.class, new Point(100, 280));
        TestHelper.addEdge(view, Transition.class, objectFlowNode, flowFinalNode);
        Node decisionNode = TestHelper.addNode(view, DecisionNode.class, new Point(320, 340));
        TestHelper.addEdge(view, Transition.class, objectFlowNode, decisionNode);
        Node actionState2 = TestHelper.addNode(view, ActionState.class, new Point(100, 370));
        TestHelper.addEdge(view, Transition.class, decisionNode, actionState2);
        Node actionState3 = TestHelper.addNode(view, ActionState.class, new Point(500, 370));
        TestHelper.addEdge(view, Transition.class, decisionNode, actionState3);
        Node mergeNode = TestHelper.addNode(view, MergeNode.class, new Point(320, 400));
        TestHelper.addEdge(view, Transition.class, actionState2, mergeNode);
        Node actionState4 = TestHelper.addNode(view, ActionState.class, new Point(800, 400));
        TestHelper.addEdge(view, Transition.class, mergeNode, actionState4);
        Node forkNode = TestHelper.addNode(view, ForkNode.class, new Point(800, 340));
        Node actionState5 = TestHelper.addNode(view, ActionState.class, new Point(650, 260));
        Node actionState6 = TestHelper.addNode(view, ActionState.class, new Point(900, 260));
        TestHelper.addEdge(view, Transition.class, forkNode, actionState5);
        TestHelper.addEdge(view, Transition.class, forkNode, actionState6);
        Node joinNode = TestHelper.addNode(view, JoinNode.class, new Point(800, 200));
        TestHelper.addEdge(view, Transition.class, actionState5, joinNode);
        TestHelper.addEdge(view, Transition.class, actionState6, joinNode);
        Node finalNode = TestHelper.addNode(view, FinalNode.class, new Point(800, 100));
        TestHelper.addEdge(view, Transition.class, joinNode, finalNode);
    }

}
