/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.errorhandling.ExceptionUtils;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

/**
 * <p>
 * This is the primary class of the component. It extends JTabbedPane and can be used as a drop-in replacement for
 * it. It paints a close button in the top-right corner of each tab which can be used to close that tab. It also
 * allows closure of tabs using a context menu. An optional border can be drawn around tab components. Event
 * handlers can also be attached that can listen to tab addition and removal events - with the option to override
 * the closure of tabs.
 * </p>
 * <p>
 * This class extends JTabbedPane to so that it can be a drop in replacement for a tabbed pane. It overrides the
 * painting and mouse event processing of the super class in order to paint the close button and catch mouse events
 * that trigger the button as well as the close context menu. It stores as members the close button images, the
 * padding for the button, the interior border if any as well as the active tab selector. It also stores a context
 * menu as well as the tab index over whose close button the mouse hovers and tab index for which the context menu
 * has been triggered.
 * </p>
 * <p>
 * In order to make the closed button display properly, this class will add three spaces after the title of each
 * tab. Because of this, getTitleAt, setTitleAt and indexOfTab will be overridden.
 * </p>
 * <p>
 * Thread Safety: This class is not thread safe as it is mutable and its base class is also not thread safe.
 * </p>
 *
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPane extends JTabbedPane {
    /** The generated serial version UID. */
    private static final long serialVersionUID = 2620514754214595448L;

    // Prepare some property names
    /** The property name for config_manager_specification_factory_namespace. */
    private static final String CONFIG_MANAGER_SPECIFICATION = "config_manager_specification_factory_namespace";

    /** The property name for active_tab_selector_key. */
    private static final String ACTIVE_TAB_SELECTOR_KEY = "active_tab_selector_key";

    /** The property name for active_tab_selector_identifier. */
    private static final String ACTIVE_TAB_SELECTOR_IDENTIFIER = "active_tab_selector_identifier";

    /** The property name for active_tab_hovered. */
    private static final String ACTIVE_TAB_HOVERED = "active_tab_hovered";

    /** The property name for active_tab_not_hovered. */
    private static final String ACTIVE_TAB_NOT_HOVERED = "active_tab_not_hovered";

    /** The property name for inactive_tab_hovered. */
    private static final String INACTIVE_TAB_HOVERED = "inactive_tab_hovered";

    /** The property name for inactive_tab_not_hovered. */
    private static final String INACTIVE_TAB_NOT_HOVERED = "inactive_tab_not_hovered";

    /** The property name for close_button_padding_top. */
    private static final String CLOSE_BUTTON_PADDING_TOP = "close_button_padding_top";

    /** The property name for close_button_padding_right. */
    private static final String CLOSE_BUTTON_PADDING_RIGHT = "close_button_padding_right";

    /** Prepare the color regex string. */
    private static final String COLOR_REGEX =
        "#[a-fA-F0-9][a-fA-F0-9][a-fA-F0-9][a-fA-F0-9][a-fA-F0-9][a-fA-F0-9]";

    /** An array of length six, representing the start/end position for each color in the regex above. */
    private static final int[] COLOR_INDEX = new int[] {1, 3, 3, 5, 5, 7};

    /** The property name for interior_border_color. */
    private static final String INTERIOR_BORDER_COLOR = "interior_border_color";

    /** The property name for interior_border_width. */
    private static final String INTERIOR_BORDER_WIDTH = "interior_border_width";

    // Prepare some constant integers
    /** 16. */
    private static final int SIXTEEN = 16;

    /** 10. */
    private static final int TEN = 10;

    /** 3. */
    private static final int THREE = 3;

    /** 4. */
    private static final int FOUR = 4;

    /** 5. */
    private static final int FIVE = 5;

    /** Provide the string to be presented in the right click menu. */
    private static final String CLOSE_TAB = "Close Tab";

    /** Provide the string to be presented in the right click menu. */
    private static final String CLOSE_OTHER_TABS = "Close Other Tabs";

    /** Provide the string to be presented in the right click menu. */
    private static final String CLOSE_ALL_TABS = "Close All Tabs";

    /** Provide some number of spaces after the title text. */
    private static final String SPACES_AFTER_TITLE = "   ";

    /** Provide the time limit for loading a file. */
    private static final int TIME_LIMIT = 200;

    /**
     * <p>
     * Represents the images that will be used for the close buttons, indexed by button state. This member is
     * frozen as the map reference will not change. The map state itself is changeable, through the
     * get/setCloseButtonImage methods. This member is also referenced by the paintComponent, processMouseEvent and
     * processMouseMotionEvent methods. It is initialized to an empty map and will never be null. All keys and
     * values will be non-null. Note that using images of differing sizes may lead to a bad user experience - for
     * example a hover image that is smaller than the normal image will lead to a weird user experience. It is
     * recommended (but not enforced) that all images be of the same size.
     * </p>
     */
    private final Map<CloseButtonState, Image> closeButtonImages = new HashMap<CloseButtonState, Image>();

    /**
     * <p>
     * Represents the amount of padding of the close button from the top-right of the tab. It is mutable and is
     * gotten/set by the get/setCloseButtonPadding methods. It is initially set to new Dimension(0, 0) and will
     * never be null. This is used by the paintComponent and processMouseEvent methods.
     * </p>
     */
    private Dimension closeButtonPadding = new Dimension(0, 0);

    /**
     * <p>
     * Represents the border around the interior of the tab - effectively a border around the component being added
     * to the tabbed pane. It is initially null and maybe set to null implying that no borders should be added. It
     * is mutable and is gotten/set by the get/setInteriorBorder methods. Note that using interior borders will
     * modify the current border of the component - by using a composite border. Thus the current border is always
     * preserved but the actual Border value of the component changes. However this change is reversible and things
     * will be reverted when the component is removed from the tabbed pane.
     * </p>
     */
    private Border interiorBorder = null;

    /**
     * <p>
     * Represents the instance of ActiveTabSelector used to select the new active tab when a currently active tab
     * is closed. It is initially null and maybe set to null implying that the default behavior of the JTabbedPane
     * will be used. It is mutable and is gotten/set by the get/setActiveTabSelector methods.
     * </p>
     */
    private ActiveTabSelector activeTabSelector = null;

    /**
     * <p>
     * Represents the context menu shown to the user when he right clicks on a tab. It is frozen since it will not
     * change after being set to a JPopupMenu instance with the following menu items.
     * <ul>
     * <li>a) A "Close Tab" item.</li>
     * <li>b) A "Close Other Tabs" item.</li>
     * <li>c) A "Close All Tabs" item.</li>
     * </ul>
     * A single instance of the inner class ClosableTabbedPane#MenuItemActionListener will be wired to all three
     * menu items. This is used by the processMouseEvent method in order to show the context menu when required.
     * </p>
     * <p>
     * In the current implementation all the initialization will be done in <code>constructorHelper</code> method.
     * </p>
     */
    private final JPopupMenu closeContextMenu = new JPopupMenu();

    /**
     * <p>
     * Represents the tab index over whose close button the mouse is currently hovering. It is initially -1 and
     * will always be
     * <ul>
     * <li>a) The index of a valid tab or</li>
     * <li>b) -1 to indicate that no tab's close button is being hovered upon.</li>
     * </ul>
     * It is mutable and will be set in the processMouseMotionEvent method. It is referenced by the paintComponent
     * method to decide which image should be painted for a given close button.
     * </p>
     */
    private int hoveredTabIndex = -1;

    /**
     * <p>
     * Represents the tab index upon which the last active context menu was popped. It is initially -1 and will
     * always be the index of a valid tab when the context menu is visible. Note that it may have invalid values
     * during periods when the context menu is invisible. It is mutable and set by the processMouseEvent method
     * before popping the context menu. It is used by the inner class
     * ClosableTabbedPane#ContextMenuItemActionListener's actionPerformed method to decide which tabs, if any,
     * should be closed.
     * </p>
     */
    private int closeContextMenuTabIndex = -1;

    /**
     * <p>
     * A private HashSet instance to store ClosableTabbedPaneEventHandler listeners in this class.
     * </p>
     */
    private Set<ClosableTabbedPaneEventHandler> closableTabbedPaneEventHandlers =
        new HashSet<ClosableTabbedPaneEventHandler>();

    /**
     * <p>
     * Constructs an instance of this closable tabbed pane.
     * </p>
     */
    public ClosableTabbedPane() {
        super();
        constructorHelper();
    }

    /**
     * <p>
     * Constructs an instance of this closable tabbed pane with the given tab placement.
     * </p>
     *
     * @param tabPlacement
     *            the placement of the tabs. Must be a valid placement value as determined by JTabbedPane.
     * @throws IllegalArgumentException
     *             thrown by the super class is the tab placement value is not valid.
     */
    public ClosableTabbedPane(int tabPlacement) {
        super(tabPlacement);
        constructorHelper();
    }

    /**
     * <p>
     * Constructs an instance of this closable tabbed pane with the given tab placement and tab layout.
     * </p>
     *
     * @param tabLayoutPolicy
     *            the layout of the tabs. Must be a valid layout value as determined by JTabbedPane.
     * @param tabPlacement
     *            the placement of the tabs. Must be a valid placement value as determined by JTabbedPane.
     * @throws IllegalArgumentException
     *             thrown by the super class is the tab placement or tabLayout value is not valid.
     */
    public ClosableTabbedPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
        constructorHelper();
    }

    /**
     * <p>
     * Constructs this closable tabbed pane with configuration properties from the given namespace. Refer to the CS
     * for the configuration properties.
     * </p>
     *
     * @throws ClosableTabbedPaneConfigurationException
     *             Wrap any errors of the ConfigManager/ObjectFactory in this exception and re-throw.
     * @throws IllegalArgumentException
     *             If namespace is null/empty.
     * @param namespace
     *            The namespace containing configuration properties. Must not be null/empty.
     */
    public ClosableTabbedPane(String namespace) throws ClosableTabbedPaneConfigurationException {
        ExceptionUtils.checkNullOrEmpty(namespace, null, null, "namespace must not be null or empty");
        // Get the instance of ConfigManager
        ConfigManager cm = ConfigManager.getInstance();
        try {
            // Attempt to create the Object Factory
            String specificationFactory = myCMGetString(cm, namespace, CONFIG_MANAGER_SPECIFICATION);
            if (specificationFactory != null) {
                ObjectFactory of = new ObjectFactory(new ConfigManagerSpecificationFactory(specificationFactory));
                // Retrieve the selector key and identifier if present
                String selectorKey = myCMGetString(cm, namespace, ACTIVE_TAB_SELECTOR_KEY);
                String selectorIdentifier = myCMGetString(cm, namespace, ACTIVE_TAB_SELECTOR_IDENTIFIER);
                if (selectorKey != null) {
                    // Create an active tab selector according to the key and identifier
                    if (selectorIdentifier == null) {
                        activeTabSelector = (ActiveTabSelector) of.createObject(selectorKey);
                    } else {
                        activeTabSelector = (ActiveTabSelector) of.createObject(selectorKey, selectorIdentifier);
                    }
                }
            }
            // Read the button images for all the four states
            readImage(CloseButtonState.ACTIVE_TAB_HOVERED, myCMGetString(cm, namespace, ACTIVE_TAB_HOVERED));
            readImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED,
                myCMGetString(cm, namespace, ACTIVE_TAB_NOT_HOVERED));
            readImage(CloseButtonState.INACTIVE_TAB_HOVERED, myCMGetString(cm, namespace, INACTIVE_TAB_HOVERED));
            readImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, myCMGetString(cm, namespace,
                INACTIVE_TAB_NOT_HOVERED));

            // Retrieve the button padding information
            closeButtonPadding =
                new Dimension(myCMGetInteger(cm, namespace, CLOSE_BUTTON_PADDING_RIGHT), myCMGetInteger(cm,
                    namespace, CLOSE_BUTTON_PADDING_TOP));

            // Set the border color and width
            String borderColor = myCMGetString(cm, namespace, INTERIOR_BORDER_COLOR);
            String borderWidth = myCMGetString(cm, namespace, INTERIOR_BORDER_WIDTH);
            if (borderColor != null || borderWidth != null) {
                // Process the border only when at least one of the two properties is present
                Color color = getBackground();
                if (borderColor != null) {
                    if (!borderColor.matches(COLOR_REGEX)) {
                        throw new ClosableTabbedPaneConfigurationException("border color cannot be parsed");
                    }
                    color =
                        new Color(toInteger(borderColor.substring(COLOR_INDEX[0], COLOR_INDEX[1]), SIXTEEN),
                            toInteger(borderColor.substring(COLOR_INDEX[2], COLOR_INDEX[THREE]), SIXTEEN),
                            toInteger(borderColor.substring(COLOR_INDEX[FOUR], COLOR_INDEX[FIVE]), SIXTEEN));
                }
                // Set the width
                int width = borderWidth == null ? 1 : toInteger(borderWidth, TEN);
                // Create the border
                interiorBorder = new LineBorder(color, width, true);
            }
        } catch (ClassCastException cce) {
            throw new ClosableTabbedPaneConfigurationException("Error while class casting", cce);
        } catch (SpecificationConfigurationException sce) {
            throw new ClosableTabbedPaneConfigurationException("Error while specifying factory", sce);
        } catch (IllegalReferenceException ire) {
            throw new ClosableTabbedPaneConfigurationException("Error while referring", ire);
        } catch (InvalidClassSpecificationException icse) {
            throw new ClosableTabbedPaneConfigurationException("Invalid class specified", icse);
        }
    }

    /**
     * A helper method to construct an image based on its path, and mapped to closeButtonImages. The creating of
     * this image will use Toolkit.getDefaultToolkit().createImage(filepath).
     *
     * @param state
     *            the state of this button
     * @param filepath
     *            the file path of this image
     */
    private void readImage(CloseButtonState state, String filepath) {
        if (filepath != null) {
            closeButtonImages.put(state, Toolkit.getDefaultToolkit().createImage(filepath));
        }
    }

    /**
     * <p>
     * A private method for getting string from config manager. This method will check if the return value is empty
     * and return null in that case. UnknownNamespaceException will be simply wrapped and re-thrown to the upper
     * method.
     * </p>
     *
     * @param cm
     *            the given config manager
     * @param namespace
     *            the given namespace
     * @param name
     *            the property name
     * @return the property value retrieved
     * @throws ClosableTabbedPaneConfigurationException
     *             if getString throws UnknownNamespaceException
     */
    private String myCMGetString(ConfigManager cm, String namespace, String name)
        throws ClosableTabbedPaneConfigurationException {
        try {
            // Get the property string from the manager, and check invalid
            String res = cm.getString(namespace, name);
            if (res != null && res.trim().length() == 0) {
                res = null;
            }
            return res;
        } catch (UnknownNamespaceException nae) {
            throw new ClosableTabbedPaneConfigurationException("Namespace not found", nae);
        }
    }

    /**
     * Convert a string into integer, using 'base' as radix.
     *
     * @param s
     *            the string to convert
     * @param base
     *            the radix
     * @return the integer converted this string
     * @throws ClosableTabbedPaneConfigurationException
     *             if cannot be parsed, or negative integer is parsed
     */
    private int toInteger(String s, int base) throws ClosableTabbedPaneConfigurationException {
        try {
            int result = Integer.parseInt(s, base);
            if (result < 0) {
                throw new ClosableTabbedPaneConfigurationException("Integer value must not be negative");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new ClosableTabbedPaneConfigurationException("Error while parsing integer property value", e);
        }
    }

    /**
     * <p>
     * A private method for getting integer from config manager. This method will check if the return value is
     * non-integer and throw ChatContactConfigurationException. UnknownNamespaceException will be simply wrapped
     * and re-thrown to the upper method. If absent, return 0.
     * </p>
     *
     * @param cm
     *            the given config manager
     * @param namespace
     *            the given namespace
     * @param name
     *            the property name
     * @return the property value retrieved, 0 if absent
     * @throws ClosableTabbedPaneConfigurationException
     *             if the retrieved property value is non-integer or negative, or if getString throws
     *             UnknownNamespaceException
     */
    private int myCMGetInteger(ConfigManager cm, String namespace, String name)
        throws ClosableTabbedPaneConfigurationException {
        String res = myCMGetString(cm, namespace, name);
        if (res == null) {
            return 0;
        }
        return toInteger(res, TEN);
    }

    /**
     * A helper method used for all the constructors. This method will enable MouseEvent and MouseMotionEvent in
     * its super class, and prepare the right click pop-up menu.
     */
    private void constructorHelper() {
        // Enable events
        enableEvents(MouseEvent.MOUSE_EVENT_MASK);
        enableEvents(MouseEvent.MOUSE_MOTION_EVENT_MASK);

        // Prepare the right click pop-up menu along with listeners
        ContextMenuItemActionListener listener = new ContextMenuItemActionListener();
        closeContextMenu.add(CLOSE_TAB).addActionListener(listener);
        closeContextMenu.add(CLOSE_OTHER_TABS).addActionListener(listener);
        closeContextMenu.add(CLOSE_ALL_TABS).addActionListener(listener);
    }

    /**
     * <p>
     * Gets the close button image for the given button state.
     * </p>
     *
     * @param buttonState
     *            the state of the close button for which to get the image. Must not be null.
     * @return the close button image for the given button state. null if no image is assigned.
     * @throws IllegalArgumentException
     *             if the given argument is null.
     */
    public Image getCloseButtonImage(CloseButtonState buttonState) {
        ExceptionUtils.checkNull(buttonState, null, null, "buttonState must not be null");
        return closeButtonImages.get(buttonState);
    }

    /**
     * <p>
     * A private helper method to perform similar function as getCloseButtonImage.
     * </p>
     * <p>
     * This method will throw ISE if the corresponding image is not set. If the image's width or height is -1, this
     * method will take a loop of at most 200ms. If the width and height are still not loaded after 200ms, ISE will
     * be thrown too. This is to prevent if the image's source is illegal, for example when image's filepath is
     * invalid, it still can be created, but the content will never be loaded.
     * </p>
     *
     * @param buttonState
     *            the button state
     * @return the image corresponding to the given button state
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded within 200ms
     */
    private Image myGetCloseButtonImage(CloseButtonState buttonState) {
        Image image = closeButtonImages.get(buttonState);
        if (image == null) {
            throw new IllegalStateException("the button image for " + buttonState + " is not set yet");
        }
        long time = System.currentTimeMillis();
        while ((image.getWidth(null) == -1 || image.getHeight(null) == -1)
            && System.currentTimeMillis() - time < TIME_LIMIT) {
            try {
                Thread.sleep(TEN);
            } catch (InterruptedException e) {
                // Ignore it
            }
        }
        if (image.getWidth(null) == -1 || image.getHeight(null) == -1) {
            throw new IllegalStateException("the button image for " + buttonState + " cannot be loaded");
        }
        return image;
    }

    /**
     * <p>
     * Sets the close button image for the given button state.
     * </p>
     *
     * @param buttonState
     *            The state of the close button for which to set the image. Must not be null.
     * @param image
     *            The image to use. Must not be null. Recommended that images for all buttons be of the same size.
     * @throws IllegalArgumentException
     *             If either of the given argument is null.
     */
    public void setCloseButtonImage(CloseButtonState buttonState, Image image) {
        ExceptionUtils.checkNull(buttonState, null, null, "buttonState must not be null");
        ExceptionUtils.checkNull(image, null, null, "image must not be null");
        closeButtonImages.put(buttonState, image);
    }

    /**
     * <p>
     * Gets the padding of close button from the top-right corner of the tab.
     * </p>
     *
     * @return the padding of close button from the top-right corner of the tab.
     */
    public Dimension getCloseButtonPadding() {
        return new Dimension(closeButtonPadding);
    }

    /**
     * <p>
     * Sets the padding of close button from the top-right corner of the tab.
     * </p>
     *
     * @param padding
     *            The padding to use. Must not be null. Negative dimension values are not allowed.
     * @throws IllegalArgumentException
     *             If a null argument is being set or either dimension value is negative.
     */
    public void setCloseButtonPadding(Dimension padding) {
        ExceptionUtils.checkNull(padding, null, null, "padding must not be null");
        if (padding.getWidth() < 0 || padding.getHeight() < 0) {
            throw new IllegalArgumentException("the giving padding must not have negative value in dimension");
        }
        this.closeButtonPadding = new Dimension(padding);
    }

    /**
     * <p>
     * Gets the border used around the interior of the tab.
     * </p>
     *
     * @return the border used around the interior of the tab. null to indicate no border.
     */
    public Border getInteriorBorder() {
        return interiorBorder;
    }

    /**
     * <p>
     * Sets the border used around the interior of the tab. For each currently added component that is an instance
     * of JComponent, this method will get its border which must be of type CompositeBorder, and create a new
     * CompositeBorder with the same inner border but with our interiorBorder as its new outer border.
     * </p>
     *
     * @param border
     *            The border to use. Possibly null to indicate no border.
     */
    public void setInteriorBorder(Border border) {
        this.interiorBorder = border;
        for (int i = 0; i < this.getTabCount(); i++) {
            if (getComponentAt(i) instanceof JComponent) {
                JComponent comp = (JComponent) getComponentAt(i);
                comp.setBorder(new CompoundBorder(interiorBorder, ((CompoundBorder) comp.getBorder())
                    .getInsideBorder()));
            }
        }
    }

    /**
     * <p>
     * Gets the instance of ActiveTabSelector used to select a new active tab when the currently active tab is
     * closed.
     * </p>
     *
     * @return the instance of ActiveTabSelector used to select a new active tab when the currently active tab is
     *         closed.
     */
    public ActiveTabSelector getActiveTabSelector() {
        return activeTabSelector;
    }

    /**
     * <p>
     * Sets the instance of ActiveTabSelector used to select a new active tab when the currently active tab is
     * closed. This method will call ActiveTabSelector#uninstallSelector on this class if another activeTabSelector
     * is previously set before. It will also call ActiveTabSelector#installSelector on this class after set.
     * </p>
     *
     * @param activeTabSelector
     *            the instance of ActiveTabSelector to be used to select a new active tab when the currently active
     *            tab is closed. May be null to indicate no selector is used.
     */
    public void setActiveTabSelector(ActiveTabSelector activeTabSelector) {
        // if another activeTabSelector is previously set before, uninstall it
        if (this.activeTabSelector != null) {
            this.activeTabSelector.uninstallSelector(this);
        }
        this.activeTabSelector = activeTabSelector;
        // Install this new ActiveTabSelector on this
        if (activeTabSelector != null) {
            activeTabSelector.installSelector(this);
        }
    }

    /**
     * <p>
     * Adds the given handler to the list of handlers to handle ClosableTabbedPaneEvents. It will not add if this
     * listener is added before - by comparing the instance.
     * </p>
     *
     * @param eventHandler
     *            The handler to add. Possibly null or already added, in which case nothing is done.
     */
    public void addClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler) {
        if (eventHandler != null) {
            // Add only when non-null
            closableTabbedPaneEventHandlers.add(eventHandler);
        }
    }

    /**
     * <p>
     * Removes the given handler from the list of handlers to handle ClosableTabbedPaneEvents. If it is not
     * present, this method will does nothing.
     * </p>
     *
     * @param eventHandler
     *            The handler to remove. Possibly null or not present in the present list, in which case nothing is
     *            done.
     */
    public void removeClosableTabbedPaneEventHandler(ClosableTabbedPaneEventHandler eventHandler) {
        if (eventHandler != null) {
            // Remove only when non-null
            closableTabbedPaneEventHandlers.remove(eventHandler);
        }
    }

    /**
     * <p>
     * Gets the list of handlers currently added to handle ClosableTabbedPaneEvents.
     * </p>
     *
     * @return the list of handlers currently added to handle ClosableTabbedPaneEvents.
     */
    public ClosableTabbedPaneEventHandler[] getClosableTabbedPaneEventHandlers() {
        // A new array of length closableTabbedPaneEventHandlers.size() will be created
        // in prior of toArray method, because it is faster
        return closableTabbedPaneEventHandlers
            .toArray(new ClosableTabbedPaneEventHandler[closableTabbedPaneEventHandlers.size()]);
    }

    /**
     * <p>
     * Inserts a component, at index, represented by a title and/or icon, either of which may be null. The super
     * class uses java.util.Vector internally, see insertElementAt for details of insertion conventions.
     * </p>
     * <p>
     * If the component is a JComponent, this method will get the current border of the component, and set its new
     * border to a new CompositeBorder(interiorBorder, currentBorder). Then a new ClosableTabbedPaneEvent for this
     * index will be fired to the listeners via fireTabAdded(e).
     * </p>
     *
     * @param index
     *            the position to insert this new tab. Must be >=0 &&<=this.getTabCount()
     * @param component
     *            The component to be displayed when this tab is clicked. Must not be null.
     * @param title
     *            the title to be displayed in this tab. Possibly null/empty.
     * @param tip
     *            the tool-tip to be displayed for this tab. Possibly null/empty.
     * @param icon
     *            the icon to be displayed in this tab. Possibly null/empty.
     * @throws IllegalArgumentException
     *             If component is null.
     * @throws IndexOutOfBoundsException
     *             If index is out of range. <b>Pay attention:</b> the super class will remove the given component
     *             if it is already existed before the removing. For more details when this exception is thrown,
     *             please refer to its super class.
     */
    public void insertTab(String title, Icon icon, Component component, String tip, int index) {
        ExceptionUtils.checkNull(component, null, null, "component must not be null");
        // Let the super class to insert it
        super.insertTab(title, icon, component, tip, index);
        // Set its new border if it is JComponent
        if (component instanceof JComponent) {
            ((JComponent) component).setBorder(new CompoundBorder(interiorBorder, ((JComponent) component)
                .getBorder()));
        }
        // Fire the event
        fireTabAddedEvent(new ClosableTabbedPaneEvent(index, this, ClosableTabbedPane.this.getComponent(index)));
    }

    /**
     * <p>
     * Returns the tab title at <code>index</code>.
     * </p>
     * <p>
     * This method is overridden in order to add spaces after the title.
     * </p>
     *
     * @param index
     *            the index of the item being queried
     * @return the title at <code>index</code>
     * @throws IndexOutOfBoundsException
     *             if index is out of range (index &lt; 0 || index &gt;= tab count)
     */
    public String getTitleAt(int index) {
        String res = super.getTitleAt(index);
        return (res == null ? "" : res) + getTitleSuffix();
    }

    /**
     * <p>
     * In order to make the close button not to appear upon the text, several spaces have to be added after the
     * title. This method will return a String with a number of spaces, which is what this class will add after the
     * title.
     * </p>
     * <p>
     * In the current implementation, 3 spaces will be used.
     * </p>
     *
     * @return a String with a number of spaces, which is what this class will add after the title
     */
    public String getTitleSuffix() {
        return SPACES_AFTER_TITLE;
    }

    /**
     * <p>
     * Removes the tab at index. After the component associated with index is removed, the super class ensures that
     * its visibility is reset to true to ensure it will be visible if added to other containers. This class will
     * re-adjust the component's borders as required.
     * </p>
     * <p>
     * If it is a JComponent, this method will get its border which must be a CompositeBorder, then set its new
     * border to the inner border of the composite border. Only after that it will remove this tab.
     * </p>
     *
     * @throws IndexOutOfBoundsException
     *             - if index is out of range (index &lt; 0 || index &gt;= tab count)
     * @param index
     *            the index of the tab to be removed
     */
    public void removeTabAt(int index) {
        // Get the component
        Component component = getComponentAt(index);
        // Restore its border
        if (component instanceof JComponent && ((JComponent) component).getBorder() instanceof CompoundBorder) {
            ((JComponent) component).setBorder(((CompoundBorder) ((JComponent) component).getBorder())
                .getInsideBorder());
        }
        // Remove it
        if (getSelectedIndex() > index) {
            setSelectedIndex(getSelectedIndex() - 1);
        }
        super.removeTabAt(index);
    }

    /**
     * <p>
     * A private helper method to get the button's display rectangle for a given index. This method will check the
     * button's image size also.
     * </p>
     *
     * @param tabIndex
     *            the tab index to retrieve its Rectangle
     * @return the button's display position
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded within 200ms
     */
    private Rectangle getCloseImageRectangle(int tabIndex) {
        // Get the button state
        CloseButtonState state = getButtonState(tabIndex);
        // Get the image location and hence the image rectangle
        Image image = myGetCloseButtonImage(state);

        // Get the tab's rectangle
        Rectangle tab = this.getUI().getTabBounds(this, tabIndex);
        // Calculate x by subtracting the padding and image width from the right-end of the tab.
        int x = tab.x + tab.width - image.getWidth(null) - closeButtonPadding.width;
        // Calculate y by adding the padding to the top of the tab.
        int y = tab.y + closeButtonPadding.height;

        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    /**
     * <p>
     * Get the CloseButtonState for a given tab index.
     * </p>
     *
     * @param index
     *            the tab index to check
     * @return the CloseButtonState for the given tab index
     */
    private CloseButtonState getButtonState(int index) {
        CloseButtonState state = null;
        // State if this tab is active
        if (index == getSelectedIndex()) {
            state =
                index == hoveredTabIndex ? CloseButtonState.ACTIVE_TAB_HOVERED
                    : CloseButtonState.ACTIVE_TAB_NOT_HOVERED;
        } else {
            // State if this tab is inactive
            state =
                index == hoveredTabIndex ? CloseButtonState.INACTIVE_TAB_HOVERED
                    : CloseButtonState.INACTIVE_TAB_NOT_HOVERED;
        }
        return state;
    }

    /**
     * <p>
     * Processes mouse events occurring on this component. This method will process the left mouse click on close
     * button and the popup right click.
     * </p>
     * <p>
     * Refer to section 1.3.1 of the CS.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If e is null.
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded within 200ms
     * @param e
     *            The mouse event. Must not be null.
     */
    protected void processMouseEvent(MouseEvent e) {
        ExceptionUtils.checkNull(e, null, null, "MouseEvent e must not be null");
        // Loop over all tabs
        for (int i = 0; i < this.getTabCount(); i++) {
            // See if the mouse-event falls in this tab's bounds
            Rectangle rect = this.getUI().getTabBounds(this, i);
            if (rect.contains(e.getPoint())) {
                Rectangle imageRect = getCloseImageRectangle(i);
                // If the mouse pointer is over the button
                if (imageRect.contains(e.getPoint())) {
                    // For a left-click
                    if (e.getID() == MouseEvent.MOUSE_CLICKED && e.getButton() == MouseEvent.BUTTON1) {
                        // Construct the event
                        ClosableTabbedPaneEvent[] event =
                            new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(i, this,
                                ClosableTabbedPane.this.getComponent(i))};
                        // Fire a closing event
                        boolean[] result = fireTabsClosingEvent(event);
                        // Fire the closed event
                        if (result[0]) {
                            fireTabsClosedEvent(event);
                        }
                        return;
                    }

                    // Ignore mouse-presses, to prevent the tab from switching in case the left mouse button is
                    // depressed but the click is still incomplete.
                    if (e.getID() == MouseEvent.MOUSE_PRESSED && e.getButton() == MouseEvent.BUTTON1) {
                        return;
                    }
                }

                // If it's a popup trigger, pop the context menu and exit the method
                if (e.isPopupTrigger()) {
                    closeContextMenuTabIndex = i;
                    closeContextMenu.show(this, e.getX(), e.getY());
                    return;
                }

                // If it's a right mouse button event, ignore it.
                // This is needed since the UI will otherwise activate the tab on a right mouse down as well
                if (e.getButton() == MouseEvent.BUTTON3) {
                    return;
                }
            }
        }

        // If we reach here, let the mouse event be handled normally
        super.processMouseEvent(e);
    }

    /**
     * <p>
     * Processes mouse motion events occurring on this component. This method will detect the tab with hovered
     * close button, which will result in a different display picture.
     * </p>
     * <p>
     * Refer to section 1.3.1 of the CS.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If e is null.
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded within 200ms
     * @param e
     *            The mouse event. Must not be null.
     */
    protected void processMouseMotionEvent(MouseEvent e) {
        ExceptionUtils.checkNull(e, null, null, "MouseEvent e must not be null");

        // Ignore MOUSE_DRAGGED
        // http://forums.topcoder.com/?module=Thread&threadID=607194&start=0
        if (e.getID() == MouseEvent.MOUSE_DRAGGED) {
            // Let the mouse event be handled normally
            super.processMouseMotionEvent(e);
            return;
        }
        // Set to -1 if none of the close button is hovered
        int newIndex = -1;
        // Loop over all tabs
        for (int i = 0; i < this.getTabCount(); i++) {
            // See if the mouse-event falls in this tab's bounds
            Rectangle rect = this.getUI().getTabBounds(this, i);
            if (rect.contains(e.getPoint())) {
                Rectangle imageRect = getCloseImageRectangle(i);
                // If the mouse pointer is over the button
                if (imageRect.contains(e.getPoint())) {
                    // Set the hovered tab index to this tab
                    newIndex = i;
                }
            }
        }

        // Let the mouse event be handled normally
        super.processMouseMotionEvent(e);

        // IMPORTANT: Only repaint when hoveredTabIndex is modified.
        // This will strongly make this class efficient
        if (hoveredTabIndex != newIndex) {
            hoveredTabIndex = newIndex;
            repaint();
        }
    }

    /**
     * <p>
     * Paints this component. This method will firstly invoke its super one, and then draw a close button on each
     * tab.
     * </p>
     * <p>
     * Refer to section 1.3.1 of the CS.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If g is null.
     * @throws IllegalStateException
     *             if the button's image be used is not set or cannot be loaded within 200ms
     * @param g
     *            The graphics context on which to paint. Must not be null.
     */
    protected void paintComponent(Graphics g) {
        ExceptionUtils.checkNull(g, null, null, "The Graphics g must not be null");
        // Let the UI do its painting first
        super.paintComponent(g);

        // Loop over all tabs
        for (int i = 0; i < this.getTabCount(); i++) {
            CloseButtonState state = getButtonState(i);
            // Get the image location and paint
            Image image = myGetCloseButtonImage(state);

            // Get the position of the close button
            Rectangle imageRect = getCloseImageRectangle(i);

            // Loop until the image is fully loaded
            long time = System.currentTimeMillis();
            while (!g.drawImage(image, imageRect.x, imageRect.y, null)
                && System.currentTimeMillis() - time < TIME_LIMIT) {
                try {
                    Thread.sleep(TEN);
                } catch (InterruptedException e) {
                    // Ignore it
                }
            }
        }
    }

    /**
     * <p>
     * Fires a tab added event using the given event.
     * </p>
     * <p>
     * This method will get all closable tabbed pane event listeners and call tabAdded on each of them.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if event is null
     * @param event
     *            The event to fire. Must not be null.
     */
    protected void fireTabAddedEvent(ClosableTabbedPaneEvent event) {
        ExceptionUtils.checkNull(event, null, null, "The ClosableTabbedPaneEvent event must not be null");
        for (ClosableTabbedPaneEventHandler handler : getClosableTabbedPaneEventHandlers()) {
            handler.tabAdded(event);
        }
    }

    /**
     * <p>
     * Fires a tabs closing event using the given event.
     * </p>
     * <p>
     * This method will get all closable tabbed pane event listeners and call tabsClosing on each of them. For each
     * boolean in the return array, it will be true only when all the listeners return true. Besides, if no
     * listener is present, it will return a true array.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If events is null/empty or contains nulls.
     * @param events
     *            The event to fire. Must not be null/empty or contain nulls.
     * @return The result of the event being handled.
     */
    protected boolean[] fireTabsClosingEvent(ClosableTabbedPaneEvent[] events) {
        ClosableTabbedPaneHelper.checkArray(events);
        // Prepare a default result
        boolean[] result = new boolean[events.length];
        Arrays.fill(result, true);
        // Fire to each listener
        for (ClosableTabbedPaneEventHandler handler : getClosableTabbedPaneEventHandlers()) {
            boolean[] tmp = handler.tabsClosing(events);
            // Append the result
            for (int i = 0; i < events.length; i++) {
                result[i] &= tmp[i];
            }
        }
        return result;
    }

    /**
     * <p>
     * Fires a tabs closed event using the given event. This method will possibly receive duplicate events.
     * </p>
     * <p>
     * This method will call removeTabAt for each element of the argument list. Then get all closable tabbed pane
     * event listeners and call tabsClosed on each of them. The actual removing process is working as below:
     * <ol>
     * <li>Obtain all the tab indices to be removed, and sort them.</li>
     * <li>Remove all of those tabs except the selected one(if present) from the large index to small index - to
     * make sure we do not need to re-calculate the new index after remove. After each removing, this event is
     * immediately fired to all the handlers - this is to make our PreviousActiveTabSelector work properly.</li>
     * <li>For the selected tab that has been SKIPPED in step 2, call activeTabSelector#selectNewActiveTab first,
     * and then remove it. Certainly yes it will be fired right after it.</li>
     * </ol>
     * <b>Note: </b> this method separate the close/fire process in order to make PreviousActiveTabSelector runs
     * properly. And it is VERY important that the ClosableTabbedPaneEvent instances fired to handlers will NOT be
     * the same as parameter. They will be re-constructed in this method for convenience.
     * </p>
     *
     * @throws IllegalArgumentException
     *             If events is null/empty or contains nulls.
     * @param events
     *            The event to fire. Must not be null/empty or contain nulls.
     */
    protected void fireTabsClosedEvent(ClosableTabbedPaneEvent[] events) {
        ClosableTabbedPaneHelper.checkArray(events);
        // ATTENTION:
        // The following procedure is confirmed on the forum, and well-explained in the javadoc.
        // http://forums.topcoder.com/?module=Thread&threadID=606395&start=0

        List<Integer> toRemove = new ArrayList<Integer>();
        Set<Integer> indexSet = new HashSet<Integer>();

        // Step 1 - construct the remove list
        for (int i = 0; i < events.length; i++) {
            if (events[i].getClosableTabbedPane() == this && events[i].getTabIndex() != -1
                && !indexSet.contains(events[i].getTabIndex())) {
                // toRemove[i]==-1 will not likely to happen, but I used it in case of further use
                indexSet.add(events[i].getTabIndex());
                toRemove.add(events[i].getTabIndex());
            }
        }

        // Step 2
        // Sort them
        Collections.sort(toRemove);
        // Remove backwards, except the selected one
        int toRemoveSelected = -1;
        for (int i = toRemove.size() - 1; i >= 0; i--) {
            if (toRemove.get(i) == getSelectedIndex()) {
                toRemoveSelected = toRemove.get(i) - i;
            } else {
                // Create the event to be fired later.
                // This line must be called in prior of remove, or else IAE will happen
                ClosableTabbedPaneEvent event =
                    new ClosableTabbedPaneEvent(toRemove.get(i), this, ClosableTabbedPane.this
                        .getComponent(toRemove.get(i)));
                removeTabAt(toRemove.get(i));
                for (ClosableTabbedPaneEventHandler handler : getClosableTabbedPaneEventHandlers()) {
                    handler.tabsClosed(new ClosableTabbedPaneEvent[] {event});
                }
            }
        }

        // Step 3
        // Remove the selected one at last
        if (toRemoveSelected != -1) {
            // Re-select a new active tab
            if (activeTabSelector != null) {
                activeTabSelector.selectNewActiveTab(this);
            }
            // Create the event to be fired later.
            // This line must be called in prior of remove, or else IAE will happen
            ClosableTabbedPaneEvent event =
                new ClosableTabbedPaneEvent(toRemoveSelected, this, ClosableTabbedPane.this
                    .getComponent(toRemoveSelected));

            // After all, remove it
            removeTabAt(toRemoveSelected);

            // Fire the last event
            for (ClosableTabbedPaneEventHandler handler : getClosableTabbedPaneEventHandlers()) {
                handler.tabsClosed(new ClosableTabbedPaneEvent[] {event});
            }
        }

    }

    /**
     * <p>
     * This private inner class of the closable tabbed pane listens for the selection of menu items in the context
     * menu that allows for tab closure.
     * </p>
     * <p>
     * This class implements ActionListener and perform the necessary closure operation there.
     * </p>
     * <p>
     * Thread Safety: This class is thread safe because it is stateless. However, its outer class is not thread
     * safe.
     * </p>
     *
     * @author humblefool, TCSDEVELOPER
     * @version 1.0
     */
    private class ContextMenuItemActionListener implements ActionListener {
        /**
         * <p>
         * Constructs an instance of this object.
         * </p>
         */
        public ContextMenuItemActionListener() {
            // Does nothing.
        }

        /**
         * <p>
         * Called when a context menu item is clicked.
         * </p>
         * <p>
         * This method will check if the event represents "Close Tab", "Close Other Tabs" or "Close All Tabs" and
         * construct corresponding ClosableTabbedPaneEvent array and then fireTabsClosing and fireTabsClosed.
         * </p>
         *
         * @throws IllegalArgumentException
         *             If e is null.
         * @param actionEvent
         *            The action event. Must not be null.
         */
        public void actionPerformed(ActionEvent actionEvent) {
            ExceptionUtils.checkNull(actionEvent, null, null, "actionEvent must not be null");
            // The array of tabs to be closed
            ClosableTabbedPaneEvent[] toClose;

            // Classify the actionEvent
            if (actionEvent.getActionCommand().equals(CLOSE_TAB)) {
                // Single tab close command
                toClose =
                    new ClosableTabbedPaneEvent[] {new ClosableTabbedPaneEvent(closeContextMenuTabIndex,
                        ClosableTabbedPane.this, ClosableTabbedPane.this.getComponent(closeContextMenuTabIndex))};
            } else if (actionEvent.getActionCommand().equals(CLOSE_ALL_TABS)) {
                // Close all tabs command
                toClose = new ClosableTabbedPaneEvent[getTabCount()];
                for (int i = 0; i < getTabCount(); i++) {
                    toClose[i] =
                        new ClosableTabbedPaneEvent(i, ClosableTabbedPane.this, ClosableTabbedPane.this
                            .getComponent(i));
                }
            } else {
                // Close all other tabs command
                toClose = new ClosableTabbedPaneEvent[getTabCount() - 1];
                for (int i = 0; i < getTabCount(); i++) {
                    if (i < closeContextMenuTabIndex) {
                        toClose[i] =
                            new ClosableTabbedPaneEvent(i, ClosableTabbedPane.this, ClosableTabbedPane.this
                                .getComponent(i));
                    } else if (i > closeContextMenuTabIndex) {
                        toClose[i - 1] =
                            new ClosableTabbedPaneEvent(i, ClosableTabbedPane.this, ClosableTabbedPane.this
                                .getComponent(i));
                    }
                }
            }
            // FireTabsClosed only when non empty array
            if (toClose.length > 0) {
                // Record the result
                boolean[] result = fireTabsClosingEvent(toClose);
                // Filter those successful events
                List<ClosableTabbedPaneEvent> filtered = new ArrayList<ClosableTabbedPaneEvent>();
                for (int i = 0; i < result.length; i++) {
                    if (result[i]) {
                        filtered.add(toClose[i]);
                    }
                }
                // FireTabClosed only when non-empty array
                if (filtered.size() > 0) {
                    fireTabsClosedEvent(filtered.toArray(new ClosableTabbedPaneEvent[filtered.size()]));
                }
            }
        }
    }
}
