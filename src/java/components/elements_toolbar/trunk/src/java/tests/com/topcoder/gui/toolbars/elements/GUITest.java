/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.topcoder.gui.toolbars.elements.mock.MockElementSelectedListener;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The GUI test.
 *
 * @author enefem21
 * @version 1.0
 */
public class GUITest extends JFCTestCase {

    /** Panel under test. */
    private JPanel mainPanel;

    /** Frame wrapped the panel. */
    private JFrame frame;

    /** Listener used in the unit test. */
    private MockElementSelectedListener mockElementSelectedListener;

    /** One of the section panel. */
    private SectionPanel nodesPanel;

    /**
     * <p>
     * Creates a test suite of the tests contained in this class.
     * </p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(GUITest.class);
    }

    /**
     * Sets the unit test up.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        // Choose the text Helper
        setHelper(new JFCTestHelper());

        TestHelper.loadConfiguration("demo_configuration.xml");

        // To create elements toolbar, component user creates four instances of SectionPanel
        String look = "javax.swing.plaf.metal.MetalLookAndFeel";

        // Initialize buttonsName and icons;
        String[] buttonNames = new String[] {"buttonName1", "buttonName2", "buttonName3", "buttonName4"};
        ImageIcon[] icons =
            new ImageIcon[] {new ImageIcon("test_files/icon/loupe-black.gif"),
                new ImageIcon("test_files/icon/jumelles.gif"), new ImageIcon("test_files/icon/photo_loupe.gif"),
                new ImageIcon("test_files/icon/lunettesBlack.gif")};

        // Initialize elementPanel and connectorsPanel through regular constructors.
        SectionPanel elementsPanel = new SectionPanel("elements", Color.RED, buttonNames, icons, look);
        SectionPanel connectorsPanel = new SectionPanel("connectors", Color.LIGHT_GRAY, buttonNames, icons, look);

        // "nodesPanel" is created from configuration file.
        String namespace = "com.topcoder.gui.toolbars.elements.nodesPanel";
        nodesPanel = new SectionPanel(namespace);

        // Create an empty panel
        SectionPanel emptyPanel = new SectionPanel("", Color.LIGHT_GRAY, null, null, look);

        mockElementSelectedListener = new MockElementSelectedListener();

        // Create one instance of ToolBarMainPanelProducer and add these SectionPanel instances
        // into the main panel.
        Dimension preferredSize = new Dimension(300, 300);
        Dimension minimumSize = new Dimension(50, 50);
        ToolBarMainPanelProducer producer = new ToolBarMainPanelProducer(2, 2, look, preferredSize, minimumSize);
        producer.addNewSectionPanel(0, 0, 1, 1, elementsPanel);
        producer.addNewSectionPanel(0, 1, 1, 1, connectorsPanel);
        producer.addNewSectionPanel(1, 0, 1, 1, nodesPanel);
        producer.addNewSectionPanel(1, 1, 1, 1, emptyPanel);

        // Get the main panel from the instance of ToolBarMainPanelProducer.
        mainPanel = producer.getToolBarMainPanel();

        // prepare the frame
        frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    /**
     * Tears the unit test down.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        frame = null;

        super.tearDown();
    }

    /**
     * Test listener. Listener have to be notified.
     */
    public void testListener() {
        // add listener
        nodesPanel.addElementSelectedListener("buttonName1", mockElementSelectedListener);

        // find the button to be click
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "buttonName1");
        JToggleButton buttonName1a = (JToggleButton) finder.find(frame, 2);

        assertNotNull("Could not find the buttonName1", buttonName1a);

        // do the click
        getHelper().enterClickAndLeave(new MouseEventData(this, buttonName1a));

        assertTrue("Listener is not executed", mockElementSelectedListener.isExecuted());

        // unselect the button
        nodesPanel.unselectButton("buttonName1");

        assertFalse("buttonName1 should be unselected", buttonName1a.isSelected());

    }

    /**
     * Test listener. Listener have to be notified.
     */
    public void testListener1() {
        // add listener
        nodesPanel.addListenerForAllButtons(mockElementSelectedListener);

        // find the button to be click
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "buttonName1");
        JToggleButton buttonName1a = (JToggleButton) finder.find(frame, 2);

        assertNotNull("Could not find the buttonName1", buttonName1a);

        // do the click
        getHelper().enterClickAndLeave(new MouseEventData(this, buttonName1a));

        assertTrue("Listener is not executed", mockElementSelectedListener.isExecuted());

        assertEquals("Number of execution is not as expected", 1, mockElementSelectedListener
            .getNumberOfExecution());

        // find the button2 to be click
        finder.setName("buttonName2");
        JToggleButton buttonName2a = (JToggleButton) finder.find(frame, 2);

        assertNotNull("Could not find the buttonName2", buttonName2a);

        // do the click
        getHelper().enterClickAndLeave(new MouseEventData(this, buttonName2a));

        assertTrue("Listener is not executed", mockElementSelectedListener.isExecuted());

        assertEquals("Number of execution is not as expected", 2, mockElementSelectedListener
            .getNumberOfExecution());

    }

}
