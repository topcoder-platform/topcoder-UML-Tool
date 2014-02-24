/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.diagraminterchange.GraphConnector;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;

import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.Lifeline;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * <p>
 * The class is a concrete implementation of the <code>Node</code> abstract class.
 * </p>
 *
 * <p>
 * This class is the one and the only node for sequence diagrams.
 * </p>
 *
 * <p>
 * The main purpose of this class is to draw graphical representation of the node.
 * </p>
 *
 * <p>
 * Note, much functionality of event processing logic is reused from the parent class.
 * </p>
 *
 * <p>
 * This class needs configuration and here is a sample: &lt;Property name=&quot;NodeStrokeColor&quot;&gt;
 * &lt;Value&gt;Color.WHITE&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeFillColor&quot;&gt;
 * &lt;Value&gt;Color.BLACK&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeFillColor2&quot;&gt;
 * &lt;Value&gt;Color.BLACK&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeShadowColor&quot;&gt;
 * &lt;Value&gt;Color.BLACK&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeFontColor&quot;&gt;
 * &lt;Value&gt;Color.BLACK&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeFontFamily&quot;&gt;
 * &lt;Value&gt;Times&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeFontStyle&quot;&gt;
 * &lt;Value&gt;Font.ITALIC&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeFontSize&quot;&gt;
 * &lt;Value&gt;15&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeRenderScheme&quot;&gt;
 * &lt;Value&gt;1&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeWidth&quot;&gt;
 * &lt;Value&gt;150&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeHeight&quot;&gt;
 * &lt;Value&gt;140&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeWidthMinimum&quot;&gt;
 * &lt;Value&gt;100&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeHeightMinimum&quot;&gt;
 * &lt;Value&gt;100&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeShadowLength&quot;&gt;
 * &lt;Value&gt;15&lt;/Value&gt; &lt;/Property&gt; &lt;Property name=&quot;NodeRoundingRadius&quot;&gt;
 * &lt;Value&gt;25&lt;/Value&gt; &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Change for v1.1: Only the consumeEvent method is modified a little. Change for v1.1: Add method
 * notifyGraphNodeChange.
 * </p>
 *
 * <p>
 * Thread safety: The class is mutable and not thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @author gniuxiao, TCSDEVELOPER
 *
 * @version 1.1
 * @since 1.0
 */
public class ObjectNode extends Node {
    /**
     * <p>
     * Represents the minimum width of the component.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any value &gt;= 5.
     * </p>
     */
    public static final int MINIMUM_WIDTH = 100;

    /**
     * <p>
     * Represents the minimum height of the component.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any value &gt;= 5.
     * </p>
     */
    public static final int MINIMUM_HEIGHT = 100;

    /**
     * <p>
     * Represents the namespace in the configuration file to use for loading configuration values.
     * </p>
     *
     */
    private static final String CONFIG_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode";

    /**
     * <p>
     * Represents the default name used when the node name is empty.
     * </p>
     */
    private static final String DEFAULT_NAME = "anonymous";

    /**
     * <p>
     * Represents the default main color for foreground elements.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default main fill color.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FILL_COLOR = Color.WHITE;

    /**
     * <p>
     * Represents the default second fill color used for gradient filling.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FILL_COLOR2 = Color.WHITE;

    /**
     * <p>
     * Represents the default color of shadow.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_SHADOW_COLOR = Color.GRAY;

    /**
     * <p>
     * Represents the default color for font.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FONT_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default family of the font.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null or empty.
     * </p>
     */
    private static final String DEFAULT_FONT_FAMILY = "Default";

    /**
     * <p>
     * Represents the default style of the font (Font.PLAIN, Font.BOLD and so on).
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any value.
     * </p>
     */
    private static final int DEFAULT_FONT_STYLE = Font.PLAIN;

    /**
     * <p>
     * Represents the default size of the font in points.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any positive (not 0) value.
     * </p>
     */
    private static final int DEFAULT_FONT_SIZE = 10;

    /**
     * <p>
     * Represents the default width of the node.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any value &gt;= <code>MINIMUM_WIDTH</code>.
     * </p>
     */
    private static final int DEFAULT_WIDTH = 100;

    /**
     * <p>
     * Represents the default height of the component.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any value &gt;= <code>MINIMUM_HEIGHT</code>.
     * </p>
     */
    private static final int DEFAULT_HEIGHT = 100;

    /**
     * <p>
     * Represents the default radius for the node corners rounding.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be 0 or any positive value.
     * </p>
     */
    private static final int DEFAULT_ROUNDING_RADIUS = 15;

    /**
     * <p>
     * Represents the default length of the shadow.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be 0 or any positive value.
     * </p>
     */
    private static final int DEFAULT_SHADOW_LENGTH = 5;

    /**
     * <p>
     * Represents the default rendering scheme.
     * </p>
     *
     * <p>
     * The related instance variable is set from this variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is not mutable and can be any value.
     * </p>
     */
    private static final RenderScheme DEFAULT_RENDER_SCHEME = RenderScheme.TopCoderScheme;

    /**
     * <p>
     * Represents the instance of Object class.
     * </p>
     *
     * <p>
     * It is used as UML model element.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null. The value is set in the constructor.
     * </p>
     */
    private final Object object;

    /**
     * <p>
     * Represents the instance of GraphConnector class.
     * </p>
     *
     * <p>
     * The connector allows to store edges related for the node.
     * </p>
     *
     * <p>
     * This variable is not mutable and can not be null.
     * </p>
     *
     * <p>
     * The value is set in the constructor.
     * </p>
     */
    private final GraphConnector graphConnector;

    /**
     * <p>
     * Represents the visibility of the stereotype compartment.
     * </p>
     *
     * <p>
     * This variable is mutable and can be any value.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value of the
     * variable.
     * </p>
     */
    private boolean isStereotypesVisible = true;

