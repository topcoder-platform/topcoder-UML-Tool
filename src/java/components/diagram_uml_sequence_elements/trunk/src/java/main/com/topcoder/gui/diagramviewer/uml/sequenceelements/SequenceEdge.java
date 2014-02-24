/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.EnumMap;

import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * <p>
 * This abstract class extends the parent Edge class by configuration options.
 * And some common behavior (popup registering, mouse events processing) for
 * the all sequence diagram edges are implemented.
 * </p>
 *
 * <p>
 * The class processes mouse events, but does not react to most of them.
 * They are passed to the top-level classes. Only popup window showing
 * is processed.
 * </p>
 *
 * <p>
 * This class needs configuration and here is a sample:
 * &lt;Property name=&quot;EdgeStrokeColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeFillColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeFillColor2&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeShadowColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeFontColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeTextBoxStrokeColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeTextBoxFillColor&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeTextBoxFillColor2&quot;&gt;
 *     &lt;Value&gt;Color.BLACK&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeFontFamily&quot;&gt;
 *     &lt;Value&gt;Times&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeFontStyle&quot;&gt;
 *     &lt;Value&gt;Font.BOLD&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeFontSize&quot;&gt;
 *     &lt;Value&gt;6&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeRenderScheme&quot;&gt;
 *     &lt;Value&gt;1&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeDashLength&quot;&gt;
 *     &lt;Value&gt;15&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;EdgeBlankLength&quot;&gt;
 *     &lt;Value&gt;0&lt;/Value&gt;
 * &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety : The class is mutable and so is not thread safe.
 * </p>
 *
 * <p>
 * Change for v1.1: Add method notifyGraphEdgeChange.
 * Add nameCompartment, stereotypeCompartment, getter method.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @author gniuxiao, TCSDEVELOPER
 *
 * @version 1.1
 * @since 1.0
 */
public abstract class SequenceEdge extends Edge {

    /**
     * <p>
     * Represents the namespace in the configuration file to use for loading configuration values.
     * </p>
     */
    private static final String CONFIG_NAMESPACE = "com.topcoder.gui.diagramviewer."
        + "uml.sequenceelements.sequenceedge";

    /**
     * <p>
     * Represents the default main stroke color for foreground elements.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default main fill color.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FILL_COLOR = Color.WHITE;

    /**
     * <p>
     * Represents the default second fill color used for gradient filling.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FILL_COLOR2 = Color.WHITE;

    /**
     * <p>
     * Represents the default color of shadow.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_SHADOW_COLOR = Color.GRAY;

    /**
     * <p>
     * Represents the default color for font.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_FONT_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default text box color for foreground elements.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_TEXT_BOX_STROKE_COLOR = Color.BLACK;

    /**
     * <p>
     * Represents the default text box fill color.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_TEXT_BOX_FILL_COLOR = Color.WHITE;

    /**
     * <p>
     * Represents the default text box second fill color used for
     * gradient filling.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final Color DEFAULT_TEXT_BOX_FILL_COLOR2 = Color.WHITE;

    /**
     * <p>
     * Represents the default family of the font.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null or empty.
     * </p>
     */
    private static final String DEFAULT_FONT_FAMILY = "Default";

    /**
     * <p>
     * Represents the default style of the font (Font.PLAIN, Font.BOLD and so on).
     * </p>
     *
     * <p>
     * This static variable is immutable and can be any int value.
     * </p>
     */
    private static final int DEFAULT_FONT_STYLE = Font.PLAIN;

    /**
     * <p>
     * Represents the default size of the font in points.
     * </p>
     *
     * <p>
     * This static variable is immutable and can be any positive (not 0) value..
     * </p>
     */
    private static final int DEFAULT_FONT_SIZE = 10;

    /**
     * <p>
     * Represents the default length of dash line part in pixels.
     * </p>
     *
     * <p>
     * This static variable is immutable and can be any positive (not 0) value..
     * </p>
     */
    private static final int DEFAULT_DASH_LENGTH = 15;

    /**
     * <p>
     * Represents the default length of blank line part in pixels.
     * </p>
     *
     * <p>
     * This static variable is immutable and can be 0 or any positive value..
     * </p>
     */
    private static final int DEFAULT_BLANK_LENGTH = 0;

