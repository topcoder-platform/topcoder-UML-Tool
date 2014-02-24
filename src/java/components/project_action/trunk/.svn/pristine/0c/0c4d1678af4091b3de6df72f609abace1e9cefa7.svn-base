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

import com.topcoder.util.actionmanager.ActionExecutionException;

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
public class ExportDiagramToImageActionUnitTest1 extends TestCase {

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
        return new TestSuite(ExportDiagramToImageActionUnitTest1.class);
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : null Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction701() throws Exception {
        try {
            new ExportDiagramToImageAction(null, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : contains a null Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction702() throws Exception {
        try {
            components.add(null);
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Empty Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction703() throws Exception {
        try {
            components.clear();
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : null Value
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
    public void test_failure_ExportDiagramToImageAction704() throws Exception {
        try {
            new ExportDiagramToImageAction(components, null, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Contains null Value
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
    public void test_failure_ExportDiagramToImageAction705() throws Exception {
        try {
            viewPorts.add(null);
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Empty list Value
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
    public void test_failure_ExportDiagramToImageAction706() throws Exception {
        try {
            viewPorts.clear();
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value(count not equal to viewports)
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
    public void test_failure_ExportDiagramToImageAction707() throws Exception {
        try {
            viewPorts.add(new Rectangle());
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction708() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, null, fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction709() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction710() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "  ", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction711() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "loc", null, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction712() throws Exception {
        try {
            fileNames.add(null);
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction713() throws Exception {
        try {
            fileNames.clear();
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
     *     String location : Valid Value
     *     List&lt;String&gt; fileNames : Valid Value (Count not equal to the other two list)
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
    public void test_failure_ExportDiagramToImageAction714() throws Exception {
        try {
            fileNames.add("file3");
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction715() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, null, imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction716() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction717() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "  ", imageExporter);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *     Input
     *     List&lt;Component&gt; components : Valid Value
     *     List&lt;Rectangle&gt; viewports : Valid Value
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
    public void test_failure_ExportDiagramToImageAction718() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of <code>ExportDiagramToImageAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * String location, String fileName, String format,ImageExporter imageExporter)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        new ExportDiagramToImageAction(components.get(0), "loc", fileNames.get(0), "format", imageExporter).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components.get(0), imageExporter.getComponents().get(0));
        assertEquals("execute failed", "loc", imageExporter.getlocation());
        assertEquals("execute failed", fileNames.get(0), imageExporter.getfileNames().get(0));
        assertEquals("execute failed", "format", imageExporter.getformat());
    }

    /**
     * <p>
     * Accuracy test of <code>ExportDiagramToImageAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor <code>ExportDiagramToImageAction.ExportDiagramToImageAction(Component component,
     * Rectangle viewport, String location, String fileName, String format, ImageExporter imageExporter)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute1() throws Exception {
        new ExportDiagramToImageAction(components.get(0), viewPorts.get(0), "loc", fileNames.get(0), "format",
            imageExporter).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components.get(0), imageExporter.getComponents().get(0));
        assertEquals("execute failed", viewPorts.get(0), imageExporter.getviewports().get(0));
        assertEquals("execute failed", "loc", imageExporter.getlocation());
        assertEquals("execute failed", fileNames.get(0), imageExporter.getfileNames().get(0));
        assertEquals("execute failed", "format", imageExporter.getformat());
    }

    /**
     * <p>
     * Accuracy test of <code>ExportDiagramToImageAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor
     * <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * String location, List<String> fileNames, String format, ImageExporter imageExporter)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute2() throws Exception {
        new ExportDiagramToImageAction(components, "loc", fileNames, "format", imageExporter).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components, imageExporter.getComponents());
        assertEquals("execute failed", "loc", imageExporter.getlocation());
        assertEquals("execute failed", fileNames, imageExporter.getfileNames());
        assertEquals("execute failed", "format", imageExporter.getformat());
    }

    /**
     * <p>
     * Accuracy test of <code>ExportDiagramToImageAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor
     * <code>ExportDiagramToImageAction.ExportDiagramToImageAction(List<Component> components,
     * List<Rectangle> viewports, String location, List<String> fileNames, String format,
     * ImageExporter imageExporter)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute3() throws Exception {
        new ExportDiagramToImageAction(components, viewPorts, "loc", fileNames, "format", imageExporter).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components, imageExporter.getComponents());
        assertEquals("execute failed", viewPorts, imageExporter.getviewports());
        assertEquals("execute failed", "loc", imageExporter.getlocation());
        assertEquals("execute failed", fileNames, imageExporter.getfileNames());
        assertEquals("execute failed", "format", imageExporter.getformat());
    }

    /**
     * <p>
     * Failure test of <code>ExportDiagramToImageAction.execute()</code> method.
     * </p>
     * <p>
     * Custom simulated exception to test.
     * </p>
     * <p>
     * Expected ActionExecutionException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute4() throws Exception {
        try {
            new ExportDiagramToImageAction(components, viewPorts, "exception", fileNames, "format", imageExporter)
                .execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As Expected
        }
    }
}
