/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package driver;

import com.topcoder.gui.panels.documentation.DocumentationPanel;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.event.DemoDocumentationListener;
import com.topcoder.gui.panels.documentation.event.DemoTagListener;

import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * <p>
 * Demo class. Only used in demo.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class PanelDriver implements ActionListener {
   /**
     * <p>
     * Specify the look and feel to use.  Valid values:
     * null (use the default), "Metal", "System", "Motif", "GTK+"
     * </p>
     */
    private static final String LOOKANDFEEL = "System";

    /**
     * <p>
     * Main panel.
     * </p>
     */
    private JPanel mainPane = new JPanel();

    /**
     * <p>
     * <code>DocumentationPanel</code>.
     * </p>
     */
    private DocumentationPanel bottom;

    /**
     * <p>
     * Top panel contains buttons.
     * </p>
     */
    private JPanel top;

    /**
     * Creates a new PanelDriver object.
     */
    public PanelDriver() {
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));

        top = new JPanel();

        top.add(makeButton("Hide Tag Panel", false));
        top.add(makeButton("Show Tag Panel", false));
        top.add(makeButton("Hide whole panel", false));
        top.add(makeButton("Show whole panel", false));
        top.add(makeButton("Set Operation target", true));
        top.add(makeButton("Set Class target", true));

        try {
            bottom = new DocumentationPanel("demo_docPanelNamespace");
        } catch (DocumentationPanelConfigurationException e) {
            System.err.println("Can not initialize Documentation Panel");
            e.printStackTrace();
        }

        //Attach listeners
        bottom.addDocumentationListener(new DemoDocumentationListener());
        bottom.addTagListener(new DemoTagListener());

        mainPane.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, top, bottom));
        mainPane.add(Box.createGlue());
    }

    /**
     * <p>
     * Create buttons.
     * </p>
     *
     * @param name button name
     * @param enable whether enabled
     *
     * @return <code>JButton</code>
     */
    public JButton makeButton(String name, boolean enable) {
        JButton ret = new JButton(name);
        ret.setActionCommand(name);
        ret.addActionListener(this);
        ret.setEnabled(enable);

        return ret;
    }

    /**
     * <p>
     * Action performed listener for buttons.
     * </p>
     *
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        String type = e.getActionCommand();

        if ("Hide Tag Panel".equals(type)) {
            bottom.showTagEditor(false);
        } else if ("Show Tag Panel".equals(type)) {
            bottom.showTagEditor(true);
        } else if ("Hide whole panel".equals(type)) {
            bottom.showWholeEditor(false);
        } else if ("Show whole panel".equals(type)) {
            bottom.showWholeEditor(true);
        } else if ("Set Operation target".equals(type)) {
            bottom.setTarget(new OperationImpl());
            enableButtons();
        } else if ("Set Class target".equals(type)) {
            bottom.setTarget(new ClassImpl());
            enableButtons();
        }
    }

    /**
     * <p>
     * Enable buttons.
     * </p>
     */
    private void enableButtons() {
        for (int i = 0; i < 4; i++) {
            top.getComponent(i).setEnabled(true);
        }
    }

    /**
     * <p>
     * Create the GUI and show it.  For thread safety, this method
     * should be invoked from the event-dispatching thread.
     * </p>
     */
    private static void createAndShowGUI() {
        //Set the look and feel.
        initLookAndFeel();

        //Create and set up the window.
        JFrame frame = new JFrame("Documentation Panel Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        PanelDriver driver = new PanelDriver();
        driver.mainPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(driver.mainPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * <p>
     * Initialize look and feel.
     * </p>
     */
    private static void initLookAndFeel() {
        String lookAndFeel = null;

        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("Metal")) {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (LOOKANDFEEL.equals("GTK+")) { //new in 1.4.2
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else {
                System.err.println(
                    "Unexpected value of LOOKANDFEEL specified: " + LOOKANDFEEL);
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (ClassNotFoundException e) {
                System.err.println(
                    "Couldn't find class for specified look and feel:"
                    + lookAndFeel);
                System.err.println(
                    "Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                    + lookAndFeel + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                    + lookAndFeel + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }

    /**
     * <p>
     * Main method.
     * </p>
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
