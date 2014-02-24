/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.topcoder.gui.verticallabel.JVerticalLabel;

/**
 * <p>
 * This JPanel can be used as the default collapsed panel used by the side menu.
 * </p>
 * <p>
 * This panel will contain a vertical label (describing the title), an expansion button on the top
 * and bottom (to allow the panel to expand).
 * </p>
 * <p>
 * This panel will work directly with the side menu model to define the label and expand operations.
 * </p>
 * <p>
 * This panel also will allow 'click to expand' operation if enabled - this allows the user to
 * simply click on the panel to expand it.
 * </p>
 * <p>
 * The application can customize the default buttons by calling getXXXButton and customizing it - or
 * the application can simply set a new button into via the setXXXButton (same applies to the text
 * label).
 *
 * </p>
 * <p>
 * This panel can be created directly directly by the SideMenuPanel (as the default panel) or by the
 * application directly (and set into the SideMenuPanel).
 * </p>
 * <p>
 * This panel will be added directly to the SideMenuPanel (when collapsed).
 * </p>
 * <p>
 * This panel will fire property change events (using the constants defined on the class) if the
 * contents change.
 * </p>
 * <p>
 * This class is NOT thread safe since it has mutable state and provides no locking. The state
 * should only be modified on the awt event thread.
 * </p>
 *
 * @author Pops, KingStone
 * @version 1.0
 */
public class DefaultCollapsedSideMenuPanel extends AbstractSideMenuPanel {
    /**
     * <p>
     * This public constant represents the property name that will be used when the upper expand
     * button (itself - not it's properties) has been changed.
     * <p>
     */
    public static final String UPPER_EXPAND_BUTTON = "upperExpandButton";