    /**
     * <p>
     * Represents the visibility of the node name.
     * </p>
     *
     * <p>
     * This variable is mutable and can be any value.
     * </p>
     *
     * <p>
     * Use related setter function to mutate. The related getter function returns the current value of the
     * variable.
     * </p>
     */
    private boolean isNameVisible = true;

    /**
     * <p>
     * Represents the main color for the foreground elements.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private Color strokeColor;

    /**
     * <p>
     * Indicates whether the ObjectNode's constructor has been called or not.
     * </p>
     */
    private boolean constructed = false;

    /**
     * <p>
     * Represents the main fill color.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private Color fillColor;

    /**
     * <p>
     * Represents the second fill color used for gradient filling.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private Color fillColor2;

    /**
     * <p>
     * Represents the shadow color.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private Color shadowColor;

    /**
     * <p>
     * Represents the color of the font.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private Color fontColor;

    /**
     * <p>
     * Represents the family of the font.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can not be null or empty.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private String fontFamily;

    /**
     * <p>
     * Represents the style of the font (for example, Font.PLAIN).
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can be any value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private int fontStyle;

    /**
     * <p>
     * Represents the size of the font in points.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can be any positive value (not 0).
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private int fontSize;

    /**
     * <p>
     * Represents the radius of node corners rounding.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can be 0 and any positive value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private int roundingRadius;

    /**
     * <p>
     * Represents the length of shadow.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can be 0 and any positive value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private int shadowLength;

    /**
     * <p>
     * Represents the rendering scheme.
     * </p>
     *
     * <p>
     * The variable is set from the related "DEFAULT" variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can be any value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private RenderScheme renderScheme;

    /**
     * <p>
     * Represents the state whether the node name is edited now.
     * </p>
     *
     * <p>
     * If the name is edited now, then the name of node is not shown when painting.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private boolean isNameEditedNow = false;

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
     * Getter and Setter methods are provided.
     * </p>
     */
    private JPopupMenu popup;

    /**
     * <p>
     * Represents the Map of property names, used for getting values from the DiagramElement parent object.
     * </p>
     *
     * <p>
     * This variable is set in constructor, non-mutable and can not be null.
     * </p>
     *
     * <p>
     * The setter method can be used to mutate the elements of the Map. The getter method returns the value for the
     * specified key from the Map.
     * </p>
     */
    private final EnumMap<ObjectNodePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Represents the Connector related to this component.
     * </p>
     *
     * <p>
     * This variable is mutable and can be null.
     * </p>
     *
     * <p>
     * Getter methods are provided.
     * </p>
     */
    private Connector connector;

    /**
     * <p>
     * Represents whether the node name will display.
     * </p>
     */
    private boolean showName = true;

    /**
     * <p>
     * Represents whether the node type will display.
     * </p>
     */
    private boolean showType = true;

    /**
     * <p>
     * Represents the lifeline name display format. used by ObjectNode.Default is Zero.
     * </p>
     */
    private final static String LIFELINE_DISPLAY_FLAG = "LIFELINE_DISPLAY_FLAG";

    /**
     * <p>
     * Constructs the class and set related class variables by using the arguments.
     * </p>
     *
     * <p>
     * The instance variables will firstly load from the properties of the <code>graphNode</code>, if not found,
     * then load from the properties in the config manager, if not found, then the default value will be used.
     * </p>
     *
     * <p>
     * Change for v1.1: Use notifyGraphNodeChange method to initialize ObjectNode's properties.
     * </p>
     *
     * @param object
     *            Reference to the Object instance. It is a child of the ModelElement.
     * @param graphConnector
     *            Reference to the instance of GraphConnector class.
     * @param graphNode
     *            Reference to the instance of GraphNode class.
     * @param position
     *            The position of the node - instance of Point class.
     * @param bound
     *            The bound of selection corners.
     * @param corners
     *            The set of selection corners types.
     * @param propertyNameMapping
     *            The predefined Map with information about property names configuration. The properties are from
     *            DiagramElement parent class.
     *
     * @throws IllegalArgumentException
     *             if any argument is null, or if propertyNameMapping is empty
     *
     * @since 1.0
     */
    public ObjectNode(Object object, GraphConnector graphConnector, GraphNode graphNode, Point position,
        Rectangle bound, Collection<SelectionCornerType> corners,
        EnumMap<ObjectNodePropertyType, String> propertyNameMapping) {
        super(graphNode, position, bound, corners);
        Util.checkNull(object, "object");
        Util.checkNull(graphConnector, "graphConnector");
        Util.checkNull(propertyNameMapping, "propertyNameMapping");
        if (propertyNameMapping.isEmpty()) {
            throw new IllegalArgumentException("The given propertyNameMapping is empty.");
        }

        this.object = object;
        this.graphConnector = graphConnector;
        this.propertyNameMapping = propertyNameMapping;

        // Notify the ObjectNode instance is created
        this.notifyGraphNodeChange("The ObjectNode is created.");
        constructed = true;
        int flag = getDisplayFlag();
        if ((flag & 1) > 0) {
            showName = false;
        } else {
            showName = true;
        }

        if ((flag & 2) > 0) {
            showType = false;
        } else {
            showType = true;
        }

    }

    /**
     * <p>
     * Sets the name of this object node.
     * </p>
     *
     * @param name
     *            The name of node.
     *
     * @throws IllegalArgumentException
     *             if name is null
     */
    public void setName(String name) {
        Util.checkNull(name, "name");

        object.setName(name);
    }

    /**
     * <p>
     * Gets the name of the object node.
     * </p>
     *
     * @return The name of node.
     */
    public String getName() {
        return object.getName();
    }

