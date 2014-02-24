/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

/**
 * <p>
 * Manages all actions related to menu and tool bar.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ActionListenerManager {
    /**
     * <p>
     * Singleton instance.
     * </p>
     */
    private static ActionListenerManager instance = null;

    /**
     * <p>
     * Map maintains the action and name map.
     * </p>
     */
    private final Map<String, Action> actions = new HashMap<String, Action>();

    /**
     * <p>
     * Private constructor.
     * </p>
     */
    private ActionListenerManager() {
    }

    /**
     * <p>
     * Gets the singleton instance of action listener manager.
     * </p>
     * @return the action listener manager
     */
    public static ActionListenerManager getInstance() {
        if (instance == null) {
            instance = new ActionListenerManager();
        }
        return instance;
    }

    /**
     * <p>
     * Adds an action into the action name map.
     * </p>
     * @param name
     *            action name
     * @param action
     *            action to add
     */
    public void setAction(String name, Action action) {
        actions.put(name, action);
    }

    /**
     * <p>
     * Gets the action by given name.
     * </p>
     * @param name
     *            action name
     * @return the action with the given name
     */
    public Action getAction(String name) {
        return actions.get(name);
    }
}
