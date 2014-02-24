/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.EnumMap;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.FilledArrowEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.NothingEdgeEnding;
import com.topcoder.uml.model.commonbehavior.links.Link;

/**
 * <p>
 * The concrete edge for Synchronous Message used on sequence diagrams.
 * The painting of the edge is implemented.
 * </p>
 *
 * <p>
 * Thread Safety : The class is mutable and so is not thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class SynchronousMessageEdge extends SequenceEdge {

    /**
     * <p>
     * Constructs the class and set related class variables by using the arguments.
     * </P>
     *
     * <p>
     * Note, the lineStyle should define continuous line. The left ending should be
     * NothingEdgeEnding. The right ending should be FilledArrowEdgeEnding.
     * </p>
     *
     * @param link The instance of the Link. This is ModelElement providing useful information
     * (for example, name) for the edge.
     * @param graphEdge Instance of the GraphEdge class. Provides the information about the edge size.
     * @param edgeproperty The predefined Map with information about property names configuration.
     * The properties are from DiagramElement parent class.
     * @param endproperty The predefined <code>Map</code> with information about property
     * names configuration. The properties are from <code>DiagramElement</code> class.
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public SynchronousMessageEdge(Link link, GraphEdge graphEdge,
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endproperty,
        EnumMap<SequenceEdgePropertyType, String> edgeproperty) {
        super(link, graphEdge, new LineStyle(1, 0), new NothingEdgeEnding(endproperty), new FilledArrowEdgeEnding(
            endproperty), edgeproperty);
    }

    /**
     * <p>
     * The drawing function for the edge. It paints the edge differently for
     * different RenderScheme.
     * </p>
     *
     * @param g The reference to the Graphics instance, which is used for edge drawing.
     *
     * @throws IllegalArgumentException if argument is null
     */
    protected void paintComponent(Graphics g) {
        Util.paintSequenceEdge(g, this);
    }

    /**
     * <p>
     * Checks whether the point is inside the edge shape.
     * </p>
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return The flag, which says whether the point is inside the edge bounds.
     */
    public boolean contains(int x, int y) {
        return super.contains(x, y);
    }

    /**
     * <p>
     * Returns the bounding rectangle of the edge.
     * </p>
     *
     * @return The bounds of the edge and its selection.
     */
    public Rectangle getBounds() {
        return super.getBounds();
    }
}