    /**
     * <p>
     * Gets the <code>Object</code> model element in this object node.
     * </p>
     *
     * @return the <code>Object</code> model element in this object node.
     */
    public Object getObject() {
        return this.object;
    }

    /**
     * <p>
     * Sets the visibility of the Stereotypes compartment.
     * </p>
     *
     * @param isVisible
     *            Stereotypes compartment visibility.
     */
    public void setIsStereotypesVisible(boolean isVisible) {
        this.isStereotypesVisible = isVisible;

        ResizeEvent event = new ResizeEvent(this, "Stereotypes visibility changed");
        fireResize(event);
    }

    /**
     * <p>
     * Gets the visibility of the Stereotypes compartment.
     * </p>
     *
     * @return Stereotypes compartment visibility.
     */
    public boolean getIsStereotypesVisible() {
        return this.isStereotypesVisible;
    }

    /**
     * <p>
     * Sets the visibility of node name.
     * </p>
     *
     * @param isVisible
     *            The visibility of node name.
     */
    public void setIsNameVisible(boolean isVisible) {
        this.isNameVisible = isVisible;

        ResizeEvent event = new ResizeEvent(this, "Node name visibility changed");
        fireResize(event);
    }

    /**
     * <p>
     * Gets the visibility of node name.
     * </p>
     *
     * @return The visibility of node name.
     */
    public boolean getIsNameVisible() {
        return this.isNameVisible;
    }

    /**
     * <p>
     * Gets the graph connector in this object node.
     * </p>
     *
     * @return The reference to the GraphConnector instance.
     */
    public GraphConnector getGraphConnector() {
        return this.graphConnector;
    }

    // /**
    // * <p>
    // * Sets the size of this object node.
    // * </p>
    // *
    // * @param size The new size of the node.
    // *
    // * @throws IllegalArgumentException if size is null
    // */
    // public void setSize(Dimension size) {
    // Util.checkNull(size, "size");
    //
    // com.topcoder.diagraminterchange.Dimension nodeSize = new com.topcoder.diagraminterchange.Dimension();
    // nodeSize.setWidth(size.getWidth());
    // nodeSize.setHeight(size.getHeight());
    //
    // this.getGraphNode().setSize(nodeSize);
    // }
    //
    // /**
    // * <p>
    // * Gets the size of this object node.
    // * </p>
    // *
    // * @return The size of the node.
    // */
    // public Dimension getSize() {
    // com.topcoder.diagraminterchange.Dimension nodeSize = this.getGraphNode().getSize();
    //
    // return new Dimension((int) nodeSize.getWidth(), (int) nodeSize.getHeight());
    // }

    /**
     * <p>
     * Sets the position of this object node.
     * </p>
     *
     * @param position
     *            The location of the node.
     *
     * @throws IllegalArgumentException
     *             if position is null
     */
    public void setPosition(Point position) {
        Util.checkNull(position, "position");

        setRelativePosition(position);
    }

    /**
     * <p>
     * Gets the position of this object node.
     * </p>
     *
     * @return The location of the node.
     */
    public Point getPosition() {
        return super.getRelativePosition();
    }

    /**
     * <p>
     * Calculates and returns the preferred size of the node.
     * </p>
     *
     * @param name
     *            The name for the node.
     * @param isNameVisible
     *            Node name visibility.
     * @param isStereotypesVisible
     *            Stereotypes compartments visibility.
     * @return The new preferred size of the node.
     */
    public Dimension getPreferredSize(String name, boolean isNameVisible, boolean isStereotypesVisible) {
        if (name == null || name.trim().length() == 0) {
            name = DEFAULT_NAME;
        }

        /*
         * BUGR-72 Lifeline type display
         */
        if (object != null && object.getClassifier() != null && object.getClassifier().getName() != null) {
            String type = object.getClassifier().getName();
            // name += ":" + type;
            if (showName) {
                if (showType)
                    name += ":" + type;

            } else {
                if (showType)
                    name = type;
                else
                    name = "";
            }
        }

        Font font = new Font(this.fontFamily, this.fontStyle, this.fontSize);
        FontMetrics fm = getFontMetrics(font);

        int width = 0;
        int height = 0;
        String lcOSName = System.getProperty("os.name").toLowerCase();
        boolean MAC_OS_X = lcOSName.startsWith("mac os x");

        if (isNameVisible) {
            // calculate the size of the object name
            // note, some extra pixels are added
            if (MAC_OS_X) {
                width += (int) (SwingUtilities.computeStringWidth(fm, name) * 1.08) + 10;
            } else {
                width += SwingUtilities.computeStringWidth(fm, name) + 10;
            }
            height += fm.getHeight();
        }

        if (isStereotypesVisible) {
            // calculate the height and width of stereotypes
            for (Stereotype stereotype : object.getStereotypes()) {
                String value = stereotype.getName();
                if (value != null) {
                    height += fm.getHeight();
                    // note, some extra pixels are added
                    int stereotypeWidth = 0;
                    if (MAC_OS_X) {
                        stereotypeWidth = (int) (SwingUtilities.computeStringWidth(fm, value) * 1.2) + 10;
                    } else {
                        stereotypeWidth = SwingUtilities.computeStringWidth(fm, value) + 10;
                    }
                    if (stereotypeWidth > width) {
                        width = stereotypeWidth;
                    }
                }
            }
        }

        // check the minimum size
        Dimension minimumSize = getMinimumSize();
        if (minimumSize.width > width) {
            width = minimumSize.width;
        }
        if (minimumSize.height > height) {
            height = minimumSize.height;
        }

        Dimension size = new Dimension(width, height);

        // update the selection bound for this object node
        Rectangle selectionBound = getSelectionBound();
        selectionBound.setSize(size);
        setSelectionBound(selectionBound);

        Component[] components = this.getComponents();
        for (Component component : components) {
            if (component instanceof Lifeline) {
                Lifeline lifeline = (Lifeline) component;
                int lifelineLength = (int) lifeline.getGraphEdge().getWaypoints().get(1).getY();
                if (height < lifelineLength) {
                    height = lifelineLength;
                }
            }
        }
        size.height = height;

        return size;
    }

