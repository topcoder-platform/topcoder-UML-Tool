/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.List;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;

/**
 * <p>
 * This class extends AbstractPropertyPanel class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockAbstractPropertyPanel extends AbstractPropertyPanel {
    /**
     * <p>
     * Represents the method is executed or not.
     * </P>
     */
    private boolean isExecuted = false;

    /**
     * <p>
     * Creates a new MockAbstractPropertyPanel.
     * </p>
     *
     * @param properties the list of properties supported
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     *
     * @throws IllegalArgumentException if either argument is null or properties is empty or contain null member
     */
    public MockAbstractPropertyPanel(List<PropertyKind> properties, PropertiesPanel propertiesPanel) {
        super(properties, propertiesPanel);
    }

    /**
     * <p>
     * Implements the execute() method.
     * </p>
     */
    public void execute() {
        // empty

    }

    /**
     * <p>
     * Implements the refreshPanel() method.
     * </p>
     */
    public void refreshPanel() {
        isExecuted = true;

    }

    /**
     * <p>
     * Returns the state of isExecuted for testing.
     * </p>
     *
     * @return the state of isExecuted for testing
     */
    public boolean getIsExecuted() {
        return isExecuted;
    }
}
