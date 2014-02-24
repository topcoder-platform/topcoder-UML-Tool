/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 * <p>
 * This JPanel is the main panel of the component and will manage the collapsed and expansion
 * panels.
 * </p>
 * <p>
 * This panel is simply a container around two other specified components (either application
 * provided or the default components provided with this component).
 * </p>
 * <p>
 * The SideMenuPanel works with a SideMenuModel to determine whether the overall title used, whether
 * it's in an expanded state, whether the expanded panel will float over other panels (or be
 * inserted along side them) and what the absolute width of the expanded panel will be.
 * </p>
 * <p>
 * The class also provides a number of convenience methods to modify the state in the model.
 * </p>
 * <p>
 * This panel will only be created directly by the application.
 * </p>
 * <p>
 * This panel will fire property change events (using the constants defined on the class) if the
 * contents change.
 * </p>
 * <p>
 * <strong>Sample usage:</strong>
 * 
 * <pre>
 * // Assume there is a panel called appPanel that the side menu will be added to
 * // (on the west side via BorderLayout) and we have an icon for both the expanded
 * // buttons and collapse buttons
 * JFrame frame = new JFrame(&quot;Side Menu Demo&quot;);
 * final Container appPane = frame.getContentPane();
 * 
 * // assume there is a tools panel, here we simply use an empty panel.
 * JPanel toolsPanel = new JPanel();
 * 
 * // Create the side menu for it
 * SideMenuPanel smp = new SideMenuPanel(&quot;Tools&quot;, toolsPanel, TestHelper.EXPAND_ICON,
 *         TestHelper.COLLAPSE_ICON);
 * 
 * // Set the width to 100
 * smp.setAbsoluteWidth(100);
 * 
 * // Start it in an expanded state
 * smp.setExpanded(true);
 * 
 * // Add it to our panel
 * appPane.add(smp, BorderLayout.WEST);
 * </pre>
 * 
 * </p>
 * <p>
 * This class is NOT thread safe since it has mutable state and provides no locking. The state
 * should only be modified on the awt event thread.
 * </p>
 * 
 * @author Pops, KingStone
 * @version 1.0
 */
public class SideMenuPanel extends AbstractSideMenuPanel {
    /**
     * <p>
     * This public constant represents the property name that will be used when the collapsed
     * component (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String COLLAPSED_COMPONENT = "collapsedComponent";

    /**
     * <p>
     * This public constant represents the property name that will be used when the expanded
     * component (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String EXPANDED_COMPONENT = "expandedComponent";

    /**
     * <p>
     * This variable represents the component that will be shown when the SideMenuPanel is
     * collapsed.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the setter,getter, xxxVisibleUpperExpandButton,
     * xxxExpandIcon and sideMenuModelPropertyChange methods.
     * </p>
     */
    private JComponent collapsedComponent;

    /**
     * <p>
     * This variable represents the component that will be shown when the SideMenuPanel is expanded.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable, and will never be null.
     * </p>
     * <p>
     * This variable is only referenced by the setter,getter, xxxVisibleUpperExpandButton,
     * xxxExpandIcon and sideMenuModelPropertyChange methods.
     * </p>
     */
    private JComponent expandedComponent;

    /**
     * <p>
     * This variable represents the Popup that will contain the expandedComponent when it is
     * floating.
     * </p>
     * <p>
     * This variable is initially set to null, is mutable and will only be non-null when the side
     * menu is expanded and floating.
     * </p>
     */
    private Popup floatingPopup = null;

    /**
     * <p>
     * Constructs the side menu panel from the given title, content and icons.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @throws IllegalArgumentException
     *             if the content is null
     * @param collapseIcon
     *            A possibly null collapse icon
     * @param title
     *            A non-null, non-empty (trim'd) string representing the title
     * @param content
     *            A non-null content component
     * @param expandIcon
     *            A possibly null expanded icon
     */
    public SideMenuPanel(String title, JComponent content, Icon expandIcon, Icon collapseIcon) {
        this(title, content, expandIcon, collapseIcon, null);
    }