    /**
     * <p>
     * Sets the stroke color of this object node.
     * </p>
     *
     * @param strokeColor
     *            The stroke color.
     *
     * @throws IllegalArgumentException
     *             if strokeColor is null
     */
    public void setStrokeColor(Color strokeColor) {
        Util.checkNull(strokeColor, "strokeColor");

        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * Gets the stroke color of this object node.
     * </p>
     *
     * @return The stroke color.
     */
    public Color getStrokeColor() {
        return this.strokeColor;
    }

    /**
     * <p>
     * Sets the fill color of this object node.
     * </p>
     *
     * @param fillColor
     *            The color to fill.
     *
     * @throws IllegalArgumentException
     *             if fillColor is null
     */
    public void setFillColor(Color fillColor) {
        Util.checkNull(fillColor, "fillColor");

        this.fillColor = fillColor;
    }

    /**
     * <p>
     * Gets the fill color of this object node.
     * </p>
     *
     * @return The color to fill.
     */
    public Color getFillColor() {
        return this.fillColor;
    }

    /**
     * <p>
     * Sets the second color for gradient filling.
     * </p>
     *
     * @param fillColor2
     *            The second color for gradient filling.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public void setFillColor2(Color fillColor2) {
        Util.checkNull(fillColor2, "fillColor2");

        this.fillColor2 = fillColor2;
    }

    /**
     * <p>
     * Gets the second color for gradient filling.
     * </p>
     *
     * @return The second color for gradient filling.
     */
    public Color getFillColor2() {
        return this.fillColor2;
    }

    /**
     * <p>
     * Sets the shadow color of this object node.
     * </p>
     *
     * @param shadowColor
     *            The color of shadow.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public void setShadowColor(Color shadowColor) {
        Util.checkNull(shadowColor, "shadowColor");

        this.shadowColor = shadowColor;
    }

    /**
     * <p>
     * Gets the shadow color of this object node.
     * </p>
     *
     * @return The color of shadow.
     */
    public Color getShadowColor() {
        return this.shadowColor;
    }

    /**
     * <p>
     * Sets the font color of this object node.
     * </p>
     *
     * @param fontColor
     *            The color of font.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public void setFontColor(Color fontColor) {
        Util.checkNull(fontColor, "fontColor");

        this.fontColor = fontColor;
    }

    /**
     * <p>
     * Gets the font color of this object node.
     * </p>
     *
     * @return The color of font.
     */
    public Color getFontColor() {
        return this.fontColor;
    }

    /**
     * <p>
     * Sets the font family name of this object node.
     * </p>
     *
     * @param fontFamily
     *            The font family string.
     *
     * @throws IllegalArgumentException
     *             if argument is null or empty
     */
    public void setFontFamily(String fontFamily) {
        Util.checkString(fontFamily, "fontFamily");

        this.fontFamily = fontFamily;
    }

    /**
     * <p>
     * Gets the font family name of this object node.
     * </p>
     *
     * @return The font family string.
     */
    public String getFontFamily() {
        return this.fontFamily;
    }

    /**
     * <p>
     * Sets the font style of this object node.
     * </p>
     *
     * @param fontStyle
     *            The style of the font.
     */
    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    /**
     * <p>
     * Gets the font style of this object node.
     * </p>
     *
     * @return The style of the font.
     */
    public int getFontStyle() {
        return this.fontStyle;
    }

    /**
     * <p>
     * Sets the font size of the object node.
     * </p>
     *
     * @param fontSize
     *            The font size in points.
     *
     * @throws IllegalArgumentException
     *             if argument is 0 or negative
     */
    public void setFontSize(int fontSize) {
        if (fontSize <= 0) {
            throw new IllegalArgumentException("The given font size [" + fontSize + "] is not positive.");
        }

        this.fontSize = fontSize;
    }

    /**
     * <p>
     * Gets the font size of the object node.
     * </p>
     *
     * @return The font size in points.
     */
    public int getFontSize() {
        return this.fontSize;
    }

    /**
     * <p>
     * Sets the rounding radius of this object node.
     * </p>
     *
     * @param radius
     *            The radius of corners rounding.
     *
     * @throws IllegalArgumentException
     *             if argument is negative
     */
    public void setRoundingRadius(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("The radius [ " + radius + "] is negative");
        }

        this.roundingRadius = radius;
    }

    /**
     * <p>
     * Gets the rounding radius of this object node.
     * </p>
     *
     * @return The radius of corners rounding.
     */
    public int getRoundingRadius() {
        return this.roundingRadius;
    }

    /**
     * <p>
     * Sets the shadow length of this object node.
     * </p>
     *
     * @param shadowLength
     *            The length of shadow.
     *
     * @throws IllegalArgumentException
     *             if argument is negative
     */
    public void setShadowLength(int shadowLength) {
        if (shadowLength < 0) {
            throw new IllegalArgumentException("The shadow length [ " + shadowLength + "] is negative");
        }

        this.shadowLength = shadowLength;
    }

    /**
     * <p>
     * Gets the shadow length of this object node.
     * </p>
     *
     * @return The length of shadow.
     */
    public int getShadowLength() {
        return this.shadowLength;
    }

    /**
     * <p>
     * Sets the render scheme of this object node.
     * </p>
     *
     * @param renderScheme
     *            The value from RenderScheme enum.
     *
     * @throws IllegalArgumentException
     *             if renderScheme is null
     */
    public void setRenderScheme(RenderScheme renderScheme) {
        Util.checkNull(renderScheme, "renderScheme");

        this.renderScheme = renderScheme;
    }

