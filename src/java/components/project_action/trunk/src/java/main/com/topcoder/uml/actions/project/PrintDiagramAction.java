/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.swing.print.PrintManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * <code>PrintDiagramAction</code> prints the diagrams. The diagram should be received as a
 * <code>java.awt.Component</code>, not as a <code>Diagram</code>.
 * The diagram Component should be the graphical representation of the diagram.
 * It will be passed to the Print Manager component.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, and its thread-safety depends on the Print Manager
 * component.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class PrintDiagramAction implements TransientAction {

    /**
     * <p>
     *  Represents a list <code>java.awt.Component</code> objects to print in the execute method. Initialized when it is
     *  declared to an ArrayList&lt;Component&gt; object, and its reference is never changed afterwards. It could
     *  never be empty.
     * </p>
     */
    private final List<Component> components = new ArrayList<Component>();

    /**
     * <p>
     * Represents a list of <code>java.awt.Rectangle</code> objects used as viewports in the execute method.
     * Initialized when it is declared to an ArrayList&lt;Rectangle&gt; object, and its reference is never
     * changed afterwards. It could be empty if it is not used, if it is used, it must contain the same number
     * of elements as the components list.
     * </p>
     */
    private final List<Rectangle> viewports = new ArrayList<Rectangle>();

    /**
     * <p>
     * Represents the <code>PrintManager</code> object used to print the diagram in the execute method.
     * Initialized in the constructor and never changed afterwards. It must be non-null.
     * </p>
     */
    private final PrintManager printManager;

    /**
     * <p>
     * Creates an Instance with the component and the <code>printManager</code>.
     * </p>
     *
     * @param component
     *            the Component object to print.
     * @param printManager
     *            the PrintManager object.
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public PrintDiagramAction(Component component, PrintManager printManager) {
        // check if component is null
        Helper.checkObjectNotNull(component, "component in PrintDiagramAction#PrintDiagramAction");
        // check if printManager is null
        Helper.checkObjectNotNull(printManager, "printManager in PrintDiagramAction#PrintDiagramAction");

        this.components.add(component);
        this.printManager = printManager;
    }

    /**
     * <p>
     * Creates an Instance with the component, view port and the <code>printManager</code>.
     * </p>
     *
     * @param component
     *            the Component object to print.
     * @param viewport
     *            the viewport of the Component to print.
     * @param printManager
     *            the PrintManager object.
     * @throws IllegalArgumentException
     *             if any argument is null
     */
    public PrintDiagramAction(Component component, Rectangle viewport, PrintManager printManager) {
        // check if component is null
        Helper.checkObjectNotNull(component, "component in PrintDiagramAction#PrintDiagramAction");
        // check if printManager is null
        Helper.checkObjectNotNull(printManager, "printManager in PrintDiagramAction#PrintDiagramAction");
        // check if viewport is null
        Helper.checkObjectNotNull(viewport, "viewport in PrintDiagramAction#PrintDiagramAction");
        this.components.add(component);
        this.viewports.add(viewport);
        this.printManager = printManager;
    }

    /**
     * <p>
     * Creates an Instance with the list of <code>components</code> and the <code>printManager</code>.
     * </p>
     *
     * @param components
     *            a list of Component objects to print.
     * @param printManager
     *            the PrintManager object.
     * @throws IllegalArgumentException
     *             if the argument is null or it is empty or contains null element.
     */
    public PrintDiagramAction(List<Component> components, PrintManager printManager) {
        // check if the components list is null/empty or contains any null element
        Helper.checkObjectListNotNull(components, "components in PrintDiagramAction#PrintDiagramAction");
        // check if printManager is null
        Helper.checkObjectNotNull(printManager, "printManager in PrintDiagramAction#PrintDiagramAction");
        this.components.addAll(components);
        this.printManager = printManager;
    }

    /**
     * <p>
     * Creates an Instance with the list of components, list of view ports and the printManager.
     * </p>
     *
     * @param components
     *            a list of Component objects to print.
     * @param viewports
     *            a list of Rectangle objects used as viewports
     * @param printManager
     *            the PrintManager object.
     * @throws IllegalArgumentException
     *             if any argument is null, or any list is empty or contains null element, or the two lists
     *             don't have the same number of elements.
     */
    public PrintDiagramAction(List<Component> components, List<Rectangle> viewports, PrintManager printManager) {
        // check if the components list is null/empty or contains any null element
        Helper.checkObjectListNotNull(components, "components in PrintDiagramAction#PrintDiagramAction");
        // check if printManager is null
        Helper.checkObjectNotNull(printManager, "printManager in PrintDiagramAction#PrintDiagramAction");
        // check if the viewports list is null/empty or contains any null element
        Helper.checkObjectListNotNull(viewports, "viewports in PrintDiagramAction#PrintDiagramAction");
        if (components.size() != viewports.size()) {
            throw new IllegalArgumentException("Components and viewports should contain same number of elements");
        }
        this.components.addAll(components);
        this.viewports.addAll(viewports);
        this.printManager = printManager;
    }

    /**
     * <p>
     * Prints the diagram. The diagram should be received as a <code>java.awt.Component</code>, not as a
     * <code>Diagram</code>. The diagram <code>Component</code> should be the graphical representation of
     * the diagram. It will be passed to the Print Manager component.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception occurs during the execution, it is mainly used to wrap the all possible
     *             underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        try {
            // if the view ports is empty
            if (viewports.isEmpty()) {
                printManager.print(components);
            } else {
                printManager.print(components, viewports);
            }
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while printing the diagram", e);
        }
    }
}