    /**
     * <p>
     * Constructs the side menu panel from the given title, content and icons.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @throws IllegalArgumentException
     *             if the content is null
     * @param pinIcon
     *            A possibly null pin icon
     * @param collapseIcon
     *            A possibly null collapse icon
     * @param title
     *            A non-null, non-empty (trim'd) string representing the title
     * @param content
     *            A non-null content component
     * @param expandIcon
     *            A possibly null expanded icon
     */
    public SideMenuPanel(String title, JComponent content, Icon expandIcon, Icon collapseIcon,
            Icon pinIcon) {
        super(new DefaultSideMenuModel(title));
        this.expandedComponent = new DefaultExpandedSideMenuPanel(getSideMenuModel(), content,
                collapseIcon, pinIcon);
        this.collapsedComponent = new DefaultCollapsedSideMenuPanel(getSideMenuModel(), expandIcon);
        setLayout(new BorderLayout());

        // ensure the panel will be updated from all the attributes of the side menu
        sideMenuModelPropertyChange(new PropertyChangeEvent(this, SIDE_MENU_MODEL, null,
                getSideMenuModel()));
    }

    /**
     * <p>
     * Constructs the side menu panel from the given model and components.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if any argument is null
     * @param sideMenuModel
     *            A non-null side menu model to use
     * @param collapsedComponent
     *            A non-null collapsed component to use
     * @param expandedComponent
     *            A non-null expanded component to use
     */
    public SideMenuPanel(SideMenuModel sideMenuModel, JComponent collapsedComponent,
            JComponent expandedComponent) {
        super(sideMenuModel);
        
        Helper.checkComponent(collapsedComponent, sideMenuModel, "collapsedComponent");
        Helper.checkComponent(expandedComponent, sideMenuModel, "collapsedComponent");
        this.collapsedComponent = collapsedComponent;
        this.expandedComponent = expandedComponent;
        setLayout(new BorderLayout());

        // ensure the panel will be updated from all the attributes of the side menu
        sideMenuModelPropertyChange(new PropertyChangeEvent(this, SIDE_MENU_MODEL, null,
                sideMenuModel));
    }

    /**
     * <p>
     * Returns the collapsed component used by this panel.
     * </p>
     *
     * @return A non-null collapsed component to use
     */
    public JComponent getCollapsedComponent() {
        return collapsedComponent;
    }

    /**
     * <p>
     * Sets the collapsed panel used by this application.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @throws IllegalArgumentException
     *             if component is null, or if the new component contains different
     *             sideMenuModel.
     * @param component
     *            A non-null component to use when collapsed
     */
    public void setCollapsedComponent(JComponent component) {
        SideMenuModel sideMenuModel = getSideMenuModel();
        Helper.checkState(sideMenuModel);
        Helper.checkComponent(component, sideMenuModel, "collapsedComponent");
        JComponent oldCollapsedComponent = this.collapsedComponent;
        this.collapsedComponent = component;
        if (!sideMenuModel.isExpanded()) {
            // update UI
            remove(oldCollapsedComponent);
            add(this.collapsedComponent, BorderLayout.CENTER);
            validate();
        }
        firePropertyChange(COLLAPSED_COMPONENT, oldCollapsedComponent, this.collapsedComponent);
    }

    /**
     * <p>
     * Returns the expanded component used by this panel.
     * </p>
     *
     * @return A non-null expanded component
     */
    public JComponent getExpandedComponent() {
        return expandedComponent;
    }

    /**
     * <p>
     * Sets the expanded panel used by this application.
     * </p>
     * <p>
     * if the old ExpandedComponent using an <code>AbstractSideMenuPanel</code> type, the user
     * should remove the menu model to prevent memory leak or something to that effect, like
     * {@link AbstractSideMenuPanel#setSideMenuModel(SideMenuModel)} (we use null SideMenuModel
     * here)
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @throws IllegalArgumentException
     *             if component is null, or if the new component contains different
     *             sideMenuModel.
     * @param component
     *            A non-null component to use when expanded
     */
    public void setExpandedComponent(JComponent component) {
        SideMenuModel sideMenuModel = getSideMenuModel();
        Helper.checkState(sideMenuModel);
        Helper.checkComponent(component, sideMenuModel, "expandedComponent");
        JComponent oldExpandedComponent = this.expandedComponent;
        this.expandedComponent = component;
        // Explicitly set the width
        setExpandedWidth(getSideMenuModel().getAbsoluteWidth());
        if (sideMenuModel.isFloating()) {
            // float the new one
            floatSideMenu();
        } else {
            if (sideMenuModel.isExpanded()) {
                remove(oldExpandedComponent);
                add(expandedComponent, BorderLayout.CENTER);
                validate();
            }
        }

        firePropertyChange(EXPANDED_COMPONENT, oldExpandedComponent, expandedComponent);
    }

