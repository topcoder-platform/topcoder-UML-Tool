package com.topcoder.umltool.deploy.zumlimport.test;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.config.ConfigManager;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.JMenuItemFinder;

/**
 * <p>
 * GUI Tests of import zuml file for sequence diagram.
 * </p>
 *
 * @version 1.0
 */
public class FunctionalTests_SequenceDiagram2 extends JFCTestCase {

    /**
     * <p>
     * Represents the uml tool mainFrame .
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Represents the namespace of config file.
     * </p>
     */
    private static String NS = "com.topcoder.umltool.deploy.zumlimport.test";

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
        ConfigManager cm = ConfigManager.getInstance();
        cm.add("config.xml");
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
        ConfigManager cm = ConfigManager.getInstance();
        cm.removeNamespace(NS);
        System.gc();
        super.tearDown();
    }

    /**
     * <p>
     * Handle sequence diagram's Namespace.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test10() throws Exception {
        verifyErrorFile("test10_file");

    }

    /**
     * <p>
     * Handle synchronous message's Accessed Attribute.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test36() throws Exception {

        verifyErrorFile("test36_file");
    }

    /**
     * <p>
     * Handle synchronous message's Accessed Operation.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test37() throws Exception {

        verifyErrorFile("test37_file");
    }

    /**
     * <p>
     * Handle asynchronous message's Accessed Attribute.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test49() throws Exception {

        verifyErrorFile("test49_file");
    }

    /**
     * <p>
     * Handle asynchronous message's Accessed Operation.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test50() throws Exception {

        verifyErrorFile("test49_file");
    }

    /**
     * <p>
     * Handle create message's Accessed Attribute.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test62() throws Exception {

        verifyErrorFile("test62_file");
    }

    /**
     * <p>
     * Handle create message's Accessed Operation.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test63() throws Exception {

        verifyErrorFile("test63_file");
    }

    /**
     * <p>
     * Handle destroy message..
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test108() throws Exception {

        verifyErrorFile("test108_file");
    }

    /**
     * <p>
     * Handle lost message..
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test109() throws Exception {

        verifyErrorFile("test109_file");
    }

    /**
     * <p>
     * Handle found message..
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test110() throws Exception {

        verifyErrorFile("test110_file");
    }

    /**
     * <p>
     * Handle asynchronous message from lifeline to gate.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test111() throws Exception {

        verifyErrorFile("test111_file");
    }

    /**
     * <p>
     * Handle asynchronous message from gate to lifeline.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void test112() throws Exception {

        verifyErrorFile("test112_file");
    }

    /**
     * <p>
     * Open a given file and verify the error message.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    private void verifyErrorFile(String file_propertyname) throws Exception {
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
        Thread.sleep(5000);
        Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        while (!(focusOwner instanceof JFileChooser)) {
            focusOwner = focusOwner.getParent();
        }
        JFileChooser fileChooser = (JFileChooser) focusOwner;

        fileChooser.setSelectedFile(new File(getProperty(file_propertyname)));
        fileChooser.approveSelection();
        Thread.sleep(10000);
        focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        while (!(focusOwner instanceof JDialog)) {
            focusOwner = focusOwner.getParent();
        }
        JDialog dialog = (JDialog) focusOwner;
        assertEquals(dialog.getTitle(), "Loading error");
    }

    /**
     * <p>
     * get the property as string from config file.
     * </p>
     *
     *@param key
     *            the property name
     *@return the property as string
     * @throws Exception
     *             to JUnit
     */
    private String getProperty(String key) throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        return (String) cm.getProperty(NS, key);
    }

}
