/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>
 * This is the main class of the style panel component (is extending JPanel) and will be responsible for
 * the main user interface of the component.
 * </p>
 *
 * <p>
 * There are three parts of the panel:
 * <ol>
 * <li>Size and position</li>
 * <li>Color</li>
 * <li>Font family and size</li>
 * </ol>
 *
 * <p>
 * Between each part there will be a JSeparator. So, in the complete mode, there will be 5 widgets stacked in
 * BoxLayout (panelSizePosition, separator1, panelColor, separator2, and panelFont).
 * </p>
 *
 * <p>
 * The instance of this class' scope is kept as long as the application is shown.
 * </p>
 *
 * <p>
 * Thread safety: this class is not thread safe, but since it will only works on event-dispatching thread,
 * there will be no problem.
 * </p>
 *
 * <p>
 * 1.1 Change Note:
 * <ol>
 * <li>The layout of the control is updated to match the new layout.</li>
 * <li>The resizing changes to keep the vertical/horizontal spacing and size of elements intact,
 * filling in empty space at the bottom and right of the panel if the panel is resized.</li>
 * <li>A separate horizontal layout is added, with a constructor and flag to be used to create
 * the secondary layout.</li>
 * </ol>
 * </p>
 * @author enefem21, TCSDEVELOPER
 * @version 1.1
 */
public class StylePanel extends JPanel {
    /**
     * <p>
     * Represents the default font name used in the component.
     * </p>
     */
    private static final String DEFAULT_FONT_NAME = "Default";

    /**
     * <p>
     * Represents the default minimum width used in the component.
     * </p>
     */
    private static final int DEFAULT_MINIMUM_WIDTH = 100;

    /**
     * <p>
     * Represents the default minimum height used in the component.
     * </p>
     */
    private static final int DEFAULT_MINIMUM_HEIGHT = 100;

    /**
     * <p>
     * Represents the default preferred width used in the component.
     * </p>
     */
    private static final int DEFAULT_PREFERRED_WIDTH = 300;

    /**
     * <p>
     * Represents the default minimum height used in the component.
     * </p>
     */
    private static final int DEFAULT_PREFERRED_HEIGHT = 300;

    /**
     * <p>
     * Represents the key for the height style.
     * </p>
     */
    private static final String DEFAULT_HEIGHT_KEY = "height";

    /**
     * <p>Represents the key for the width style.</p>
     *
     */
    private static final String DEFAULT_WIDTH_KEY = "width";

    /**
     * <p>
     * Represents the key for the axis position style.
     * </p>
     */
    private static final String DEFAULT_X_KEY = "x";

    /**
     * <p>
     * Represents the key for the ordinate position style.
     * </p>
     */
    private static final String DEFAULT_Y_KEY = "y";

    /**
     * <p>
     * Represents the key for the font name style.
     * </p>
     */
    private static final String DEFAULT_FONT_NAME_KEY = "fontName";

    /**
     * <p>
     * Represents the key for the font size style.
     * </p>
     */
    private static final String DEFAULT_FONT_SIZE_KEY = "fontSize";

    /**
     * <p>
     * Represents the key for the fill color style.
     * </p>
     */
    private static final String DEFAULT_FILL_COLOR_KEY = "fillColor";

    /**
     * <p>
     * Represents the key for the outline color style.
     * </p>
     */
    private static final String DEFAULT_OUTLINE_COLOR_KEY = "outlineColor";

    /**
     * <p>
     * Represents the key for the text color style.
     * </p>
     */
    private static final String DEFAULT_TEXT_COLOR_KEY = "textColor";

    /**
     * <p>
     * Represents the listeners that have to be notified when a style change happens.
     * </p>
     *
     * <p>
     * This variable is immutable, it can not be null or contains null element but can
     * be empty.
     * </p>
     */
    private final List<StyleListener> styleListenerList = new ArrayList<StyleListener>();

    /**
     * <p>
     * Represents current style objects that are displayed in the style panel.
     * </p>
     *
     * <p>
     * This variable is mutable, it can not be null or contains null element but can
     * be empty.
     * </p>
     */
    private List<StyleObject> styleObjectList = new ArrayList<StyleObject>();

    /**
     * <p>
     * Represents the font that is used in the component itself.
     * </p>
     *
     * <p>
     * This variable is mutable, it can not be null.
     * </p>
     */
    private Font font;

    /**
     * <p>
     * Represents the font family selector.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private FontFamilySelector fontFamilySelector;

    /**
     * <p>
     * Represents the font size selector.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private FontSizeSelector fontSizeSelector;

    /**
     * <p>
     * Represents the widget to select color.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JColorChooser colorChooser;

    /**
     * <p>
     * Represents the widget of color selector panel.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private ColorChooserPanel colorChooserPanel;

    /**
     * <p>
     * Represents the widget to change width value.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JTextField widthTextField;

    /**
     * <p>
     * Represents the widget to change height value.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JTextField heightTextField;

    /**
     * <p>
     * Represents the widget to change x-position value.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JTextField xTextField;

    /**
     * <p>
     * Represents the widget to change y-position value.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JTextField yTextField;

    /**
     * <p>
     * Represents the widget to show color of fill color.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JButton fillColorButton;

    /**
     * <p>
     * Represents the widget to show color of outline color.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JButton outlineColorButton;

    /**
     * <p>
     * Represents the widget to show color of text color.
     * </p>
     *
     * <p>
     * Maybe be null at the beginning, once set, it cannot be changed afterward.
     * </p>
     */
    private JButton textColorButton;

    /**
     * <p>
     * Represents the frame for containing color chooser.
     * </p>
     *
     * <p>
     * It may be read from configuration manager, if not, default value will be used.
     * </p>
     */
    private JFrame colorChooserFrame;

    /**
     * <p>
     * Represents the key for height.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String heightKey;

    /**
     * <p>
     * Represents the key for width.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String widthKey;

    /**
     * <p>
     * Represents the key for x-position.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String xKey;

    /**
     * <p>
     * Represents the key for y-position.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String yKey;

    /**
     * <p>
     * Represents the key for font name.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String fontNameKey;

    /**
     * <p>
     * Represents the key for font name.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String fontSizeKey;

    /**
     * <p>
     * Represents the key for fill color.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String fillColorKey;

    /**
     * <p>
     * Represents the key for out color.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String outlineColorKey;

    /**
     * <p>
     * Represents the key for text color.
     * </p>
     *
     * <p>
     * Is immutable and will never be null or empty string.
     * </p>
     */
    private final String textColorKey;

    /**
     * <p>
     * Represents the namespace to configure the style panel.
     * </p>
     *
     * <p>
     * It may be null if the default constructor is used.
     * </p>
     *
     * <p>
     * Is immutable, can be null but can not be empty string.
     * </p>
     */
    private final String namespace;

    /**
     * <p>
     * Represents the minimum width of the style panel.
     * </p>
     *
     * <p>
     * It may be read from configuration manager, if not, default value will be used.
     * </p>
     */
    private final int minimumWidth;

    /**
     * <p>
     * Represents the minimum height of the style panel.
     * </p>
     *
     * <p>
     * It may be read from configuration manager, if not, default value will be used.
     * </p>
     */
    private final int minimumHeight;

    /**
     * <p>
     * Represents the preferred width of the style panel.
     * </p>
     *
     * <p>
     * It may be read from configuration manager, if not, default value will be used.
     * </p>
     */
    private final int preferredWidth;

    /**
     * <p>
     * Represents the preferred height of the style panel.
     * </p>
     *
     * <p>
     * It may be read from configuration manager, if not, default value will be used.
     * </p>
     */
    private final int preferredHeight;

    /**
     * <p>
     * Represents the initial font name of the style panel.
     * </p>
     *
     * <p>
     * It may be read from configuration manager, if not, default value will be used.
     * </p>
     */
    private final String fontName;


    /**
     * <p>
     * Represents whether to use horizontal layout.
     * </p>
     *
     * <p>
     * Initialized in the constructor, never change afterward.
     * </p>
     */
    private final boolean horizontalLayout;

    /**
     * <p>
     * Default constructor for StylePanel.
     * </p>
     *
     * <p>
     * Note, if the StylePanel instance is constructed using this constructor, then the default
     * values for <b>heightKey</b>, <b>widthKey</b>, <b>xKey</b>, <b>yKey</b>, <b>fontNameKey</b>,
     * <b>fontSizeKey</b>, <b>fillColorKey</b>, <b>outlineColorKey</b>, <b>textColorKey</b>,
     * <b>minimum width</b>, <b>minimum height</b>, <b>preferred width</b>, <b>preferred height</b>,
     * <b>font name</b> will be used.
     * </p>
     * <p>
     * Vertical layout is used.
     * </p>
     * <p>
     * v1.1 Change Note: the vertical layout is used as default.
     * </p>
     */
    public StylePanel() {
        this(false);
    }

