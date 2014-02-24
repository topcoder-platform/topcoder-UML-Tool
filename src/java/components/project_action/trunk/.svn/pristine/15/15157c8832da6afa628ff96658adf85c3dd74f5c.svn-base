/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Button;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for PrintDiagramAction class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintDiagramActionUnitTest extends TestCase {
    /**
     * <p>
     * List of components to be used.
     * </p>
     */
    private List<Component> components;

    /**
     * <p>
     * List of viewPorts to be used.
     * </p>
     */
    private List<Rectangle> viewPorts;

    /**
     * <p>
     * PrintManager to be used.
     * </p>
     */
    private MockPrintManager printManager;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        components = new ArrayList<Component>();
        viewPorts = new ArrayList<Rectangle>();
        printManager = new MockPrintManager();
        // load the initial settings
        components.add(new Button());
        components.add(new Button());
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
        viewPorts = null;
        printManager = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(PrintDiagramActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, PrintManager printManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PrintDiagramAction() throws Exception {
        assertNotNull("PrintDiagramAction creation failed", new PrintDiagramAction(components.get(0), printManager));
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Component component : null Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction() throws Exception {
        try {
            new PrintDiagramAction((Component) null, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "component in PrintDiagramAction#PrintDiagramAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Component component : Valid Value
     *         PrintManager printManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction01() throws Exception {
        try {
            new PrintDiagramAction(components.get(0), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message is wrong", e.getMessage(),
                "printManager in PrintDiagramAction#PrintDiagramAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PrintDiagramAction1() throws Exception {
        assertNotNull("PrintDiagramAction creation failed", new PrintDiagramAction(components.get(0), viewPorts
            .get(0), printManager));
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Component component : null Value
     *         Rectangle viewport : Valid Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction10() throws Exception {
        try {
            new PrintDiagramAction(null, viewPorts.get(0), printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Component component : Valid Value
     *         Rectangle viewport : null Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction11() throws Exception {
        try {
            new PrintDiagramAction(components.get(0), null, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         Component component : Valid Value
     *         Rectangle viewport : Valid Value
     *         PrintManager printManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction12() throws Exception {
        try {
            new PrintDiagramAction(components.get(0), viewPorts.get(0), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components, PrintManager printManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PrintDiagramAction2() throws Exception {
        assertNotNull("PrintDiagramAction creation failed", new PrintDiagramAction(components, printManager));
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : null Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction20() throws Exception {
        try {
            new PrintDiagramAction((List<Component>) null, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Contains null Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction2() throws Exception {
        try {
            components.add(null);
            new PrintDiagramAction(components, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : empty list Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction22() throws Exception {
        try {
            components.clear();
            new PrintDiagramAction(components, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Valid Value
     *         PrintManager printManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction23() throws Exception {
        try {
            new PrintDiagramAction(components, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components, List < Rectangle > viewports,
     * PrintManager printManager)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PrintDiagramAction3() throws Exception {
        assertNotNull("PrintDiagramAction creation failed", new PrintDiagramAction(components, viewPorts,
            printManager));
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : null Value
     *         List &lt; Rectangle &gt; viewports : Valid Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction31() throws Exception {
        try {
            new PrintDiagramAction(null, viewPorts, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Contains null Value
     *         List &lt; Rectangle &gt; viewports : Valid Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction32() throws Exception {
        try {
            components.add(null);
            new PrintDiagramAction(components, viewPorts, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Empty list Value
     *         List &lt; Rectangle &gt; viewports : Valid Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction33() throws Exception {
        try {
            components.clear();
            new PrintDiagramAction(components, viewPorts, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Count not same as viewports count.
     *         List &lt; Rectangle &gt; viewports : Valid Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction34() throws Exception {
        try {
            components.add(new Button());
            new PrintDiagramAction(components, viewPorts, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Valid Value
     *         List &lt; Rectangle &gt; viewports : null Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction35() throws Exception {
        try {
            new PrintDiagramAction(components, null, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Valid Value
     *         List &lt; Rectangle &gt; viewports : Contains null Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction36() throws Exception {
        try {
            viewPorts.add(null);
            new PrintDiagramAction(components, viewPorts, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Empty list Value
     *         List &lt; Rectangle &gt; viewports : Valid Value
     *         PrintManager printManager : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction37() throws Exception {
        try {
            viewPorts.clear();
            new PrintDiagramAction(components, viewPorts, printManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>PrintDiagramAction.PrintDiagramAction(List < Component > components,
     * List < Rectangle > viewports, PrintManager printManager)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *    Input
     *         List &lt; Component &gt; components : Valid Value
     *         List &lt; Rectangle &gt; viewports : Valid Value
     *         PrintManager printManager : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PrintDiagramAction38() throws Exception {
        try {
            new PrintDiagramAction(components, viewPorts, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of <code>PrintDiagramAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, PrintManager printManager)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        new PrintDiagramAction(components.get(0), printManager).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components.get(0), printManager.getComponents().get(0));
    }

    /**
     * <p>
     * Accuracy test of <code>PrintDiagramAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor
     * <code>PrintDiagramAction.PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute1() throws Exception {
        new PrintDiagramAction(components.get(0), viewPorts.get(0), printManager).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components.get(0), printManager.getComponents().get(0));
        assertEquals("execute failed", viewPorts.get(0), printManager.getviewports().get(0));
    }

    /**
     * <p>
     * Accuracy test of <code>PrintDiagramAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor <code>PrintDiagramAction.PrintDiagramAction(List<Component> components,
     * PrintManager printManager)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute2() throws Exception {
        new PrintDiagramAction(components, printManager).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components, printManager.getComponents());
    }

    /**
     * <p>
     * Accuracy test of <code>PrintDiagramAction.execute()</code> method.
     * </p>
     * <p>
     * For the constructor
     * <code>PrintDiagramAction.PrintDiagramAction(List<Component> components, List<Rectangle> viewports,
     * PrintManager printManager)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute3() throws Exception {
        new PrintDiagramAction(components, viewPorts, printManager).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", components, printManager.getComponents());
        assertEquals("execute failed", viewPorts, printManager.getviewports());
    }

    /**
     * <p>
     * Failure test of <code>PrintDiagramAction.execute()</code> method.
     * </p>
     * <p>
     * Expected ActionExecutionException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        try {
            components.add(new Button());
            new PrintDiagramAction(components, printManager).execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As Expected
        }
    }
}
