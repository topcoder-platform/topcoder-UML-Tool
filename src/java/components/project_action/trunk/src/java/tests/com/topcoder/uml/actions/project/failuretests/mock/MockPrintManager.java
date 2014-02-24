/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests.mock;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.List;

import com.topcoder.swing.print.PrintManager;

/**
 * <p>
 * Mock implementation for PrintManager used in failure test only.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class MockPrintManager extends PrintManager {
    /**
     * print components.
     */
    public void printComponents(List<Component> components, List<Rectangle> viewports) {
        throw new IllegalArgumentException(); 
    }
    
    /**
     * print components.
     */
    public void printComponents(List<Component> components) {
        throw new IllegalArgumentException();
    }
}