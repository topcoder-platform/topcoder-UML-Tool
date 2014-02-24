/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.DropDownPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;
import com.topcoder.util.config.ConfigLockedException;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the main class of this component.
 * 
 * It uses the PropertyDefinition instances to define the properties and the
 * related JComponents.
 * 
 * It is a JPanel that is used to display prompt text and the associated control
 * to edit the configuration values.
 * 
 * These JComponents are constructed with the related generators using the type.
 * Many other graphic values are configurable.
 * 
 * The component is initialized in the initialize method called in the
 * constructor.
 * 
 * The component uses the validators to validate the properties against the old
 * properties.
 * 
 * The new properties values are saved using the Configuration Manager, (the old
 * properties values are retrieved using ConfigurationManager)
 * 
 * Thread safety: this class is not thread safe but it's not required because
 * only a single thread will use this class, this TC Tool application and then
 * the user who uses the application.
 * 
 * <p>
 * Sample config contains the properties to modify: &lt;Config
 * name="MyClass"&gt; &lt;Property name="name"&gt;
 * &lt;Value&gt;John&lt;/Value&gt; &lt;/Property&gt; &lt;Property
 * name="size"&gt; &lt;Value&gt;10&lt;/Value&gt; &lt;/Property&gt;
 * &lt;/Config&gt;
 * </p>
 * <p>
 * Sample configuration for the component: &lt;Config
 * name="ConfigurationManagerEditorPanel"&gt;
 * 
 * &lt;!-- Define the namespace used to load the old values of properties and to
 * save the properties --&gt; &lt;Property name="propertiesNamespace"&gt;
 * &lt;Value&gt;MyClass&lt;/Value&gt; &lt;/Property&gt;
 * 
 * &lt;!-- Define the properties definitions --&gt; &lt;Property
 * name="propertyDefinitions"&gt;
 * 
 * &lt;!-- Defines a text field --&gt; &lt;Property name="name"&gt;
 * &lt;Value&gt;Name :&lt;/Value&gt; &lt;Value&gt;FREE_TEXT&lt;/Value&gt;
 * 
 * &lt;/Property&gt;
 * 
 * &lt;!-- Defines a combobox with multiple values --&gt; &lt;Property
 * name="size"&gt; &lt;Value&gt;Size :&lt;/Value&gt;
 * &lt;Value&gt;DROP_DOWN&lt;/Value&gt; &lt;Value&gt;1&lt;/Value&gt;
 * &lt;Value&gt;10&lt;/Value&gt; &lt;Value&gt;20&lt;/Value&gt; &lt;/Property&gt;
 * &lt;/Property&gt;
 * 
 * &lt;Property name="rowsSpacing"&gt; &lt;Value&gt;10&lt;/Value&gt;
 * &lt;/Property&gt;
 * 
 * &lt;Property name="columnsSpacing"&gt; &lt;Value&gt;20&lt;/Value&gt;
 * &lt;/Property&gt;
 * 
 * &lt;Property name="fontName"&gt; &lt;Value&gt;Times New Roman&lt;/Value&gt;
 * &lt;/Property&gt;
 * 
 * &lt;Property name="fontStyle"&gt; &lt;Value&gt;0&lt;/Value&gt;&lt;!-- Plain
 * style --&gt; &lt;/Property&gt;
 * 
 * &lt;Property name="fontSize"&gt; &lt;Value&gt;10&lt;/Value&gt;
 * &lt;/Property&gt;
 * 
 * &lt;Property name="fontColor"&gt; &lt;Value&gt;black&lt;/Value&gt;
 * &lt;/Property&gt;
 * 
 * &lt;/Config&gt;
 * </p>
 * <p>
 * Sample usage: panel = new
 * ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel");
 * 
 * panel.setSize(400, 400); panel.setVisible(true); // add it to the frame
 * frame.getContentPane().add(panel); frame.pack(); frame.setSize(400, 400);
 * frame.setVisible(true);
 * 
 * // Add this point the panel is shown // (see the RS for a picture of the
 * panel editor). The user click to // modify the "size" property 8use 20) with
 * the combobox. Then also // modify the name with the text field (write
 * "Michael")
 * 
 * // Set validators panel.addPropertyTypeValidator(PropertyType.CHECK_BOX, new
 * DirectoryValidator());
 * 
 * // validate the properties ValidationResultSet resultSet =
 * panel.validateProperties();
 * 
 * // the properties are validated
 * 
 * // check the validation if (resultSet.isSuccess()) { // save the properties
 * // the validation is already performed since I can call directly the // save
 * method panel.saveProperties(); // the properties now are saved to the related
 * namespace }
 * </p>
 * 
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationManagerEditorPanel extends JPanel {
    /**
     * Represents the properties namespace. It is used to retrieve the
     * properties values and it is used to save the properties.
     * 
     * Initial Value: defined in constructor
     * 
     * Accessed In: getter method
     * 
     * Modified In: none
     * 
     * Utilized In: initialize component and constructor Valid Values: can't be
     * null, can't be empty
     */
    private final String propertiesNamespace;

    /**
     * Represents the property Validators tied to the property types used to
     * validate the properties when they are saved.
     * 
     * Initial Value: empty map
     * 
     * Accessed In: getter methods
     * 
     * Modified In: clear, add, remove
     * 
     * Utilized In: save, validate methods
     * 
     * Valid Values: The keys are the property types, can't be null, the values
     * are the validators can't be null
     */
    private final Map<PropertyType, PropertyValidator> propertyTypeValidators = new HashMap<PropertyType, PropertyValidator>();

    /**
     * Represents the property Validators tied to the property name used to
     * validate the properties when they are saved.
     * 
     * Initial Value: empty map
     * 
     * Accessed In: getter methods
     * 
     * Modified In: clear, add, remove
     * 
     * Utilized In: save, validate methods
     * 
     * Valid Values: The keys are the property names, can't be null, can't be
     * empty; the values are the validators can't be null
     */
    private final Map<String, PropertyValidator> propertyNameValidators = new HashMap<String, PropertyValidator>();

    /**
     * Represents the property Definitions. The keys are the properties
     * definitions and the values are the related JComponents. The [0] is the
     * JLabel associated, the [1] is the JComponent returned by the
     * PropertyComponentGenerator. In the constructor the property definitions
     * (keys) are put with null values. The keys can't be null. The values must
     * have the size=2, not null values (only when the initialize component is
     * called)
     * 
     * Initial Value: defined in constructor
     * 
     * Accessed In: getter method
     * 
     * Modified In: initialize
     * 
     * Utilized In: none
     * 
     * Valid Values: see the above description
     */
    private final Map<PropertyDefinition, JComponent[]> propertyDefinitions = new HashMap<PropertyDefinition, JComponent[]>();

    /**
     * Represents the component Generators related to the types, used to
     * generate the component. The keys can't be null, the values can't be null,
     * can't be empty. It will have all the generates defined in the relates
     * sub-package.
     * 
     * Initial Value: defined in constructor
     * 
     * Accessed In: getter method
     * 
     * Modified In: none
     * 
     * Utilized In: initialize
     * 
     * Valid Values: see the above description
     */
    private final Map<PropertyType, PropertyComponentGenerator> componentGenerators = new HashMap<PropertyType, PropertyComponentGenerator>();

    /**
     * Represents the rows Spacing for the properties rows.
     * 
     * Initial Value: defined in constructor, -1 means that the default will be
     * used
     * 
     * Accessed In: getter method
     * 
     * Modified In: none
     * 
     * Utilized In: initialize
     * 
     * Valid Values: greater than or equal to -1
     */
    private int rowsSpacing;

    /**
     * Represents the columns Spacing for the properties rows.
     * 
     * Initial Value: defined in constructor, -1 means that the default will be
     * used
     * 
     * Accessed In: getter method
     * 
     * Modified In: none
     * 
     * Utilized In: initialize
     * 
     * Valid Values: greater than or equal to -1
     */
    private int columnsSpacing;

    /**
     * Represents the font's Color.
     * 
     * Initial Value: defined in constructor.
     * 
     * Accessed In: getter method.
     * 
     * Modified In: none.
     * 
     * Utilized In: initialize.
     * 
     * Valid Values: can be null, in this case the default font is used.
     */
    private Color fontColor;

    /**
     * Construct the instance from the properties.
     * 
     * @throws IllegalArgumentException
     *             if any argument is null or empty (string), if the
     *             propertyDefinitions is empty, if the int are less than 0, if
     *             the lists contain null values
     * @throws NotValidNamespaceException
     *             If the namespace provided isn't available or contains no
     *             properties
     * @param generators
     *            the generators
     * @param propertiesNamespace
     *            the namespace used to save the properties
     * @param columnsSpacing
     *            the columns spacing
     * @param propertyDefinitions
     *            the property Definitions
     * @param rowsSpacing
     *            the row spacing
     */
    public ConfigurationManagerEditorPanel(String propertiesNamespace, List<PropertyDefinition> propertyDefinitions,
            int rowsSpacing, int columnsSpacing, List<PropertyComponentGenerator> generators)
            throws NotValidNamespaceException {
        // Check propertiesNamespace.
        this.propertiesNamespace = propertiesNamespace;
        if (propertiesNamespace == null) {
            throw new IllegalArgumentException("propertiesNamespace cannot be null.");
        }
        if (propertiesNamespace.trim().length() == 0) {
            throw new IllegalArgumentException("propertiesNamespace cannot be empty.");
        }
        if (rowsSpacing < 0) {
            throw new IllegalArgumentException("rowsSpacing cannot be less than 0.");
        }
        if (columnsSpacing < 0) {
            throw new IllegalArgumentException("columnsSpacing cannot be less than 0.");
        }
        // Check propertyDefinitions.
        if (propertyDefinitions == null) {
            throw new IllegalArgumentException("propertyDefinitions cannot be null.");
        }
        if (propertyDefinitions.isEmpty()) {
            throw new IllegalArgumentException("propertyDefinitions cannot be empty.");
        }
        if (propertyDefinitions.contains(null)) {
            throw new IllegalArgumentException("propertyDefinitions cannot contain null.");
        }
        // Check generators.
        if (generators == null) {
            throw new IllegalArgumentException("generators cannot be null.");
        }
        if (generators.contains(null)) {
            throw new IllegalArgumentException("generators cannot contain null.");
        }

        ConfigManager cm = ConfigManager.getInstance();

        if (!cm.existsNamespace(propertiesNamespace)) {
            throw new NotValidNamespaceException("namespace " + propertiesNamespace + " does not exist.");
        }

        // Check rowsSpacing.
        this.rowsSpacing = rowsSpacing;
        // Check columnsSpacing.
        this.columnsSpacing = columnsSpacing;

        // Initialize propertyDefinitions.
        for (int i = 0; i < propertyDefinitions.size(); ++i) {
            this.propertyDefinitions.put(propertyDefinitions.get(i), null);
        }

        // Initialize componentGenerators.
        for (PropertyComponentGenerator generator : generators) {
            componentGenerators.put(generator.getPropertyType(), generator);
        }

        // Read configuration values and fill PropertyDefinitions.
        Map<String, String> oldPropertiesValues = getOldPropertiesValues();
        for (Entry<String, String> property : oldPropertiesValues.entrySet()) {
            for (PropertyDefinition pd : propertyDefinitions) {
                if (property.getKey().equals(pd.getPropertyName())) {
                    pd.setPropertyValue(property.getValue());
                    break;
                }
            }
        }

        initialize();
    }

    /**
     * Construct the instance from the namespace.
     * 
     * @throws IllegalArgumentException
     *             if the argument is null or empty
     * @throws ConfigurationException
     *             missing required properties or in the bad format
     * @throws NotValidNamespaceException
     *             If the namespace provided isn't available or contains no
     *             properties
     * @param configurationNamespace
     *            the namespace used to load the configuration
     */
    public ConfigurationManagerEditorPanel(String configurationNamespace) throws ConfigurationException,
            NotValidNamespaceException {
        if (configurationNamespace == null) {
            throw new IllegalArgumentException("propertiesNamespace cannot be null.");
        }
        if (configurationNamespace.trim().length() == 0) {
            throw new IllegalArgumentException("propertiesNamespace cannot be empty.");
        }
        try {
            ConfigManager cm = ConfigManager.getInstance();

            if (!cm.existsNamespace(configurationNamespace)) {
                throw new NotValidNamespaceException("namespace " + configurationNamespace + " does not exist.");
            }
            propertiesNamespace = cm.getString(configurationNamespace, "propertiesNamespace");
            if (propertiesNamespace == null) {
                throw new ConfigurationException("propertiesNamespace is required for namespace "
                        + configurationNamespace);
            }
            if (propertiesNamespace.trim().length() == 0) {
                throw new ConfigurationException("propertiesNamespace cannot be empty for namespace "
                        + configurationNamespace);
            }
            if (!cm.existsNamespace(propertiesNamespace)) {
                throw new NotValidNamespaceException("namespace " + propertiesNamespace + " does not exist.");
            }

            this.rowsSpacing = getIntProperty(cm, configurationNamespace, "rowsSpacing");
            this.columnsSpacing = getIntProperty(cm, configurationNamespace, "columnsSpacing");

            String fontColorString = (String) cm.getProperty(configurationNamespace, "fontColor");
            if (fontColorString != null) {
                Field field = null;
                try {
                    field = Color.class.getDeclaredField(fontColorString);
                    // set the field accessible.
                    field.setAccessible(true);
                    Object fieldValue = field.get(null);
                    // get the value
                    if (fieldValue == null || !(fieldValue instanceof Color)) {
                        throw new ConfigurationException("FontColor " + fontColorString
                                + " is not defined in the Color class.");
                    }
                    fontColor = (Color) fieldValue;
                } catch (NoSuchFieldException e) {
                    throw new ConfigurationException("FontColor " + fontColorString
                            + " is not defined in the Color class.");
                } catch (IllegalArgumentException e) {
                    throw new ConfigurationException("FontColor " + fontColorString
                            + " is not defined in the Color class.");
                } catch (IllegalAccessException e) {
                    throw new ConfigurationException("FontColor " + fontColorString
                            + " is not defined in the Color class.");
                } finally {
                    if (field != null) {
                        // reset the accessibility
                        field.setAccessible(false);
                    }
                }
            }

            String fontName = (String) cm.getProperty(configurationNamespace, "fontName");
            if (fontName != null) {
                // Check font name.
                Font font = new Font(fontName, 0, 12);
                if (!font.getFontName().equals(fontName)) {
                    throw new ConfigurationException("Font " + fontName + " is not defined.");
                }
            }

            String fontStyle = (String) cm.getProperty(configurationNamespace, "fontStyle");
            // Check fontStyle.
            if (fontStyle != null && !fontStyle.equals("0") && !fontStyle.equals("1") && !fontStyle.equals("2")) {
                throw new ConfigurationException("FontStyle " + fontStyle + " is not defined in the Font class.");
            }

            Integer fontSize = getIntProperty(cm, configurationNamespace, "fontSize");

            Property propertiyDefinitionsProperty = cm.getPropertyObject(configurationNamespace, "propertyDefinitions");
            if (propertiyDefinitionsProperty == null) {
                throw new ConfigurationException("propertyDefinitions is missing for namespace"
                        + configurationNamespace);
            }

            List<Property> list = propertiyDefinitionsProperty.list();
            for (Object element : list) {
                PropertyDefinition pd = new PropertyDefinition();
                this.propertyDefinitions.put(pd, null);

                Property subProperty = (Property) element;

                pd.setPropertyName(subProperty.getName());
                String[] values = subProperty.getValues();

                if (values == null || values.length < 2) {
                    throw new ConfigurationException(MessageFormat.format(
                            "Configuration for PropertyDefinition [{0}] is incomplete. "
                                    + "At least, two value items should be given. Namespace: [{1}]", pd
                                    .getPropertyName(), configurationNamespace));
                }

                String promptText = values[0];
                pd.setPromptText(promptText);
                PropertyType propertyType;
                try {
                    propertyType = PropertyType.valueOf(values[1]);
                } catch (IllegalArgumentException e) {
                    throw new ConfigurationException("Invalid PropertyType: " + values[1], e);
                }
                pd.setPropertyType(propertyType);
                // Read property value from ConfigManager.
                pd.setPropertyValue((String) cm.getProperty(propertiesNamespace, subProperty.getName()));

                // Set value choices.
                if (PropertyType.DROP_DOWN.equals(propertyType) || PropertyType.RADIO_BUTTONS.equals(propertyType)) {
                    Set<String> valueChoices = new HashSet<String>();
                    for (int i = 2; i < values.length; ++i) {
                        valueChoices.add(values[i]);
                    }

                    pd.setValueChoices(valueChoices);
                }
            }

            // Initialize componentGenerators.
            componentGenerators.put(PropertyType.CHECK_BOX, new CheckBoxPropertyComponentGenerator());
            componentGenerators.put(PropertyType.FREE_TEXT, new FreeTextPropertyComponentGenerator());
            componentGenerators.put(PropertyType.DROP_DOWN, new DropDownPropertyComponentGenerator());
            componentGenerators.put(PropertyType.RADIO_BUTTONS, new RadioButtonsPropertyComponentGenerator());

            initialize();

            // now set the custom font, use also the color, (if it's not null)
            // to
            // all sub-components related to properties (or you can set directly
            // it
            // in the cycle
            if (fontName != null && fontStyle != null) {
                Font font = new Font(fontName, Integer.parseInt(fontStyle), fontSize);
                setFont(font);
            }
            if (fontColor != null) {
                if (propertyDefinitions != null) {
                    // set the color to all children JComponents.
                    for (JComponent[] components : propertyDefinitions.values()) {
                        components[0].setForeground(fontColor);
                        components[1].setForeground(fontColor);
                    }
                }
            }
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("Namespace " + configurationNamespace + " is unknown.", e);
        }
    }

    /**
     * Initializes the component. Initializes all from properties definitions.
     */
    protected void initialize() {
        // create the grid bag layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        // create the index for the cycle
        int index = 0;

        for (final PropertyDefinition propertyDefinition : propertyDefinitions.keySet()) {
            // create the label related to the prompt text
            JLabel label = new JLabel(propertyDefinition.getPromptText());

            // create the constraints for the label
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = index;
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.LINE_START;
            // also set the c.insets,c.ipadx and c.ipady constraints: use the
            // values of rowsSpacing and columnsSpacing
            if (columnsSpacing != -1) {
                c.ipadx = columnsSpacing;
            }
            if (rowsSpacing != -1) {
                c.ipady = rowsSpacing;
            }
            c.insets.bottom = c.insets.top = rowsSpacing;
            c.insets.left = c.insets.right = columnsSpacing;

            // add the component to the grid
            gridBagLayout.addLayoutComponent(label, c);
            add(label);

            // now the column is the second
            c.gridx = 1;

            // create the component from the component generator, and add it to
            // the property definitions
            JComponent component = this.componentGenerators.get(propertyDefinition.getPropertyType())
                    .generateComponent(propertyDefinition);
            this.propertyDefinitions.put(propertyDefinition, new JComponent[] { label, component });
            add(component);
            // add the component to the layout manager
            gridBagLayout.addLayoutComponent(component, c);
            index++;
        }
    }

    /**
     * validate the properties definitions. The properties definitions are
     * already set when an user click on a JComponent, so we can use directly
     * the PropertyDefinition instances.
     * 
     * Validation: get the related property type validator and validate it (if
     * it exists) and then get the related property name validator and validate
     * it (if it exists)
     * 
     * @throws ValidationException
     *             if some errors occur
     * @return the result of validation.
     */
    public ValidationResultSet validateProperties() throws ValidationException {
        Map<PropertyDefinition, List<ValidationResult>> resultMap = new HashMap<PropertyDefinition, List<ValidationResult>>();

        try {
            for (PropertyDefinition propertyDef : propertyDefinitions.keySet()) {
                List<ValidationResult> list = resultMap.get(propertyDef);

                resultMap.put(propertyDef, new ArrayList<ValidationResult>());
                list = resultMap.get(propertyDef);

                PropertyValidator nameValidator = propertyNameValidators.get(propertyDef.getPropertyName());
                if (nameValidator != null) {
                    list.add(nameValidator.validateProperty(propertyDef));
                }

                PropertyValidator typeValidator = propertyTypeValidators.get(propertyDef.getPropertyType());
                if (typeValidator != null) {
                    list.add(typeValidator.validateProperty(propertyDef));
                }
            }
        } catch (ConfigurationManagerEditorPanelException e) {
            throw new ValidationException("Validate fails.", e);
        }

        return new ValidationResultSet(resultMap);
    }

    /**
     * Save the properties commiting the changes to the ConfigurationManager.
     * 
     * Implementation: lock the configuration manager, the user will be the
     * fully qualified name of this class; for each property definition entry in
     * the map: get the old value from the ConfigManager, check if it's
     * different (case sensitive), if so then firstly validate the new property
     * and then if the validation succeed set the attribute; at the end of
     * setting, commit the changes.
     * 
     * @throws SavingException
     *             if some errors occur during the saving
     */
    public void saveProperties() throws SavingException {
        String user = ConfigurationManagerEditorPanel.class.getName();

        try {
            ConfigManager instance = ConfigManager.getInstance();
            // lock ConfigManager
            instance.lock(propertiesNamespace, user);
            instance.createTemporaryProperties(propertiesNamespace);

            for (Entry<String, String> entry : getOldPropertiesValues().entrySet()) {
                // For each property.

                // Get the old value.
                Object oldValue = entry.getValue();

                for (PropertyDefinition pd : propertyDefinitions.keySet()) {
                    String propertyName = pd.getPropertyName();
                    if (entry.getKey().equals(propertyName)) {
                        String propertyValue = pd.getPropertyValue();
                        // Compare with the new value.
                        if (oldValue == null || !oldValue.equals(propertyValue)) {
                            if (propertyValue == null) {
                                propertyValue = "";
                            }
                            instance.setProperty(propertiesNamespace, propertyName, propertyValue);
                        }
                        break;
                    }
                }
            }

            // commit changes.
            instance.commit(propertiesNamespace, user);
        } catch (UnknownNamespaceException e) {
            throw new SavingException("Namespace " + propertiesNamespace + " is not found.", e);
        } catch (ConfigLockedException e) {
            throw new SavingException("Unable to lock ConfigManager.", e);
        } catch (ConfigManagerException e) {
            throw new SavingException("Error occurred while saving properties.", e);
        }
    }

    /**
     * Add the property validator to the list.
     * 
     * @throws IllegalArgumentException
     *             if the argument is null
     * @param validator
     *            the validator to add
     * @param propertyType
     *            the property type.
     * 
     */
    public void addPropertyTypeValidator(PropertyType propertyType, PropertyValidator validator) {
        if (propertyType == null) {
            throw new IllegalArgumentException("propertyType cannot be null.");
        }
        if (validator == null) {
            throw new IllegalArgumentException("validator cannot be null.");
        }
        this.propertyTypeValidators.put(propertyType, validator);
    }

    /**
     * Add the validator related to property name
     * 
     * @throws IllegalArgumentException
     *             if the arguments are null, if the String is empty
     * @param validator
     *            the related validator.
     * @param propertyName
     *            the property name
     */
    public void addPropertyNameValidator(String propertyName, PropertyValidator validator) {
        if (propertyName == null) {
            throw new IllegalArgumentException("propertyName cannot be null.");
        }
        if (propertyName.trim().length() == 0) {
            throw new IllegalArgumentException("propertyName cannot be empty.");
        }
        if (validator == null) {
            throw new IllegalArgumentException("validator cannot be null.");
        }
        this.propertyNameValidators.put(propertyName, validator);
    }

    /**
     * Remove the validator from the list. Return true if it exists and the it
     * was removed
     * 
     * @throws IllegalArgumentException
     *             if the argument is null
     * @param propertyType
     *            the key of map of validator to remove
     * @return true if it exists and the it was removed
     */
    public boolean removePropertyTypeValidator(PropertyType propertyType) {
        if (propertyType == null) {
            throw new IllegalArgumentException("propertyType cannot be null.");
        }
        return propertyTypeValidators.remove(propertyType) != null;
    }

    /**
     * Remove the related property name validator from the map
     * 
     * @throws IllegalArgumentException
     *             if the argument is null or empty
     * @param propertyName
     *            the name of property
     * @return true if it exists and the it was removed
     */
    public boolean removePropertyNameValidator(String propertyName) {
        if (propertyName == null) {
            throw new IllegalArgumentException("propertyName cannot be null.");
        }
        if (propertyName.trim().length() == 0) {
            throw new IllegalArgumentException("propertyName cannot be empty.");
        }
        return propertyNameValidators.remove(propertyName) != null;
    }

    /**
     * Clear the validator list.
     */
    public void clearPropertyTypeValidators() {
        propertyTypeValidators.clear();
    }

    /**
     * Clear the property names validators map.
     */
    public void clearPropertyNameValidators() {
        propertyNameValidators.clear();
    }

    /**
     * Return the propertyValidators related to types. Shallow copy.
     * 
     * @return the propertyValidators
     */
    public Map<PropertyType, PropertyValidator> getPropertyTypeValidators() {
        return new HashMap<PropertyType, PropertyValidator>(propertyTypeValidators);
    }

    /**
     * Return the propertyValidators related to names. Shallow copy.
     * 
     * @return the property validators related to property names
     */
    public Map<String, PropertyValidator> getPropertyNameValidators() {
        return new HashMap<String, PropertyValidator>(propertyNameValidators);
    }

    /**
     * Set the propertyValidators. Shallow copy.
     * 
     * @throws IllegalArgumentException
     *             if it's null or contain the null key or the empty key or null
     *             values
     * @param propertyTypeValidators
     *            the propertyValidators to set
     */
    public void setPropertyTypeValidators(Map<PropertyType, PropertyValidator> propertyTypeValidators) {
        if (propertyTypeValidators == null) {
            throw new IllegalArgumentException("propertyTypeValidators cannot be null.");
        }
        if (propertyTypeValidators.containsKey(null)) {
            throw new IllegalArgumentException("propertyTypeValidators cannot contain null key.");
        }
        if (propertyTypeValidators.containsKey("")) {
            throw new IllegalArgumentException("propertyTypeValidators cannot contain empty key.");
        }
        if (propertyTypeValidators.containsValue(null)) {
            throw new IllegalArgumentException("propertyTypeValidators cannot contain null value.");
        }

        this.propertyTypeValidators.clear();
        if (propertyTypeValidators != null) {
            this.propertyTypeValidators.putAll(propertyTypeValidators);
        }
    }

    /**
     * Set the property validators related to names
     * 
     * @throws IllegalArgumentException
     *             if it's null or contain the null key or the empty key or null
     *             values
     * @param propertyNameValidators
     *            the map of validators
     */
    public void setPropertyNameValidators(Map<String, PropertyValidator> propertyNameValidators) {
        if (propertyNameValidators == null) {
            throw new IllegalArgumentException("propertyNameValidators cannot be null.");
        }
        if (propertyNameValidators.containsKey(null)) {
            throw new IllegalArgumentException("propertyNameValidators cannot contain null key.");
        }
        if (propertyNameValidators.containsKey("")) {
            throw new IllegalArgumentException("propertyNameValidators cannot contain empty key.");
        }
        if (propertyNameValidators.containsValue(null)) {
            throw new IllegalArgumentException("propertyNameValidators cannot contain null value.");
        }

        this.propertyNameValidators.clear();
        if (propertyNameValidators != null) {
            this.propertyNameValidators.putAll(propertyNameValidators);
        }
    }

    /**
     * Return the propertiesNamespace
     * 
     * @return the propertiesNamespace
     */
    public String getPropertiesNamespace() {
        return propertiesNamespace;
    }

    /**
     * Return the oldPropertiesValues.
     * 
     * @return the old PropertiesValues
     */
    public Map<String, String> getOldPropertiesValues() {
        Map<String, String> oldPropertiesValues = new HashMap<String, String>();

        ConfigManager cm = ConfigManager.getInstance();
        for (PropertyDefinition property : propertyDefinitions.keySet()) {
            String propertyName = property.getPropertyName();

            try {
                oldPropertiesValues.put(propertyName, cm.getString(propertiesNamespace, propertyName));
            } catch (UnknownNamespaceException e) {
                // never occurs. ignore.
            }
        }

        return oldPropertiesValues;
    }

    /**
     * Return the propertyDefinitions. use a shallow copy.
     * 
     * @return the propertyDefinitions
     */
    public Map<PropertyDefinition, JComponent[]> getPropertyDefinitions() {
        return new HashMap<PropertyDefinition, JComponent[]>(propertyDefinitions);
    }

    /**
     * Return the componentGenerators. use a shallow copy.
     * 
     * @return the componentGenerators
     */
    public Map<PropertyType, PropertyComponentGenerator> getComponentGenerators() {
        return new HashMap<PropertyType, PropertyComponentGenerator>(componentGenerators);
    }

    /**
     * Return the rowsSpacing
     * 
     * @return the rowsSpacing
     */
    public int getRowsSpacing() {
        return rowsSpacing;
    }

    /**
     * Return the columnsSpacing
     * 
     * @return the columnsSpacing
     */
    public int getColumnsSpacing() {
        return columnsSpacing;
    }

    /**
     * Override the parent method. Set the parent font and also set the font to
     * all children JComponents using the propertyDeifnition map.
     * 
     * @throws IllegalArgumentException
     *             if it's null
     * @param font
     *            the font to set
     */
    public void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("font cannot be null.");
        }
        super.setFont(font);

        if (propertyDefinitions != null) {
            // set the font to all children JComponents.
            for (JComponent[] components : propertyDefinitions.values()) {
                components[0].setForeground(fontColor);
                components[1].setForeground(fontColor);
            }
        }
    }

    /**
     * Return the fontColor
     * 
     * @return the fontColor
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * Retrieves property and convert to int.
     * 
     * @param cm
     *            ConfigManager instance.
     * @param namespace
     *            namespace.
     * @param propertyName
     *            property name.
     * @return configured int value.
     * @throws UnknownNamespaceException
     *             If namespace is unknown.
     * @throws ConfigurationException
     *             If configured int is less than 0.
     */
    private static int getIntProperty(ConfigManager cm, String namespace, String propertyName)
            throws UnknownNamespaceException, ConfigurationException {
        Object property = cm.getProperty(namespace, propertyName);
        if (property != null) {
            try {
                int ret = Integer.parseInt((String) property);

                if (ret < 0) {
                    throw new ConfigurationException(MessageFormat.format(
                            "Property {0} under namespace {1} must be non-negative. But it is {2}", propertyName,
                            namespace, ret));
                }
                return ret;
            } catch (NumberFormatException e) {
                throw new ConfigurationException(MessageFormat.format(
                        "Property {0} under namespace {1} must be a number. But it is {2}", propertyName, namespace,
                        property));
            } catch (ClassCastException e) {
                throw new ConfigurationException(MessageFormat.format(
                        "Property {0} under namespace {1} must be a number. But it is {2}", propertyName, namespace,
                        property));
            }
        } else {
            return -1;
        }
    }
}