    /**
     * <p>
     * Sets the side menu model for this class, a <code>PropertyChangeListener</code> is added into the
     * new sideMenuModel if it is not null.
     * </p>
     * <p>
     * Side menu model of this panel's AbstractSideMenuPanel children will be updated too.
     * </p>
     *
     * @param newValue
     *            A side menu model to use(can be null)
     */
    @Override
    public void setSideMenuModel(SideMenuModel newValue) {
        // update components
        if (collapsedComponent instanceof AbstractSideMenuPanel) {
            ((AbstractSideMenuPanel) this.collapsedComponent).setSideMenuModel(newValue);
        }
        if (expandedComponent instanceof AbstractSideMenuPanel) {
            ((AbstractSideMenuPanel) this.expandedComponent).setSideMenuModel(newValue);
        }
        super.setSideMenuModel(newValue);
    }

    /**
     * <p>
     * Convenience method to return true if the side menu is expanded.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @return True if the panel is expanded, false otherwise
     */
    public boolean isExpanded() {
        Helper.checkState(getSideMenuModel());
        return getSideMenuModel().isExpanded();
    }

    /**
     * <p>
     * Convenience method to set the side menu expanded (true) or not (false).
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @param expand
     *            true if the side menu should be expanded (false otherwise)
     */
    public void setExpanded(boolean expand) {
        Helper.checkState(getSideMenuModel());
        getSideMenuModel().setExpanded(expand);
    }

    /**
     * <p>
     * Convenience method to return the title for the side menu.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @return A non-null, non-empty (trim'd) variable representing the title
     */
    public String getTitle() {
        Helper.checkState(getSideMenuModel());
        return getSideMenuModel().getTitle();
    }

    /**
     * <p>
     * Convenience method to set the title for the side menu.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @param title
     *            A non-null, non-empty (trim'd) variable representing the title.(The title will be
     *            trim'd before set to class field)
     */
    public void setTitle(String title) {
        Helper.checkState(getSideMenuModel());
        getSideMenuModel().setTitle(title);
    }

    /**
     * <p>
     * Convenience method to return the true if the expanded component will be floating.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @return True if the expanded panel should be floating,false otherwise
     */
    public boolean isFloating() {
        Helper.checkState(getSideMenuModel());
        return getSideMenuModel().isFloating();
    }

    /**
     * <p>
     * Convenience method to set the floating of the expanded component.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @param floating
     *            True if the expanded panel should be floating,false otherwise
     */
    public void setFloating(boolean floating) {
        Helper.checkState(getSideMenuModel());
        getSideMenuModel().setFloating(floating);

    }

    /**
     * <p>
     * Convenience method to return the absolute width of the expanded component.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @return A > 0 value for the absolute width or -1 for no width specified
     */
    public int getAbsoluteWidth() {
        Helper.checkState(getSideMenuModel());
        return getSideMenuModel().getAbsoluteWidth();
    }

    /**
     * <p>
     * Convenience method to set the absolute width of the expanded component.
     * </p>
     *
     * @throws IllegalStateException
     *             if sideMenuModel is removed(sideMenuModel is null)
     * @throws IllegalArgumentException
     *             if absolute value is 0 or < -1
     * @param width
     *            A > 0 value for the absolute width or -1 for no width specified
     */
    public void setAbsoluteWidth(int width) {
        Helper.checkState(getSideMenuModel());
        getSideMenuModel().setAbsoluteWidth(width);
    }

