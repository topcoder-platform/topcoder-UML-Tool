/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.gui.diagramviewer.edges.EdgeEnding;

import com.topcoder.gui.diagramviewer.uml.classedges.event.PopupMenuEndingTrigger;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeEndingSelectionTrigger;

/**
 * <p>
 * This class is the base of active edge endings in this component. It is an extension of <code>EdgeEnding</code>
 * class served for the purpose of providing all the common functionalities required by several edge endings for
 * {@link AssociatioinEdge}.
 * </p>
 *
 * <p>
 * It contains several compartments. They are name compartment and multiplicity compartment represented by
 * <code>TextField</code>. There are several properties allowing to configure visibility when selected and hide
 * values for these compartments.
 * </p>
 *
 * <p>
 * The reference to parent edge allows to get common properties (such as colors) from the related edge.
 * </p>
 *
 * <p>
 * The selection feature is provided. This class also adds <code>EditBoxTrigger</code> to name compartment
 * automatically to allow name editing. <code>PopupMenuEndingTrigger</code> and
 * <code>EdgeEndingSelectionTrigger</code> are also registered automatically to edge ending and name/multiplicity
 * compartments to support popup menu and selection for the edge ending.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public abstract class ActiveEdgeEnding extends EdgeEnding {

    /**
     * <p>
     * Represents the name compartment of this edge ending. Initialized in constructor, never changed later, can't be
     * null. Can be accessed by getter method.
     * </p>
     *
     * <p>
     * This object is created by the related contained XXXEdge class. The text/size/location of this TextField will be
     * updated in notifyGraphEdgeChange method of the related XXXEdge class.
     * </p>
     */
    private final TextField nameCompartment;

    /**
     * <p>
     * Represents the multiplicity compartment of this edge ending. Initialized in constructor, never changed later,
     * can't be null. Can be accessed by getter method.
     * </p>
     *
     * <p>
     * This object is created by the related contained XXXEdge class. The text/size/location of this TextField will be
     * updated in notifyGraphEdgeChange method of the related XXXEdge class.
     * </p>
     */
    private final TextField multiplicityCompartment;

    /**
     * <p>
     * Represents is the name compartment visible.
     * </p>
     *
     * <p>
     * The variable can be any value. Use getter/setter methods to access or mutate.
     * </p>
     */
    private boolean isNameVisible = true;

    /**
     * <p>
     * Represents is the multiplicity compartment visible.
     * </p>
     *
     * <p>
     * The variable can be any value. Use getter/setter methods to access or mutate.
     * </p>
     */
    private boolean isMultiplicityVisible = true;

    /**
     * <p>
     * Represents whether should the name compartment be visible after selecting this edge ending, or not.
     * </p>
     *
     * <p>
     * The variable can be any value. Use getter/setter methods to access or mutate.
     * </p>
     */
    private boolean isNameVisibleWhenSelected = true;

    /**
     * <p>
     * Represents whether should the multiplicity compartment be visible after selecting this edge ending, or not.
     * </p>
     *
     * <p>
     * The variable can be any value. Use getter/setter methods to access or mutate.
     * </p>
     */
    private boolean isMultiplicityVisibleWhenSelected = true;

    /**
     * <p>
     * Represents the text string, for which the name compartment should be hidden (isVisible = false).
     * </p>
     *
     * <p>
     * This value can not be null, but can be empty string. Use getter/setter methods to access or mutate.
     * </p>
     */
    private String hideNameText = "";

    /**
     * <p>
     * Represents the text string, for which the multiplicity compartment should be hidden (isVisible = false).
     * </p>
     *
     * <p>
     * This value can not be null, but can be empty string. Use getter/setter methods to access or mutate.
     * </p>
     */
    private String hideMultiplicityText = "1";

    /**
     * <p>
     * Represents the property whether the edge ending is selected. The <code>paintComponent</code> method of the
     * concrete edge ending will paint the background relies on this value.
     * </p>
     *
     * <p>
     * Can be any value. Use getter/setter methods to access or mutate.
     * </p>
     */
    private boolean isSelected = false;

    /**
     * <p>
     * The protected constructor preventing direct instantiation of this class.
     * </p>
     *
     * @param name
     *            The name compartment to be registered to the edge ending.
     * @param multiplicity
     *            The multiplicity compartment to be registered to the edge ending.
     *
     * @throws IllegalArgumentException
     *             If any argument is null
     */
    protected ActiveEdgeEnding(TextField name, TextField multiplicity) {
        Utils.checkObjectNotNull(name, "name");
        Utils.checkObjectNotNull(multiplicity, "multiplicity");

        //Register triggers
        addMouseListener(new PopupMenuEndingTrigger());
        addMouseListener(new EdgeEndingSelectionTrigger(this));

        //Assign and add compartments
        nameCompartment = name;
        // BugFix: UML-9940
        // Don't add the compartments as children, they will be added to edge
//        add(nameCompartment);

        multiplicityCompartment = multiplicity;
        // BugFix: UML-9940
        // Don't add the compartments as children, they will be added to edge
//        add(multiplicityCompartment);
    }

    /**
     * <p>
     * Getter of the name compartment belonging to this edge ending. Refer to the class field for more information.
     * </p>
     *
     * @return The text field representing the name compartment.
     */
    public TextField getNameCompartment() {
        return nameCompartment;
    }

    /**
     * <p>
     * Getter of the multiplicity compartment belonging to this edge ending. Refer to the class field for more
     * information.
     * </p>
     *
     * @return The text field representing the multiplicity compartment.
     */
    public TextField getMultiplicityCompartment() {
        return multiplicityCompartment;
    }

    /**
     * <p>
     * Getter of the isNameVisible field. Refer to the class field for more information.
     * </p>
     *
     * @return The isNameVisible field value.
     */
    public boolean isNameVisible() {
        return this.isNameVisible;
    }

    /**
     * <p>
     * Setter of the isNameVisible field. Refer to the class field for more information.
     * </p>
     *
     * @param isVisible
     *            A new value for the isNameVisible field.
     */
    public void nameVisible(boolean isVisible) {
        this.isNameVisible = isVisible;
    }

    /**
     * <p>
     * Getter of the isMultiplicityVisible field. Refer to the class field for more information.
     * </p>
     *
     * @return The isMultiplicityVisible field value.
     */
    public boolean isMultiplicityVisible() {
        return this.isMultiplicityVisible;
    }

    /**
     * <p>
     * Setter of the isMultiplicityVisible field. Refer to the class field for more information.
     * </p>
     *
     * @param isVisible
     *            A new value for the isMultiplicityVisible field.
     */
    public void multiplicityVisible(boolean isVisible) {
        this.isMultiplicityVisible = isVisible;
    }

    /**
     * <p>
     * Getter of the isNameVisibleWhenSelected field. Refer to the class field for more information.
     * </p>
     *
     * @return The isNameVisibleWhenSelected field value.
     */
    public boolean isNameVisibleWhenSelected() {
        return this.isNameVisibleWhenSelected;
    }

    /**
     * <p>
     * Setter of the isNameVisibleWhenSelected field. Refer to the class field for more information.
     * </p>
     *
     * @param isVisible
     *            A new value for the isNameVisibleWhenSelected field.
     */
    public void nameVisibleWhenSelected(boolean isVisible) {
        this.isNameVisibleWhenSelected = isVisible;
    }

    /**
     * <p>
     * Getter of the isMultiplicityVisibleWhenSelected field. Refer to the class field for more information.
     * </p>
     *
     * @return The isMultiplicityVisibleWhenSelected field value.
     */
    public boolean isMultiplicityVisibleWhenSelected() {
        return this.isMultiplicityVisibleWhenSelected;
    }

    /**
     * <p>
     * Setter of the isMultiplicityVisibleWhenSelected field. Refer to the class field for more information.
     * </p>
     *
     * @param isVisible
     *            A new value for the isMultiplicityVisibleWhenSelected field.
     */
    public void multiplicityVisibleWhenSelected(boolean isVisible) {
        this.isMultiplicityVisibleWhenSelected = isVisible;
    }

    /**
     * <p>
     * Getter of the hideNameText field. Refer to the class field for more information.
     * </p>
     *
     * @return The hideNameText field value.
     */
    public String getHideNameText() {
        return this.hideNameText;
    }

    /**
     * <p>
     * Setter of the hideNameText field. Refer to the class field for more information.
     * </p>
     *
     * @param hideNameText
     *            A new value for the hideNameText field.
     *
     * @throws IllegalArgumentException
     *             if hideNameText is null
     */
    public void setHideNameText(String hideNameText) {
        Utils.checkObjectNotNull(hideNameText, "hideNameText");
        this.hideNameText = hideNameText;
    }

    /**
     * <p>
     * Getter of the hideMultiplicityText field. Refer to the class field for more information.
     * </p>
     *
     * @return The hideMultiplicityText field value.
     */
    public String getHideMultiplicityText() {
        return this.hideMultiplicityText;
    }

    /**
     * <p>
     * Setter of the hideMultiplicityText field. Refer to the class field for more information.
     * </p>
     *
     * @param hideMultiplicityText
     *            A new value for the hideMultiplicityText field.
     *
     * @throws IllegalArgumentException
     *             if hideMultiplicityText is null
     */
    public void setHideMultiplicityText(String hideMultiplicityText) {
        Utils.checkObjectNotNull(hideMultiplicityText, "hideMultiplicityText");
        this.hideMultiplicityText = hideMultiplicityText;
    }

    /**
     * <p>
     * Getter of the isSelected field. Refer to the class field for more information.
     * </p>
     *
     * @return the isSelected field value.
     */
    public boolean isSelected() {
        return this.isSelected;
    }

    /**
     * <p>
     * Setter of the isSelected field. Refer to the class field for more information.
     * </p>
     *
     * @param isSelected
     *            A new value for the isSelected field.
     */
    public void selected(boolean isSelected) {
        this.isSelected = isSelected;
        nameCompartment.setSelected(isSelected);
        multiplicityCompartment.setSelected(isSelected);

        //If selected, set the visibility of compartments
        if (this.isSelected) {
            nameVisible(isNameVisibleWhenSelected);
            multiplicityVisible(isMultiplicityVisibleWhenSelected);
        }
    }

}
