/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * This class provides a GUI for the modifier properties of <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> containing at least one of the following modifiers:
 * <b>abstract</b>, <b>final</b>, <b>root</b>, <b>static</b>, <b>active</b>, <b>transient</b>,
 * <b>navigable</b> and <b>asynchronous</b>.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 * <p>
 * V1.1 Change Note: the new layout is used as the prototype.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ModifiersPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * This is a list that contains all the property kinds supported by the modifier panel.
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
    private static final List<PropertyKind> PROPERTIES = new ArrayList<PropertyKind>();

    /**
     * <p>
     * The <code>JCheckBox</code> to represent abstract modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxAbstract;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent final modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxFinal;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent root modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxRoot;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent static modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxStatic;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent active modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxActive;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent transient modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxTransient;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent navigable modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxNavigable;

    /**
     * <p>
     * The <code>JCheckBox</code> to represent asynchronous modifier property.
     * </p>
     *
     * <p>
     * Created in the constructor and the reference will not be modified afterwards.
     * </p>
     *
     * <p>
     * Will not be null.
     * </p>
     */
    private final JCheckBox checkboxAsynchronous;

    /**
     * <p>
     * This is a static initialization for this class.
     * </p>
     *
     * <p>
     * This static initialization is used to initialize the <code>PROPERTIES</code> list.
     * </p>
     */
    static {
        PROPERTIES.add(PropertyKind.ABSTRACT);
        PROPERTIES.add(PropertyKind.FINAL);
        PROPERTIES.add(PropertyKind.ROOT);
        PROPERTIES.add(PropertyKind.STATIC);
        PROPERTIES.add(PropertyKind.ACTIVE);
        PROPERTIES.add(PropertyKind.TRANSIENT);
        PROPERTIES.add(PropertyKind.NAVIGABLE);
        PROPERTIES.add(PropertyKind.ASYNCHRONOUS);
    }

    /**
     * <p>
     * Creates a new <code>ModifiersPropertyPanel</code>.
     * </p>
     * <p>
     * V1.1 Change Note: the new layout is used as the prototype.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel that owns this panel
     * @throws IllegalArgumentException if argument is null
     */
    public ModifiersPropertyPanel(PropertiesPanel propertiesPanel) {
        super(PROPERTIES, propertiesPanel);

        this.checkboxAbstract = new JCheckBox("Abstract");
        this.checkboxFinal = new JCheckBox("Final");
        this.checkboxRoot = new JCheckBox("Root");
        this.checkboxStatic = new JCheckBox("Static");
        this.checkboxActive = new JCheckBox("Active");
        this.checkboxTransient = new JCheckBox("Transient");
        this.checkboxNavigable = new JCheckBox("Navigable");
        this.checkboxAsynchronous = new JCheckBox("Asynchronous");

        ItemListener listener = new ModifiersItemListener();

        checkboxAbstract.addItemListener(listener);
        checkboxFinal.addItemListener(listener);
        checkboxRoot.addItemListener(listener);
        checkboxStatic.addItemListener(listener);
        checkboxActive.addItemListener(listener);
        checkboxTransient.addItemListener(listener);
        checkboxNavigable.addItemListener(listener);
        checkboxAsynchronous.addItemListener(listener);

        JPanel panel = retrievePanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Modifiers"));

    }

    /**
     * <p>
     * Executes the logic of this class.
     * </p>
     *
     * <p>
     * Note, all the logic is contained in the item listener. Thus, this method actually does nothing.
     * </p>
     */
    public void execute() {
        // empty
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * For a modifier, if all the configured <code>ModelElement</code> has the modifier active, the
     * check box corresponding with the modifier will be marked selected.
     * </p>
     * <p>
     * V1.1 Change Note: the new layout is used as the prototype.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        JPanel panel = retrievePanel();
        panel.removeAll();

        // all all the check boxes to the panel if any one is supported
        addTitledPanelItems(new JComponent[] {
            updateCheckBoxValue(checkboxAbstract, isAllAbstract()),
            updateCheckBoxValue(checkboxFinal, isAllFinal()),
            updateCheckBoxValue(checkboxRoot, isAllRoot()),
            updateCheckBoxValue(checkboxStatic, isAllStatic()),
            updateCheckBoxValue(checkboxActive, isAllActive()),
            updateCheckBoxValue(checkboxTransient, isAllTransient()),
            updateCheckBoxValue(checkboxNavigable, isAllNavigable()),
            updateCheckBoxValue(checkboxAsynchronous, isAllAsynchronous()) });
    }

    /**
     * <p>
     * This method update the given check box with the given value.
     * </p>
     *
     * <p>
     * If the value is null, then the check box will not be update and null is returned.
     * </p>
     *
     * @param checkBox the <code>JCheckBox</code> to update
     * @param value the <code>Boolean</code> value
     * @return the updated check box or null if the value is null.
     * @since 1.1
     */
    private JCheckBox updateCheckBoxValue(JCheckBox checkBox, Boolean value) {
        if (value == null) {
            return null;
        }

        checkBox.setSelected(value);
        return checkBox;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the abstract modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the abstract modifier this method will
     * return null, or this method will return the abstract value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the abstract modifier, or
     * the abstract value for all the configured model elements
     */
    private Boolean isAllAbstract() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Package) {
                values.add(((Package) element).isAbstract());
            } else if (element instanceof Interface) {
                values.add(((Interface) element).isAbstract());
            } else if (element instanceof Class) {
                values.add(((Class) element).isAbstract());
            } else if (element instanceof Enumeration) {
                values.add(((Enumeration) element).isAbstract());
            } else if (element instanceof Operation) {
                values.add(((Operation) element).isAbstract());
            } else if (element instanceof Actor) {
                values.add(((Actor) element).isAbstract());
            } else if (element instanceof UseCase) {
                values.add(((UseCase) element).isAbstract());
            } else if (element instanceof Subsystem) {
                values.add(((Subsystem) element).isAbstract());
            } else {
                // the abstract modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same abstract state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the final modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the final modifier this method will
     * return null, or this method will return the final value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the final modifier, or
     * the final value for all the configured model elements
     */
    private Boolean isAllFinal() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Package) {
                values.add(((Package) element).isLeaf());
            } else if (element instanceof Interface) {
                values.add(((Interface) element).isLeaf());
            } else if (element instanceof Class) {
                values.add(((Class) element).isLeaf());
            } else if (element instanceof Enumeration) {
                values.add(((Enumeration) element).isLeaf());
            } else if (element instanceof Operation) {
                values.add(((Operation) element).isLeaf());
            } else if (element instanceof Actor) {
                values.add(((Actor) element).isLeaf());
            } else if (element instanceof UseCase) {
                values.add(((UseCase) element).isLeaf());
            } else if (element instanceof Subsystem) {
                values.add(((Subsystem) element).isLeaf());
            } else if (element instanceof Parameter) {
                values.add(getTaggedValue(element, "final"));
            } else {
                // the final modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same final state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * This method checks whether a given model element has a <code>TaggedValue</code> with
     * the given <code>type</code> name and its value is <b>true</b>.
     * </p>
     *
     * @param element the model element
     * @param type the tag type
     *
     * @return true if the <code>TaggedValue</code> can be found, false otherwise
     */
    private boolean getTaggedValue(ModelElement element, String type) {
        for (TaggedValue taggedValue : element.getTaggedValues()) {
            TagDefinition tagDefinition = taggedValue.getType();
            if (type.equals(tagDefinition.getTagType())) {
                // The TaggedValue is found
                if ("true".equals(taggedValue.getDataValue())) {
                    return true;
                }
            }
        }

        // The TaggedValue is not found
        return false;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the root modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the root modifier this method will
     * return null, or this method will return the root value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the root modifier, or
     * the root value for all the configured model elements
     */
    private Boolean isAllRoot() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Package) {
                values.add(!isInClassifierNamespace(element) && ((Package) element).isRoot());
            } else if (element instanceof Interface) {
                values.add(!isInClassifierNamespace(element) && ((Interface) element).isRoot());
            } else if (element instanceof Class) {
                values.add(!isInClassifierNamespace(element) && ((Class) element).isRoot());
            } else if (element instanceof Enumeration) {
                values.add(!isInClassifierNamespace(element) && ((Enumeration) element).isRoot());
            } else if (element instanceof Actor) {
                values.add(((Actor) element).isRoot());
            } else if (element instanceof UseCase) {
                values.add(((UseCase) element).isRoot());
            } else if (element instanceof Subsystem) {
                values.add(((Subsystem) element).isRoot());
            } else {
                // the root modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same root state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * This method checks whether the given model element is in a <code>Classifier</code> <code>Namespace</code>.
     * </p>
     *
     * @param element the model element to check
     *
     * @return true if the given model element is in a <code>Classifier</code> <code>Namespace</code>, false
     * otherwise
     */
    private boolean isInClassifierNamespace(ModelElement element) {
        return element.getNamespace() instanceof Classifier;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the static modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the static modifier this method will
     * return null, or this method will return the static value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the static modifier, or
     * the static value for all the configured model elements
     */
    private Boolean isAllStatic() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Interface) {
                values.add(isInClassifierNamespace(element) && ((Interface) element).isRoot());
            } else if (element instanceof Class) {
                values.add(isInClassifierNamespace(element) && ((Class) element).isRoot());
            } else if (element instanceof Enumeration) {
                values.add(isInClassifierNamespace(element) && ((Enumeration) element).isRoot());
            } else if (element instanceof Feature) {
                values.add(((Feature) element).getOwnerScope() == ScopeKind.CLASSIFIER);
            } else if (element instanceof AssociationEnd) {
                values.add(((AssociationEnd) element).getTargetKind() == ScopeKind.CLASSIFIER);
            } else {
                // the static modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same static state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the active modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the active modifier this method will
     * return null, or this method will return the active value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the active modifier, or
     * the active value for all the configured model elements
     */
    private Boolean isAllActive() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Class) {
                values.add(((Class) element).isActive());
            } else {
                //  the active modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same active state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the transient modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the transient modifier this method will
     * return null, or this method will return the transient value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the transient modifier, or
     * the transient value for all the configured model elements
     */
    private Boolean isAllTransient() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Attribute || element instanceof AssociationEnd) {
                values.add(getTaggedValue(element, "transient"));
            } else {
                // the transient modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same transient state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the navigable modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the navigable modifier this method will
     * return null, or this method will return the navigable value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the navigable modifier, or
     * the navigable value for all the configured model elements
     */
    private Boolean isAllNavigable() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof AssociationEnd) {
                values.add(((AssociationEnd) element).isNavigable());
            } else {
                // the navigable modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same navigable state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * Checks whether all the configured model elements support the asynchronous modifier.
     * </p>
     *
     * <p>
     * If some configured model element doesn't support the asynchronous modifier this method will
     * return null, or this method will return the asynchronous value for all the configured
     * model elements.
     * </p>
     *
     * @return null if some configured model element doesn't support the asynchronous modifier, or
     * the asynchronous value for all the configured model elements
     */
    private Boolean isAllAsynchronous() {
        Set<Boolean> values = new HashSet<Boolean>();

        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Stimulus) {
                Procedure procedure = ((Stimulus) element).getDispatchAction();
                if (procedure != null && procedure.getAction() instanceof CallOperationAction) {
                    values.add(((CallOperationAction) procedure.getAction()).isAsynchronous());
                } else {
                    values.add(false);
                }
            } else {
                // the asynchronous modifier is not supported
                return null;
            }
        }

        // if not all the model elements with the same asynchronous state, false will be returned.
        return (values.size() == 1) ? values.iterator().next() : false;
    }

    /**
     * <p>
     * This inner class provides a listener to the checkbox's item state change event.
     * </p>
     *
     * <p>
     * All the update logic for each modifier is embedded within this class.
     * </p>
     *
     * <p>
     * Thread-safety: This class is immutable and is therefore thread-safe.
     * </p>
     *
     * @author ch_music, TCSDEVELOPER
     * @version 1.0
     */
    private class ModifiersItemListener implements ItemListener {
        /**
         * <p>
         * Creates a new <code>ModifiersItemListener</code>.
         * </p>
         */
        public ModifiersItemListener() {
            // empty
        }

        /**
         * <p>
         * Invoked when an item has been selected or deselected by the user.
         * </p>
         *
         * <p>
         * When the check box is selected or deselected, this method will be invoked.
         * </p>
         *
         * @param e a semantic event which indicates that an item was selected or deselected.
         */
        public void itemStateChanged(ItemEvent e) {
            if (!isConfigured()) {
                return;
            }

            Object source = e.getItemSelectable();

            PropertyKind kind;
            if (source == checkboxAbstract) {
                kind = PropertyKind.ABSTRACT;
            } else if (source == checkboxFinal) {
                kind = PropertyKind.FINAL;
            } else if (source == checkboxRoot) {
                kind = PropertyKind.ROOT;
            } else if (source == checkboxStatic) {
                kind = PropertyKind.STATIC;
            } else if (source == checkboxActive) {
                kind = PropertyKind.ACTIVE;
            } else if (source == checkboxTransient) {
                kind = PropertyKind.TRANSIENT;
            } else if (source == checkboxNavigable) {
                kind = PropertyKind.NAVIGABLE;
            } else {
                kind = PropertyKind.ASYNCHRONOUS;
            }

            boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;

            // notify the listeners about the change
            for (ModelElement element : getConfiguredModelElements()) {
                getPropertiesPanel().firePropertyChangeEvent(element, kind, PropertyOperation.MODIFY, isSelected);
            }
        }
    }
}