    /**
     * <p>
     * Gets the render scheme of this object node.
     * </p>
     *
     * @return The value from RenderScheme enum.
     */
    public RenderScheme getRenderScheme() {
        return this.renderScheme;
    }

    /**
     * <p>
     * Consumes event when the diagram viewer is in the state of adding element.
     * </p>
     *
     * <p>
     * If true is returned, it means that the event is consumed in the element. If false is returned, it means that
     * the event should be passed behind.
     * </p>
     *
     * <p>
     * Note, how to implement this information will be defined when the DiagramViewer design will be implemented.
     * </p>
     *
     * <p>
     * Change for v1.1: Since there's no addEditControlListener method in DiagramViewer, the step to register the
     * listener is removed in order to compile the class.
     * </p>
     *
     * @param event
     *            The instance of the mouse event.
     * @return Flag whether the event was consumed in the component.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     *
     * @since v1.0
     */
    protected boolean consumeEvent(MouseEvent event) {
        Util.checkNull(event, "event");

        return false;
    }

    /**
     * <p>
     * Processes the mouse event.
     * </p>
     *
     * <p>
     * This is simply delegated to the corresponding method in the super class <code>Node</code>.
     * </p>
     *
     * @param e
     *            The instance of the MouseEvent.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    protected void processMouseEvent(MouseEvent e) {
        Util.checkNull(e, "e");

        if (SwingUtilities.isLeftMouseButton(e) && e.getID() == MouseEvent.MOUSE_CLICKED && e.getClickCount() == 2) {
            // double click will sent out the edit name events
            EditNameEvent editNameEvent = new EditNameEvent(e.getPoint(), getName(), this);
            TextInputListener listener = new TextInputListener(this);
            DiagramViewer viewer = getDiagramViewer();
            if (viewer != null) {
                // this listener will be removed when the edit name event is
                // finished
                viewer.getTextInputBox().addTextInputListener(listener);
            }

            this.isNameEditedNow = true;
            fireEditName(editNameEvent);
            return;
        } else if (SwingUtilities.isRightMouseButton(e)) {
            // right click will show the popup menu if any
            if (this.popup != null) {
                this.popup.setVisible(true);
            }
            return;
        }

        super.processMouseEvent(e);
    }

    /**
     * <p>
     * Adds a <code>EditNameListener</code> to the <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            The reference to the <code>EditNameListener</code> instance.
     */
    public void addEditNameListener(EditNameListener listener) {
        listenerList.add(EditNameListener.class, listener);
    }

    /**
     * <p>
     * Adds <code>SetNameListener</code> to the <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            The reference to the SetNameListener instance.
     */
    public void addSetNameListener(SetNameListener listener) {
        listenerList.add(SetNameListener.class, listener);
    }

    /**
     * <p>
     * Adds <code>ResizeListener</code> to the <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            The reference to the ResizeListener instance.
     */
    public void addResizeListener(ResizeListener listener) {
        listenerList.add(ResizeListener.class, listener);
    }

    /**
     * <p>
     * Notifies all listeners registered interest for starting edit name event.
     * </p>
     *
     * @param event
     *            The instance of the EditNameEvent class.
     */
    protected void fireEditName(EditNameEvent event) {
        if (event != null) {
            for (EditNameListener listener : listenerList.getListeners(EditNameListener.class)) {
                listener.nameEditStarted(event);
            }
        }
    }

    /**
     * <p>
     * Notifies all listeners registered interest for name prepared event.
     * </p>
     *
     * @param event
     *            The instance of the SetNameEvent class.
     */
    protected void fireSetName(SetNameEvent event) {
        if (event != null) {
            for (SetNameListener listener : listenerList.getListeners(SetNameListener.class)) {
                listener.namePrepared(event);
            }
        }
    }

    /**
     * <p>
     * Notifies all listeners registered interest for resize event.
     * </p>
     *
     * @param event
     *            The instance of the ResizeEvent class.
     */
    protected void fireResize(ResizeEvent event) {
        if (event != null) {
            for (ResizeListener listener : listenerList.getListeners(ResizeListener.class)) {
                listener.resizeNeeded(event);
            }
        }
    }

    /**
     * <p>
     * Removes an <code>EditNameListener</code> from <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            The reference to the EditNameListener instance.
     */
    public void removeEditNameListener(EditNameListener listener) {
        listenerList.remove(EditNameListener.class, listener);
    }

    /**
     * <p>
     * Removes an <code>SetNameListener</code> from <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            The reference to the SetNameListener instance.
     */
    public void removeSetNameListener(SetNameListener listener) {
        listenerList.remove(SetNameListener.class, listener);
    }

    /**
     * <p>
     * Removes an <code>ResizeListener</code> from <code>listenerList</code>.
     * </p>
     *
     * @param listener
     *            The reference to the ResizeListener instance.
     */
    public void removeResizeListener(ResizeListener listener) {
        listenerList.remove(ResizeListener.class, listener);
    }

    /**
     * <p>
     * Sets the pop up menu for this object node.
     * </p>
     *
     * @param popup
     *            The reference to the instance of the JPopupMenu implementation class.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public void setPopup(JPopupMenu popup) {
        Util.checkNull(popup, "popup");

        this.popup = popup;
    }

    /**
     * <p>
     * Gets the pop up menu for this object node.
     * </p>
     *
     * @return The reference to the instance of the JPopupMenu implementation class.
     */
    public JPopupMenu getPopup() {
        return popup;
    }

