/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.gui.diagramviewer.edges.WayPointListener;
import com.topcoder.gui.diagramviewer.edges.Connector;

import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;

import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Dimension;
import java.awt.Point;


/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * <p>
 * This class only contains the demonstration for programmatic usage.
 * For the swing drawing demonstrations, please run the following classes:
 * <ul>
 * <li>CommentNodeTests</li>
 * <li>FreeTextNodeTests</li>
 * <li>PolylineNodeTests</li>
 * <li>CommentLinkEdgeTests</li>
 * </ul>
 * Note, each class has a testFrame method.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }

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
     * <strong>Demo test:</strong>
     * </p><p>
     * This method shows the functionality of the <code>PolylineNode</code>.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testForPolylineNode() throws Exception {
        // create a polyline node
        PolylineNode polylineNode = new PolylineNode(new Polyline(), new PropertyMapping());
        DiagramViewer viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        DiagramView view = viewer.createDiagramView(diagram);
        view.add(polylineNode);

        // implement a selection corner dragged listener
        // the event occurs before the boundary is actually changed.
        class PolylineCornerDragListener implements CornerDragListener {
            /**
             * @param e - the SelectionBoundEvent
             */
            public void cornerDragged(SelectionBoundEvent e) {
                // change the vertex of polyline according to new bound
                // update the visual looking of polyline
                ((PolylineNode) e.getSource()).notifyUpdate();
            }
        }

        // add selection corner listener to actually change the polyline boundary
        polylineNode.addCornerDragListener(new PolylineCornerDragListener());

        // implement boundary change listener
        // the event occurs after the boundary is actually changed.
        class PolyLineBoundaryListener implements BoundaryChangeListener {
            /**
             * @param e - the BoundaryChangeEvent
             */
            public void boundaryChanged(BoundaryChangeEvent e) {
                // changed the location of the nearby nodes
                // change the size of diagram viewer to contain it.
            }
        }

        // add the boundary changed listener
        polylineNode.addBoundaryChangeListener(new PolyLineBoundaryListener());
    }

    /**
     * <p>
     * <strong>Demo test:</strong>
     * </p><p>
     * This method shows the functionality of the <code>CommentNode</code> and the <code>CommentLinkEdge</code>.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testForCommentNodeAndCommentLinkEdge() throws Exception {
        // load configuration, and create property mappings
        TestHelper.clearConfig();
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        PropertyMapping propMapping = new PropertyMapping(VALID_NAMESPACE);

        // create graphNode for CommentNode
        GraphNode graphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement((Element) new CommentImpl());
        graphNode.setSemanticModel(usmb);
        graphNode.addContained(new TextElement());
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());

        // create comment node with property mapping
        CommentNode commentNode = new CommentNode(graphNode, propMapping);
        DiagramViewer viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        DiagramView view = viewer.createDiagramView(diagram);
        view.add(commentNode);

        // create a class to listen to text change event.
        class CommentChangeListener implements TextChangeListener {
            /**
             * @param e - the TextChangeEvent
             */
            public void textChanged(TextChangeEvent e) {
                // retrieve the CommentNode, GraphNode, Comment element
                CommentNode node = (CommentNode) e.getSource();
                GraphNode graphNode = node.getGraphNode();
                Comment comment =
                    (Comment) ((Uml1SemanticModelBridge) graphNode.getSemanticModel()).getElement();

                // actually change the text
                comment.setBody(e.getNewText());

                // get preferred size
                Dimension newSize = node.getPreferredSize(e.getNewText());
                com.topcoder.diagraminterchange.Dimension newSize2 =
                    new com.topcoder.diagraminterchange.Dimension();
                newSize2.setWidth(newSize.width);
                newSize2.setHeight(newSize.height);

                // change size of graphNode according to new text
                graphNode.setSize(newSize2);

                // notify the size of graphNode is changed.
                // the comment node will be updated accordinly.
                node.notifyUpdate();
            }
        }

        // register the text change listener
        // the text can be changed, and node will be resized automatically
        commentNode.addTextChangeListener(new CommentChangeListener());

        // set up the graphEdge instance
        GraphEdge graphEdge = new GraphEdge();
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));

        // create a comment link edge.
        CommentLinkEdge commentLink = new CommentLinkEdge(graphEdge);

        // create a class used to change the location of edge ending
        class CommentLinkEdgeEndingDragListener implements WayPointListener {
            /**
             * @param e - the WayPointEvent
             */
            public void wayPointDragged(WayPointEvent e) {
                // check whether the ending is dragged....

                // retrieve the edge
                CommentLinkEdge edge = (CommentLinkEdge) e.getSource();

                // retrieve the CommentNode link to this edge.
                //CommentNode commentNode = edge.getLeftConnector();

                // get connector link to this edge.
                Connector connector;
                if (edge.getLeftEnding().getEndingPoint().equals(e.getOldPosition())) {
                    connector = edge.getLeftConnector();
                } else {
                    connector = edge.getRightConnector();
                }

                // get the actual connection point
                Point p = connector.getConnectionPoint(e.getNewPosition());

                // update the ending in diagram interchage.
                com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
                point.setX(p.getX());
                point.setY(p.getY());
                edge.getGraphEdge().addWaypoint(point);
            }
        }

        // add the ending change listener.
        // then it will be linked to the comment node appropriately.
        commentLink.addWayPointDragListener(new CommentLinkEdgeEndingDragListener());
    }

    /**
     * <p>
     * <strong>Demo test:</strong>
     * </p><p>
     * This method shows the functionality of the <code>FreeTextNode</code>.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testForFreeTextNode() throws Exception {
        // load configuration, and create property mappings
        TestHelper.clearConfig();
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        PropertyMapping propMapping = new PropertyMapping(VALID_NAMESPACE);

        // create graphNode for FreeTextNode
        GraphNode graphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo(FREE_TEXT);
        graphNode.setSemanticModel(ssme);
        graphNode.addContained(new TextElement());
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());

        // create freeText node with property mapping
        FreeTextNode freeTextNode = new FreeTextNode(graphNode, propMapping);
        DiagramViewer viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        DiagramView view = viewer.createDiagramView(diagram);
        view.add(freeTextNode);

        // create a class to listen to text change event.
        class FreeTextChangeListener implements TextChangeListener {
            /**
             * @param e - the TextChangeEvent
             */
            public void textChanged(TextChangeEvent e) {
                // retrieve the FreeTextNode, GraphNode, TextElement
                FreeTextNode node = (FreeTextNode) e.getSource();
                GraphNode graphNode = node.getGraphNode();
                TextElement textElement = (TextElement) graphNode.getContaineds().get(0);

                // actually change the text
                textElement.setText(e.getNewText());

                // get preferred size
                Dimension newSize = node.getPreferredSize(e.getNewText());
                com.topcoder.diagraminterchange.Dimension newSize2 =
                    new com.topcoder.diagraminterchange.Dimension();
                newSize2.setWidth(newSize.width);
                newSize2.setHeight(newSize.height);

                // change size of graphNode according to new text
                graphNode.setSize(newSize2);

                // notify the size of graphNode is changed.
                // the freeText node will be updated accordinly.
                node.notifyUpdate();
            }
        }

        // register the text change listener
        // the text can be changed, and node will be resized automatically
        freeTextNode.addTextChangeListener(new FreeTextChangeListener());
    }
}
