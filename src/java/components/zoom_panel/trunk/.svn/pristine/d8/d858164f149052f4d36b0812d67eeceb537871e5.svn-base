/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom.stresstests;

import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.gui.panels.zoom.transform.AffineZoomTransform;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * <p>
 * The GUI demo to test whether the component can work properly.
 * </p>
 *
 * @author lyt
 * @version 1.0
 */
public class StressDemo {
    /** The frame of demo. */
    private JFrame frame = null;

    /** A comboBox ZoomPanel for testing */
    private ZoomPanel comboBoxZoomPanel = null;

    /** A button ZoomPanel for testing */
    private ZoomPanel buttonZoomPanel = null;

    /** An image icon ZoomPanel for testing */
    private ZoomPanel picPanel;

    /** A lable used to show the status of mouse */
    private JLabel status = null;

    /** A button for zooming */
    private JButton button = null;

    /**
     * Creates a new StressDemo object.
     */
    public StressDemo() {
        JComboBox comboBox = new JComboBox(new String[] { "Algorithm", "Design", "Development" });
        comboBoxZoomPanel = new ZoomPanel(comboBox);

        button = new JButton("Happy new year");
        buttonZoomPanel = new ZoomPanel(button);

        JLabel label = new JLabel(new ImageIcon("test_files" + File.separatorChar + "stress" + File.separatorChar
                    + "ZoomPanel.JPG"));
        picPanel = new ZoomPanel(label, new AffineZoomTransform(AffineTransform.getRotateInstance(0.2)));

        status = new JLabel("Status: -_-");

        registerButtonListeners();
    }

    /**
     * Register the listeners to button.
     */
    private void registerButtonListeners() {
        button.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    status.setText("Status: The button gained focus.");
                }

                public void focusLost(FocusEvent e) {
                    status.setText("Status: The button lost focus.");
                }
            });
        button.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    status.setText("Status: Mouse clicked.");
                }

                public void mousePressed(MouseEvent e) {
                    status.setText("Status: Mouse pressed.");
                }

                public void mouseReleased(MouseEvent e) {
                    status.setText("Status: Mouse released.");
                }

                public void mouseEntered(MouseEvent e) {
                    status.setText("Status: Mouse entered.");
                }

                public void mouseExited(MouseEvent e) {
                    status.setText("Status: Mouse exited.");
                }
            });
    }

    /**
     * Create the container pane
     *
     * @return the container pane
     */
    private Container createPane() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        contentPane.add(createZoomPanes());
        contentPane.add(createToolBar());

        return contentPane;
    }

    /**
     * Create the zoom pane
     *
     * @return the zoom pane
     */
    private Component createZoomPanes() {
        JPanel zoomPane = new JPanel(new GridLayout(3, 1));

        zoomPane.add(buttonZoomPanel);
        zoomPane.add(picPanel);
        zoomPane.add(comboBoxZoomPanel);

        return zoomPane;
    }

    /**
     * Create the tool bar
     *
     * @return the tool bar
     */
    private Component createToolBar() {
        String[] values = new String[] { "100%", "200%", "400%", "800%", "1600%" };
        JPanel toolPanel = new JPanel(new GridLayout(1, 2));
        JComboBox comboBox = new JComboBox(values);
        comboBox.setSize(30, 10);
        comboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();

                    String factorStr = (String) cb.getSelectedItem();
                    double factor = Double.valueOf(factorStr.substring(0, factorStr.indexOf('%'))).doubleValue() / 100;

                    comboBoxZoomPanel.setZoomFactor(factor);
                    buttonZoomPanel.setZoomFactor(factor);
                    picPanel.setZoomFactor(factor);
                }
            });

        toolPanel.add(status);
        toolPanel.add(comboBox);

        return toolPanel;
    }

    /**
     * Create the GUI and show it.  For thread safety, this method should be invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ZoomPanel Demo test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StressDemo demo = new StressDemo();

        //Create and set up the content pane.
        frame.setContentPane(demo.createPane());

        frame.setPreferredSize(new Dimension(800, 600));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * <p>
     * Schedules a job for the event-dispatching thread. Creates and shows this application GUI.
     * </p>
     *
     * @param args the list command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
