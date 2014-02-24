/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * <p>
 * A simple demo for Closable Tabbed Pane component. This demo will represent a Text Editor using this pane.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextEditor implements ClosableTabbedPaneEventHandler, DocumentListener {
    /** Declare all necessary widgets, the main JFrame, menu bars etc. */
    private JFrame frame = new JFrame("Hello");

    /** Declare the closable tabbed pane. */
    private ClosableTabbedPane tabbedPane;

    /** The currently open files. */
    private List<String> filenames = new ArrayList<String>();

    /** For each tab, whether the contents of the tab have been modified. */
    private List<Boolean> modified = new ArrayList<Boolean>();

    /**
     * The constructor of this editor.
     */
    public TextEditor() {
        // Initialize all widgets

        /*
         * Create and add the closable tabbed pane, add a listener to it. We perform programmatic configuration. We
         * could also use namespace properties as shown in section 4.2
         */

        tabbedPane = new ClosableTabbedPane(JTabbedPane.BOTTOM);

        // We-use the different close images for 4 close button states
        tabbedPane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit()
            .createImage("test_files/1.gif"));
        tabbedPane.setCloseButtonImage(CloseButtonState.ACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
            .createImage("test_files/2.gif"));
        tabbedPane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_HOVERED, Toolkit.getDefaultToolkit()
            .createImage("test_files/3.gif"));
        tabbedPane.setCloseButtonImage(CloseButtonState.INACTIVE_TAB_NOT_HOVERED, Toolkit.getDefaultToolkit()
            .createImage("test_files/4.gif"));

        // A rounded, blue, 5-pixel border
        tabbedPane.setInteriorBorder(new LineBorder(Color.BLUE, 5, true));

        tabbedPane.setCloseButtonPadding(new Dimension(0, 5));

        /* When an active tab closes, we want to switch to the last tab which was active */
        // tabbedPane.setActiveTabSelector(new PreviousActiveTabSelector());
        // Add an event handler and add the pane to the frame
        tabbedPane.addClosableTabbedPaneEventHandler(this);
        frame.getContentPane().add(tabbedPane);

        // Display the frame etc.
        frame.setSize(1000, 500);
        frame.setVisible(true);

        openNewFile("test_files/a.txt");
        openNewFile("test_files/b.txt");
        openNewFile("test_files/c.txt");
        openNewFile("test_files/d.txt");
    }

    /**
     * The entrance to this demo.
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        // Simply create the editor
        new TextEditor();
    }

    /**
     * This method should be called by the menu-item handler for the open file menu item.
     * @param filename
     *            name of the file to open
     */
    private void openNewFile(String filename) {
        try {
            // If the file is already open, simply activate the tab
            int index = filenames.indexOf(filename);
            if (index != -1) {
                tabbedPane.setSelectedIndex(index);
                return;
            }

            // This string will hold the contents of the file
            String text = "";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while (true) {
                String str = br.readLine();
                if (str == null) {
                    break;
                }
                text += str + "\n";
            }
            br.close();

            // Create a text area with the content
            JTextArea area = new JTextArea(text, 10, 20);

            // Add a listener to check for modifications
            area.getDocument().addDocumentListener(this);

            // Add the text area as a tab
            tabbedPane.insertTab(filename, null, area, null, tabbedPane.getTabCount());

            // Add the filename and an entry for modified
            filenames.add(filename);
            modified.add(Boolean.FALSE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The update event is caught here, and we can mark the text to be modified - should be saved later.
     * @param e
     *            the event
     */
    public void changedUpdate(DocumentEvent e) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (((JTextArea) tabbedPane.getComponentAt(i)).getDocument() == e.getDocument()) {
                modified.set(i, Boolean.TRUE);
            }
        }
    }

    /**
     * Does same thing as changedUpdate.
     * @param e
     *            the event
     */
    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    /**
     * Does same thing as changedUpdate.
     * @param e
     *            the event
     */
    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    /**
     * Does nothing special when tab is added.
     * @param e
     *            the event
     */
    public void tabAdded(ClosableTabbedPaneEvent e) {
    }

    /**
     * When tabs are closing we ask the user if he wishes to save any unsaved files. The user can also cancel the
     * operation (using a standard yes/no/cancel dialog).
     * @param e
     *            the events
     * @return if each event is handled properly
     */
    public boolean[] tabsClosing(ClosableTabbedPaneEvent[] e) {
        boolean[] result = new boolean[e.length];
        for (int i = 0; i < e.length; i++) {
            // If the file has been modified
            if (modified.get(e[i].getTabIndex())) {
                // Show a confirm dialog
                String message = "Do you want to save " + filenames.get(e[i].getTabIndex()) + "?";
                int option = JOptionPane.showConfirmDialog(tabbedPane, message);

                if (option == JOptionPane.YES_OPTION) {
                    // TODO Save the file

                    result[i] = true;
                } else if (option == JOptionPane.NO_OPTION) {
                    result[i] = true;
                }
            } else {
                // Comes here if the file is not modified
                result[i] = true;
            }
        }
        return result;
    }

    /**
     * When the tabs are closed, we remove the entries from the filenames and modified lists.
     * @param e
     *            the events
     */
    public void tabsClosed(ClosableTabbedPaneEvent[] e) {
        // First store the indices
        int[] index = new int[e.length];
        for (int i = 0; i < e.length; i++) {
            index[i] = e[i].getTabIndex();
        }

        // Sort the array, so we can remove the entries from last to first
        Arrays.sort(index);

        // Remove the entries
        for (int i = e.length - 1; i >= 0; i--) {
            filenames.remove(index[i]);
            modified.remove(index[i]);
        }
    }
}