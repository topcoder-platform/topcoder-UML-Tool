/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;

import com.topcoder.gui.diagramviewer.TextInputBox;

import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.EditBoxListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * Stress test cases for EditBoxListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxListenerStressTests extends TestCase {
    /**
     * The number of operations in the stress tests.
     */
    private static final int TIMES = 10000;

    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The FreeTextNode instance for helping testing.
     * </p>
     */
    private FreeTextNode node;

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The SimpleSemanticModelElement instance for helping testing.
     * </p>
     */
    private SimpleSemanticModelElement ssme;

    /**
     * <p>
     * The TextElement instance for helping testing.
     * </p>
     */
    private TextElement textElement;

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * The TextInputBox instance for helping testing.
     * </p>
     */
    private TextInputBox textInputBox;

    /**
     * <p>
     * The TextInputEvent instance for helping testing.
     * </p>
     */
    private TextInputEvent textInputEvent;

    /**
     * <p>
     * The EditBoxListener instance for helping testing.
     * </p>
     */
    private EditBoxListener listener;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        StressTestHelper.loadXMLConfig(StressTestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        graphNode = new GraphNode();
        ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo(FREE_TEXT);
        graphNode.setSemanticModel(ssme);
        textElement = new TextElement();
        textElement.setText("oldText");
        graphNode.addContained(textElement);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        node = new FreeTextNode(graphNode, mapping);
        textInputBox = new TextInputBox();
        textInputEvent = new TextInputEvent(textInputBox, "textInputEvent");
        listener = new EditBoxListener(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        StressTestHelper.clearConfig();
        mapping = null;
        graphNode = null;
        textElement = null;
        ssme = null;
        node = null;
        textInputBox = null;
        textInputEvent = null;
        listener = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EditBoxListenerStressTests.class);
    }

    /**
     * <p>
     * Tests EditBoxListener#textEntered(TextInputEvent e) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EditBoxListener#textEntered(TextInputEvent e) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextEntered() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            listener.textEntered(textInputEvent);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "EditBoxListener#textEntered(TextInputEvent e) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Tests EditBoxListener#textCancelled(TextInputEvent e) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EditBoxListener#textCancelled(TextInputEvent e) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTextCancelled() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            listener.textCancelled(textInputEvent);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "EditBoxListener#textCancelled(TextInputEvent e) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }
}
