/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgelayout.DefaultEdgeLayoutStrategy;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * <p>
 * This is the stress test cases for <code>DefaultEdgeLayoutStrategy</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 */
public class DefaultEdgeLayoutStrategyTestStress extends TestCase {

    /**
     * The <code>DefaultEdgeLayoutStrategy</code> instance for stress test.
     */

    private DefaultEdgeLayoutStrategy dels;

    private int EDGE_SPACING=12;

    /**
     * The value of the edgeSpace for stress test.
     */

    private final static int EDGE_SPACE = 12;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        this.dels = new DefaultEdgeLayoutStrategy(EDGE_SPACE);
    }

    /**
     * Tears down test environment .
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        this.dels = null;
    }

    /**
     * This is the stress test for the method : List<LifelineSegment>
     * layout(List<SequenceEdge> edges, Map<SequenceEdge, ObjectNode[]>
     * edgeNodeMapping)
     *
     * @throws Exception
     *             to JUnit
     */
    public void testLayoutStress() throws Exception {
        // the test start time.
        long startTime = System.currentTimeMillis();

        // run the test for RUN_TIMES times.
        for (int i = 0; i < StressTestsHelper.RUN_TIMES; i++) {

            // Prepare the test input.

            EnumMap<ObjectNodePropertyType, String> nodePropertyNameMapping =
                    new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
            nodePropertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "red");

            ObjectNode node1 = new ObjectNode(new ObjectImpl(), new GraphConnector(), StressTestsHelper.createGraphNode(), new Point(),
                                              new Rectangle(10, 20, 30, 40), StressTestsHelper.createSelectionCorner(),
                                              nodePropertyNameMapping);

            ObjectNode node2 = new ObjectNode(new ObjectImpl(), new GraphConnector(), StressTestsHelper.createGraphNode(), new Point(),
                                              new Rectangle(80, 20, 30, 40), StressTestsHelper.createSelectionCorner(),
                                              nodePropertyNameMapping);

            EnumMap<ConfiguredEdgeEndingPropertyType, String> confEdgeEndPropertyMapping =
                    new EnumMap<ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);
            confEdgeEndPropertyMapping.put(ConfiguredEdgeEndingPropertyType.STROKE_COLOR, "red");

            EnumMap<SequenceEdgePropertyType, String> seqEdgeEndPropertyMapping =
                    new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
            seqEdgeEndPropertyMapping.put(SequenceEdgePropertyType.FILL_COLOR, "red");

            GraphEdge graphEdge = new GraphEdge();
            com.topcoder.diagraminterchange.Point p1 = new com.topcoder.diagraminterchange.Point();
            p1.setX(0);
            p1.setY(0);
            graphEdge.addWaypoint(p1);
            com.topcoder.diagraminterchange.Point p2 = new com.topcoder.diagraminterchange.Point();
            p2.setX(1);
            p2.setY(0);
            graphEdge.addWaypoint(p2);

            SequenceEdge edge = new SynchronousMessageEdge(new LinkImpl(), StressTestsHelper.createGraphEdge(),
                    confEdgeEndPropertyMapping,
                    seqEdgeEndPropertyMapping);

            SequenceEdge returnEdge = new ReturnMessageEdge(new LinkImpl(), StressTestsHelper.createGraphEdge(),
                    confEdgeEndPropertyMapping,
                    seqEdgeEndPropertyMapping);

            List<SequenceEdge> edgesList = new ArrayList<SequenceEdge>();
            edgesList.add(edge);
            edgesList.add(returnEdge);

            Map<SequenceEdge, ObjectNode[]> nodeMap = new HashMap<SequenceEdge, ObjectNode[]>();
            nodeMap.put(edge, new ObjectNode[] {node1, node2});
            nodeMap.put(returnEdge, new ObjectNode[] {node2, node1});

            // Run the layout algorithm.

            List<LifelineSegment> lsList = this.dels.layout(edgesList, nodeMap);

            // Check coordinates of all objects.

            Rectangle node1Bounds = node1.getBounds();
            Rectangle node2Bounds = node2.getBounds();

            List<SelectionCorner> edgeWayPoints = edge.getWayPoints();


        }

        long endTime = System.currentTimeMillis();
        System.out
                .println("Run "
                        + StressTestsHelper.RUN_TIMES
                        + " DefaultEdgeLayoutStrategy#layout(List<SequenceEdge> edges, Map<SequenceEdge, ObjectNode[]> edgeNodeMapping) method takes "
                        + (endTime - startTime) + "ms");
    }

}