    /**
     * <p>
     * Represents the default rendering scheme.
     * </p>
     *
     * <p>
     * This static variable is immutable and can not be null.
     * </p>
     */
    private static final RenderScheme DEFAULT_RENDER_SCHEME = RenderScheme.TopCoderScheme;

    /**
     * <p>
     * Represent the prefix of stereo type.
     * </p>
     */
    private static final String STEREOTYPE_PREFIX = "<<";

    /**
     * <p>
     * Represent the postfix of stereo type.
     * </p>
     */
    private static final String STEREOTYPE_POSTFIX = ">>";


    /**
     * <p>
     * Represents the instance of Link class. It is used as UML model element.
     * </p>
     *
     * <p>
     * This variable is immutable and can not be null.
     * </p>
     *
     * <p>
     * The value is set in the constructor.
     * </p>
     */
    private final Link link;

    /**
     * <p>
     * Represents the visibility of the stereotype compartment.
     * </p>
     *
     * <p>
     * This variable is mutable and can be any boolean value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private boolean isStereotypesVisible = true;

    /**
     * <p>
     * Represents the visibility of the edge name.
     * </p>
     *
     *
     * <p>
     * This variable is mutable and can be any string value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private boolean isNameVisible = true;

    /**
     * <p>
     * Represents the main color for the foreground elements.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * Represents the main fill color.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * Represents the text box color for the foreground elements.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
    private Color textBoxStrokeColor;

    /**
     * <p>
     * Represents the text box fill color.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
    private Color textBoxFillColor;

    /**
     * <p>
     * Represents the text box second fill color used for gradient filling.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
    private Color textBoxFillColor2;

    /**
     * <p>
     * Represents the family of the font.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
     * <p>
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
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * Represents the length of the dash line part in pixels.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
    private int dashLength;

    /**
     * <p>
     * Represents the length of the blank line part in pixels.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
     * </p>
     *
     * <p>
     * This variable is mutable and can be 0 or any positive value.
     * </p>
     *
     * <p>
     * Getter and Setter methods are provided.
     * </p>
     */
    private int blankLength;

    /**
     * <p>
     * Represents the rendering scheme.
     * </p>
     *
     * <p>
     * The variable is set from the related &quot;DEFAULT&quot; variable in the constructor.
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
     * Represents the Map of property names, used for getting values
     * from the DiagramElement parent object.
     * </p>
     *
     * <p>
     * This variable is set in constructor, non-mutable and can not be null.
     * </p>
     *
     * <p>
     * The setter method can be used to mutate the elements of the Map.
     * The getter method returns the value for the specified key from the Map.
     * </p>
     */
    private EnumMap<SequenceEdgePropertyType, String> propertyNameMapping;

    /**
     * Enhancement:UML 9627
     * Description:SequenceEdge##nameCompartment, stereotypeCompartment, getter.
     */
    /**
     * <p>
     * Represents the name compartment of the GraphEdge that this class represents. It will be changed in constructor
     * and <code>notifyGraphEdgeChange</code> method, can be accessed.
     * </p>
     */
    private TextField nameCompartment;

    /**
     * Enhancement:UML 9627
     * Description:SequenceEdge##nameCompartment, stereotypeCompartment, getter.
     */
    /**
     * <p>
     * Represents the stereotype compartment of the GraphEdge that this class represents. It will be changed in
     * constructor and <code>notifyGraphEdgeChange</code> method, can be accessed.
     * </p>
     */
    private TextField stereotypeCompartment;

    /**
     * <p>
     * Indicates whether the ObjectNode's constructor has been called or not.
     * </p>
     */
    private boolean constructed = false;

