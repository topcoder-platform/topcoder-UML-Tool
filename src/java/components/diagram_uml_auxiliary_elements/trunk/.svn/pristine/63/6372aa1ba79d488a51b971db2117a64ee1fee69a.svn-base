/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentConnector;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Accuracy test of <code>CommentConnector</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class CommonConnectorAccuracyTest extends TestCase {

    /**
     * <p>
     * The CommentConnector instance for helping testing.
     * </p>
     */
    private CommentConnector commentConnector;

    /**
     * <p>
     * The CommentNode instance for helping testing.
     * </p>
     */
    private CommentNode commentNode;

    /**
     * <p>
     * The DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * <p>
     * The DiagramView instance for helping testing.
     * </p>
     */
    private DiagramView view;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        super.setUp();
        // load config
    	ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        PropertyMapping propertyMapping = new PropertyMapping(ConfigHelper.ACC_NAMESPACE);
        GraphNode graphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        graphNode.setSemanticModel(usmb);
        com.topcoder.diagraminterchange.Point position = new com.topcoder.diagraminterchange.Point();
        position.setX(100);
        position.setY(100);
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setHeight(200);
        size.setWidth(200);
        graphNode.setPosition(position);
        graphNode.setSize(size);
        commentNode = new CommentNode(graphNode, propertyMapping);
        commentConnector = new CommentConnector(commentNode);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(0);
        point.setY(0);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);

        commentNode.notifyUpdate();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    	ConfigHelper.clearConfigration();
        commentConnector = null;
        commentNode = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests Accuracy of <code>getConnectionPoint(Point)</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetConnectionPointPointAccuracy() throws Exception {
        viewer.add(view);
        view.add(commentNode);
        Point wayPt = new Point(0, 0);
        Point ret = commentConnector.getConnectionPoint(wayPt);
        assertEquals("Connection point is not getted correctly", 100.0, ret.getX());
        assertEquals("Connection point is not getted correctly", 100.0, ret.getY());

        wayPt = new Point(299, 150);
        ret = commentConnector.getConnectionPoint(wayPt);
        assertEquals("Connection point is not getted correctly", 300.0, ret.getX());
        assertEquals("Connection point is not getted correctly", 150.0, ret.getY());

        wayPt = new Point(400, 0);
        ret = commentConnector.getConnectionPoint(wayPt);

        assertEquals("Connection point is not getted correctly", 295.0, ret.getX());
        assertEquals("Connection point is not getted correctly", 105.0, ret.getY());

        wayPt = new Point(200, 302);
        ret = commentConnector.getConnectionPoint(wayPt);

        assertEquals("Connection point is not gotten correctly", 200.0, ret.getX());
        assertEquals("Connection point is not gotten correctly", 300.0, ret.getY());
    }
}