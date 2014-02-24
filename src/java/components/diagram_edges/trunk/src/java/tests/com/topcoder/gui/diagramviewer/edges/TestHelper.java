/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.io.File;
import java.util.Iterator;

import junit.framework.Assert;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * <p>
     * This method creates a Edge instance for helping testing.
     * </p>
     *
     * @return the newly create Edge instance
     *
     * @throws Exception to JUnit
     */
    public static Edge createEdge() throws Exception {
        Diagram diagram = new Diagram();
        GraphEdge edge = new GraphEdge();
        edge.addWaypoint(createDiagramInterchangePoint(100, 100));
        edge.addWaypoint(createDiagramInterchangePoint(200, 200));

        GraphNode node1 = new GraphNode();
        edge.addContained(node1);
        node1.setContainer(edge);
        GraphNode node2 = new GraphNode();
        edge.addContained(node2);
        node2.setContainer(edge);
        GraphNode node3 = new GraphNode();
        edge.addContained(node3);
        node3.setContainer(edge);
        GraphNode node4 = new GraphNode();
        edge.addContained(node4);
        node4.setContainer(edge);
        GraphNode node5 = new GraphNode();
        edge.addContained(node5);
        node5.setContainer(edge);
        GraphNode node6 = new GraphNode();
        edge.addContained(node6);
        node6.setContainer(edge);

        diagram.addContained(edge);
        edge.setContainer(diagram);

        TriangleEdgeEnding ending = new TriangleEdgeEnding(0, new Point(200, 100));

        Edge gEdge = new GeneralizationEdge(edge, ending);
        gEdge.addTextField(node1, "Head", AnchorType.LeftEnding);
        gEdge.addTextField(node2, "Head2", AnchorType.LeftEnding);
        gEdge.addTextField(node3, "Tail", AnchorType.RightEnding);
        gEdge.addTextField(node4, "Tail2", AnchorType.RightEnding);
        gEdge.addTextField(node5, "Middle", AnchorType.Line);
        gEdge.addTextField(node6, "Middle2", AnchorType.Line);

        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(gEdge);

        return gEdge;
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange component.
     * </p>
     *
     * @param x the x-coordinate position of the point
     * @param y the y-coordinate position of the points
     *
     * @return the point instance defined in Diagram Interchange component with the given x and y coordinate value.
     */
    public static com.topcoder.diagraminterchange.Point createDiagramInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(x);
        pt.setY(y);

        return pt;
    }

    /**
     * <p>
     * This method creates a Dimension instance defined in Diagram Interchange component.
     * </p>
     *
     * @param width the width
     * @param height the height
     *
     * @return the Dimension instance defined in Diagram Interchange component with the given width and height value.
     */
    public static Dimension createDiagramInterchangeDimension(int width, int height) {
        Dimension dimension = new Dimension();
        dimension.setWidth(width);
        dimension.setHeight(height);

        return dimension;
    }

    /**
     * <p>
     * Assert the edge is active in the diagram viewer.
     * </p>
     *
     * @param edge the Edge instance
     */
    public static void verifyEdgeActive(Edge edge) {
        Assert.assertTrue("The edge should be active in the diagram viewer.",
            edge.getDiagramViewer().isElementSelected(edge));
    }
}