    /**
     * <p>
     * This public constant represents the property name that will be used when the lower expand
     * button (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String LOWER_EXPAND_BUTTON = "lowerExpandButton";

    /**
     * <p>
     * This public constant represents the property name that will be used when the text label
     * (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String TEXT_LABEL = "textLabel";

    /**
     * <p> A  {@link GridBagConstraints}  used to add upperButton into this panel. </p>
     */
    private static final GridBagConstraints UPPER_BUTTON_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
                    0, 0), 0, 0);

    /**
     * <p> A  {@link GridBagConstraints}  used to add lowerButton into this panel. </p>
     */
    private static final GridBagConstraints LOWER_BUTTON_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
                    0, 0), 0, 0);

    /**
     * <p> A  {@link GridBagConstraints}  used to add textLabel into this panel. </p>
     */
    private static final GridBagConstraints TEXT_LABEL_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0,
                    0, 0), 0, 0);

    /**
     * <p>
     * This variable represents the anonymous mouse listener that can be used to listen for clicks
     * (to expand the panel).
     * </p>
     * <p>
     * This variable is immutable (the reference) and will never be null.
     * </p>
     * <p>
     * This variable is only referenced in the setClickToExpand and isClickToExpand methods.
     * </p>
     */
    private final MouseListener mouseListener;

    /**
     * <p>
     * This variable represents the anonymous action listener used to listen for changes in the
     * expansion buttons.
     * </p>
     * <p>
     * This variable is immutable (the reference) and will never be null.
     * </p>
     * <p>
     * This variable is only referenced in the setter methods for the buttons.
     * </p>
     * The developer should note we run the set's later in the event queue - this is to prevent an
     * endless loop because the setter will trigger a change event (which calls us back to set the
     * value of the button - which shouldn't happen from within the action performed event).
     */
    private final ActionListener buttonListener;

    /**
     * <p>
     * This variable represents the button that will be used to signal expansion and will be set on
     * the top of the panel.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the setter,getter, xxxUpperExpandButtonVisible,
     * xxxExpandIcon and sideMenuModelPropertyChange methods.
     * </p>
     */
    private JButton upperExpandButton;

    /**
     * <p>
     * This variable represents the button that will be used to signal expansion and will be set on
     * the bottom of the panel.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the setter,getter, xxxLowerExpandButtonVisible,
     * xxxExpandIcon and sideMenuModelPropertyChange methods.
     * </p>
     */
    private JButton lowerExpandButton;

    /**
     * <p>
     * This variable represents the label that will be used to show the title of the side menu.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the setter, getter and sideMenuModelPropertyChange
     * methods.
     * </p>
     */
    private JVerticalLabel textLabel;

    /**
     * <p>
     * Create the panel with a side menu model.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if sideMenuModel is null
     * @param sideMenuModel
     *            A non-null SideMenuModel
     */
    public DefaultCollapsedSideMenuPanel(SideMenuModel sideMenuModel) {
        this(sideMenuModel, null, true);
    }

    /**
     * <p>
     * Create the panel with a side menu model, setting the icon of the expansion buttons and
     * disallowing click to expand.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the sideMenuModel is null
     * @param sideMenuModel
     *            A non-null SideMenuModel
     * @param expandIcon
     *            A possibly null expansion icon to use
     */
    public DefaultCollapsedSideMenuPanel(SideMenuModel sideMenuModel, Icon expandIcon) {
        this(sideMenuModel, expandIcon, false);
    }

    /**
     * <p>
     * Constructs the side menu panel with the specified arguments.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the sideMenuModel is null
     * @param sideMenuModel
     *            A non-null SideMenuModel
     * @param clickToExpand
     *            True if click to expand, false otherwise
     * @param expandIcon
     *            A possibly null expansion icon to use
     */
    public DefaultCollapsedSideMenuPanel(SideMenuModel sideMenuModel, Icon expandIcon,
            boolean clickToExpand) {
        super(sideMenuModel);
        // set the final fields
        mouseListener = new MouseAdapter() {
            /**
             * Set expanded status of SideMenuModel to true.
             *
             * @throws IllegalStateException
             *             if sideMenuModel is removed(sideMenuModel is null)
             */
            public void mouseClicked(MouseEvent evt) {
                SideMenuModel sideMenuModel = getSideMenuModel();
                Helper.checkState(sideMenuModel);
                sideMenuModel.setExpanded(true);
            }
        };
        buttonListener = new ActionListener() {
            /**
             * Set expanded status of SideMenuModel to true.
             *
             * @throws IllegalStateException
             *             if sideMenuModel is removed(sideMenuModel is null)
             */
            public void actionPerformed(ActionEvent evt) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        SideMenuModel sideMenuModel = getSideMenuModel();
                        Helper.checkState(sideMenuModel);
                        sideMenuModel.setExpanded(true);
                    }
                });
            }
        };

        // create button
        upperExpandButton = new JButton();
        Helper.setButton(upperExpandButton, expandIcon, buttonListener);
        lowerExpandButton = new JButton();
        Helper.setButton(lowerExpandButton, expandIcon, buttonListener);
        // create vertical label
        textLabel = new JVerticalLabel();
        textLabel.setText(sideMenuModel.getTitle());
        // set alignment of vertical label
        textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        // set click to expand
        if (clickToExpand) {
            this.addMouseListener(mouseListener);
        }

        setLayout(new GridBagLayout());
        // add swing elements to panel
        add(upperExpandButton, UPPER_BUTTON_GRID_BAG_CONSTRAINTS);
        add(textLabel, TEXT_LABEL_GRID_BAG_CONSTRAINTS);
        add(lowerExpandButton, LOWER_BUTTON_GRID_BAG_CONSTRAINTS);

        // ensure the panel will be updated from all the attributes of the side menu
        firePropertyChange(SIDE_MENU_MODEL, null, sideMenuModel);
    }

    /**
     * <p>
     * Returns the upper expand button used by this panel.
     * </p>
     *
     * @return A non-null button
     */
    public JButton getUpperExpandButton() {
        return upperExpandButton;
    }

    /**
     * <p>
     * Sets a new button to use as the upper expand button.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if button is null
     * @param button
     *            A non-null button to use
     */
    public void setUpperExpandButton(JButton button) {
        Helper.checkNull(button, "button");
        JButton oldUpperExpandButton = upperExpandButton;
        upperExpandButton = button;
        addNewExpandButton(oldUpperExpandButton, button, UPPER_BUTTON_GRID_BAG_CONSTRAINTS,
                UPPER_EXPAND_BUTTON);
    }

    /**
     * <p>
     * This method remove old button and add the new one.
     * </p>
     *
     * @param oldButton
     *            the old button
     * @param newButton
     *            the new button
     * @param constraints
     *            GridBagConstraints used when add new button
     * @param propertyName
     *            the property name used when fire PropertyChangeEvent
     */
    private void addNewExpandButton(JButton oldButton, JButton newButton,
            GridBagConstraints constraints, String propertyName) {
        // remove old one
        remove(oldButton);
        oldButton.removeActionListener(buttonListener);
        // add new one
        newButton.addActionListener(buttonListener);
        add(newButton, constraints);
        validate();
        firePropertyChange(propertyName, oldButton, newButton);
    }

    /**
     * <p>
     * Returns the lower expand button used by this panel.
     * </p>
     *
     * @return A non-null button
     */
    public JButton getLowerExpandButton() {
        return lowerExpandButton;
    }

    /**
     * <p>
     * Sets a new button to use as the lower expand button.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if button is null
     * @param button
     *            A non-null button to use
     */
    public void setLowerExpandButton(JButton button) {
        Helper.checkNull(button, "button");
        JButton oldUpperExpandButton = lowerExpandButton;
        lowerExpandButton = button;
        addNewExpandButton(oldUpperExpandButton, button, LOWER_BUTTON_GRID_BAG_CONSTRAINTS,
                LOWER_EXPAND_BUTTON);
    }

    /**
     * <p>
     * Returns the icon used in the expand buttons.
     * </p>
     * <p>
     * Note: if upperExpandButton's icon is not null, this method will return icon of
     * upperExpandButton's icon, else if lowerExpandButton's icon is not null, this method will
     * return icon of this method will return icon of upperExpandButton's icon. If both of above
     * icons are null, this method will return null.
     * </p>
     *
     * @return A possibly null icon being used.
     */
    public Icon getExpandIcon() {
        if (upperExpandButton.getIcon() != null) {
            return upperExpandButton.getIcon();
        } else {
            return lowerExpandButton.getIcon();
        }
    }

    /**
     * <p>
     * Sets the expansion icon to use.
     * </p>
     *
     * @param icon
     *            A possibly null icon to use for expansion
     */
    public void setExpandIcon(Icon icon) {
        upperExpandButton.setIcon(icon);
        lowerExpandButton.setIcon(icon);
    }

    /**
     * <p>
     * Returns the Text Label used by this panel.
     * </p>
     *
     * @return A non-null text label
     */
    public JVerticalLabel getTextLabel() {
        return textLabel;
    }

    /**
     * <p>
     * Set's the text label used by this panel.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @throws IllegalArgumentException
     *             if textLabel is null
     * @param textLabel
     *            A non-null text label to use
     */
    public void setTextLabel(JVerticalLabel textLabel) {
        SideMenuModel sideMenuModel = getSideMenuModel();
        Helper.checkState(sideMenuModel);
        Helper.checkNull(textLabel, "textLabel");
        // remove the old one
        remove(this.textLabel);
        JVerticalLabel oldTextLabel = this.textLabel;
        // add/set new one
        this.textLabel = textLabel;
        this.textLabel.setText(sideMenuModel.getTitle());
        add(this.textLabel, TEXT_LABEL_GRID_BAG_CONSTRAINTS);
        validate();
        firePropertyChange(TEXT_LABEL, oldTextLabel, this.textLabel);
    }

    /**
     * <p>
     * Returns whether click to expand is enabled.
     * </p>
     *
     * @return True if clicking to expand is enabled, false otherwise
     */
    public boolean isClickToExpand() {
        for (MouseListener iteratedMouseListener : getMouseListeners()) {
            if (iteratedMouseListener == mouseListener) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Sets whether click to expand is enabled.
     * </p>
     *
     * @param enable
     *            true to enable click to expand, false otherwise
     */
    public void setClickToExpand(boolean enable) {
        if (isClickToExpand() == enable) {
            return;
        } else {
            // add/remove mouse listener
            if (enable) {
                addMouseListener(mouseListener);
            } else {
                removeMouseListener(mouseListener);
            }
        }
    }

    /**
     * <p>
     * Returns whether the upper expand button is visible.
     * </p>
     *
     * @return true if the upper expand button is visible, false otherwise
     */
    public boolean isUpperExpandButtonVisible() {
        return upperExpandButton.isVisible();
    }

    /**
     * <p>
     * Sets whether the upper expand button is visible.
     * </p>
     *
     * @param visible
     *            true if the upper expand button is visible, false otherwise
     */
    public void setUpperExpandButtonVisible(boolean visible) {
        upperExpandButton.setVisible(visible);
    }

    /**
     * <p>
     * Returns whether the lower expand button is visible.
     * </p>
     *
     * @return true if the lower expand button is visible, false otherwise
     */
    public boolean isLowerExpandButtonVisible() {
        return lowerExpandButton.isVisible();
    }

    /**
     * <p>
     * Sets whether the lower expand button is visible.
     * </p>
     *
     * @param visible
     *            true if the lower expand button is visible, false otherwise
     */
    public void setLowerExpandButtonVisible(boolean visible) {
        lowerExpandButton.setVisible(visible);
    }

    /**
     * <p>
     * Processes property change events (in this case, we look for title).
     * </p>
     * <p>
     * This method will only deal with SIDE_MENU_MODEL/TITLE event.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if event is null, value of specific property is invalid.
     * @param event
     *            A non-null property change event
     */
    protected void sideMenuModelPropertyChange(PropertyChangeEvent event) {
        Helper.checkNull(event, "event");
        SideMenuModel sideMenuModel = getSideMenuModel();
        if (sideMenuModel == null) {
            // this is to take care of when the setSideMenuModel(null) case happens
            return;
        }
        try {
            if (event.getPropertyName() == SIDE_MENU_MODEL) {
                textLabel.setText(sideMenuModel.getTitle());
            } else if (event.getPropertyName() == SideMenuModel.TITLE) {
                // following check may never IllegalArgumentException
                // (value should be check before fired into this method)
                // just add to make the code more robust
                Helper.checkString((String) event.getNewValue(), "new title");
                textLabel.setText((String) event.getNewValue());
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid value type of property:"
                    + event.getPropertyName() + ".", e);
        }
        // Silently Ignore all other types
    }
}
