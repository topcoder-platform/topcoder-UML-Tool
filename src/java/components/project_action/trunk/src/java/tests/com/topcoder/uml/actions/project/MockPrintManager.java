/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.swing.print.PrintManager;

/**
 * <p>
 * This is a mock extension of PrintManager.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockPrintManager extends PrintManager {
    /**
     * <p>
     * Represents a list of Component objects.
     * </p>
     */
    private final List<Component> components = new ArrayList<Component>();

    /**
     * <p>
     * Represents a list of Rectangle objects used as viewports.
     * </p>
     */
    private List<Rectangle> viewports = new ArrayList<Rectangle>();

    /**
     * <p>
     * Mock Stub implementation. Sets all the variable for testing.
     * </p>
     *
     * @param components
     *            a list of Component objects to print.
     * @throws IllegalArgumentException
     *             if the components size is greater than or equal to three. Used for simulating an Exception.
     */
    public void printComponents(List<Component> components) {
        if (components.size() >= 3) {
            throw new IllegalArgumentException();
        }
        this.components.addAll(components);
    }

    /**
     * <p>
     * Mock Stub implementation. Sets all the variable for testing.
     * </p>
     *
     * @param components
     *            a list of Component objects to print.
     * @param viewports
     *            a list of Rectangle objects used as viewports
     */
    public void printComponents(List<Component> components, List<Rectangle> viewports) {
        this.components.addAll(components);
        this.viewports.addAll(viewports);
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the components list.
     * </p>
     *
     * @return the components list.
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the viewports list.
     * </p>
     *
     * @return the viewports list.
     */
    public List<Rectangle> getviewports() {
        return viewports;
    }
}
