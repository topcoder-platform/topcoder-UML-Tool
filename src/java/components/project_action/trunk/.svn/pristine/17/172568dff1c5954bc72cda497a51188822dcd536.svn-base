/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Button;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.actionmanager.Action;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for ExportDiagramToImageAction class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExportDiagramToImageActionUnitTest extends TestCase {

    /**
     * <p>
     * List of components to be used.
     * </p>
     */
    private List<JComponent> components;

    /**
     * <p>
     * List of fileNames to be used.
     * </p>
     */
    private List<String> fileNames;

    /**
     * <p>
     * List of viewPorts to be used.
     * </p>
     */
    private List<Rectangle> viewPorts;

    /**
     * <p>
     * ImageExporter to be used.
     * </p>
     */
    private MockImageExporter imageExporter;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        components = new ArrayList<JComponent>();
        fileNames = new ArrayList<String>();
        viewPorts = new ArrayList<Rectangle>();
        imageExporter = new MockImageExporter();
        // load the initial settings
        components.add(new JButton());
        components.add(new JButton());
        fileNames.add("file1");
        fileNames.add("file2");
        viewPorts.add(new Rectangle());
        viewPorts.add(new Rectangle());
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        components = null;
        fileNames = null;
        viewPorts = null;
        imageExporter = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ExportDiagramToImageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ExportDiagramToImageAction1() throws Exception {
        ExportDiagramToImageAction projectAction = new ExportDiagramToImageAction(components.get(0), "loc", "file1",
            "format", imageExporter);
        // check for instantiation
        assertNotNull("ExportDiagramToImageAction creation failed", projectAction);
        // check for inheritance
        assertTrue("ExportDiagramToImageAction creation failed", projectAction instanceof Action);
    }

    /**
     * <p>
     * Accuracy test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ExportDiagramToImageAction2() throws Exception {
        ExportDiagramToImageAction projectAction = new ExportDiagramToImageAction(components.get(0),
            viewPorts.get(0), "loc", "file1", "format", imageExporter);
        // check for instantiation
        assertNotNull("ExportDiagramToImageAction creation failed", projectAction);
        // check for inheritance
        assertTrue("ExportDiagramToImageAction creation failed", projectAction instanceof Action);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ExportDiagramToImageAction3() throws Exception {
        ExportDiagramToImageAction projectAction = new ExportDiagramToImageAction(components, "loc", fileNames,
            "format", imageExporter);
        // check for instantiation
        assertNotNull("ExportDiagramToImageAction creation failed", projectAction);
        // check for inheritance
        assertTrue("ExportDiagramToImageAction creation failed", projectAction instanceof Action);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ExportDiagramToImageAction4() throws Exception {
        ExportDiagramToImageAction projectAction = new ExportDiagramToImageAction(components, viewPorts, "loc",
            fileNames, "format", imageExporter);
        // check for instantiation
        assertNotNull("ExportDiagramToImageAction creation failed", projectAction);
        // check for inheritance
        assertTrue("ExportDiagramToImageAction creation failed", projectAction instanceof Action);
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : null Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction1() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), null, "file1", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Empty Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction10() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "", "file1", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Empty Value with spaces
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction11() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "  ", "file1", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : null Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction2() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", null, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : Empty Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction20() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", "", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : Empty spaces Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction21() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", "  ", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : null Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction3() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", "file1", null, imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Empty Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction30() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", "file1", "", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Empty Spaces Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction31() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", "file1", "  ", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction4() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), "loc", "file1", "format", null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : null Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction5() throws Exception {
        try {
            new ExportDiagramToImageAction(null, viewPorts.get(0), "loc", "file1", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : null Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction51() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), null, "loc", "file1", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : null Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction52() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), null, "file1", "format",
                imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Empty Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction53() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "", "file1", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Empty spaces Value
     *     String fileName : Valid Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction54() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "  ", "file1", "format",
                imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : null Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction55() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", null, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Empty Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction56() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", "", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Empty spaces Value
     *     String format : Valid Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction57() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", "  ", "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : null Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction58() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", "file1", null, imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Empty Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction59() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", "file1", "", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : Empty spaces Value
     *     ImageExporter imageExporter : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction501() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", "file1", "  ", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     Component component : Valid Value
     *     Rectangle viewport : Valid Value
     *     String location : Valid Value
     *     String fileName : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction502() throws Exception {
        try {
            new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", "file1", "format", null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Null Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction600() throws Exception {
        try {
            new ExportDiagramToImageAction(null, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Contains Null Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction601() throws Exception {
        try {
            components.add(null);
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Empty list Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction6010() throws Exception {
        try {
            components.clear();
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : null Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction602() throws Exception {
        try {
            new ExportDiagramToImageAction(components, null, fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Empty Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction603() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Empty spaces Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction604() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "  ", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : null Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction605() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "loc", null, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Contains null Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction606() throws Exception {
        try {
            fileNames.add(null);
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Empty list Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction6060() throws Exception {
        try {
            fileNames.clear();
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value(Count not equal to the other list)
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction6061() throws Exception {
        try {
            fileNames.add("file3");
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Contains a empty Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction607() throws Exception {
        try {
            fileNames.add("");
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Conatins a empty spaces Value
     *     String format : valid Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction608() throws Exception {
        try {
            fileNames.add("   ");
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : null Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction609() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "loc", fileNames, null, imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : Empty Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction610() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "loc", fileNames, "", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : Empty spaces Value
     *     ImageExporter imageExporter : valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction611() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "loc", fileNames, "  ", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value
     *     String format : valid Value
     *     ImageExporter imageExporter : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ExportDiagramToImageAction612() throws Exception {
        try {
            new ExportDiagramToImageAction(components, "loc", fileNames, "format", null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }
}
