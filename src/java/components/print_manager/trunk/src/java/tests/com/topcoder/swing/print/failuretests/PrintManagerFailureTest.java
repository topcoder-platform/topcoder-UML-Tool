/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import java.awt.Button;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.swing.print.ConfigurationException;
import com.topcoder.swing.print.PrintFormatRetrieveException;
import com.topcoder.swing.print.PrintManager;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Failure test for <code>PrintManager</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PrintManagerFailureTest extends TestCase {
    /**
     * <p>
     * The PrintManager instance created for failure testing.
     * </p>
     */
    private PrintManager manager = new PrintManager();

    /**
     * <p>
     * The Component instance created for failure testing.
     * </p>
     */
    private Component component = new Button();

    /**
     * <p>
     * The Component instance created for failure testing.
     * </p>
     */
    private Rectangle rectangle = new Rectangle();

    /**
     * <p>
     * Set up the environment. It loads the namespaces.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("config.xml");
    }

    /**
     * <p>
     * Clear the environment. It unloads the namespaces.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator it = cm.getAllNamespaces(); it.hasNext();) {
            cm.removeNamespace(it.next().toString());
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * namespace is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintManagerNullNamespace() {
        try {
            new PrintManager(null);
            fail("namespace is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (ConfigurationException e) {
            fail("namespace is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * namespace is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintManagerEmptyNamespace() {
        try {
            new PrintManager(" ");
            fail("namespace is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (ConfigurationException e) {
            fail("namespace is empty, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * namespace is valid, No Exception is expected.
     * </p>
     */
    public void testPrintManager() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager");
        } catch (ConfigurationException e) {
            fail("namespace is valid, No Exception is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * objectFactoryNamespace is missing, ConfigurationException is expected.
     * </p>
     */
    public void testPrintManagerMissingObjectFactoryNamespace() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.missing.objectFactoryNamespace");
            fail("objectFactoryNamespace is missing, ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // expected.
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * objectFactoryNamespace is invalid, ConfigurationException is expected.
     * </p>
     */
    public void testPrintManagerWrongObjectFactoryNamespace1() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.wrongObjectfactory1");
            fail("objectFactoryNamespace is invalid, ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * objectFactoryNamespace is invalid, ConfigurationException is expected.
     * </p>
     */
    public void testPrintManagerWrongObjectFactoryNamespace2() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.wrongObjectfactory2");
            fail("objectFactoryNamespace is invalid, ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * componentVisibleMaker is missing, ConfigurationException is expected.
     * </p>
     */
    public void testPrintManagerMissingComponentVisibleMaker() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.missing.componentVisibleMaker");
            fail("componentVisibleMaker is missing, ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * printFormatRetriever is missing, ConfigurationException is expected.
     * </p>
     */
    public void testPrintManagerMissingPrintFormatRetriever() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.missing.printFormatRetriever");
            fail("printFormatRetriever is missing, ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * hasPrintDialog is "trUe", No Exception is expected.
     * </p>
     */
    public void testPrintManagerTrue() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.true");
        } catch (ConfigurationException e) {
            fail("hasPrintDialog is \"trUe\", No Exception is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * hasPrintDialog is "faLse", No Exception is expected.
     * </p>
     */
    public void testPrintManagerFalse() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.false");
        } catch (ConfigurationException e) {
            fail("hasPrintDialog is \"faLse\", No Exception is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * hasPrintDialog is missing, No Exception is expected.
     * </p>
     */
    public void testPrintManagerMissingComponentMissingHasPrintDialog() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.missingBoolean");
        } catch (ConfigurationException e) {
            fail("hasPrintDialog is missing, No Exception is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * hasPrintDialog is empty, No Exception is expected.
     * </p>
     */
    public void testPrintManagerMissingComponentEmptyHasPrintDialog() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.emptyBoolean");
        } catch (ConfigurationException e) {
            fail("hasPrintDialog is empty, No Exception is expected.");
        }
    }
    /**
     * <p>
     * Failure test for <code>PrintManager(String namespace)</code>.
     * </p>
     * <p>
     * hasPrintDialog is invalid, ConfigurationException is expected.
     * </p>
     */
    public void testPrintManagerMissingComponentWrongHasPrintDialog() {
        try {
            new PrintManager("com.topcoder.swing.print.PrintManager.wrongBoolean");
            fail("hasPrintDialog is invalid, ConfigurationException is expected.");
        } catch (ConfigurationException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>print(Component component)</code>.
     * </p>
     * <p>
     * user do not specify print format first, IllegalStateException is
     * expected.
     * </p>
     */
    public void testPrintComponent1() {
        try {
            manager.print(component);
            fail("user do not specify print format first, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>print(Component component)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintComponent2() {
        try {
            manager.specifyPrintFormat();
            manager.print((Component) null);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("component is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(Component component, Rectangle rectangle)</code>.
     * </p>
     * <p>
     * user do not specify print format first, IllegalStateException is
     * expected.
     * </p>
     */
    public void testPrintComponentRectangle1() {
        try {
            manager.print(component, rectangle);
            fail("user do not specify print format first, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(Component component, Rectangle rectangle)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintComponentRectangleNullComponent() {
        try {
            manager.specifyPrintFormat();
            manager.print((Component) null, rectangle);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("component is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(Component component, Rectangle rectangle)</code>.
     * </p>
     * <p>
     * rectangle is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintComponentRectangleNullRectangle2() {
        try {
            manager.specifyPrintFormat();
            manager.print(component, null);
            fail("rectangle is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("rectangle is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>print(List<Component> components)</code>.
     * </p>
     * <p>
     * components is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentNullList() {
        try {
            manager.specifyPrintFormat();
            manager.print((List<Component>) null);
            fail("components is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("components is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>print(List<Component> components)</code>.
     * </p>
     * <p>
     * components contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentContainsNull() {
        try {
            manager.specifyPrintFormat();
            List<Component> list = new ArrayList<Component>();
            list.add(component);
            list.add(null);
            manager.print(list);
            fail("components contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("components contains null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for <code>print(List<Component> components)</code>.
     * </p>
     * <p>
     * user do not specify print format first, IllegalStateException is
     * expected.
     * </p>
     */
    public void testPrintListOfComponent() {
        try {
            List<Component> list = new ArrayList<Component>();
            list.add(component);
            manager.print(list);
            fail("user do not specify print format first, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * user do not specify print format first, IllegalStateException is
     * expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangle() {
        try {
            List<Component> components = new ArrayList<Component>();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            components.add(component);
            rectangles.add(rectangle);
            manager.print(components, rectangles);
            fail("user do not specify print format first, IllegalStateException is expected.");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * The list are null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangleEmptyList() {
        try {
            manager.specifyPrintFormat();
            List<Component> components = new ArrayList<Component>();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            manager.print(components, rectangles);
            fail("the lists are null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("the lists are null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * components is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangleNullComponents() {
        try {
            manager.specifyPrintFormat();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            rectangles.add(rectangle);
            manager.print(null, rectangles);
            fail("components is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("components is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * rectangles is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangleNullRectangles() {
        try {
            manager.specifyPrintFormat();
            List<Component> components = new ArrayList<Component>();
            components.add(component);
            manager.print(components, null);
            fail("rectangles is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("rectangles is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * components contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangleComponentsContainsNull() {
        try {
            manager.specifyPrintFormat();
            List<Component> components = new ArrayList<Component>();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            components.add(null);
            rectangles.add(rectangle);
            manager.print(components, rectangles);
            fail("components contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("components contains null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * rectangles contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangleRectanglesContainsNull() {
        try {
            manager.specifyPrintFormat();
            List<Component> components = new ArrayList<Component>();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            components.add(component);
            rectangles.add(null);
            manager.print(components, rectangles);
            fail("rectangles contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("rectangles contains null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>print(List<Component> components, List<Rectangle> rectangles)</code>.
     * </p>
     * <p>
     * Given component or rectangle list is not of the same length,
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testPrintListOfComponentListOfRectangleNotEqualsLength() {
        try {
            manager.specifyPrintFormat();
            List<Component> components = new ArrayList<Component>();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            components.add(component);
            rectangles.add(rectangle);
            rectangles.add(rectangle);
            manager.print(components, rectangles);
            fail("given component or rectangle list is not of the same length, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (PrintFormatRetrieveException e) {
            fail("given component or rectangle list is not of the same length, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>setComponentVisibleMaker(ComponentVisibleMaker componentVisibleMaker)</code>.
     * </p>
     * <p>
     * componentVisibleMaker is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetComponentVisibleMaker() {
        try {
            manager.setComponentVisibleMaker(null);
            fail("componentVisibleMaker is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>setPrintFormatRetriever(PrintFormatRetriever printFormatRetriever)</code>.
     * </p>
     * <p>
     * printFormatRetriever is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetPrintFormatRetriever() {
        try {
            manager.setPrintFormatRetriever(null);
            fail("printFormatRetriever is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
