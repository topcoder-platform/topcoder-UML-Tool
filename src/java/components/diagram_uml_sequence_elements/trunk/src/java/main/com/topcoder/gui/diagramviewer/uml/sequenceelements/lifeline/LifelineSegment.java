/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;

import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.Util;

/**
 * <p>
 * The LifelineSegment class represents the lifeline segment in sequence diagram.
 * </p>
 *
 * <p>
 * This class is a concrete implementation of the Node abstract class. The main purpose - to draw
 * graphical representation of the lifeline segment.
 * </p>
 *
 * <p>
 * Many events are processed by the class and some are generated. Much functionality of event
 * processing logic is reused from the parent class.
 * </p>
 *
 * <p>
 * This class needs configuration and here is a sample:
 * </p>
 *
 * <pre>
 * &lt;Property name=&quot;LifelineSegmentStrokeColor&quot;&gt;
 *      &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentFillColor&quot;&gt;
 *      &lt;Value&gt;Color.GREEN&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentShadowColor&quot;&gt;
 *      &lt;Value&gt;Color.GRAY&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentRenderScheme&quot;&gt;
 *      &lt;Value&gt;0&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentWidth&quot;&gt;
 *      &lt;Value&gt;6&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentHeight&quot;&gt;
 *      &lt;Value&gt;16&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentWidthMinimum;&gt;
 *      &lt;Value&gt;4&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentHeightMinimum;&gt;
 *      &lt;Value&gt;6&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineSegmentShadowLength;&gt;
 *      &lt;Value&gt;6&lt;/Value&gt;
 * &lt;/Property&gt;
 * </pre>
 *
 *
 * Thread safety: The class is mutable and not thread safe.
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */

public class LifelineSegment extends com.topcoder.gui.diagramviewer.elements.Node {

    /**
     * <p>
     * Represents the minimum height of the component
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    public static final int MINIMUM_HEIGHT = 5;

    /**
     * <p>
     * Represents the minimum width of the component.
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    public static final int MINIMUM_WIDTH = 3;

    /**
     * <p>
     * Represents the namespace in the configuration file to use for loading default variables.
     * </p>
     *
     */
    private static final String CONFIG_NAMESPACE = "com.topcoder.gui.diagramviewer.uml."
            + "sequenceelements.lifeline.lifelinesegment";

    /**
     * <p>
     * Represents the default rendering scheme
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final RenderScheme DEFAULT_RENDER_SCHEME = RenderScheme.TopCoderScheme;

    /**
     * <p>
     * Represents the default length of the shadow.
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final int DEFAULT_SHADOW_LENGTH = 5;

    /**
     * <p>
     * Represents the defalut color of shadow.
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final Color DEFAULT_SHADOW_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default height of the component
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final int DEFAULT_HEIGHT = 15;

    /**
     * <p>
     * Represents the default width of the node.
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final int DEFAULT_WIDTH = 5;

    /**
     * <p>
     * Represents the default main fill color.
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final Color DEFAULT_FILL_COLOR = Color.WHITE;

    /**
     * <p>
     * Represents the default main color for foreground elements.
     * </p>
     *
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     *
     */
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the name of fillColor in the config file.
     * </p>
     *
     */
    private static final String ID_FILL_COLOR = "LifelineSegmentFillColor";

    /**
     * <p>
     * Represents the name of height in the config file.
     * </p>
     *
     */
    private static final String ID_HEIGHT = "LifelineSegmentHeight";

    /**
     * <p>
     * Represents the name of renderScheme in the config file.
     * </p>
     *
     */
    private static final String ID_RENDER_SCHEME = "LifelineSegmentRenderScheme";

    /**
     * <p>
     * Represents the name of shadowColor in the config file.
     * </p>
     *
     */
    private static final String ID_SHADOW_COLOR = "LifelineSegmentShadowColor";

    /**
     * <p>
     * Represents the name of shadowLength in the config file.
     * </p>
     *
     */
    private static final String ID_SHADOW_LENGTH = "LifelineSegmentShadowLength";

    /**
     * <p>
     * Represents the name of strokeColor in the config file.
     * </p>
     *
     */
    private static final String ID_STROKE_COLOR = "LifelineSegmentStrokeColor";