    /**
     * <p>
     * Constructs the class and set related class variables by using the arguments.
     * </p>
     *
     * <p>
     * The instance variables will firstly load from the properties of the <code>graphEdge</code>,
     * if not found, then load from the properties in the config manager, if not found, then
     * the default value will be used.
     * </p>
     *
     * <p>
     * Change for v1.1: Use notifyGraphEdgeChange method to initialize SequenceEdge's properties.
     * </p>
     *
     * @param link The instance of the Link. This is ModelElement providing useful information
     * (for example, name) for the edge.
     * @param graphEdge Instance of the GraphEdge class. Provides the information about the edge size.
     * The GraphEdge should have the right structure, it should have at least 2 contained DiagramElement.
     * Both are GraphNode, and the first one is used to create nameCompartment, and the second one is
     * used to create stereotypeCompartment. If the structure is not right, these two member will be null.
     * @param lineStyle The instance of the LineStyle class representing the line to draw for the edge.
     * @param leftEnding The instance of the EdgeEnding representing the left ending element for the edge.
     * @param rightEnding The instance of the EdgeEnding representing the right ending element for the edge.
     * @param propertyNameMapping The predefined Map with information about property names configuration.
     * The properties are from DiagramElement parent class.
     *
     * @throws IllegalArgumentException if any argument is null, or if propertyNameMapping is empty
     *
     * @since 1.0
     */
    protected SequenceEdge(Link link, GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding,
        EdgeEnding rightEnding, EnumMap<SequenceEdgePropertyType, String> propertyNameMapping) {
        super(graphEdge, lineStyle, leftEnding, rightEnding);

        Util.checkNull(link, "link");
        Util.checkNull(leftEnding, "leftEnding");
        Util.checkNull(rightEnding, "rightEnding");
        Util.checkNull(propertyNameMapping, "propertyNameMapping");
        if (propertyNameMapping.isEmpty()) {
            throw new IllegalArgumentException("The given propertyNameMapping is empty.");
        }

        this.link = link;
        this.propertyNameMapping = propertyNameMapping;

        addTextFields(graphEdge);

        //Notify the SequenceEdge instance is created
        notifyGraphEdgeChange();
        constructed = true;
    }

    /**
     * <p>
     * Sets the name of the edge.
     * </p>
     *
     * @param name The name of edge.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setName(String name) {
        Util.checkNull(name, "name");

        this.link.setName(name);
    }

    /**
     * <p>
     * Gets the name of the edge.
     * </p>
     *
     * @return The name of edge.
     */
    public String getName() {
        return this.link.getName();
    }

    /**
     * <p>
     * Gets the <code>Link</code> model element in this edge.
     * </p>
     *
     * @return The reference to the Link object.
     */
    public Link getLink() {
        return this.link;
    }

    /**
     * <p>
     * Sets the Stereotypes compartment visibility.
     * </p>
     *
     * @param isVisible Stereotypes compartment visibility.
     */
    public void setIsStereotypesVisible(boolean isVisible) {
        this.isStereotypesVisible = isVisible;
    }

    /**
     * <p>
     * Gets the Stereotypes compartment visibility.
     * </p>
     *
     * @return Stereotypes compartment visibility.
     */
    public boolean getIsStereotypesVisible() {
        return this.isStereotypesVisible;
    }

    /**
     * <p>
     * Sets the visibility of edge name.
     * </p>
     *
     * @param isVisible The visibility of edge name.
     */
    public void setIsNameVisible(boolean isVisible) {
        this.isNameVisible = isVisible;
    }

    /**
     * <p>
     * Gets the visibility of edge name.
     * </p>
     *
     * @return The visibility of edge name.
     */
    public boolean getIsNameVisible() {
        return this.isNameVisible;
    }

    /**
     * <p>
     * Sets the stroke color of the edge.
     * </p>
     *
     * @param strokeColor The stroke color.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setStrokeColor(Color strokeColor) {
        Util.checkNull(strokeColor, "strokeColor");

        this.strokeColor = strokeColor;
    }

    /**
     * <p>
     * Gets the stroke color of the edge.
     * </p>
     *
     * @return The stroke color.
     */
    public Color getStrokeColor() {
        return this.strokeColor;
    }

    /**
     * <p>
     * Sets the fill color of the edge.
     * </p>
     *
     * @param fillColor The color to fill.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setFillColor(Color fillColor) {
        Util.checkNull(fillColor, "fillColor");

        this.fillColor = fillColor;
    }

    /**
     * <p>
     * Gets the fill color of the edge.
     * </p>
     *
     * @return The color to fill.
     */
    public Color getFillColor() {
        return this.fillColor;
    }

    /**
     * <p>
     * Sets the second color for filling.
     * </p>
     *
     * @param fillColor2 The second color for filling.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setFillColor2(Color fillColor2) {
        Util.checkNull(fillColor2, "fillColor2");

        this.fillColor2 = fillColor2;
    }

    /**
     * <p>
     * Gets the second color for filling.
     * </p>
     *
     * @return The second color for filling.
     */
    public Color getFillColor2() {
        return this.fillColor2;
    }

