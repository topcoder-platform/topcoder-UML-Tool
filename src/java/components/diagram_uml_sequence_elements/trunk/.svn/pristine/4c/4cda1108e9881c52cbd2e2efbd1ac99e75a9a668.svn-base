/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

import com.topcoder.diagraminterchange.GraphEdge;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.Util;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.NothingEdgeEnding;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import java.util.Collection;
import java.util.EnumMap;

import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 * <p>
 * The Lifeline class represent the lifeline of an object in sequence diagram.
 * </p>
 * <p>
 * This class extends the parent Edge class by configuration options. The main purpose of this class
 * is to draw graphical representation of the Lifeline.
 * </p>
 * <p>
 * The class processes mouse events, but does not react to most of them. They are passed to the
 * top-level classes. Only popup window showing is processed.
 * </p>
 *
 * <p>
 * This class needs configuration and here is a sample:
 * </p>
 *
 * <pre>
 * &lt;Property name=&quot;LifelineLength&quot;&gt;
 *      &lt;Value&gt;120&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineStrokeColor&quot;&gt;
 *      &lt;Value&gt;Color.GRAY&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineShadowColor&quot;&gt;
 *      &lt;Value&gt;Color.GRAY&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineRenderScheme&quot;&gt;
 *      &lt;Value&gt;0&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineDashLength&quot;&gt;
 *      &lt;Value&gt;5&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineBlankLength&quot;&gt;
 *      &lt;Value&gt;5&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;LifelineShadowLength;&gt;
 *      &lt;Value&gt;4&lt;/Value&gt;
 * &lt;/Property&gt;
 * </pre>
 *
 *
 * Thread safety: The class is mutable and not thread safe.
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 *
 * @since 1.1
 */
public class Lifeline extends Edge {
    /**
     * <p>
     * Represents the namespace in the configuration file to use for loading configuration values.
     * </p>
     */
    private static final String CONFIG_NAMESPACE = "com.topcoder.gui.diagramviewer."
            + "uml.sequenceelements.lifeline.lifeline";

    /**
     * <p>
     * Represents the default main color for foreground elements.
     * </p>
     * <p>
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default length of dash line part in pixels
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final int DEFAULT_DASH_LENGTH = 4;

    /**
     * <p>
     * Represents the default length of blank line part in pixels.
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final int DEFAULT_BLANK_LENGTH = 4;

    /**
     * <p>
     * Represents the default initial length of lifeline.
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final int DEFAULT_LIFELINE_LENGTH = 100;

    /**
     * <p>
     * Represents the default rendering scheme.
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final RenderScheme DEFAULT_RENDER_SCHEME = RenderScheme.TopCoderScheme;

    /**
     * <p>
     * Represents the default color of shadow.
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final Color DEFAULT_SHADOW_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default length of shadow.
     * </p>
     * <p>
     * The related instance variable may be set from this variable in the constructor.
     * </p>
     * <p>
     * This static variable is immutable.
     * </p>
     */
    private static final int DEFAULT_SHADOW_LENGTH = 5;

    /**
     * <p>
     * Represents the name of blankLength in the config file.
     * </p>
     */
    private static final String ID_BLANK_LENGTH = "LifelineBlankLength";

    /**
     * <p>
     * Represents the name of dashLength in the config file.
     * </p>
     */
    private static final String ID_DASH_LENGTH = "LifelineDashLength";

    /**
     * <p>
     * Represents the name of lifelineLength in the config file.
     * </p>
     */
    private static final String ID_LIFELINE_LENGTH = "LifelineLength";

    /**
     * <p>
     * Represents the name of renderScheme in the config file.
     * </p>
     */
    private static final String ID_RENDER_SCHEME = "LifelineRenderScheme";

    /**
     * <p>
     * Represents the name of shadowColor in the config file.
     * </p>
     */
    private static final String ID_SHADOW_COLOR = "LifelineShadowColor";

    /**
     * <p>
     * Represents the name of shadowLength in the config file.
     * </p>
     */
    private static final String ID_SHADOW_LENGTH = "LifelineShadowLength";

    /**
     * <p>
     * Represents the name of strokeColor in the config file.
     * </p>
     */
    private static final String ID_STROKE_COLOR = "LifelineStrokeColor";

    /**
     * <p>
     * Represents the length of the blank line part in pixels.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can be 0 or any positive value. Use related setter function to
     * mutate. The related getter function returns the current value of the variable.
     * </p>
     */
    private int blankLength;

