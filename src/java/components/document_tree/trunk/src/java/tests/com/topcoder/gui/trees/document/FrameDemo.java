/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This is a demo frame for using the functionality provided by this document tree component.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class FrameDemo extends JFrame {
    /**
     * Namespace for config manager to use in this demo.
     * If you want to run old version of this demo, set value to TestHelper.NAMESPACE.
     */
    private static final String NAMESPACE = TestHelper.NAMESPACE_NEW;

    /**
     * <p>
     * The content panel of this frame.
     * </p>
     */
    private JPanel jContentPane;

    /**
     * <p>
     * The tree tabbed pane of this frame.
     * </p>
     */
    private DocumentTreeTabbedPaneImpl treeTabbedPane;

    /**
     * <p>
     * This is the default constructor.
     * </p>
     *
     * @throws Exception if any exception occurs
     */
    public FrameDemo() throws Exception {
        initialize();
    }

    /**
     * <p>
     * This method initializes the widgets in this frame.
     * </p>
     *
     * @throws Exception if any exception occurs
     */
    public void initialize() throws Exception {
        this.setContentPane(getJContentPane());
        this.setTitle("Frame Demo");
    }

    /**
     * <p>
     * This method initializes jContentPane.
     * </p>
     *
     * @return the content panel for this frame.
     *
     * @throws Exception if any exception occurs
     */
    public JPanel getJContentPane() throws Exception {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());

            treeTabbedPane = new DocumentTreeTabbedPaneImpl(TestHelper.createUMLModelManager(), NAMESPACE);

            DocumentTreePanel treePanel = treeTabbedPane.getCurrentPanel();
            for (DocumentTreeView view : treePanel.getAllViews()) {
                view.getTree().addMouseListener(new DragMouseAdapter());
            }
            treeTabbedPane.addDocumentTreeEventListener(new DocumentTreeEventListenerImpl());

            jContentPane.add(new JScrollPane(treeTabbedPane.getTabbedPane()), BorderLayout.CENTER);
        }

        return jContentPane;
    }

    /**
     * <p>
     * This class extends MouseAdapter class and is used for DnD demonstration.
     * </p>
     *
     * @author biotrail
     * @version 1.0
     */
    private class DragMouseAdapter extends MouseAdapter {
        /**
         * <p>
         * Handles the mouse pressed event.
         * </p>
         *
         * @param e the mouse event.
         */
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }

    /**
     * <p>
     * This class implements DocumentTreeEventListener interface and is used for tree event handling demonstration.
     * </p>
     *
     * @author biotrail
     * @version 1.0
     */
    private class DocumentTreeEventListenerImpl implements DocumentTreeEventListener {
        /**
         * <p>
         * This method is called to indicate to the listener that the selection of nodes has changed.
         * </p>
         *
         * @param event The event denoting the selection.
         */
        public void treeNodeSelectionChanged(SelectionChangedEvent event) {
            System.out.println("Received SelectionChangedEvent : selected nodes are "
                + Arrays.asList(event.getSelectedTreeNodes()));
        }

        /**
         * <p>
         * This method is called to indicate to the listener that the name of a node has changed.
         * </p>
         *
         * @param event The event denoting the change of name.
         */
        public void treeNodeNameChanged(NameChangedEvent event) {
            System.out.println("Received NameChangedEvent : The tree node is [" + event.getTreeNode()
                + "], The new name is [" + event.getNewName() + "].");
        }

        /**
         * <p>
         * This method is called to indicate to the listener that the view type has changed.
         * </p>
         *
         * @param event The event denoting the change of view type. Will not be null.
         *
         * @throws IllegalArgumentException If event is null
         */
        public void treeViewChanged(ViewChangedEvent event) {
            System.out.println("Received Tree View Changed Event : " + event);
        }
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     *
     * @throws Exception to JUnit
     */
    public static void main(String[] args) throws Exception {
        System.out.println("start demo...");
        TestHelper.loadConfigurations();

        FrameDemo frameDemo = new FrameDemo();

        frameDemo.addWindowListener(new WindowAdapter() {
            /**
             * <p>
             * This method handles the situation when the frame is closing.
             * </p>
             *
             * <p>
             * The namespaces are cleared in this method.
             * </p>
             *
             * @param event a window event instance
             */
            public void windowClosing(WindowEvent event) {
                super.windowClosed(event);

                try {
                    TestHelper.clearConfig();
                } catch (UnknownNamespaceException e) {
                    // ignore
                }
            }

        });

        frameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDemo.setSize(new Dimension(500, 500));
        frameDemo.setVisible(true);
    }
}
