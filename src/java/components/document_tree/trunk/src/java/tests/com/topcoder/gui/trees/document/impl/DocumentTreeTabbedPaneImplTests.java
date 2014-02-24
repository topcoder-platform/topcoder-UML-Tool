/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeEventListener;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.gui.trees.document.TestHelper;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeTabbedPaneImpl.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class DocumentTreeTabbedPaneImplTests extends TestCase {
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
     * The DocumentTreeNode array for testing.
     * </p>
     */
    private DocumentTreeNode[] nodes;

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
        super.setUp();
        TestHelper.loadConfigurations();

        node = new DocumentTreeNode("tree");
        nodes = new DocumentTreeNode[] {node};

        manager = TestHelper.createUMLModelManager();
        tabbedPane = new DocumentTreeTabbedPaneImpl(manager, TestHelper.NAMESPACE);
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
        nodes = null;
        node = null;

        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeTabbedPaneImplTests.class);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreeTabbedPaneImpl instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DocumentTreeTabbedPaneImpl instance.", tabbedPane);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullModelManager() {
        try {
            new DocumentTreeTabbedPaneImpl(null, TestHelper.NAMESPACE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is unknown and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_UnknownNamespace() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "UnknownNamespace");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is missing and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_NamespaceMissing() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "namespace_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_NamespaceEmpty() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "namespace_empty");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is invalid and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_NamespaceInvalid() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "namespace_invlalid");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tree cell renderer is missing and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_TreeCellRendererMissing() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "tree_cell_renderer_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tree cell renderer is empty and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_TreeCellRendererEmpty() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "tree_cell_renderer_empty");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when tree cell renderer is invalid and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_TreeCellRendererInvalid() {
        try {
            new DocumentTreeTabbedPaneImpl(manager, "tree_cell_renderer_invalid");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException iae) {
            //good
        }
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
        BaseDocumentTreeView view = (BaseDocumentTreeView) treePane.getCurrentView();

        Diagram classDiagram = manager.getDiagrams().get(1);
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        DefaultMutableTreeNode classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(0).getChildAt(0);

        GraphNode newGraphNode = new GraphNode();
        newGraphNode.setSemanticModel(TestHelper.createUml1SemanticModelBridge("NewNode"));
        classDiagram.addContained(newGraphNode);

        node = new DocumentTreeNode(newGraphNode);

        tabbedPane.addTreeNode(node);

        assertTrue("Failed to add the tree node correctly.", view.documentNodeToTreeNodeMap.containsKey(node));

        MutableTreeNode newNode = view.documentNodeToTreeNodeMap.get(node);

        assertSame("Failed to add the tree node correctly.", classDiagramNode, newNode.getParent());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#addTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddTreeNode_NullTreeNode() {
        try {
            tabbedPane.addTreeNode(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
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
        DefaultMutableTreeNode classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(0).getChildAt(0);
        DefaultMutableTreeNode useCaseDiagramNode = (DefaultMutableTreeNode) root.getChildAt(1).getChildAt(0);

        DiagramElement child = useCaseDiagram.getContaineds().get(0);
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) useCaseDiagramNode.getChildAt(0);

        // update the namespace of the child element
        useCaseDiagram.removeContained(child);
        classDiagram.addContained(child);

        view.updateTreeNode((DocumentTreeNode) childNode.getUserObject());

        TreeNode parentNode = childNode.getParent();

        // verify it is removed from the use case diagram node and added to the class diagram node
        assertNotSame("Failed to update the node.", useCaseDiagramNode, parentNode);
        assertSame("Failed to update the node.", classDiagramNode, parentNode);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#updateTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testUpdateTreeNode_NullTreeNode() {
        try {
            tabbedPane.updateTreeNode(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
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

        view.removeTreeNode(node);

        int newChildCount = classDiagramNode.getChildCount();

        assertEquals("Failed to remove the tree node correctly.", oldChildCount - 1, newChildCount);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#removeTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveTreeNode_NullTreeNode() {
        try {
            tabbedPane.removeTreeNode(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
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
        tabbedPane.updateTree();
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

            tabbedPane.setSelectedTreeNodes(new DocumentTreeNode[] {rootNode});

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
     * Tests DocumentTreeTabbedPaneImpl#setSelectedTreeNodes(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetSelectedTreeNodes_NullSelectedTreeNodes() {
        try {
            tabbedPane.setSelectedTreeNodes(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#setSelectedTreeNodes(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes contains null element and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testSetSelectedTreeNodes_NullInSelectedTreeNodes() {
        nodes = new DocumentTreeNode[] {node, null};
        try {
            tabbedPane.setSelectedTreeNodes(nodes);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getTabbedPane() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getTabbedPane() is correct.
     * </p>
     */
    public void testGetTabbedPane() {
        assertNotNull("Failed to get the tabbed pane correctly.", tabbedPane.getTabbedPane());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getModelManager() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getModelManager() is correct.
     * </p>
     */
    public void testGetModelManager() {
        assertSame("Failed to get the model manager correctly.", manager, tabbedPane.getModelManager());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getTreeCellRenderer() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getTreeCellRenderer() is correct.
     * </p>
     */
    public void testGetTreeCellRenderer() {
        assertEquals("Failed to set the tree cell renderer.", IconTreeCellRenderer.class,
            tabbedPane.getTreeCellRenderer().getClass());
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
        assertNotNull("Failed to create new panel correctly.", tabbedPane.createNewPanel());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getCurrentPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getCurrentPanel() is correct.
     * </p>
     */
    public void testGetCurrentPanel() {
        assertNotNull("Failed to get the current panel correctly.", tabbedPane.getCurrentPanel());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getCurrentPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getCurrentPanel() is correct.
     * </p>
     */
    public void testGetCurrentPanel2() {
        tabbedPane.createNewPanel();

        JFrame frame = new JFrame();
        JPanel main = new JPanel();
        main.add(tabbedPane.getTabbedPane());

        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

        try {
            assertNotNull("Failed to get the current panel correctly.", tabbedPane.getCurrentPanel());
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#setCurrentPanel(DocumentTreePanel) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#setCurrentPanel(DocumentTreePanel) is correct.
     * </p>
     */
    public void testSetCurrentPanel() {
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

            assertSame("Failed to set the current panel correctly.", panel1, tabbedPane.getCurrentPanel());
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#setCurrentPanel(DocumentTreePanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when panel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetCurrentPanel_NullPanel() {
        try {
            tabbedPane.setCurrentPanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
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
        tabbedPane.removePanel(panel);

        assertEquals("Failed to remove the panel correctly.", 1, tabbedPane.getTabbedPane().getTabCount());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#removePanel(DocumentTreePanel) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when panel is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemovePanel_NullPanel() {
        try {
            tabbedPane.removePanel(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#addDocumentTreeEventListener(DocumentTreeEventListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#addDocumentTreeEventListener(DocumentTreeEventListener) is correct.
     * </p>
     */
    public void testAddDocumentTreeEventListener() {
        DocumentTreeEventListener listener = new SimpleDocumentTreeEventListener();
        tabbedPane.addDocumentTreeEventListener(listener);

        assertEquals("Expected the length of the listeners is one.", 1,
            tabbedPane.getAllDocumentTreeEventListeners().length);
        assertEquals("Failed to add the listener correctly.", listener,
            tabbedPane.getAllDocumentTreeEventListeners()[0]);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#addDocumentTreeEventListener(DocumentTreeEventListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddDocumentTreeEventListener_NullListener() {
        try {
            tabbedPane.addDocumentTreeEventListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#removeDocumentTreeEventListener(DocumentTreeEventListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#removeDocumentTreeEventListener(DocumentTreeEventListener) is correct.
     * </p>
     */
    public void testRemoveDocumentTreeEventListener() {
        DocumentTreeEventListener listener = new SimpleDocumentTreeEventListener();
        tabbedPane.addDocumentTreeEventListener(listener);
        tabbedPane.removeDocumentTreeEventListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
            tabbedPane.getAllDocumentTreeEventListeners().length);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#removeDocumentTreeEventListener(DocumentTreeEventListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveDocumentTreeEventListener_NullListener() {
        try {
            tabbedPane.removeDocumentTreeEventListener(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#getAllDocumentTreeEventListeners() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#getAllDocumentTreeEventListeners() is correct.
     * </p>
     */
    public void testGetAllDocumentTreeEventListeners() {
        DocumentTreeEventListener listener = new SimpleDocumentTreeEventListener();
        tabbedPane.addDocumentTreeEventListener(listener);

        assertEquals("Expected the length of the listeners is one.", 1,
            tabbedPane.getAllDocumentTreeEventListeners().length);
        assertEquals("Failed to get the listeners correctly.", listener,
            tabbedPane.getAllDocumentTreeEventListeners()[0]);
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#fireSelectionChangedEvent(SelectionChangedEvent) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#fireSelectionChangedEvent(SelectionChangedEvent) is correct.
     * </p>
     */
    public void testFireSelectionChangedEvent() {
        SimpleDocumentTreeEventListener listener = new SimpleDocumentTreeEventListener();
        SelectionChangedEvent event = new SelectionChangedEvent(nodes, new boolean[] {true});

        tabbedPane.addDocumentTreeEventListener(listener);
        tabbedPane.fireSelectionChangedEvent(event);

        assertSame("Failed to fire the change event correctly.", event, listener.getLastSelectionEvent());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#fireSelectionChangedEvent(SelectionChangedEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFireSelectionChangedEvent_NullEvent() {
        try {
            tabbedPane.fireSelectionChangedEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#fireNameChangedEvent(NameChangedEvent) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeTabbedPaneImpl#fireNameChangedEvent(NameChangedEvent) is correct.
     * </p>
     */
    public void testFireNameChangedEvent() {
        SimpleDocumentTreeEventListener listener = new SimpleDocumentTreeEventListener();
        NameChangedEvent event = new NameChangedEvent(node, "newName");

        tabbedPane.addDocumentTreeEventListener(listener);
        tabbedPane.fireNameChangedEvent(event);

        assertSame("Failed to fire the change event correctly.", event, listener.getLastNameEvent());
    }

    /**
     * <p>
     * Tests DocumentTreeTabbedPaneImpl#fireNameChangedEvent(NameChangedEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects IllegalArgumentException.
     * </p>
     */
    public void testFireNameChangedEvent_NullEvent() {
        try {
            tabbedPane.fireNameChangedEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
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

        try {
            tabbedPane.setCurrentViewType(DocumentTreeViewType.CLASS_CENTRIC);
            assertEquals("Failed to get the current view type correctly.", DocumentTreeViewType.CLASS_CENTRIC,
                tabbedPane.getCurrentViewType());
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }


    /***************************************************************************************************
     * Below a number of tests added in version 1.1 to check new functionality.
     */

    /**
     * Tests constructor for new branch: create set of default simple tabs.
     */
    public void testConstructorNew() {
        tabbedPane = new DocumentTreeTabbedPaneImpl(manager, TestHelper.NAMESPACE_NEW);

        assertEquals("number of panels", 3, tabbedPane.getPanels().size());
        Set<DocumentTreeViewType> views = new HashSet<DocumentTreeViewType>();
        for (DocumentTreePanel panel : tabbedPane.getPanels()) {
            views.add(panel.getCurrentView().getViewType());
        }

        assertTrue("CLASS_CENTRIC view created", views.contains(DocumentTreeViewType.CLASS_CENTRIC));
        assertTrue("DIAGRAM_CENTRIC view created", views.contains(DocumentTreeViewType.DIAGRAM_CENTRIC));
        assertTrue("PACKAGE_CENTRIC view created", views.contains(DocumentTreeViewType.PACKAGE_CENTRIC));
    }

    /**
     * Tests constructor again. Configuration missed for both 1.0 and 1.1, default tabs must be created.
     */
    public void testConstructorDefault() {
        tabbedPane = new DocumentTreeTabbedPaneImpl(manager, "com.topcoder.gui.trees.document.impl_default");

        assertEquals("number of panels", 2, tabbedPane.getPanels().size());
        Set<DocumentTreeViewType> views = new HashSet<DocumentTreeViewType>();
        for (DocumentTreePanel panel : tabbedPane.getPanels()) {
            views.add(panel.getCurrentView().getViewType());
        }

        assertTrue("CLASS_CENTRIC view created", views.contains(DocumentTreeViewType.CLASS_CENTRIC));
        assertTrue("DIAGRAM_CENTRIC view created", views.contains(DocumentTreeViewType.DIAGRAM_CENTRIC));
    }

    /**
     * Tests constructor for bad configuration: String used as View.
     * DocumentTreeConfigurationException created.
     */
    public void testConstructorWrongViewType() {
        try {
            tabbedPane = new DocumentTreeTabbedPaneImpl(manager, "wrong_view_type");
            fail("DocumentTreeConfigurationException created.");
        } catch (DocumentTreeConfigurationException ex) {
            // success
        }
    }

    /**
     * DiagramCentricDocumentTreeView not configured.
     * DocumentTreeConfigurationException created.
     */
    public void testConstructorWrongViewConfig() {
        try {
            tabbedPane = new DocumentTreeTabbedPaneImpl(manager, "wrong_view_config");
            fail("DocumentTreeConfigurationException created.");
        } catch (DocumentTreeConfigurationException ex) {
            // success
        }
    }

    /**
     * Tests constructor for unknown namespace.
     * DocumentTreeConfigurationException created.
     */
    public void testConstructorMissedNamespace() {
        try {
            tabbedPane = new DocumentTreeTabbedPaneImpl(manager, "no_such_namespace");
            fail("DocumentTreeConfigurationException created.");
        } catch (DocumentTreeConfigurationException ex) {
            // success
        }
    }
}