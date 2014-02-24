/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;


/**
 * <p>This class is used to set the component's visibility. It ensures the component is visible before printed,
 * and restores it's original visibility afterwards.<p>
 * <p>Thread-Safety: This class is thread safe because all methods are thread safe.</p>
 *
 * @author fabrizyo, TCSDEVELOPER
 * @version 1.0
 */
public class DefaultVisibleMaker implements JComponentVisibleMaker {
    /**
     * <p>Represents the map with the visibility state of components.</p>
     */
    private final Map<JComponent, Boolean> visibilityState;

    /**
     * <p>
     * Constructs a DefaultVisibleMaker.
     * </p>
     */
    public DefaultVisibleMaker() {
        this.visibilityState = new HashMap<JComponent, Boolean>();
    }

    /**
     * <p>Makes a JComponent visible if it isn't. This method is called before the the JComponent's export.</p>
     *
     * @param component the jComponent of which visibility will be set to visible
     *
     * @throws IllegalArgumentException if component is null
     */
    public synchronized void makeVisible(JComponent component) {
        ParameterCheck.checkNull("component", component);

        visibilityState.put(component, component.isVisible());
        component.setVisible(true);
    }

    /**
     * <p>Restores the JComponent's visible status to its original value before being printed. This method should
     * be invoked after export.</p>
     *
     * @param component the jComponent of which visibility will be restored
     *
     * @throws IllegalArgumentException if component is null or it's not made visible by makeVisible() previously
     */
    public synchronized void restoreVisibility(JComponent component) {
        ParameterCheck.checkNull("component", component);

        Boolean status = visibilityState.remove(component);

        if (status == null) {
            throw new IllegalArgumentException("component is not made visible by makeVisible() previously");
        }

        component.setVisible(status.booleanValue());
    }
}
