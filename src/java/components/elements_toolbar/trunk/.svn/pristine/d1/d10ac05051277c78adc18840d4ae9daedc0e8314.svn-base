/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The demo for the component.
 *
 * @author enefem21
 * @version 1.0
 */
public class Demo extends TestCase {

    /** Status label. */
    private JLabel label;

    /** The currently selected element. */
    private String selectedElement;

    /**
     * <p>
     * Creates a test suite of the tests contained in this class.
     * </p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * The Class DefaultListener is the default implementation of ElementSelectedListener.
     */
    class DefaultListener implements ElementSelectedListener {

        /** Represents the current received element name. */
        private String elementName = null;

        /**
         * A retrieval methods to get the member elementName.
         *
         * @return the element name
         */
        public String getElementName() {
            return elementName;
        }

        /**
         * Set the elementName that is selected.
         *
         * @param sectionPanel
         *            the section panel
         * @param button
         *            the button
         */
        public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
            this.elementName = button.getName();
            label.setText(elementName + " is selected");
            selectedElement = elementName;

        }
    }

    /**
     * Sets the unit test up.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        TestHelper.loadConfiguration("demo_configuration.xml");
    }

    /**
     * Tears the unit test down.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearNamespaces();

        label = null;
        selectedElement = null;

        super.tearDown();
    }

    /**
     * Test demo.
     *
     * @throws Exception
     *             the exception
     */
    public void testDemo() throws Exception {
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
        final SectionPanel nodesPanel = new SectionPanel(namespace);

        // Create an empty panel
        SectionPanel emptyPanel = new SectionPanel("", Color.LIGHT_GRAY, null, null, look);

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
        JPanel mainPanel = producer.getToolBarMainPanel();

        // prepare the frame
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        label = new JLabel("");

        final JLabel finalLabel = label;
        JButton unselectButton = new JButton("unselect");

        // try the unselect method
        unselectButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // When user gets the selectedElement, he can unselect the toggle button.
                nodesPanel.unselectButton(selectedElement);

                finalLabel.setText("unselected");
            }

        });

        southPanel.add(label);
        southPanel.add(unselectButton);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);

        // /////////////////////////////////////////////////////////////////////

        // Add new listener, which is interested in the "Up" button selection event.
        DefaultListener listener = new DefaultListener();
        nodesPanel.addElementSelectedListener("buttonName1", listener);

        // If the listener is interested in all buttons of nodesPanel, it will be registered as following
        nodesPanel.addListenerForAllButtons(listener);

        // Remove listener, which is interested in the "Up" button selection event.
        nodesPanel.removeElementSelectedListener("buttonName1", listener);

    }

    /**
     * The main method.
     *
     * @param args
     *            the args
     *
     * @throws Exception
     *             the exception
     */
    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        demo.setUp();
        demo.testDemo();
    }
}
