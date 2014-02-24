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
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * <p>
 * This JPanel can be used as the default expansion panel used by the side menu panel.
 * </p>
 * <p>
 * This panel will contain a JLabel (describing the title), a 'pin' button (that will allow allow
 * the panel to be pinned when pressed down [ie non-floating]) and a collapse button (to allow the
 * panel to collapse down. This panel will work directly with the side menu model to define the
 * label and floating/collapse operations.
 * </p>
 * <p>
 * The application can customize the default buttons by calling getXXXButton and customizing it - or
 * the application can simply set a new button into via the setXXXButton (same applies to the text
 * label).
 * </p>
 * <p>
 * This panel can be created directly directly by the SideMenuPanel (as the default panel) or by the
 * application directly (and set into the SideMenuPanel).
 * </p>
 * <p>
 * This panel will either be added directly to the SideMenuPanel (when expanded and pinned) or in a
 * Popup (if floating). The application will need to add contents to prevent the default label from
 * appearing. This panel will fire property change events (using the constants defined on the class)
 * if the contents change.
 * </p>
 * <p>
 * This class is NOT thread safe since it has mutable state and provides no locking. The state
 * should only be modified on the AWT event thread.
 * </p>
 *
 * @author Pops, KingStone
 * @version 1.0
 */
public class DefaultExpandedSideMenuPanel extends AbstractSideMenuPanel {
    /**
     * <p>
     * This public constant represents the property name that will be used when the collapse button
     * (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String COLLAPSE_BUTTON = "collapseButton";

    /**
     * <p>
     * This public constant represents the property name that will be used when the pin button
     * (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String PIN_BUTTON = "pinButton";

    /**
     * <p>
     * This public constant represents the property name that will be used when the text label
     * (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String TEXT_LABEL = "textLabel";

    /**
     * <p>
     * This public constant represents the property name that will be used when the content
     * component (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String CONTENT_COMPONENT = "contentComponent";

    /**
     * <p> A  {@link GridBagConstraints}  used to add textLabel into this panel. </p>
     */
    private static final GridBagConstraints TEXTLABEL_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                    0, 0, 0, 0), 0, 0);

    /**
     * <p> A  {@link GridBagConstraints}  used to add pinButton into this panel. </p>
     */
    private static final GridBagConstraints PIN_BUTTON_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0,
                    0), 0, 0);

    /**
     * <p> A  {@link GridBagConstraints}  used to add collapseButton into this panel. </p>
     */
    private static final GridBagConstraints COLLAPSE_BUTTON_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            2, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0,
                    0), 0, 0);

    /**
     * <p> A  {@link GridBagConstraints}  used to add content into this panel. </p>
     */
    private static final GridBagConstraints CONTENT_GRID_BAG_CONSTRAINTS = new GridBagConstraints(
            0, 1, 3, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0,
                    0, 0, 0), 0, 0);

    /**
     * <p>
     * This variable represents the anonymous action listener used to listen for changes in the
     * pinButton and collapseButton. This variable is immutable (the reference) and will never be
     * null.
     * </p>
     * <p>
     * This variable is only referenced in the setter methods for the buttons.
     * </p>
     * <p>
     * The developer should note we run the set's later in the event queue - this is to prevent an
     * endless loop because the setter will trigger a change event (which calls us back to set the
     * value of the button - which shouldn't happen from within the action performed event).
     * </p>
     */
    private final ActionListener buttonListener;

    /**
     * <p>
     * This variable represents the button that will be used to signal a collapse of this panel.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the *Collapsed* methods (getCollapsedButton,
     * getCollapsedIcon, etc).
     * </p>
     */
    private JButton collapseButton;

    /**
     * <p>
     * This variable represents the button that will be used to signal a pin of this panel.
     * </p>
     * <p>
     * If the button is selected - the panel is 'pinned'.
     * </p>
     * <p>
     * If the button is not selected, the panel is 'floating'.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the *Pin* methods (getPinButton, getPinIcon, etc) and the
     * sideMenuModelPropertyChange methods.
     * </p>
     */
    private JToggleButton pinButton;

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
    private JLabel textLabel;

    /**
     * <p>
     * This variable represents the component that will be used to show the application specified
     * content of the side menu.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the setter and getter methods
     * </p>
     */
    private JComponent content;

    /**
     * <p>
     * Create the panel with only a side menu model and content.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if sideMenuModel or content is null
     * @param sideMenuModel
     *            A non-null side menu model to use
     * @param content
     *            A non-null content panel to use
     */
    public DefaultExpandedSideMenuPanel(SideMenuModel sideMenuModel, JComponent content) {
        this(sideMenuModel, content, null, null);
    }

    /**
     * <p>
     * Create the panel with only a side menu model, content and potentially a collapse icon (if
     * non-null).
     * </p>
     *
     * @throws IllegalArgumentException
     *             if sideMenuModel or content is null
     * @param sideMenuModel
     *            A non-null side menu model to use
     * @param collapseIcon
     *            A possibly null collapse icon to use
     * @param content
     *            A non-null content panel to use
     */
    public DefaultExpandedSideMenuPanel(SideMenuModel sideMenuModel, JComponent content,
            Icon collapseIcon) {
        this(sideMenuModel, content, collapseIcon, null);
    }

    /**
     * <p>
     * Constructs the side menu panel with the specified arguments.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if sideMenuModel or content is null
     * @param pinIcon
     *            A possibly null pin icon to use
     * @param sideMenuModel
     *            A non-null side menu model to use
     * @param collapseIcon
     *            A possibly null collapse icon to use
     * @param content
     *            A non-null content panel to use
     */
    public DefaultExpandedSideMenuPanel(SideMenuModel sideMenuModel, JComponent content,
            Icon collapseIcon, Icon pinIcon) {
        super(sideMenuModel);
        Helper.checkNull(content, "content");
        buttonListener = new ActionListener() {
            /**
             * <p>
             * if event is fired from pinButton, update floating status of SideMenuModel.
             * </p>
             * <p>
             * if event is fired from collapseButton, update expanded status of SideMenuModel to
             * false.
             * </p>
             *
             * @throws IllegalStateException
             *             if sideMenuModel is removed(sideMenuModel is null)
             */
            public void actionPerformed(ActionEvent evt) {
                SideMenuModel sideMenuModel = getSideMenuModel();
                Helper.checkState(sideMenuModel);
                if (evt.getSource() == pinButton) {
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            getSideMenuModel().setFloating(pinButton.isSelected());
                        }
                    });
                } else {
                    // source == collapseButton
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            getSideMenuModel().setExpanded(false);
                        }
                    });
                }
            }
        };
        this.content = content;

        // create buttons
        this.collapseButton = new JButton();
        Helper.setButton(collapseButton, collapseIcon, buttonListener);
        this.pinButton = new JToggleButton();
        Helper.setButton(pinButton, pinIcon, buttonListener);
        // set the button's selected state
        this.pinButton.setSelected(sideMenuModel.isFloating());
        // set title label
        this.textLabel = new JLabel();
        this.textLabel.setText(sideMenuModel.getTitle());
        this.textLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // set layout and add components
        setLayout(new GridBagLayout());
        add(this.textLabel, TEXTLABEL_GRID_BAG_CONSTRAINTS);
        //add(this.pinButton, PIN_BUTTON_GRID_BAG_CONSTRAINTS);
        add(this.collapseButton, COLLAPSE_BUTTON_GRID_BAG_CONSTRAINTS);
        add(this.content, CONTENT_GRID_BAG_CONSTRAINTS);

        // ensure the panel will be updated from all the attributes of the side menu
        firePropertyChange(SIDE_MENU_MODEL, null, sideMenuModel);
    }

    /**
     * <p>
     * Returns the CollapseButton used by this panel.
     * </p>
     *
     * @return A non-null collapse button
     */
    public JButton getCollapseButton() {
        return collapseButton;
    }

    /**
     * <p>
     * Sets a new button to use as the collapse button.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the button is null
     * @param button
     *            A non-null button to use as the collapse button
     */
    public void setCollapseButton(JButton button) {
        Helper.checkNull(button, "button");
        JButton oldCollapseButton = this.collapseButton;
        remove(this.collapseButton);
        oldCollapseButton.removeActionListener(buttonListener);
        this.collapseButton = button;
        // set new collapseButton
        this.collapseButton.addActionListener(buttonListener);
        add(collapseButton, COLLAPSE_BUTTON_GRID_BAG_CONSTRAINTS);
        validate();
        firePropertyChange(COLLAPSE_BUTTON, oldCollapseButton, collapseButton);
    }

    /**
     * <p>
     * Returns the icon used in the collapse button.
     * </p>
     *
     * @return A possibly null icon value
     */
    public Icon getCollapseIcon() {
        return collapseButton.getIcon();
    }

    /**
     * <p>
     * Set's the collapse icon.
     * </p>
     *
     * @param icon
     *            A possibly null icon.
     */
    public void setCollapseIcon(Icon icon) {
        collapseButton.setIcon(icon);
    }

    /**
     * <p>
     * Returns the PinButton used by this panel.
     * </p>
     *
     * @return A non-null toggle button used for pin
     */
    public JToggleButton getPinButton() {
        return pinButton;
    }

    /**
     * <p>
     * Sets a new button to use as the pin button.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @throws IllegalArgumentException
     *             if button is null
     * @param button
     *            A non-null toggle button to use as the pin button
     */
    public void setPinButton(JToggleButton button) {
        SideMenuModel sideMenuModel = getSideMenuModel();
        Helper.checkState(sideMenuModel);
        Helper.checkNull(button, "button");
        JToggleButton oldPinButton = this.pinButton;
        remove(this.pinButton);
        oldPinButton.removeActionListener(buttonListener);
        this.pinButton = button;
        // set pin buttion
        this.pinButton.addActionListener(buttonListener);
        add(pinButton, PIN_BUTTON_GRID_BAG_CONSTRAINTS);
        this.pinButton.setSelected(sideMenuModel.isFloating());
        validate();
        firePropertyChange(PIN_BUTTON, oldPinButton, pinButton);
    }

    /**
     * <p>
     * Returns the icon used in the pin button.<p/>
     *
     * @return A possibly null icon value
     */
    public Icon getPinIcon() {
        return pinButton.getIcon();
    }

    /**
     * <p>
     * Set's the pin icon.
     * </p>
     *
     * @param icon
     *            A possibly null icon
     */
    public void setPinIcon(Icon icon) {
        pinButton.setIcon(icon);
    }

    /**
     * <p>
     * Returns the TextLabel used by this panel.
     * </p>
     *
     * @return A non-null text label
     */
    public JLabel getTextLabel() {
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
    public void setTextLabel(JLabel textLabel) {
        SideMenuModel sideMenuModel = getSideMenuModel();
        Helper.checkState(sideMenuModel);
        Helper.checkNull(textLabel, "textLabel");
        JLabel oldTextLabel = this.textLabel;
        remove(oldTextLabel);
        this.textLabel = textLabel;
        add(textLabel, TEXTLABEL_GRID_BAG_CONSTRAINTS);
        textLabel.setText(sideMenuModel.getTitle());
        validate();
        firePropertyChange(TEXT_LABEL, oldTextLabel, textLabel);
    }

    /**
     * <p>
     * Returns the content used by this panel.
     * </p>
     *
     * @return A non-null content panel
     */
    public JComponent getContent() {
        return content;
    }

    /**
     * <p>
     * Set's the content used by this panel.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if content is null
     * @param content
     *            A non-null content panel to use
     */
    public void setContent(JComponent content) {
        Helper.checkNull(content, "content");
        JComponent oldContent = this.content;
        remove(this.content);
        this.content = content;
        add(content, CONTENT_GRID_BAG_CONSTRAINTS);
        validate();
        firePropertyChange(CONTENT_COMPONENT, oldContent, content);
    }

    /**
     * <p>
     * Processes property change events (in this case, we look for title and floating).
     * </p>
     * <p>
     * This method will only deal with SIDE_MENU_MODEL/TITLE/FLOATING event.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if event is null, or value of property is invalid.
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
        String propertyName = event.getPropertyName();
        Object newValue = event.getNewValue();
        try {
            if (propertyName == SIDE_MENU_MODEL) {
                textLabel.setText(sideMenuModel.getTitle());
                pinButton.setSelected(sideMenuModel.isFloating());
            } else if (propertyName == SideMenuModel.TITLE) {
                // following check may never IllegalArgumentException
                // (value should be check before fired into this method)
                // just add to make the code more robust
                Helper.checkString((String) newValue, "new title");
                textLabel.setText((String) newValue);
            } else if (propertyName == SideMenuModel.FLOATING) {
                Helper.checkNull(newValue, "new value");
                pinButton.setSelected((Boolean) newValue);
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid value of property:" + propertyName + ".", e);
        }
        // Silently Ignore all other types
    }
}
