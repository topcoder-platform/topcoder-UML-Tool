/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout.DefaultEdgeLayoutStrategy;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.TestUtil;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * <p>
 * This class only contains the demonstration for programmatic usage. For the swing drawing
 * demonstrations, please run the following classes:
 * <ul>
 * <li>AsynchronousMessageEdgeTests</li>
 * <li>ObjectNodeTests</li>
 * <li>CreateMessageEdgeTests</li>
 * <li>ReturnMessageEdgeTests</li>
 * <li>SendSignalMessageEdgeTests</li>
 * <li>LifelineTests</li>
 * <li>LifelineSegmentTests</li>
 * </ul>
 * Note, each class has a program entry, that is, the main(String[]) method.
 * </p>
 *
 * <p>
 * Change for v1.1: Add the demo test for Lifeline,LifelineSegment and DefaultEdgeLayoutStrategy in
 * testDemo method.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This test case demonstrates the basic usage of this component in programmatic way.
     * </p>
     *
     * <p>
     * Change for v1.1: Add the demo test for Lifeline,LifelineSegment and
     * DefaultEdgeLayoutStrategy.
     * </p>
     *
     * @since 1.0
     */
    public void testDemo() {
        // Create the node
        ObjectNode objNode = TestHelper.createObjectNode();

        // Work with properties
        objNode.setName("NewClass");
        objNode.setIsStereotypesVisible(false);
        objNode.setIsNameVisible(true);
        objNode.setFontFamily("Times New Roman");
        objNode.setFontSize(objNode.getFontSize() + 2);
        objNode.setFontColor(Color.RED);
        objNode.setFontStyle(Font.BOLD);
        objNode.setStrokeColor(Color.GREEN);

        // Work with size and position
        Dimension size = objNode.getPreferredSize("NewInterface", true, true);
        objNode.setSize(size);
        objNode.setName("NewInterface");
        objNode.setIsStereotypesVisible(true);
        objNode.setPosition(new Point(50, 20));

        // Add popup menu
        JPopupMenu popup = new JPopupMenu();
        objNode.setPopup(popup);

        // Register to the listeners
        ResizeListener rszHandler = new MockResizeListener();
        objNode.addResizeListener(rszHandler);
        EditNameListener editNameHandler = new MockEditNameListener();
        objNode.addEditNameListener(editNameHandler);
        SetNameListener setNameHandler = new MockSetNameListener();
        objNode.addSetNameListener(setNameHandler);

        // Prepare the other objects for edge instantiating
        Link link = new LinkImpl();

        // set up the GraphEdge instance
        Diagram diagram = new Diagram();
        GraphEdge graphEdge = TestHelper.createGraphEdge();
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(graphEdge);

        // Instantiate different edges with different edge endings
        CreateMessageEdge createMessageEdge = new CreateMessageEdge(link, graphEdge, TestHelper
                .createEdgeEndingProperties(), TestHelper.createSequenceEdgeProperties());
        SynchronousMessageEdge synchMessageEdge = new SynchronousMessageEdge(link, graphEdge, TestHelper
                .createEdgeEndingProperties(), TestHelper.createSequenceEdgeProperties());
        AsynchronousMessageEdge asynchMessageEdge = new AsynchronousMessageEdge(link, graphEdge, TestHelper
                .createEdgeEndingProperties(), TestHelper.createSequenceEdgeProperties());
        SendSignalMessageEdge sendSigMessageEdge = new SendSignalMessageEdge(link, graphEdge, TestHelper
                .createEdgeEndingProperties(), TestHelper.createSequenceEdgeProperties());
        ReturnMessageEdge retMessageEdge = new ReturnMessageEdge(link, graphEdge, TestHelper
                .createEdgeEndingProperties(), TestHelper.createSequenceEdgeProperties());

        // Add popup menu
        JPopupMenu popup1 = new JPopupMenu();
        createMessageEdge.setPopup(popup1);
        synchMessageEdge.setPopup(popup1);
        asynchMessageEdge.setPopup(popup1);
        sendSigMessageEdge.setPopup(popup1);
        retMessageEdge.setPopup(popup1);

        /*
         * Test for Lifeline,LifelineSegment and EdgeLayoutStrategy
         */

        // Lifeline and LifelineSegment are generated by the component, end user
        // needn¡¯t
        // care about how to create them.
        LifelineSegment segment = TestUtil.createLifelineSegment();
        Lifeline line = TestUtil.createLifeline();

        // Set properties of a lifeline segment and a lifeline
        segment.setShadowLength(3);
        segment.setStrokeColor(Color.YELLOW);
        line.setStrokeColor(Color.BLUE);
        line.setLifelineLength(100);

        // Add popup menu to a lifeline segment
        JPopupMenu popup2 = new JPopupMenu();
        segment.setPopup(popup2);
        line.setPopup(popup2);

        // Layout edges
        Map<SequenceEdge, ObjectNode[]> edgeNodeMapping = new HashMap<SequenceEdge, ObjectNode[]>();
        List<SequenceEdge> allEdges = TestUtil.createSimpleSequnceEdgeAndAssociation(edgeNodeMapping);

        DefaultEdgeLayoutStrategy defaultLayout = new DefaultEdgeLayoutStrategy();
        // We can modify the edge space
        defaultLayout.setEdgeSpace(20);
        EdgeLayoutStrategy algo = defaultLayout;
        try {
            List<LifelineSegment> lifelineSegments = algo.layout(allEdges, edgeNodeMapping);
        } catch (EdgeLayoutException e) {
            fail("Should not get EdgeLayoutException");
        }
    }
}