    /**
     * <p>
     * Constructor with the horizontal layout flag. The layout specified by horizontalLayout is used.
     * </p>
     *
     * <p>
     * Note, if the StylePanel instance is constructed using this constructor, then the default
     * values for <b>heightKey</b>, <b>widthKey</b>, <b>xKey</b>, <b>yKey</b>, <b>fontNameKey</b>,
     * <b>fontSizeKey</b>, <b>fillColorKey</b>, <b>outlineColorKey</b>, <b>textColorKey</b>,
     * <b>minimum width</b>, <b>minimum height</b>, <b>preferred width</b>, <b>preferred height</b>,
     * <b>font name</b> will be used.
     * </p>
     * @param horizontalLayout whether to use horizontal layout.
     * @since 1.1
     */
    public StylePanel(boolean horizontalLayout) {
        this.horizontalLayout = horizontalLayout;

        this.heightKey = DEFAULT_HEIGHT_KEY;
        this.widthKey = DEFAULT_WIDTH_KEY;
        this.xKey = DEFAULT_X_KEY;
        this.yKey = DEFAULT_Y_KEY;
        this.fontNameKey = DEFAULT_FONT_NAME_KEY;
        this.fontSizeKey = DEFAULT_FONT_SIZE_KEY;
        this.fillColorKey = DEFAULT_FILL_COLOR_KEY;
        this.outlineColorKey = DEFAULT_OUTLINE_COLOR_KEY;
        this.textColorKey = DEFAULT_TEXT_COLOR_KEY;

        this.minimumWidth = DEFAULT_MINIMUM_WIDTH;
        this.minimumHeight = DEFAULT_MINIMUM_HEIGHT;
        this.preferredWidth = DEFAULT_PREFERRED_WIDTH;
        this.preferredHeight = DEFAULT_PREFERRED_HEIGHT;
        this.fontName = DEFAULT_FONT_NAME;

        namespace = null;
        initialize();
    }


    /**
     * <p>
     * Constructor with namespace specified.
     * </p>
     * <p>
     * Vertical layout is used.
     * </p>
     * <p>
     * Sample configuration:
     * &lt;Property name=&quot;looknfeel&quot;&gt;
     *     &lt;Property name=&quot;fontName&quot;&gt;
     *         &lt;Value&gt;Arial&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;minimumWidth&quot;&gt;
     *        &lt;Value&gt;100&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;minimumHeight&quot;&gt;
     *         &lt;Value&gt;100&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;preferredWidth&quot;&gt;
     *         &lt;Value&gt;140&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;preferredHeight&quot;&gt;
     *         &lt;Value&gt;140&lt;/Value&gt;
     *     &lt;/Property&gt;
     * &lt;/Property&gt;
     * &lt;Property name=&quot;propertyKey&quot;&gt;
     *     &lt;Property name=&quot;widthKey&quot;&gt;
     *         &lt;Value&gt;width&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;heightKey&quot;&gt;
     *         &lt;Value&gt;height&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;xKey&quot;&gt;
     *         &lt;Value&gt;x&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;yKey&quot;&gt;
     *         &lt;Value&gt;y&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;fontNameKey&quot;&gt;
     *         &lt;Value&gt;fontName&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;fontSizeKey&quot;&gt;
     *         &lt;Value&gt;fontSize&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;fillColorKey&quot;&gt;
     *         &lt;Value&gt;fillColor&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;outlineColorKey&quot;&gt;
     *         &lt;Value&gt;outlineColor&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;textColorKey&quot;&gt;
     *         &lt;Value&gt;textColor&lt;/Value&gt;
     *     &lt;/Property&gt;
     * &lt;/Property&gt;
     * </p>
     * <p>
     * v1.1 Change Note: the vertical layout is used as default.
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     *
     * @throws IllegalArgumentException if namespace is null or empty
     * @throws StylePanelConfigurationException if there is an invalid configuration
     */
    public StylePanel(String namespace) {
        this(namespace, false);
    }

    /**
     * <p>
     * Constructor with namespace and horizontalLayout specified.
     * The layout specified by horizontalLayout is used.
     * </p>
     *
     * <p>
     * Sample configuration:
     * &lt;Property name=&quot;looknfeel&quot;&gt;
     *     &lt;Property name=&quot;fontName&quot;&gt;
     *         &lt;Value&gt;Arial&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;minimumWidth&quot;&gt;
     *        &lt;Value&gt;100&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;minimumHeight&quot;&gt;
     *         &lt;Value&gt;100&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;preferredWidth&quot;&gt;
     *         &lt;Value&gt;140&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;preferredHeight&quot;&gt;
     *         &lt;Value&gt;140&lt;/Value&gt;
     *     &lt;/Property&gt;
     * &lt;/Property&gt;
     * &lt;Property name=&quot;propertyKey&quot;&gt;
     *     &lt;Property name=&quot;widthKey&quot;&gt;
     *         &lt;Value&gt;width&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;heightKey&quot;&gt;
     *         &lt;Value&gt;height&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;xKey&quot;&gt;
     *         &lt;Value&gt;x&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;yKey&quot;&gt;
     *         &lt;Value&gt;y&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;fontNameKey&quot;&gt;
     *         &lt;Value&gt;fontName&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;fontSizeKey&quot;&gt;
     *         &lt;Value&gt;fontSize&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;fillColorKey&quot;&gt;
     *         &lt;Value&gt;fillColor&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;outlineColorKey&quot;&gt;
     *         &lt;Value&gt;outlineColor&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;textColorKey&quot;&gt;
     *         &lt;Value&gt;textColor&lt;/Value&gt;
     *     &lt;/Property&gt;
     * &lt;/Property&gt;
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     * @param horizontalLayout whether to use horizontal layout.
     *
     * @throws IllegalArgumentException if namespace is null or empty
     * @throws StylePanelConfigurationException if there is an invalid configuration
     * @since 1.1
     */
    public StylePanel(String namespace, boolean horizontalLayout) {
        Util.checkString(namespace, "namespace");
        this.namespace = namespace;
        this.horizontalLayout = horizontalLayout;

        // Get all the properties under the "looknfeel" property
        Map<String, String> looknfeelMap = Util.getPropertyMap(namespace, "looknfeel");

        if (looknfeelMap != null) {
            // get the config value for minimumWidth property
            this.minimumWidth = getIntegerProperty(looknfeelMap, "minimumWidth", DEFAULT_MINIMUM_WIDTH);

            // get the config value for minimumHeight property
            this.minimumHeight = getIntegerProperty(looknfeelMap, "minimumHeight", DEFAULT_MINIMUM_HEIGHT);

            // get the config value for preferredWidth property
            this.preferredWidth = getIntegerProperty(looknfeelMap, "preferredWidth", DEFAULT_PREFERRED_WIDTH);

            // preferredWidth should not be less than minimumWidth
            if (this.preferredWidth < this.minimumWidth) {
                throw new StylePanelConfigurationException("Preferred width is less than minimum width.");
            }

            // get the config value for preferredHeight property
            this.preferredHeight = getIntegerProperty(looknfeelMap, "preferredHeight", DEFAULT_PREFERRED_HEIGHT);

            // preferredHeight should not be less than minimumHeight
            if (this.preferredHeight < this.minimumHeight) {
                throw new StylePanelConfigurationException("Preferred height is less than minimum height.");
            }

            // get the config value for fontName property
            if (looknfeelMap.containsKey("fontName")) {
                String name = looknfeelMap.get("fontName");
                // verify the font name is supported by the system
                if (!Util.getAllFontNames().contains(name)) {
                    throw new StylePanelConfigurationException("The value for looknfeel.fontName property"
                        + " is not valid in system.");
                }
                this.fontName = name;
            } else {
                this.fontName = DEFAULT_FONT_NAME;
            }
        } else {
            // The property is missing, then use default values
            this.minimumWidth = DEFAULT_MINIMUM_WIDTH;
            this.minimumHeight = DEFAULT_MINIMUM_HEIGHT;
            this.preferredWidth = DEFAULT_PREFERRED_WIDTH;
            this.preferredHeight = DEFAULT_PREFERRED_HEIGHT;
            this.fontName = DEFAULT_FONT_NAME;
        }

        // Get all the properties under the "propertyKey" property
        Map<String, String> keyMap = Util.getPropertyMap(namespace, "propertyKey");
        if (keyMap != null) {
            // the width key, may be from config manager or default value
            this.widthKey = (keyMap.containsKey("widthKey")) ? keyMap.get("widthKey") : DEFAULT_WIDTH_KEY;
            // the height key, may be from config manager or default value
            this.heightKey = (keyMap.containsKey("heightKey")) ? keyMap.get("heightKey") : DEFAULT_HEIGHT_KEY;
            // the x key, may be from config manager or default value
            this.xKey = (keyMap.containsKey("xKey")) ? keyMap.get("xKey") : DEFAULT_X_KEY;
            // the y key, may be from config manager or default value
            this.yKey = (keyMap.containsKey("yKey")) ? keyMap.get("yKey") : DEFAULT_Y_KEY;
            // the fontName key, may be from config manager or default value
            this.fontNameKey = (keyMap.containsKey("fontNameKey")) ? keyMap.get("fontNameKey") : DEFAULT_FONT_NAME_KEY;
            // the fontSize key, may be from config manager or default value
            this.fontSizeKey = (keyMap.containsKey("fontSizeKey")) ? keyMap.get("fontSizeKey") : DEFAULT_FONT_SIZE_KEY;
            // the fillColor key, may be from config manager or default value
            this.fillColorKey = (keyMap.containsKey("fillColorKey")) ? keyMap.get("fillColorKey")
                : DEFAULT_FILL_COLOR_KEY;
            // the outlineColor key, may be from config manager or default value
            this.outlineColorKey = (keyMap.containsKey("outlineColorKey")) ? keyMap.get("outlineColorKey")
                : DEFAULT_OUTLINE_COLOR_KEY;
            // the textColor key, may be from config manager or default value
            this.textColorKey = (keyMap.containsKey("textColorKey")) ? keyMap.get("textColorKey")
                : DEFAULT_TEXT_COLOR_KEY;
        } else {
            // The property is missing, then use default values
            this.widthKey = DEFAULT_WIDTH_KEY;
            this.heightKey = DEFAULT_HEIGHT_KEY;
            this.xKey = DEFAULT_X_KEY;
            this.yKey = DEFAULT_Y_KEY;
            this.fontNameKey = DEFAULT_FONT_NAME_KEY;
            this.fontSizeKey = DEFAULT_FONT_SIZE_KEY;
            this.fillColorKey = DEFAULT_FILL_COLOR_KEY;
            this.outlineColorKey = DEFAULT_OUTLINE_COLOR_KEY;
            this.textColorKey = DEFAULT_TEXT_COLOR_KEY;
        }

        initialize();
    }