    /**
     * <p>
     * Processes property change events (in this case, we look for title).
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the event is null, or value type is invalid.
     * @param event
     *            A non-null event to use
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
        Helper.checkNull(newValue, "new value");
        try {
            if (propertyName == SIDE_MENU_MODEL || SideMenuModel.EXPANDED == propertyName
                    || SideMenuModel.FLOATING == propertyName
                    || SideMenuModel.ABSOLUTE_WIDTH == propertyName) {
                // field may be changed
                boolean expandedValue = sideMenuModel.isExpanded();
                boolean floatingValue = sideMenuModel.isFloating();
                int absoluteWidth = sideMenuModel.getAbsoluteWidth();
                if (SideMenuModel.EXPANDED == propertyName) {
                    expandedValue = (Boolean) newValue;
                } else if (SideMenuModel.FLOATING == propertyName) {
                    floatingValue = (Boolean) newValue;
                } else if (SideMenuModel.ABSOLUTE_WIDTH == propertyName) {
                    absoluteWidth = (Integer) newValue;
                }
                setExpandedWidth(absoluteWidth);
                updatePanel(expandedValue, floatingValue);
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid value type for property:" + propertyName
                    + ".", e);
        }
        // Silently Ignore all other types
    }

    /**
     * <p>
     * This method uses following rules to update UI.
     * </p>
     * <table>
     * <tr>
     * <td>expanded</td>
     * <td> floating</td>
     * <td> action</td>
     * </tr>
     * <tr>
     * <td>true</td>
     * <td> true</td>
     * <td> we have popup and collapsed panel.</td>
     * </tr>
     * <tr>
     * <td>true</td>
     * <td> false</td>
     * <td> we have only expanded panel.</td>
     * </tr>
     * <tr>
     * <td>false</td>
     * <td> true</td>
     * <td> we have popup and collapsed panel.</td>
     * </tr>
     * <tr>
     * <td>false</td>
     * <td> false</td>
     * <td> we have only collapsed panel.</td>
     * </tr>
     * </table>
     *
     * @param expandedValue
     *            the expanded flag
     * @param floatingValue
     *            the floating flag
     */
    private void updatePanel(boolean expandedValue, boolean floatingValue) {
        if (floatingValue) {
            floatSideMenu();
        } else {
            if (expandedValue) {
                expandSideMenu();
            } else {
                collapseSideMenu();
            }
        }
    }

    /**
     * <p>
     * This method attempts to set the width of the expandedComponent to the absoluteWidth.
     * </p>
     * <p>
     * This method does it's best effort by setting the size, preferred size, minimum size and
     * maximum size of the component to the absoluteWidth and the height of 'this'.
     * </p>
     * <p>
     * The developer should note that the layout manager of the expandedComponent is free to
     * completely ignore all the sizes - so this is a best effort attempt.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if absolute value is 0 or < -1
     * @param absoluteWidth
     *            A > 0 value for the absolute width or -1 for no width specified
     */
    private void setExpandedWidth(int absoluteWidth) {
        Helper.checkAbsoluteWidth(absoluteWidth);
        if (absoluteWidth == -1) {
            absoluteWidth = (int) expandedComponent.getPreferredSize().getWidth();
        }
        Dimension dim = new Dimension(absoluteWidth, this.getHeight());
        expandedComponent.setSize(dim);
        expandedComponent.setPreferredSize(dim);
        expandedComponent.setMinimumSize(dim);
        expandedComponent.setMaximumSize(dim);
    }

    /**
     * <p>
     * Expands the side menu panel to display the expandedComponent.
     * </p>
     */
    private void expandSideMenu() {
        // destroy popup
        destroyPopup();
        remove(collapsedComponent);
        add(expandedComponent, BorderLayout.CENTER);
        validate();
        expandedComponent.requestFocus();
    }

    /**
     * <p>
     * Simply destroy popup.
     * </p>
     */
    private void destroyPopup() {
        if (floatingPopup != null) {
            floatingPopup.hide();
            floatingPopup = null;
        }
    }

    /**
     * <p>
     * Collapses the side menu panel to display the collapsedComponent.
     * </p>
     */
    private void collapseSideMenu() {
        destroyPopup();
        remove(expandedComponent);
        add(collapsedComponent, BorderLayout.CENTER);
        validate();
        collapsedComponent.requestFocus();
    }

    /**
     * <p>
     * Expands the side menu panel by floating the expandedComponent over it.
     * </p>
     */
    private void floatSideMenu() {
        collapseSideMenu();
        // Create a PopupFactory
        PopupFactory popupFactory = PopupFactory.getSharedInstance();
        Point location = getLocationOnScreen();
        this.floatingPopup = popupFactory.getPopup(this, expandedComponent, location.x, location.y);
        this.floatingPopup.show();
        // get focus to expandedComponent
        expandedComponent.requestFocus();
    }
}