    /**
     * <p>
     * Represents the length of the dash line part in pixels.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can be any positive value (not 0). Use related setter function
     * to mutate. The related getter function returns the current value of the variable.
     * </p>
     */
    private int dashLength;

    /**
     * <p>
     * Represents the main color for the foreground elements.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can not be null. Use related setter function to mutate. The
     * related getter function returns the current value of the variable.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Represents the length of the lifeline.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can be any positive value (not 0). Use related setter function
     * to mutate. The related getter function returns the current value of the variable.
     * </p>
     */
    private int lifelineLength;

    /**
     * <p>
     * Represents the rendering scheme.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can be any value. Use related setter function to mutate. The
     * related getter function returns the current value of the variable.
     * </p>
     */
    private RenderScheme renderScheme;

    /**
     * <p>
     * Represents the shadow color.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can not be null. Use related setter function to mutate. The
     * related getter function returns the current value of the variable.
     * </p>
     */
    private Color shadowColor;

    /**
     * <p>
     * Represents the Lifeline's shadow length in pixels.
     * </p>
     * <p>
     * The variable is set in the constructor.
     * </p>
     * <p>
     * This variable is mutable and can be 0 or any positive value. Use related setter function to
     * mutate. The related getter function returns the current value of the variable.
     * </p>
     */
    private int shadowLength;

    /**
     * <p>
     * Represents the Map of property names, used for getting values from the DiagramElement parent
     * object.
     * </p>
     * <p>
     * This variable is set in constructor, non-mutable and can not be null.
     * </p>
     * <p>
     * Use related setter function to mutate the elements of the Map. The related getter function
     * returns the value for the specified key from the Map.
     * </p>
     */
    private EnumMap<LifelinePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Represents the JPopupMenu related to this component.
     * </p>
     * <p>
     * This variable is mutable and can be null.
     * </p>
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value
     * of the variable.
     * </p>
     */
    private JPopupMenu popup = null;

