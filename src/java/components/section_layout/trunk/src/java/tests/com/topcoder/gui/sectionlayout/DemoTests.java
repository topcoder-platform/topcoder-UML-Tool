/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configUIManager();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * Shows the functionality of this component.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testForDemo() throws Exception {
        // ------- 4.3.1 Create Section with existing component -------

        Component innerComponent = new JPanel();
        Section section = new Section(innerComponent); //default vertical
        // configure section
        section.setTitle("Tools");
        section.setSize(100, 150);

        // default false, if it is true, this section will expand to
        // take up the empty space in the container
        section.setExpandToFill(true);

        // set to horizontal orientation, default to vertical
        section.setVertical(false);

        section.addExpandContractListener(new SectionExpandContractListener() {
            public void contracted(Section section) {
                System.out.println(section.getTitle() + " contracted");
            }
            public void expanded(Section section) {
                System.out.println(section.getTitle() + " expanded");
            }
        });

        // ------- 4.3.2 How to dock the sections in the side menu -------

        // assume the side menu is a JPanel
        JPanel sideMenu = new JPanel();
        // Create Dock Container, the orientation is vertical by default
        DockContainer dockContainer = new SectionDockContainer(sideMenu);

        // create dock container with horizontal orientation
        dockContainer = new SectionDockContainer(sideMenu, false);

        // create Dock for section, the section is created in 4.3.1
        Dock dock = new DefaultDock(section);
        dockContainer.dock(dock);

        // set floatable of the dock to false,
        // the dock will not be floatable
        dock.setFloatable(false);

        // Disable the drag of the dock, the dock
        // can't be dragged again.
        dock.setDragEnabled(false);

        // adding Drag listeners to the dock and dock container
        DockListener dockListener = new DockListener() {
            public void docked(DockEvent event) {
                System.out.println(event.getDock() + " docked in " + event.getContainer()
                        + ". Index is " + event.getIndex() + ", Location is " + event.getLocation() + ".");
            }
            public void undocked(DockEvent event) {
                System.out.println(event.getDock() + " undocked in " + event.getContainer()
                        + ". Index is " + event.getIndex() + ", Location is " + event.getLocation() + ".");
            }
        };

        dock.addDockListener(dockListener);
        dockContainer.addDockListener(dockListener);

        // ------- 4.3.3 How to dock swing components other than Section -------

        // First you need to get a DockContainer can dock the dock type ¡°DockableWrapper¡±
        DockContainer container = new PowDockContainer(sideMenu);
        // The mouse pressed on any position on the ¡°anyComponent¡± will start drag.
        Component anyComponent = new JPanel();
        container.dock(new DefaultDock(new DockableWrapper(anyComponent)));
    }

    /**
     * <p>
     * Shows the GUI functionality of this component.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testForGUI() throws Exception {
        // create section
        JPanel sectionPanel = new JPanel();
        sectionPanel.setBackground(Color.yellow);
        Section section = new Section(sectionPanel);
        section.setTitle("testGUI");
        section.setSize(200, 200);

        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();

        // create dock container and dock the section
        DockContainer dockContainer = new SectionDockContainer(contentPane);
        Dock dock = new DefaultDock(section);
        dockContainer.dock(dock);
        dock.setFloatable(true);
        dock.setDragEnabled(true);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 400);

        // make the Frame visible for 10 second
        Thread.sleep(30000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * You can extends <code>SectionDockContainer</code> or <code>BasicDockContainer</code>
     * to implements your own <code>DockContainer</code>.
     * This <code>PowDockContainer</code> can dock every thing.
     * </p>
     *
     * @author dmks, TCSDEVELOPER
     * @version 1.0
     */
    public class PowDockContainer extends SectionDockContainer {
        /**
         * <p>
         * Constructs a PowDockContainer instance.
         * </p>
         *
         * @param container
         *        the outer container
         */
        public PowDockContainer(Container container) {
            super(container);
        }

        /**
         * <p>
         * Return whether this container can dock the dock.
         * </p>
         *
         * @param dock
         *        the dock to be checked
         * @return whether this container can dock the dock
         */
        public boolean canDock(Dock dock) {
            // dock every thing
            return true;
        }
    }
}
