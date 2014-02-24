/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import com.topcoder.swing.print.PrintManager;
import com.topcoder.uml.actions.project.PrintDiagramAction;

/**
 * <p>
 * Accuracy test for <code>{@link PrintDiagramAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class PrintDiagramActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>{@link PrintManager}</code> instance used in tests.
     * </p>
     */
    private static final PrintManager PRINT_MANAGER = new PrintManager();

    /**
     * <p>
     * Represents the size to create the list.
     * </p>
     */
    private static final int SIZE = 10;

    /**
     * <p>
     * Represents the <code>{@link PrintDiagramAction}</code> instance used in tests.
     * </p>
     */
    private PrintDiagramAction printDiagramAction;

    /**
     * <p>
     * Accuracy test for <code>{@link PrintDiagramAction#PrintDiagramAction(Component, PrintManager)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        Component component = new JList();
        printDiagramAction = new PrintDiagramAction(component, PRINT_MANAGER);
        // verify
        assertEquals("printManager field not set correctly.", PRINT_MANAGER, AccuracyTestHelper.getFieldValue(
            printDiagramAction, "printManager"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "viewports"), new ArrayList());
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "components"), components);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PrintDiagramAction#PrintDiagramAction(Component, Rectangle, PrintManager)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        Component component = new JList();
        Rectangle viewport = new Rectangle();
        printDiagramAction = new PrintDiagramAction(component, viewport, PRINT_MANAGER);
        // verify
        assertEquals("printManager field not set correctly.", PRINT_MANAGER, AccuracyTestHelper.getFieldValue(
            printDiagramAction, "printManager"));
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "viewports"), viewports);
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "components"), components);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PrintDiagramAction#PrintDiagramAction(List, PrintManager)}</code> constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_3_Accuracy() throws Exception {
        List<Component> components = new ArrayList<Component>();
        for (int i = 0; i < SIZE; i++) {
            components.add(new JList());
        }
        printDiagramAction = new PrintDiagramAction(components, PRINT_MANAGER);
        // verify
        assertEquals("printManager field not set correctly.", PRINT_MANAGER, AccuracyTestHelper.getFieldValue(
            printDiagramAction, "printManager"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "viewports"), new ArrayList());
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "components"), components);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PrintDiagramAction#PrintDiagramAction(List, List, PrintManager)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_4_Accuracy() throws Exception {
        List<Component> components = new ArrayList<Component>();
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        for (int i = 0; i < SIZE; i++) {
            components.add(new JList());
            viewports.add(new Rectangle());
        }
        printDiagramAction = new PrintDiagramAction(components, viewports, PRINT_MANAGER);
        // verify
        assertEquals("printManager field not set correctly.", PRINT_MANAGER, AccuracyTestHelper.getFieldValue(
            printDiagramAction, "printManager"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "viewports"), viewports);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(printDiagramAction, "components"), components);
    }
}
