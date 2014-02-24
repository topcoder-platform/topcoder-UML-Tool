/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.util.List;

import javax.swing.JPanel;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This interface provides a contract for a small property panel responsible for one or more properties.
 * </p>
 *
 * <p>
 * Usually the implementations will only be responsible for either one property or a few closely related
 * property.
 * </p>
 *
 * <p>
 * The implementations are expected to provide a GUI for the panel in the form of a <code>JPanel</code>
 * container. Additionally, implementations are responsible for detecting changes to the supported
 * properties and fire the events appropriately when a property is changed.
 * </p>
 *
 * <p>
 * Thread-safety: Implementations are not required to be thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public interface PropertyPanel {
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
    public void execute();

    /**
     * <p>
     * Determines whether this property panel should be visible when the modelElement is selected.
     * </p>
     *
     * @return true if this property panel should be visible and false otherwise
     *
     * @throws IllegalArgumentException if modelElement is null
     */
    public boolean isVisible();

    /**
     * <p>
     * Configures the panel display to the given <code>ModelElement</code>.
     * </p>
     *
     * @param modelElement the <code>ModelElement</code> to be configured with this <code>PropertyPanel</code>
     *
     * @throws IllegalArgumentException if modelElement is null
     */
    public void configurePanel(ModelElement modelElement);

    /**
     * <p>
     * Configures the panel display to the given list of <code>ModelElement</code>.
     * </p>
     *
     * @param modelElements the list of <code>ModelElement</code> to configure this <code>PropertyPanel</code>
     * with
     *
     * @throws IllegalArgumentException if modelElements is null, contains null element, or is empty
     */
    public void configurePanel(List<ModelElement> modelElements);

    /**
     * <p>
     * Retrieves the JPanel to be displayed by <code>PropertiesPanel</code> class.
     * </p>
     *
     * <p>
     * The panel should only be displayed if {@link PropertyPanel#isVisible()} returns true.
     * </p>
     *
     * @return the JPanel to be displayed by PropertiesPanel
     */
    public JPanel retrievePanel();

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     */
    public void refreshPanel();

    /**
     * <p>
     * Determines whether the given property is supported by the implementation.
     * </p>
     *
     * @param property the property in question
     * @return true if the given property is supported and false otherwise
     *
     * @throws IllegalArgumentException if property is null
     */
    public boolean isPropertySupported(PropertyKind property);

    /**
     * <p>
     * Retrieves an unmodifiable list of supported property/properties.
     * </p>
     *
     * @return a list of supported properties
     */
    public List<PropertyKind> getSupportedProperties();
}
