/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyPanel;
import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;

/**
 * <p>
 * This is an abstract base implementing <code>PropertyPanel</code> interface.
 * </p>
 *
 * <p>
 * It provides a common functionalities needed by all of the concrete implementations of
 * <code>PropertyPanel</code> interface.
 * </p>
 *
 * <p>
 * The class provides with the functionality of configuring the <code>ModelElement</code> associated with
 * the <code>PropertyPanel</code> and determining the visibility of the <code>PropertyPanel</code>.
 * </p>
 *
 * <p>
 * Note, all the {@link PropertyPanel#refreshPanel()} concrete implementation <b>MUST</b> check that
 * {@link PropertyPanel#isVisible()} returns true before performing anything else.
 * If {@link PropertyPanel#isVisible()} returns false, return immediately.
 * </p>
 *
 * <p>
 * Thread-safety: This abstract class is not thread-safe since some of its members are mutable.
 * </p>
 * <p>
 * V1.1 Change Note: add some helper methods that could be used be subclasses.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public abstract class AbstractPropertyPanel implements PropertyPanel {
    /**
     * <p>
     * This is a mapping from the property kind to all its supported <code>ModelElement</code> types.
     * </p>
     *
     * <p>
     * This variable is static and is initialized in static initialization.
     * </p>
     *
     * <p>
     * This is frozen and it won't be changed after initialization.
     * </p>
     */
    private static final Map<PropertyKind, java.lang.Class[]> KIND_TO_ELEMENTTYPES
        = new HashMap<PropertyKind, java.lang.Class[]>();

    /**
     * <p>
     * The list of <code>PropertyKind</code> supported by this implementation.
     * </p>
     *
     * <p>
     * It is set during construction and it is never modified afterwards.
     * </p>
     *
     * <p>
     * Will never be null or empty (at least 1 property must be supported).
     * </p>
     */
    private final List<PropertyKind> properties;

    /**
     * <p>
     * The <code>JPanel</code> used to display the property panel.
     * </p>
     *
     * <p>
     * It is created by the constructor and modified by the child classes in configurePanel and refreshPanel.
     * </p>
     *
     * <p>
     * Its reference will not be modified afterwards. Will not be null.
     * </p>
     */
    private final JPanel panel;

    /**
     * <p>
     * The list of configured <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * The <code>PropertyPanel</code> will only fire events for <code>ModelElement</code> instances
     * that are configured.
     * </p>
     *
     * <p>
     * Initially set to null, the value is set through configurePanel and setConfiguredModelElements method
     * and accessed through getConfiguredModelElements.
     * </p>
     *
     * <p>
     * May not be empty.
     * </p>
     */
    private List<ModelElement> modelElements;

    /**
     * <p>
     * Represents the <code>PropertiesPanel</code> owning this element.
     * </p>
     *
     * <p>
     * Set in the constructor and will never be changed afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final PropertiesPanel propertiesPanel;

    /**
     * <p>
     * The flag to indicate whether this panel is already configured.
     * </p>
     *
     * <p>
     * The value is false before configurePanel is called for the first time and during subsequent
     * re-configuration/panel refresh.
     * </p>
     *
     * <p>
     * Accessed by isConfigured and set by setConfigured.
     * </p>
     */
    private boolean configured = false;

    /**
     * <p>
     * The expected visibility of this <code>PropertyPanel</code>.
     * </p>
     *
     * <p>
     * If the panel is supposed to be visible (i.e. property is supported by the ModelElement0,
     * the value will be true, otherwise it will be false).
     * </p>
     *
     * <p>
     * Initially false, it is modified in configurePanel and accessed by isVisible.
     * </p>
     */
    private boolean visible = false;

    /**
     * <p>
     * This is a static initialization for this class.
     * </p>
     *
     * <p>
     * This static initialization is used to initialize the <code>KIND_TO_ELEMENTTYPES</code> mapping.
     * </p>
     */
    static {
        // The key of the mapping is PropertyKind while the value is all the supported model element types
        KIND_TO_ELEMENTTYPES.put(PropertyKind.NAME, new Class[0]);
        KIND_TO_ELEMENTTYPES.put(PropertyKind.NAMESPACE, new java.lang.Class[] {Package.class, Interface.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Enumeration.class, Actor.class, UseCase.class,
            Subsystem.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.OWNER, new Class[] {Operation.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.TYPE, new Class[] {Attribute.class, Parameter.class,
            AssociationEnd.class, Object.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.VISIBILITY, new Class[] {Interface.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Enumeration.class, Attribute.class, Operation.class,
            AssociationEnd.class, Actor.class, UseCase.class, Subsystem.class, Object.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.CHANGEABILITY, new Class[] {Attribute.class, AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.INITIAL_VALUE, new Class[] {Attribute.class, AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.GUARD, new Class[] {Transition.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.AGGREGATION, new Class[] {AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.MULTIPLICITY, new Class[] {Attribute.class, AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.KIND, new Class[] {Parameter.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.CONCURRENCY, new Class[] {Operation.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ORDERING, new Class[] {AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.PARAMETERS, new Class[] {Operation.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.STEREOTYPES, new Class[0]);
        KIND_TO_ELEMENTTYPES.put(PropertyKind.OWNER_LINK, new Class[] {Parameter.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.SUPPLIER_LINK, new Class[] {Dependency.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.CLIENT_LINK, new Class[] {Dependency.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.PARENT_LINK, new Class[] {Generalization.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.CHILD_LINK, new Class[] {Generalization.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ASSOCIATION_LINK, new Class[] {AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.BASE_LINK, new Class[] {Extend.class, Include.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.EXTENSION_LINK, new Class[] {Extend.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ADDITION_LINK, new Class[] {Include.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.SOURCE_LINK, new Class[] {Transition.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.TARGET_LINK, new Class[] {Transition.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.INCOMING_TRANSITIONS, new Class[] {StateVertex.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.OUTGOING_TRANSITIONS, new Class[] {StateVertex.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ASSOCIATION_ENDS_LINK, new Class[] {Association.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ACTION_LINK, new Class[] {Stimulus.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.STIMULUS_LINK, new Class[] {Action.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.NAMESPACE_LINK, new Class[] {Dependency.class, Generalization.class,
            Abstraction.class, Association.class, Include.class, Extend.class, Object.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ABSTRACT, new Class[] {Package.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class, Enumeration.class, Operation.class,
            Actor.class, UseCase.class, Subsystem.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.FINAL, new Class[] {Package.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class, Enumeration.class, Operation.class,
            Actor.class, UseCase.class, Subsystem.class, Parameter.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ROOT, new Class[] {Package.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class, Enumeration.class, Actor.class,
            UseCase.class, Subsystem.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.STATIC, new Class[] {com.topcoder.uml.model.core.classifiers.Class.class,
            Interface.class, Enumeration.class, Operation.class, Attribute.class, AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ACTIVE, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.TRANSIENT, new Class[] {Attribute.class, AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.NAVIGABLE, new Class[] {AssociationEnd.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ASYNCHRONOUS, new Class[] {Stimulus.class});
        /*
         * BugFix: UML-9718
         * Add two entries to add attributes and operations.
         */
        KIND_TO_ELEMENTTYPES.put(PropertyKind.OPERATION, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class});
        KIND_TO_ELEMENTTYPES.put(PropertyKind.ATTRIBUTE, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class});

    }

    /**
     * <p>
     * Creates a new <code>AbstractPropertyPanel</code>.
     * </p>
     *
     * @param properties the list of properties supported
     * @param propertiesPanel the <code>PropertiesPanel</code> instance that owns this panel
     *
     * @throws IllegalArgumentException if either argument is null or properties is empty or contain null member
     */
    protected AbstractPropertyPanel(List<PropertyKind> properties, PropertiesPanel propertiesPanel) {
        Util.checkCollection(properties, "properties");
        Util.checkNull(propertiesPanel, "propertiesPanel");
        this.properties = properties;
        this.propertiesPanel = propertiesPanel;

        // The components insides the panel should be left-justified by default
        // Concrete implementations may change the layout
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    }

    /**
     * <p>
     * Executes the logic of the panel.
     * </p>
     *
     * <p>
     * This method is a simple placeholder. It usually contains the logic for firing the events.
     * </p>
     *
     * <p>
     * This serves as a notification that a property of the given <code>ModelElement</code> has changed.
     * </p>
     */
    public abstract void execute();

    /**
     * <p>
     * Determines whether this property panel should be visible when the modelElement is selected.
     * </p>
     *
     * @return true if the panel should be displayed, false otherwise
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * <p>
     * Configures this panel to display the <code>ModelElement</code> given.
     * </p>
     *
     * @param modelElement the ModelElement to configure this panel with
     *
     * @throws IllegalArgumentException if modelElement is null
     */
    public void configurePanel(ModelElement modelElement) {
        Util.checkNull(modelElement, "modelElement");

        List<ModelElement> elements = new ArrayList<ModelElement>();
        elements.add(modelElement);
        configurePanel(elements);
    }

    /**
     * <p>
     * Configures the panel to the given list of <code>ModelElement</code>.
     * </p>
     *
     * @param modelElements the list of ModelElement to configure this panel with
     *
     * @throws IllegalArgumentException if modelElements is null, contains null element, or is empty
     */
    public void configurePanel(List<ModelElement> modelElements) {
        Util.checkCollection(modelElements, "modelElements");

        setConfigured(false);
        setConfiguredModelElements(modelElements);

        visible = calculateVisibility(modelElements);

        // if the panel is visible, then re-layout the swing components inside the panel according the
        // newly configured model elements
        refreshPanel();

        setConfigured(true);
    }

    /**
     * <p>
     * Determines whether this property panel should be visible for the given <code>ModelElement</code> list.
     * </p>
     *
     * @param modelElements the list of ModelElement to configure this panel with
     * @return true if the panel should be displayed, false otherwise
     */
    private boolean calculateVisibility(List<ModelElement> modelElements) {

        for (ModelElement element : modelElements) {
            if (!isModelElementVisible(element, modelElements)) {
                return false;
            }
        }

        return true;
    }

    /**
     * <p>
     * Determines whether this property panel supports the given <code>ModelElement</code> instance.
     * </p>
     *
     * @param element the <code>ModelElement</code> to check
     * @param modelElements all elements to configure
     *
     * @return true if the panel supports the given model element, false otherwise
     */
    private boolean isModelElementVisible(ModelElement element, List<ModelElement> modelElements) {
    	int size = modelElements.size();

        for (PropertyKind kind : properties) {
            // check the model element size constrain
            if (kind.equals(PropertyKind.PARAMETERS) || kind.equals(PropertyKind.OPERATION)
            		|| kind.equals(PropertyKind.ATTRIBUTE)) {
                if (size != 1) {
                    continue;
                }
            }

            //BUGR-115  - stereotypes only when the same elements selected
            if (kind.equals(PropertyKind.STEREOTYPES) && size > 1){
            	boolean same = true;
            	for (ModelElement el : modelElements) {
            		if(!el.getClass().equals(element.getClass())){
            			same = false;
            			break;
            		}

				}
            	if(!same){
            		continue;
            	}

            }

            // check the type according to the property kind
            Class[] types = KIND_TO_ELEMENTTYPES.get(kind);
            if (types != null) {
                // The zero length means all the model elements are supported
                if (types.length == 0) {
                    return true;
                }

                // If the model element is instance of any supported type, then true is returned
                for (Class type : types) {
                    if (type.isInstance(element)) {
                        // we have to treat ASYNCHRONOUS modifier specially
                        if (kind.equals(PropertyKind.ASYNCHRONOUS)) {
                            Stimulus stimulus = (Stimulus) element;

                            Procedure procedure = stimulus.getDispatchAction();
                            return (procedure != null && procedure.getAction() instanceof CallOperationAction);
                        }

                        return true;
                    }
                }
            }
        }

        // The panel doesn't support the given model element
        return false;
    }

    /**
     * <p>
     * Retrieves the <code>JPanel</code> to be displayed by <code>PropertiesPanel</code> class.
     * </p>
     *
     * <p>
     * The panel should only be displayed if isVisible returns true.
     * </p>
     *
     * @return the <code>JPanel</code> to be displayed by <code>PropertiesPanel</code> class
     */
    public JPanel retrievePanel() {
        return panel;
    }

    /**
     * <p>
     * Refreshes the panel.
     * </p>
     *
     * <p>
     * This does not re-configure the panel display but only refreshed the property values displayed
     * to reflect the most up-to-date ModelElement's property values.
     * </p>
     *
     * <p>
     * The method is invoked if a <code>ModelElement</code> whose property is being displayed had
     * its property/properties changed from outside Properties Panel.
     * </p>
     *
     * <p>
     * Note, all the refreshPanel() implementation MUST check that isVisible() returns true before
     * performing anything else. If isVisible() is false, return immediately.
     * Remember to setConfigured(false) before performing refresh logic, and setConfigured(true) afterwards.
     * </p>
     */
    public abstract void refreshPanel();

    /**
     * <p>
     * Determines whether the given property is supported by this instance.
     * </p>
     *
     * @param property the property to be checked
     * @return true if supported and false otherwise
     *
     * @throws IllegalArgumentException if property is null
     */
    public boolean isPropertySupported(PropertyKind property) {
        Util.checkNull(property, "property");

        return properties.contains(property);
    }

    /**
     * <p>
     * Retrieves an unmodifiable list of properties supported by this instance.
     * </p>
     *
     * @return an unmodifiable list of properties supported by this instance
     */
    public List<PropertyKind> getSupportedProperties() {
        return Collections.unmodifiableList(properties);
    }

    /**
     * <p>
     * Retrieves the list of ModelElement that this list is configured to use.
     * </p>
     *
     * @return a list of ModelElement that this list is configured to use;
     * may return null if the panel is not configured yet
     */
    protected List<ModelElement> getConfiguredModelElements() {
        return modelElements == null ? null : new ArrayList<ModelElement>(modelElements);
    }

    /**
     * <p>
     * Sets the list of <code>ModelElement</code> that this instance is configured with.
     * </p>
     *
     * @param modelElements the list of ModelElement that this instance is configured with
     *
     * @throws IllegalArgumentException if the list is null or empty or contains null element
     */
    protected void setConfiguredModelElements(List<ModelElement> modelElements) {
        Util.checkCollection(modelElements, "modelElements");

        this.modelElements = Collections.unmodifiableList(modelElements);
    }

    /**
     * <p>
     * Retrieves the <code>PropertiesPanel</code> that owns this instance.
     * </p>
     *
     * @return the <code>PropertiesPanel</code> that owns this instance
     */
    protected PropertiesPanel getPropertiesPanel() {
        return propertiesPanel;
    }

    /**
     * <p>
     * Determines whether this panel is configured.
     * </p>
     *
     * @return true if the panel is configured, false otherwise
     */
    protected boolean isConfigured() {
        return configured;
    }

    /**
     * <p>
     * Sets the configured flag for this panel.
     * </p>
     *
     * @param value true if the panel is configured or false otherwise
     */
    protected void setConfigured(boolean value) {
        this.configured = value;
    }

    /**
     * <p>
     * Add a text label to the component with a fixed width colon.
     * </p>
     * @param component the component to add
     * @param text the label text
     * @param width the label width
     * @param textWidth the text width
     * @param height the label height
     * @since 1.1
     */
    void addTextLableWithColon(JComponent component, String text, int width, int textWidth, int height) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;

        // add the text label
        JLabel label = new JLabel(text);
        Util.setFixedSize(label, textWidth, height);
        panel.add(label, constraints);

        // add the colon
        constraints.gridx = 1;
        JLabel colonLabel = new JLabel(":");
        Util.setFixedSize(colonLabel, width - textWidth, height);
        panel.add(colonLabel, constraints);
    }


    /**
     * <p>
     * Populates a table panel with given title, button and tables.
     * It could be used in parameter/stereotype list panel.
     * </p>
     *
     * @param panel the parent panel
     * @param title panel title
     * @param button panel button
     * @param tables the tables to add
     * @since 1.1
     */
    void populateTabelPanel(JPanel panel, String title, JButton button, JTable[] tables) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(2, 4, 2, 4);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        // add the title
        panel.add(new JLabel(title), constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        Util.setFixedSize(button, 25, 20);
        // add the button
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;

        // add a panel containing sub-tables.
        JPanel tablePanel = new JPanel(new GridBagLayout());
        panel.add(new JScrollPane(tablePanel), constraints);

        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 2, 5, 2);
        // add each table to table panel
        for (JTable table : tables) {
            table.setTableHeader(null);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            table.setRowHeight(20);
            table.setIntercellSpacing(new Dimension(8, 0));

            tablePanel.add(table, constraints);
            ++constraints.gridy;
        }

        // add an empty panel for resizing
        constraints.gridy = 2;
        constraints.weighty = 1;
        tablePanel.add(new JPanel(), constraints);

    }

    /**
     * <p>
     * Set the delete column with fixed width in given table.
     * </p>
     * @param table the table set.
     * @since 1.1
     */
    void setDeleteColumnWidth(JTable table) {
        // make sure there is a delete column.
        if (table.getColumnCount() > 1) {
            TableColumn col = table.getColumnModel().getColumn(1);
            col.setPreferredWidth(45);
            col.setMaxWidth(45);
            col.setMinWidth(45);
        }
    }

    /**
     * <p>
     * Add items to this panel with a TitledBorder.
     * This method will handle the padding issue for TitledBorder.
     * </p>
     * @param items the items to add
     * @since 1.1
     */
    void addTitledPanelItems(JComponent[] items) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.WEST;
        // the top padding is -5, since TitledBorder uses a 5px padding by default.
        constraints.insets = new Insets(-5, 0, 0, 0);

        // add items to this panel
        for (JComponent item : items) {
            if (item != null) {
                panel.add(item, constraints);
                ++constraints.gridx;
            }
        }
        // add an empty panel for resizing
        constraints.weightx = 1;
        panel.add(new JPanel(), constraints);
    }

}