    /**
     * <p>
     * Sets the shadow color of this edge.
     * </p>
     *
     * @param shadowColor The color of shadow.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setShadowColor(Color shadowColor) {
        Util.checkNull(shadowColor, "shadowColor");

        this.shadowColor = shadowColor;
    }

    /**
     * <p>
     * Gets the shadow color of this edge.
     * </p>
     *
     * @return The color of shadow.
     */
    public Color getShadowColor() {
        return this.shadowColor;
    }

    /**
     * <p>
     * Sets the font color of this edge.
     * </p>
     *
     * @param fontColor The color of font.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setFontColor(Color fontColor) {
        Util.checkNull(fontColor, "fontColor");

        this.fontColor = fontColor;
    }

    /**
     * <p>
     * Gets the font color of this edge.
     * </p>
     *
     * @return The color of font.
     */
    public Color getFontColor() {
        return this.fontColor;
    }

    /**
     * <p>
     * Sets the text box stroke color of this edge.
     * </p>
     *
     * @param textBoxStrokeColor The main color of the text box.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setTextBoxStrokeColor(Color textBoxStrokeColor) {
        Util.checkNull(textBoxStrokeColor, "textBoxStrokeColor");

        this.textBoxStrokeColor = textBoxStrokeColor;
    }

    /**
     * <p>
     * Gets the text box stroke color of this edge.
     * </p>
     *
     * @return The main color of the text box.
     */
    public Color getTextBoxStrokeColor() {
        return this.textBoxStrokeColor;
    }

    /**
     * <p>
     * Sets the text box fill color of this edge.
     * </p>
     *
     * @param textBoxFillColor The color to fill text box.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setTextBoxFillColor(Color textBoxFillColor) {
        Util.checkNull(textBoxFillColor, "textBoxFillColor");

        this.textBoxFillColor = textBoxFillColor;
    }

    /**
     * <p>
     * Gets the text box fill color of this edge.
     * </p>
     *
     * @return The color to fill text box.
     */
    public Color getTextBoxFillColor() {
        return this.textBoxFillColor;
    }

    /**
     * <p>
     * Sets the gradient filling color of the text box.
     * </p>
     *
     * @param textBoxFillColor2 The color for gradient filling of the text box.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setTextBoxFillColor2(Color textBoxFillColor2) {
        Util.checkNull(textBoxFillColor2, "textBoxFillColor2");

        this.textBoxFillColor2 = textBoxFillColor2;
    }

    /**
     * <p>
     * Gets the gradient filling color of the text box.
     * </p>
     *
     * @return The color for gradient filling of the text box.
     */
    public Color getTextBoxFillColor2() {
        return this.textBoxFillColor2;
    }

    /**
     * <p>
     * Sets the font family name of this edge.
     * </p>
     *
     * @param fontFamily The font family string.
     *
     * @throws IllegalArgumentException if argument is null or empty
     */
    public void setFontFamily(String fontFamily) {
        Util.checkString(fontFamily, "fontFamily");

        this.fontFamily = fontFamily;
    }

    /**
     * <p>
     * Gets the font family name of this edge.
     * </p>
     *
     * @return The font family string.
     */
    public String getFontFamily() {
        return this.fontFamily;
    }

    /**
     * <p>
     * Sets the font style of this edge.
     * </p>
     *
     * @param fontStyle The style of the font.
     */
    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    /**
     * <p>
     * Gets the font style of this edge.
     * </p>
     *
     * @return The style of the font.
     */
    public int getFontStyle() {
        return this.fontStyle;
    }

    /**
     * <p>
     * Sets the font size of this edge.
     * </p>
     *
     * @param fontSize The font size in points.
     *
     * @throws IllegalArgumentException if the argument is 0 or negative
     */
    public void setFontSize(int fontSize) {
        if (fontSize <= 0) {
            throw new IllegalArgumentException("The given font size [" + fontSize + "] is not positive.");
        }

        this.fontSize = fontSize;
    }

    /**
     * <p>
     * Gets the font size of this edge.
     * </p>
     *
     * @return The font size in points.
     */
    public int getFontSize() {
        return this.fontSize;
    }

    /**
     * <p>
     * Sets the dash length of this edge.
     * </p>
     *
     * @param dashLength The length of the dash part of the line in pixels.
     *
     * @throws IllegalArgumentException if argument is 0 or negative
     */
    public void setDashLength(int dashLength) {
        if (dashLength <= 0) {
            throw new IllegalArgumentException("The given dash length [" + dashLength + "] is not positive.");
        }

        this.dashLength = dashLength;
    }