    /**
     * <p>
     * Construct the class and set related class variables by using the arguments.
     * </p>
     *
     * <p>
     * The instance variables should be 1)loaded from property in graphEdge, 2)if not found in step
     * 1, loaded from ConfigManager 3)if not found in step 2, set to its correspondint DEFAULT value
     * </p>
     *
     * <p>
     * both left edge ending and right edge ending are NothingEdgeEnding; the line style is dash.
     * </p>
     *
     * @param graphEdge Instance of the GraphEdge class. Provides the information about the edge
     * size.
     * @param propertyNameMapping The predefined Map with information about property names
     * cofiguration. The properties are from DiagramElement parent class, value can't be null or
     * empty.
     *
     * @throws IllegalArgumentException if any argument is null, or if propertyNameMapping is
     * null/empty, or any value in map is null or empty.
     */
    public Lifeline(GraphEdge graphEdge, EnumMap<LifelinePropertyType, String> propertyNameMapping) {
        // call the parent constructor.Use default value to set the LineStyle.
        super(graphEdge, new LineStyle(DEFAULT_DASH_LENGTH, DEFAULT_BLANK_LENGTH),
                generateNothingEdgeEnding(propertyNameMapping), generateNothingEdgeEnding(propertyNameMapping));

        // check the arguments.Still check it although generateNothingEdgeEnding has checked
        Util.checkNull(propertyNameMapping, "propertyNameMapping");

        if (propertyNameMapping.isEmpty()) {
            throw new IllegalArgumentException("The propertyNameMapping should not be empty");
        }

        // check the entry value in the propertyNameMapping
        Collection<String> values = propertyNameMapping.values();

        for (String entryvalue : values) {
            Util.checkString(entryvalue, "entry value in propertyNameMapping");
        }

        // propertyNameMapping.
        // Set the propertyNameMapping variable
        this.propertyNameMapping = propertyNameMapping;

        // load the shadowColor ,from the graphEdge properties,or from the
        // config manager or from the default.
        this.shadowColor = Util.readColorProperty(graphEdge,
                propertyNameMapping.get(LifelinePropertyType.SHADOW_COLOR), CONFIG_NAMESPACE, ID_SHADOW_COLOR,
                DEFAULT_SHADOW_COLOR);

        // load the strokeColor ,from the graphEdge properties,or from the
        // config manager or from the default.
        this.strokeColor = Util.readColorProperty(graphEdge,
                propertyNameMapping.get(LifelinePropertyType.STROKE_COLOR), CONFIG_NAMESPACE, ID_STROKE_COLOR,
                DEFAULT_STROKE_COLOR);

        // load the blankLength ,from the graphEdge properties,or from the
        // config manager or from the default.
        this.blankLength = Util.readIntegerProperty(graphEdge, propertyNameMapping
                .get(LifelinePropertyType.BLANK_LENGTH), CONFIG_NAMESPACE, ID_BLANK_LENGTH, DEFAULT_BLANK_LENGTH);

        if (blankLength < 0) {
            blankLength = DEFAULT_BLANK_LENGTH;
        }

        // load the dashLength ,from the graphEdge properties,or from the config
        // manager or from the default.
        this.dashLength = Util.readIntegerProperty(graphEdge,
                propertyNameMapping.get(LifelinePropertyType.DASH_LENGTH), CONFIG_NAMESPACE, ID_DASH_LENGTH,
                DEFAULT_DASH_LENGTH);

        if (dashLength <= 0) {
            dashLength = DEFAULT_DASH_LENGTH;
        }

        // load the lifelineLength ,from the graphEdge properties,or from the
        // config manager or from the default.
        this.lifelineLength = Util.readIntegerProperty(graphEdge, propertyNameMapping
                .get(LifelinePropertyType.LIFELINE_LENGTH), CONFIG_NAMESPACE, ID_LIFELINE_LENGTH,
                DEFAULT_LIFELINE_LENGTH);

        if (lifelineLength <= 0) {
            lifelineLength = DEFAULT_LIFELINE_LENGTH;
        }

        // load the shadowlength ,from the graphEdge properties,or from the
        // config manager or from the default.
        this.shadowLength = Util.readIntegerProperty(graphEdge, propertyNameMapping
                .get(LifelinePropertyType.SHADOW_LENGTH), CONFIG_NAMESPACE, ID_SHADOW_LENGTH, DEFAULT_SHADOW_LENGTH);

        if (shadowLength < 0) {
            shadowLength = DEFAULT_SHADOW_LENGTH;
        }

        // load the renderScheme, from the graph node properties or config
        // manager or the default one
        int defaultSchemeValue = (DEFAULT_RENDER_SCHEME == RenderScheme.SimpleScheme) ? 0 : 1;
        this.renderScheme = Util.parseReaderSchemeProperty(graphEdge, propertyNameMapping
                .get(LifelinePropertyType.RENDER_SCHEME), CONFIG_NAMESPACE, ID_RENDER_SCHEME, defaultSchemeValue);
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The lenght of the dash part of the line in pixels.
     */
    public int getDashLength() {
        return this.dashLength;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param dashLength The lenght of the dash part of the line in pixels.
     *
     * @throws IllegalArgumentException if argument is 0 or negative.
     */
    public void setDashLength(int dashLength) {
        Util.checkInt_NegativeOrNil(dashLength, "dashLength");
        this.dashLength = dashLength;
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
     * @return The lenght of the blank part of the line in pixels.If zero then the line is
     * continuous, not dashed.
     */
    public int getBlankLength() {
        return this.blankLength;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param blankLength The lenght of the blank part of the line in pixels. If zero then the line
     * will be continuous, not dashed.
     *
     * @throws IllegalArgumentException if argument is negative
     */
    public void setBlankLength(int blankLength) {
        Util.checkInt_Negative(blankLength, "blankLength");
        this.blankLength = blankLength;
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
     * @return The value from RenderScheme enum.
     */
    public RenderScheme getRenderScheme() {
        return this.renderScheme;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param lifelineLength The length of the Lifeline in pixels.
     *
     * @throws IllegalArgumentException if argument is 0 or negative.
     */
    public void setLifelineLength(int lifelineLength) {
        Util.checkInt_NegativeOrNil(lifelineLength, "lifelineLength");
        this.lifelineLength = lifelineLength;
    }

    /**
     * <p>
     * The getter method for the related class variable.
     * </p>
     *
     * @return The length of the Lifeline in pixels.
     */
    public int getLifelineLength() {
        return this.lifelineLength;
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
     * The getter method for the related class variable.
     * </p>
     *
     * @return The length of the shadow in pixels.
     */
    public int getShadowLength() {
        return shadowLength;
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param shadowLength The length of the shadow in pixels.
     *
     * @throws IllegalArgumentException if shadowLength is negative.
     */
    public void setShadowLength(int shadowLength) {
        Util.checkInt_Negative(shadowLength, "shadowLength");
        this.shadowLength = shadowLength;
    }

    /**
     * <p>
     * The setter method for the propertyNameMapping element.
     * </p>
     * <p>
     * If there is no element for required key then a new element will insert to the
     * propertyNameMapping Map. In other case - the existed element value should be replaced with a
     * new value.
     * </p>
     *
     * @param key The key in the propertyNameMapping Map.
     * @param value The value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key is null or value argument is null/empty.
     */
    public void setPropertyNameMappingElement(LifelinePropertyType key, String value) {
        // Check the arguments.
        Util.checkNull(key, "key");
        Util.checkString(value, "value");

        // Insert or replace the key/value pair.
        propertyNameMapping.put(key, value);
    }

    /**
     * <p>
     * The getter method for the propertyNameMapping element.
     * </p>
     *
     * @param key The key in the propertyNameMapping Map.
     *
     * @return The element value from the propertyNameMapping for the required key.If the element is
     * absent - return null.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    public String getPropertyNameMappingElement(LifelinePropertyType key) {
        Util.checkNull(key, "key");

        String value = propertyNameMapping.get(key);

        return value;
    }

    /**
     * <p>
     * Get the bounding rectangle of the Edge.
     * </p>
     *
     * @return The bounds of the edge and its selection.
     */
    public Rectangle getBounds() {

        return super.getBounds();
    }

    /**
     * <p>
     * The setter method for the related class variable.
     * </p>
     *
     * @param popup The reference to the instance of the JPopupMenu implementation class.
     *
     * @throws IllegalArgumentException if argument null.
     */
    public void setPopup(JPopupMenu popup) {
        Util.checkNull(popup, "popup");

        this.popup = popup;
    }

    /**
     * <p>
     * The getter method for the related class variable. See the variable description for the
     * details.
     * </p>
     *
     * @return The reference to the instance of the JPopupMenu implementation class.
     */
    public JPopupMenu getPopup() {
        return popup;
    }

    /**
     * <p>
     * Check whether the point is inside the edge shape.
     * </p>
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     *
     * @return The flag, which says whether the point is inside the edge bounds.
     */
    public boolean contains(int x, int y) {

        return super.contains(x, y);
    }

    /**
     * <p>
     * Consume event when the diagram viewer is in the state of adding element.
     * </p>
     * <p>
     * If true is returned, it means that the event is consumed in the element. If false is
     * returned, it means that the event should be passed behind.
     * </p>
     * <p>
     * The right mouse button click is processed. It will show the popup (if it was registered on
     * this component).
     * </p>
     *
     * @param event The instance of the mouse event.
     *
     * @return Flag - whether the event was consumed in the component.
     *
     * @throws IllegalArgumentException if argument is null.
     */
    protected boolean consumeEvent(MouseEvent event) {

        Util.checkNull(event, "event");
        // variable indicates whether the event was consumed,initialized with false value.
        boolean consumed = false;

        Container container = this.getParent();
        if (container != null) {

            if (container instanceof DiagramViewer) {
                DiagramViewer viewer = (DiagramViewer) container;
                // Check the state of diagramviewer.
                DiagramState state = viewer.getState();
                if ((state == DiagramState.ADD_ELEMENT_BY_CLICK)
                        || (state == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE)) {
                    // set consumed to true first because the precondition holds
                    consumed = true;
                }
            }
        }

        // Process the rightclick mouse event only when consumed == true
        if (consumed && SwingUtilities.isRightMouseButton(event) && (event.getID() == MouseEvent.MOUSE_CLICKED)) {
            // right click will show the popup menu if any
            if (this.popup != null) {
                Point p = event.getPoint();
                SwingUtilities.convertPointToScreen(p, this);
                // Show this popup at the mouse place
                popup.setLocation(p.x, p.y);
                this.popup.setVisible(true);
            }
        } else {
            // set consumed back to false because the event is not consumed.
            consumed = false;
        }

        return consumed;
    }

    /**
     * <p>
     * Process the processMouseEvent.It can treat mouse event differently when diagram viewer is in
     * different state.
     * </p>
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
     * The drawing function for the Edge. It paints the edge differently for different RenderScheme.
     * </p>
     *
     * @param g The reference to the Graphics instance, which is used for edge drawing.
     *
     * @throws IllegalArgumentException if argument is null,or the renderScheme can not be recognized.
     */
    protected void paintComponent(Graphics g) {
        Util.checkNull(g, "g");

        super.paintComponent(g);

        // Get the linestyle of the lifeline,use it for line painting.
        LineStyle linestyle = this.getLineStyle();
        linestyle.setBlankLength(this.blankLength);
        linestyle.setDashLength(this.dashLength);

        // store the old color
        Color oldcolor = g.getColor();

        if (this.renderScheme == RenderScheme.TopCoderScheme) {
            // Draw the shadow of the line by using shadow color and shadow
            // length.
            Point left = new Point((int) getGraphEdge().getWaypoints().get(0)
                    .getX(), (int) getGraphEdge().getWaypoints().get(0).getY());
            Point right = new Point((int) getGraphEdge().getWaypoints().get(1)
                    .getX(), (int) getGraphEdge().getWaypoints().get(1).getY());

            left.x += this.shadowLength;
            left.y += this.shadowLength;
            right.x += this.shadowLength;
            right.y += this.shadowLength;

            g.setColor(this.shadowColor);
            linestyle.paint(g, left, right);
        }

        if (this.renderScheme == RenderScheme.SimpleScheme
                || this.renderScheme == RenderScheme.TopCoderScheme) {
            // Draw the dashed line from the leftEnding endpoint to the
            // rightEnding
            // endpoint by using the stroke color.
            Point left = new Point((int) getGraphEdge().getWaypoints().get(0)
                    .getX(), (int) getGraphEdge().getWaypoints().get(0).getY());
            Point right = new Point((int) getGraphEdge().getWaypoints().get(1)
                    .getX(), (int) getGraphEdge().getWaypoints().get(1).getY());
            g.setColor(this.strokeColor);
            linestyle.paint(g, left, right);

        } else {
            throw new IllegalArgumentException(
                    "The render scheme can not be recognized.");
        }


        g.setColor(oldcolor);
    }

    /**
     * <p>
     * Create a NothingEdgeEnding instance to pass it into the constructor of parent Lifeline class.
     * The propertyNameMapping of NothingEdgeEnding is copied from the its parent Lifeline's
     * propertyNameMapping.
     * </p>
     *
     * <p>
     * Note: This method is invoked before the constuctor doing any argument check since
     * it must be invoked in the first line of constructor.
     * </p>
     *
     * @param propertyNameMapping the parent Lifeline's propertyNameMapping.
     *
     * @return the created <code>NothingEdgeEnding</code> instance
     *
     * @throws IllegalArgumentException if propertyNameMapping is null.
     */
    private static NothingEdgeEnding generateNothingEdgeEnding(EnumMap<LifelinePropertyType, String>
                        propertyNameMapping) {

        //check whether propertyNameMapping is null to avoid NullPointException.
        Util.checkNull(propertyNameMapping, "propertyNameMapping");

        //create the EnumMap<ConfiguredEdgeEndingPropertyType,String> instance
        EnumMap<ConfiguredEdgeEndingPropertyType, String> endingPropertyNameMapping = new
                EnumMap<ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);

        //enumerate all the values of LifelinePropertyType to fill propertyNameMapping.
        ConfiguredEdgeEndingPropertyType[] configEdgeEnums = ConfiguredEdgeEndingPropertyType.values();
        for (int i = 0; i < configEdgeEnums.length; ++i) {
            try {
                // look up corresponding LifelinePropertyType.
                LifelinePropertyType key = LifelinePropertyType.valueOf(configEdgeEnums[i].name());

                String value = propertyNameMapping.get(key);
                // add the value without check,since null or empty value will cause
                // IllegalArgumentException
                // in the Lifeline's constructor later.
                endingPropertyNameMapping.put(configEdgeEnums[i], value);

            } catch (IllegalArgumentException e) {
                // it will get IllegalArgumentException if no corresponding LifelinePropertyType
                // is found.
            }
        }
        if (endingPropertyNameMapping.size() == 0) {
            // If after the look-up the propertyNameMapping is still empty,add an entry into the map
            // to make
            // sure it will not cause IllegalArgumentException.
            endingPropertyNameMapping.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "color");
        }

        //create the NothingEdgeEnding instance finally.
        NothingEdgeEnding ending = new NothingEdgeEnding(endingPropertyNameMapping);
        return ending;
    }
}