    /**
     * <p>
     * Represents the name of width in the config file.
     * </p>
     *
     */
    private static final String ID_WIDTH = "LifelineSegmentWidth";

    /**
     * <p>
     * Represents the name of minimum width in the config file.
     * </p>
     *
     */
    private static final String ID_MINIMUM_WIDTH = "LifelineSegmentWidthMinimum";

    /**
     * <p>
     * Represents the name of minimum height in the config file.
     * </p>
     *
     */
    private static final String ID_MINIMUM_HEIGHT = "LifelineSegmentHeightMinimum";

    /**
     * <p>
     * Represents the shadow color.&nbsp;The variable is set in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null. Use related setter function to mutate.
     * </p>
     *
     * <p>
     * The related getter function returns the current value of the variable.
     * </p>
     *
     */
    private Color shadowColor;

    /**
     * <p>
     * Represents the rendering scheme.
     * </p>
     *
     * <p>
     * The variable is set in the constructor. This variable is mutable and can be any value but
     * null.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value
     * of the variable.
     * </p>
     *
     */
    private RenderScheme renderScheme;

    /**
     * <p>
     * Represents the length of shadow.
     * </p>
     *
     * <p>
     * The variable is set in the constructor. This variable is mutable and can be 0 and any
     * positive value.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value
     * of the variable.
     * </p>
     *
     */
    private int shadowLength;

    /**
     * <p>
     * Represents the main fill color.
     * </p>
     *
     * <p>
     * The variable is set in the constructor. This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value
     * of the variable.
     * </p>
     *
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the main color for the foreground elements
     * </p>
     *
     * <p>
     * The variable is set in the constructor.This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value
     * of the variable.
     * </p>
     *
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the JPopupMenu related to this component.
     * </p>
     *
     * <p>
     * This variable is mutable and can be null.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value
     * of the variable.
     * </p>
     *
     *
     */
    private JPopupMenu popup = null;

