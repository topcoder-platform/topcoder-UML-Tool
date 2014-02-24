/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import java.awt.Component;
import java.awt.Label;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.swing.print.PrintManager;
import com.topcoder.uml.actions.project.PrintDiagramAction;
import com.topcoder.uml.actions.project.failuretests.mock.MockPrintManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * Failure test for <code>PrintDiagramAction</code> class.
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrintDiagramActionFailureTest extends TestCase {
    /**
     * The component used to construct PrintDiagramAction. 
     */
    private Component component;
    
    /**
     * The viewport used to construct PrintDiagramAction. 
     */
    private Rectangle viewport;
    
    /**
     * The printManager used to construct PrintManager. 
     */
    private PrintManager printManager;
    
    /**
     * Set up for each test.
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        component = new Label();
        viewport = new Rectangle();
        printManager = new MockPrintManager();
    }
    
    /**
     * Test ctor PrintDiagramAction(Component component, PrintManager
     * printManager), when component is null, IllegalArgumentException is expected.
     */
    public void testCtor1_ComponentIsNull() {
        try {
            new PrintDiagramAction((Component) null, printManager);
            fail("when component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor PrintDiagramAction(Component component, PrintManager
     * printManager), when printManager is null, IllegalArgumentException is expected.
     */
    public void testCtor1_PrintManagerIsNull() {
        try {
            new PrintDiagramAction(component, null);
            fail("when printManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager), when component is null, IllegalArgumentException is expected.
     */
    public void testCtor2_ComponentIsNull() {
        try {
            new PrintDiagramAction(null, viewport, printManager);
            fail("when component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager), when viewport is null, IllegalArgumentException is expected.
     */
    public void testCtor2_ViewportIsNull() {
        try {
            new PrintDiagramAction(component, null, printManager);
            fail("when viewport is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(Component component, Rectangle viewport,
     * PrintManager printManager), when printManager is null, IllegalArgumentException is expected.
     */
    public void testCtor2_PrintManagerIsNull() {
        try {
            new PrintDiagramAction(component, viewport, null);
            fail("when printManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction( List&lt;Component&gt; components,
     * PrintManager printManager), when components is null, IllegalArgumentException is expected.
     */
    public void testCtor3_ComponentsIsNull() {
        try {
            new PrintDiagramAction((List<Component>) null, printManager);
            fail("when components is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction( List&lt;Component&gt; components,
     * PrintManager printManager), when components is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_ComponentsIsEmpty() {
        try {
            new PrintDiagramAction(new ArrayList<Component>(), printManager);
            fail("when components is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction( List&lt;Component&gt; components,
     * PrintManager printManager), when components is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_ComponentsContainsNull() {
        List<Component> components = new ArrayList<Component>();
        components.add(null);
        try {
            new PrintDiagramAction(components, printManager);
            fail("when components contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    /**
     * Test ctor PrintDiagramAction( List&lt;Component&gt; components,
     * PrintManager printManager), when printManager is null, IllegalArgumentException is expected.
     */
    public void testCtor3_PrintManagerIsNull() {
        try {
            new PrintDiagramAction((List<Component>) null, printManager);
            fail("when printManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction( List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when components is null, IllegalArgumentException is expected.
     */
    public void testCtor4_ComponentsIsNull() {
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        try {
            new PrintDiagramAction((List<Component>) null, viewports, printManager);
            fail("when printManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when components contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_ComponentsContainsNull() {
        List<Component> components = new ArrayList<Component>();
        components.add(null);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        try {
            new PrintDiagramAction(components, viewports, printManager);
            fail("when components is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when components is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_ComponentsIsEmpty() {
        List<Component> components = new ArrayList<Component>();
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        try {
            new PrintDiagramAction(components, viewports, printManager);
            fail("when components is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when viewports is null, IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsIsNull() {
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        try {
            new PrintDiagramAction(components, null, printManager);
            fail("when viewports is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when viewports is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsIsEmpty() {
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        try {
            new PrintDiagramAction(components, viewports, printManager);
            fail("when viewports is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when viewports contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_ViewportsContainsNull() {
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.contains(null);
        try {
            new PrintDiagramAction(components, viewports, printManager);
            fail("when viewports contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test ctor PrintDiagramAction(List&lt;Component&gt; components,
     * List&lt;Rectangle&gt; viewports, PrintManager printManager),
     * when printManager is null, IllegalArgumentException is expected.
     */
    public void testCtor4_PrintManagerIsNull() {
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.contains(viewport);
        try {
            new PrintDiagramAction(components, viewports, printManager);
            fail("when printManager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor execute(),
     * when failed to execute, ActionExecutionException is expected.
     */
    public void testExecute_Failed1() {
        List<Component> components = new ArrayList<Component>();
        components.add(component);
        List<Rectangle> viewports = new ArrayList<Rectangle>();
        viewports.add(viewport);
        try {
            new PrintDiagramAction(components, viewports, printManager).execute();
            fail("when failed to execute, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
    
    /**
     * Test ctor execute(),
     * when failed to execute, ActionExecutionException is expected.
     */
    public void testExecute_Failed2() {
        try {
            new PrintDiagramAction(component, printManager).execute();
            fail("when failed to execute, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
}