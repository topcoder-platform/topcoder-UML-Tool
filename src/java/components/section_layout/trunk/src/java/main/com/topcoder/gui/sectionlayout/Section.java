/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.DragInitListener;
import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;
import com.topcoder.gui.sectionlayout.model.SectionModel;

/**
 * <p>
 * The section control of this component.
 * A section is a swing component which can be expanded or contracted.
 * It implements <code>Dockable</code> interface so that it can be docked in the dock container.
 * To make its L&F pluggable as general swing component,
 * I defined the <code>SectionHeader</code> as a custom swing component, and used MVC pattern.
 * (Writing own data model and UIDelegate).
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is mutable and not thread-safe.
 * Note the listeners management methods are thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class Section extends JPanel implements Dockable, PropertyChangeListener {

    /**
     * <p>
     * The constant representing the dock type of Section.
     * </p>
     */
    public static final String DOCK_TYPE = "section";

    /**
     * <p>
     * Represents the model of this section.
     * It is initialized in constructor, and never changed later. Can't be null.
     * </p>
     */
    private final SectionModel model;

    /**
     * <p>
     * Represents the component of this section.
     * The component can be expanded and contracted.
     * It is initialized in constructor, and never changed later. Can't be null.
     * </p>
     */
    private final Component component;

    /**
     * <p>
     * Represents the header subcomponent of this section.
     * It is initialized in constructor, and never changed later. Can't be null.
     * </p>
     */
    private final SectionHeader header;

    /**
     * <p>
     * Represents the dragInitListener listener listen to the drag start event.
     * Can be null. Accessed in getter/setter.
     * </p>
     */
    private DragInitListener dragInitListener = null;

    /**
     * <p>
     * The expand/contract listeners to listen when this section is expanded or contracted.
     * Initialized to empty list, can be empty, can't be null, never changed. the element can't be null.
     * </p>
     */
    private final List<SectionExpandContractListener> listeners = new ArrayList<SectionExpandContractListener>();

    /**
     * <p>
     * Constructs a Section instance with the given component.
     * </p>
     *
     * @param component
     *        the component to be put into section
     * @throws IllegalArgumentException
     *         if the component is null or if the component is a window
     */
    public Section(Component component) {
        this(component, true);
    }

    /**
     * <p>
     * Constructs a Section instance with the given component and orientation.
     * </p>
     *
     * @param component
     *        the component to be put into section
     * @param vertical
     *        whether the orientation is vertical
     * @throws IllegalArgumentException
     *         if the component is null or if the component is a window
     */
    public Section(Component component, boolean vertical) {
        this(component, vertical, true);
    }

    /**
     * <p>
     * Constructs a Section instance with the given component, orientation and expanded property.
     * </p>
     *
     * @param component
     *        the component to be put into section
     * @param vertical
     *        whether the orientation is vertical
     * @param expanded
     *        whether the section is expanded
     * @throws IllegalArgumentException
     *         if the component is null or if the component is a window
     */
    public Section(Component component, boolean vertical, boolean expanded) {
        Helper.checkNull(component, "component");
        if (component instanceof Window) {
            throw new IllegalArgumentException("The argument [component] should not be a Window.");
        }

        // initialize component and model, then add them to this section
        this.component = component;
        model = new DefaultSectionModel();
        model.setVertical(vertical);
        model.setExpanded(expanded);
        this.setLayout(new BorderLayout());
        header = new SectionHeader(this, model);
        this.add(header, BorderLayout.NORTH);
        this.add(component, BorderLayout.CENTER);
        if (isExpanded()) {
            this.component.setVisible(true);
        } else {
            this.component.setVisible(false);
        }

        // monitor expanded property and set border
        this.addPropertyChangeListener("expanded", this);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // repaint
        invalidate();
        repaint();
    }

    /**
     * <p>
     * Getter of the floating property of this dockable component.
     * </p>
     *
     * @return True, the dockable component is floating now
     */
    public boolean isFloating() {
        return model.isFloating();
    }

    /**
     * <p>
     * Setter of the floating property of this dockable component.
     * </p>
     *
     * @param floating
     *        True, the dockable component is floating now
     */
    public void setFloating(boolean floating) {
        boolean oldFloating = isFloating();
        if (oldFloating != floating) {
            model.setFloating(floating);
            this.firePropertyChange("floating", oldFloating, floating);
        }
    }

    /**
     * <p>
     * Getter of the expanded property of this section model.
     * </p>
     *
     * @return whether the section is expanded
     */
    public boolean isExpanded() {
        return model.isExpanded();
    }

    /**
     * <p>
     * Setter of the expanded property of this section model.
     * </p>
     *
     * @param expanded
     *        whether the section is expanded
     */
    public void setExpanded(boolean expanded) {
        boolean oldExpanded = isExpanded();
        if (oldExpanded != expanded) {
            model.setExpanded(expanded);
            this.firePropertyChange("expanded", oldExpanded, expanded);
        }
    }

    /**
     * <p>
     * Getter of the title property of this section model.
     * </p>
     *
     * @return section title
     */
    public String getTitle() {
        return model.getTitle();
    }

    /**
     * <p>
     * Setter of the title property of this section model.
     * </p>
     *
     * @param title
     *        section title
     * @throws IllegalArgumentException
     *         if the title is null
     */
    public void setTitle(String title) {
        String oldTitle = getTitle();
        if (!oldTitle.equals(title)) {
            model.setTitle(title);
            this.firePropertyChange("title", oldTitle, title);
        }
    }

    /**
     * <p>
     * Getter of the vertical property of this section model.
     * </p>
     *
     * @return whether the section is vertical
     */
    public boolean isVertical() {
        return model.isVertical();
    }

    /**
     * <p>
     * Setter of the vertical property of this section model.
     * </p>
     *
     * @param vertical
     *        whether the section is vertical
     */
    public void setVertical(boolean vertical) {
        boolean oldVertical = isVertical();
        if (oldVertical != vertical) {
            model.setVertical(vertical);
            this.firePropertyChange("vertical", oldVertical, vertical);
        }
    }

    /**
     * <p>
     * Getter of the expandToFill property of this section model.
     * </p>
     *
     * @return Whether this section expands to fill the remaining empty space in the container
     */
    public boolean isExpandToFill() {
        return model.isExpandToFill();
    }

    /**
     * <p>
     * Setter of the expandToFill property of this section model.
     * </p>
     *
     * @param expandToFill
     *        Whether this section expands to fill the remaining empty space in the container
     */
    public void setExpandToFill(boolean expandToFill) {
        boolean oldExpandToFill = isExpandToFill();
        if (oldExpandToFill != expandToFill) {
            model.setExpandToFill(expandToFill);
            this.firePropertyChange("expandToFill", oldExpandToFill, expandToFill);
        }
    }

    /**
     * <p>
     * Set the default size of the section.
     * </p>
     *
     * @param width
     *        the width of section
     * @param height
     *        the height of section
     * @throws IllegalArgumentException
     *         if any argument is not positive
     */
    public void setSize(int width, int height) {
        Helper.checkNotPositive(width, "width");
        Helper.checkNotPositive(height, "height");
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * <p>
     * Override the getMaximumSize of the JPanel to support "expandToFill" property in section.
     * </p>
     *
     * @return the value of the maximumSize property
     */
    public Dimension getMaximumSize() {
        if (this.isExpandToFill() && this.isExpanded()) {
            // return the size fill all the screen,
            // so that this section can fill the all the empty size of dock container.
            return Toolkit.getDefaultToolkit().getScreenSize();
        }
        // this section is not expandToFill
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (this.isVertical()) {
            // set the width to the screen width,
            // so that the width of section can fill the section container's width
            return new Dimension(screenSize.width, this.getPreferredSize().height);
        } else {
            // set the height to the screen height,
            // so that the width of section can fill the section container's height
            return new Dimension(this.getPreferredSize().width, screenSize.height);
        }
    }

    /**
     * <p>
     * Override the getMinimumSize of the JPanel.
     * </p>
     *
     * @return the value of the minimumSize property
     */
    public Dimension getMinimumSize() {
        return this.getPreferredSize();
    }

    /**
     * <p>
     * Return the dock type of section.
     * </p>
     *
     * @return the dock type of section
     */
    public String getDockType() {
        return DOCK_TYPE;
    }

    /**
     * <p>
     * Return the dockable component of this section.
     * </p>
     *
     * @return the dockable component of this section
     */
    public Component getDockableComponent() {
        return this;
    }

    /**
     * <p>
     * Sets the DragInitListener listeners to the section.
     * </p>
     *
     * @param listener
     *        the listener to monitor the drag start event, can be null
     */
    public void setDragInitListener(DragInitListener listener) {
        dragInitListener = listener;
    }

    /**
     * <p>
     * Gets the DragInitListener listener in the section.
     * Default to null.
     * </p>
     *
     * @return the listener to monitor the drag start event
     */
    public DragInitListener getDragInitListener() {
        return dragInitListener;
    }

    /**
     * <p>
     * Add listener to monitor whether this section is expanded or contracted.
     * </p>
     *
     * @param listener
     *        listener to monitor whether this section is expanded or contracted
     * @throws IllegalArgumentException
     *         if the listener is null
     */
    public synchronized void addExpandContractListener(SectionExpandContractListener listener) {
        Helper.checkNull(listener, "listener");
        listeners.add(listener);
    }

    /**
     * <p>
     * Remove listener to monitor whether this section is expanded or contracted.
     * </p>
     *
     * @param listener
     *        listener to monitor whether this section is expanded or contracted
     * @throws IllegalArgumentException
     *         if the listener is null
     */
    public synchronized void removeExpandContractListener(SectionExpandContractListener listener) {
        Helper.checkNull(listener, "listener");
        listeners.remove(listener);
    }

    /**
     * <p>
     * Return all the ExpandContract Listeners in this section.
     * </p>
     *
     * @return all the ExpandContract Listeners in this section
     */
    public synchronized List<SectionExpandContractListener> getExpandContractListeners() {
        return new ArrayList<SectionExpandContractListener>(listeners);
    }

    /**
     * <p>
     * This section also implements ProepertyChangeListener interface to monitor itself on the property "expanded".
     * So this method is invoked when "expanded" property is changed.
     * </p>
     *
     * @param event
     *        the property change event
     */
    public void propertyChange(PropertyChangeEvent event) {
        if (this.isExpanded()) {
            component.setVisible(true);
            this.fireExpanded();
        } else {
            component.setVisible(false);
            this.fireContracted();
        }
        invalidate();
        repaint();
    }

    /**
     * <p>
     * Fire the expanded event in section.
     * </p>
     */
    protected synchronized void fireExpanded() {
        for (SectionExpandContractListener listener : listeners) {
            listener.expanded(this);
        }
    }

    /**
     * <p>
     * Fire the contracted event in section.
     * </p>
     */
    protected synchronized void fireContracted() {
        for (SectionExpandContractListener listener : listeners) {
            listener.contracted(this);
        }
    }
}
