/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EnumMap;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegmentPropertyType;

/**
 * <p>
 * This is the mock class extends from <code>Lifeline</code> used for stress
 * test.
 * </p>
 * <p>
 * This mock class make the three protected method of its parent class to
 * public.
 * </p>
 *
 * @author littleken
 * @version 1.1
 */
public class MockLifelineSegment extends LifelineSegment {

    /**
     * This is the serialVersionUID of this class.
     */
    private static final long serialVersionUID = 8931002558588437385L;

    /**
     * <p>
     * Construct the class and set related class variables by using the
     * arguments. The instance variables should be first loaded from property in
     * graphNode, if not found in step 1, then loaded from ConfigManager, if
     * still not found, set to its related DEFAULT value.
     * </p>
     * <p>
     * The constructor should check parent DiagramElement properties by using
     * their predefined names from the propertyNameMapping argument. If the
     * properties exist then their value should be used to update related
     * instance variables: strokeColor, fillColor and so on. If some properties
     * are absent then they should be created from these instance variables.
     * </p>
     *
     * @param graphNode
     *            Reference to the instance of GraphNode class.
     * @param position
     *            The position of the node - instance of Point class.
     * @param bound
     *            The bound of selection corners.
     * @param propertyNameMapping
     *            The predefined Map with information about property names
     *            configuration. The properties are from DiagramElement parent
     *            class, the value can't be null or empty
     * @throws IllegalArgumentException
     *             If any argument is null, or if propertyNameMapping is
     *             null/empty, or any value in map is null or empty
     */
    public MockLifelineSegment(GraphNode graphNode, Point position, Rectangle bound,
            EnumMap<LifelineSegmentPropertyType, String> propertyNameMapping) {
        super(graphNode, position, bound, propertyNameMapping);
    }

    /**
     * <p>
     * Consume event when the diagram viewer is in the state of adding element.
     * If true is returned, it means that the event is consumed in the element.
     * If false is returned, it means that the event should be passed behind.
     * This method should get the instance of the DiagramViewer from the parent
     * class (Node.getDiagramViewer), and then check the state of the
     * DiagramViewer. How to get this information will be defined when the
     * DiagramViewer design will be implemented.
     * </p>
     *
     * @param event
     *            The instance of the mouse event.
     * @return Flag - whether the event was consumed in the component.
     * @throws IllegalArgumentException
     *             If argument is null.
     */
    public boolean consumeEvent(MouseEvent event) {
        return super.consumeEvent(event);
    }

    /**
     * <p>
     * Override processMouseEvent. It can treat mouse event differently when
     * diagram viewer is in different state. Use consumeEvent to determine the
     * current state. The right mouse button click is processed. It will show
     * the popup (if it was registered on this component).
     * </p>
     *
     * @param e
     *            The instance of the MouseEvent.
     * @throws IllegalArgumentException
     *             If argument is null.
     */
    public void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
    }

    /**
     * <p>
     * The drawing function for the edge. It paints the edge differently for
     * different RenderScheme. Refer to the component specification for the
     * details.
     * </p>
     *
     * @param g
     *            The reference to the Graphics instance, which is used for edge
     *            drawing.
     * @throws IllegalArgumentException
     *             If argument is null.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
