/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.util.EnumMap;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SynchronousMessageEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link CreateMessageEdge}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class SynchronousMessageEdgeFailureTests extends TestCase {
    /**
     * <p>
     * Represents the Link used in testing.
     * </p>
     */
    private Link link;

    /**
     * <p>
     * Represents the GraphEdge used in testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Represents a map of ending properties.
     * </p>
     */
    private EnumMap<ConfiguredEdgeEndingPropertyType, String> endProperties;

    /**
     * <p>
     * Represents a map of edge properties.
     * </p>
     */
    private EnumMap<SequenceEdgePropertyType, String> edgeProperties;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        link = new LinkImpl();
        graphEdge = new GraphEdge();

        endProperties = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);
        edgeProperties = new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
    }

    /**
     * <p>
     * assert the failure of the constructor.
     * </p>
     */
    private void assertionSynchronousMessageEdgeCtor() {
        try {
            new SynchronousMessageEdge(link, graphEdge, endProperties, edgeProperties);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SynchronousMessageEdge#SynchronousMessageEdge(Link, GraphEdge, EnumMap, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testSynchronousMessageEdge_NullLink() {
        link = null;

        assertionSynchronousMessageEdgeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SynchronousMessageEdge#SynchronousMessageEdge(Link, GraphEdge, EnumMap, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testSynchronousMessageEdge_NullGraphEdge() {
        graphEdge = null;

        assertionSynchronousMessageEdgeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SynchronousMessageEdge#SynchronousMessageEdge(Link, GraphEdge, EnumMap, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testSynchronousMessageEdge_NullEndingProperties() {
        endProperties = null;

        assertionSynchronousMessageEdgeCtor();
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SynchronousMessageEdge#SynchronousMessageEdge(Link, GraphEdge, EnumMap, EnumMap)}</code>
     * constructor.
     * </p>
     */
    public void testSynchronousMessageEdge_NullEdgeProperties() {
        edgeProperties = null;

        assertionSynchronousMessageEdgeCtor();
    }

}