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
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Tests for adding, removing, and persistence for class diagram.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ClassDiagramTest extends DiagramTest {

    /**
     * <p>
     * Creates a class diagram for testing.
     * </p>
     */
    public void createDiagram() {
        DiagramView view = TestHelper.getDiagramView(DiagramType.CLASS);
        TestHelper.addNode(view, PackageNode.class, new Point(20, 20));
        TestHelper.addNode(view, PackageNode.class, new Point(20, 320));
        TestHelper.addNode(view, PackageNode.class, new Point(500, 320));
        Node classNode1 = TestHelper.addNode(view, ClassNode.class, new Point(40, 40));
        Node classNode2 = TestHelper.addNode(view, ClassNode.class, new Point(300, 100));
        TestHelper.addEdge(view, GeneralizationEdge.class, classNode1, classNode2);
        Node interfaceNode = TestHelper.addNode(view, InterfaceNode.class, new Point(30, 350));
        TestHelper.addEdge(view, AbstractionEdge.class, classNode1, interfaceNode);
        Node exceptionNode = TestHelper.addNode(view, ExceptionNode.class, new Point(520, 350));
        TestHelper.addEdge(view, DependencyEdge.class, classNode2, exceptionNode);
        TestHelper.addNode(view, FreeTextNode.class, new Point(320, 20));
        Node commentNode = TestHelper.addNode(view, CommentNode.class, new Point(620, 120));
        TestHelper.addEdge(view, CommentLinkEdge.class, classNode2, commentNode);
    }

}
