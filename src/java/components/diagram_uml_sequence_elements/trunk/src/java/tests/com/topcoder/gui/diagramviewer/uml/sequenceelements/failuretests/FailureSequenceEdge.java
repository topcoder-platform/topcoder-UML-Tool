/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.util.EnumMap;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.uml.model.commonbehavior.links.Link;

/**
 * <p>
 * Dummy implementation of <code>{@link SequenceEdge}</code> abstract class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FailureSequenceEdge extends SequenceEdge {

    /**
     * <p>
     * Constructs an <code>FailureSequenceEdge</code> instance.
     * </p>
     * @param link
     *            the link
     * @param graphEdge
     *            graph edge.
     * @param lineStyle
     *            line style
     * @param leftEnding
     *            left ending
     * @param rightEnding
     *            right ending
     * @param propertyNameMapping
     *            property name mapping.
     */
    public FailureSequenceEdge(Link link, GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding,
        EdgeEnding rightEnding, EnumMap<SequenceEdgePropertyType, String> propertyNameMapping) {
        super(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
    }
}