    /**
     * <p>
     * The entry point for changing the name of the node.
     * </p>
     *
     * @param oldName
     *            The old name of the node.
     * @param newName
     *            The new name of the node.
     *
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public void applyNewName(String oldName, String newName) {
        SetNameEvent nameEvent = new SetNameEvent(oldName, newName, this);
        fireSetName(nameEvent);

        this.setName(newName);

        ResizeEvent sizeEvent = new ResizeEvent(this, "Name was changed.");
        fireResize(sizeEvent);

        this.repaint();
    }

    /**
     * <p>
     * The drawing function for the node.
     * </p>
     *
     * <p>
     * It paints the node differently for different <code>RenderScheme</code>.
     * </p>
     *
     * @param g
     *            The reference to the Graphics instance, which is used for node drawing.
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    protected void paintComponent(Graphics g) {
        Util.checkNull(g, "g");

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // back up the old color and restore it to the Graphics after the painting is finished
        // this is required by swing component
        Color oldColor = g2.getColor();

        String name = getName();
        if (name == null || name.trim().length() == 0) {
            name = DEFAULT_NAME;
        }

        /*
         * BUGR-72 Lifeline type display
         */
        if (object != null && object.getClassifier() != null && object.getClassifier().getName() != null) {
            String type = object.getClassifier().getName();
            if (showName) {
                if (showType)
                    name += ":" + type;

            } else {
                if (showType)
                    name = type;
                else
                    name = "";
            }
        }

        Rectangle bound = getSelectionBound();

        switch (this.renderScheme) {
        case SimpleScheme: {

            // simple scheme drawing
            g2.setColor(fillColor);
            g2.fillRect(bound.x, bound.y, bound.width, bound.height);
            g2.setColor(strokeColor);
            g2.drawRect(bound.x, bound.y, bound.width, bound.height);

            break;
        }
        case TopCoderScheme: {
            // topcoder scheme drawing

            g2.setColor(shadowColor);
            g2.fillRoundRect(this.shadowLength + bound.x, this.shadowLength + bound.y, bound.width, bound.height,
                roundingRadius, roundingRadius);

            // backup the old Paint instance
            Paint paint = g2.getPaint();

            // fill with a gradient.
            GradientPaint gp =
                new GradientPaint(bound.x, bound.y, fillColor, bound.x + bound.width, bound.y + bound.height,
                    fillColor2, true);
            g2.setPaint(gp);
            g2.fillRoundRect(bound.x, bound.y, bound.width, bound.height, roundingRadius, roundingRadius);

            g2.setColor(strokeColor);
            g2.drawRoundRect(bound.x, bound.y, bound.width, bound.height, roundingRadius, roundingRadius);

            // restore the old Paint instance
            g2.setPaint(paint);

            break;
        }
        default: {
            return;
        }
        }

        if (!isNameEditedNow) {
            // back up the font
            Font oldFont = g2.getFont();

            Font font = new Font(this.fontFamily, this.fontStyle, this.fontSize);
            g2.setFont(font);
            g2.setColor(this.fontColor);

            FontMetrics fm = g2.getFontMetrics();

            // calculate the size of the string to draw
            String lcOSName = System.getProperty("os.name").toLowerCase();
            boolean MAC_OS_X = lcOSName.startsWith("mac os x");
            int width = 0;
            if (MAC_OS_X) {
                width = (int) (SwingUtilities.computeStringWidth(fm, name) * 1.08);
            } else {
                width = SwingUtilities.computeStringWidth(fm, name);
            }
            int height = fm.getAscent();

            int x = (width < bound.width) ? (bound.width - width) / 2 + bound.x : bound.x;
            int y = (height < bound.height) ? (bound.height - height) / 2 + bound.y : bound.y;
            g2.drawString(name, x, y);

            // restore the old font and old color
            g2.setFont(oldFont);
        }