    /**
     * <p>
     * Gets the dash length of this edge.
     * </p>
     *
     * @return The length of the dash part of the line in pixels.
     */
    public int getDashLength() {
        return this.dashLength;
    }

    /**
     * <p>
     * Sets the blank length of this edge.
     * </p>
     *
     * @param blankLength The length of the blank part of the line in pixels.
     * If zero then the line will be continuous, not dashed.
     *
     * @throws IllegalArgumentException if argument is negative
     */
    public void setBlankLength(int blankLength) {
        if (blankLength < 0) {
            throw new IllegalArgumentException("The given blank length [" + blankLength + "] is negative.");
        }

        this.blankLength = blankLength;
    }

    /**
     * <p>
     * Gets the blank length of this edge.
     * </p>
     *
     * @return The length of the blank part of the line in pixels. If zero then
     * the line is continuous, not dashed.
     */
    public int getBlankLength() {
        return this.blankLength;
    }

    /**
     * <p>
     * Sets the render scheme of this edge.
     * </p>
     *
     * @param renderScheme The value from RenderScheme enum.
     *
     * @throws IllegalArgumentException if renderScheme is null
     */
    public void setRenderScheme(RenderScheme renderScheme) {
        Util.checkNull(renderScheme, "renderScheme");

        this.renderScheme = renderScheme;
    }

    /**
     * <p>
     * Gets the render scheme of this edge.
     * </p>
     *
     * @return The value from RenderScheme enum.
     */
    public RenderScheme getRenderScheme() {
        return this.renderScheme;
    }

    /**
     * <p>
     * Sets the pop-up menu of this edge.
     * </p>
     *
     * @param popup The reference to the instance of the JPopupMenu implementation class.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setPopup(JPopupMenu popup) {
        Util.checkNull(popup, "popup");

        this.popup = popup;
    }

    /**
     * <p>
     * Gets the pop-up menu of this edge.
     * </p>
     *
     * @return The reference to the instance of the JPopupMenu implementation class.
     */
    public JPopupMenu getPopup() {
        return this.popup;
    }

    /**
     * <p>
     * Consumes event when the diagram viewer is in the state of adding element.
     * </p>
     *
     * <p>
     * If true is returned, it means that the event is consumed in the element.
     * If false is returned, it means that the event should be passed behind.
     * </p>
     *
     * <p>
     * Note, how to implement this information will be defined when the DiagramViewer
     * design will be implemented.
     * </p>
     *
     * @param event The instance of the mouse event.
     * @return Flag whether the event was consumed in the component.
     *
     * @throws IllegalArgumentException if argument is null
     */
    protected boolean consumeEvent(MouseEvent event) {
        Util.checkNull(event, "event");

        return false;
    }


    /**
     * <p>
     * Overrides processMouseEvent. It can treat mouse event differently when diagram viewer is in
     * different state. Use consumeEvent to determine the current state.
     * </p>
     *
     * <p>
     * The right mouse button click is processed. It will show the popup (if it was registered
     * on this component).
     * </p>
     *
     * @param e The instance of the MouseEvent.
     *
     * @throws IllegalArgumentException if argument is null
     */
    protected void processMouseEvent(MouseEvent e) {
        Util.checkNull(e, "e");

        super.processMouseEvent(e);
    }

    /**
     * <p>
     * Sets the given key and value to the <code>propertyNameMapping</code> Map.
     * </p>
     *
     * @param key They key in the propertyNameMapping Map.
     * @param value They value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key is null or if value argument is null/empty
     */
    public void setPropertyNameMappingElement(SequenceEdgePropertyType key, String value) {
        Util.checkNull(key, "key");
        Util.checkString(value, "value");

        this.propertyNameMapping.put(key, value);
    }

    /**
     * <p>
     * Gets the property value in the <code>propertyNameMapping</code> Map according to the given
     * key.
     * </p>
     *
     * @param key They key in the propertyNameMapping Map.
     * @return They value in the propertyNameMapping Map for the specified key.
     *
     * @throws IllegalArgumentException if key is null
     */
    public String getPropertyNameMappingElement(SequenceEdgePropertyType key) {
        Util.checkNull(key, "key");

        return this.propertyNameMapping.get(key);
    }

