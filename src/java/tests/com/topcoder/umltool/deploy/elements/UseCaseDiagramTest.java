/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Tests for adding, removing, and persistence for use case diagram.
 * </p>
 * @author ly
 * @version 1.0
 */
public class UseCaseDiagramTest extends DiagramTest {

    /**
     * <p>
     * Creates an use case diagram for testing.
     * </p>
     */
    public void createDiagram() {
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        TestHelper.addNode(view, SubsystemNodeContainer.class, new Point(20, 20));
        Node useCaseNode1 = TestHelper.addNode(view, UseCaseNode.class, new Point(40, 40));
        Node useCaseNode2 = TestHelper.addNode(view, UseCaseNode.class, new Point(40, 150));
        Node useCaseNode3 = TestHelper.addNode(view, UseCaseNode.class, new Point(40, 250));
        Node useCaseNode4 = TestHelper.addNode(view, UseCaseNode.class, new Point(10, 350));
        Node useCaseNode5 = TestHelper.addNode(view, UseCaseNode.class, new Point(450, 400));
        Node useCaseNode6 = TestHelper.addNode(view, UseCaseNode.class, new Point(300, 150));
        Node useCaseNode = TestHelper.addNode(view, UseCaseNode.class, new Point(300, 300));
        Node actorNode = TestHelper.addNode(view, ActorNode.class, new Point(600, 300));
        TestHelper.addNode(view, FreeTextNode.class, new Point(320, 20));
        Node commentNode = TestHelper.addNode(view, CommentNode.class, new Point(620, 120));
        TestHelper.addEdge(view, CommentLinkEdge.class, useCaseNode, commentNode);
        TestHelper.addEdge(view, DependencyEdge.class, actorNode, useCaseNode);
        TestHelper.addEdge(view, IncludeEdge.class, useCaseNode, useCaseNode1);
        TestHelper.addEdge(view, IncludeEdge.class, useCaseNode, useCaseNode2);
        TestHelper.addEdge(view, ExtendEdge.class, useCaseNode, useCaseNode3);
        TestHelper.addEdge(view, IncludeEdge.class, useCaseNode, useCaseNode4);
        TestHelper.addEdge(view, ExtendEdge.class, useCaseNode, useCaseNode5);
        TestHelper.addEdge(view, ExtendEdge.class, useCaseNode, useCaseNode6);
    }

}
