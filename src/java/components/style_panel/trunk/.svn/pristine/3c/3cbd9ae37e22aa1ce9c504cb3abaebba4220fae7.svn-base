/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JComboBox;

/**
 * <p>
 * This class extends JComboBox and acts as the widget for font size selection.
 * </p>
 *
 * <p>
 * The font sizes are customizable but a default is also provided.
 * </p>
 *
 * <p>
 * Thread safety: The JComboBox is not thread safe, but since all of operation will
 * be done in event-dispatching thread, there is no needs to worry.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class FontSizeSelector extends JComboBox {
    /**
     * <p>
     * Represents the default font size.
     * </p>
     */
    private static final int DEFAULT_SELECTED_FONT_SIZE = 10;

    /**
     * <p>
     * Represents the default font size list to be used when no configuration is provided for this class.
     * </p>
     */
    private static final int[] DEFAULT_LIST_FONT_SIZE = new int[] {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 20, 22,
        24, 26, 28, 32, 36, 40, 44, 48, 54, 60, 66, 72, 80, 88, 96};

    /**
     * <p>
     * Represents the list of font size used in the combo box.
     * </p>
     *
     * <p>
     * Is mutable but can not be null or empty list, null element is not allowed as well.
     * </p>
     *
     */
    private List<Integer> listFontSize = new ArrayList<Integer>();

    /**
     * <p>
     * Represents the default font size selected when the property is not defined (empty).
     * </p>
     *
     * <p>
     * It is mutable.
     * </p>
     */
    private int defaultFontSize;

    /**
     * <p>
     * Default constructor.
     * </p>
     *
     *
     * <p>
     * The default font size list will be used if the FontSizeSelector instance is created using
     * this constructor.
     * </p>
     */
    public FontSizeSelector() {
        defaultConfig();
    }

    /**
     * <p>
     * Constructor with namespace as the parameter.
     * </p>
     *
     *
     * <p>
     * Sample configuration:
     * &lt;Property name=&quot;fontSize&quot;&gt;
     *     &lt;Property name=&quot;small&quot;&gt;
     *         &lt;Value&gt;8&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;smaller&quot;&gt;
     *         &lt;Value&gt;6&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;normal&quot;&gt;
     *         &lt;Value&gt;10&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;default&quot;&gt;
     *         &lt;Value&gt;10&lt;/Value&gt;
     *     &lt;/Property&gt;
     * &lt;/Property&gt;
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     *
     * @throws IllegalArgumentException if namespace is null or empty
     * @throws StylePanelConfigurationException if there is an invalid configuration
     */
    public FontSizeSelector(String namespace) {
        Util.checkString(namespace, "namespace");

        Map<String, String> map = Util.getPropertyMap(namespace, "fontSize");
        if (map == null) {
            // The property is missing, then use default values
            defaultConfig();
        } else {
            // the empty font size
            addItem("");

            // the default font size
            // if present in the configuration file, then use it
            // otherwise, use the default font size
            if (map.containsKey("default")) {
                // It must be an positive integer
                defaultFontSize = Util.convertInteger(map.get("default"), "fontSize.default");
            } else {
                defaultFontSize = DEFAULT_SELECTED_FONT_SIZE;
                addItem(defaultFontSize);
                listFontSize.add(defaultFontSize);
            }

            Set<Entry<String, String>> entries = map.entrySet();
            for (Entry<String, String> entry : entries) {
                // The default font size is skipped
                if ("default".equals(entry.getKey())) {
                    continue;
                }

                // Each font size must be positive integer
                Integer fontSize = Util.convertInteger(entry.getValue(), "fontSize." + entry.getKey());
                if (!this.listFontSize.contains(fontSize)) {
                    addItem(fontSize);
                    this.listFontSize.add(fontSize);
                } else {
                    if (fontSize != defaultFontSize) {
                        throw new StylePanelConfigurationException("There are duplicate font size, it is " + fontSize);
                    }
                }
            }

            if (!listFontSize.contains(defaultFontSize)) {
                throw new StylePanelConfigurationException(
                    "The default font size is missing in the configuration file.");
            }

            Collections.sort(listFontSize);

            this.setSelectedItem(defaultFontSize);
        }
    }

    /**
     * <p>
     * Config the FontSizeSelector using the default values.
     * </p>
     */
    private void defaultConfig() {
        this.defaultFontSize = DEFAULT_SELECTED_FONT_SIZE;

        // the empty font size
        addItem("");

        // add all the default font size in the combo box
        for (int fontSize : DEFAULT_LIST_FONT_SIZE) {
            this.listFontSize.add(fontSize);
            addItem(fontSize);
        }

        // set the current font size
        this.setSelectedItem(defaultFontSize);
    }

    /**
     * <p>
     * Returns the font size list in the combo box.
     * </p>
     *
     * <p>
     * Note, the returned list is unmodifiable.
     * </p>
     *
     * @return the font size list in the combo box.
     */
    public List<Integer> getListFontSize() {
        return Collections.unmodifiableList(this.listFontSize);
    }

    /**
     * <p>
     * Returns the default font size.
     * </p>
     *
     * @return the default font size.
     */
    public int getDefaultFontSize() {
        return defaultFontSize;
    }

    /**
     * <p>
     * Sets the font size list for the combo box.
     * </p>
     *
     * @param listFontSize the font size list
     *
     * @throws IllegalArgumentException if the listFontSize is null or empty, or contains null element
     * or non-positive integer
     */
    public void setListFontSize(List<Integer> listFontSize) {
        Util.checkList(listFontSize, "listFontSize");
        // empty is not allowed
        if (listFontSize.isEmpty()) {
            throw new IllegalArgumentException("The given listFontSize is empty.");
        }
        // each font size must be positive
        for (Integer fontSize : listFontSize) {
            if (fontSize.intValue() <= 0) {
                throw new IllegalArgumentException("The given font size is non-positive, its value is " + fontSize);
            }
        }

        this.removeAllItems();

        addItem("");
        for (Integer fontSize : listFontSize) {
            addItem(fontSize);
        }

        this.listFontSize = new ArrayList<Integer>(listFontSize);
    }

    /**
     * <p>
     * Sets the default font size.
     * </p>
     *
     * @param defaultFontSize the default font size
     *
     * @throws IllegalArgumentException if defaultFontSize &lt;= 0
     */
    public void setDefaultFontSize(int defaultFontSize) {
        if (defaultFontSize <= 0) {
            throw new IllegalArgumentException("The given default font size is non-positive, its value is "
                + defaultFontSize);
        }

        this.defaultFontSize = defaultFontSize;
    }
}