    /**
     * <p>
     * Return the current font used by this style panel.
     * </p>
     *
     * @return the current font used by this style panel.
     */
    public Font getFont() {
        return this.font;
    }

    /**
     * <p>
     * Add style listener that will be notified when there is a change in the style.
     * </p>
     *
     * @param styleListener styleListener to be notified when there is a change in the style
     *
     * @throws IllegalArgumentException if styleListener is null
     */
    public void addStyleListener(StyleListener styleListener) {
        Util.checkNull(styleListener, "styleListener");

        this.styleListenerList.add(styleListener);
    }

    /**
     * <p>
     * Notifies all style listener when a change in style happens.
     * </p>
     *
     * @param styleEvent the style event which contains information about the changed style
     *
     * @throws IllegalArgumentException if styleEvent is null
     */
    private void fireStyleChanged(StyleEvent styleEvent) {
        Util.checkNull(styleEvent, "styleEvent");

        for (StyleListener styleListener : styleListenerList) {
            styleListener.styleChanged(styleEvent);
        }
    }

    /**
     * <p>
     * Set this panel to show information about styleObject.
     * </p>
     *
     * @param styleObject the style object to be displayed in the style panel
     *
     * @throws IllegalArgumentException if styleObject is null
     */
    public void setStyleObject(StyleObject styleObject) {
        Util.checkNull(styleObject, "styleObject");

        List<StyleObject> styleObjects = new ArrayList<StyleObject>();
        styleObjects.add(styleObject);
        setStyleObjectList(styleObjects);
    }

    /**
     * <p>
     * Set this panel to show information about the given style object list.
     * </p>
     *
     * <p>
     * If one of the style property is not supported, then the corresponding widget in style panel
     * will be hidden.
     * If all the style objects have same value for one style, then the corresponding widge will
     * display the special value, otherwise default value will be used.
     * </p>
     *
     * @param styleObjectList the style object list to be displayed in the style panel
     *
     * @throws IllegalArgumentException if styleObjectList is null or contains null element.
     */
    public void setStyleObjectList(List<StyleObject> styleObjectList) {
        Util.checkList(styleObjectList, "styleObjectList");

        // we should empty the original style objects
        this.styleObjectList = new ArrayList<StyleObject>();

        // update the style panel for all the style objects
        for (StyleObject styleObject : styleObjectList) {
            styleObject.setStylePanel(this);
        }

        // update the widget for x style
        Set<Object> xValues = getStyleValues(styleObjectList, "X");
        if (xValues == null) {
            // Some style object doesn't support the x style, hide the widget
            getXTextField().setVisible(false);
        } else if (xValues.size() == 1) {
            // all of the style objects have the same x value
            getXTextField().setVisible(true);
            getXTextField().setText(xValues.iterator().next().toString());
        } else {
            // not all of the style objects have the same x value
            getXTextField().setVisible(true);
            getXTextField().setText("");
        }

        // update the widget for y style
        Set<Object> yValues = getStyleValues(styleObjectList, "Y");
        if (yValues == null) {
            // Some style object doesn't support the y style, hide the widget
            getYTextField().setVisible(false);
        } else if (yValues.size() == 1) {
            // all of the style objects have the same y value
            getYTextField().setVisible(true);
            getYTextField().setText(yValues.iterator().next().toString());
        } else {
            // not all of the style objects have the same y value
            getYTextField().setVisible(true);
            getYTextField().setText("");
        }

        // update the widget for width style
        Set<Object> widthValues = getStyleValues(styleObjectList, "Width");
        if (widthValues == null) {
            // Some style object doesn't support the width style, hide the widget
            getWidthTextField().setVisible(false);
        } else if (widthValues.size() == 1) {
            // all of the style objects have the same width value
            getWidthTextField().setVisible(true);
            getWidthTextField().setText(widthValues.iterator().next().toString());
        } else {
            // not all of the style objects have the same width value
            getWidthTextField().setVisible(true);
            getWidthTextField().setText("");
        }

        // update the widget for height style
        Set<Object> heightValues = getStyleValues(styleObjectList, "Height");
        if (heightValues == null) {
            // Some style object doesn't support the height style, hide the widget
            getHeightTextField().setVisible(false);
        } else if (heightValues.size() == 1) {
            // all of the style objects have the same height value
            getHeightTextField().setVisible(true);
            getHeightTextField().setText(heightValues.iterator().next().toString());
        } else {
            // not all of the style objects have the same height value
            getHeightTextField().setVisible(true);
            getHeightTextField().setText("");
        }

        // update the widget for fillColor style
        Set<Object> fillColorValues = getStyleValues(styleObjectList, "FillColor");
        if (fillColorValues == null) {
            // Some style object doesn't support the fillColor style, hide the widget
            getFillColorButton().setVisible(false);
        } else if (fillColorValues.size() == 1) {
            // all of the style objects have the same fillColor value
            getFillColorButton().setVisible(true);
            getFillColorButton().setBackground(
                Util.convertColor((String) fillColorValues.iterator().next(), Color.WHITE));
        } else {
            // not all of the style objects have the same fillColor value
            getFillColorButton().setVisible(true);
            getFillColorButton().setBackground(Color.WHITE);
        }

        // update the widget for outlineColor style
        Set<Object> outlineColorValues = getStyleValues(styleObjectList, "OutlineColor");
        if (outlineColorValues == null) {
            // Some style object doesn't support the outlineColor style, hide the widget
            getOutlineColorButton().setVisible(false);
        } else if (outlineColorValues.size() == 1) {
            // all of the style objects have the same fillColor value
            getOutlineColorButton().setVisible(true);
            getOutlineColorButton().setBackground(
                Util.convertColor((String) outlineColorValues.iterator().next(), Color.WHITE));
        } else {
            // not all of the style objects have the same fillColor value
            getOutlineColorButton().setVisible(true);
            getOutlineColorButton().setBackground(Color.WHITE);
        }

        // update the widget for textColor style
        Set<Object> textColorValues = getStyleValues(styleObjectList, "TextColor");
        if (textColorValues == null) {
            // Some style object doesn't support the textColor style, hide the widget
            getTextColorButton().setVisible(false);
        } else if (textColorValues.size() == 1) {
            // all of the style objects have the same textColor value
            getTextColorButton().setVisible(true);
            getTextColorButton().setBackground(
                Util.convertColor((String) textColorValues.iterator().next(), Color.WHITE));
        } else {
            // not all of the style objects have the same textColor value
            getTextColorButton().setVisible(true);
            getTextColorButton().setBackground(Color.WHITE);
        }

        // update the widget for fontName style
        Set<Object> fontNameValues = getStyleValues(styleObjectList, "FontName");
        if (fontNameValues == null) {
            // Some style object doesn't support the fontName style, hide the widget
            getFontFamilySelector().setVisible(false);
        } else if (fontNameValues.size() == 1) {
            // all of the style objects have the same fontName value
            getFontFamilySelector().setVisible(true);
            getFontFamilySelector().setSelectedItem(fontNameValues.iterator().next());
        } else {
            // not all of the style objects have the same fontName value
            getFontFamilySelector().setVisible(true);
            getFontFamilySelector().setSelectedItem("");
        }

        // update the widget for fontSize style
        Set<Object> fontSizeValues = getStyleValues(styleObjectList, "FontSize");
        if (fontSizeValues == null) {
            // Some style object doesn't support the fontSize style, hide the widget
            getFontSizeSelector().setVisible(false);
        } else if (fontSizeValues.size() == 1) {
            // all of the style objects have the same fontSize value
            getFontSizeSelector().setVisible(true);
            getFontSizeSelector().setSelectedItem(fontSizeValues.iterator().next());
        } else {
            // not all of the style objects have the same fontSize value
            getFontSizeSelector().setVisible(true);
            getFontSizeSelector().setSelectedItem("");
        }

        // update all the widgets in the style panel
        updateWidgets();

        // update the style object list at last
        this.styleObjectList = styleObjectList;
    }

