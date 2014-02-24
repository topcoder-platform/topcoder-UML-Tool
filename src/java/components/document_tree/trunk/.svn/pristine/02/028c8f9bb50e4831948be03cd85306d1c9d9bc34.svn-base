/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.BaseDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for DocumentTreeTabbedPaneImpl.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class DocumentTreeTabbedPaneImplStressTests extends TestCase {
    /**
     * <p>
     * Represents the times of stress test.
     * </p>
     */
    private int TIMES = 1000;

    /**
     * <p>
     * The DocumentTreeTabbedPaneImpl instance for testing.
     * </p>
     */
    private DocumentTreeTabbedPaneImpl tabbedPane;

    /**
     * <p>
     * The UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * The DocumentTreeNode instance for testing.
     * </p>
     */
    private DocumentTreeNode node;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        StressTestHelper.loadConfigurations();

        node = new DocumentTreeNode("tree");

        manager = StressTestHelper.createUMLModelManager();
        tabbedPane = new DocumentTreeTabbedPaneImpl(manager, StressTestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        tabbedPane = null;
        manager = null;
        node = null;

        StressTestHelper.clearConfig();
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getSelectedTreeNodes() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getSelectedTreeNodes() is correct.
     * </p>
     */
    public void testGetSelectedTreeNodes() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            tabbedPane.getSelectedTreeNodes();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#getSelectedTreeNodes() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

        DocumentTreeNode[] selectedNodes = tabbedPane.getSelectedTreeNodes();
        assertEquals("Failed to get the selected tree nodes correctly.", 0, selectedNodes.length);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#addTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#addTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testAddTreeNode() {
        DocumentTreePanel treePane = tabbedPane.createNewPanel();
        treePane.setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);

        Diagram classDiagram = manager.getDiagrams().get(1);

        GraphNode newGraphNode = new GraphNode();
        newGraphNode.setSemanticModel(StressTestHelper.createUml1SemanticModelBridge("NewNode"));
        classDiagram.addContained(newGraphNode);

        node = new DocumentTreeNode(newGraphNode);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            tabbedPane.addTreeNode(node);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#addTreeNode(DocumentTreeNode) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#updateTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#updateTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testUpdateTreeNode() {
        DocumentTreePanel treePane = tabbedPane.createNewPanel();
        treePane.setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);
        BaseDocumentTreeView view = (BaseDocumentTreeView) treePane.getCurrentView();

        Diagram useCaseDiagram = manager.getDiagrams().get(0);
        Diagram classDiagram = manager.getDiagrams().get(1);
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        DefaultMutableTreeNode useCaseDiagramNode = (DefaultMutableTreeNode) root.getChildAt(0).getChildAt(0);

        DiagramElement child = useCaseDiagram.getContaineds().get(0);
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) useCaseDiagramNode.getChildAt(0);

        // update the namespace of the child element
        useCaseDiagram.removeContained(child);
        classDiagram.addContained(child);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            view.updateTreeNode((DocumentTreeNode) childNode.getUserObject());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#updateTreeNode"
                + "(DocumentTreeNode) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#removeTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#removeTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testRemoveTreeNode() {
        DocumentTreePanel treePane = tabbedPane.createNewPanel();
        treePane.setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);
        BaseDocumentTreeView view = (BaseDocumentTreeView) treePane.getCurrentView();

        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        DefaultMutableTreeNode classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(1).getChildAt(0);

        node = (DocumentTreeNode) ((DefaultMutableTreeNode) classDiagramNode.getChildAt(0)).getUserObject();

        int oldChildCount = classDiagramNode.getChildCount();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES / 10; i++) {
            view.removeTreeNode(node);
            treePane = tabbedPane.createNewPanel();
            treePane.setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);
            view = (BaseDocumentTreeView) treePane.getCurrentView();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#removeTreeNode"
                + "(DocumentTreeNode) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        int newChildCount = classDiagramNode.getChildCount();

        assertEquals("Failed to remove the tree node correctly.", oldChildCount - 1, newChildCount);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#updateTree() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#updateTree() is correct.
     * </p>
     */
    public void testUpdateTree() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            tabbedPane.updateTree();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#updateTree() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#setSelectedTreeNodes(DocumentTreeNode[]) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#setSelectedTreeNodes(DocumentTreeNode[]) is correct.
     * </p>
     */
    public void testSetSelectedTreeNodes() {
        DocumentTreePanel panel1 = tabbedPane.createNewPanel();

        JFrame frame = new JFrame();
        JPanel main = new JPanel();
        main.add(tabbedPane.getTabbedPane());

        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

        try {
            tabbedPane.setCurrentPanel(panel1);

            DocumentTreeView view1 = panel1.getCurrentView();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) view1.getTree().getModel().getRoot();

            DocumentTreeNode rootNode = (DocumentTreeNode) root.getUserObject();

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < TIMES; i++) {
                tabbedPane.setSelectedTreeNodes(new DocumentTreeNode[] {rootNode});
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#setSelectedTreeNodes"
                    + "(DocumentTreeNode[]) in "
                    + TIMES + " times takes " + (endTime - startTime) + "ms");

            DocumentTreeNode[] newNodes = tabbedPane.getSelectedTreeNodes();

            assertEquals("Failed to set the current selected tree node correctly.", 1, newNodes.length);
            assertSame("Failed to set the current selected tree node correctly.", rootNode, newNodes[0]);

        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#createNewPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#createNewPanel() is correct.
     * </p>
     */
    public void testCreateNewPanel() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES / 10; i++) {
            tabbedPane.createNewPanel();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#createNewPanel() in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
        assertNotNull("Failed to create new panel correctly.", tabbedPane.createNewPanel());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#removePanel(DocumentTreePanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#removePanel(DocumentTreePanel) is correct.
     * </p>
     */
    public void testRemovePanel() {
        DocumentTreePanel panel = tabbedPane.createNewPanel();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES / 10; i++) {
            tabbedPane.removePanel(panel);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#removePanel(DocumentTreePanel) in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
        assertNotNull("Failed to remove the panel correctly.", tabbedPane.getCurrentPanel());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getCurrentViewType() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getCurrentViewType() is correct.
     * </p>
     */
    public void testGetCurrentViewType() {
        tabbedPane.createNewPanel();

        JFrame frame = new JFrame();
        JPanel main = new JPanel();
        main.add(tabbedPane.getTabbedPane());

        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            tabbedPane.getCurrentViewType();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#getCurrentViewType() in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
        try {
            assertEquals("Failed to get the current view type correctly.", DocumentTreeViewType.DIAGRAM_CENTRIC,
                tabbedPane.getCurrentViewType());
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#setCurrentViewType(DocumentTreeViewType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#setCurrentViewType(DocumentTreeViewType) is correct.
     * </p>
     */
    public void testSetCurrentViewType() {
        tabbedPane.createNewPanel();

        JFrame frame = new JFrame();
        JPanel main = new JPanel();
        main.add(tabbedPane.getTabbedPane());

        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            tabbedPane.setCurrentViewType(DocumentTreeViewType.CLASS_CENTRIC);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreeTabbedPaneImpl#setCurrentViewType() in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
        try {
            tabbedPane.setCurrentViewType(DocumentTreeViewType.CLASS_CENTRIC);
            assertEquals("Failed to get the current view type correctly.", DocumentTreeViewType.CLASS_CENTRIC,
                tabbedPane.getCurrentViewType());
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

}