    /**
     * Enhancement:UML 9627
     * Description:SequenceEdge##nameCompartment, stereotypeCompartment, getter.
     */
    /**
     * <p>
     * Gets a name compartment <code>TextField</code>.
     * </p>
     * @return the text field representing name compartment
     * @since 1.1
     */
    public TextField getNameCompartment() {
        return nameCompartment;
    }

    /**
     * Enhancement:UML 9627
     * Description:SequenceEdge##nameCompartment, stereotypeCompartment, getter.
     */
    /**
     * <p>
     * Gets a stereotype compartment <code>TextField</code>.
     * </p>
     * @return the text field representing stereotype compartment
     * @since 1.1
     */
    public TextField getStereotypeCompartment() {
        return stereotypeCompartment;
    }

    /**
     * Enhancements: UML 9626
     * Description: This method will be used to retrieve diagram interchange information
     * from contained graphEdge, and update the SequenceEdge.
     */
    /**
     * <p>
     * Retrieve diagram interchange information from contained graphEdge, and update the SequenceEdge.
     * </p>
     *
     * @since 1.1
     */
    public void notifyGraphEdgeChange() {
        GraphEdge graphEdge = getGraphEdge();

        if (!constructed) {
            //this method is called by the constructor, so perform initialization
            //on the SequenceEdge and its properties.
            updateProperties(CONFIG_NAMESPACE, true);
        } else {
            //perform update on the SequenceEdge and its properties
            updateProperties("", false);
        }

        ModelElement element = (ModelElement) (((Uml1SemanticModelBridge) graphEdge
                .getSemanticModel()).getElement());
        stereotypeCompartment.setText(getStereotypeText(element
                .getStereotypes()));
        nameCompartment.setText(element.getName());
    }

    /**
     * <p>
     * Helper function that generates a stereotype string according to the given
     * stereotypes.
     * </p>
     *
     * @param stereotypes
     *            the collection of stereotype
     * @return the stereotype string
     */
    private static String getStereotypeText(Collection<Stereotype> stereotypes) {
        String s = "";

        if (stereotypes != null) {
            for (Stereotype stereotype : stereotypes) {
                s += stereotype.getName() + ", ";
            }
        }

        String result = "";
        if (s.length() != 0) {
            s = s.substring(0, s.length() - 2);
            result = STEREOTYPE_PREFIX + s + STEREOTYPE_POSTFIX;
        }

        return result;
    }

