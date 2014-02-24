/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.AsynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.CreateMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SendSignalMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Tests for adding, removing, and persistence for sequence diagram.
 * </p>
 * @author ly
 * @version 1.0
 */
public class SequenceDiagramTest extends DiagramTest {

    /**
     * <p>
     * Creates a sequence diagram for testing.
     * </p>
     */
    public void createDiagram() {
        DiagramView view = TestHelper.getDiagramView(DiagramType.SEQUENCE);
        TestHelper.addNode(view, FreeTextNode.class, new Point(320, 10));
        Node objectNode1 = TestHelper.addNode(view, ObjectNode.class, new Point(20, 40));
        Node objectNode2 = TestHelper.addNode(view, ObjectNode.class, new Point(120, 40));
        Node objectNode3 = TestHelper.addNode(view, ObjectNode.class, new Point(220, 40));
        Node objectNode4 = TestHelper.addNode(view, ObjectNode.class, new Point(320, 40));
        Node objectNode5 = TestHelper.addNode(view, ObjectNode.class, new Point(420, 40));
        Node objectNode6 = TestHelper.addNode(view, ObjectNode.class, new Point(520, 40));
        TestHelper.addEdge(view, SynchronousMessageEdge.class, objectNode1, objectNode2);
        TestHelper.addNode(view, PolylineNode.class, new Rectangle(40, 130, 140, 80));
        TestHelper.addEdge(view, CreateMessageEdge.class, objectNode2, objectNode3);
        TestHelper.addEdge(view, SynchronousMessageEdge.class, objectNode3, objectNode4);
        TestHelper.addEdge(view, SendSignalMessageEdge.class, objectNode4, objectNode5);
        TestHelper.addEdge(view, AsynchronousMessageEdge.class, objectNode5, objectNode6);
    }

}
