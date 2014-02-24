/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import java.util.List;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.propertypanel.links.AbstractLinkPropertyPanel;
import com.topcoder.uml.model.core.ModelElement;

/**
 * This mock class is used in the test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AbstractLinkPropertyPanelMock extends AbstractLinkPropertyPanel {
    /**
     * <p>
     * Creates a new AbstractLinkPropertyPanelMock.
     * </p>
     *
     * @param properties the supported PropertyKind
     * @param propertiesPanel the PropertiesPanel that owns this panel
     * @param labelText the property name to be displayed
     *
     * @throws IllegalArgumentException if any argument is null, or properties is empty or
     * contains null element, or labelText is empty string
     */
    public AbstractLinkPropertyPanelMock(List<PropertyKind> properties, PropertiesPanel propertiesPanel,
        String labelText) {
        super(properties, propertiesPanel, labelText);
    }

    /**
     * <p>
     * Refreshes the panel.
     * </p>
     */
    public void refreshPanel() {
        // empty

    }

    /**
     * <p>
     * Sets the ModelElement linked by this panel instance.
     * </p>
     *
     * @param linkedModelElement the ModelElement linked by this instance
     */
    public void setLinkedModelElement(ModelElement linkedModelElement) {
        super.setLinkedModelElement(linkedModelElement);
    }
}