    /**
     * <p>
     * Update the SequenceEdge's properties with the GraphEdge's properties.
     * </p>
     *
     * <p>
     * The params namespace and flag should only have the two following combination:
     * 1)namespace is valid and flag is true.
     * 2)namespace is empty and flag is false.
     * </p>
     *
     * <p>
     * if namespace is valid and flag is true:
     * this method will actually load the instance variables from the properties of the GraphEdge,
     * if not found, then load from the properties in the config manager, if not found, then the
     * default value will be used.
     * </p>
     *
     * <p>
     * If namespace is empty and flag is false:
     * this method will update the SequenceEdge's properties from GraphEdge's properties.If not found
     * in the GraphEdge, then the SequenceEdge's properties will not be changed.
     * </p>
     *
     *
     * @param namespace The namespace of the Config Manager, can be null.
     * @param flag indicates whether use the default value or stay the same when it can not find
     * correponding properties.
     *
     * @since 1.1
     */
    private void updateProperties(String namespace, boolean flag) {

        GraphEdge graphEdge = this.getGraphEdge();

        // load the stroke color, from the graph node properties or config manager or the default one
        this.strokeColor = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.STROKE_COLOR), namespace, "EdgeStrokeColor",
            flag ? DEFAULT_STROKE_COLOR : strokeColor);

        // load the fill color, from the graph node properties or config manager or the default one
        this.fillColor = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.FILL_COLOR), namespace, "EdgeFillColor",
            flag ? DEFAULT_FILL_COLOR : fillColor);

        // load the fill color 2, from the graph node properties or config manager or the default one
        this.fillColor2 = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.FILL_COLOR2), namespace, "EdgeFillColor2",
            flag ? DEFAULT_FILL_COLOR2 : fillColor2);

        // load the font color, from the graph node properties or config manager or the default one
        this.fontColor = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.FONT_COLOR), namespace, "EdgeFontColor",
            flag ? DEFAULT_FONT_COLOR : fontColor);

        // load the shadow color, from the graph node properties or config manager or the default one
        this.shadowColor = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.SHADOW_COLOR), namespace, "EdgeShadowColor",
            flag ? DEFAULT_SHADOW_COLOR : shadowColor);

        // load the font family, from the graph node properties or config manager or the default one
        String fontFamily = null;
        fontFamily = Util.parseStringProperty(graphEdge, propertyNameMapping
                .get(SequenceEdgePropertyType.FONT_FAMILY));
        if (fontFamily == null) {
            fontFamily = Util.parseStringProperty(namespace, "EdgeFontFamily");
        }
        if (fontFamily == null) {
            fontFamily = flag ? DEFAULT_FONT_FAMILY : this.fontFamily;
        }
        this.fontFamily = fontFamily;

        // load the font size, from the graph node properties or config manager or the default one
        this.fontSize = Util.readIntegerProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.FONT_SIZE), namespace, "EdgeFontSize",
            flag ? DEFAULT_FONT_SIZE : this.fontSize);
        if (fontSize <= 0) {
            this.fontSize = flag ? DEFAULT_FONT_SIZE : this.fontSize;
        }

        // load the font style, from the graph node properties or config manager or the default one
        this.fontStyle = Util.parseFontStyleProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.FONT_STYLE), namespace, "EdgeFontStyle",
            flag ? DEFAULT_FONT_STYLE : this.fontStyle);

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
        this.renderScheme = Util.parseReaderSchemeProperty(graphEdge,
            propertyNameMapping.get(ObjectNodePropertyType.RENDER_SCHEME), namespace, "NodeRenderScheme",
            flag ? defaultSchemeValue : oldSchemeValue);

        // load the dast length, from the graph node properties or config manager or the default one
        this.dashLength = Util.readIntegerProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.DASH_LENGTH), namespace, "EdgeDashLength",
            flag ? DEFAULT_DASH_LENGTH : dashLength);
        if (dashLength <= 0) {
            this.dashLength = flag ? DEFAULT_DASH_LENGTH : dashLength;
        }

        // load the blank length, from the graph node properties or config manager or the default one
        this.blankLength = Util.readIntegerProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.BLANK_LENGTH), namespace, "EdgeBlankLength",
            flag ? DEFAULT_BLANK_LENGTH : blankLength);
        if (blankLength < 0) {
            blankLength = flag ? DEFAULT_BLANK_LENGTH : blankLength;
        }

        // load the text box stroke color, from the graph node properties or config manager or the default one
        this.textBoxStrokeColor = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.TEXT_BOX_STROKE_COLOR), namespace,
            "EdgeTextBoxStrokeColor", flag ? DEFAULT_TEXT_BOX_STROKE_COLOR : textBoxStrokeColor);

        // load the text box fill color, from the graph node properties or config manager or the default one
        this.textBoxFillColor = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR), namespace,
            "EdgeTextBoxFillColor", flag ? DEFAULT_TEXT_BOX_FILL_COLOR : textBoxFillColor);

        // load the text box fill color 2, from the graph node properties or config manager or the default one
        this.textBoxFillColor2 = Util.readColorProperty(graphEdge,
            propertyNameMapping.get(SequenceEdgePropertyType.TEXT_BOX_FILL_COLOR2), namespace,
            "EdgeTextBoxFillColor2", flag ? DEFAULT_TEXT_BOX_FILL_COLOR2 : textBoxFillColor2);

        // set font and font color to edge and its compartments
        Font font = new Font(fontFamily, fontStyle, fontSize);
        setFont(font);
        setFontColor(fontColor);
        nameCompartment.setFontColor(fontColor);
        stereotypeCompartment.setFontColor(fontColor);
        nameCompartment.setFont(font);
        stereotypeCompartment.setFont(font);
    }

    /**
     * <p>
     * Creates three compartments and adds them as children.
     * </p>
     *
     * @param graphEdge
     *            the graphEdge representing this Edge
     */
    private void addTextFields(GraphEdge graphEdge) {
        GraphNode nameGraphNode = (GraphNode) (graphEdge.getContaineds().get(0));
        GraphNode stereotypeGraphNode = (GraphNode) (graphEdge.getContaineds()
                .get(1));
        nameCompartment = new TextField(nameGraphNode);
        stereotypeCompartment = new TextField(stereotypeGraphNode);
        nameCompartment.addMouseListener(new TextInputTrigger(nameCompartment));
        addTextField(nameCompartment, AnchorType.Line);
        addTextField(stereotypeCompartment, AnchorType.Line);
    }
}