    /**
     * <p>
     * Clears the style object list and updates the panel.
     * </p>
     */
    public void clearStyleObjects() {
        this.styleObjectList = null;
        this.getXTextField().setVisible(false);
        this.getYTextField().setVisible(false);
        this.getWidthTextField().setVisible(false);
        this.getHeightTextField().setVisible(false);
        this.getFillColorButton().setVisible(false);
        this.getOutlineColorButton().setVisible(false);
        this.getTextColorButton().setVisible(false);
        this.getFontFamilySelector().setVisible(false);
        this.getFontSizeSelector().setVisible(false);
        updateWidgets();
    }

    /**
     * <p>
     * Returns an unmodifiable copy of the style object list.
     * </p>
     *
     * @return styleObjectList an unmodifiable copy of the style object list
     */
    public List<StyleObject> getStyleObjectList() {
        return Collections.unmodifiableList(this.styleObjectList);
    }

    /**
     * <p>
     * Returns the key for the height style.
     * </p>
     *
     * @return the key for the height style
     */
    public String getHeightKey() {
        return this.heightKey;
    }

    /**
     * <p>
     * Returns the key for the height style.
     * </p>
     *
     * @return the key for the height style.
     */
    public String getWidthKey() {
        return this.widthKey;
    }

    /**
     * <p>
     * Returns the key for the x style.
     * </p>
     *
     * @return the key for the x style
     */
    public String getXKey() {
        return this.xKey;
    }

    /**
     * <p>
     * Returns the key for the y style.
     * </p>
     *
     * @return the key for the y style.
     */
    public String getYKey() {
        return this.yKey;
    }

    /**
     * <p>
     * Returns the key for the font name style.
     * </p>
     *
     * @return the key for the font name style
     */
    public String getFontNameKey() {
        return this.fontNameKey;
    }

    /**
     * <p>
     * Returns the key for the font size style.
     * </p>
     *
     * @return the key for the font size style
     */
    public String getFontSizeKey() {
        return this.fontSizeKey;
    }

    /**
     * <p>
     * Returns the key for the fill color style.
     * </p>
     *
     * @return the key for the fill color style
     */
    public String getFillColorKey() {
        return this.fillColorKey;
    }

    /**
     * <p>
     * Returns the key for the outline color style.
     * </p>
     *
     * @return the key for the outline color style
     */
    public String getOutlineColorKey() {
        return this.outlineColorKey;
    }

    /**
     * <p>
     * Returns the key for the text color style.
     * </p>
     *
     * @return the key for the text color style
     */
    public String getTextColorKey() {
        return this.textColorKey;
    }

    /**
     * <p>
     * Returns the color chooser for selecting color.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the color chooser for selecting color.
     */
    private JColorChooser getColorChooser() {
        if (colorChooser == null) {
            colorChooser = new JColorChooser();

            // install the color chooser panel
            colorChooser.setChooserPanels(new AbstractColorChooserPanel[] {getColorChooserPanel()});

            // remove preview panel
            colorChooser.setPreviewPanel(new JPanel());
        }

        return colorChooser;
    }

    /**
     * <p>
     * Returns the color selector panel.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the color selector panel.
     */
    private ColorChooserPanel getColorChooserPanel() {
        if (colorChooserPanel == null) {
            colorChooserPanel = new ColorChooserPanel();
        }

        return colorChooserPanel;
    }

    /**
     * <p>
     * Returns the font family selector.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the font family selector.
     *
     * @throws StylePanelConfigurationException if fails to create
     * FontFamilySelector instance with namespace specified
     */
    private FontFamilySelector getFontFamilySelector() {
        if (fontFamilySelector == null) {
            if (this.namespace != null) {
                fontFamilySelector = new FontFamilySelector(this.namespace);
            } else {
                fontFamilySelector = new FontFamilySelector();
            }

            // Add an item listener
            fontFamilySelector.addItemListener(new FontSelectorAdapter(this.fontNameKey, "FontName"));
        }

        return fontFamilySelector;
    }

    /**
     * <p>
     * Returns the font size selector.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the font size selector.
     *
     * @throws StylePanelConfigurationException if fails to create
     * FontSizeSelector instance with namespace specified
     */
    private FontSizeSelector getFontSizeSelector() {
        if (fontSizeSelector == null) {
            if (this.namespace != null) {
                fontSizeSelector = new FontSizeSelector(this.namespace);
            } else {
                fontSizeSelector = new FontSizeSelector();
            }

            fontSizeSelector.addItemListener(new FontSelectorAdapter(this.fontSizeKey, "FontSize"));
        }

        return fontSizeSelector;
    }

    /**
     * <p>
     * Returns the width text field.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the width text field.
     */
    private JTextField getWidthTextField() {
        if (widthTextField == null) {
            widthTextField = new JTextField();

            // key listener and focus listener are installed
            TextFieldAdapter adapter = new TextFieldAdapter(widthTextField, this.widthKey, "Width");
            widthTextField.addKeyListener(adapter);
            widthTextField.addFocusListener(adapter);
        }

        return widthTextField;
    }

    /**
     * <p>
     * Returns the height text field.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the height text field.
     */
    private JTextField getHeightTextField() {
        if (heightTextField == null) {
            heightTextField = new JTextField();

            // key listener and focus listener are installed
            TextFieldAdapter adapter = new TextFieldAdapter(heightTextField, this.heightKey, "Height");
            heightTextField.addKeyListener(adapter);
            heightTextField.addFocusListener(adapter);
        }

        return heightTextField;
    }

    /**
     * <p>
     * Returns the x-position text field.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the x-position text field.
     */
    private JTextField getXTextField() {
        if (xTextField == null) {
            xTextField = new JTextField();

            // key listener and focus listener are installed
            TextFieldAdapter adapter = new TextFieldAdapter(xTextField, this.xKey, "X");
            xTextField.addKeyListener(adapter);
            xTextField.addFocusListener(adapter);
        }

        return xTextField;
    }

    /**
     * <p>
     * Returns the y-position text field.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the y-position text field.
     */
    private JTextField getYTextField() {
        if (yTextField == null) {
            yTextField = new JTextField();

            // key listener and focus listener are installed
            TextFieldAdapter adapter = new TextFieldAdapter(yTextField, this.yKey, "Y");
            yTextField.addKeyListener(adapter);
            yTextField.addFocusListener(adapter);
        }

        return yTextField;
    }

    /**
     * <p>
     * Returns the fill color button.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the fill color button.
     */
    private JButton getFillColorButton() {
        if (fillColorButton == null) {
            fillColorButton = new JButton();
            fillColorButton.setBackground(Color.WHITE);

            // add an action listener
            fillColorButton.addActionListener(new ColorButtonActionListener(fillColorButton, this.fillColorKey));
        }
        return fillColorButton;
    }

    /**
     * <p>
     * Returns the outline color button.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the outline color button.
     */
    private JButton getOutlineColorButton() {
        if (outlineColorButton == null) {
            outlineColorButton = new JButton();
            outlineColorButton.setBackground(Color.WHITE);

            // add an action listener
            outlineColorButton.addActionListener(
                new ColorButtonActionListener(outlineColorButton, this.outlineColorKey));
        }

        return outlineColorButton;
    }

    /**
     * <p>
     * Returns the text color button.
     * </p>
     *
     * <p>
     * Note, if it is not created and it will be created and returned.
     * </p>
     *
     * @return the text color button.
     */
    private JButton getTextColorButton() {
        if (textColorButton == null) {
            textColorButton = new JButton();
            textColorButton.setBackground(Color.WHITE);

            // add an action listener
            textColorButton.addActionListener(new ColorButtonActionListener(textColorButton, this.textColorKey));
        }
        return textColorButton;
    }

    /**
     * <p>
     * Initializes the style panel.
     * </p>
     *
     * <p>
     * There are five components installed:
     * <ol>
     * <li>size panel - which owns x-position, y-position, width and height text fields</li>
     * <li>separator</li>
     * <li>color panel - which owns fill color, outline color and text color buttons</li>
     * <li>separator</li>
     * <li>font panel - which owns font name and font size selectors</li>
     * </ol>
     * </p>
     * <p>
     * v1.1 Change Note: layout is changed as the prototype. And a new horizontal layout is provided.
     * </p>
     * @version 1.1
     * @since 1.0
     */
    private void initialize() {
		//change keyboard action keybindings to be more Mac OS X like
		if(System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
			com.topcoder.macosx.MacInputMap.setDefaultInputMap(
				javax.swing.UIManager.getDefaults());
		}

        this.setLayout(new GridBagLayout());

        JPanel sizePanel = getSizePanel();
        JPanel colorPanel = getColorPanel();
        JPanel fontPanel = getFontPanel();

        // add sub-panels
        if (horizontalLayout) {
            addPanels(new JPanel[] { fontPanel, sizePanel, colorPanel });
        } else {
            addPanels(new JPanel[] { sizePanel, colorPanel, fontPanel });
        }

        // set the minimum size, preferred size and font
        this.setMinimumSize(new Dimension(this.minimumWidth, this.minimumHeight));
        this.setPreferredSize(new Dimension(this.preferredWidth, this.preferredHeight));
        setFont(new Font(fontName, Font.PLAIN, 9));

    }

