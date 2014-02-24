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
 * This class extends JComboBox and acts as the widget for font family selection.
 * </p>
 *
 * <p>
 * The font families are customizable but a default from the system is also provided.
 * </p>
 *
 * <p>
 * Thread safety: The JComboBox is not thread safe and so this class is not thread safe,
 * but since all of operation will be done in event-dispatching thread, there is no needs to worry.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class FontFamilySelector extends JComboBox {
    /**
     * <p>
     * Represents the default font name.
     * </p>
     */
    private static final String DEFAULT_SELECTED_FONT_NAME = "Default";

    /**
     * <p>
     * Represents the list of font family name used in the combo box.
     * </p>
     *
     * <p>
     * Is mutable but can not be null or empty list, null element is not allowed as well.
     * </p>
     */
    private List<String> listFontFamily = new ArrayList<String>();

    /**
     * <p>
     * Represents the default font name selected when the property is not defined (empty).
     * </p>
     *
     * <p>
     * It is mutable and can not be null or empty string.
     * </p>
     */
    private String defaultFontFamily;

    /**
     * <p>
     * Default constructor.
     * </p>
     *
     * <p>
     * All the available font names in the system will be used if the FontFamilySelector instance
     * is created using this constructor.
     * </p>
     */
    public FontFamilySelector() {
        defaultConfig(Util.getAllFontNames());
    }

    /**
     * <p>
     * Constructor with namespace as the parameter.
     * </p>
     *
     * <p>
     * Sample configuration:
     * &lt;Property name=&quot;fontFamily&quot;&gt;
     *     &lt;Property name=&quot;arial&quot;&gt;
     *         &lt;Value&gt;Arial&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;timesnewroman&quot;&gt;
     *         &lt;Value&gt;Times New Roman&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;verdana&quot;&gt;
     *         &lt;Value&gt;Verdana&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;default&quot;&gt;
     *         &lt;Value&gt;Verdana&lt;/Value&gt;
     *     &lt;/Property&gt;
     * &lt;/Property&gt;
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     *
     * @throws IllegalArgumentException if namespace is null or empty
     * @throws StylePanelConfigurationException if there is an invalid configuration
     */
    public FontFamilySelector(String namespace) {
        Util.checkString(namespace, "namespace");

        Set<String> defaultFontFamilyNames = Util.getAllFontNames();

        Map<String, String> map = Util.getPropertyMap(namespace, "fontFamily");
        if (map == null) {
            // The property is missing, then use default values
            defaultConfig(defaultFontFamilyNames);
        } else {
            // the empty font name
            addItem("");

            // the default font name
            // if present in the configuration file, then use it
            // otherwise, use the default font name
            if (map.containsKey("default")) {
                defaultFontFamily = map.get("default");

                // The default font name is not available in the system
                if (!defaultFontFamilyNames.contains(defaultFontFamily)) {
                    throw new StylePanelConfigurationException("The default font name " + defaultFontFamily
                        + " is not supported.");
                }
            } else {
                defaultFontFamily = DEFAULT_SELECTED_FONT_NAME;
                addItem(defaultFontFamily);
                listFontFamily.add(defaultFontFamily);
            }

            // Add all the configed fonts as items
            Set<Entry<String, String>> entries = map.entrySet();
            for (Entry<String, String> entry : entries) {
                // The default font is skipped
                if ("default".equals(entry.getKey())) {
                    continue;
                }

                // Other fonts are added as items of the combo box
                String fontName = entry.getValue();

                // If the font name is not available, then throw StylePanelConfigurationException
                if (!defaultFontFamilyNames.contains(fontName)) {
                    throw new StylePanelConfigurationException("The font name " + fontName + " is not supported.");
                }

                if (!listFontFamily.contains(fontName)) {
                    addItem(fontName);
                    listFontFamily.add(fontName);
                } else {
                    if (fontName.equals(defaultFontFamily)) {
                        throw new StylePanelConfigurationException("There are duplicate font name, it is " + fontName);
                    }
                }
            }

            if (!listFontFamily.contains(defaultFontFamily)) {
                throw new StylePanelConfigurationException(
                    "The default font name is missing in the configuration file.");
            }

            this.setSelectedItem(defaultFontFamily);
        }
    }

    /**
     * <p>
     * Config the FontFamilySelector using the default values.
     * </p>
     *
     * <p>
     * All the system available font names are added to the combo box.
     * </p>
     *
     * @param defaultFontFamilyNames all the available font names in the system
     */
    private void defaultConfig(Set<String> defaultFontFamilyNames) {
        defaultFontFamily = DEFAULT_SELECTED_FONT_NAME;

        // the empty font name
        addItem("");

        // all the system font names to combo box
        for (String defaultFontFamilyName : defaultFontFamilyNames) {
            this.listFontFamily.add(defaultFontFamilyName);
            addItem(defaultFontFamilyName);
        }

        this.setSelectedItem(defaultFontFamily);
    }

    /**
     * <p>
     * Returns the font family name list in this combo box.
     * </p>
     *
     * <p>
     * Note, the returned list is unmodifiable.
     * </p>
     *
     * @return the unmodifiable font family name list
     */
    public List<String> getListFontFamily() {
        return Collections.unmodifiableList(this.listFontFamily);
    }

    /**
     * <p>
     * Returns the default font family name.
     * </p>
     *
     * @return the default font family name
     */
    public String getDefaultFontFamily() {
        return this.defaultFontFamily;
    }

    /**
     * <p>
     * Sets the font family name list.
     * </p>
     *
     * @param listFontFamily the font family name list
     *
     * @throws IllegalArgumentException if list is null or empty, or contains null element
     */
    public void setListFontFamily(List<String> listFontFamily) {
        Util.checkList(listFontFamily, "listFontFamily");
        if (listFontFamily.isEmpty()) {
            throw new IllegalArgumentException("The listFontFamily is empty list.");
        }

        this.removeAllItems();

        addItem("");
        for (String font : listFontFamily) {
            addItem(font);
        }

        this.listFontFamily = listFontFamily;
    }

    /**
     * <p>
     * Sets the default font family name.
     * </p>
     *
     * @param defaultFontFamily the default font family name
     *
     * @throws IllegalArgumentException if parameter is null or empty string
     */
    public void setDefaultFontFamily(String defaultFontFamily) {
        Util.checkString(defaultFontFamily, "defaultFontFamily");

        this.defaultFontFamily = defaultFontFamily;
    }
}
