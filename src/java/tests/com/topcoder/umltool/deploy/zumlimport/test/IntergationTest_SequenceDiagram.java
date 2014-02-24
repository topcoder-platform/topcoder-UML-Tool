package com.topcoder.umltool.deploy.zumlimport.test;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.JMenuItemFinder;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Intergattion Tests of import zuml file for sequence diagram.
 * </p>
 *
 * @version 1.0
 */
public class IntergationTest_SequenceDiagram extends JFCTestCase {

    /**
     * <p>
     * Represents the uml tool mainFrame .
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * set up test suite.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        setHelper(new JFCTestHelper());
        try {
            UIManager.setLookAndFeel("com.topcoder.umltool.deploy.UMLToolLookAndFeel");
        } catch (Exception e) {
            System.err.println(e);
        }
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);

    }

    /**
     * <p>
     * clear up test
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        if (mainFrame != null) {
            mainFrame.dispose();
            mainFrame = null;
        }

        JFCTestHelper.cleanUp(this);

        super.tearDown();
    }

    /**
     * <p>
     * Intergation test1 .
     * </p>
     * <p>
     * Verify that all diagrams are displayed in tcuml tool when successfully open a zuml file.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test1() throws Exception {
        JMenuItemFinder finder = new JMenuItemFinder("File");
        JMenuItem fileMenu = (JMenuItem) finder.find(mainFrame, 0);
        fileMenu.doClick();
        finder.setText("Open");

        final JMenuItem openMenu = (JMenuItem) finder.find(mainFrame, 0);
        assertNotNull("Could not find the open Menu", openMenu);

        new Thread() {
            private boolean open = false;

            public void run() {
                if (!open) {
                    openMenu.doClick();
                    open = true;

                }

            }
        }.start();
        Thread.sleep(3000);
        Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        while (!(focusOwner instanceof JFileChooser)) {
            focusOwner = focusOwner.getParent();
        }
        JFileChooser fileChooser = (JFileChooser) focusOwner;

        fileChooser.setSelectedFile(new File("test_files/LDAP_Active_Directory_Interface.zuml"));
        fileChooser.approveSelection();
        Thread.sleep(20000);
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        DiagramView[] views = viewer.getCachedDiagramViews();
        assertEquals(views.length, 17);
    }

    /**
     * <p>
     * Intergation test2 .
     * </p>
     * <p>
     * Verify that when fail to import a zuml file, proper message should be given.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test2() throws Exception {
        JMenuItemFinder finder = new JMenuItemFinder("File");
        JMenuItem fileMenu = (JMenuItem) finder.find(mainFrame, 0);
        fileMenu.doClick();
        finder.setText("Open");

        final JMenuItem openMenu = (JMenuItem) finder.find(mainFrame, 0);
        assertNotNull("Could not find the open Menu", openMenu);

        new Thread() {
            private boolean open = false;

            public void run() {
                if (!open) {
                    openMenu.doClick();
                    open = true;

                }

            }
        }.start();
        Thread.sleep(3000);
        Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        while (!(focusOwner instanceof JFileChooser)) {
            focusOwner = focusOwner.getParent();
        }
        JFileChooser fileChooser = (JFileChooser) focusOwner;

        fileChooser.setSelectedFile(new File("test_files/wrong.zuml"));
        fileChooser.approveSelection();
        Thread.sleep(15000);
        focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        while (!(focusOwner instanceof JDialog)) {
            focusOwner = focusOwner.getParent();
        }
        JDialog dialog = (JDialog) focusOwner;
        assertEquals(dialog.getTitle(), "Loading error");

    }

}