    /**
     * <p>
     * Returns the font panel.
     * </p>
     * <p>
     * The font panel contains font name and font size selectors.
     * </p>
     * <p>
     * v1.1 Change Note: layout is changed as the prototype. And a new horizontal layout is provided.
     * </p>
     *
     * @return the font panel.
     * @version 1.1
     * @since 1.0
     */
    private JPanel getFontPanel() {

        JPanel fontPanel = new JPanel();
        setFixedSize(fontPanel, 185, 50);
        fontPanel.setLayout(new GridBagLayout());

        // label for font name selector
        JLabel fontLabel = new JLabel("Fonts:", JLabel.LEADING);

        // label for font size selector
        JLabel sizeLabel = new JLabel("Size:", JLabel.LEADING);

        FontFamilySelector fontSelector = this.getFontFamilySelector();
        setFixedSize(fontSelector, 112, 20);
        fontLabel.setLabelFor(fontSelector);

        FontSizeSelector sizeSelector = this.getFontSizeSelector();
        setFixedSize(sizeSelector, 52, 20);
        sizeLabel.setLabelFor(sizeSelector);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 0, 2, 3);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        fontPanel.add(fontLabel, constraints);
        constraints.gridx = 1;
        fontPanel.add(sizeLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        fontPanel.add(fontSelector, constraints);
        constraints.gridx = 1;
        fontPanel.add(sizeSelector, constraints);

        constraints.gridx = 2;
        fontPanel.add(new JLabel("px", JLabel.LEADING), constraints);
        addEmptyPanel(fontPanel, 1, 3);

        return fontPanel;
    }

    /**
     * <p>
     * Returns the color panel.
     * </p>
     *
     * <p>
     * The color panel contains fill color, outline color and text color buttons.
     * </p>
     *
     * <p>
     * v1.1 Change Note: layout is changed as the prototype. And a new horizontal layout is provided.
     * </p>
     *
     * @return the color panel.
     * @version 1.1
     * @since 1.0
     */
    private JPanel getColorPanel() {

        JPanel colorPanel = new JPanel();
        setFixedSize(colorPanel, this.horizontalLayout ? 120 : 185, this.horizontalLayout ? 50 : 30);
        colorPanel.setLayout(new GridBagLayout());

        // label for fill color button
        JButton fillButton = getFillColorButton();
        setFixedSize(fillButton, 20, 20);
        JLabel fillColorLabel = new JLabel("Fill:", JLabel.TRAILING);
        fillColorLabel.setLabelFor(fillButton);

        // label for outline color button
        JButton outlineButton = getOutlineColorButton();
        setFixedSize(outlineButton, 20, 20);
        JLabel outlineColorLabel = new JLabel("Outline:", JLabel.TRAILING);
        outlineColorLabel.setLabelFor(outlineButton);

        // label for text color button
        JButton textButton = getTextColorButton();
        setFixedSize(textButton, 20, 20);
        JLabel textColorLabel = new JLabel("Text:", JLabel.TRAILING);
        textColorLabel.setLabelFor(textButton);

        // add the sub-panels
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 0, 2, 2);
        constraints.anchor = GridBagConstraints.CENTER;
        colorPanel.add(fillColorLabel, constraints);
        setNextColorItemPosition(constraints);
        colorPanel.add(outlineColorLabel, constraints);
        setNextColorItemPosition(constraints);
        colorPanel.add(textColorLabel, constraints);

        if (horizontalLayout) {
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.insets = new Insets(2, 10, 2, 10);

        } else {
            constraints.gridx = 1;
            constraints.insets = new Insets(2, 0, 2, 13);
        }
        colorPanel.add(fillButton, constraints);
        setNextColorItemPosition(constraints);
        colorPanel.add(outlineButton, constraints);
        setNextColorItemPosition(constraints);
        if (!horizontalLayout) {
            constraints.insets = new Insets(2, 0, 2, 0);
        }
        colorPanel.add(textButton, constraints);

        // add empty JPanel to take the extra space when resizing
        if (!horizontalLayout) {
            addEmptyPanel(colorPanel, 1, 4);
        } else {
            addEmptyPanel(colorPanel, 0, 6);
        }