    /**
     * <p>
     * Represents the Map of property names, used for getting values from the DiagramElement parent
     * object.
     * </p>
     *
     * <p>
     * This variable is set in constructor, non-mutable and can not be null.
     * </p>
     *
     * <p>
     * Use related setter function to mutate the elements of the Map. The related getter function
     * returns the value for the specified key from the Map.
     * </p>
     *
     */
    private final EnumMap<LifelineSegmentPropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Construct the class and set related class variables by using the arguments.
     * </p>
     *
     *
     * <p>
     * The instance variables should be 1)loaded from property in graphNode, 2)if not found in step
     * 1, loaded from ConfigManager 3)if not found in step 2, set to its correspondint DEFAULT value
     * </p>
     *
     *
     * @param graphNode Reference to the instance of GraphNode class.
     * @param position The position of the node - instance of Point class.
     * @param bound The bound of selection corners.
     * @param propertyNameMapping The predefined Map with information about property names
     * cofiguration. The properties are from DiagramElement parent class, the value can't be null or
     * empty
     *
     *
     * @throws IllegalArgumentException if any argument is null, or if
     * propertyNameMapping is null/empty, or any value in map is null or empty.
     *
     */
    public LifelineSegment(GraphNode graphNode, Point position, Rectangle bound,
            EnumMap<LifelineSegmentPropertyType, String> propertyNameMapping) {

        super(graphNode, position, bound, createDefaultCorners());

        // Check the arguments
        Util.checkNull(position, "position");
        Util.checkNull(bound, "bound");
        Util.checkNull(propertyNameMapping, "propertyNameMapping");

        if (propertyNameMapping.isEmpty()) {
            throw new IllegalArgumentException("The given propertyNameMapping is empty.");
        }

        // check the entry value in the propertyNameMapping
        Collection<String> values = propertyNameMapping.values();
        for (String entryvalue : values) {

            Util.checkString(entryvalue, "entryvalue in propertyNameMapping");
        }

        this.propertyNameMapping = propertyNameMapping;

        // load the stroke color, from the graph node properties or config
        // manager or the default one
        this.strokeColor = Util
                .readColorProperty(graphNode, propertyNameMapping.get(LifelineSegmentPropertyType.STROKE_COLOR),
                        CONFIG_NAMESPACE, ID_STROKE_COLOR, DEFAULT_STROKE_COLOR);

        // load the fill color, from the graph node properties or config manager
        // or the default one
        this.fillColor = Util.readColorProperty(graphNode, propertyNameMapping
                .get(LifelineSegmentPropertyType.FILL_COLOR), CONFIG_NAMESPACE, ID_FILL_COLOR, DEFAULT_FILL_COLOR);

        // load the shadow color, from the graph node properties or config
        // manager or the default one
        this.shadowColor = Util
                .readColorProperty(graphNode, propertyNameMapping.get(LifelineSegmentPropertyType.SHADOW_COLOR),
                        CONFIG_NAMESPACE, ID_SHADOW_COLOR, DEFAULT_SHADOW_COLOR);

        // load the shadow length, from the graph node properties or config
        // manager or the default one
        this.shadowLength = Util.readIntegerProperty(graphNode, propertyNameMapping
                .get(LifelineSegmentPropertyType.SHADOW_LENGTH), CONFIG_NAMESPACE, ID_SHADOW_LENGTH,
                DEFAULT_SHADOW_LENGTH);
        if (this.shadowLength < 0) {
            this.shadowLength = DEFAULT_SHADOW_LENGTH;
        }

        // load the render scheme, from the graph node properties or config
        // manager or the default one
        int defaultSchemeValue = (DEFAULT_RENDER_SCHEME == RenderScheme.SimpleScheme) ? 0 : 1;
        this.renderScheme = Util
                .parseReaderSchemeProperty(graphNode, propertyNameMapping
                        .get(LifelineSegmentPropertyType.RENDER_SCHEME), CONFIG_NAMESPACE, ID_RENDER_SCHEME,
                        defaultSchemeValue);

        // load the width, from the graph node properties or config manager or
        // the default one
        int width = Util.readIntegerProperty(graphNode, propertyNameMapping.get(LifelineSegmentPropertyType.WIDTH),
                CONFIG_NAMESPACE, ID_WIDTH, DEFAULT_WIDTH);

        // load the height, from the graph node properties or config manager or
        // the default one
        int height = Util.readIntegerProperty(graphNode, propertyNameMapping.get(LifelineSegmentPropertyType.HEIGHT),
                CONFIG_NAMESPACE, ID_HEIGHT, DEFAULT_HEIGHT);

        // load the minimum width, from the graph node properties or config
        // manager or the default one
        int minWidth = Util.readIntegerProperty(graphNode, propertyNameMapping
                .get(LifelineSegmentPropertyType.MINIMUM_WIDTH), CONFIG_NAMESPACE, ID_MINIMUM_WIDTH, MINIMUM_WIDTH);

        // load the minimum height, from the graph node properties or config
        // manager or the default one
        int minHeight = Util.readIntegerProperty(graphNode, propertyNameMapping
                .get(LifelineSegmentPropertyType.MINIMUM_HEIGHT), CONFIG_NAMESPACE, ID_MINIMUM_HEIGHT, MINIMUM_HEIGHT);

        if (width <= 0) {
            width = DEFAULT_WIDTH;
        }
        if (height <= 0) {
            height = DEFAULT_HEIGHT;
        }
        if (minWidth < 0) {
            minWidth = MINIMUM_WIDTH;
        }
        if (minWidth > width) {
            minWidth = width;
        }
        if (minHeight < 0) {
            minHeight = MINIMUM_HEIGHT;
        }
        if (minHeight > height) {
            minHeight = height;
        }

        this.setSize(width, height);
        this.setMinimumSize(new Dimension(minWidth, minHeight));
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param fillColor The color to fill.
     *
     * @throws IllegalArgumentException if fillColor is null
     */
    public void setFillColor(Color fillColor) {

        Util.checkNull(fillColor, "fillColor");
        this.fillColor = fillColor;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The length of shadow.
     */
    public int getShadowLength() {

        return this.shadowLength;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The stroke color.
     */
    public Color getStrokeColor() {

        return this.strokeColor;
    }

    /**
     * <p>
     * The setter method for the related class variable. See the variable description for the
     * details.
     * </p>
     *
     * @param shadowLength The length of shadow.
     *
     * @throws IllegalArgumentException if argument is negative.
     */
    public void setShadowLength(int shadowLength) {
        Util.checkInt_Negative(shadowLength, "shadowLength");
        this.shadowLength = shadowLength;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param strokeColor The stroke color.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    public void setStrokeColor(Color strokeColor) {

        Util.checkNull(strokeColor, "strokeColor");
        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The color of shadow.
     */
    public Color getShadowColor() {

        return this.shadowColor;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The value from RenderScheme enum.
     */
    public RenderScheme getRenderScheme() {

        return this.renderScheme;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The color to fill.
     */
    public Color getFillColor() {

        return this.fillColor;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param shadowColor The color of shadow.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    public void setShadowColor(Color shadowColor) {

        Util.checkNull(shadowColor, "shadowColor");
        this.shadowColor = shadowColor;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param renderScheme The value from RenderScheme enum.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    public void setRenderScheme(RenderScheme renderScheme) {

        Util.checkNull(renderScheme, "renderScheme");
        this.renderScheme = renderScheme;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The reference to the instance of the JPopupMenu implementation class.
     */
    public JPopupMenu getPopup() {

        return this.popup;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param popup The reference to the instance of the JPopupMenu implementation class.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    public void setPopup(JPopupMenu popup) {

        Util.checkNull(popup, "popup");
        this.popup = popup;
    }

    /**
     * <p> * Override processMouseEvent. It can treat mouse event differently when diagram viewer is
     * in different state.
     * </p>
     *
     * <p>
     * It is a template method and call the consumeEvent method.
     * </p>
     *
     * @param event The instance of the MouseEvent.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    protected void processMouseEvent(MouseEvent event) {

        Util.checkNull(event, "event");
        super.processMouseEvent(event);
    }

    /**
     * <p>
     * Consume event when the diagram viewer is in the state of adding element.
     * </p>
     *
     * <p>
     * If true is returned, it means that the event is consumed in the element. If false is
     * returned, it means that the event should be passed behind.
     * </p>
     *
     * <p>
     * The right mouse button click is processed. It will show the popup (if it was registered on
     * this component).
     * </p>
     *
     * <p>
     * The left mouse button click is processed.It will be selected,the border of the lifeline
     * segment will be wider(specifically, +1 pixel).
     * </p>
     *
     * <p>
     * Note:If the left mouse button clicked,it also return false and let the diagram viewer
     * handler receive the event and make the selection.
     * </p>
     *
     * @param event The instance of the mouse event.
     *
     * @return Flag - whether the event was consumed in the component.
     *
     * @throws IllegalArgumentException if argument is null.
     *
     */
    protected boolean consumeEvent(MouseEvent event) {

        Util.checkNull(event, "event");
        // variable indicates whether the evengt was consumed,initialized with false value.
        boolean consumed = false;

        DiagramViewer viewer = super.getDiagramViewer();
        // Check the state of diagram viewer.
        if (viewer != null) {
            DiagramState state = viewer.getState();
            if (state == DiagramState.SELECT_ELEMENT) {
                // set consumed to true first because the precondition holds
                consumed = true;
            }
        }

        // Process the mouse event only when consumed == true
        if (consumed && SwingUtilities.isRightMouseButton(event) && event.getID() == MouseEvent.MOUSE_CLICKED
                && event.getClickCount() == 1) {
                // right click will show the popup menu if any
            if (this.popup != null) {
                Point p = event.getPoint();
                SwingUtilities.convertPointToScreen(p, this);
                // Show this popup at the mouse place
                popup.setLocation(p.x, p.y);
                this.popup.setVisible(true);
            }
        } else {
            //set consumed back to false because the event is not consumed.
            consumed = false;
        }

        return consumed;
    }

    /**
     * <p>
     * The drawing function for the node.
     * </p>
     *
     * <p>
     * It paints the node differently for different RenderScheme.
     * </p>
     *
     * @param g The reference to the Graphics instance, which is used for node drawing.
     *
     * @throws IllegalArgumentException if argument is null,or the renderScheme can not be recognized.
     */
    protected void paintComponent(Graphics g) {

        Util.checkNull(g, "g");

        super.paintComponent(g);

        // backup the old color and restore it after the paint.
        Color oldcolor = g.getColor();

        Rectangle rect = getSelectionBound();

        if (renderScheme == RenderScheme.TopCoderScheme) {
            // Draw the shadow of the rectangle by using shadow color and shadow
            // length
            g.setColor(this.shadowColor);
            g.fillRect(rect.x + this.shadowLength, rect.y + this.shadowLength, rect.width, rect.height);
        }

        if (renderScheme == RenderScheme.TopCoderScheme || renderScheme == RenderScheme.SimpleScheme) {
            // Draw the filled rectangle with the size of lifeline segment by using
            // fill color and stroke color.
            g.setColor(this.fillColor);
            g.fillRect(rect.x, rect.y, rect.width, rect.height);

            g.setColor(this.strokeColor);
            g.drawRect(rect.x, rect.y, rect.width, rect.height);

            // If the component is selected,draw a wide border.
            if (isSelected()) {
                g.drawRect(rect.x - 1, rect.y - 1, rect.width + 2, rect.height + 2);
            }
        } else {
            throw new IllegalArgumentException("The render scheme can not be recognized.");
        }

        g.setColor(oldcolor);
    }

//    /**
//     * <p>
//     * Return the bounding rectangle of the node.
//     * </p>
//     *
//     * @return The bounds of the node and its selection.
//     */
//    public Rectangle getBounds() {
//        return getSelectionBound();
//    }

    /**
     * <p>
     * Check whether the point is inside the node shape.
     * </p>
     *
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     *
     * @return The flag, which says whether the point is inside the node bounds.
     */
    public boolean contains(int x, int y) {

        Rectangle rect = getSelectionBound();
        if (rect.contains(x, y)) {
            return true;
        }

        // Check the child component.
        for (int i = 0; i < getComponentCount(); i++) {
            Component c = getComponent(i);
            Point pt = SwingUtilities.convertPoint(this, x, y, c);
            if (c.contains(pt.x, pt.y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * The getter method for the propertyNameMapping element.
     * </p>
     *
     * <p>
     * Simply return the element value from the propertyNameMapping for the required key. If the
     * element is absent - return null.
     * </p>
     *
     *
     * @param key The key in the propertyNameMapping Map.
     * @return The value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key argument is null.
     */
    public String getPropertyNameMappingElement(LifelineSegmentPropertyType key) {

        Util.checkNull(key, "key");
        String value = propertyNameMapping.get(key);
        return value;
    }

    /**
     * <p>
     * The setter method for the propertyNameMapping element.
     * </p>
     *
     * <p>
     * If there is no element for required key then a new element will insert to the
     * propertyNameMapping Map. In other case - the existed element value should be replaced with a
     * new value.
     * </p>
     *
     *
     * @param key The key in the propertyNameMapping Map.
     * @param value The value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key argument is null or value
     * argument is null/empty.
     */
    public void setPropertyNameMappingElement(LifelineSegmentPropertyType key, String value) {

        // Check the arguments.
        Util.checkNull(key, "key");
        Util.checkString(value, "value");

        // Insert or replace the key/value pair.
        propertyNameMapping.put(key, value);
    }

    /**
     * <p>
     * Create a default Collection< SelectionCornerType > instance for the constructor.
     * </p>
     *
     * <p>
     * This method creates an empty collection.
     * </p>
     *
     * @return the Collection< SelectionCornerType > instance for the constructor
     */
    private static Collection<SelectionCornerType> createDefaultCorners() {

        return new HashSet<SelectionCornerType>();
    }

    /**
     * <p>
     * Check whether the LifelineSegment component is selected in the DiagramViewer.
     * </p>
     *
     * @return the flag - true if selected,false otherwise.
     */
    private boolean isSelected() {

        // Get the parent component.
        Container container = this.getParent();

        if (container == null) {
            return false;
        }
        // The component should be an instance of DiagramViewer.
        if (container instanceof DiagramViewer) {
            return ((DiagramViewer) container).isElementSelected(this);
        }
        return false;
    }
}
