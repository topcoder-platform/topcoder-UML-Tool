/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * The EdgeLayoutStrategy interface encapsulates layout algorithm.
 * </p>
 *
 * <p>
 * This interface defines a single method layout() to layout edges.
 * </p>
 *
 * Thread-safety: Implementations needn't be thread-safe.
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 *
 */
public interface EdgeLayoutStrategy {
    /**
     * <p>
     * Layout the specified edges by setting their properties, returns generated LifelineSegments
     * that are corresponding to the edges.
     * </p>
     *
     * @param edges the edges to layout, can't be null, can't contain null element
     * @param edgeNodeMapping The edgeNodeMapping is used to find associated ObjectNode of each
     * edge.
     * <p>
     * The first element represents the started node. The second element represents the ended node.
     *
     * @return a list of generated LifelineSegment, never be null but may be empty, never contain
     * null element
     *
     * @throws EdgeLayoutException if any error occurs during layout
     * @throws IllegalArgumentException if edges is null or contain null element,or
     * edgeNodeMapping is null or not under the constraints above.
     */
    public List<LifelineSegment> layout(List<SequenceEdge> edges, Map<SequenceEdge, ObjectNode[]> edgeNodeMapping)
            throws EdgeLayoutException;
}