        return colorPanel;
    }

    /**
     * <p>
     * Returns the size panel.
     * </p>
     *
     * <p>
     * The size panel contains x-position, y-position, width and height text fields.
     * </p>
     *
     * <p>
     * v1.1 Change Note: layout is changed as the prototype. And a new horizontal layout is provided.
     * </p>
     *
     * @return the size panel.
     * @version 1.1
     * @since 1.0
     */
    private JPanel getSizePanel() {

        JPanel sizePanel = new JPanel();
        setFixedSize(sizePanel, this.horizontalLayout ? 160 : 185, 50);
        sizePanel.setLayout(new GridBagLayout());

        JTextField xField = this.getXTextField();
        setFixedSize(xField, this.horizontalLayout ? 54 : 68, 20);
        // label for x-position text field
        JLabel xLabel = new JLabel("X:", JLabel.TRAILING);
        xLabel.setLabelFor(xField);

        JTextField yField = this.getYTextField();
        setFixedSize(yField, this.horizontalLayout ? 54 : 68, 20);

        // label for y-position text field
        JLabel yLabel = new JLabel("Y:", JLabel.TRAILING);
        yLabel.setLabelFor(yField);

        JTextField widthField = this.getWidthTextField();

        // label for width text field
        JLabel widthLabel = new JLabel("W:", JLabel.TRAILING);
        widthLabel.setLabelFor(widthField);
        setFixedSize(widthField, this.horizontalLayout ? 54 : 68, 20);

        JTextField heightField = this.getHeightTextField();

        // label for height text field
        JLabel heightLabel = new JLabel("H:", JLabel.TRAILING);
        heightLabel.setLabelFor(heightField);
        setFixedSize(heightField, this.horizontalLayout ? 54 : 68, 20);

        // add the sub-panels
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 0, 2, 4);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        sizePanel.add(xLabel, constraints);
        constraints.gridy = 1;
        sizePanel.add(yLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 0, 2, 12);
        sizePanel.add(xField, constraints);
        constraints.gridy = 1;
        sizePanel.add(yField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 0, 2, 4);
        sizePanel.add(widthLabel, constraints);
        constraints.gridy = 1;
        sizePanel.add(heightLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 0, 2, 0);
        sizePanel.add(widthField, constraints);
        constraints.gridy = 1;
        sizePanel.add(heightField, constraints);

        // add empty JPanel to take the extra space when resizing
        addEmptyPanel(sizePanel, 1, 4);

        return sizePanel;
    }

    /**
     * <p>
     * The frame where the color chooser is located.
     * </p>
     *
     * <p>
     * This frame will be responsible for setting the user selected color to the corresponding
     * color button.
     * </p>
     *
     * <p>
     * This frame will be hidden when it is inactive or user selects a color.
     * </p>
     *
     * @return the frame where the color chooser is located.
     */
    private JFrame getColorChooserFrame() {
        if (colorChooserFrame == null) {
            colorChooserFrame = new JFrame();
            colorChooserFrame.getContentPane().setLayout(new BorderLayout());
            colorChooserFrame.setState(Frame.NORMAL);
            colorChooserFrame.getContentPane().add(getColorChooser(), BorderLayout.CENTER);

            // add the window listener to handle the de-activated message
            colorChooserFrame.addWindowListener(new WindowAdapter() {
                /**
                 * <p>
                 * Handles the window de-activated message.
                 * </p>
                 *
                 * <p>
                 * The color chooser frame will be hidden once it is inactivate.
                 * </p>
                 *
                 * @param e the window event that indicates that a window has changed its status
                 */
                public void windowDeactivated(WindowEvent e) {
                    colorChooserFrame.setVisible(false);
                }

            });

            colorChooserFrame.setUndecorated(true);
            colorChooserFrame.pack();
        }

        return colorChooserFrame;
    }

    /**
     * <p>
     * Updates the visible property of all the widgets in the style panel.
     * </p>
     *
     * <p>
     * This method is invoked by setStyleObjectList() method.
     * </p>
     */
    private void updateWidgets() {
        boolean xTextFieldVisible = this.getXTextField().isVisible();
        boolean yTextFieldVisible = this.getYTextField().isVisible();
        boolean widthTextFieldVisible = this.getWidthTextField().isVisible();
        boolean heightTextFieldVisible = this.getHeightTextField().isVisible();
        boolean fillColorVisible = this.getFillColorButton().isVisible();
        boolean outlineColorVisible = this.getOutlineColorButton().isVisible();
        boolean textColorVisible = this.getTextColorButton().isVisible();
        boolean fontNameVisible = this.getFontFamilySelector().isVisible();
        boolean fontSizeVisible = this.getFontSizeSelector().isVisible();

        Container sizePanel = (Container) this.getComponent(horizontalLayout ? 2 : 0);
        Component separator1 = this.getComponent(1);
        Container colorPanel = (Container) this.getComponent(horizontalLayout ? 4 : 2);
        Component separator2 = this.getComponent(3);
        Container fontPanel = (Container) this.getComponent(horizontalLayout ? 0 : 4);

        // for size panel
        // label for x-position text field
        sizePanel.getComponent(0).setVisible(xTextFieldVisible);
        // label for y-position text field
        sizePanel.getComponent(1).setVisible(yTextFieldVisible);
        // label for width text field
        sizePanel.getComponent(4).setVisible(widthTextFieldVisible);
        // label for height text field
        sizePanel.getComponent(5).setVisible(heightTextFieldVisible);

        boolean sizePanelVisible = xTextFieldVisible || yTextFieldVisible || widthTextFieldVisible
            || heightTextFieldVisible;
        sizePanel.setVisible(sizePanelVisible);

        // for color panel
        // label for fill color button
        colorPanel.getComponent(0).setVisible(fillColorVisible);
        // label for outline color button
        colorPanel.getComponent(1).setVisible(outlineColorVisible);
        // label for text color button
        colorPanel.getComponent(2).setVisible(textColorVisible);


        boolean colorPanelVisible = fillColorVisible || outlineColorVisible || textColorVisible;
        colorPanel.setVisible(colorPanelVisible);

        // for font panel
        // label for font name selector
        fontPanel.getComponent(0).setVisible(fontNameVisible);
        // label for font size selector
        fontPanel.getComponent(1).setVisible(fontSizeVisible);
        // "px" label for font size selector
        if (fontPanel.getComponentCount() > 4) {
            fontPanel.getComponent(4).setVisible(fontSizeVisible);
        }

        boolean fontPanelVisible = fontNameVisible || fontSizeVisible;
		fontPanel.setVisible(fontPanelVisible);

        separator1.setVisible(this.getComponent(0).isVisible()
                && (this.getComponent(2).isVisible() || this.getComponent(4).isVisible()));
        separator2.setVisible(this.getComponent(2).isVisible() && this.getComponent(4).isVisible());

    }

    /**
     * <p>
     * Sets the font used in the component.
     * </p>
     *
     * <p>
     * Note, the font property for all the widgets in the style panel will
     * be updated.
     * </p>
     *
     * @param font the font to be set
     *
     * @throws IllegalArgumentException if font is null
     */
    public void setFont(Font font) {
        Util.checkNull(font, "font");

        this.font = font;
        updateFont(this, font);
    }

    /**
     * <p>
     * Updates the font property for all the child components in the given container.
     * </p>
     *
     * <p>
     * Note, if the child component is a container, then the font property for the child
     * components of the sub-container will be updated too.
     * This is done recursively.
     * </p>
     *
     * @param container the parent component
     * @param font the new font instance to apply
     */
    private void updateFont(Container container, Font font) {
        // update each child component
        for (Component component : container.getComponents()) {
            component.setFont(font);

            // recursively update the child component of sub Container
            if (component instanceof Container) {
                updateFont((Container) component, font);
            }
        }
    }

    /**
     * <p>
     * Sets the font family style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the current font name is modified.
     * </p>
     *
     * @param fontFamily the new font family name to update
     *
     * @throws StyleNotSupportedException if the font family selector is invisible
     * @throws IllegalArgumentException if fontFamily is null or is an empty string
     */
    public void setFontFamilyStyle(String fontFamily) {
        Util.checkString(fontFamily, "fontFamily");

        // The font name is not supported
        if (!getFontFamilySelector().isVisible()) {
            throw new StyleNotSupportedException("The font family style is not supported.");
        }

        String oldValue = (String) getFontFamilySelector().getSelectedItem();

        // check the current font name and the new font name
        // if equal, then nothing will be done
        if (fontFamily.equals(oldValue)) {
            return;
        }

        getFontFamilySelector().setSelectedItem(fontFamily);
    }

    /**
     * <p>
     * Sets the font size style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the current font size is modified.
     * </p>
     *
     * @param fontSize the new font size to update
     *
     * @throws StyleNotSupportedException if the font size selector is invisible
     * @throws IllegalArgumentException if fontSize is non-positive
     */
    public void setFontSizeStyle(int fontSize) {
        if (fontSize <= 0) {
            throw new IllegalArgumentException("The given font size is non-positive, its value is " + fontSize);
        }

        // font size style is not supported
        if (!getFontSizeSelector().isVisible()) {
            throw new StyleNotSupportedException("The font size style is not supported.");
        }

        int oldValue = (Integer) getFontSizeSelector().getSelectedItem();
        // check the current font size and the new font size
        // if equal, then nothing will be done
        if (oldValue == fontSize) {
            return;
        }

        getFontSizeSelector().setSelectedItem(fontSize);
    }

    /**
     * <p>
     * Sets the fill color style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the current fill color is modified.
     * </p>
     *
     * @param fillColor the new fill color to update
     *
     * @throws StyleNotSupportedException if the fill color button is invisible
     * @throws IllegalArgumentException if fillColor is null
     */
    public void setFillColorStyle(Color fillColor) {
        Util.checkNull(fillColor, "fillColor");

        // fill color style is not supported
        if (!getFillColorButton().isVisible()) {
            throw new StyleNotSupportedException("The fill color style is not supported.");
        }

        Color oldValue = getFillColorButton().getBackground();
        // check the current fill color and the new fill color
        // if equal, then nothing will be done
        if (oldValue.equals(fillColor)) {
            return;
        }

        getFillColorButton().setBackground(fillColor);
        propertyChanged(this.fillColorKey, Util.convertColor(oldValue), Util.convertColor(fillColor), "FillColor");
    }

    /**
     * <p>
     * Sets the outline color style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the current fill color is modified.
     * </p>
     *
     * @param outlineColor the new outline color to update
     *
     * @throws StyleNotSupportedException if the outline color button is invisible
     * @throws IllegalArgumentException if outlineColor is null
     */
    public void setOutlineColorStyle(Color outlineColor) {
        Util.checkNull(outlineColor, "outlineColor");

        // outline color style is not supported
        if (!getOutlineColorButton().isVisible()) {
            throw new StyleNotSupportedException("The outline color style is not supported.");
        }

        Color oldValue = getOutlineColorButton().getBackground();
        // check the current outline color and the new outline color
        // if equal, then nothing will be done
        if (oldValue.equals(outlineColor)) {
            return;
        }

        getOutlineColorButton().setBackground(outlineColor);
        propertyChanged(this.outlineColorKey, Util.convertColor(oldValue), Util.convertColor(outlineColor),
            "OutlineColor");
    }

    /**
     * <p>
     * Sets the text color style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the current text color is modified.
     * </p>
     *
     * @param textColor the new outline color to update
     *
     * @throws StyleNotSupportedException if the text color button is invisible
     * @throws IllegalArgumentException if textColor is null
     */
    public void setTextColorStyle(Color textColor) {
        Util.checkNull(textColor, "textColor");

        // text color style is not supported
        if (!getTextColorButton().isVisible()) {
            throw new StyleNotSupportedException("The text color style is not supported.");
        }

        Color oldValue = getTextColorButton().getBackground();
        // check the current text color and the new text color
        // if equal, then nothing will be done
        if (oldValue.equals(textColor)) {
            return;
        }

        getTextColorButton().setBackground(textColor);
        propertyChanged(this.textColorKey, Util.convertColor(oldValue), Util.convertColor(textColor), "TextColor");
    }

    /**
     * <p>
     * Sets the position style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the x-position or y-position is modified.
     * </p>
     *
     * @param position the new position to update
     *
     * @throws StyleNotSupportedException if the x-position text field or y-position text field is invisible
     * @throws IllegalArgumentException if position is null, or the x-value or y-value for the position is
     * non-positive
     */
    public void setPositionStyle(Point position) {
        Util.checkNull(position, "position");
        if (position.getX() <= 0) {
            throw new IllegalArgumentException("The x coordinate is non-positive, its value is " + position.getX());
        }
        if (position.getY() <= 0) {
            throw new IllegalArgumentException("The y coordinate is non-positive, its value is " + position.getY());
        }

        // the x-position style is not supported
        if (!getXTextField().isVisible()) {
            throw new StyleNotSupportedException("The x-position style is not supported.");
        }

        // the y-position style is not supported
        if (!getYTextField().isVisible()) {
            throw new StyleNotSupportedException("The y-position style is not supported.");
        }

        String xOldValue = getXTextField().getText();
        String xNewValue = String.valueOf(position.getX());
        // check the current x-position value and the new x-position value
        // if equal, then nothing will be done
        // otherwise, update the current value and notify the listener
        if (!xNewValue.equals(xOldValue)) {
            getXTextField().setText(xNewValue);
            propertyChanged(this.xKey, xOldValue, xNewValue, "X");
        }

        String yOldValue = getYTextField().getText();
        String yNewValue = String.valueOf(position.getY());
        // check the current y-position value and the new y-position value
        // if equal, then nothing will be done
        // otherwise, update the current value and notify the listener
        if (!yNewValue.equals(yOldValue)) {
            getYTextField().setText(yNewValue);
            propertyChanged(this.yKey, yOldValue, yNewValue, "Y");
        }
    }

    /**
     * <p>
     * Sets the dimension style.
     * </p>
     *
     * <p>
     * This method will notifies the listeners if the width or height is modified.
     * </p>
     *
     * @param size the new size to update
     *
     * @throws StyleNotSupportedException if the width text field or height text field is invisible
     * @throws IllegalArgumentException if size is null, or the width or height for the size is
     * non-positive
     */
    public void setSizeStyle(Dimension size) {
        Util.checkNull(size, "size");
        if (size.getWidth() <= 0) {
            throw new IllegalArgumentException("The width is non-positive, its value is " + size.getWidth());
        }
        if (size.getHeight() <= 0) {
            throw new IllegalArgumentException("The height is non-positive, its value is " + size.getHeight());
        }

        // the width style is not supported
        if (!getWidthTextField().isVisible()) {
            throw new StyleNotSupportedException("The width size style is not supported.");
        }

        // the height style is not supported
        if (!getHeightTextField().isVisible()) {
            throw new StyleNotSupportedException("The height size style is not supported.");
        }

        String widthOldValue = getWidthTextField().getText();
        String widthNewValue = String.valueOf(size.getWidth());
        // check the current width value and the new width value
        // if equal, then nothing will be done
        // otherwise, update the current value and notify the listener
        if (!widthNewValue.equals(widthOldValue)) {
            getWidthTextField().setText(widthNewValue);
            propertyChanged(this.widthKey, widthOldValue, widthNewValue, "Width");
        }

        String heightOldValue = getHeightTextField().getText();
        String heightNewValue = String.valueOf(size.getHeight());
        // check the current height value and the new height value
        // if equal, then nothing will be done
        // otherwise, update the current value and notify the listener
        if (!heightNewValue.equals(heightOldValue)) {
            getHeightTextField().setText(heightNewValue);
            propertyChanged(this.heightKey, heightOldValue, heightNewValue, "Height");
        }
    }

    /**
     * <p>
     * This class implements ItemListener interface.
     * </p>
     *
     * <p>
     * This class is used for the font name and font size selector.
     * </p>
     *
     * <p>
     * Select Item and de-select item messages are caught and handled in this class.
     * </p>
     *
     * <p>
     * Thread Safety : This class is mutable and so is not thread safe.
     * </p>
     *
     * @author TCSDEVELOPRE
     * @version 1.0
     */
    private class FontSelectorAdapter implements ItemListener {
        /**
         * <p>
         * Represents the key for the style.
         * </p>
         *
         * <p>
         * The style may be font name style or font size style.
         * </p>
         */
        private final String propKey;

        /**
         * <p>
         * Represents the style name.
         * </p>
         *
         * <p>
         * The style may be font name style or font size style.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final String styleName;

        /**
         * <p>
         * The old value for the font name selector or font size selector.
         * </p>
         *
         * <p>
         * This variable is used to construct a StyleEvent instance.
         * </p>
         */
        private Object oldValue;

        /**
         * <p>
         * Constructs a FontSelectorAdapter with key specified.
         * </p>
         *
         * @param propKey the key for the style, the style may be font name or font size.
         * @param styleName the name of the style
         */
        public FontSelectorAdapter(String propKey, String styleName) {
            this.propKey = propKey;
            this.styleName = styleName;
        }

        /**
         * <p>
         * This method handles the item state changed message for font name selector or font size selector.
         * </p>
         *
         * <p>
         * When an item is de-selected, the value is saved as old value, when an item is selected, the value
         * is saved as new value and a style event will be sent out to notify all the listeners.
         * </p>
         *
         * @param e an item event that indicates that an item was selected or de-selected
         */
        public void itemStateChanged(ItemEvent e) {
            // save the old value
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                oldValue = e.getItem();
            }

            // notify all the listeners
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object newValue = e.getItem();

                if (newValue instanceof String) {
                    String value = (String) newValue;
                    // the empty font name or font size, do nothing here
                    if (value.length() == 0) {
                        return;
                    }
                }

                propertyChanged(propKey, oldValue.toString(), newValue.toString(), styleName);
            }
        }
    }

    /**
     * <p>
     * This class implements ActionListener interface.
     * </p>
     *
     * <p>
     * This class is used for the fill color, outline color and text color buttons.
     * </p>
     *
     * <p>
     * This class will handle the event when the color button is clicked.
     * </p>
     *
     * <p>
     * Thread Safety : This class is mutable and so is not thread safe.
     * </p>
     *
     * @author TCSDEVELOPRE
     * @version 1.0
     */
    private class ColorButtonActionListener implements ActionListener {
        /**
         * <p>
         * Represents the color button that this listener handles its click event.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final JButton colorButton;

        /**
         * <p>
         * Represents the key for the style.
         * </p>
         *
         * <p>
         * The style may be fill color, outline color and text color.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final String propKey;

        /**
         * <p>
         * Constructs a ColorButtonActionListener with color button and key specified.
         * </p>
         *
         * @param colorButton the color button that this listener handles its click event
         * @param propKey the key for the style, the style may be fill color, outline color and text color
         */
        public ColorButtonActionListener(JButton colorButton, String propKey) {
            this.colorButton = colorButton;
            this.propKey = propKey;
        }

        /**
         * <p>
         * This method handles the button-click event for fill color, outline color or text color button.
         * </p>
         *
         * <p>
         * When the button is clicked, the color chooser frame will be shown for selecting color.
         * </p>
         *
         * @param e an action event that indicates the button is clicked
         */
        public void actionPerformed(ActionEvent e) {
            // handle the case that the color chooser frame is visible
            if (getColorChooserFrame().isVisible()) {
                removeAllComponentListener();
            }

            // update the color for the color chooser according to color button
            getColorChooser().setColor(colorButton.getBackground());

            // set the location of the color chooser frame
            Point point = new Point(colorButton.getLocationOnScreen());
            getColorChooserFrame().setLocation(point.x, point.y + colorButton.getHeight());

            // add a ComponentListener
            getColorChooserFrame().addComponentListener(new ColorChooserFrameComponentAdapter(colorButton, propKey));

            // show it
            getColorChooserFrame().setVisible(true);
        }
    }

    /**
     * <p>
     * This class extends ComponentAdapter class and so implements ComponentListener.
     * </p>
     *
     * <p>
     * This class is used for the fill color, outline color and text color buttons.
     * </p>
     *
     * <p>
     * This class will handle the event when the color chooser is hidden and then
     * update the new color for the color button.
     * </p>
     *
     * <p>
     * Thread Safety : This class is mutable and so is not thread safe.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class ColorChooserFrameComponentAdapter extends ComponentAdapter {
        /**
         * <p>
         * Represents the color button that this listener will update its color.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final JButton colorButton;

        /**
         * <p>
         * Represents the key for the style.
         * </p>
         *
         * <p>
         * The style may be fill color, outline color and text color.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final String propKey;

        /**
         * <p>
         * Constructs a ColorChooserFrameComponentAdapter with color button and key specified.
         * </p>
         *
         * @param colorButton the color button that this listener updates its color
         * @param propKey the key for the style, the style may be fill color, outline color and text color
         */
        public ColorChooserFrameComponentAdapter(JButton colorButton, String propKey) {
            this.colorButton = colorButton;
            this.propKey = propKey;
        }

        /**
         * <p>
         * Handles the component hidden event.
         * </p>
         *
         * <p>
         * When the component is hidden, the current color of the color button will be updated.
         * </p>
         *
         * @param e a component event that indicates that a component moved, changed size, or
         * changed visibility
         */
        public void componentHidden(ComponentEvent e) {
            Color oldColor = colorButton.getBackground();
            Color newColor = getColorChooser().getColor();

            // notify the listeners when the color is changed
            if (!newColor.equals(oldColor)) {
                colorButton.setBackground(newColor);

                propertyChanged(propKey, Util.convertColor(oldColor), Util.convertColor(newColor), null);
            }

            // all of the component listener for the color chooser frame will be remove
            // this is because the color chooser frame is re-used by all the three color buttons
            removeAllComponentListener();
        }
    }

    /**
     * <p>
     * This class extends KeyAdapter class and so implements KeyListener.
     * Besides, it implements FocusListener as well.
     * </p>
     *
     * <p>
     * This class is used for the x-position, y-position, width and height text fields.
     * </p>
     *
     * <p>
     * This class will handle the events when <b>Enter</b> key is entered or the text
     * field gains or lose focus.
     * </p>
     *
     * <p>
     * Thread Safety : This class is mutable and so is not thread safe.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class TextFieldAdapter extends KeyAdapter implements FocusListener {
        /**
         * <p>
         * Represents the key for the style.
         * </p>
         *
         * <p>
         * The style may be x-position, y-position, width and height.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final String propKey;

        /**
         * <p>
         * Represents the style name.
         * </p>
         *
         * <p>
         * The style may be x-position, y-position, width and height.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final String styleName;

        /**
         * <p>
         * Represents the text filed that this listener will handle its key and focus events.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private final JTextField textField;

        /**
         * <p>
         * Represents the old value before the text of the text field is changed.
         * </p>
         *
         * <p>
         * Note, the old text value is got when the text field gains focus.
         * </p>
         *
         * <p>
         * It is immutable.
         * </p>
         */
        private String oldText;

        /**
         * <p>
         * Constructs a TextFieldAdapter with text field and key specified.
         * </p>
         *
         * @param textField the text field that this listener handle its key and focus events.
         * @param propKey the key for the style, the style may be x-position, y-position, width and height.
         * @param styleName the name of the style
         */
        public TextFieldAdapter(JTextField textField, String propKey, String styleName) {
            this.textField = textField;
            this.propKey = propKey;
            this.styleName = styleName;
        }

        /**
         * <p>
         * Handles the key event.
         * </p>
         *
         * <p>
         * This method will handle the case when "Enter" key is pressed.
         * If that's the case, the text of the text field will be updated.
         * </p>
         *
         * @param e An event which indicates that a keystroke occurred in a component
         */
        public void keyPressed(KeyEvent e) {
            // Only handle the case when "Enter" key is pressed
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                updateText();
            }
        }

        /**
         * <p>
         * Handles the event when focus is gained by the text field.
         * </p>
         *
         * <p>
         * This method will save the text of the text field as the old text value
         * </p>
         *
         * @param e An event that indicates that a Component has gained or lost the input focus
         */
        public void focusGained(FocusEvent e) {
            oldText = textField.getText();
        }

        /**
         * <p>
         * Handles the event when focus is lost by the text field.
         * </p>
         *
         * <p>
         * If the new text value is valid then the listeners will be notified, otherwise the
         * new text value will be dropped and old text value will be used.
         * </p>
         *
         * @param e An event that indicates that a Component has gained or lost the input focus
         */
        public void focusLost(FocusEvent e) {
            updateText();
        }

        /**
         * <p>
         * Updates the text for the text field.
         * </p>
         *
         * <p>
         * If the new text value is valid then the listeners will be notified, otherwise the
         * new text value will be dropped and old text value will be used.
         * </p>
         *
         */
        private void updateText() {
            String newText = textField.getText();

            // the text is not changed, do nothing
            if (newText == null || newText.equals(oldText)) {
                return;
            }

            try {
                // valid new text value
                Double.parseDouble(newText);
                propertyChanged(propKey, oldText, newText, styleName);
                oldText = textField.getText();
            } catch (NumberFormatException e) {
                // invalid new text value
                textField.setText(oldText);
            }
        }

    }

    /**
     * <p>
     * This method removes all the component listeners for the color chooser frame.
     * </p>
     *
     * <p>
     * This is done because the color chooser frame is re-used by the three color buttons,
     * in order to update the button color correctly, the component listeners should
     * be removed each time the color chooser frame is hidden.
     * </p>
     */
    private void removeAllComponentListener() {
        JFrame frame = getColorChooserFrame();
        ComponentListener[] listeners = frame.getComponentListeners();
        for (ComponentListener listener : listeners) {
            frame.removeComponentListener(listener);
        }
    }

    /**
     * <p>
     * When a style is changed, this method is used to notify all the listeners for the
     * changed style.
     * </p>
     *
     * @param changedKey the key of the style
     * @param oldValue the old value for the style
     * @param newValue the new value for the style
     * @param styleName the name of the style
     */
    private void propertyChanged(String changedKey, String oldValue, String newValue, String styleName) {
        for (StyleObject styleObject : this.styleObjectList) {
            if (oldValue.trim().length() == 0) {
                try {
                    // get the style value of the style object using reflection
                    Method method = StyleObject.class.getMethod("get" + styleName, (Class[]) null);

                    // get the original value
                    oldValue = method.invoke(styleObject, (Object[]) null).toString();

                } catch (SecurityException e) {
                    // ignore, it won't happen in this method
                } catch (NoSuchMethodException e) {
                    // ignore, it won't happen in this method
                } catch (IllegalArgumentException e) {
                    // ignore, it won't happen in this method
                } catch (IllegalAccessException e) {
                    // ignore, it won't happen in this method
                } catch (InvocationTargetException e) {
                    // ignore, it won't happen in this method
                }
            }

            StyleEvent event = new StyleEvent(styleObject, changedKey, oldValue, newValue);
            this.fireStyleChanged(event);
        }
    }

    /**
     * <p>
     * This method returns all the values of the style object list for the given style.
     * </p>
     *
     * <p>
     * Note, the return value may be null. If that's the case, then the style may be not
     * supported by some style object in the current style object list.
     * </p>
     *
     * @param styleObjectList the style object list
     * @param style the style name, it may be <b>X</b>, <b>Y</b>, <b>Width</b>, <b>Height</b>,
     * <b>FillColor</b>, <b>OutlineColor</b>, <b>TextColor</b>, <b>FontName</b> and <b>FontSize</b>.
     *
     * @return all the values of the style object list for the given style, null may be returned
     * to identify the style is not supported by some style object
     */
    private Set<Object> getStyleValues(List<StyleObject> styleObjectList, String style) {
        try {
            Set<Object> result = new HashSet<Object>();

            // get the getter method using reflection
            Method method = StyleObject.class.getMethod("get" + style, (Class[]) null);

            // execute the getter method in order to get the style value
            for (StyleObject styleObject : styleObjectList) {
                result.add(method.invoke(styleObject, (Object[]) null));
            }

            return result;
        } catch (SecurityException e) {
            // the style is not supported
            return null;
        } catch (NoSuchMethodException e) {
            // the style is not supported
            return null;
        } catch (IllegalArgumentException e) {
            // the style is not supported
            return null;
        } catch (IllegalAccessException e) {
            // the style is not supported
            return null;
        } catch (InvocationTargetException e) {
            // the style is not supported
            return null;
        }
    }

    /**
     * <p>
     * Get the integer property value from the given map instance.
     * </p>
     *
     * @param looknfeelMap the mapping containing the configuration properties under the
     * <b>looknfeel</b> property
     * @param propName the property name, used as a key to get the value
     * @param defaultValue the default value if the property is missing
     *
     * @return the value of the property name in integer representations
     *
     * @throws StylePanelConfigurationException if there is an invalid configuration
     */
    private int getIntegerProperty(Map<String, String> looknfeelMap, String propName, int defaultValue) {
        if (looknfeelMap.containsKey(propName)) {
            return Util.convertInteger(looknfeelMap.get(propName), propName);
        } else {
            return defaultValue;
        }
    }

    /**
     * <p>
     * Set the fixed size to given component.
     * </p>
     * @param component the component to set
     * @param width the fixed width
     * @param height the fixed height
     */
    private void setFixedSize(JComponent component, int width, int height) {
        Dimension size = new Dimension(width, height);
        component.setMaximumSize(size);
        component.setMinimumSize(size);
        component.setPreferredSize(size);
    }

    /**
     * <p>
     * Add given panels to this style panel.
     * panels will be placed vertically or horizontally based on horizontalLayout flag.
     * </p>
     *
     * @param panels the panels to add
     * @since 1.1
     */
    private void addPanels(JPanel[] panels) {

        // create the layout constraints
        // All elements will be placed at the upper-left corner
        // and cannot be resized.
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        boolean first = true;
        for (JPanel panel : panels) {
            // add a separator between panels
            if (first) {
                first = false;
            } else {
                JSeparator separator = null;
                if (horizontalLayout) {
                    separator = new JSeparator(SwingConstants.VERTICAL);
                    setFixedSize(separator, 1, 50);
                } else {
                    separator = new JSeparator(SwingConstants.HORIZONTAL);
                    setFixedSize(separator, 186, 1);
                }
                separator.setBorder(BorderFactory.createLineBorder(Color.gray));
                add(separator, constraints);
                setNextGridPosition(constraints);
            }

            // add the panel
            add(panel, constraints);
            setNextGridPosition(constraints);
        }
        // add empty JPanel to take the extra space when resizing
        addEmptyPanel(this, constraints.gridx, constraints.gridy);
    }

    /**
     * <p>
     * Set the position for next grid item in given constraints.
     * </p>
     *
     * @param constraints the constraints containing position info
     * @since 1.1
     */
    private void setNextGridPosition(GridBagConstraints constraints) {
        if (horizontalLayout) {
            ++constraints.gridx;
        } else {
            ++constraints.gridy;
        }
    }

    /**
     * <p>
     * Set the position for next color item in given constraints.
     * </p>
     *
     * @param constraints the constraints containing position info
     * @since 1.1
     */
    private void setNextColorItemPosition(GridBagConstraints constraints) {
        if (horizontalLayout) {
            ++constraints.gridx;
        } else {
            constraints.gridx += 2;
        }
    }

    /**
     * Add a empty panel that take extra space when resizing.
     *
     * @param panel the panel to add
     * @param x the x position;
     * @param y the y position
     */
    private void addEmptyPanel(JPanel panel, int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = x;
        constraints.gridy = y;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(new JPanel(), constraints);
    }

}
