/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.panels.properties.propertypanel.AggregationPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.AssociationEndsPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.AttributePropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.ChangeabilityPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.ConcurrencyPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.GuardPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.IncomingTransitionPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.InitialValuePropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.KindPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.ModifiersPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.MultiplicityPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.NamePropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.NamespacePropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.OperationPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.OrderingPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.OutgoingTransitionPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.OwnerPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.ParameterListPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.StereotypeListPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.TypePropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.VisibilityPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ActionLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.AdditionLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.AssociationLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.BaseLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ChildLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ClientLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ExtensionLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.NamespaceLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.OwnerLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ParentLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.SourceLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.StimulusLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.SupplierLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.TargetLinkPropertyPanel;

import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.SendSignalAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * <p>
 * This is the main class of the component.
 * </p>
 *
 * <p>
 * It provides a container for the whole GUI of the Properties Panel.
 * </p>
 *
 * <p>
 * Additionally, it provides a facade for the complex operations of refreshing the panel and configuring the panel.
 * </p>
 *
 * <p>
 * The panel can be configured to display properties of one or a few <code>ModelElement</code> through
 * configurePanel method. These properties can be refreshed through refreshPanel method.
 * </p>
 *
 * <p>
 * Additionally, the panel provides two notification facilities.
 * <ul>
 * <li>
 * The first one is to notify application of changes in property values of a <code>ModelElement</code> (changes in
 * multiple properties/multiple <code>ModelElement</code> will result in the same number of notifications
 * produced).</li>
 * <li>
 * The second one is to notify the application of a change of focus from one ModelElement to another caused by the
 * internal operation of <code>ModelElement</code>.</li>
 * </ul>
 * For example, when viewing a <code>Class</code> properties, clicking a link button for a namespace in the panel
 * will lead the Properties Panel to display the properties of the namespace. The application may need to be
 * informed of this change.
 * </p>
 *
 * <p>
 * The class provides configurable look and feel for the panel.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as it contains many mutable variable.
 * </p>
 * <p>
 * V1.1 Change Note: the new layout is used as the prototype.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class PropertiesPanel extends JPanel {
    /**
     * <p>
     * The default namespace to be used by the class to load configuration information through Configuration
     * Manager.
     * </p>
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.gui.panels.properties";

    /**
     * <p>
     * The class array represents the keys for the stereotype mapping.
     * </p>
     */
    private static final java.lang.Class<?>[] STEREOTYPE_MAPPING_KEYS =
        new java.lang.Class[] {Package.class, Interface.class, Class.class, Enumeration.class, Attribute.class,
            Operation.class, Parameter.class, Dependency.class, Generalization.class, Abstraction.class,
            Association.class, AssociationEnd.class, Actor.class, UseCase.class, Subsystem.class, Include.class,
            Extend.class, SimpleState.class, ObjectFlowState.class, FinalState.class, ActionState.class,
            Pseudostate.class, Transition.class, Object.class, CreateObjectAction.class,
            CallOperationAction.class, SendSignalAction.class, Stimulus.class};

    /**
     * <p>
     * The string array represents the values for the stereotype mapping.
     * </p>
     */
    private static final String[] STEREOTYPE_MAPPING_PROPERTIES =
        new String[] {"Package", "Interface", "Class", "Enumeration", "Attribute", "Operation", "Parameter",
            "Dependency", "Generalization", "Abstraction", "Association", "AssociationEnd", "Actor", "UseCase",
            "Subsystem", "Include", "Extend", "SimpleState", "ObjectFlowState", "FinalState", "ActionState",
            "Pseudostate", "Transition", "Object", "CreateObjectAction", "CallOperationAction",
            "SendSignalAction", "Stimulus"};

    /**
     * <p>
     * The list of property change listener.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will never be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null. May be empty.
     * </p>
     */
    private final List<ModelElementChangeListener> propertyChangeListener =
        new ArrayList<ModelElementChangeListener>();

    /**
     * <p>
     * The list of diagram change listener.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will never be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null. May be empty.
     * </p>
     */
    private final List<DiagramChangeListener> diagramChangeListener = new ArrayList<DiagramChangeListener>();

    /**
     * <p>
     * The list of selection change listener.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will never be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null. May be empty.
     * </p>
     */
    private final List<ModelElementSelectionListener> selectionChangeListener =
        new ArrayList<ModelElementSelectionListener>();

    /**
     * <p>
     * The list of configured <code>ModelElement</code>.
     * </p>
     * <p>
     * The <code>PropertyPanel</code> will only fire events for <code>ModelElement</code> instances that are
     * configured.
     * </p>
     * <p>
     * Initially set to null, the value is set through configurePanel and setConfiguredModelElements method and
     * accessed through getConfiguredModelElements.
     * </p>
     * <p>
     * May not be empty.
     * </p>
     */
    private List<ModelElement> modelElements = new ArrayList<ModelElement>();

    /**
     * <p>
     * Represents the left panel in the properties panel.
     * </p>
     *
     * <p>
     * It is created in the constructor and the reference will never changed afterwards although the contained
     * components may change.
     * </p>
     *
     * <p>
     * Will never be null.
     * </p>
     */
    private final JPanel leftPanel;

    /**
     * <p>
     * Represents the right panel in the properties panel.
     * </p>
     *
     * <p>
     * It is created in the constructor and the reference will never changed afterwards although the contained
     * components may change.
     * </p>
     *
     * <p>
     * Will never be null.
     * </p>
     */
    private final JPanel rightPanel;

    /**
     * <p>
     * The <code>UMLModelManager</code> used to retrieve the model of the current project.
     * </p>
     *
     * <p>
     * It is mutable. Set in the constructor and in configureProject method.
     * </p>
     *
     * <p>
     * It will never be null.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * The look and feel of the panel.
     * </p>
     *
     * <p>
     * Set in the constructor, it will never be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     */
    private final LookAndFeel lookAndFeel;

    /**
     * <p>
     * The icon for the link button in the panel.
     * </p>
     *
     * <p>
     * Set in the constructor, it will never change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final Icon linkIcon;

    /**
     * <p>
     * The icon for the add button in the panel.
     * </p>
     *
     * <p>
     * Set in the constructor, it will never change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final Icon addIcon;

    /**
     * <p>
     * The icon for the delete button in the panel.
     * </p>
     *
     * <p>
     * Set in the constructor, it will never change afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final Icon deleteIcon;

    /**
     * <p>
     * This is a list of all the <code>PropertyPanel</code> instance that may go to the left panel of the
     * Properties Panel in the order they should be displayed.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified.
     * </p>
     *
     * <p>
     * Will not be null. Will not be empty; contents will not be modified after construction.
     * </p>
     */
    private final List<PropertyPanel> leftPanelPropertyPanels = new ArrayList<PropertyPanel>();

    /**
     * <p>
     * This is a list of all the PropertyPanel instance that may go to the right panel of the Properties Panel in
     * the order they should be displayed.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference will not be modified.
     * </p>
     *
     * <p>
     * Will not be null. Will not be empty; contents will not be modified after construction.
     * </p>
     */
    private final List<PropertyPanel> rightPanelPropertyPanels = new ArrayList<PropertyPanel>();

    /**
     * <p>
     * This provides a mapping from an interface (as a <code>Class</code> object) to the mapping string necessary
     * to obtain stereotypes list for the interface.
     * </p>
     *
     * <p>
     * Created in the constructor and its reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null. Will not be empty; contents will not be modified after construction.
     * </p>
     */
    private final Map<java.lang.Class<?>, String> stereotypeMappings = new HashMap<java.lang.Class<?>, String>();

    private DiagramNamePanel diagramNamePanel = null;

    /**
     * <p>
     * Creates a new <code>PropertiesPanel</code> with configuration retrieved from the default namespace.
     * </p>
     *
     * <p>
     * For detail information, please refer to {@link PropertiesPanel#PropertiesPanel(String, UMLModelManager)}.
     * </p>
     *
     * @param umlModelManager
     *            the UMLModelManager used by this panel
     * @throws PropertiesPanelConfigurationException
     *
     * @throws IllegalArgumentException
     *             if either argument is null
     * @throws PropertiesPanelConfigurationException
     *             if there are problems in retrieving configuration properties
     */
    public PropertiesPanel(UMLModelManager umlModelManager) throws PropertiesPanelConfigurationException {
        this(DEFAULT_NAMESPACE, umlModelManager);
    }

    /**
     * <p>
     * Creates a new PropertiesPanel with configuration retrieved from the given namespace.
     * </p>
     *
     * <p>
     * For the configuration details, please refer to the <b>Component Specification.</b>
     * </p>
     * <p>
     * V1.1 Change Note: the new label layout is used as the prototype.
     * </p>
     *
     * @param namespace
     *            the namespace from which to retrieve the configuration properties
     * @param umlModelManager
     *            the UMLModelManager used by this panel
     *
     * @throws IllegalArgumentException
     *             if any of the argument is null or namespace is empty string
     * @throws PropertiesPanelConfigurationException
     *             if there are problems in retrieving configuration properties; this includes missing required
     *             properties or invalid property values
     */
    public PropertiesPanel(String namespace, UMLModelManager umlModelManager)
        throws PropertiesPanelConfigurationException {
        Util.checkString(namespace, "namespace");
        Util.checkNull(umlModelManager, "umlModelManager");

        this.umlModelManager = umlModelManager;

        this.linkIcon = new ImageIcon(getString(namespace, "LinkButtonImagePath", true));
        this.addIcon = new ImageIcon(getString(namespace, "AddButtonImagePath", true));
        this.deleteIcon = new ImageIcon(getString(namespace, "DeleteButtonImagePath", true));

        // load the LookAndFeelClass configuration value
        String lookAndFeelClass = getString(namespace, "LookAndFeelClass", false);

        if (lookAndFeelClass != null) {
            try {
                this.lookAndFeel = (LookAndFeel) java.lang.Class.forName(lookAndFeelClass).newInstance();
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (InstantiationException e) {
                throw new PropertiesPanelConfigurationException("Failed to instantiate the [" + lookAndFeelClass
                    + "] class.", e);
            } catch (IllegalAccessException e) {
                throw new PropertiesPanelConfigurationException("Failed to access the [" + lookAndFeelClass
                    + "] class.", e);
            } catch (ClassNotFoundException e) {
                throw new PropertiesPanelConfigurationException("Failed to find the [" + lookAndFeelClass
                    + "] class.", e);
            } catch (ClassCastException e) {
                throw new PropertiesPanelConfigurationException("Failed to cast the [" + lookAndFeelClass
                    + "] instance to [javax.swing.LookAndFeel] instance.", e);
            } catch (UnsupportedLookAndFeelException e) {
                throw new PropertiesPanelConfigurationException("The configured LookAndFeel is not supported.", e);
            }
        } else {
            this.lookAndFeel = null;
        }

        loadStereotypeMappings(namespace);

        List<Multiplicity> multiplicities = readMultiplicities(namespace);

        leftPanel = new JPanel(new GridBagLayout());
        rightPanel = new JPanel(new GridBagLayout());

        addLeftPropertyPanels(multiplicities);
        addRightPropertyPanels();

        diagramNamePanel = new DiagramNamePanel(this);

        // initializes the GUI layouts
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        add(leftPanel, constraints);

        Util.setFixedSize(rightPanel, 500, 150);

        constraints.gridx = 1;
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        add(rightPanel, constraints);

        setMinimumSize(new Dimension(800, 400));
        setPreferredSize(new Dimension(1000, 500));
    }

    /**
     * <p>
     * This method initializes the <code>leftPanelPropertyPanels</code> with all the possible
     * <code>PropertyPanel</code> instances.
     * </p>
     *
     * @param multiplicities
     *            the <code>Multiplicity</code> list loaded from configuration file for the
     *            <code>MultiplicityPropertyPanel</code> instance.
     * @throws PropertiesPanelConfigurationException
     *             if the multiplicities loaded from configuration file are not valid
     * @since 1.1
     */
    private void addLeftPropertyPanels(List<Multiplicity> multiplicities)
        throws PropertiesPanelConfigurationException {
        leftPanelPropertyPanels.add(new NamePropertyPanel(this));
        leftPanelPropertyPanels.add(new NamespacePropertyPanel(this, linkIcon));
        leftPanelPropertyPanels.add(new OwnerPropertyPanel(this, linkIcon));
        leftPanelPropertyPanels.add(new TypePropertyPanel(this, linkIcon));
        leftPanelPropertyPanels.add(new InitialValuePropertyPanel(this));
        leftPanelPropertyPanels.add(new GuardPropertyPanel(this));
        leftPanelPropertyPanels.add(new IncomingTransitionPropertyPanel(this));
        leftPanelPropertyPanels.add(new OutgoingTransitionPropertyPanel(this));

        try {
            leftPanelPropertyPanels.add(new MultiplicityPropertyPanel(this, multiplicities));
        } catch (IllegalArgumentException e) {
            throw new PropertiesPanelConfigurationException("Invalid multiplicities loaded from configuration.", e);
        }

        leftPanelPropertyPanels.add(new ConcurrencyPropertyPanel(this));
        leftPanelPropertyPanels.add(new AssociationEndsPropertyPanel(this));
        leftPanelPropertyPanels.add(new SupplierLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new ClientLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new ParentLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new ChildLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new AssociationLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new BaseLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new ExtensionLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new AdditionLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new SourceLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new TargetLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new OwnerLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new ActionLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new StimulusLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new NamespaceLinkPropertyPanel(this));
        leftPanelPropertyPanels.add(new AttributePropertyPanel(this));
        leftPanelPropertyPanels.add(new OperationPropertyPanel(this));
        leftPanelPropertyPanels.add(new ModifiersPropertyPanel(this));
        leftPanelPropertyPanels.add(new ChangeabilityPropertyPanel(this));
        leftPanelPropertyPanels.add(new VisibilityPropertyPanel(this));
        leftPanelPropertyPanels.add(new KindPropertyPanel(this));
        leftPanelPropertyPanels.add(new OrderingPropertyPanel(this));
        leftPanelPropertyPanels.add(new AggregationPropertyPanel(this));
    }

    /**
     * <p>
     * This method initializes the <code>rightPanelPropertyPanels</code> with all the possible
     * <code>PropertyPanel</code> instances.
     * </p>
     *
     * @since 1.1
     */
    private void addRightPropertyPanels() {
        rightPanelPropertyPanels.add(new ParameterListPropertyPanel(this, deleteIcon, addIcon));
        rightPanelPropertyPanels.add(new StereotypeListPropertyPanel(this, addIcon, deleteIcon));
    }

    /**
     * <p>
     * This method loads the stereotype mappings from the configuration namespace.
     * </p>
     *
     * @param namespace
     *            the namespace for the configuration manager
     * @throws PropertiesPanelConfigurationException
     *             if there are problems in retrieving configuration properties; this includes missing required
     *             properties or invalid property values
     */
    private void loadStereotypeMappings(String namespace) throws PropertiesPanelConfigurationException {
        Property stereotypeMappingProperty = getRequiredProperty(namespace, "StereotypeMapping");

        for (int i = 0; i < STEREOTYPE_MAPPING_KEYS.length; i++) {
            String value = getPropertyValue(stereotypeMappingProperty, STEREOTYPE_MAPPING_PROPERTIES[i]);
            stereotypeMappings.put(STEREOTYPE_MAPPING_KEYS[i], value);
        }
    }

    /**
     * <p>
     * This method loads the <code>Multiplicity</code> lists from the configuration namespace.
     * </p>
     *
     * @param namespace
     *            the namespace for the configuration manager
     * @return the <code>Multiplicity</code> lists from the configuration namespace.
     * @throws PropertiesPanelConfigurationException
     *             if there are problems in retrieving configuration properties; this includes missing required
     *             properties or invalid property values
     */
    private List<Multiplicity> readMultiplicities(String namespace) throws PropertiesPanelConfigurationException {
        List<Multiplicity> multiplicities = new ArrayList<Multiplicity>();

        Property multiplicitiesProperty = getRequiredProperty(namespace, "Multiplicities");

        for (java.lang.Object multiplicityObj : multiplicitiesProperty.list()) {
            Property prop = (Property) multiplicityObj;

            Multiplicity multiplicity = new MultiplicityImpl();

            for (java.lang.Object rangeObj : prop.list()) {
                Property childProp = (Property) rangeObj;
                MultiplicityRange range = new MultiplicityRangeImpl();

                // get the lower bound value
                int lower = parseBoundProperty(childProp, "LowerBound");

                if (lower == -1) {
                    lower = 0;
                }

                if (lower == Integer.MAX_VALUE) {
                    throw new PropertiesPanelConfigurationException(
                        "The value for LowerBound property cannot be [*].");
                }

                range.setLower(lower);

                // get the upper bound value
                int upper = parseBoundProperty(childProp, "UpperBound");

                // the property is missing then the upper value is set to Integer.MAX_VALUE
                if (upper == -1) {
                    upper = Integer.MAX_VALUE;
                }

                range.setUpper(upper);

                range.setMultiplicity(multiplicity);
                multiplicity.addRange(range);
            }

            // At least one MultiplicityRange should be configured
            if (multiplicity.countRanges() == 0) {
                throw new PropertiesPanelConfigurationException("No multiplicity ranges for the " + prop.getName()
                    + " property.");
            }

            multiplicities.add(multiplicity);
        }

        // At least one Multiplicity should be configured
        if (multiplicities.size() == 0) {
            throw new PropertiesPanelConfigurationException(
                "No child properties are present for the Multiplicities property.");
        }

        return multiplicities;
    }

    /**
     * <p>
     * This method parses lower or upper bound property value.
     * </p>
     *
     * <p>
     * If the bound property is missing, then <code>-1</code> will be returned.
     * </p>
     *
     * @param property
     *            the parent property
     * @param childPropName
     *            the child property name
     * @return the bound property value
     *
     * @throws PropertiesPanelConfigurationException
     *             if the value for the bound property is invalid
     */
    private int parseBoundProperty(Property property, String childPropName)
        throws PropertiesPanelConfigurationException {
        String bound = property.getValue(childPropName);

        // the property is missing
        if (bound == null) {
            return -1;
        }

        if ("*".equals(bound)) {
            return Integer.MAX_VALUE;
        }

        try {
            int value = Integer.parseInt(bound);

            if (value < 0) {
                throw new PropertiesPanelConfigurationException("The value for " + childPropName
                    + " property is negative, it is " + value);
            }

            return value;
        } catch (NumberFormatException e) {
            throw new PropertiesPanelConfigurationException("The value for " + childPropName
                + " property is not an integer, it is " + bound, e);
        }
    }

    /**
     * <p>
     * Configures this panel with a single <code>ModelElement</code> instance.
     * </p>
     *
     * @param modelElement
     *            the <code>ModelElement</code> used whose properties are to be displayed
     *
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public void configurePanel(ModelElement modelElement) {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();
        modelElements.add(modelElement);

        configurePanel(modelElements);
    }

    /**
     * <p>
     * Configures this panel to display property <code>Diagram</code>.
     * </p>
     *
     * @param diagram
     *            a diagram
     */
    public void configurePanel(Diagram diagram) {
        this.validate();
        leftPanel.removeAll();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        leftPanel.add(diagramNamePanel, constraints);

        diagramNamePanel.configureDiagram(diagram);
        rightPanel.removeAll();
    }

    /**
     * <p>
     * Configures this panel to display the common properties of the given list of <code>ModelElement</code>.
     * </p>
     * <p>
     * V1.1 Change Note: the new layout is used as the prototype.
     * </p>
     *
     * @param modelElements
     *            a list of <code>ModelElement</code>
     * @throws IllegalArgumentException
     *             if argument is null or contains null element or empty
     */
    public void configurePanel(List<ModelElement> modelElements) {
        Util.checkCollection(modelElements, "modelElements");
        this.modelElements = modelElements;
        this.validate();

        configureLeftPanel(modelElements);
        configureRightPanel(modelElements);
        validate();
    }

    /**
     * <p>
     * Refreshes this panel data with the most up to date property values from the configured
     * <code>ModelElement</code>.
     * </p>
     * <p>
     * V1.1 Change Note: the new layout is used as the prototype.
     * </p>
     */
    public void refreshPanel() {
        refreshPanel(leftPanelPropertyPanels);
        refreshPanel(rightPanelPropertyPanels);
    }

    /**
     * <p>
     * Refreshes each panel in the given <code>proertyPanels</code> with the most up to date property values from
     * the configured <code>ModelElement</code>.
     * </p>
     *
     * @param proertyPanels
     *            a list of <code>PropertyPanel</code> to refresh
     */
    private void refreshPanel(List<PropertyPanel> proertyPanels) {
        for (PropertyPanel propertyPanel : proertyPanels) {
            propertyPanel.refreshPanel();
        }
    }

    /**
     * <p>
     * Retrieves the currently used <code>UMLModelManager</code>.
     * </p>
     *
     * @return the currently used <code>UMLModelManager</code>.
     */
    public UMLModelManager getUMLModelManager() {
        return umlModelManager;
    }

    /**
     * <p>
     * Configures the PropertiesPanel to suit the current project according to <code>UMLModelManager</code> given.
     * </p>
     *
     * @param umlModelManager
     *            the <code>UMLModelManager</code> to be used by this instance
     *
     * @throws IllegalArgumentException
     *             if either argument is null
     */
    public void configureProject(UMLModelManager umlModelManager) {
        Util.checkNull(umlModelManager, "umlModelManager");

        this.umlModelManager = umlModelManager;
    }

    /**
     * <p>
     * Fires all the registered <code>ModelElementChangeListener</code>.
     * </p>
     *
     * <p>
     * This serves as a notification that a property of the given ModelElement has changed.
     * </p>
     *
     * @param modelElement
     *            the ModelElement whose properties were asked to be modified
     * @param kind
     *            the modified property name
     * @param op
     *            the kind of operation to be done on the property
     * @param o
     *            the Object that will be added/removed or modify the property (depending on PropertyOperation
     *            type)
     *
     * @throws IllegalArgumentException
     *             if modelElement, kind or op is null
     */
    public void firePropertyChangeEvent(ModelElement modelElement, PropertyKind kind, PropertyOperation op,
        java.lang.Object o) {
        Util.checkNull(modelElement, "modelElement");
        Util.checkNull(kind, "property");
        Util.checkNull(op, "op");

        for (ModelElementChangeListener listener : propertyChangeListener) {
            listener.stateChanged(modelElement, kind, op, o);
        }
        if (modelElement instanceof Parameter) {
            for (ModelElement e : modelElements) {

                if (e instanceof Operation) {
                    for (ModelElementChangeListener listener : propertyChangeListener) {
                        // TODO not optimal, why should the parameter is removed for added?
                        Classifier type = ((Parameter) modelElement).getType();
                        listener.stateChanged(e, PropertyKind.PARAMETERS, PropertyOperation.REMOVE, modelElement);
                        ((Parameter) modelElement).setType(type);
                        listener.stateChanged(e, PropertyKind.PARAMETERS, PropertyOperation.ADD, modelElement);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Fires all the registered <code>ModelElementSelectionListener</code>.
     * </p>
     *
     * <p>
     * This serves as a notification that another <code>ModelElement</code> has been given focus by the
     * <code>PropertiesPanel</code>.
     * </p>
     *
     * @param modelElement
     *            the newly selected modelElement
     *
     * @throws IllegalArgumentException
     *             if modelElement is null
     */
    public void fireSelectionChangeEvent(ModelElement modelElement) {
        Util.checkNull(modelElement, "modelElement");

        for (ModelElementSelectionListener listener : selectionChangeListener) {
            listener.selectionChanged(modelElement);
        }
    }

    /**
     * <p>
     * Adds a new <code>ModelElementChangeListener</code>.
     * </p>
     *
     * @param listener
     *            the listener to be added
     * @return true if listener is successfully added, false otherwise
     *
     * @throws IllegalArgumentException
     *             if listener is null
     */
    public boolean addModelElementChangeListener(ModelElementChangeListener listener) {
        Util.checkNull(listener, "listener");

        return propertyChangeListener.add(listener);
    }

    /**
     * <p>
     * Removes a <code>ModelElementChangeListener</code> from this panel.
     * </p>
     *
     * @param listener
     *            the listener to be removed
     * @return true if listener is successfully removed, false otherwise
     *
     * @throws IllegalArgumentException
     *             if listener is null
     */
    public boolean removeModelElementChangeListener(ModelElementChangeListener listener) {
        Util.checkNull(listener, "listener");

        return propertyChangeListener.remove(listener);
    }

    /**
     * <p>
     * Removes all the registered <code>ModelElementChangeListener</code>.
     * </p>
     */
    public void removeAllModelElementChangeListeners() {
        propertyChangeListener.clear();
    }

    /**
     * <p>
     * Adds a new <code>DiagramChangeListener</code>.
     * </p>
     *
     * @param listener
     *            the listener to be added
     * @return true if listener is successfully added, false otherwise
     *
     * @throws IllegalArgumentException
     *             if listener is null
     */
    public boolean addDiagramChangeListener(DiagramChangeListener listener) {
        Util.checkNull(listener, "listener");

        return diagramChangeListener.add(listener);
    }

    /**
     * <p>
     * Removes a <code>DiagramChangeListener</code> from this panel.
     * </p>
     *
     * @param listener
     *            the listener to be removed
     * @return true if listener is successfully removed, false otherwise
     *
     * @throws IllegalArgumentException
     *             if listener is null
     */
    public boolean removeDiagramChangeListener(DiagramChangeListener listener) {
        Util.checkNull(listener, "listener");

        return diagramChangeListener.remove(listener);
    }

    /**
     * <p>
     * Removes all the registered <code>DiagramChangeListener</code>.
     * </p>
     */
    public void removeAllDiagramChangeListeners() {
        diagramChangeListener.clear();
    }

    /**
     * <p>
     * Fires all the registered <code>DiagramChangeListener</code>.
     * </p>
     *
     * <p>
     * This serves as a notification that a property of the given Diagram has changed.
     * </p>
     *
     * @param diagram
     *            the Diagram whose properties were asked to be modified
     * @throws IllegalArgumentException
     *             if modelElement is null
     */
    public void fireDiagramChangeEvent(Diagram diagram) {
        Util.checkNull(diagram, "diagram");

        for (DiagramChangeListener listener : diagramChangeListener) {
            DiagramStateEvent evt = new DiagramStateEvent(diagram);
            listener.diagramStateChanged(evt);
        }
    }

    /**
     * <p>
     * Adds a new <code>ModelElementSelectionListener</code> to this instance.
     * </p>
     *
     * @param listener
     *            the listener to be added
     * @return true if the listener is successfully added, false otherwise
     *
     * @throws IllegalArgumentException
     *             if listener is null
     */
    public boolean addModelElementSelectionListener(ModelElementSelectionListener listener) {
        Util.checkNull(listener, "listener");

        return selectionChangeListener.add(listener);
    }

    /**
     * <p>
     * Removes the specified <code>ModelElementSelectionListener</code> from this panel.
     * </p>
     *
     * @param listener
     *            the listener to be removed
     * @return true if the listener is successfully removed and false otherwise
     *
     * @throws IllegalArgumentException
     *             if listener is null
     */
    public boolean removeModelElementSelectionListener(ModelElementSelectionListener listener) {
        Util.checkNull(listener, "listener");

        return selectionChangeListener.remove(listener);
    }

    /**
     * <p>
     * Removes all registered <code>ModelElementSelectionListener</code>.
     * </p>
     */
    public void removeAllModelElementSelectionListeners() {
        selectionChangeListener.clear();
    }

    /**
     * <p>
     * Retrieves the list of stereotypes for the specified <code>ModelElement</code> class.
     * </p>
     *
     * <p>
     * The stereotypes returned included the configured stereotypes got from the
     * <code>ProjectConfigurationManager</code>.
     * </p>
     *
     * <p>
     * Note, any exception generated during retrieval of stereotypes are ignored.
     * </p>
     *
     * @param modelElementClass
     *            the class of the ModelElement whose allowed stereotypes are to be received
     * @return the list of stereotypes allowed for the given <code>ModelElement</code> class
     *
     * @throws IllegalArgumentException
     *             if modelElementClass is null
     */
    public List<Stereotype> getStereotypes(java.lang.Class<?> modelElementClass) {
        Util.checkNull(modelElementClass, "modelElementClass");

        String mappingString = getMappingString(modelElementClass);

        List<Stereotype> stereotypes = new ArrayList<Stereotype>();

        // Obtain the stereotypes from project configuration manager
        try {
            ProjectConfigurationManager pcm = umlModelManager.getProjectConfigurationManager();
            stereotypes.addAll(pcm.getStandardStereotypes(umlModelManager.getProjectLanguage(), mappingString));
        } catch (ProjectConfigurationException e) {
            // ignore
        } catch (IllegalArgumentException e) {
            // ignore
        } catch (IllegalStateException e) {
            // ignore
        }

        // Adds the remaining stereotypes from model
        Model model = umlModelManager.getModel();

        for (ModelElement element : model.getOwnedElements()) {
            if (element instanceof Stereotype) {
                if ((((Stereotype) element).getBaseClass() == null)
                    || ((Stereotype) element).getBaseClass().equals(mappingString)
                    || ((Stereotype) element).getBaseClass().equals(modelElementClass.getName())) {
                    boolean isStandard = false;

                    for (Stereotype stereotype : stereotypes) {
                        if (stereotype.getName().equals(element.getName())) {
                            stereotypes.set(stereotypes.indexOf(stereotype), (Stereotype) element);
                            isStandard = true;

                            break;
                        }
                    }

                    if (!isStandard) {
                        stereotypes.add((Stereotype) element);
                    }
                }
            }
        }

        return stereotypes;
    }

    /**
     * <p>
     * Adds the set of stereotypes for the specified <code>ModelElement</code> class.
     * </p>
     * <p>
     * Note, any exception generated during retrieval of stereotypes are ignored.
     * </p>
     *
     * @param modelElementClass
     *            the class of the ModelElement whose allowed stereotypes are to be received
     * @param newStereotypes
     *            the set of stereotypes added for the given <code>ModelElement</code> class
     * @throws IllegalArgumentException
     *             if modelElementClass is null
     */
    public void addStereotypes(Set<Stereotype> newStereotypes, java.lang.Class<?> modelElementClass) {
        Util.checkNull(modelElementClass, "modelElementClass");

        List<Stereotype> standardStereotypes = getStereotypes(modelElementClass);
        Model model = umlModelManager.getModel();

        for (Stereotype stereotype : newStereotypes) {
            if (!standardStereotypes.contains(stereotype)) {
                model.addOwnedElement(stereotype);
            }
        }
    }

    /**
     * <p>
     * Gets the mapping string for the given model element class.
     * </p>
     *
     * @param modelElementClass
     *            the class of the ModelElement whose allowed stereotypes are to be received
     * @return the mapping string for the given model element class.
     */
    public String getMappingString(java.lang.Class<?> modelElementClass) {
        java.lang.Class<?>[] interfaces = modelElementClass.getInterfaces();

        // It is guaranteed that the interface can be found
        java.lang.Class<?> lowestInterface = null;

        for (java.lang.Class<?> type : interfaces) {
            if (lowestInterface == null) {
                lowestInterface = type;
            } else {
                if (lowestInterface.isAssignableFrom(type)) {
                    lowestInterface = type;
                }
            }
        }

        return stereotypeMappings.get(lowestInterface);
    }

    /**
     * <p>
     * Gets a required child property from the given namespace with the given name.
     * </p>
     *
     * <p>
     * If the property is missing, then exception will be thrown.
     * </p>
     *
     * @param namespace
     *            the namespace from which to retrieve the configuration properties
     * @param name
     *            the name of the property
     * @return the child property under the parent property with the given name
     *
     * @throws PropertiesPanelConfigurationException
     *             if the property is missing or namespace is unknown
     */
    private Property getRequiredProperty(String namespace, String name)
        throws PropertiesPanelConfigurationException {
        Property property = null;

        try {
            property = ConfigManager.getInstance().getPropertyObject(namespace, name);
        } catch (UnknownNamespaceException e) {
            throw new PropertiesPanelConfigurationException("UnknownNamespaceException occurs "
                + "when accessing ConfigManager.", e);
        }

        if (property == null) {
            throw new PropertiesPanelConfigurationException("The property [" + name + "] is missing.");
        }

        return property;
    }

    /**
     * <p>
     * Gets the property value under the given parent parent property with the given name.
     * </p>
     *
     * @param prop
     *            the parent property
     * @param name
     *            the name of the child property
     *
     * @return the child property value under the parent property with the given name
     *
     * @throws PropertiesPanelConfigurationException
     *             if the property is missing or the value is null or empty string
     */
    private String getPropertyValue(Property prop, String name) throws PropertiesPanelConfigurationException {
        Property subProp = prop.getProperty(name);

        if (subProp == null) {
            throw new PropertiesPanelConfigurationException("The property [ " + name + " ] under ["
                + prop.getName() + "] property is missing.");
        }

        String value = subProp.getValue();

        if ((value == null) || (value.trim().length() == 0)) {
            throw new PropertiesPanelConfigurationException("The value for property [ " + name + " ] under ["
                + prop.getName() + "] property is null or empty.");
        }

        return value.trim();
    }

    /**
     * <p>
     * Return the value of the property.
     * </p>
     *
     * @param namespace
     *            the namespace to get
     * @param propertyName
     *            the name of property
     * @param required
     *            whether this property is required
     *
     * @return the value of the property
     *
     * @throws PropertiesPanelConfigurationException
     *             if fail to load the config values
     */
    private String getString(String namespace, String propertyName, boolean required)
        throws PropertiesPanelConfigurationException {
        try {
            String property = ConfigManager.getInstance().getString(namespace, propertyName);

            // Empty property value is not allowed
            if ((property != null) && (property.trim().length() == 0)) {
                throw new PropertiesPanelConfigurationException("Property " + propertyName + " is empty.");
            }

            // This property is missed
            if (required && (property == null)) {
                throw new PropertiesPanelConfigurationException("Property " + propertyName + " is missing.");
            }

            return property;
        } catch (UnknownNamespaceException e) {
            throw new PropertiesPanelConfigurationException(
                "UnknownNamespaceException occurs when accessing ConfigManager.", e);
        }
    }

    /**
     * <p>
     * Retrieves the list of ModelElement that this list is configured to use.
     * </p>
     *
     * @return a list of ModelElement that this list is configured to use; may return null if the panel is not
     *         configured yet
     */
    public List<ModelElement> getConfiguredModelElements() {
        return modelElements;
    }

    /**
     * <p>
     * Configure the left panel if there is only one element type selected.
     * </p>
     *
     * @param <T>
     *            the model element type
     * @param elementClass
     *            the model element class
     * @return true is the left panel is configured, false if cannot process such single element type
     * @since 1.1
     */
    private <T extends ModelElement> boolean configureSingleElementPanel(java.lang.Class<T> elementClass) {
        if (Operation.class.isAssignableFrom(elementClass)) {
            configureOperationPanel();
        } else if (Attribute.class.isAssignableFrom(elementClass)) {
            configureAttributePanel();
        } else if (Class.class.isAssignableFrom(elementClass) || (Interface.class.isAssignableFrom(elementClass))) {
            configureClassPanel();
        } else if (AssociationEnd.class.isAssignableFrom(elementClass)) {
            configureAssociationEndPanel();
        } else if (Package.class.isAssignableFrom(elementClass)) {
            // set the fixed size and use single column layout
            JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
            // Util.setFixedSize(modifiersPanel, 247, 45);
            modifiersPanel.setMinimumSize(new Dimension(247, 45));
            return false;
        } else if (Parameter.class.isAssignableFrom(elementClass)) {
            // set the fixed size and use single column layout
            JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
            Util.setFixedSize(modifiersPanel, 247, 45);

            JPanel kindPanel = getJPanel(leftPanelPropertyPanels, KindPropertyPanel.class);
            Util.setFixedSize(kindPanel, 247, 45);

            return false;
        } else if (Association.class.isAssignableFrom(elementClass)) {
            // set the fixed size and use single column layout
            JPanel associationEndsPanel = getJPanel(leftPanelPropertyPanels, AssociationEndsPropertyPanel.class);
            Util.setFixedSize(associationEndsPanel, 247, 45);

            return false;
        } else if (UseCase.class.isAssignableFrom(elementClass)) {
            // set the fixed size and use single column layout
            JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
            Util.setFixedSize(modifiersPanel, 335, 45);

            JPanel visibilityPanel = getJPanel(leftPanelPropertyPanels, VisibilityPropertyPanel.class);
            Util.setFixedSize(visibilityPanel, 335, 45);

            return false;
        } else {
            // use single column layout
            return false;
        }

        return true;
    }

    /**
     * <p>
     * Configure the left panel if there is only <code>Operation</code> element type. Refer to prototype for more
     * details about layout.
     * </p>
     *
     * @since 1.1
     */
    private void configureOperationPanel() {
        // retrieve sub-panels
        JPanel namePanel = getJPanel(leftPanelPropertyPanels, NamePropertyPanel.class);
        JPanel ownerPanel = getJPanel(leftPanelPropertyPanels, OwnerPropertyPanel.class);
        JPanel concurrencyPanel = getJPanel(leftPanelPropertyPanels, ConcurrencyPropertyPanel.class);
        JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
        JPanel visibilityPanel = getJPanel(leftPanelPropertyPanels, VisibilityPropertyPanel.class);

        // draft layout:
        // -------------------------------
        // | name | owner |
        // -------------------------------
        // | concurrency | modifiers |
        // -------------------------------
        // | visibility |
        // -------------------------------
        addLeftPanel(namePanel, 0, 0, 2, GridBagConstraints.NONE);
        addLeftPanel(ownerPanel, 0, 1, 2, GridBagConstraints.NONE);
        addLeftPanel(concurrencyPanel, 0, 2, 1, 130, 45, GridBagConstraints.NONE);
        addLeftPanel(modifiersPanel, 1, 2, 1, 195, 45, GridBagConstraints.NONE);
        addLeftPanel(visibilityPanel, 0, 3, 2, 335, 45, GridBagConstraints.NONE);
        addLeftEmptyPanel(2, 4);
    }

    /**
     * <p>
     * Configure the left panel if there is only <code>Attribute</code> element type. Refer to prototype for more
     * details about layout.
     * </p>
     *
     * @since 1.1
     */
    private void configureAttributePanel() {
        // retrieve sub-panels
        JPanel namePanel = getJPanel(leftPanelPropertyPanels, NamePropertyPanel.class);
        JPanel initialValuePanel = getJPanel(leftPanelPropertyPanels, InitialValuePropertyPanel.class);
        JPanel typePanel = getJPanel(leftPanelPropertyPanels, TypePropertyPanel.class);
        JPanel multiplicityPanel = getJPanel(leftPanelPropertyPanels, MultiplicityPropertyPanel.class);
        JPanel changeabilityPanel = getJPanel(leftPanelPropertyPanels, ChangeabilityPropertyPanel.class);
        JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
        JPanel visibilityPanel = getJPanel(leftPanelPropertyPanels, VisibilityPropertyPanel.class);

        // draft layout:
        // -----------------------------------
        // | name | initial value |
        // -----------------------------------
        // | type | multiplicity |
        // -----------------------------------
        // | changeability | modifiers |
        // -----------------------------------
        // | visibility |
        // -----------------------------------
        addLeftPanel(namePanel, 0, 0, 1, GridBagConstraints.NONE);
        addLeftPanel(initialValuePanel, 1, 0, 1, GridBagConstraints.NONE);
        addLeftPanel(typePanel, 0, 1, 1, GridBagConstraints.NONE);
        addLeftPanel(multiplicityPanel, 1, 1, 1, GridBagConstraints.NONE);
        addLeftPanel(changeabilityPanel, 0, 2, 1, 275, 45, GridBagConstraints.NONE);
        addLeftPanel(modifiersPanel, 1, 2, 1, 210, 45, GridBagConstraints.NONE);
        addLeftPanel(visibilityPanel, 0, 3, 2, 330, 45, GridBagConstraints.NONE);
        addLeftEmptyPanel(2, 4);
    }

    /**
     * <p>
     * Configure the left panel if there is only <code>Class</code> element type. Refer to prototype for more
     * details about layout.
     * </p>
     *
     * @since 1.1
     */
    private void configureClassPanel() {
        // retrieve sub-panels
        JPanel namePanel = getJPanel(leftPanelPropertyPanels, NamePropertyPanel.class);
        JPanel namespacePanel = getJPanel(leftPanelPropertyPanels, NamespacePropertyPanel.class);
        JPanel attributePanel = getJPanel(leftPanelPropertyPanels, AttributePropertyPanel.class);
        JPanel operationPanel = getJPanel(leftPanelPropertyPanels, OperationPropertyPanel.class);
        JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
        JPanel visibilityPanel = getJPanel(leftPanelPropertyPanels, VisibilityPropertyPanel.class);

        // draft layout:
        // ---------------------------------
        // | name | attribute |
        // ---------------------------------
        // | namespace | operation |
        // ---------------------------------
        // | modifiers |
        // ---------------------------------
        // | visibility |
        // ---------------------------------
        addLeftPanel(namePanel, 0, 0, 1, GridBagConstraints.HORIZONTAL);
        addLeftPanel(attributePanel, 1, 0, 1, GridBagConstraints.NONE);
        addLeftPanel(namespacePanel, 0, 1, 1, GridBagConstraints.HORIZONTAL);
        addLeftPanel(operationPanel, 1, 1, 1, GridBagConstraints.NONE);
        addLeftPanel(modifiersPanel, 0, 2, 2, 330, 45, GridBagConstraints.NONE);
        addLeftPanel(visibilityPanel, 0, 3, 2, 330, 45, GridBagConstraints.NONE);
        addLeftEmptyPanel(0, 4);
    }

    /**
     * <p>
     * Configure the left panel if there is only <code>AssociationEnd</code> element type. Refer to prototype for
     * more details about layout.
     * </p>
     *
     * @since 1.1
     */
    private void configureAssociationEndPanel() {
        // retrieve sub-panels
        JPanel namePanel = getJPanel(leftPanelPropertyPanels, NamePropertyPanel.class);
        JPanel initialValuePanel = getJPanel(leftPanelPropertyPanels, InitialValuePropertyPanel.class);
        JPanel typePanel = getJPanel(leftPanelPropertyPanels, TypePropertyPanel.class);
        JPanel multiplicityPanel = getJPanel(leftPanelPropertyPanels, MultiplicityPropertyPanel.class);
        JPanel changeabilityPanel = getJPanel(leftPanelPropertyPanels, ChangeabilityPropertyPanel.class);
        JPanel modifiersPanel = getJPanel(leftPanelPropertyPanels, ModifiersPropertyPanel.class);
        JPanel visibilityPanel = getJPanel(leftPanelPropertyPanels, VisibilityPropertyPanel.class);
        JPanel orderingPanel = getJPanel(leftPanelPropertyPanels, OrderingPropertyPanel.class);
        JPanel aggregationPanel = getJPanel(leftPanelPropertyPanels, AggregationPropertyPanel.class);

        // draft layout:
        // -----------------------------------
        // | name | initial value |
        // -----------------------------------
        // | type | multiplicity |
        // -----------------------------------
        // | aggregation | changeability |
        // -----------------------------------
        // | ordering | modifiers |
        // -----------------------------------
        // | visibility |
        // -----------------------------------
        addLeftPanel(namePanel, 0, 0, 2, GridBagConstraints.HORIZONTAL);
        addLeftPanel(initialValuePanel, 2, 0, 1, GridBagConstraints.NONE);
        addLeftPanel(typePanel, 0, 1, 2, GridBagConstraints.HORIZONTAL);
        addLeftPanel(multiplicityPanel, 2, 1, 1, GridBagConstraints.NONE);
        addLeftPanel(aggregationPanel, 0, 2, 1, 275, 45, GridBagConstraints.NONE);
        addLeftPanel(changeabilityPanel, 1, 2, 2, 247, 45, GridBagConstraints.NONE);
        addLeftPanel(orderingPanel, 0, 3, 1, 275, 45, GridBagConstraints.NONE);
        addLeftPanel(modifiersPanel, 1, 3, 2, 247, 45, GridBagConstraints.NONE);
        addLeftPanel(visibilityPanel, 0, 4, 2, 330, 45, GridBagConstraints.NONE);
        addLeftEmptyPanel(2, 5);
    }

    /**
     * <p>
     * Gets the property panel with specified panel type in given panel list.
     * </p>
     *
     * @param <T>
     *            type of property panel
     * @param proertyPanels
     *            the property panel list
     * @param panelClass
     *            the class of desired property panel
     * @return the property panel with specified type
     * @since 1.1
     */
    private <T extends PropertyPanel> T getPanel(List<PropertyPanel> proertyPanels, java.lang.Class<T> panelClass) {
        // return the first panel that matches given type
        for (PropertyPanel panel : proertyPanels) {
            if (panel.getClass().equals(panelClass)) {
                return panelClass.cast(panel);
            }
        }

        // nothing found, return null
        return null;
    }

    /**
     * <p>
     * Gets the <code>JPanel</code> with specified panel type in given panel list.
     * </p>
     *
     * @param <T>
     *            type of property panel
     * @param proertyPanels
     *            the property panel list
     * @param panelClass
     *            the class of desired property panel
     * @return the JPanel with specified type
     * @since 1.1
     */
    private <T extends PropertyPanel> JPanel getJPanel(List<PropertyPanel> proertyPanels,
        java.lang.Class<T> panelClass) {
        return getPanel(proertyPanels, panelClass).retrievePanel();
    }

    /**
     * <p>
     * Configure left panel in one column style. All visible property panels will be add from top to down.
     * </p>
     *
     * @since 1.1
     */
    private void configureOneColumnPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(3, 5, 3, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        // add each panel to the left size from top to down
        for (PropertyPanel propertyPanel : this.leftPanelPropertyPanels) {
            if (propertyPanel.isVisible()) {
                leftPanel.add(propertyPanel.retrievePanel(), constraints);
                constraints.gridy++;
            }
        }

        // add an extra empty panel that takes all extra space when resizing
        constraints.weightx = 1;
        constraints.weighty = 1;
        leftPanel.add(new JPanel(), constraints);
    }

    /**
     * <p>
     * Configure the right panel with the given model element list.
     * </p>
     *
     * @param modelElements
     *            the list of <code>ModelElement</code> to configure
     * @since 1.1
     */
    private void configureRightPanel(List<ModelElement> modelElements) {
        rightPanel.removeAll();

        // configure parameter list panel
        ParameterListPropertyPanel parameterPanel =
            getPanel(rightPanelPropertyPanels, ParameterListPropertyPanel.class);
        parameterPanel.configurePanel(modelElements);

        // configure stereotype list panel
        StereotypeListPropertyPanel stereotypePanel =
            getPanel(rightPanelPropertyPanels, StereotypeListPropertyPanel.class);
        stereotypePanel.configurePanel(modelElements);

        // parameter panel has a fixed horizontal size
        // stereotype panel could be resized
        // the max total size is 500.
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;

        int stereotypeWidth = 500;

        // add the parameter panel
        if (parameterPanel.isVisible()) {
            constraints.weightx = 0;
            constraints.fill = GridBagConstraints.VERTICAL;
            constraints.anchor = GridBagConstraints.EAST;

            JPanel panel = parameterPanel.retrievePanel();
            Util.setFixedSize(panel, 210, 150);
            rightPanel.add(panel, constraints);
            stereotypeWidth = 300;
            constraints.gridx = 1;
        }

        // add the stereotype panel
        if (stereotypePanel.isVisible()) {
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.anchor = GridBagConstraints.EAST;

            JPanel panel = stereotypePanel.retrievePanel();
            panel.setPreferredSize(new Dimension(100, 150));
            panel.setMinimumSize(new Dimension(100, 150));
            panel.setMaximumSize(new Dimension(stereotypeWidth, 150));
            rightPanel.add(panel, constraints);
        }

        rightPanel.validate();
    }

    /**
     * <p>
     * Configure the left panel with the given model element list.
     * </p>
     *
     * @param modelElements
     *            the list of <code>ModelElement</code> to configure
     * @since 1.1
     */
    private void configureLeftPanel(List<ModelElement> modelElements) {
        leftPanel.removeAll();

        // configure each property panel
        for (PropertyPanel propertyPanel : leftPanelPropertyPanels) {
            propertyPanel.configurePanel(modelElements);
        }

        // check if modelElements contains only single type of elements.
        boolean signleElement = true;
        ModelElement firstElement = modelElements.iterator().next();

        for (ModelElement element : modelElements) {
            if (!firstElement.getClass().equals(element.getClass())) {
                signleElement = false;

                break;
            }
        }

        // if only one element type, try to configure single element panel
        // otherwise use the one column layout.
        if (!signleElement || !configureSingleElementPanel(firstElement.getClass())) {
            configureOneColumnPanel();
        }

        leftPanel.validate();
        leftPanel.repaint();
    }

    /**
     * <p>
     * Adds given panel to left panel with specified position and size.
     * </p>
     *
     * @param panel
     *            the panel to add
     * @param x
     *            the x position
     * @param y
     *            the y position
     * @param size
     *            the panel size
     * @since 1.1
     */
    private void addLeftPanel(JPanel panel, int x, int y, int size, int fill) {
        addLeftPanel(panel, x, y, size, -1, -1, fill);
    }

    /**
     * <p>
     * Adds given panel to left panel with specified position size and fixed width/height.
     * </p>
     *
     * @param panel
     *            the panel to add
     * @param x
     *            the x position
     * @param y
     *            the y position
     * @param size
     *            the panel size
     * @param width
     *            the fixed panel width, negative number for not available.
     * @param height
     *            the fixed panel height, negative number for not available.
     * @since 1.1
     */
    private void addLeftPanel(JPanel panel, int x, int y, int size, int width, int height, int fill) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = size;
        constraints.weightx = fill == GridBagConstraints.HORIZONTAL ? 1 : 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(3, 5, 3, 5);
        constraints.fill = fill;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        if ((width >= 0) && (height >= 0)) {
            Util.setFixedSize(panel, width, height);
        }

        leftPanel.add(panel, constraints);
    }

    /**
     * <p>
     * Add an empty panel to left panel, which will take up the extra space when resizing.
     * </p>
     *
     * @param x
     *            the x position.
     * @param y
     *            the y position.
     * @since 1.1
     */
    private void addLeftEmptyPanel(int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        JPanel comp = new JPanel();
        leftPanel.add(comp, constraints);
    }

}