        g2.setColor(oldColor);
    }

    /**
     * <p>
     * This method overrides the contains method for defining custom shape.
     * </p>
     *
     * <p>
     * Note, this method is invoked by the Swing system, in order to make sure the child components will receive
     * the mouse event, the contains method of child components are invoked and the point is transformed before
     * passing to child component.
     * </p>
     *
     * @param x
     *            the x-coordinate value
     * @param y
     *            the y-coordinate value
     *
     * @return true if the given point is inside this rectangle node, false otherwise
     */
    public boolean contains(int x, int y) {
        Rectangle bound = getSelectionBound();
        switch (this.renderScheme) {
        case SimpleScheme: {
            if (x >= bound.x && x <= bound.width + bound.x && y >= bound.y && y <= bound.height + bound.y) {
                return true;
            }
            break;
        }
        case TopCoderScheme: {
            RoundRectangle2D roundBound =
                new RoundRectangle2D.Float(bound.x, bound.y, bound.width, bound.height, this.roundingRadius,
                    this.roundingRadius);

            if (roundBound.contains(x, y)) {
                return true;
            }
        }
        default: {
            break;
        }
        }

        // check the child components
        for (int i = 0; i < getComponentCount(); i++) {
            Component c = getComponent(i);
            Point pt = SwingUtilities.convertPoint(this, x, y, c);
            if (c.contains(pt.x, pt.y)) {
                return true;
            }
        }

        return false;
    }

    // /**
    // * <p>
    // * Returns the bounding rectangle of the node.
    // * </p>
    // *
    // * @return The bounds of the node and its selection.
    // */
    // public Rectangle getBounds() {
    // return getSelectionBound();
    // }

    /**
     * <p>
     * The setter method for the <code>propertyNameMapping</code> element.
     * </p>
     *
     * <p>
     * If there is no element for required key then a new element will insert to the
     * <code>propertyNameMapping</code> Map. The existed element value will be replaced with the given new value.
     * </p>
     *
     * @param key
     *            They key in the propertyNameMapping Map.
     * @param value
     *            They value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException
     *             if key is null or value argument is null/empty.
     */
    public void setPropertyNameMappingElement(ObjectNodePropertyType key, String value) {
        Util.checkNull(key, "key");
        Util.checkString(value, "value");

        this.propertyNameMapping.put(key, value);
    }

    /**
     * <p>
     * The getter method for the <code>propertyNameMapping</code> element.
     * </p>
     *
     * <p>
     * This method returns the element value from the <code>propertyNameMapping</code> for the required key.
     * </p>
     *
     * <p>
     * If the element is absent, it will return null.
     * </p>
     *
     * @param key
     *            They key in the propertyNameMapping Map.
     * @return They value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException
     *             if key is null
     */
    public String getPropertyNameMappingElement(ObjectNodePropertyType key) {
        Util.checkNull(key, "key");

        return this.propertyNameMapping.get(key);
    }

    /**
     * <p>
     * Gets the flag that whether the name of the object node is edited now or not.
     * </p>
     *
     * @return the flag that whether the name of the object node is edited now or not.
     */
    public boolean isNameEditedNow() {
        return isNameEditedNow;
    }

    /**
     * <p>
     * Sets the flag that whether the name of the object node is edited now or not to the given value.
     * </p>
     *
     * @param isNameEditedNow
     *            the new flag to set
     */
    public void setNameEditedNow(boolean isNameEditedNow) {
        this.isNameEditedNow = isNameEditedNow;
    }

    /**
     * Enhancements: UML 9625 Description: Like other components such as Diagram Use Case Elements, Diagram Class
     * Elements, Diagram Activity Elements, this method will be used to retrieve diagram interchange information
     * from contained graphNode, and update the ObjectNode.
     */
    /**
     * <p>
     * Reloads diagram interchange information from contained graphNode.
     * </p>
     *
     * @param message
     *            telling how graphNode is changed (could be null)
     *
     * @since 1.1
     */
    public void notifyGraphNodeChange(String message) {
        // update the ObjectNode's size and properties.
        if (!constructed) {
            // this method is called by the constructor, so perform initialization
            // on the ObjectNode and its properties.
            updateProperties(CONFIG_NAMESPACE, true);
        } else {
            // perform update on the ObjectNode and its properties
            updateProperties("", false);
        }

        // Set the calculated size to the graph node to keep consistency.
        GraphNode graphNode = getGraphNode();
        Dimension preferredSize = getPreferredSize(getName(), getIsNameVisible(), getIsStereotypesVisible());
        com.topcoder.diagraminterchange.Dimension graphNodeSize = graphNode.getSize();

        graphNodeSize.setWidth(preferredSize.width);
        graphNodeSize.setHeight(preferredSize.height);
        graphNode.setSize(graphNodeSize);

        int cornerRadius = this.getSelectionCorners().iterator().next().getRadius();
        this.setLocation((int) graphNode.getPosition().getX() - cornerRadius, (int) graphNode.getPosition().getY()
            - cornerRadius);
        this.setSize((int) graphNodeSize.getWidth() + cornerRadius * 2, (int) graphNodeSize.getHeight()
            + cornerRadius * 2);

        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof Lifeline) {
                Lifeline lifeline = (Lifeline) component;
                lifeline.getGraphEdge().getWaypoints().get(0).setX(getWidth() / 2);
                lifeline.getGraphEdge().getWaypoints().get(1).setX(getWidth() / 2);
                lifeline.setStrokeColor(this.strokeColor);
                lifeline.setShadowColor(this.shadowColor);
            } else if (component instanceof LifelineSegment) {
                LifelineSegment lifelineSegment = (LifelineSegment) component;
                lifelineSegment.setLocation(getWidth() / 2 - (int) lifelineSegment.getSelectionBound().getWidth()
                    / 2, lifelineSegment.getY());
                lifelineSegment.setStrokeColor(this.strokeColor);
                lifelineSegment.setShadowColor(this.shadowColor);
                lifelineSegment.setFillColor(this.fillColor);
            }
        }
    }

    /**
     * <p>
     * Update the ObjectNode's properties with the GraphNode's properties.
     * </p>
     *
     * <p>
     * The params namespace and flag should only have the two following combination: 1)namespace is valid and flag
     * is true. 2)namespace is empty and flag is false.
     * </p>
     *
     * <p>
     * if namespace is valid and flag is true: this method will actually load the instance variables from the
     * properties of the graphNode, if not found, then load from the properties in the config manager, if not
     * found, then the default value will be used.
     * </p>
     *
     * <p>
     * If namespace is empty and flag is false: this method will update the ObjectNode's properties from
     * GraphNode's properties.If not found in the GraphNode, then the objectNode's properties will not be changed.
     * </p>
     *
     *
     * @param namespace
     *            The namespace of the Config Manager, can be null.
     * @param flag
     *            indicates whether use the default value or stay the same when it can not find correponding
     *            properties.
     *
     * @since 1.1
     */
    private void updateProperties(String namespace, boolean flag) {

        GraphNode graphNode = this.getGraphNode();

        // load the stroke color, from the graph node properties or config manager or the default one
        this.strokeColor =
            Util.readColorProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.STROKE_COLOR),
                namespace, "NodeStrokeColor", flag ? DEFAULT_STROKE_COLOR : strokeColor);

        // load the fill color, from the graph node properties or config manager or the default one
        this.fillColor =
            Util.readColorProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.FILL_COLOR),
                namespace, "NodeFillColor", flag ? DEFAULT_FILL_COLOR : fillColor);

        // load the fill color 2, from the graph node properties or config manager or the default one
        this.fillColor2 =
            Util.readColorProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.FILL_COLOR2),
                namespace, "NodeFillColor2", flag ? DEFAULT_FILL_COLOR2 : fillColor2);

        // load the font color, from the graph node properties or config manager or the default one
        this.fontColor =
            Util.readColorProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.FONT_COLOR),
                namespace, "NodeFontColor", flag ? DEFAULT_FONT_COLOR : fontColor);

        // load the shadow color, from the graph node properties or config manager or the default one
        this.shadowColor =
            Util.readColorProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.SHADOW_COLOR),
                namespace, "NodeShadowColor", flag ? DEFAULT_SHADOW_COLOR : shadowColor);

        // load the shadow length, from the graph node properties or config manager or the default one
        this.shadowLength =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.SHADOW_LENGTH),
                namespace, "NodeShadowLength", flag ? DEFAULT_SHADOW_LENGTH : shadowLength);
        if (this.shadowLength < 0) {
            this.shadowLength = flag ? DEFAULT_SHADOW_LENGTH : shadowLength;
        }

        // load the font family, from the graph node properties or config manager or the default one
        this.fontFamily =
            Util.readStringProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.FONT_FAMILY),
                namespace, "NodeFontFamily", flag ? DEFAULT_FONT_FAMILY : fontFamily);

        // load the font size, from the graph node properties or config manager or the default one
        this.fontSize =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.FONT_SIZE),
                namespace, "NodeFontSize", flag ? DEFAULT_FONT_SIZE : fontSize);
        if (fontSize <= 0) {
            this.fontSize = flag ? DEFAULT_FONT_SIZE : fontSize;
        }

        // load the font style, from the graph node properties or config manager or the default one
        this.fontStyle =
            Util.parseFontStyleProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.FONT_STYLE),
                namespace, "NodeFontStyle", flag ? DEFAULT_FONT_STYLE : fontStyle);

        // load the render scheme, from the graph node properties or config manager or the default one
        int defaultSchemeValue = (DEFAULT_RENDER_SCHEME == RenderScheme.SimpleScheme) ? 0 : 1;
        int oldSchemeValue = defaultSchemeValue;
        if (renderScheme != null) {
            if (renderScheme == RenderScheme.SimpleScheme) {
                oldSchemeValue = 0;
            } else {
                oldSchemeValue = 1;
            }
        }
        this.renderScheme =
            Util.parseReaderSchemeProperty(graphNode, propertyNameMapping
                .get(ObjectNodePropertyType.RENDER_SCHEME), namespace, "NodeRenderScheme",
                flag ? defaultSchemeValue : oldSchemeValue);

        // load the rounding radius, from the graph node properties or config manager or the default one
        this.roundingRadius =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.ROUNDING_RADIUS),
                namespace, "NodeRoundingRadius", flag ? DEFAULT_ROUNDING_RADIUS : roundingRadius);
        if (this.roundingRadius < 0) {
            this.roundingRadius = flag ? DEFAULT_ROUNDING_RADIUS : roundingRadius;
        }

        // load the width, from the graph node properties or config manager or the default one
        int width =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.WIDTH), namespace,
                "NodeWidth", flag ? DEFAULT_WIDTH : getWidth());

        // load the height, from the graph node properties or config manager or the default one
        int height =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.HEIGHT), namespace,
                "NodeHeight", flag ? DEFAULT_HEIGHT : getHeight());

        // load the minimum width, from the graph node properties or config manager or the default one
        int minWidth =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.MINIMUM_WIDTH),
                namespace, "NodeWidthMinimum", flag ? MINIMUM_WIDTH : (int) getMinimumSize().getWidth());

        // load the minimum height, from the graph node properties or config manager or the default one
        int minHeight =
            Util.readIntegerProperty(graphNode, propertyNameMapping.get(ObjectNodePropertyType.MINIMUM_HEIGHT),
                namespace, "NodeHeightMinimum", flag ? MINIMUM_HEIGHT : (int) getMinimumSize().getHeight());

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

    // FIXME added
    /**
     * <p>
     * Gets the connector.
     * </p>
     *
     * @return the connector of this component.
     */
    public Connector getConnector() {
        return connector;
    }

    // FIXME added
    /**
     * <p>
     * Sets the connector.
     * </p>
     *
     * @param connector
     *            the connector to set
     */
    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    /**
     * <p>
     * changes the showName.
     * </p>
     *
     * @param showName
     *            the showName to change
     */
    public void changeShowName() {
        this.showName = !showName;
        Property p = getFlagProperty();
        int flag = Integer.parseInt(p.getValue());
        flag ^= 1;
        p.setValue(Integer.toString(flag));
    }

    /**
     * <p>
     * Sets the showType.
     * </p>
     *
     * @param showType
     *            the showType to change
     */
    public void changeShowType() {
        this.showType = !showType;
        Property p = getFlagProperty();
        int flag = Integer.parseInt(p.getValue());
        // int flag=getGraphNode().getFlag();
        // int flag=getGraphNode().getFlag();
        flag ^= 2;
        // getGraphNode().setFlag(flag);
        p.setValue(Integer.toString(flag));
    }

    /**
     * <p>
     * Get the property whose value indicate how display the objectNode name. 0- display name and type, 1-display
     * type, 2-display name, 3 - display none.
     * </p>
     *
     * @param property
     *            the property whose value is display flag
     */
    public Property getFlagProperty() {
        Iterator<Property> it = getGraphNode().getProperties().iterator();
        while (it.hasNext()) {
            Property p = it.next();
            if (LIFELINE_DISPLAY_FLAG.equals(p.getKey())) {
                return p;
            }
        }
        Property flag = new Property();
        flag.setKey(LIFELINE_DISPLAY_FLAG);
        flag.setValue("0");
        getGraphNode().addProperty(flag);
        return flag;
    }

    /**
     * <p>
     * Get the flag imply how display the objectNode name. 0- display name and type, 1-display type, 2-display
     * name, 3 - display none.
     * </p>
     *
     * @param int the display flag
     */
    public int getDisplayFlag() {
        Property p = getFlagProperty();
        return Integer.parseInt(p.getValue());
    }

}
