/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEnding;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

/**
 * Stress test for SequenceEdge.
 * 
 * @author radium
 * @version 1.0
 */
public class SequenceEdgeTestStress extends TestCase {
    /**
     * The maximum process number for testing.
     */
    private int max = 10000;

    /**
     * Mock SequencEdge for testing.
     */
    private class MockSequenceEdge extends SequenceEdge {
        /**
         * Simple implementation.
         * 
         * @param link
         * @param graphEdge
         * @param lineStyle
         * @param leftEnding
         * @param rightEnding
         * @param propertyNameMapping
         */
        public MockSequenceEdge(Link link, GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding,
            EdgeEnding rightEnding, EnumMap<SequenceEdgePropertyType, String> propertyNameMapping) {
            super(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
        }
    }

    /**
     * Sample SequenceEdge for testing.
     */
    private SequenceEdge sequenceEdge;

    /**
     * Set up the environment for testing.
     */
    protected void setUp() throws Exception {
        EnumMap propertyNameMapping = new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
        propertyNameMapping.put(SequenceEdgePropertyType.FILL_COLOR, "red");

        EnumMap<ConfiguredEdgeEndingPropertyType, String> mapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
            ConfiguredEdgeEndingPropertyType.class);
        mapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "value");

        EdgeEnding rightEnding = new EmptyArrowEdgeEnding(mapping);
        EdgeEnding leftEnding = new EmptyArrowEdgeEnding(mapping);
        LineStyle lineStyle = new LineStyle(2, 2);
        Link link = new LinkImpl();
        GraphEdge graphEdge = StressTestsHelper.createGraphEdge();
        // add 3 waypoints.
        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());
        sequenceEdge = new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding,
            propertyNameMapping);
    }

    /**
     * Test method for setPropertyNameMappingElement(SequenceEdgePropertyType,
     * String).
     */
    public void testSetPropertyNameMappingElement() {
        SequenceEdgePropertyType[] types = SequenceEdgePropertyType.values();
        for (int i = 0; i < this.max; i++) {
            this.sequenceEdge.setPropertyNameMappingElement(types[i % types.length], "name" + i);
            assertTrue("Should be equal.", ("name" + i).equals(this.sequenceEdge
                .getPropertyNameMappingElement(types[i % types.length])));
        }
    }

    /**
     * Test method for getPropertyNameMappingElement(SequenceEdgePropertyType).
     */
    public void testGetPropertyNameMappingElement() {
        SequenceEdgePropertyType[] types = SequenceEdgePropertyType.values();
        for (int i = 0; i < this.max; i++) {
            this.sequenceEdge.setPropertyNameMappingElement(types[i % types.length], "name" + i);
            assertTrue("Should be equal.", ("name" + i).equals(this.sequenceEdge
                .getPropertyNameMappingElement(types[i % types.length])));
        }
    }

}
